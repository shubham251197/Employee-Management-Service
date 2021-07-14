package com.paypal.bfs.test.employeeserv;

import org.springframework.http.HttpStatus;

public class DatabaseException extends RuntimeException{

    private HttpStatus statusCode;
    private String message;

    public DatabaseException(HttpStatus statusCode,String message){
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
