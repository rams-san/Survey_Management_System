package com.capgemini.survey.repository;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.factory.Factory;

public class SurveyRepository {

	public static final org.apache.log4j.Logger logger = Logger.getLogger(SurveyRepository.class);

	/**
	 * This method is use to create survey table.
	 * 
	 * @return surveyList
	 */
	public List<SurveyInfoBean> surveyTable() {
		List<SurveyInfoBean> surveyList = new ArrayList<>();
		SurveyInfoBean surveyInfoBean1 = Factory.getSurveyInfoBeanInstance();
		surveyInfoBean1.setSurveyTitle("Amazon Prime");
		surveyInfoBean1.setSurveyDescription("Amazon Prime Survey");
		surveyInfoBean1.setSurveyQuestion1("1.Have you ever heard of Amazon Prime (yes/no)?");
		surveyInfoBean1.setSurveyQuestion2(
				"2.Are you more inclined to buy an item you normally wouldn't consider buying if it is on sale (yes/no)?");
		surveyInfoBean1.setSurveyQuestion3("3.What 3 words would you use to describe Amazon Prime?");
		surveyInfoBean1.setSurveyQuestion4(
				"4.In general, do you feel like subscription services are worth the price of membership? (yes/no)");
		surveyInfoBean1.setSurveyQuestion5("5.Do you know how much Amazon Prime costs (yes/no)?");
		surveyInfoBean1.setSurveyQuestion6("6.Have you ever used Amazon Prime (yes/no)?");
		surveyInfoBean1
				.setSurveyQuestion7("7.If you have used Amazon Prime what features did you like about it the best?");
		surveyInfoBean1.setSurveyQuestion8("8.Have you seen advertisements for Amazon Prime (yes/no)?");
		surveyInfoBean1.setSurveyQuestion9("9.What features, if any, would you like to see added to Amazon Prime?");
		surveyInfoBean1.setSurveyQuestion10("10.Rate Amazon Prime from (1-10).");

		SurveyInfoBean surveyInfoBean2 = Factory.getSurveyInfoBeanInstance();
		surveyInfoBean2.setSurveyTitle("Flipkart");
		surveyInfoBean2.setSurveyDescription("Flipkart Survey");
		surveyInfoBean2.setSurveyQuestion1("1.Have you ever heard of flipkart (yes/no)?");
		surveyInfoBean2.setSurveyQuestion2(
				"2.Are you more inclined to buy an item you normally wouldn't consider buying if it is on sale (yes/no)?");
		surveyInfoBean2.setSurveyQuestion3("3.What 3 words would you use to describe flipkart?");
		surveyInfoBean2.setSurveyQuestion4("4.Have you ever used flipkart (yes/no)?");
		surveyInfoBean2.setSurveyQuestion5("5.Have you seen advertisements for Flipkart (yes/no)?");
		surveyInfoBean2.setSurveyQuestion6("6.Is Our Product Quality Satisfactory (yes/no)?");
		surveyInfoBean2.setSurveyQuestion7("7.Mention Specific type of item that you didn't found on our website.");
		surveyInfoBean2.setSurveyQuestion8("8.Do you like our payment facility (yes/no)?");
		surveyInfoBean2.setSurveyQuestion9("9.What features, if any, would you like to see added to flipkart?");
		surveyInfoBean2.setSurveyQuestion10("10.Rate flipkart from (1-10).");

		SurveyInfoBean surveyInfoBean3 = Factory.getSurveyInfoBeanInstance();
		surveyInfoBean3.setSurveyTitle("Facebook");
		surveyInfoBean3.setSurveyDescription("Facebook Survey");
		surveyInfoBean3.setSurveyQuestion1("1.What is your name ?");
		surveyInfoBean3.setSurveyQuestion2("2.What is your age ?");
		surveyInfoBean3.setSurveyQuestion3("3.Have you ever used facebook (yes/no)?");
		surveyInfoBean3.setSurveyQuestion4("4.How many accounts do you have (one/one or more)? please enter below :");
		surveyInfoBean3.setSurveyQuestion5("5.What 3 words would you use to describe facebook?");
		surveyInfoBean3.setSurveyQuestion6("6.Is facebook useful to communicate with your friends (yes/no)?");
		surveyInfoBean3.setSurveyQuestion7("7.Have you ever used facebook live (yes/no)?");
		surveyInfoBean3.setSurveyQuestion8("8.What features, if any, would you like to see added to facebook ?");
		surveyInfoBean3.setSurveyQuestion9("9.For what purpose you are using facebook (personal/commercial) ?");
		surveyInfoBean3.setSurveyQuestion10("10.Rate facebook from (1-10).");

		surveyList.add(surveyInfoBean1);
		surveyList.add(surveyInfoBean2);
		surveyList.add(surveyInfoBean3);
		
		return surveyList;
	}

	/**
	 * This method is use to print survey table.
	 * 
	 * @return true
	 */
	public boolean getSurveyTable() {
		List<SurveyInfoBean> surveyList1 = new SurveyRepository().surveyTable();
		for (SurveyInfoBean surveyInfoBean4 : surveyList1) {
			logger.info(surveyInfoBean4);
		}
		return true;
	}
}
