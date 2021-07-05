package com.cognizant.springlearn.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Country {
	
	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters") 
	private String code;
	private String name;
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	public Country() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
	}
	public String getCode() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Start");
		this.code = code;
		LOGGER.debug("End");
	}
	public Country(String code, String name) {
		super();
		LOGGER.debug("Start");
		this.code = code;
		this.name = name;
		LOGGER.debug("End");
	}
	public String getName() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Start");
		this.name = name;
		LOGGER.debug("End");
	}
	
	@Override
	public String toString() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
