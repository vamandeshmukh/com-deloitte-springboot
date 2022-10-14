package com.deloitte.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.springboot.demo.model.Employee;

@RestController
public class EmployeeController {

//	http://localhost:8082/emp

	@RequestMapping("/emp")
	public Employee getEmp() {
		Employee emp = new Employee(101, "Sonu", 90000);
		System.out.println(emp.toString());
		return emp;
	}

	// create other methods

}
