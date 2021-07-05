package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Transactional
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployee();
	}
}
