package com.deloitte.springboot.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dep")
@CrossOrigin(origins = "*")
public class DepartmentController {

}
