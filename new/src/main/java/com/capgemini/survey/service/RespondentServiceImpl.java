package com.capgemini.survey.service;

import java.time.LocalDate;
import java.util.List;
import com.capgemini.survey.beans.RespondentInfoBean;
import com.capgemini.survey.dao.RespondentDao;
import com.capgemini.survey.factory.Factory;

public class RespondentServiceImpl implements RespondentService{
	
	@Override
	public boolean serviceLoginRespondent(String userName, String password) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.loginRespondent(userName, password);		
	}

	@Override
	public RespondentInfoBean serviceGetRespondent(int respondentId) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.getRespondent(respondentId);
	}

	@Override
	public boolean serviceAddRespondent(int respondentId, String respondentName, String respondentEmail, String respondentUserName, String respondentPassword, LocalDate respondentDob) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.addRespondent(respondentId, respondentName, respondentEmail, respondentUserName, respondentPassword, respondentDob);		
	}

	@Override
	public boolean serviceUpdateRespondent(int respondentId, String respondentName, String respondentEmail, String respondentUserName, String respondentPassword, LocalDate respondentDob){
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.updateRespondent(respondentId, respondentName, respondentEmail, respondentUserName, respondentPassword, respondentDob);		
	}

	@Override
	public boolean serviceDeleteRespondent(int respondentId) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.deleteRespondent(respondentId);		
	}
	
	@Override
	public List<RespondentInfoBean> serviceGetAllRespondents() {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.getAllRespondents();		
	}

	@Override
	public boolean serviceSearchRespondent(int respondentId) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.searchRespondent(respondentId);			
	}

	@Override
	public boolean serviceSearchRespondent1(int respondentId) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.searchRespondent1(respondentId);	
	}

	@Override
	public boolean serviceSearchRespondent2(int respondentId) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.searchRespondent2(respondentId);		
	}

	@Override
	public boolean serviceValidRespondent(String userName, int respondId) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		return respondentDao.validRespondent(userName, respondId);
	}
}
