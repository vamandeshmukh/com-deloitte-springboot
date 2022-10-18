package com.deloitte.springboot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.springboot.demo.model.Employee;
import com.deloitte.springboot.demo.service.EmployeeService;

// http://localhost:8082/swagger-ui/index.html

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	// http://localhost:8082/emp/get-all-emps

	@GetMapping("/get-all-emps")
	public List<Employee> getAllEmps() {
		return empService.getAllEmployees();
	}

	// http://localhost:8082/emp/get-emp-by-id/101

//	@GetMapping("/get-emp-by-id/{eid}") // this is one style 
	@RequestMapping(path = "/get-emp-by-id/{eid}", method = RequestMethod.GET) // this is another style
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int employeeId) {
		Employee emp = empService.getEmployeeById(employeeId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee with eid " + employeeId + " found successfuly.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, status);
		return response;
	}

//	http://localhost:8082/emp/get-emp-by-first-name/101
	@GetMapping("/get-emp-by-first-name/{firstName}")
	public ResponseEntity<List<Employee>> getEmpByFirstName(@PathVariable(name = "firstName") String firstName) {
		List<Employee> empList = empService.getEmployeeByFirstName(firstName);
		HttpStatus status = HttpStatus.OK;
		empList.forEach(e -> System.out.println(e.toString()));
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(empList, status);
		return response;
	}

//	http://localhost:8082/emp/get-emp-by-salary-greater-than/101
	@GetMapping("/get-emp-by-salary-greater-than/{salary}")
	public ResponseEntity<List<Employee>> getEmpBySalaryGreaterThan(@PathVariable(name = "salary") double salary) {
		List<Employee> empList = empService.getEmployeeBySalaryGreaterThan(salary);
		HttpStatus status = HttpStatus.OK;
		empList.forEach(e -> System.out.println(e.toString()));
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(empList, status);
		return response;
	}

//	http://localhost:8082/emp/get-emp-by-first-name/101
	@GetMapping("/get-emp-by-city/{city}")
	public ResponseEntity<List<Employee>> getEmpByCity(@PathVariable(name = "city") String city) {
		List<Employee> empList = empService.getEmployeeByCity(city);
		HttpStatus status = HttpStatus.OK;
		empList.forEach(e -> System.out.println(e.toString()));
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(empList, status);
		return response;
	}

	//	http://localhost:8082/emp/add-emp 

	@PostMapping("/add-emp")
	public ResponseEntity<Employee> addEmp(@Valid @RequestBody Employee employee) {
		Employee emp = empService.addEmployee(employee);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee with eid " + emp.getEmployeeId() + " was added sussessfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, status);
		return response;
	}

//	http://localhost:8082/emp/update-emp 

	@PutMapping("/update-emp")
	public ResponseEntity<Employee> updateEmp(@Valid @RequestBody Employee employee) {
		Employee emp = empService.updateEmployee(employee);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee with eid " + emp.getEmployeeId() + " was updated sussessfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, status);
		return response;
	}

//	http://localhost:8082/emp/delete-emp-by-id/101 

	@DeleteMapping("/delete-emp-by-id/{eid}")
	public ResponseEntity<Employee> deleteEmp(@PathVariable(name = "eid") int employeeId) {
		Employee emp = empService.deleteEmployeeById(employeeId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee with eid " + employeeId + " was deleted sussessfully.");
		ResponseEntity<Employee> response = new ResponseEntity<>(emp, headers, status);
		return response;
	}

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
