package com.capgemini.survey.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesController {
	private PropertiesController() {

	}

	public static boolean callingProperties() {
		Logger logger = MainController.logger;
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("F:\\assesments\\survey-management-system\\src\\main\\java\\db.properties"));
		} catch (FileNotFoundException e1) {
			logger.log(null, e1);
		} catch (IOException e2) {
			logger.log(null, e2);
		}
		String userName = props.getProperty("userName");
		String password = props.getProperty("password");
		logger.info("\nUser Name : " + userName);
		logger.info("Password : " + password);
		return true;
	}
}
