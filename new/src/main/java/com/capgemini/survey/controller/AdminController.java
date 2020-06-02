package com.capgemini.survey.controller;

import java.time.LocalDate;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.capgemini.survey.exceptions.InvalidChoiceException;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.exceptions.RespondAlreadyExistsException;
import com.capgemini.survey.exceptions.RespondentAlreadyExistsException;
import com.capgemini.survey.exceptions.SurveyorAlreadyExistsException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.service.AdminService;
import com.capgemini.survey.service.RespondentService;
import com.capgemini.survey.service.SurveyorService;
import com.capgemini.survey.validations.InputValidations;

public class AdminController {
	private AdminController() {

	}

	static InputValidations inputValidation = Factory.getInputValidationInstance();
	static boolean flag1 = true;
	static String userNameStatement = "Please enter valid username ";
	static String passwordStatement = "Please enter valid Password ";
	static String dateStatement = "Please enter valid date of birth ";
	static Scanner sc = MainController.sc;
	static Logger logger = MainController.logger;

	public static boolean callingAddSurveyor() {
		SurveyorService surveyorService = Factory.getSurveyorServiceInstance();
		logger.info("Enter Surveyor ID (range:00-9999) :");
		String surveyorId1 = sc.next();
		while (!inputValidation.idValidation(surveyorId1)) {
			logger.error("please enter valid surveyor id");
			surveyorId1 = sc.next();
		}
		int surveyorId = Integer.parseInt(surveyorId1);
		if (surveyorService.serviceSearchSurveyor(surveyorId)) {
			logger.info("Enter Surveyor Name :");
			sc.nextLine();
			String surveyorName = sc.nextLine();
			while (!inputValidation.nameValidation(surveyorName)) {
				logger.error("please enter valid surveyor name");
				surveyorName = sc.nextLine();
			}

			logger.info("Enter Surveyor Email (e.g ramsan11@gmail.com):");
			String surveyorEmail = sc.next();
			while (!inputValidation.emailValidation(surveyorEmail)) {
				logger.error("please enter valid email");
				surveyorEmail = sc.nextLine();
			}

			logger.info("Enter Surveyor UserName (e.g rams_san11):");
			String surveyorUserName = sc.next();
			while (!inputValidation.userNameValidation(surveyorUserName)) {
				logger.info(userNameStatement);
				surveyorUserName = sc.next();
			}

			logger.info("Enter Surveyor Password (e.g Sa*@#$%!11):");
			String surveyorPassword = sc.next();
			while (!inputValidation.passwordValidation(surveyorPassword)) {
				logger.info(passwordStatement);
				surveyorPassword = sc.next();
			}

			logger.info("Enter Surveyor Date of birth (e.g yyyy/mm/dd):");
			String date = sc.next();
			while (!inputValidation.localDateValidation(date)) {
				logger.info(dateStatement);
				date = sc.next();
			}
			LocalDate surveyorDob = LocalDate.parse(date);
			surveyorService.serviceAddSurveyor(surveyorId, surveyorName, surveyorEmail, surveyorUserName,
					surveyorPassword, surveyorDob);
			logger.info("\n Surveyor added successfully !!");
		}
		return false;
	}

