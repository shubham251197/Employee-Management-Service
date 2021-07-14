package com.paypal.bfs.test.employeeserv.api.Utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.paypal.bfs.test.employeeserv.entities.Employee;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Set;

@Component
public class ValidatorService {

    private JsonSchema schema;
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() throws IOException {
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);
        Resource schemaResource = new ClassPathResource("v1/schema/employee.json");
        schema = schemaFactory.getSchema(schemaResource.getInputStream());
        objectMapper = new ObjectMapper();
    }

    private void validateObject(String employee) throws IOException,ValidationException {
        JsonNode json = new ObjectMapper().readTree(employee);
        Set<ValidationMessage> validationResult = schema.validate(json);
        validationResult.forEach(validationMessage -> {
            throw new ValidationException(HttpStatus.BAD_REQUEST,validationMessage.getMessage());
        });
    }

    public Employee constructEmployee(Object employee) {
        try {
            String employeeBody = objectMapper.writeValueAsString(employee);
            validateObject(employeeBody);
            return objectMapper.readValue(employeeBody,Employee.class);
        }catch (ValidationException validationException) {
            throw validationException;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw new ValidationException(HttpStatus.INTERNAL_SERVER_ERROR,"Unexpected Error while constructing Employee");
        }
    }

    public int getId(String id) throws ValidationException{
        try {
            return Integer.parseInt(id);
        }catch (Exception e){
            throw new ValidationException(HttpStatus.BAD_REQUEST,"Invalid Employee Id");
        }
    }
}
