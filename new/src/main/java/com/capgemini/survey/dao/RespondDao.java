package com.capgemini.survey.dao;

import java.util.List;
import java.util.Map;
import com.capgemini.survey.beans.RespondInfoBean;

public interface RespondDao {
	public Map<Integer, String> getRespondedList();

	public List<RespondInfoBean> getRespondedRecord();

	public List<RespondInfoBean> getPendingRecord();

	public Map<Integer, String> getPendingRespondList();

	public boolean distributeSurvey(int respondId, String respondTitle);

	public boolean respondToSurvey(int respondId, int option1, RespondInfoBean respondInfoBean);

	public List<RespondInfoBean> getAllResponds();

	public boolean searchRespondId(int respondId);

	public List<String> searchRespondId1(int respondId);
	
	public List<String> getListOfRespondTitle(); 
	
	public List<String> getRespondQuestion(List<String> respondTitleList1,int option1);

}
