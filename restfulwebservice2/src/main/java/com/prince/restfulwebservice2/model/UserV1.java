package com.prince.restfulwebservice2.model;

public class UserV1 {
    private int id;
    private String name;

    public UserV1() {}

    public UserV1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
