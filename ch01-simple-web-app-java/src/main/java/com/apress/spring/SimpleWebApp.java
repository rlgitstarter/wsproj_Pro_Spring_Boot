package com.apress.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* Entry point for a Spring Boot application in Java:
* SimpleWebApp is using a @SpringBootApplication annotation and the SpringApplication singleton class
* in the main method that will execute the application.
* */
@SpringBootApplication
public class SimpleWebApp {
    public static void main(String[] args) {
        SpringApplication.run(SimpleWebApp.class, args);
    }
}
