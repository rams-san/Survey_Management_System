package com.capgemini.survey.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.exceptions.InvalidChoiceException;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.exceptions.SurveyAlreadyExistsException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.service.RespondService;
import com.capgemini.survey.service.RespondentService;
import com.capgemini.survey.service.SurveyService;
import com.capgemini.survey.service.SurveyorService;
import com.capgemini.survey.validations.InputValidations;

public class AdminServicesController {
	private AdminServicesController() {

	}

	static InputValidations inputValidation = Factory.getInputValidationInstance();
	static String userNameStatement = "Please enter valid username ";
	static String passwordStatement = "Please enter valid Password ";
	static String dateStatement = "Please enter valid date of birth ";
	static String questionStatement = "Please enter valid question ";
	static String answerStatement = "Please enter valid answer ";
	static String listStatement = "\nlist is empty.";
	static boolean flag4 = true;
	static Scanner sc = MainController.sc;
	static Logger logger = MainController.logger;

	public static boolean callingUpdateSurveyor() {
		SurveyorService surveyorService2 = Factory.getSurveyorServiceInstance();
		logger.info("Enter Surveyor ID (range:00-9999) :");
		String surveyorId6 = sc.next();

		while (!inputValidation.idValidation(surveyorId6)) {
			logger.info("Please Enter Valid surveyor ID ");
			surveyorId6 = sc.next();
		}
		int surveyorId7 = Integer.parseInt(surveyorId6);
		if (surveyorService2.serviceSearchSurveyor1(surveyorId7)) {
			logger.info("Update Surveyor Name :");
			sc.nextLine();
			String surveyorName1 = sc.nextLine();
			while (!inputValidation.nameValidation(surveyorName1)) {
				logger.info("Please enter valid name ");
				surveyorName1 = sc.nextLine();
			}

			logger.info("Update Surveyor Email (e.g ramsan11@gmail.com) :");
			String surveyorEmail1 = sc.next();
			while (!inputValidation.emailValidation(surveyorEmail1)) {
				logger.info("Please enter valid email ");
				surveyorEmail1 = sc.next();
			}

			logger.info("Update Surveyor UserName (e.g rams_san11):");
			String surveyorUserName1 = sc.next();
			while (!inputValidation.userNameValidation(surveyorUserName1)) {
				logger.info(userNameStatement);
				surveyorUserName1 = sc.next();
			}

			logger.info("Update Surveyor Password (e.g Sa*@#$%!11):");
			String surveyorPassword1 = sc.next();
			while (!inputValidation.passwordValidation(surveyorPassword1)) {
				logger.info(passwordStatement);
				surveyorPassword1 = sc.next();
			}

			logger.info("Update Surveyor Date of birth (e.g yyyy/mm/dd):");
			String date = sc.next();
			while (!inputValidation.localDateValidation(date)) {
				logger.info(dateStatement);
				date = sc.next();
			}
			LocalDate surveyorDob1 = LocalDate.parse(date);
			surveyorService2.serviceUpdateSurveyor(surveyorId7, surveyorName1, surveyorEmail1, surveyorUserName1,
					surveyorPassword1, surveyorDob1);
			logger.info("\nSurveyor Updated !!");
		}
		return false;
	}

	public static boolean callingUpdateRespondent() {
		RespondentService respondentService2 = Factory.getRespondentServiceInstance();
		logger.info("Enter Respondent ID (range:00-9999):");
		String respondentId6 = sc.next();

		while (!inputValidation.idValidation(respondentId6)) {
			logger.info("Please Enter Valid respondent ID ");
			respondentId6 = sc.next();
		}
		int respondentId7 = Integer.parseInt(respondentId6);

		if (respondentService2.serviceSearchRespondent1(respondentId7)) {
			logger.info("Update Respondent Name :");
			sc.nextLine();
			String respondentName1 = sc.nextLine();
			while (!inputValidation.nameValidation(respondentName1)) {
				logger.info("Please enter valid name ");
				respondentName1 = sc.nextLine();
			}

			logger.info("Update Respondent Email (e.g ramsan11@gmail.com):");
			String respondentEmail1 = sc.next();

			while (!inputValidation.emailValidation(respondentEmail1)) {
				logger.info("Please enter valid email ");
				respondentEmail1 = sc.nextLine();
			}

			logger.info("Update Respondent UserName (e.g rams_san11):");
			String respondentUserName1 = sc.next();
			while (!inputValidation.userNameValidation(respondentUserName1)) {
				logger.info(userNameStatement);
				respondentUserName1 = sc.next();
			}

			logger.info("Update Respondent Password (e.g Sa*@#$%!11):");
			String respondentPassword1 = sc.next();
			while (!inputValidation.passwordValidation(respondentPassword1)) {
				logger.info(passwordStatement);
				respondentPassword1 = sc.next();
			}

			logger.info("Update Respondent Date of birth (e.g yyyy/mm/dd):");
			String date1 = sc.next();
			while (!inputValidation.localDateValidation(date1)) {
				logger.info(dateStatement);
				date1 = sc.next();
			}
			LocalDate respondentDob1 = LocalDate.parse(date1);
			respondentService2.serviceUpdateRespondent(respondentId7, respondentName1, respondentEmail1,
					respondentUserName1, respondentPassword1, respondentDob1);
			logger.info("\nRespondent Updated !!");
		}
		return false;
	}

