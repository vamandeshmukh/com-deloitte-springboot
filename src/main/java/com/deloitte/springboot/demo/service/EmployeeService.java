package com.deloitte.springboot.demo.service;

import org.springframework.stereotype.Service;

import com.deloitte.springboot.demo.model.Employee;

@Service
public class EmployeeService {

	public Employee getEmployeeById(int employeeId) {
		System.out.println(employeeId);
		Employee emp = new Employee(101, "Sonu", 90000);
		System.out.println(emp.toString());
		return emp;
	}

}
