package com.capgemini.survey.service;

import java.util.List;
import java.util.Map;
import com.capgemini.survey.beans.RespondInfoBean;

public interface RespondService {
	public boolean serviceDistributeSurvey(int respondId, String respondTitle);

	public boolean serviceRespondToSurvey(int respondId, int option1, RespondInfoBean respondInfoBean);

	public List<RespondInfoBean> serviceGetAllResponds();

	public Map<Integer, String> serviceGetRespondedList();

	public Map<Integer, String> serviceGetPendingRespondList();

	public List<RespondInfoBean> serviceGetRespondedRecord();

	public List<RespondInfoBean> serviceGetPendingRecord();

	public boolean serviceSearchRespondId(int respondId);

	public List<String> serviceSearchRespondId1(int respondId);
	
	public List<String> getRespondQuestion(List<String> respondTitleList1, int option1);
}
