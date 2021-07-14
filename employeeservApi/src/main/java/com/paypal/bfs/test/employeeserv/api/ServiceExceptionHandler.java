package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.DatabaseException;
import com.paypal.bfs.test.employeeserv.api.Utilities.ValidationException;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(value = DatabaseException.class)
    protected ResponseEntity<EmployeeResponse> handlerDatabaseException(DatabaseException exception){
        return new ResponseEntity<>(new EmployeeResponse(exception.getStatusCode().value(), exception.getMessage()), exception.getStatusCode());
    }

    @ExceptionHandler(value = ValidationException.class)
    protected ResponseEntity<EmployeeResponse> handlerValidationException(ValidationException exception){
        return new ResponseEntity<>(new EmployeeResponse(exception.getStatusCode().value(), exception.getMessage()), exception.getStatusCode());
    }
}
