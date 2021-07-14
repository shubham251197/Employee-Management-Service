package com.paypal.bfs.test.employeeserv.api.Utilities;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException{

    private HttpStatus statusCode;
    private String message;

    public ValidationException(HttpStatus statusCode,String message){
        super();
        this.message = message;
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
