/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines fee payment structure for MISMO XML
 * @author sboragala
 *
 */
public class MismoPaymentsModel implements Serializable {
	
	private static final long serialVersionUID = -397906066936163857L;
	private String amount = "";
	private String paidByType = "";
	private String closingIndicator = "";
	
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
	 * @return the paidByType
	 */
	public String getPaidByType() {
		return paidByType;
	}
	/**
	 * @param paidByType the paidByType to set
	 */
	public void setPaidByType(String paidByType) {
		this.paidByType = paidByType;
	}
	/**
	 * @return the closingIndicator
	 */
	public String getClosingIndicator() {
		return closingIndicator;
	}
	/**
	 * @param closingIndicator the closingIndicator to set
	 */
	public void setClosingIndicator(String closingIndicator) {
		this.closingIndicator = closingIndicator;
	}
	
	
}
