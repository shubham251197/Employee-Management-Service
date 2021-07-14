package com.paypal.bfs.test.employeeserv.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeResponse;
import com.paypal.bfs.test.employeeserv.entities.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping( value = "/v1/bfs/employees/{id}", method = RequestMethod.GET)
    ResponseEntity<?> employeeGetById(@PathVariable("id") String id) throws JsonProcessingException;

    /**
     * Create an {@link Employee} resource by id.
     *
     * @return {@link EmployeeResponse} resource.
     */
    @RequestMapping( value = "/v1/bfs/employees", method = RequestMethod.POST)
    ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Object employee) throws IOException;
}
