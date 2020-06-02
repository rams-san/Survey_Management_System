package com.capgemini.survey.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.exceptions.RespondAlreadyExistsException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.service.RespondService;
import com.capgemini.survey.service.RespondentService;
import com.capgemini.survey.validations.InputValidations;

public class RespondDaoImpl implements RespondDao {
	static List<RespondInfoBean> respondList = new ArrayList<>();
	Map<Integer, String> hashMap1 = new HashMap<>();
	Map<Integer, String> hashMap2 = new HashMap<>();
	InputValidations inputValidation = Factory.getInputValidationInstance();
	List<RespondInfoBean> respondedRecord = new ArrayList<>();
	List<RespondInfoBean> pendingRecord = new ArrayList<>();
	ArrayList<String> respondTitleList = new ArrayList<>();
	ArrayList<String> respondTitleList1 = new ArrayList<>();
	ArrayList<String> respondTitleList2 = new ArrayList<>();
	ArrayList<Integer> respondIdList = new ArrayList<>();
	List<String> respondQuestionList1 = new ArrayList<>();
	int counter = 0;

	/**
	 * This method is use to get responded list.
	 * 
	 * @return boolean value base on condition, returns hashMap1 if respond is present
	 *         else returns null.
	 */
	@Override
	public Map<Integer, String> getRespondedList() {
		for (RespondInfoBean respondInfoBean : respondList) {
			if ((respondInfoBean.getRespondAnswer10() != null)) {
				String str = respondInfoBean.getRespondTitle();
				int id = respondInfoBean.getRespondId();
				hashMap1.put(id, str);
				counter++;
			}
		}
		if (counter != 0) {
			return hashMap1;
		}
		return null;
	}

	/**
	 * This method is use to get pending respond list.
	 * 
	 * @return boolean value base on condition, returns hashMap2 if respond is not
	 *         present else returns null.
	 */
	@Override
	public Map<Integer, String> getPendingRespondList() {
		for (RespondInfoBean respondInfoBean : respondList) {
			if ((respondInfoBean.getRespondAnswer10() == null)) {
				String str = respondInfoBean.getRespondTitle();
				int id = respondInfoBean.getRespondId();
				hashMap2.put(id, str);
				counter++;
			}
		}
		if (counter != 0) {
			return hashMap2;
		}
		return null;
	}

	/**
	 * This method is use to get search respond id.
	 * 
	 * @param respondId is the parameter to searchRespondId method.
	 * @return boolean value base on condition.
	 *        .
	 */
	@Override
	public boolean searchRespondId(int respondId) {
		RespondentService respondentService = Factory.getRespondentServiceInstance();
		if (respondentService.serviceSearchRespondent2(respondId)) {
			Iterator<RespondInfoBean> respondInfoBean4 = respondList.iterator();
			while (respondInfoBean4.hasNext()) {
				RespondInfoBean compare2 = respondInfoBean4.next();
				if (compare2.getRespondId() == respondId) {
					counter++;
					throw new RespondAlreadyExistsException("\nThis Id is already distributed !!");
				}
			}
		}
		return (counter == 0);
	}

	/**
	 * This method is use to distribute survey to respondent based on their id's.
	 * 
	 * @param respondId,respondTitle are the parameters to distributeSurvey method.
	 * @return true.
	 */
	@Override
	public boolean distributeSurvey(int respondId, String respondTitle) {
		RespondInfoBean respondInfoBean = Factory.getRespondInfoBeanInstance();
		respondInfoBean.setRespondId(respondId);
		ArrayList<RespondInfoBean> list1 = new ArrayList<>();
		list1.add(respondInfoBean);
		respondList.addAll(list1);
		for (RespondInfoBean respondInfoBean1 : respondList) {
			if (respondInfoBean1.getRespondId() == respondId) {
				respondInfoBean1.setRespondTitle(respondTitle);
			}
		}
		return true;
	}

	/**
	 * This method is use to get all responded and pending responds list.
	 * 
	 * @return respondList if true else returns empty list.
	 */
	@Override
	public List<RespondInfoBean> getAllResponds() {
		if (!respondList.isEmpty()) {
			return respondList;
		}
		return Collections.emptyList();
	}

	/**
	 * This method is use to search respond id.
	 * 
	 * @param respondId is the parameter to searchRespondId1 method.
	 * @return respondTitleList if true else throw NotFoundException.
	 */
	@Override
	public List<String> searchRespondId1(int respondId) {
		for (RespondInfoBean respondInfoBean : respondList) {

			if ((respondInfoBean.getRespondId() == respondId)&&(respondInfoBean.getRespondAnswer10() == null)) {
				counter++;
			}
		}
		if (counter != 0) {

			for (RespondInfoBean respondInfoBean : respondList) {
				if (respondInfoBean.getRespondId() == respondId) {

					String str = respondInfoBean.getRespondTitle();
					respondTitleList.add(str);
				}
			}
			return respondTitleList;
		} else {
			throw new NotFoundException("\nRespondent id doesn't exists or it is already responded !!");
		}
	}

