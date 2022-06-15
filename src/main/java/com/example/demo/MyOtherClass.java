package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class MyOtherClass {

    @Autowired
    private MyConfiguration config;

    public int theAnswer() {
        return config.getAnswer();
    }
}

