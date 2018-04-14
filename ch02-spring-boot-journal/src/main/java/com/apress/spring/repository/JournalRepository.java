package com.apress.spring.repository;

import com.apress.spring.domain_model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* persistence mechanism for the journal data:
* Use the Spring Data JPA technology by creating an interface and extending it from the JpaRepository interface
* */

public interface JournalRepository extends JpaRepository<Journal, Long> {

}
