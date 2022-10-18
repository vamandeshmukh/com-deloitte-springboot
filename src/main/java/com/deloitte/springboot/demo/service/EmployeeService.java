package com.deloitte.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.springboot.demo.exception.EmployeeNotFoundException;
import com.deloitte.springboot.demo.model.Employee;
import com.deloitte.springboot.demo.repository.DepartmentRepository;
import com.deloitte.springboot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	@Autowired
	DepartmentRepository depRepository;

	@Autowired
	DepartmentService depService;

	public List<Employee> getAllEmployees() {
		System.out.println("getAllEmployees");
		return empRepository.findAll();
	}

	public Employee getEmployeeById(int employeeId) { //
		System.out.println("getEmployeeById " + employeeId);
		Optional<Employee> empOptional = empRepository.findById(employeeId);
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			String errorMessage = "Employee with eid " + employeeId + " not found.";
			System.out.println(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		System.out.println("getEmployeeByFirstName " + firstName);
		List<Employee> empList = empRepository.findByFirstName(firstName);
		if (!empList.isEmpty()) {
			return empList;
		} else {
			String errorMessage = "Employee with name " + firstName + " not found.";
			System.out.println(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
	}

	public List<Employee> getEmployeeByCity(String city) {
		// logic
		return empRepository.findByDepartment_City(city);
	}

	public Employee addEmployee(Employee employee) {
		System.out.println("addEmployee " + employee.toString());
		if (null != employee.getDepartment())
			depService.getDepartmentById(employee.getDepartment().getDepartmentId());
		return empRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		this.getEmployeeById(employee.getEmployeeId());
		System.out.println("updateEmployee " + employee.toString());
		return empRepository.save(employee);
	}

	public Employee deleteEmployeeById(int employeeId) {
		Employee emp = this.getEmployeeById(employeeId);
		System.out.println("deleteEmployeeById " + employeeId);
		empRepository.deleteById(employeeId);
		return emp;
	}

	public List<Employee> getEmployeeBySalaryGreaterThan(double salary) {
		return empRepository.findBySalaryGreaterThan(salary);
	}

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
