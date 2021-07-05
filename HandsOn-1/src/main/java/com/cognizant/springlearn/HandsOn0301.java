package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

@SpringBootApplication
public class HandsOn0301 {
	private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn0301.class);

	public static void main(String[] args) {
		SpringApplication.run(HandsOn0301.class, args);
		HandsOn0301 obj = new HandsOn0301();
		obj.displayDate();
		obj.displayCountry();
		obj.displayCountries();
		
	}
	
	void displayDate() {
		LOGGER.info("Started");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("End");
	}
	void displayCountry() {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country)context.getBean("in", Country.class);
		Country anoCountry = (Country)context.getBean("in", Country.class);
		LOGGER.debug("Country : {}", country.hashCode());
		LOGGER.debug("Country : {}", anoCountry.hashCode());
		LOGGER.info("End");
	}
	void displayCountries() {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Country List");
		for (Country country: countries) {
			LOGGER.debug("Country {}", country);
		}
		LOGGER.info("End");
	}

}
