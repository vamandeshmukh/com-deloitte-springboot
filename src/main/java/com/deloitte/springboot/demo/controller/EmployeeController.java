package com.deloitte.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.springboot.demo.model.Employee;
import com.deloitte.springboot.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8082/swagger-ui/index.html

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;


//	@GetMapping("/get-emp-by-id/{eid}")
//	public Employee getEmpById(@PathVariable(name = "eid") int employeeId) {
//		return empService.getEmployeeById(employeeId);
//	}

//	http://localhost:8082/emp/get-emp-by-id/101

	@GetMapping("/get-emp-by-id/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int employeeId) {
		Employee emp = empService.getEmployeeById(employeeId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee with eid " + employeeId + " found successfuly.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, status);
		return response;
	}

////	http://localhost:8082/emp/get-emp-by-id/101
//	@GetMapping("/get-emp-by-first-name/{firstName}")


		//	http://localhost:8082/emp/get-all-emps

	@GetMapping("/get-all-emps")
	public List<Employee> getAllEmps() {
		return empService.getAllEmployees();
	}

//	http://localhost:8082/emp/add-emp 

	@PostMapping("/add-emp")
	public Employee addEmp(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}

//	http://localhost:8082/emp/update-emp 

	@PutMapping("/update-emp")
	public Employee updateEmp(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}

//	http://localhost:8082/emp/delete-emp-by-id/101 

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
