package com.capgemini.survey.factory;

import com.capgemini.survey.beans.AdminInfoBean;
import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.beans.RespondentInfoBean;
import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.beans.SurveyorInfoBean;
import com.capgemini.survey.dao.AdminDao;
import com.capgemini.survey.dao.AdminDaoImpl;
import com.capgemini.survey.dao.RespondDao;
import com.capgemini.survey.dao.RespondDaoImpl;
import com.capgemini.survey.dao.RespondentDao;
import com.capgemini.survey.dao.RespondentDaoImpl;
import com.capgemini.survey.dao.SurveyDao;
import com.capgemini.survey.dao.SurveyDaoImpl;
import com.capgemini.survey.dao.SurveyorDao;
import com.capgemini.survey.dao.SurveyorDaoImpl;
import com.capgemini.survey.repository.RespondentRepository;
import com.capgemini.survey.repository.SurveyRepository;
import com.capgemini.survey.repository.SurveyorRepository;
import com.capgemini.survey.service.AdminService;
import com.capgemini.survey.service.AdminServiceImpl;
import com.capgemini.survey.service.RespondService;
import com.capgemini.survey.service.RespondServiceImpl;
import com.capgemini.survey.service.RespondentService;
import com.capgemini.survey.service.RespondentServiceImpl;
import com.capgemini.survey.service.SurveyService;
import com.capgemini.survey.service.SurveyServiceImpl;
import com.capgemini.survey.service.SurveyorService;
import com.capgemini.survey.service.SurveyorServiceImpl;
import com.capgemini.survey.validations.InputValidations;
import com.capgemini.survey.validations.InputValidationsImpl;

public class Factory {
	private Factory() {

	}

	public static AdminInfoBean getAdminInfoBeanInstance() {
		return new AdminInfoBean();
	}

	public static AdminDao getAdminDaoInstance() {
		return new AdminDaoImpl();
	}

	public static AdminService getAdminServiceInstance() {
		return new AdminServiceImpl();
	}

	public static SurveyorInfoBean getSurveyorInfoBeanInstance() {
		return new SurveyorInfoBean();
	}

	public static SurveyorDao getSurveyorDaoInstance() {
		return new SurveyorDaoImpl();
	}

	public static SurveyorService getSurveyorServiceInstance() {
		return new SurveyorServiceImpl();
	}

	public static RespondentInfoBean getRespondentInfoBeanInstance() {
		return new RespondentInfoBean();
	}

	public static RespondentDao getRespondentDaoInstance() {
		return new RespondentDaoImpl();
	}

	public static RespondentService getRespondentServiceInstance() {
		return new RespondentServiceImpl();
	}

	public static SurveyInfoBean getSurveyInfoBeanInstance() {
		return new SurveyInfoBean();
	}

	public static SurveyDao getSurveyDaoInstance() {
		return new SurveyDaoImpl();
	}

	public static SurveyService getSurveyServiceInstance() {
		return new SurveyServiceImpl();
	}

	public static InputValidations getInputValidationInstance() {
		return new InputValidationsImpl();
	}

	public static RespondInfoBean getRespondInfoBeanInstance() {
		return new RespondInfoBean();
	}

	public static RespondDao getRespondDaoInstance() {
		return new RespondDaoImpl();
	}

	public static RespondService getRespondServiceInstance() {
		return new RespondServiceImpl();
	}

	public static SurveyRepository getSurveyRepositoryInstance() {
		return new SurveyRepository();
	}
	
	public static SurveyorRepository getSurveyorRepositoryInstance() {
		return new SurveyorRepository();
	}
	
	public static RespondentRepository getRespondentRepositoryInstance() {
		return new RespondentRepository();
	}
}
