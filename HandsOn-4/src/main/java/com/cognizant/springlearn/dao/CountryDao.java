package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Country;

@Component
public class CountryDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);
	public static ArrayList<Country> COUNTRY_LIST;
	public CountryDao() {
		LOGGER.debug("Start");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
		COUNTRY_LIST = (ArrayList<Country>)ctx.getBean("countryList");
		LOGGER.debug("End");
	}
	public ArrayList<Country> getAllCountries(){
		LOGGER.debug("Start");
		LOGGER.debug("End");
		return COUNTRY_LIST;
	}
	public void addCountry(Country country) {
		LOGGER.debug("Start");
		COUNTRY_LIST.add(country);
		LOGGER.debug("End");
	}
	public boolean editCountry(Country newCountry) {
		LOGGER.debug("Start");
		for (Country country: COUNTRY_LIST) {
			if (country.getCode().equals(newCountry.getCode())) {
				country.setName(newCountry.getName());
				return true;
			}
		}
		LOGGER.debug("End");
		return false;
	}
	public boolean deleteCountry(String code) {
		LOGGER.debug("Start");
		Country country = getCountryByCode(code);
		if (country == null) {
			return false;
		}
		COUNTRY_LIST.remove(country);
		LOGGER.debug("End");
		return true;
	}
	public Country getCountryByCode(String code) {
		LOGGER.debug("Start");
		for (Country country: COUNTRY_LIST) {
			if (country.getCode().equalsIgnoreCase(code)) {
				return country;
			}
		}
		LOGGER.debug("End");
		return null;
	}
}