	public static boolean callingDeleteSurveyor() {
		logger.info("Enter Surveyor Id : ");
		String surveyorId2 = sc.next();
		while (!inputValidation.idValidation(surveyorId2)) {
			logger.info("Please enter valid surveyor id : ");
			surveyorId2 = sc.next();
		}
		int surveyorId3 = Integer.parseInt(surveyorId2);
		SurveyorService surveyorService3 = Factory.getSurveyorServiceInstance();
		if (surveyorService3.serviceDeleteSurveyor(surveyorId3)) {
			logger.info("\nData deleted.");
		}
		return false;
	}

	public static boolean callingDeleteRespondent() {
		logger.info("Enter Respondent Id : ");
		String respondentId2 = sc.next();
		while (!inputValidation.idValidation(respondentId2)) {
			logger.info("Please enter valid respondent id : ");
			respondentId2 = sc.next();
		}
		int respondentId3 = Integer.parseInt(respondentId2);
		RespondentService respondentService3 = Factory.getRespondentServiceInstance();
		if (respondentService3.serviceDeleteRespondent(respondentId3)) {
			logger.info("\nData deleted.");
		}
		return false;
	}

	public static boolean callingGetSurveyorDetails() {
		logger.info("Enter Surveyor Id : ");
		String surveyorId4 = sc.next();
		while (!inputValidation.idValidation(surveyorId4)) {
			logger.info("Please enter valid surveyor id : ");
			surveyorId4 = sc.next();
		}
		int surveyorId5 = Integer.parseInt(surveyorId4);
		SurveyorService surveyorService4 = Factory.getSurveyorServiceInstance();
		if (surveyorService4.serviceGetSurveyor(surveyorId5) != null) {
			logger.info("\nSurveyor Found");
			logger.info("\nGetting surveyor details !!");
			logger.info("\n" + surveyorService4.serviceGetSurveyor(surveyorId5));
		}
		return false;
	}

	public static boolean callingGetRespondentDetails() {
		logger.info("Enter Respondent Id : ");
		String respondentId4 = sc.next();
		while (!inputValidation.idValidation(respondentId4)) {
			logger.info("Please enter valid respondent id : ");
			respondentId4 = sc.next();
		}
		int respondentId5 = Integer.parseInt(respondentId4);
		RespondentService respondentService4 = Factory.getRespondentServiceInstance();
		if (respondentService4.serviceGetRespondent(respondentId5) != null) {
			logger.info("\nRespondent found !!");
			logger.info("\nGetting respondent details !!");
			logger.info("\n" + respondentService4.serviceGetRespondent(respondentId5));
		}
		return false;
	}

	public static boolean callingGetAllSurveyorsDetails() {
		SurveyorService surveyorService5 = Factory.getSurveyorServiceInstance();
		if (!surveyorService5.serviceGetAllSurveyors().isEmpty()) {
			logger.info("Details of all Surveyors !!");
			logger.info("\n" + surveyorService5.serviceGetAllSurveyors());
		} else {
			logger.info("Surveyors table is empty !!");
		}
		return false;
	}

	public static boolean callingGetAllRespondentsDetails() {
		RespondentService respondentService5 = Factory.getRespondentServiceInstance();
		if (!respondentService5.serviceGetAllRespondents().isEmpty()) {
			logger.info("Details of all Respondents !!");
			logger.info("\n" + respondentService5.serviceGetAllRespondents());
		} else {
			logger.info("Respondents table is empty !!");
		}
		return false;
	}

