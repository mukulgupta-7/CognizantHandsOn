package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	private static List<Country> allCountries;
	public CountryService() {
		LOGGER.debug("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		allCountries = (List<Country>)context.getBean("countryList", List.class);
		LOGGER.debug("END");
	}
	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.debug("START");
		for (Country country: allCountries) {
			if (country.getCode().equalsIgnoreCase(code)) {
				return country;
			}
		}
		LOGGER.debug("END");
		throw new CountryNotFoundException("Country not found");
	}
	
	public List<Country> getCountries() {
		LOGGER.debug("START");
		LOGGER.debug("END");
		return allCountries;
	}

}
