package com.actualize.mortgage.leservices;

import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.lepagemodels.LoanEstimatePageOne;

public interface LoanEstimateResponseServices {
	/**
	 * This method renders the response for page one of LE.
	 * @param deal
	 * @return JSON response for page One of LE
	 * @throws Exception
	 */
	public LoanEstimatePageOne createLoanEstimatePageOne(Deal deal) throws Exception;
	
}
