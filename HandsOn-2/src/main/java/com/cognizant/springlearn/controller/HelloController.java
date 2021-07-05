package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	/*
	 * http://localhost:8083/hello
	 */
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ResponseEntity<String> sayHello() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<String>("Hello",HttpStatus.OK);
	}
}