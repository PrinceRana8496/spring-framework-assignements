package com.prince.Springdatajpa2.dto;


public class EmployeeBasicInfoDTO {
    private Long id;
    private String firstName;
    private int age;

    public EmployeeBasicInfoDTO(Long id, String firstName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
    }

    // Getters and Setters (or you can use Lombok)
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}
