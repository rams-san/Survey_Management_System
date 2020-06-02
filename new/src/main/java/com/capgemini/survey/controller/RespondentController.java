package com.capgemini.survey.controller;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.capgemini.survey.exceptions.InvalidChoiceException;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.service.RespondentService;
import com.capgemini.survey.validations.InputValidations;

public class RespondentController {
	private RespondentController() {

	}

	static InputValidations inputValidation = Factory.getInputValidationInstance();
	static Scanner sc = MainController.sc;
	static Logger logger = MainController.logger;
	static boolean flag3 = true;

	public static boolean callingTryCatchBlock() {
		String choice3 = sc.next();

		try {
			while (!inputValidation.choice3Validation(choice3)) {
				throw new InvalidChoiceException("Choice doesn't exists");
			}
			int switchChoice3 = Integer.parseInt(choice3);
			switch (switchChoice3) {
			case 1:
				AdminServicesController.callingRespondedToASurvey();
				break;
			case 2:
				AdminServicesController.callingListOfRespondedSurveys();
				break;
			case 3:
				logger.info("Logged out from Respondent!");
				flag3 = false;
				break;
			default:
				flag3 = false;
				logger.info("Please enter correct option :");
			}
		} catch (NotFoundException e) {
			String s = e.getMessage();
			logger.error(s);
		} catch (InvalidChoiceException e1) {
			String s = e1.getMessage();
			logger.error(s);
		}
		return false;
	}

	public static boolean callingRespondentController() {
		logger.info("\nEnter Respondent UserName (e.g rams_san11):");
		String userName3 = sc.next();

		while (!inputValidation.userNameValidation(userName3)) {
			logger.info("Please enter valid respondent userName ");
			userName3 = sc.next();
		}

		logger.info("\nEnter Respondent Password (e.g Sa*@#$%!11):");
		String password3 = sc.next();

		while (!inputValidation.passwordValidation(password3)) {
			logger.info("Please enter valid respondent password ");
			password3 = sc.next();
		}
		RespondentService respondentService1 = Factory.getRespondentServiceInstance();
		boolean b2 = respondentService1.serviceLoginRespondent(userName3, password3);
		if (b2) {
			logger.info("Respondent login Successful !!");
			do {
				logger.info("\nInside Respondent");
				logger.info("\nChoose your option");
				logger.info("1. Respond to a survey");
				logger.info("2. List of responded surveys");
				logger.info("3. Logout");
				RespondentController.callingTryCatchBlock();
			} while (flag3);
			return true;
		} else {
			logger.error("Invalid username or password !");
			return false;
		}
	}
}
