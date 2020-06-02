package com.capgemini.survey.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.capgemini.survey.controller.MainController;
import com.capgemini.survey.factory.Factory;

class RespondentDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(MainController.class);
	Scanner sc = new Scanner(System.in);

	@Test
	@DisplayName("Test loginRespondent")
	void testLoginRespondent() {
		logger.info("\n-----Testing loginRespondent for correct user-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertEquals(true, respondentDao.loginRespondent("siddhi09_Ram","riddhiSR@*9276"));
	}

	@Test
	@DisplayName("Test loginRespondent1")
	void testLoginRespondent1() {
		logger.info("\n-----Testing loginRespondent1 for wrong user-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();		
		assertEquals(false, respondentDao.loginRespondent("siddhi09_Ram_","riddhiSR@*9276"));
	}

	@Test
	@DisplayName("Test addRespondent")
	void testAddRespondent() {
		logger.info("\n-----Testing addRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertEquals(true, respondentDao.addRespondent(444, "sam", "Sneha05@gmail.com", "sneha0805_Ram", "SnR15@#215", LocalDate.of(1999, Month.AUGUST, 5)));
	}

	@Test
	@DisplayName("Test addRespondent1")
	void testAddRespondent1() {
		logger.info("\n-----Testing addRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertEquals(true, respondentDao.addRespondent(555, "ram", "Sneha05@gmail.com", "sneha0805_Ram", "SnR15@#215", LocalDate.of(1999, Month.AUGUST, 5)));
	}

	@Test
	@DisplayName("Test updateRespondent")
	void testUpdateRespondent() {
		logger.info("\n-----Testing updateRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertEquals(true, respondentDao.updateRespondent(111, "ankita", "Sneha05@gmail.com", "sneha0805_Ram", "SnR15@#215", LocalDate.of(1999, Month.AUGUST, 5)));
	}

	@Test
	@DisplayName("Test updateRespondent1")
	void testUpdateRespondent1() {
		logger.info("\n-----Testing updateRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertEquals(true, respondentDao.updateRespondent(111, "nikita", "Sneha05@gmail.com", "sneha0805_Ram", "SnR15@#215", LocalDate.of(1999, Month.AUGUST, 5)));
	}

	@Test
	@DisplayName("Test deleteRespondent")
	void testDeleteRespondent() {
		logger.info("\n-----Testing deleteRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertEquals(true, respondentDao.deleteRespondent(333));
	}
	
	@Test
	@DisplayName("Test getRespondent")
	void testGetRespondent() {
		logger.info("\n-----Testing getRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertNotNull(null, respondentDao.getRespondent(111));
	}
	
	@Test
	@DisplayName("Test getRespondent1")
	void testGetRespondent1() {
		logger.info("\n-----Testing getRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertNotNull(null, respondentDao.getRespondent(222));
	}
	
	@Test
	@DisplayName("Test getAllRespondent")
	void testGetAllRespondent() {
		logger.info("\n-----Testing getAllRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertNotNull(null, respondentDao.getAllRespondents());
	}
	
	@Test
	@DisplayName("Test getAllRespondent1")
	void testGetAllRespondent1() {
		logger.info("\n-----Testing getAllRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertNotNull(null, respondentDao.getAllRespondents());
	}
}
