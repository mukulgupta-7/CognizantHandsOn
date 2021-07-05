package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	EmployeeDao employeeDao;
	public EmployeeService() {
		super();
		LOGGER.debug("START");
		LOGGER.debug("END");
	}
	public Employee getEmployee(String id) throws EmployeeNotFoundException {
		LOGGER.debug("START");
		Employee employee = employeeDao.getEmployeeById(id);
		if (employee == null) {			
			throw new EmployeeNotFoundException("Employee not found");
		}
		LOGGER.debug("END");
		return employee;
	}
	
	public List<Employee> getAllEmployees() {
		LOGGER.debug("START");
		LOGGER.debug("END");
		return employeeDao.getAllEmployee();
	}

	public Employee addEmployee(Employee employee) {
		LOGGER.debug("START");
		
		//employee already exits?
		if (employeeDao.getEmployeeById(employee.getId()) != null) {
			return null;
		}
		employeeDao.addEmployee(employee);
		LOGGER.debug("END");
		return employee;
	}

	public String editEmployee(Employee employee) {
		LOGGER.debug("START");
		if (employeeDao.editEmployee(employee)) {
			return "Employee edited successfully";
		}
		LOGGER.debug("END");
		return "failed to edit employee";
	}

	public String deleteEmployee(String id) throws EmployeeNotFoundException{
		LOGGER.debug("START");
		if (employeeDao.deleteEmployee(id)) {
			return "Employee with id "+id + " is deleted successfully";
		} else {
			throw new EmployeeNotFoundException("Employee not found");
		}
	}
}
