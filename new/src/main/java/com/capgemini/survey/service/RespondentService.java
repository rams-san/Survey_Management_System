package com.capgemini.survey.service;

import java.time.LocalDate;
import java.util.List;
import com.capgemini.survey.beans.RespondentInfoBean;

public interface RespondentService {
	public boolean serviceLoginRespondent(String userName, String password);

	public RespondentInfoBean serviceGetRespondent(int respondentId);

	public boolean serviceAddRespondent(int respondentId, String respondentName, String respondentEmail, String respondentUserName, String respondentPassword, LocalDate respondentDob);

	public boolean serviceUpdateRespondent(int respondentId, String respondentName, String respondentEmail, String respondentUserName, String respondentPassword, LocalDate respondentDob);

	public boolean serviceDeleteRespondent(int respondentId);

	public List<RespondentInfoBean> serviceGetAllRespondents();
	
	public boolean serviceSearchRespondent(int respondentId);
	
	public boolean serviceSearchRespondent1(int respondentId);
	
	public boolean serviceSearchRespondent2(int respondentId);
	
	public boolean serviceValidRespondent(String userName, int respondId);
}