	public static boolean callingCreateSurvey() {
		SurveyInfoBean surveyInfoBean = Factory.getSurveyInfoBeanInstance();
		SurveyService surveyService = Factory.getSurveyServiceInstance();
		logger.info("Enter Survey Title :");
		sc.nextLine();
		String surveyTitle = sc.nextLine();
		while (!inputValidation.titleValidation(surveyTitle)) {
			logger.error("please enter valid survey title");
			surveyTitle = sc.nextLine();
		}

		if (surveyService.serviceSearchSurvey(surveyTitle)) {
			logger.info("Enter Survey Description :");
			String surveyDescription = sc.nextLine();

			while (!inputValidation.descriptionValidation(surveyDescription)) {
				logger.error("please enter valid survey description");
				surveyDescription = sc.nextLine();
			}

			logger.info("Enter Survey Question no 1 :");
			String surveyQuestion1 = AdminServicesController.callingValidateQuestion();
			
			logger.info("Enter Survey Question no 2 :");
			String surveyQuestion2 = AdminServicesController.callingValidateQuestion();

			logger.info("Enter Survey Question no 3 :");
			String surveyQuestion3 = AdminServicesController.callingValidateQuestion();

			logger.info("Enter Survey Question no 4 :");
			String surveyQuestion4 = AdminServicesController.callingValidateQuestion();

			logger.info("Enter Survey Question no 5 :");
			String surveyQuestion5 = AdminServicesController.callingValidateQuestion();

			logger.info("Enter Survey Question no 6 :");
			String surveyQuestion6 = AdminServicesController.callingValidateQuestion();

			logger.info("Enter Survey Question no 7 :");
			String surveyQuestion7 = AdminServicesController.callingValidateQuestion();

			logger.info("Enter Survey Question no 8 :");
			String surveyQuestion8 = AdminServicesController.callingValidateQuestion();

			logger.info("Enter Survey Question no 9 :");
			String surveyQuestion9 = AdminServicesController.callingValidateQuestion();

			logger.info("Enter Survey Question no 10 :");
			String surveyQuestion10 = AdminServicesController.callingValidateQuestion();

			surveyInfoBean.setSurveyTitle(surveyTitle);
			surveyInfoBean.setSurveyDescription(surveyDescription);
			surveyInfoBean.setSurveyQuestion1(surveyQuestion1);
			surveyInfoBean.setSurveyQuestion2(surveyQuestion2);
			surveyInfoBean.setSurveyQuestion3(surveyQuestion3);
			surveyInfoBean.setSurveyQuestion4(surveyQuestion4);
			surveyInfoBean.setSurveyQuestion5(surveyQuestion5);
			surveyInfoBean.setSurveyQuestion6(surveyQuestion6);
			surveyInfoBean.setSurveyQuestion7(surveyQuestion7);
			surveyInfoBean.setSurveyQuestion8(surveyQuestion8);
			surveyInfoBean.setSurveyQuestion9(surveyQuestion9);
			surveyInfoBean.setSurveyQuestion10(surveyQuestion10);
			surveyService.serviceAddSurvey(surveyInfoBean);
			logger.info("\nSurvey created successfully !!");
		}
		return false;
	}

	public static boolean callingUpdateSurvey() {
		SurveyInfoBean surveyInfoBean1 = Factory.getSurveyInfoBeanInstance();
		SurveyService surveyService1 = Factory.getSurveyServiceInstance();
		logger.info("Enter Survey Title :");
		sc.nextLine();
		String surveyTitle1 = sc.nextLine();

		while (!inputValidation.titleValidation(surveyTitle1)) {
			logger.info("Please Enter Valid survey title ");
			surveyTitle1 = sc.nextLine();
		}
		if (surveyService1.serviceCompareDistribution()) {
			if (surveyService1.serviceSearchSurvey1(surveyTitle1)) {
				logger.info("Update Survey Description :");
				String surveyDescription1 = sc.nextLine();
				while (!inputValidation.descriptionValidation(surveyDescription1)) {
					logger.info("Please enter valid survey description ");
					surveyDescription1 = sc.nextLine();
				}

				logger.info("Update Survey Question no 1 :");
				String surveyQuestion11 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 2 :");
				String surveyQuestion22 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 3 :");
				String surveyQuestion33 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 4 :");
				String surveyQuestion44 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 5 :");
				String surveyQuestion55 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 6 :");
				String surveyQuestion66 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 7 :");
				String surveyQuestion77 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 8 :");
				String surveyQuestion88 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 9 :");
				String surveyQuestion99 = AdminServicesController.callingValidateQuestion();

				logger.info("Update Survey Question no 10 :");
				String surveyQuestion1010 = AdminServicesController.callingValidateQuestion();

				surveyInfoBean1.setSurveyDescription(surveyDescription1);
				surveyInfoBean1.setSurveyQuestion1(surveyQuestion11);
				surveyInfoBean1.setSurveyQuestion2(surveyQuestion22);
				surveyInfoBean1.setSurveyQuestion3(surveyQuestion33);
				surveyInfoBean1.setSurveyQuestion4(surveyQuestion44);
				surveyInfoBean1.setSurveyQuestion5(surveyQuestion55);
				surveyInfoBean1.setSurveyQuestion6(surveyQuestion66);
				surveyInfoBean1.setSurveyQuestion7(surveyQuestion77);
				surveyInfoBean1.setSurveyQuestion8(surveyQuestion88);
				surveyInfoBean1.setSurveyQuestion9(surveyQuestion99);
				surveyInfoBean1.setSurveyQuestion10(surveyQuestion1010);
				surveyService1.serviceUpdateSurvey(surveyTitle1, surveyInfoBean1);
				logger.info("\nSurvey Updated !!");
			}
		} else {
			logger.info("\nThis survey is ditributed you can't update it.");
		}
		return false;
	}

