package com.capgemini.survey.service;

import java.util.List;
import java.util.Map;
import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.dao.RespondDao;
import com.capgemini.survey.factory.Factory;

public class RespondServiceImpl implements RespondService {

	@Override
	public boolean serviceDistributeSurvey(int respondId, String respondTitle) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.distributeSurvey(respondId, respondTitle);
	}

	@Override
	public boolean serviceRespondToSurvey(int respondId, int option1, RespondInfoBean respondInfoBean) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.respondToSurvey(respondId, option1, respondInfoBean);
	}

	@Override
	public List<RespondInfoBean> serviceGetAllResponds() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.getAllResponds();
	}

	@Override
	public Map<Integer, String> serviceGetRespondedList() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.getRespondedList();
	}

	@Override
	public Map<Integer, String> serviceGetPendingRespondList() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.getPendingRespondList();
	}

	@Override
	public List<RespondInfoBean> serviceGetRespondedRecord() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.getRespondedRecord();
	}

	@Override
	public List<RespondInfoBean> serviceGetPendingRecord() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.getPendingRecord();
	}

	@Override
	public boolean serviceSearchRespondId(int respondId) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.searchRespondId(respondId);
	}

	@Override
	public List<String> serviceSearchRespondId1(int respondId) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.searchRespondId1(respondId);
	}

	@Override
	public List<String> getRespondQuestion(List<String> respondTitleList1, int option1) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		return respondDao.getRespondQuestion(respondTitleList1, option1);
	}
}
