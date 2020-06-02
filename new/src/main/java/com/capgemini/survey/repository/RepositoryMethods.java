package com.capgemini.survey.repository;

import com.capgemini.survey.factory.Factory;

public class RepositoryMethods {
	private RepositoryMethods() {
	}

	public static boolean callingRepositoryMethods() {
		SurveyorRepository surveyorRepository = Factory.getSurveyorRepositoryInstance();
		surveyorRepository.surveyorTable();
		surveyorRepository.getSurveyorTable();
		RespondentRepository respondentRepository = Factory.getRespondentRepositoryInstance();
		respondentRepository.respondentTable();
		respondentRepository.getRespondentTable();
		SurveyRepository surveyRepository = Factory.getSurveyRepositoryInstance();
		surveyRepository.surveyTable();
		return true;
	}
}