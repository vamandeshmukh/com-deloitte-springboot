package com.deloitte.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//	http://localhost:8080/hello

	@GetMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "Hello world!";
	}

//	http://localhost:8080/hi

	@GetMapping("/hi")
	public String hi() {
		System.out.println("hi");
		return "Hi! How're you?";
	}

}
