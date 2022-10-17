package com.deloitte.springboot.demo.controller;

import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping("/emp-list")
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
