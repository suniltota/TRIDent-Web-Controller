package com.actualize.mortgage.leservices.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.lepagemodels.LoanEstimatePageOne;
import com.actualize.mortgage.leservices.LoanEstimatePageOneService;
import com.actualize.mortgage.leservices.LoanEstimateResponseServices;

/**
 * This class defines all the services related for generating JSON response from XML
 * @author sboragala
 *
 */
public class LoanEstimateResponseServicesImpl  implements LoanEstimateResponseServices{

	@Autowired
	LoanEstimatePageOneService loanEstimatePageOneService;
	/*
	 * (non-Javadoc)
	 * @see com.actualize.mortgage.leservices.LoanEstimateResponseServices#createLoanEstimatePageOne(com.actualize.mortgage.ledatamodels.Deal)
	 */
	@Override
	public LoanEstimatePageOne createLoanEstimatePageOne(Deal deal) throws Exception {
		LoanEstimatePageOne loanEstimatePageOne = new LoanEstimatePageOne();
			loanEstimatePageOne.setLoanEstimateSection(loanEstimatePageOneService.createLoanEstimateSection(deal));
		return loanEstimatePageOne;
	}

}
