package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;

@Component
public class EmployeeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	private ApplicationContext context;
	private List<Employee> EMPLOYEE_LIST;
	
	public EmployeeDao() {
		LOGGER.debug("Start");
		context = new ClassPathXmlApplicationContext("employee.xml");

		this.EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
		LOGGER.debug("End");
	}
	
	public List<Employee> getAllEmployee() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return this.EMPLOYEE_LIST;
	}

}