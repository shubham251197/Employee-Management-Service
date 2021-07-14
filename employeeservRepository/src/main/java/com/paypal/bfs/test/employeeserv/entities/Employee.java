package com.paypal.bfs.test.employeeserv.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.internal.ws.developer.Serialization;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity()
@Table( name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull(message = "First Name is required.")
    private String first_name;

    @NotNull(message = "Last Name is required.")
    private String last_name;

    @NotNull(message = "Date of Birth is required.")
    private Date dateOfBirth;

    @NotNull(message = "Address Line 1 is required.")
    private String addressLine1;

    private String addressLine2;

    @NotNull(message = "City is required.")

    private String city;

    @NotNull(message = "State is required.")
    private String state;

    @NotNull(message = "Country is required.")
    private String country;

    @NotNull(message = "Zip Code is required.")
    private String zipCode;


    public Employee(){

    }

    public Employee(@NotNull String first_name, @NotNull String last_name, @NotNull Date dateOfBirth, @NotNull String addressLine1, String addressLine2, @NotNull String city, @NotNull String state, @NotNull String country, @NotNull String zipCode) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dateOfBirth = dateOfBirth;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDateOfBirth(String date) throws ParseException {
        this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }
}
