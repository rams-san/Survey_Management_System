package com.capgemini.survey.dao;

import java.time.LocalDate;
import java.util.List;
import com.capgemini.survey.beans.SurveyorInfoBean;

public interface SurveyorDao {
	public boolean loginSurveyor(String userName, String password);
	
	public SurveyorInfoBean getSurveyor(int surveyorId);

	public boolean addSurveyor(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName, String surveyorPassword, LocalDate surveyorDob);
	
	public boolean updateSurveyor(int surveyorId, String surveyorName, String surveyorEmail, String surveyorUserName, String surveyorPassword, LocalDate surveyorDob);

	public boolean deleteSurveyor(int surveyorId);

	public List<SurveyorInfoBean> getAllSurveyors();
	
	public boolean searchSurveyor(int surveyorId);
	
	public boolean searchSurveyor1(int surveyorId);
}
