package com.deloitte.springboot.demo.controller;

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

//	http://localhost:8082/get-alll-emps

	@GetMapping("/get-alll-emps")
	public List<Employee> getAllEmps() {
		System.out.println("get-all-emps");
		return empService.getAllEmployees();
	}

	// create other methods

//	addEmp() 

//	updateEmp()

//	deleteEmp()

}

//package com.deloitte.springboot.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.deloitte.springboot.demo.model.Employee;
//import com.deloitte.springboot.demo.service.EmployeeService;
//
//@RestController
//public class EmployeeController {
//
////	EmployeeService empService = new EmployeeService();
//
//	@Autowired
//	EmployeeService empService;
//
////	http://localhost:8082/get-emp-by-id
//
//	@GetMapping("/get-emp-by-id")
//	public Employee getEmpById() {
//		return empService.getEmployeeById(101);
//	}
//
////	http://localhost:8082/get-alll-emps
//
//	@GetMapping("/get-alll-emps")
//	public List<Employee> getAllEmps() {
//		return empService.getAllEmployees();
//	}
//
//	// create other methods
//
////	addEmp() 
//
////	updateEmp()
//
////	deleteEmp()
//
//}
