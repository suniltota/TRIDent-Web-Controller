/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class SummariesofTransactionsDetailsBorrowerTransaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4380364076683782942L;
	
	private IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosing;
	private IntegratedDisclosureSectionSummaryModel paidAlreadyByOrOnBehalfOfBorrowerAtClosing;
	private String cashFromBorrowerAtClosingAmount;
	private String cashToBorrowerAtClosingAmount;
	
	/**
	 * @return the dueFromBorrowerAtClosing
	 */
	public IntegratedDisclosureSectionSummaryModel getDueFromBorrowerAtClosing() {
		return dueFromBorrowerAtClosing;
	}
	/**
	 * @param dueFromBorrowerAtClosing the dueFromBorrowerAtClosing to set
	 */
	public void setDueFromBorrowerAtClosing(IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosing) {
		this.dueFromBorrowerAtClosing = dueFromBorrowerAtClosing;
	}
	/**
	 * @return the paidAlreadyByOrOnBehalfOfBorrowerAtClosing
	 */
	public IntegratedDisclosureSectionSummaryModel getPaidAlreadyByOrOnBehalfOfBorrowerAtClosing() {
		return paidAlreadyByOrOnBehalfOfBorrowerAtClosing;
	}
	/**
	 * @param paidAlreadyByOrOnBehalfOfBorrowerAtClosing the paidAlreadyByOrOnBehalfOfBorrowerAtClosing to set
	 */
	public void setPaidAlreadyByOrOnBehalfOfBorrowerAtClosing(
			IntegratedDisclosureSectionSummaryModel paidAlreadyByOrOnBehalfOfBorrowerAtClosing) {
		this.paidAlreadyByOrOnBehalfOfBorrowerAtClosing = paidAlreadyByOrOnBehalfOfBorrowerAtClosing;
	}
	/**
	 * @return the cashFromBorrowerAtClosingAmount
	 */
	public String getCashFromBorrowerAtClosingAmount() {
		return cashFromBorrowerAtClosingAmount;
	}
	/**
	 * @param cashFromBorrowerAtClosingAmount the cashFromBorrowerAtClosingAmount to set
	 */
	public void setCashFromBorrowerAtClosingAmount(String cashFromBorrowerAtClosingAmount) {
		this.cashFromBorrowerAtClosingAmount = cashFromBorrowerAtClosingAmount;
	}
	/**
	 * @return the cashToBorrowerAtClosingAmount
	 */
	public String getCashToBorrowerAtClosingAmount() {
		return cashToBorrowerAtClosingAmount;
	}
	/**
	 * @param cashToBorrowerAtClosingAmount the cashToBorrowerAtClosingAmount to set
	 */
	public void setCashToBorrowerAtClosingAmount(String cashToBorrowerAtClosingAmount) {
		this.cashToBorrowerAtClosingAmount = cashToBorrowerAtClosingAmount;
	}
	
	

}
