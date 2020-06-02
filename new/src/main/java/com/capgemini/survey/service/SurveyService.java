package com.capgemini.survey.service;

import java.util.List;

import com.capgemini.survey.beans.SurveyInfoBean;

public interface SurveyService {

	public SurveyInfoBean serviceGetSurvey(String surveyTitle);

	public boolean serviceAddSurvey(SurveyInfoBean surveyInfoBean);

	public boolean serviceUpdateSurvey(String surveyTitle, SurveyInfoBean surveyInfoBean);

	public boolean serviceDeleteSurvey(String surveyTitle);

	public List<SurveyInfoBean> serviceGetAllSurveys();

	public List<String> serviceGetListOfTitle();

	public boolean serviceSearchSurvey(String surveyTitle);
	
	public boolean serviceSearchSurvey1(String surveyTitle);
	
	public boolean serviceCompareDistribution();
}
