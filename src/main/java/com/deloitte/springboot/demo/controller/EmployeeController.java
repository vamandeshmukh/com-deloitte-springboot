package com.deloitte.springboot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.springboot.demo.model.Employee;
import com.deloitte.springboot.demo.service.EmployeeService;

@RestController
public class EmployeeController {

//	EmployeeService empService = new EmployeeService();

	@Autowired
	EmployeeService empService;

//	http://localhost:8082/get-emp-by-id

	@GetMapping("/get-emp-by-id")
	public Employee getEmpById() {
		return empService.getEmployeeById(101);
	}

//	http://localhost:8082/emp-list

	@GetMapping("/emp-list")
	public List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 90000));
		empList.add(new Employee(102, "Monu", 95000));
		empList.add(new Employee(103, "Tonu", 85000));
		System.out.println(empList.size());
		return empList;
	}

	// create other methods

}
