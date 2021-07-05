package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Department;
@Component
public class DepartmentDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
	public static ArrayList<Department> DEPARTMENT_LIST;
	public DepartmentDao() {
		LOGGER.debug("Start");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (ArrayList<Department>)ctx.getBean("departmentList");
		LOGGER.debug("End");
	}
	public ArrayList<Department> getAllDepartments(){
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return DEPARTMENT_LIST;
	}
}