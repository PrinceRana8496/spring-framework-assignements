package org.example1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickBeforeAfterTest {

    @BeforeEach
    public void setup()
    {
        System.out.println("Before");
    }
    @Test
    public void test1()
    {
        System.out.println("Task1 executed");
    }
    @Test
    public void test2()
    {
        System.out.println("Task2 executed");
    }
    @AfterEach
    public void teardown()
    {
        System.out.println("Terminated");
    }

}