/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines LoanProduct in JSON Response
 * @author sboragala
 *
 */
public class LoanProductModel implements Serializable {
	
	private static final long serialVersionUID = 4563513628139754860L;
	private String loanPriceQuoteInterestRatePercent;

	/**
	 * @return the loanPriceQuoteInterestRatePercent
	 */
	public String getLoanPriceQuoteInterestRatePercent() {
		return loanPriceQuoteInterestRatePercent;
	}

	/**
	 * @param loanPriceQuoteInterestRatePercent the loanPriceQuoteInterestRatePercent to set
	 */
	public void setLoanPriceQuoteInterestRatePercent(String loanPriceQuoteInterestRatePercent) {
		this.loanPriceQuoteInterestRatePercent = loanPriceQuoteInterestRatePercent;
	}
	
	

}
