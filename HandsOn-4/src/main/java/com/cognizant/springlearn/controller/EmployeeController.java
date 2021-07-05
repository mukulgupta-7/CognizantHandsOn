package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Controller
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	
	/*
	 * http://localhost:8083/employees
	 */
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
	
	/*
	 * http://localhost:8083/employees/{code}
	 */
	@GetMapping("/employees/{code}")
	public ResponseEntity<Employee> getEmployee(@PathVariable String code) throws EmployeeNotFoundException {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<Employee>(employeeService.getEmployee(code),HttpStatus.OK);
	}
	
	/*
	 * add a new employee
	 * http://localhost:8083/employees
	 */
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.CREATED);
	}
	
	
	/*
	 * update a employee
	 * http://localhost:8083/employees/
	 */
	@PutMapping("/employees")
	public ResponseEntity<String> updateEmployees(@RequestBody @Valid Employee employee) {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<>(employeeService.editEmployee(employee),HttpStatus.ACCEPTED);
	}
	
	/*
	 * Delete a employee
	 * http://localhost:8083/employees/{code}
	 */
	@DeleteMapping("/employees/{code}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String code) throws EmployeeNotFoundException {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<>(employeeService.deleteEmployee(code),HttpStatus.OK);
	}

}
