package com.deloitte.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.springboot.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// repository provides methods for basic CRUD operations -
	// INSERT - save();
	// UPDATE - save();
	// DELETE - deleteById();
	// SELECT one - findById();
	// SELECT all - findAll();
	// No need to declare methods for these operations.

	// for other business specific requirements, methods need to be declared here.
	// read this doc for more -
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.core-concepts

}
