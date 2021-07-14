package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.DatabaseException;
import com.paypal.bfs.test.employeeserv.entities.Employee;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLDataException;
import java.util.Optional;

@Service
public class EmployeeDatabaseService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDatabaseService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional( rollbackOn = DatabaseException.class)
    public void saveEmployee(Employee employee){
        try{
            this.employeeRepository.save(employee);
        }catch (Exception e){
            throw new DatabaseException(HttpStatus.INTERNAL_SERVER_ERROR,"Error Occur while persisting data");
        }
    }


    @Transactional( rollbackOn = DatabaseException.class)
    public Optional<Employee> getEmployee(int employeeId){
        try{
            return this.employeeRepository.findById(employeeId);
        }catch (Exception e){
            throw new DatabaseException(HttpStatus.INTERNAL_SERVER_ERROR,"Error Occur while fetching data");
        }
    }
}
