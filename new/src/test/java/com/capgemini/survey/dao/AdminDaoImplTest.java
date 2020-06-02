package com.capgemini.survey.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.capgemini.survey.controller.MainController;
import com.capgemini.survey.factory.Factory;

class AdminDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(MainController.class);
	Scanner sc = new Scanner(System.in);

	@Test
	@DisplayName("Test loginAdmin")
	void testLoginAdmin() {
		logger.info("\n-----Testing loginAdmin for correct user-----\n");
		AdminDao adminDao = Factory.getAdminDaoInstance();
		assertEquals(true, adminDao.loginAdmin("Suyash", "Suyash@123"));
	}

	@Test
	@DisplayName("Test loginAdmin1")
	void testLoginAdmin1() {
		logger.info("\n-----Testing loginAdmin1 for wrong user-----\n");
		AdminDao adminDao = Factory.getAdminDaoInstance();
		assertEquals(false, adminDao.loginAdmin("Suyash_", "Suyash@123"));
	}
}
