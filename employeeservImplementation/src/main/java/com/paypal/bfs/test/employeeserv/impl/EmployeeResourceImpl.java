package com.paypal.bfs.test.employeeserv.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.paypal.bfs.test.employeeserv.DatabaseException;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.Utilities.ValidationException;
import com.paypal.bfs.test.employeeserv.api.Utilities.ValidatorService;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeResponse;
import com.paypal.bfs.test.employeeserv.entities.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    private EmployeeDatabaseService databaseService;
    private ValidatorService validatorService;

    @Autowired
    public EmployeeResourceImpl(EmployeeDatabaseService databaseService,ValidatorService validatorService){
        this.databaseService = databaseService;
        this.validatorService = validatorService;
    }

    @Override
    public ResponseEntity<EmployeeResponse> employeeGetById(String id) throws ValidationException, DatabaseException {
        int employeeId = validatorService.getId(id);
        Optional<Employee> employee = databaseService.getEmployee(employeeId);
        if(employee.isPresent()) {
            return new ResponseEntity<>(new EmployeeResponse(200, "Employee Found.", employee.get()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new EmployeeResponse(404, "Employee Not Found."), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<EmployeeResponse> createEmployee(Object employeeDTO) throws ValidationException,DatabaseException {
        Employee employee = this.validatorService.constructEmployee(employeeDTO);
        this.databaseService.saveEmployee(employee);
        return new ResponseEntity<>(new EmployeeResponse(200,"Employee Added Successfully.", employee), HttpStatus.OK);
    }
}
