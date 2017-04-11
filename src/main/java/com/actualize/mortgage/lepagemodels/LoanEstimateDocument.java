package com.actualize.mortgage.lepagemodels;

import java.io.Serializable;

/**
 * This model defines the structure of response for page one of Loan Estimate
 * @author sboragala
 *
 */
public class LoanEstimateDocument  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3623033275137867128L;
	
	private LoanEstimatePageOne loanEstimatePageOne;

	/**
	 * @return the loanEstimatePageOne
	 */
	public LoanEstimatePageOne getLoanEstimatePageOne() {
		return loanEstimatePageOne;
	}

	/**
	 * @param loanEstimatePageOne the loanEstimatePageOne to set
	 */
	public void setLoanEstimatePageOne(LoanEstimatePageOne loanEstimatePageOne) {
		this.loanEstimatePageOne = loanEstimatePageOne;
	}
	
	
}
