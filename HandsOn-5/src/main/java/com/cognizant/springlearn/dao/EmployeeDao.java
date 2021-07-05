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
	
	public void addEmployee(Employee employee) {
		LOGGER.debug("Start");
		EMPLOYEE_LIST.add(employee);
		LOGGER.debug("End");
	}
	public boolean editEmployee(Employee newEmployee) {
		LOGGER.debug("Start");
		int ind=0;
		for (Employee employee: EMPLOYEE_LIST) {
			if (employee.getId().equals(newEmployee.getId())) {
				EMPLOYEE_LIST.set(ind, newEmployee);
				return true;
			}
			ind+=1;
		}
		LOGGER.debug("End");
		return false;
	}
	public boolean deleteEmployee(String id) {
		LOGGER.debug("Start");
		Employee employee = getEmployeeById(id);
		if (employee == null) {
			return false;
		}
		EMPLOYEE_LIST.remove(employee);
		LOGGER.debug("End");
		return true;
	}
	public Employee getEmployeeById(String id) {
		LOGGER.debug("Start");
		for (Employee employee: EMPLOYEE_LIST) {
			if (employee.getId().equalsIgnoreCase(id)) {
				return employee;
			}
		}
		LOGGER.debug("End");
		return null;
	}

}