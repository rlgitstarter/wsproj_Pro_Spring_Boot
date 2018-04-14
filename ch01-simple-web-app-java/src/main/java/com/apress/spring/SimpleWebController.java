package com.apress.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Typical Spring MVC controller class, where you use the @RestController and the @RequestMapping annotations
 * to tell Spring to use the SimpleWebController class as a web controller
 * and to use the method greetings as an entry point for a HTTP request.
 */
@RestController
public class SimpleWebController {
    @RequestMapping("/")
    public String greetings() {
        return "<h1> Spring Boot Rocks in Java too! </h1>";
    }
}
