package com.capgemini.survey.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;
import com.capgemini.survey.exceptions.InvalidChoiceException;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.exceptions.RespondAlreadyExistsException;
import com.capgemini.survey.exceptions.RespondentAlreadyExistsException;
import com.capgemini.survey.exceptions.SurveyorAlreadyExistsException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.repository.RepositoryMethods;
import com.capgemini.survey.validations.InputValidations;

/**
 * The SurveyController program implements an application that executes survey
 * management system.
 * 
 * @author Suyash
 * 
 */
public class MainController {
	public static final org.apache.log4j.Logger logger = Logger.getLogger(MainController.class);
	public static final Scanner sc = new Scanner(System.in);

	/**
	 * This is the main method.
	 * 
	 * @param args Unused.
	 * @return Nothing.
	 * @exception NotFoundException                on input error.
	 * @exception InvalidChoiceException           on input error.
	 * @exception SurveyorAlreadyExistsException   on input error.
	 * @exception RespondentAlreadyExistsException on input error.
	 * @exception RespondAlreadyExistsException    on input error.
	 * @see NotFoundException.
	 * @see InvalidChoiceException.
	 * @see SurveyorAlreadyExistsException.
	 * @see RespondentAlreadyExistsException.
	 * @see RespondAlreadyExistsException.
	 * 
	 */
	public static void main(String[] args) {
		InputValidations inputValidation = Factory.getInputValidationInstance();
		boolean flag = true;
		Scanner sc = MainController.sc;
		do {
			PropertiesController.callingProperties();
			RepositoryMethods.callingRepositoryMethods();
			logger.info("\n Choose your option");
			logger.info("1. Admin Login");
			logger.info("2. Exit");
			String choice = sc.next();
			try {
				while (!inputValidation.choiceValidation(choice)) {
					throw new InvalidChoiceException("Choice doesn't exists");
				}
				int switchChoice = Integer.parseInt(choice);
				switch (switchChoice) {
				case 1:
					AdminController.callingAdminController();
					break;
				case 2:
					logger.info("Exited !");
					flag = false;
					break;
				default:
					flag = false;
					logger.info("Please enter correct option :");
				}
			} catch (NotFoundException e) {
				String s = e.getMessage();
				logger.error(s);
			} catch (InvalidChoiceException e1) {
				String s = e1.getMessage();
				logger.error(s);
			}
		} while (flag);
		sc.close();
	}
}
