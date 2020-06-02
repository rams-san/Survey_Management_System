package com.capgemini.survey.controller;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.capgemini.survey.exceptions.InvalidChoiceException;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.service.SurveyorService;
import com.capgemini.survey.validations.InputValidations;

public class SurveyorController {
	private SurveyorController() {

	}

	static InputValidations inputValidation = Factory.getInputValidationInstance();
	static Scanner sc = MainController.sc;
	static Logger logger = MainController.logger;
	static boolean flag2 = true;
	static String questionStatement = "Please enter valid question ";

	public static boolean callingTryCatchBlock() {
		String choice2 = sc.next();

		try {
			while (!inputValidation.choice2Validation(choice2)) {
				throw new InvalidChoiceException("Choice doesn't exists");
			}
			int switchChoice2 = Integer.parseInt(choice2);
			switch (switchChoice2) {
			case 1:
				AdminServicesController.callingCreateSurvey();
				break;
			case 2:
				AdminServicesController.callingUpdateSurvey();
				break;
			case 3:
				AdminServicesController.callingDeleteSurvey();
				break;
			case 4:
				AdminServicesController.callingGetSurveyDetails();
				break;
			case 5:
				AdminServicesController.callingGetAllSurveysDetails();
				break;
			case 6:
				AdminServicesController.callingDistributeSurvey();
				break;
			case 7:
				AdminServicesController.callingRecordOfRespondedSurveys();
				break;
			case 8:
				AdminServicesController.callingRecordOfPendingSurveys();
				break;
			case 9:
				logger.info("Logged out from Surveyor!");
				flag2 = false;
				break;
			default:
				flag2 = false;
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

	public static boolean callingSurveyorController() {
		logger.info("\nEnter Surveyor UserName (e.g rams_san11):");
		String userName2 = sc.next();

		while (!inputValidation.userNameValidation(userName2)) {
			logger.info("Please Enter Valid surveyor userName ");
			userName2 = sc.next();
		}

		logger.info("\nEnter Surveyor Password (e.g Sa*@#$%!11):");
		String password2 = sc.next();

		while (!inputValidation.passwordValidation(password2)) {
			logger.info("Please Enter Valid Surveyor password ");
			password2 = sc.next();
		}
		SurveyorService surveyorService1 = Factory.getSurveyorServiceInstance();
		boolean b1 = surveyorService1.serviceLoginSurveyor(userName2, password2);
		if (b1) {
			logger.info("Surveyor login Successful !!");
			do {
				logger.info("\nInside Surveyor");
				logger.info("\nChoose your option");
				logger.info("1. Create Survey");
				logger.info("2. Update Survey");
				logger.info("3. Delete Survey");
				logger.info("4. Get Survey Details");
				logger.info("5. Get All Survey Details");
				logger.info("6. Distribute Surveys");
				logger.info("7. Record of Responded surveys");
				logger.info("8. Record of Pending surveys");
				logger.info("9. Logout");
				SurveyorController.callingTryCatchBlock();
			} while (flag2);
			return true;
		} else {
			logger.error("Invalid username or password !");
			return false;
		}
	}
}