	/**
	 * This method is use to get respond question.
	 * 
	 * @param respondTitleList1,option1 are the parameters to getRespondQuestion method.
	 * @return respondQuestionList.
	 */
	@Override
	public List<String> getRespondQuestion(List<String> respondTitleList1, int option1) {
		for (RespondInfoBean respondInfoBean : respondList) {
			if (respondInfoBean.getRespondTitle().equals(respondTitleList1.get(option1))) {
				SurveyDaoImpl surveyDaoImpl = new SurveyDaoImpl();
				List<String> respondQuestionList = surveyDaoImpl.getSurveyQuestions(respondTitleList1.get(option1));

				respondInfoBean.setRespondQuestion1(respondQuestionList.get(0));
				respondInfoBean.setRespondQuestion2(respondQuestionList.get(1));
				respondInfoBean.setRespondQuestion3(respondQuestionList.get(2));
				respondInfoBean.setRespondQuestion4(respondQuestionList.get(3));
				respondInfoBean.setRespondQuestion5(respondQuestionList.get(4));
				respondInfoBean.setRespondQuestion6(respondQuestionList.get(5));
				respondInfoBean.setRespondQuestion7(respondQuestionList.get(6));
				respondInfoBean.setRespondQuestion8(respondQuestionList.get(7));
				respondInfoBean.setRespondQuestion9(respondQuestionList.get(8));
				respondInfoBean.setRespondQuestion10(respondQuestionList.get(9));

				respondQuestionList1.add(respondInfoBean.getRespondQuestion1());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion2());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion3());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion4());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion5());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion6());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion7());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion8());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion9());
				respondQuestionList1.add(respondInfoBean.getRespondQuestion10());
			}
		}
		return respondQuestionList1;
	}

	/**
	 * This method is use to respond to a survey based on respondent id's.
	 * 
	 * @param respondId,option1,answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,answer9,answer10 are the parameters to respondToSurvey method.
	 * @return true else throw NotFoundException.
	 */
	@Override
	public boolean respondToSurvey(int respondId, int option1, RespondInfoBean respondInfoBean) {
		RespondService respondService = Factory.getRespondServiceInstance();
		respondTitleList1.addAll(respondService.serviceSearchRespondId1(respondId));
		option1--;
		for (RespondInfoBean respondInfoBean1 : respondList) {
			if (respondInfoBean1.getRespondTitle().equals(respondTitleList1.get(option1))) {
				counter++;
			}
		}
		if (counter != 0) {
			for (RespondInfoBean respondInfoBean1 : respondList) {
				if (respondInfoBean1.getRespondTitle().equals(respondTitleList1.get(option1))) {
					SurveyDao surveyDao = Factory.getSurveyDaoInstance();
					surveyDao.getSurveyQuestions(respondTitleList1.get(option1));
				}
			}
			RespondDaoImpl respondDaoImpl = new RespondDaoImpl();
			respondDaoImpl.getRespondQuestion(respondTitleList1, option1);

			for (RespondInfoBean respondInfoBean1 : respondList) {
				if (respondInfoBean1.getRespondTitle().equals(respondTitleList1.get(option1))) {
					respondInfoBean1.setRespondAnswer1(respondInfoBean.getRespondAnswer1());
					respondInfoBean1.setRespondAnswer2(respondInfoBean.getRespondAnswer2());
					respondInfoBean1.setRespondAnswer3(respondInfoBean.getRespondAnswer3());
					respondInfoBean1.setRespondAnswer4(respondInfoBean.getRespondAnswer4());
					respondInfoBean1.setRespondAnswer5(respondInfoBean.getRespondAnswer5());
					respondInfoBean1.setRespondAnswer6(respondInfoBean.getRespondAnswer6());
					respondInfoBean1.setRespondAnswer7(respondInfoBean.getRespondAnswer7());
					respondInfoBean1.setRespondAnswer8(respondInfoBean.getRespondAnswer8());
					respondInfoBean1.setRespondAnswer9(respondInfoBean.getRespondAnswer9());
					respondInfoBean1.setRespondAnswer10(respondInfoBean.getRespondAnswer10());
				}
			}
			return true;
		}
		throw new NotFoundException("\nRespondent id not found");
	}

	/**
	 * This method is use to get responded record.
	 * 
	 * @return respondedRecord if true else return empty list.
	 */
	@Override
	public List<RespondInfoBean> getRespondedRecord() {
		for (RespondInfoBean respondInfoBean : respondList) {
			if ((respondInfoBean.getRespondAnswer10() != null)) {
				counter++;
				ArrayList<RespondInfoBean> list1 = new ArrayList<>();
				list1.add(respondInfoBean);
				respondedRecord.addAll(list1);
			}
		}
		if (counter != 0) {
			return respondedRecord;
		}
		return Collections.emptyList();
	}

	/**
	 * This method is use to get pending respond records.
	 * 
	 * @return pendingRecord if true else return empty list.
	 */
	@Override
	public List<RespondInfoBean> getPendingRecord() {
		for (RespondInfoBean respondInfoBean : respondList) {
			if ((respondInfoBean.getRespondAnswer10() == null)) {
				counter++;
				ArrayList<RespondInfoBean> list1 = new ArrayList<>();
				list1.add(respondInfoBean);
				pendingRecord.addAll(list1);
			}
		}
		if (counter != 0) {
			return pendingRecord;
		}
		return Collections.emptyList();
	}
	
	/**
	 * This method is use to get list of titles.
	 * 
	 * @return respondTitleList2.
	 */
	@Override
	public List<String> getListOfRespondTitle() {
		for (RespondInfoBean respondInfoBean : respondList) {
			String str = respondInfoBean.getRespondTitle();
			respondTitleList2.add(str);
		}
		return respondTitleList2;
	}
}