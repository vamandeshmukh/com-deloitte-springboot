package com.deloitte.springboot.demo.exception;

public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1433097311378386507L;

	public DepartmentNotFoundException() {
		super();
	}

	public DepartmentNotFoundException(String message) {
		super(message);
	}
}
