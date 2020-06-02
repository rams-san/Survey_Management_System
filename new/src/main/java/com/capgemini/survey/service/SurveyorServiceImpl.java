package com.capgemini.survey.service;

import java.time.LocalDate;
import java.util.List;
import com.capgemini.survey.beans.SurveyorInfoBean;
import com.capgemini.survey.dao.SurveyorDao;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;

public class SurveyorServiceImpl implements SurveyorService {
	InputValidations inputValidation = Factory.getInputValidationInstance();

	@Override
	public boolean serviceLoginSurveyor(String userName, String password) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		return surveyorDao.loginSurveyor(userName, password);	
	}

	@Override
	public SurveyorInfoBean serviceGetSurveyor(int surveyorId) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		return surveyorDao.getSurveyor(surveyorId);	
	}

	@Override
	public boolean serviceAddSurveyor(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName, String surveyorPassword, LocalDate surveyorDob) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		return surveyorDao.addSurveyor(surveyorId, surveyorName, surveyorEmail, surveyorUserName, surveyorPassword, surveyorDob);	
	}

	@Override
	public boolean serviceUpdateSurveyor(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName, String surveyorPassword, LocalDate surveyorDob) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		return surveyorDao.updateSurveyor(surveyorId, surveyorName, surveyorEmail, surveyorUserName, surveyorPassword, surveyorDob);		
	}

	@Override
	public boolean serviceDeleteSurveyor(int surveyorId) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		return surveyorDao.deleteSurveyor(surveyorId);	
	}

	@Override
	public List<SurveyorInfoBean> serviceGetAllSurveyors() {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		return surveyorDao.getAllSurveyors();		
	}

	@Override
	public boolean serviceSearchSurveyor(int surveyorId) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		return surveyorDao.searchSurveyor(surveyorId);	
	}

	@Override
	public boolean serviceSearchSurveyor1(int surveyorId) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		return surveyorDao.searchSurveyor1(surveyorId);		
	}
}
