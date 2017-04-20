package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * 
 * @author sboragala
 * 
 */
public class CostsAtClosingClosingCosts implements Serializable {
	
	private static final long serialVersionUID = 5273848413251894676L;
	
	private String amount;
	private String integratedDisclosureSubsectionTotalAmount;
	private String integratedDisclosureSubsectionPaymentAmount;
	private String totalLoanCosts;
	private String totalOtherCosts;
	private String lenderCredits;
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * @return the integratedDisclosureSubsectionTotalAmount
	 */
	public String getIntegratedDisclosureSubsectionTotalAmount() {
		return integratedDisclosureSubsectionTotalAmount;
	}
	/**
	 * @param integratedDisclosureSubsectionTotalAmount the integratedDisclosureSubsectionTotalAmount to set
	 */
	public void setIntegratedDisclosureSubsectionTotalAmount(String integratedDisclosureSubsectionTotalAmount) {
		this.integratedDisclosureSubsectionTotalAmount = integratedDisclosureSubsectionTotalAmount;
	}
	/**
	 * @return the integratedDisclosureSubsectionPaymentAmount
	 */
	public String getIntegratedDisclosureSubsectionPaymentAmount() {
		return integratedDisclosureSubsectionPaymentAmount;
	}
	/**
	 * @param integratedDisclosureSubsectionPaymentAmount the integratedDisclosureSubsectionPaymentAmount to set
	 */
	public void setIntegratedDisclosureSubsectionPaymentAmount(String integratedDisclosureSubsectionPaymentAmount) {
		this.integratedDisclosureSubsectionPaymentAmount = integratedDisclosureSubsectionPaymentAmount;
	}
	/**
	 * @return the totalLoanCosts
	 */
	public String getTotalLoanCosts() {
		return totalLoanCosts;
	}
	/**
	 * @param totalLoanCosts the totalLoanCosts to set
	 */
	public void setTotalLoanCosts(String totalLoanCosts) {
		this.totalLoanCosts = totalLoanCosts;
	}
	/**
	 * @return the totalOtherCosts
	 */
	public String getTotalOtherCosts() {
		return totalOtherCosts;
	}
	/**
	 * @param totalOtherCosts the totalOtherCosts to set
	 */
	public void setTotalOtherCosts(String totalOtherCosts) {
		this.totalOtherCosts = totalOtherCosts;
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
	
	

}
