package com.paypal.bfs.test.employeeserv.api.model;

import com.paypal.bfs.test.employeeserv.entities.Employee;
import com.sun.xml.internal.ws.developer.Serialization;

@Serialization
public class EmployeeResponse {

    private int code;
    private String message;
    private Employee employee;

    public EmployeeResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public EmployeeResponse(int code, String message, Employee employee) {
        this.code = code;
        this.message = message;
        this.employee = employee;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
