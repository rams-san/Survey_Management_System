package com.capgemini.survey.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.controller.MainController;
import com.capgemini.survey.factory.Factory;

class SurveyDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(MainController.class);
	Scanner sc = new Scanner(System.in);
	
	@Test
	@DisplayName("Test addSurvey")
	void testAddSurvey() {
		logger.info("\n-----Testing addSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		SurveyInfoBean surveyInfoBean = Factory.getSurveyInfoBeanInstance();
		assertEquals(true, surveyDao.addSurvey(surveyInfoBean));
	}

	@Test
	@DisplayName("Test addSurvey1")
	void testAddSurvey1() {
		logger.info("\n-----Testing addSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		SurveyInfoBean surveyInfoBean = Factory.getSurveyInfoBeanInstance();
		assertEquals(true, surveyDao.addSurvey(surveyInfoBean));
	}

	@Test
	@DisplayName("Test updateSurvey")
	void testUpdateSurvey() {
		logger.info("\n-----Testing updateSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		SurveyInfoBean surveyInfoBean = Factory.getSurveyInfoBeanInstance();
		assertEquals(true, surveyDao.updateSurvey("Facebook", surveyInfoBean));
	}

	@Test
	@DisplayName("Test updateSurvey1")
	void testUpdateSurvey1() {
		logger.info("\n-----Testing updateSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		SurveyInfoBean surveyInfoBean = Factory.getSurveyInfoBeanInstance();
		assertEquals(true, surveyDao.updateSurvey("Facebook", surveyInfoBean));
	}

	@Test
	@DisplayName("Test deleteSurvey")
	void testDeleteSurvey() {
		logger.info("\n-----Testing deleteSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertEquals(true, surveyDao.deleteSurvey("Amazon Prime"));
	}

	@Test
	@DisplayName("Test getSurvey")
	void testGetSurvey() {
		logger.info("\n-----Testing getSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getSurvey("Flipkart"));
	}

	@Test
	@DisplayName("Test getSurvey1")
	void testGetSurvey1() {
		logger.info("\n-----Testing getSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getSurvey("Facebook"));
	}

	@Test
	@DisplayName("Test getAllSurvey")
	void testGetAllSurvey() {
		logger.info("\n-----Testing getAllSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getAllSurveys());
	}

	@Test
	@DisplayName("Test getAllSurvey1")
	void testGetAllSurvey1() {
		logger.info("\n-----Testing getAllSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getAllSurveys());
	}
	
	@Test
	@DisplayName("Test getListOfTitle")
	void testGetListOfTitle() {
		logger.info("\n-----Testing getListOfTitle-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getListOfTitle());
	}
	
	@Test
	@DisplayName("Test getSurveyQuestions")
	void testGetSurveyQuestions() {
		logger.info("\n-----Testing getSurveyQuestions for wrong entry-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getSurveyQuestions("Facebook"));
	}
}
