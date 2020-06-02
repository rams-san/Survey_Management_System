package com.capgemini.survey.service;

import java.util.List;
import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.dao.SurveyDao;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;

public class SurveyServiceImpl implements SurveyService {
	InputValidations inputValidation = Factory.getInputValidationInstance();

	@Override
	public SurveyInfoBean serviceGetSurvey(String surveyTitle) {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		return surveyDao.getSurvey(surveyTitle);
	}

	@Override
	public boolean serviceAddSurvey(SurveyInfoBean surveyInfoBean) {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		surveyDao.addSurvey(surveyInfoBean);
		return true;
	}

	@Override
	public boolean serviceUpdateSurvey(String surveyTitle, SurveyInfoBean surveyInfoBean) {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		surveyDao.updateSurvey(surveyTitle, surveyInfoBean);
		return true;
	}

	@Override
	public boolean serviceDeleteSurvey(String surveyTitle) {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		return surveyDao.deleteSurvey(surveyTitle);	
	}

	@Override
	public List<SurveyInfoBean> serviceGetAllSurveys() {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		return surveyDao.getAllSurveys();	
	}

	@Override
	public List<String> serviceGetListOfTitle() {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		return surveyDao.getListOfTitle();		
	}

	@Override
	public boolean serviceSearchSurvey(String surveyTitle) {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		return surveyDao.searchSurvey(surveyTitle);		
	}

	@Override
	public boolean serviceSearchSurvey1(String surveyTitle) {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		return surveyDao.searchSurvey1(surveyTitle);		
	}

	@Override
	public boolean serviceCompareDistribution() {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		return surveyDao.compareDistribution();
	}
}
