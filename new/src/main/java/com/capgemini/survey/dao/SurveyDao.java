package com.capgemini.survey.dao;

import java.util.List;

import com.capgemini.survey.beans.SurveyInfoBean;

public interface SurveyDao {
	public SurveyInfoBean getSurvey(String surveyTitle);

	public boolean addSurvey(SurveyInfoBean surveyInfoBean);

	public boolean updateSurvey(String surveyTitle, SurveyInfoBean surveyInfoBean);

	public boolean deleteSurvey(String surveyTitle);

	public List<SurveyInfoBean> getAllSurveys();

	public List<String> getListOfTitle();

	public List<String> getSurveyQuestions(String respondTitle);

	public boolean searchSurvey(String surveyTitle);
	
	public boolean searchSurvey1(String surveyTitle);
	
	public boolean compareDistribution();
}
