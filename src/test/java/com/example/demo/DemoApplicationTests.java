package com.example.demo;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class DemoApplicationTests {

    @Autowired
    private MyClass myClass;

    @Autowired MyConfiguration myConfiguration;

    @Test
    public void property_is_passed_into_ConfigurationProperties_class() {
        assertThat(myConfiguration.getAnswer())
           .isEqualTo(42);
    }

    @Test
    public void property_is_passed_into_bean_that_uses_ConfigurationProperties_class() {
        assertThat(myClass.theAnswer())
                .isEqualTo(42);
    }

    @Test
    public void property_is_not_injected_into_a_class_that_is_not_a_bean() {
        var myOtherClass = new MyOtherClass();

        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(myOtherClass::theAnswer);
    }

}
