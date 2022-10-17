package com.deloitte.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.springboot.demo.model.Employee;
import com.deloitte.springboot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public Employee getEmployeeById(int employeeId) {  
		System.out.println("getEmployeeById " + employeeId);
		Optional<Employee> empOptional = empRepository.findById(employeeId);
		Employee emp = empOptional.get();
		return emp;
	}

	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees");
		return empRepository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		System.out.println("addEmployee " + employee.toString());
		return empRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		System.out.println("updateEmployee " + employee.toString());
		return empRepository.save(employee);
	}

	public Employee deleteEmployeeById(int employeeId) {
		System.out.println("deleteEmployeeById " + employeeId);
		empRepository.deleteById(employeeId);
		return getEmployeeById(employeeId);
	}

	// addEmployee()

//	updateEmployee()

//	deleteEmployee()

}

//package com.deloitte.springboot.demo.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.deloitte.springboot.demo.model.Employee;
//
//@Service
//public class EmployeeService {
//
//	public Employee getEmployeeById(int employeeId) {
//		System.out.println(employeeId);
//		Employee emp = new Employee(101, "Sonu", 90000);
//		return emp;
//	}
//
//	public List<Employee> getAllEmployees() {
//		List<Employee> empList = new ArrayList<>();
//		empList.add(new Employee(101, "Sonu", 90000));
//		empList.add(new Employee(102, "Monu", 95000));
//		empList.add(new Employee(103, "Tonu", 85000));
//		System.out.println(empList.size());
//		return empList;
//	}
//
////	addEmployee()
//
////	updateEmployee()
//
////	deleteEmployee()
//
//}
