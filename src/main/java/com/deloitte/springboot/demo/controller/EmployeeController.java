package com.deloitte.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.springboot.demo.model.Employee;
import com.deloitte.springboot.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.RequestBody;

// http://localhost:8082/swagger-ui/index.html

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;

//	http://localhost:8082/get-emp-by-id/101

	@GetMapping("/get-emp-by-id/{eid}")
	public Employee getEmpById(@PathVariable(name = "eid") int employeeId) {
		return empService.getEmployeeById(employeeId);
	}

//	http://localhost:8082/get-all-emps

	@GetMapping("/get-all-emps")
	public List<Employee> getAllEmps() {
		return empService.getAllEmployees();
	}

//	http://localhost:8082/add-emp 

	@PostMapping("/add-emp")
	public Employee addEmp(@RequestBody Employee employee) {
		System.out.println("addEmp " + employee.toString());
		return empService.addEmployee(employee);
	}

//	http://localhost:8082/update-emp 

	@PutMapping("/update-emp")
	public Employee updateEmp(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}

//	http://localhost:8082/delete-emp-by-id/101 

	@DeleteMapping("/delete-emp-by-id/{eid}")
	public Employee deleteEmpById(@PathVariable(name = "eid") int employeeId) {
		return empService.deleteEmployeeById(employeeId);
	}

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
