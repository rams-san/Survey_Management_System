package com.capgemini.survey.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.capgemini.survey.beans.RespondentInfoBean;

public class RespondentRepository {
	public static final org.apache.log4j.Logger logger = Logger.getLogger(RespondentRepository.class);

	/**
	 * This method is use to create respondent table.
	 * 
	 * @return respondentList
	 */
	public List<RespondentInfoBean> respondentTable() {
		
		List<RespondentInfoBean> respondentList = new ArrayList<>();
		respondentList.add(new RespondentInfoBean(111, "Sneha", "Sneha05@gmail.com", "sneha0805_Ram", "SnR15@#215", LocalDate.of(1999, Month.AUGUST, 5)));
		respondentList.add(new RespondentInfoBean(222, "Akash", "AksahR17@gmail.com", "Akash1709_Ram", "aK1@#857", LocalDate.of(1996, Month.SEPTEMBER, 17)));
		respondentList.add(new RespondentInfoBean(333, "Shraddha", "ShraddhaRam03@gmail.com", "siddhi09_Ram", "riddhiSR@*9276", LocalDate.of(1999, Month.SEPTEMBER, 3)));
		return respondentList;
	}

	/**
	 * This method is use to print respondent table.
	 * 
	 * @return true
	 */
	public boolean getRespondentTable() {
		List<RespondentInfoBean> respondentList1 = new RespondentRepository().respondentTable();
		for (RespondentInfoBean respondentInfoBean4 : respondentList1) {
			logger.info(respondentInfoBean4);
		}
		return true;
	}
}
