/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines IntegratedDisclosureDetail in MISMO XML
 * @author sboragala
 *
 */
public class IntegratedDisclosureDetailModel implements Serializable {

	private static final long serialVersionUID = 4003318663989330818L;
	
	private String firstYearTotalEscrowPaymentAmount;
	private String firstYearTotalEscrowPaymentDescription;
	private String firstYearTotalNonEscrowPaymentAmount;
	private String firstYearTotalNonEscrowPaymentDescription;
	private boolean integratedDisclosureHomeEquityLoanIndicator;
	private String integratedDisclosureIssuedDate;
	private String integratedDisclosureLoanProductDescription;
	
	/**
	 * @return the firstYearTotalEscrowPaymentAmount
	 */
	public String getFirstYearTotalEscrowPaymentAmount() {
		return firstYearTotalEscrowPaymentAmount;
	}
	/**
	 * @param firstYearTotalEscrowPaymentAmount the firstYearTotalEscrowPaymentAmount to set
	 */
	public void setFirstYearTotalEscrowPaymentAmount(String firstYearTotalEscrowPaymentAmount) {
		this.firstYearTotalEscrowPaymentAmount = firstYearTotalEscrowPaymentAmount;
	}
	/**
	 * @return the firstYearTotalEscrowPaymentDescription
	 */
	public String getFirstYearTotalEscrowPaymentDescription() {
		return firstYearTotalEscrowPaymentDescription;
	}
	/**
	 * @param firstYearTotalEscrowPaymentDescription the firstYearTotalEscrowPaymentDescription to set
	 */
	public void setFirstYearTotalEscrowPaymentDescription(String firstYearTotalEscrowPaymentDescription) {
		this.firstYearTotalEscrowPaymentDescription = firstYearTotalEscrowPaymentDescription;
	}
	/**
	 * @return the firstYearTotalNonEscrowPaymentAmount
	 */
	public String getFirstYearTotalNonEscrowPaymentAmount() {
		return firstYearTotalNonEscrowPaymentAmount;
	}
	/**
	 * @param firstYearTotalNonEscrowPaymentAmount the firstYearTotalNonEscrowPaymentAmount to set
	 */
	public void setFirstYearTotalNonEscrowPaymentAmount(String firstYearTotalNonEscrowPaymentAmount) {
		this.firstYearTotalNonEscrowPaymentAmount = firstYearTotalNonEscrowPaymentAmount;
	}
	/**
	 * @return the firstYearTotalNonEscrowPaymentDescription
	 */
	public String getFirstYearTotalNonEscrowPaymentDescription() {
		return firstYearTotalNonEscrowPaymentDescription;
	}
	/**
	 * @param firstYearTotalNonEscrowPaymentDescription the firstYearTotalNonEscrowPaymentDescription to set
	 */
	public void setFirstYearTotalNonEscrowPaymentDescription(String firstYearTotalNonEscrowPaymentDescription) {
		this.firstYearTotalNonEscrowPaymentDescription = firstYearTotalNonEscrowPaymentDescription;
	}
	/**
	 * @return the integratedDisclosureHomeEquityLoanIndicator
	 */
	public boolean isIntegratedDisclosureHomeEquityLoanIndicator() {
		return integratedDisclosureHomeEquityLoanIndicator;
	}
	/**
	 * @param integratedDisclosureHomeEquityLoanIndicator the integratedDisclosureHomeEquityLoanIndicator to set
	 */
	public void setIntegratedDisclosureHomeEquityLoanIndicator(boolean integratedDisclosureHomeEquityLoanIndicator) {
		this.integratedDisclosureHomeEquityLoanIndicator = integratedDisclosureHomeEquityLoanIndicator;
	}
	/**
	 * @return the integratedDisclosureIssuedDate
	 */
	public String getIntegratedDisclosureIssuedDate() {
		return integratedDisclosureIssuedDate;
	}
	/**
	 * @param integratedDisclosureIssuedDate the integratedDisclosureIssuedDate to set
	 */
	public void setIntegratedDisclosureIssuedDate(String integratedDisclosureIssuedDate) {
		this.integratedDisclosureIssuedDate = integratedDisclosureIssuedDate;
	}
	/**
	 * @return the integratedDisclosureLoanProductDescription
	 */
	public String getIntegratedDisclosureLoanProductDescription() {
		return integratedDisclosureLoanProductDescription;
	}
	/**
	 * @param integratedDisclosureLoanProductDescription the integratedDisclosureLoanProductDescription to set
	 */
	public void setIntegratedDisclosureLoanProductDescription(String integratedDisclosureLoanProductDescription) {
		this.integratedDisclosureLoanProductDescription = integratedDisclosureLoanProductDescription;
	}
	
	
	

}
