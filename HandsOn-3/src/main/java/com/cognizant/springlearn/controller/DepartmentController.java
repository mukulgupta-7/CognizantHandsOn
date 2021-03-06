package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.service.DepartmentService;

@Controller
public class DepartmentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService departmentService;
	
	/*
	 * returns list of departments
	 * http://localhost:8083/departments
	 */
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartments() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(),HttpStatus.OK); 
	}

}
