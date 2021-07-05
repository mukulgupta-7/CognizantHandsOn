package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Controller
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	@Autowired
	private CountryService countryService;
	
	
	/*
	 * http://localhost:8083/country
	 */
	@RequestMapping(value="/country",method=RequestMethod.GET)
	public ResponseEntity<Country> getCountryIndia() {
		LOGGER.debug("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("in", Country.class);
		LOGGER.debug("End");
		return new ResponseEntity<Country>(country,HttpStatus.OK);
	}
	
	/*
	 * http://localhost:8083/countries
	 */
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getAllCountries() {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<List<Country>>(countryService.getCountries(),HttpStatus.OK);
	}
	
	/*
	 * http://localhost:8083/countries/{code}
	 */
	@GetMapping("/countries/{code}")
	public ResponseEntity<Country> getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<Country>(countryService.getCountry(code),HttpStatus.OK);
	}
	
	/*
	 * add a new country
	 * http://localhost:8083/countries
	 */
	
	@PostMapping("/countries")
	public ResponseEntity<Country> addCountry(@RequestBody @Valid Country country) {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<Country>(countryService.addCountry(country),HttpStatus.CREATED);
	}
	
	
	/*
	 * update a country
	 * http://localhost:8083/countries/
	 */
	@PutMapping("/countries")
	public ResponseEntity<String> updateCountries(@RequestBody @Valid Country country) {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<>(countryService.editCountry(country),HttpStatus.ACCEPTED);
	}
	
	/*
	 * Delete a country
	 * http://localhost:8083/countries/{code}
	 */
	@DeleteMapping("/countries/{code}")
	public ResponseEntity<String> deleteCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return new ResponseEntity<>(countryService.deleteCountry(code),HttpStatus.OK);
	}

}

