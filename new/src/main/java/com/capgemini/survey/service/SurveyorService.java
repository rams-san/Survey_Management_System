package com.capgemini.survey.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.survey.beans.SurveyorInfoBean;

public interface SurveyorService {
	public boolean serviceLoginSurveyor(String userName, String password);

	public SurveyorInfoBean serviceGetSurveyor(int surveyorId);

	public boolean serviceAddSurveyor(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName, String surveyorPassword, LocalDate surveyorDob);
	
	public boolean serviceUpdateSurveyor(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName, String surveyorPassword, LocalDate surveyorDob);

	public boolean serviceDeleteSurveyor(int surveyorId);

	public List<SurveyorInfoBean> serviceGetAllSurveyors();
	
	public boolean serviceSearchSurveyor(int surveyorId);
	
	public boolean serviceSearchSurveyor1(int surveyorId);
}
