package com.deloitte.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.springboot.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	basic CRUD Ops -
	// no need to write any methods
	
	// findById();
	// findAll();
	// save();
	// save();
	// deleteById();
	
	
	
	
	

}
