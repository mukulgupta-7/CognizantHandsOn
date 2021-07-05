package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	@Autowired
	CountryDao countryDao;
	public CountryService() {
		super();
		LOGGER.debug("START");
		LOGGER.debug("END");
	}
	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.debug("START");
		Country country = countryDao.getCountryByCode(code);
		if (country == null) {			
			throw new CountryNotFoundException("Country not found");
		}
		LOGGER.debug("END");
		return country;
	}
	
	public List<Country> getCountries() {
		LOGGER.debug("START");
		LOGGER.debug("END");
		return countryDao.getAllCountries();
	}

	public Country addCountry(Country country) {
		LOGGER.debug("START");
		
		//country already exits?
		if (countryDao.getCountryByCode(country.getCode()) != null) {
			return null;
		}
		countryDao.addCountry(country);
		LOGGER.debug("END");
		return country;
	}

	public String editCountry(Country country) {
		LOGGER.debug("START");
		if (countryDao.editCountry(country)) {
			return "Country edited successfully";
		}
		LOGGER.debug("END");
		return "failed to edit country";
	}

	public String deleteCountry(String code) throws CountryNotFoundException{
		LOGGER.debug("START");
		if (countryDao.deleteCountry(code)) {
			return "Country with code "+code + " is deleted successfully";
		} else {
			throw new CountryNotFoundException("Country not found");
		}
	}


}
