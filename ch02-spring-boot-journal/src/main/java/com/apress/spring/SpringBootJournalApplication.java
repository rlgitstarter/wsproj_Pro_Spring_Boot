package com.apress.spring;

import com.apress.spring.domain_model.Journal;
import com.apress.spring.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJournalApplication {

    @Bean
    InitializingBean saveData(JournalRepository repo) {
        // Lambda: s. dazu JavaInsel I, InnerVsLambdaThis
        return() -> {
            // inject some data
            repo.save(new Journal("Get to know Spring Boot","01/01/2016","Today I will learn Spring Boot"));
            repo.save(new Journal("Simple Spring Boot Project","01/02/2016","I will do my first Spring Boot Project"));
            repo.save(new Journal("Spring Boot Reading","02/01/2016","Read more about Spring Boot"));
            repo.save(new Journal("Spring Boot in the Cloud","03/01/2016","Spring Boot using Cloud Foundry"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);
    }

}
