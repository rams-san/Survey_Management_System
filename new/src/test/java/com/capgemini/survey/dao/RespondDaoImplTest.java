package com.capgemini.survey.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.controller.MainController;
import com.capgemini.survey.factory.Factory;

	@TestMethodOrder(Alphanumeric.class)
class RespondDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(MainController.class);

	@Test
	@DisplayName("Test AdistributeSurvey")
	void testAdistributeSurvey() {
		logger.info("\n-----Testing distributeSurvey-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		assertEquals(true, respondDao.distributeSurvey(111,"Facebook"));
	}
	
	@Test
	@DisplayName("Test BrespondToSurvey ")
	void testBrespondToSurvey() {
		logger.info("\n-----Testing respondToSurvey-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		RespondInfoBean respondInfoBean = Factory.getRespondInfoBeanInstance();
		assertEquals(true, respondDao.respondToSurvey(111, 1, respondInfoBean));
	}

	@Test
	@DisplayName("TestCgetRespondedList")
	void testCgetRespondedList() {
		logger.info("\n-----Testing getRespondedList-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		assertNotNull(null, respondDao.getRespondedList());
	}

	@Test
	@DisplayName("Test DgetRespondedRecord")
	void testDgetRespondedRecord() {
		logger.info("\n-----Testing getRespondedRecord-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		assertNotNull(null, respondDao.getRespondedRecord());
	}

}
