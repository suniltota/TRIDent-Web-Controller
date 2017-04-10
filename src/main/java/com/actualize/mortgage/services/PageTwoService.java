package com.actualize.mortgage.services;

import org.mismo.residential._2009.schemas.DOCUMENT;

import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
/**
 * 
 * @author sboragala
 *
 */
public interface PageTwoService {
	
	public ClosingCostDetailsLoanCosts createClosingCostDetailsLoanCosts(DOCUMENT document);
	public ClosingCostDetailsOtherCosts createClosingCostDetailsOtherCosts(DOCUMENT document);

}
