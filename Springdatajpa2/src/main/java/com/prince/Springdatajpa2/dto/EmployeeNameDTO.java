package com.prince.Springdatajpa2.dto;

public class EmployeeNameDTO {
    private String firstName;
    private String lastName;

    public EmployeeNameDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
