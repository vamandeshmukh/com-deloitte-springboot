package com.deloitte.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deloitte.springboot.demo.model.Employee;

@Service
public class EmployeeService {

	public Employee getEmployeeById(int employeeId) {
		System.out.println(employeeId);
		Employee emp = new Employee(101, "Sonu", 90000);
		return emp;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 90000));
		empList.add(new Employee(102, "Monu", 95000));
		empList.add(new Employee(103, "Tonu", 85000));
		System.out.println(empList.size());
		return empList;
	}

//	addEmployee()

//	updateEmployee()

//	deleteEmployee()

}