	public static boolean callingDeleteSurvey() {
		logger.info("Enter Survey Title : ");
		sc.nextLine();
		String surveyTitle2 = sc.nextLine();
		while (!inputValidation.titleValidation(surveyTitle2)) {
			logger.info("Please enter valid survey title : ");
			surveyTitle2 = sc.next();
		}
		SurveyService surveyService2 = Factory.getSurveyServiceInstance();
		if (surveyService2.serviceDeleteSurvey(surveyTitle2)) {
			logger.info("\nData deleted");
		}
		return false;
	}

	public static boolean callingGetSurveyDetails() {
		logger.info("Enter Survey Title : ");
		sc.nextLine();
		String surveyTitle3 = sc.nextLine();
		while (!inputValidation.titleValidation(surveyTitle3)) {
			logger.info("Please enter valid survey title : ");
			surveyTitle3 = sc.next();
		}
		SurveyService surveyService3 = Factory.getSurveyServiceInstance();
		surveyService3.serviceGetSurvey(surveyTitle3);
		if (surveyService3.serviceGetSurvey(surveyTitle3) != null) {
			logger.info("\nSurvey Found");
			logger.info("\nGetting survey details !!");
			logger.info("\n" + surveyService3.serviceGetSurvey(surveyTitle3));
		}
		return false;
	}

	public static boolean callingGetAllSurveysDetails() {
		SurveyService surveyService4 = Factory.getSurveyServiceInstance();
		if (!surveyService4.serviceGetAllSurveys().isEmpty()) {
			logger.info("\nDetails of all Surveys !!");
			logger.info("\n" + surveyService4.serviceGetAllSurveys());
		} else {
			logger.info("Surveys table is empty !!");
		}
		return false;
	}

	public static boolean callingDistributeSurvey() {
		RespondService respondService1 = Factory.getRespondServiceInstance();
		logger.info("\nEnter respondent Id to assign surveys :");
		String respondId1 = sc.next();
		while (!inputValidation.idValidation(respondId1)) {
			logger.error("please enter valid respond id");
			respondId1 = sc.next();
		}
		int respondId = Integer.parseInt(respondId1);

		if (respondService1.serviceSearchRespondId(respondId)) {
			logger.info("\nRespondId is added");
			logger.info("\nList of Survey Titles : \n");
			SurveyService surveyService5 = Factory.getSurveyServiceInstance();
			int n = 0;
			ArrayList<String> list = new ArrayList<>();
			list.addAll(surveyService5.serviceGetListOfTitle());
			for (int i = 0; i < list.size(); i++) {
				n++;
				logger.info(n + "." + list.get(i));
			}
			logger.info("\nNow enter survey title from above list to distribute to the respondent :");
			sc.nextLine();
			String respondTitle = sc.nextLine();
			while (!inputValidation.titleValidation(respondTitle)) {
				logger.info("Please enter valid title name ");
				respondTitle = sc.nextLine();
			}
			respondService1.serviceDistributeSurvey(respondId, respondTitle);
			logger.info("\nSurvey distributed !!\n");
		}
		return false;
	}

