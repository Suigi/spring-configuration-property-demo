package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class MyClass {

    private final MyConfiguration config;

    @Autowired
    public MyClass(MyConfiguration config) {
        this.config = config;
    }

    public int theAnswer() {
        return config.getAnswer();
    }
}

