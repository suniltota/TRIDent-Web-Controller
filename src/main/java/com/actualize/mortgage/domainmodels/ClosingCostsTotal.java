/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines closing costs total 
 * @author sboragala
 *
 */
public class ClosingCostsTotal implements Serializable {

	private static final long serialVersionUID = -2686016371514724570L;
	
	private String totalClosingCosts;
	private PaymentsModel  closingCostsSubtotal;
	private String lenderCredits;
	private String lenderCreditToleranceCureAmount;
	
	/**
	 * @return the totalClosingCosts
	 */
	public String getTotalClosingCosts() {
		return totalClosingCosts;
	}
	/**
	 * @param totalClosingCosts the totalClosingCosts to set
	 */
	public void setTotalClosingCosts(String totalClosingCosts) {
		this.totalClosingCosts = totalClosingCosts;
	}
	/**
	 * @return the closingCostsSubtotal
	 */
	public PaymentsModel getClosingCostsSubtotal() {
		return closingCostsSubtotal;
	}
	/**
	 * @param closingCostsSubtotal the closingCostsSubtotal to set
	 */
	public void setClosingCostsSubtotal(PaymentsModel closingCostsSubtotal) {
		this.closingCostsSubtotal = closingCostsSubtotal;
	}
	/**
	 * @return the lenderCredits
	 */
	public String getLenderCredits() {
		return lenderCredits;
	}
	/**
	 * @param lenderCredits the lenderCredits to set
	 */
	public void setLenderCredits(String lenderCredits) {
		this.lenderCredits = lenderCredits;
	}
	/**
	 * @return the lenderCreditToleranceCureAmount
	 */
	public String getLenderCreditToleranceCureAmount() {
		return lenderCreditToleranceCureAmount;
	}
	/**
	 * @param lenderCreditToleranceCureAmount the lenderCreditToleranceCureAmount to set
	 */
	public void setLenderCreditToleranceCureAmount(String lenderCreditToleranceCureAmount) {
		this.lenderCreditToleranceCureAmount = lenderCreditToleranceCureAmount;
	}

	
}
