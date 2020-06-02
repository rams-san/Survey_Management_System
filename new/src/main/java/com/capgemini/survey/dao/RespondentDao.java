package com.capgemini.survey.dao;

import java.time.LocalDate;
import java.util.List;
import com.capgemini.survey.beans.RespondentInfoBean;


public interface RespondentDao {
	public boolean loginRespondent(String userName, String password);
	
	public RespondentInfoBean getRespondent(int respondentId);

	public boolean addRespondent(int respondentId, String respondentName, String respondentEmail, String respondentUserName, String respondentPassword, LocalDate respondentDob);

	public boolean updateRespondent(int respondentId, String respondentName, String respondentEmail, String respondentUserName, String respondentPassword, LocalDate respondentDob);

	public boolean deleteRespondent(int respondentId);

	public List<RespondentInfoBean> getAllRespondents();
	
	public boolean searchRespondent(int respondentId);
	
	public boolean searchRespondent1(int respondentId);
	
	public boolean searchRespondent2(int respondentId);
	
	public boolean validRespondent(String userName, int respondId);
}
