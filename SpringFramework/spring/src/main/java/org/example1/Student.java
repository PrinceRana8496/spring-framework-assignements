package org.example1;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int id = 101;
    private String name = "Prince Rana";

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
