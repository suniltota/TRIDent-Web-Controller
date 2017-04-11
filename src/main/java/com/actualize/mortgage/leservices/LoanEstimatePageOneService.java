package com.actualize.mortgage.leservices;

import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.lepagemodels.LoanEstimateSection;

/**
 * 
 * @author sboragala
 *
 */
public interface LoanEstimatePageOneService {
	/**
	 * 
	 * @param deal
	 * @return JSON reponse from LoanEstimate Section of page One in LE 
	 * @throws Exception
	 */
	public LoanEstimateSection createLoanEstimateSection(Deal deal) throws Exception;

}
