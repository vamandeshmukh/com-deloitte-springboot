package com.deloitte.springboot.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.springboot.demo.exception.DepartmentNotFoundException;
import com.deloitte.springboot.demo.model.Department;
import com.deloitte.springboot.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository depRepository;

	public Department getDepartmentById(int departmentId) {
		Optional<Department> depOptional = depRepository.findById(departmentId);
		if (depOptional.isPresent()) {
			return depOptional.get();
		} else {
			String errorMessage = "Department with did " + departmentId + " not found.";
			System.out.println(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
	}

}
