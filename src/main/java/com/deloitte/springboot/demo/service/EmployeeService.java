package com.deloitte.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.springboot.demo.exception.EmployeeNotFoundException;
import com.deloitte.springboot.demo.model.Employee;
import com.deloitte.springboot.demo.repository.DepartmentRepository;
import com.deloitte.springboot.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeRepository empRepository;

	@Autowired
	DepartmentRepository depRepository;

	@Autowired
	DepartmentService depService;

	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		return empRepository.findAll();
	}

	public Employee getEmployeeById(int employeeId) { //
		LOG.info("getEmployeeById " + employeeId);
		Optional<Employee> empOptional = empRepository.findById(employeeId);
		if (empOptional.isPresent()) {
			return empOptional.get();
		} else {
			String errorMessage = "Employee with eid " + employeeId + " not found.";
			LOG.error(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		LOG.info("getEmployeeByFirstName " + firstName);
		List<Employee> empList = empRepository.findByFirstName(firstName);
		if (!empList.isEmpty()) {
			return empList;
		} else {
			String errorMessage = "Employee with name " + firstName + " not found.";
			LOG.error(errorMessage);
			throw new EmployeeNotFoundException(errorMessage);
		}
	}

	public List<Employee> getEmployeeByCity(String city) {
		LOG.info(city); // logic
		return empRepository.findByDepartment_City(city);
	}

	public Employee addEmployee(Employee employee) {
		LOG.info("addEmployee " + employee.toString());
		if (null != employee.getDepartment())
			depService.getDepartmentById(employee.getDepartment().getDepartmentId());
		return empRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		LOG.info("updateEmployee " + employee.toString());
		this.getEmployeeById(employee.getEmployeeId());
		return empRepository.save(employee);
	}

	public Employee deleteEmployeeById(int employeeId) {
		Employee emp = this.getEmployeeById(employeeId);
		LOG.info("deleteEmployeeById " + employeeId);
		empRepository.deleteById(employeeId);
		return emp;
	}

	public List<Employee> getEmployeeBySalaryGreaterThan(double salary) {
		LOG.info(Double.toString(salary));
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
