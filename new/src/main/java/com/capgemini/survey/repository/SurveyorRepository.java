package com.capgemini.survey.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.capgemini.survey.beans.SurveyorInfoBean;

public class SurveyorRepository {
	public static final org.apache.log4j.Logger logger = Logger.getLogger(SurveyorRepository.class);

	/**
	 * This method is use to create surveyor table.
	 * 
	 * @return surveyorList
	 */
	public List<SurveyorInfoBean> surveyorTable() {
		List<SurveyorInfoBean> surveyorList = new ArrayList<>();
		surveyorList.add(new SurveyorInfoBean(1111, "Suyash", "Suyash788@gmail.com", "suyash788_Ram", "Sr@132357", LocalDate.of(1997, Month.MAY, 11)));
		surveyorList.add(new SurveyorInfoBean(2222, "Surya", "Surya0417@gmail.com", "surya45_Gattu", "gS#@*21551", LocalDate.of(1998, Month.APRIL, 17)));
		surveyorList.add(new SurveyorInfoBean(3333, "Nicks", "Nicks09@gmail.com", "nikhil_06P", "Pn@215225#*", LocalDate.of(1997, Month.JUNE, 8)));

		return surveyorList;
	}
	
	/**
	 * This method is use to print surveyor table.
	 * 
	 * @return true
	 */
	public boolean getSurveyorTable() {
		 List<SurveyorInfoBean> surveyorList1 = new SurveyorRepository().surveyorTable();
		 for (SurveyorInfoBean surveyorInfoBean4 : surveyorList1) {
				logger.info(surveyorInfoBean4);
			}
		return true;
	}
}
