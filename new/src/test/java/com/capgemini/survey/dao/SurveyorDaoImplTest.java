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

class SurveyorDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(MainController.class);
	Scanner sc = new Scanner(System.in);

	@Test
	@DisplayName("Test loginSurveyor")
	void testLoginSurveyor() {
		logger.info("\n-----Testing loginSurveyor for correct user-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertEquals(true, surveyorDao.loginSurveyor("nikhil_06P","Pn@215225#*"));
	}

	@Test
	@DisplayName("Test loginSurveyor1")
	void testLoginSurveyor1() {
		logger.info("\n-----Testing loginSurveyor1 for wrong user-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertEquals(false, surveyorDao.loginSurveyor("nikhil_06P_","Pn@215225#*"));
	}

	@Test
	@DisplayName("Test addSurveyor")
	void testAddSurveyor() {
		logger.info("\n-----Testing addSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertEquals(true, surveyorDao.addSurveyor(4444, "Nicks", "Nicks09@gmail.com", "nikhil_06P", "Pn@215225#*", LocalDate.of(1997, Month.JUNE, 8)));
	}

	@Test
	@DisplayName("Test addSurveyor1")
	void testAddSurveyor1() {
		logger.info("\n-----Testing addSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertEquals(true, surveyorDao.addSurveyor(5555, "Nicks", "Nicks09@gmail.com", "nikhil_06P", "Pn@215225#*", LocalDate.of(1997, Month.JUNE, 8)));
	}

	@Test
	@DisplayName("Test updateSurveyor")
	void testUpdateSurveyor() {
		logger.info("\n-----Testing updateSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertEquals(true, surveyorDao.updateSurveyor(1111, "swarupa", "Nicks09@gmail.com", "nikhil_06P", "Pn@215225#*", LocalDate.of(1997, Month.JUNE, 8)));
	}

	@Test
	@DisplayName("Test updateSurveyor1")
	void testUpdateSurveyor1() {
		logger.info("\n-----Testing updateSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertEquals(true, surveyorDao.updateSurveyor(2222, "riddhi", "Nicks09@gmail.com", "nikhil_06P", "Pn@215225#*", LocalDate.of(1997, Month.JUNE, 8)));
	}

	@Test
	@DisplayName("Test deleteSurveyor")
	void testDeleteSurveyor() {
		logger.info("\n-----Testing deleteSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertEquals(true, surveyorDao.deleteSurveyor(3333));
	}

	@Test
	@DisplayName("Test getSurveyor")
	void testGetSurveyor() {
		logger.info("\n-----Testing getSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertNotNull(null, surveyorDao.getSurveyor(1111));
	}

	@Test
	@DisplayName("Test getSurveyor1")
	void testGetSurveyor1() {
		logger.info("\n-----Testing getSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertNotNull(null, surveyorDao.getSurveyor(2222));
	}

	@Test
	@DisplayName("Test getAllSurveyor")
	void testGetAllSurveyor() {
		logger.info("\n-----Testing getAllSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertNotNull(null, surveyorDao.getAllSurveyors());
	}

	@Test
	@DisplayName("Test getAllSurveyor1")
	void testGetAllSurveyor1() {
		logger.info("\n-----Testing getAllSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertNotNull(null, surveyorDao.getAllSurveyors());
	}
}
