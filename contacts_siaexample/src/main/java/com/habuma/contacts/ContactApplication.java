package com.habuma.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class ContactApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
    }
}