	public static boolean callingAddRespondent() {
		RespondentService respondentService = Factory.getRespondentServiceInstance();
		logger.info("Enter Respondent ID (range:00-9999):");
		String respondentId1 = sc.next();
		while (!inputValidation.idValidation(respondentId1)) {
			logger.error("please enter valid respondent id");
			respondentId1 = sc.next();
		}
		int respondentId = Integer.parseInt(respondentId1);

		if (respondentService.serviceSearchRespondent(respondentId)) {
			logger.info("Enter Respondent Name :");
			sc.nextLine();
			String respondentName = sc.nextLine();

			while (!inputValidation.nameValidation(respondentName)) {
				logger.error("please enter valid respondent name");
				respondentName = sc.nextLine();
			}

			logger.info("Enter Respondent Email (e.g ramsan11@gmail.com):");
			String respondentEmail = sc.next();
			while (!inputValidation.emailValidation(respondentEmail)) {
				logger.error("please enter valid email");
				respondentEmail = sc.nextLine();
			}

			logger.info("Enter Respondent UserName (e.g rams_san11):");
			String respondentUserName = sc.next();
			while (!inputValidation.userNameValidation(respondentUserName)) {
				logger.info(userNameStatement);
				respondentUserName = sc.next();
			}

			logger.info("Enter Respondent Password (e.g Sa*@#$%!11):");
			String respondentPassword = sc.next();
			while (!inputValidation.passwordValidation(respondentPassword)) {
				logger.info(passwordStatement);
				respondentPassword = sc.next();
			}

			logger.info("Enter Respondent Date of birth (e.g yyyy/mm/dd):");
			String date = sc.next();
			while (!inputValidation.localDateValidation(date)) {
				logger.info(dateStatement);
				date = sc.next();
			}
			LocalDate respondentDob = LocalDate.parse(date);
			respondentService.serviceAddRespondent(respondentId, respondentName, respondentEmail, respondentUserName,
					respondentPassword, respondentDob);
			logger.info("\n Respondent added successfully !!");
		}
		return false;
	}

	public static boolean callingTryCatchBlock() {
		String choice1 = sc.next();
		try {
			while (!inputValidation.choice1Validation(choice1)) {
				throw new InvalidChoiceException("Choice doesn't exists");
			}
			int switchChoice1 = Integer.parseInt(choice1);
			switch (switchChoice1) {
			case 1:
				AdminController.callingAddSurveyor();
				break;
			case 2:
				AdminController.callingAddRespondent();
				break;
			case 3:
				SurveyorController.callingSurveyorController();
				break;
			case 4:
				RespondentController.callingRespondentController();
				break;
			case 5:
				AdminServicesController.callingAdminServicesController();
				break;
			case 6:
				logger.info("\nLogged out from Admin!");
				flag1 = false;
				break;
			default:
				flag1 = false;
				logger.info("Please enter correct option :");
			}
		} catch (NotFoundException e) {
			String s = e.getMessage();
			logger.error(s);
		} catch (InvalidChoiceException e1) {
			String s = e1.getMessage();
			logger.error(s);
		} catch (SurveyorAlreadyExistsException e4) {
			String s = e4.getMessage();
			logger.error(s);
		} catch (RespondentAlreadyExistsException e5) {
			String s = e5.getMessage();
			logger.error(s);
		} catch (RespondAlreadyExistsException e6) {
			String s = e6.getMessage();
			logger.error(s);
		}
		return false;
	}

	public static boolean callingAdminController() {
		logger.info("Enter Admin UserName :");
		String userName1 = sc.next();
		while (!inputValidation.userNameValidation(userName1)) {
			logger.info("Please enter valid admin username ");
			userName1 = sc.next();
		}

		logger.info("Enter Admin Password :");
		String password1;
		password1 = sc.next();
		while (!inputValidation.passwordValidation(password1)) {
			logger.info("Please enter valid admin password ");
			password1 = sc.next();
		}
		AdminService adminService = Factory.getAdminServiceInstance();
		boolean b = adminService.serviceLoginAdmin(userName1, password1);
		if (b) {
			logger.info("Admin login Successful !!");
			do {
				logger.info("\nInside Admin");
				logger.info("\nChoose your option");
				logger.info("1. Add Surveyor");
				logger.info("2. Add Respondent");
				logger.info("3. Login as Surveyor");
				logger.info("4. Login as Respondent");
				logger.info("5. Services");
				logger.info("6. logout");
				AdminController.callingTryCatchBlock();
			} while (flag1);
			return true;
		} else {
			logger.error("Invalid username or password !");
			return false;
		}
	}
}
