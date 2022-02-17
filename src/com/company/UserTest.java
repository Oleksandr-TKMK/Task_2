package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;


class UserTest {
    private int counter;
    private int counterAfter;
    private String status;
    private String name;
    private int level;
    private int levelAfter;
    private int experience;
    private int experienceAfter;
    private Stack<String> stack;
    private String[] array;
    User user;

    @BeforeEach
    void setUp(){

        counter = 5;
        counterAfter = 4;
        status = "Paid";
        name = "John_Doe";
        level = 6;
        levelAfter = 8;
        experience = 1055;
        experienceAfter = 55;
        array = new String[]{"John_Doe", "1055", "6", "Paid", "5"};
        stack = new Stack<>();
        for (String s : array) {
            stack.push(s);
        }
        user = new User(stack);
    }

    @Test
    void getName() {
        Assertions.assertEquals(name, user.getName());
    }

    @Test
    void getExperience() {
        Assertions.assertEquals(experience, user.getExperience());
    }

    @Test
    void getLevel() {
        Assertions.assertEquals(level, user.getLevel());
    }

    @Test
    void getStatus() {
        Assertions.assertEquals(status, user.getStatus());
    }

    @Test
    void getCounter() {
        Assertions.assertEquals(counter, user.getCounter());
    }

    @Test
    void taskFunction() {
        user.taskFunction();
        Assertions.assertEquals(experienceAfter, user.getExperience());
        Assertions.assertEquals(levelAfter, user.getLevel());
        Assertions.assertEquals(counterAfter, user.getCounter());
    }
}