	public static boolean callingRecordOfRespondedSurveys() {
		RespondService respondService2 = Factory.getRespondServiceInstance();
		if (!respondService2.serviceGetRespondedRecord().isEmpty()) {
			logger.info("\nRecord of Responded Survey :\n");
			logger.info("\n" + respondService2.serviceGetRespondedRecord());
		} else {
			logger.info(listStatement);
		}
		return false;
	}

	public static boolean callingRecordOfPendingSurveys() {
		RespondService respondService3 = Factory.getRespondServiceInstance();
		if (!respondService3.serviceGetPendingRecord().isEmpty()) {
			logger.info("\nRecord of Responded Survey :\n");
			logger.info("\n" + respondService3.serviceGetPendingRecord());
		} else {
			logger.info(listStatement);
		}
		return false;
	}

	public static boolean callingRespondedToASurvey() {
		RespondInfoBean respondInfoBean = Factory.getRespondInfoBeanInstance();
		RespondService respondService4 = Factory.getRespondServiceInstance();
		logger.info("Enter your ID to respond :");
		String respondId2 = sc.next();

		while (!inputValidation.idValidation(respondId2)) {
			logger.info("Please Enter Valid respondent ID ");
			respondId2 = sc.next();
		}
		int respondId3 = Integer.parseInt(respondId2);
		if (!respondService4.serviceSearchRespondId1(respondId3).isEmpty()) {
			List<String> respondList1 = new ArrayList<>();
			int n = 0;
			respondList1.addAll(respondService4.serviceSearchRespondId1(respondId3));
			for (int i = 0; i < respondList1.size(); i++) {
				n++;
				logger.info(n + "." + respondList1.get(i));
			}
			logger.info("\nChoose your option to respond : \n");
			String option = sc.next();

			while (!inputValidation.choice5Validation(option)) {
				logger.info("Please Enter Valid responding title ");
				option = sc.next();
			}
			int option1 = Integer.parseInt(option);
			option1--;

			List<String> questionList = new ArrayList<>();
			questionList.addAll(respondService4.getRespondQuestion(respondList1, option1));

			logger.info("\n" + questionList.get(0));
			sc.nextLine();
			String answer1 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(1));
			String answer2 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(2));
			String answer3 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(3));
			String answer4 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(4));
			String answer5 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(5));
			String answer6 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(6));
			String answer7 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(7));
			String answer8 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(8));
			String answer9 = AdminServicesController.callingValidateAnswer();

			logger.info("\n" + questionList.get(9));
			String answer10 = AdminServicesController.callingValidateAnswer();

			option1++;
			respondInfoBean.setRespondAnswer1(answer1);
			respondInfoBean.setRespondAnswer2(answer2);
			respondInfoBean.setRespondAnswer3(answer3);
			respondInfoBean.setRespondAnswer4(answer4);
			respondInfoBean.setRespondAnswer5(answer5);
			respondInfoBean.setRespondAnswer6(answer6);
			respondInfoBean.setRespondAnswer7(answer7);
			respondInfoBean.setRespondAnswer8(answer8);
			respondInfoBean.setRespondAnswer9(answer9);
			respondInfoBean.setRespondAnswer10(answer10);
			respondService4.serviceRespondToSurvey(respondId3, option1, respondInfoBean);
			logger.info("\nRespond recorded successfully !!");
		}
		return false;
	}

	public static boolean callingListOfRespondedSurveys() {
		RespondService respondService7 = Factory.getRespondServiceInstance();
		if (respondService7.serviceGetRespondedList() != null) {
			int i = 1;
			logger.info("\nList of Responded survey with Id and Titles :\n");
			Map<Integer, String> hashMap1 = new HashMap<>();
			hashMap1.putAll(respondService7.serviceGetRespondedList());
			for (Map.Entry<Integer, String> map : hashMap1.entrySet()) {
				logger.info(i + ". " + map.getKey() + "," + map.getValue());
			}
		} else {
			logger.info(listStatement);
		}
		return false;
	}

	public static boolean callingListOfPendingSurveys() {
		RespondService respondService8 = Factory.getRespondServiceInstance();
		if (respondService8.serviceGetPendingRespondList() != null) {
			int i = 1;
			logger.info("\nList of Pending survey with Id and Titles :\n");
			Map<Integer, String> hashMap2 = new HashMap<>();
			hashMap2.putAll(respondService8.serviceGetPendingRespondList());
			for (Map.Entry<Integer, String> map : hashMap2.entrySet()) {
				logger.info(i + ". " + map.getKey() + "," + map.getValue());
			}
		} else {
			logger.info(listStatement);
		}
		return false;
	}

	public static boolean callingRecordOfRespondedAndPendingSurveys() {
		RespondService respondService9 = Factory.getRespondServiceInstance();
		if (!respondService9.serviceGetAllResponds().isEmpty()) {
			logger.info("Details of all responded and pending responds !!");
			logger.info("\n" + respondService9.serviceGetAllResponds());
		} else {
			logger.info("Respond table is empty !!");
		}
		return false;
	}

	public static String callingValidateQuestion() {
		String question = sc.nextLine();
		while (!inputValidation.questionValidation(question)) {
			logger.info(questionStatement);
			question = sc.nextLine();
		}
		return question;
	}

	public static String callingValidateAnswer() {
		String answer = sc.nextLine();
		while (!inputValidation.answerValidation(answer)) {
			logger.info(answerStatement);
			answer = sc.nextLine();
		}
		return answer;
	}
	
	public static boolean callingAdminServicesController() {

		do {
			logger.info("\nInside Admin Services");
			logger.info("\nChoose your option");
			logger.info("1. Update Surveyor");
			logger.info("2. Update Respondent");
			logger.info("3. Delete Surveyor");
			logger.info("4. Delete Respondent");
			logger.info("5. Get Surveyor Details");
			logger.info("6. Get Respondent Details");
			logger.info("7. Get All Surveyors Details");
			logger.info("8. Get All Respondents Details");
			logger.info("9. Create Survey");
			logger.info("10. Update Survey");
			logger.info("11. Delete Survey");
			logger.info("12. Get Survey Details");
			logger.info("13. Get All Surveys Details");
			logger.info("14. Distribute Surveys");
			logger.info("15. Record of Responded surveys");
			logger.info("16. Record of Pending surveys");
			logger.info("17. Respond to a survey");
			logger.info("18. List of responded surveys");
			logger.info("19. List of pending surveys");
			logger.info("20. Record of responded and pending surveys");
			logger.info("21. Exit");
			String choice4 = sc.next();
			try {
				while (!inputValidation.choice4Validation(choice4)) {
					throw new InvalidChoiceException("Choice doesn't exists");
				}
				int switchChoice4 = Integer.parseInt(choice4);
				switch (switchChoice4) {
				case 1:
					AdminServicesController.callingUpdateSurveyor();
					break;
				case 2:
					AdminServicesController.callingUpdateRespondent();
					break;
				case 3:
					AdminServicesController.callingDeleteSurveyor();
					break;
				case 4:
					AdminServicesController.callingDeleteRespondent();
					break;
				case 5:
					AdminServicesController.callingGetSurveyorDetails();
					break;
				case 6:
					AdminServicesController.callingGetRespondentDetails();
					break;
				case 7:
					AdminServicesController.callingGetAllSurveyorsDetails();
					break;
				case 8:
					AdminServicesController.callingGetAllRespondentsDetails();
					break;
				case 9:
					AdminServicesController.callingCreateSurvey();
					break;
				case 10:
					AdminServicesController.callingUpdateSurvey();
					break;
				case 11:
					AdminServicesController.callingDeleteSurvey();
					break;
				case 12:
					AdminServicesController.callingGetSurveyDetails();
					break;
				case 13:
					AdminServicesController.callingGetAllSurveysDetails();
					break;
				case 14:
					AdminServicesController.callingDistributeSurvey();
					break;
				case 15:
					AdminServicesController.callingRecordOfRespondedSurveys();
					break;
				case 16:
					AdminServicesController.callingRecordOfPendingSurveys();
					break;
				case 17:
					AdminServicesController.callingRespondedToASurvey();
					break;
				case 18:
					AdminServicesController.callingListOfRespondedSurveys();
					break;
				case 19:
					AdminServicesController.callingListOfPendingSurveys();
					break;
				case 20:
					AdminServicesController.callingRecordOfRespondedAndPendingSurveys();
					break;
				case 21:
					logger.info("\nExited from Admin Services");
					flag4 = false;
					break;
				default:
					flag4 = false;
					logger.info("Please enter correct option :");
				}
			} catch (NotFoundException e) {
				String s = e.getMessage();
				logger.error(s);
			} catch (InvalidChoiceException e1) {
				String s = e1.getMessage();
				logger.error(s);
			} catch (SurveyAlreadyExistsException e2) {
				String s = e2.getMessage();
				logger.error(s);
			}
		} while (flag4);
		return false;
	}
}
