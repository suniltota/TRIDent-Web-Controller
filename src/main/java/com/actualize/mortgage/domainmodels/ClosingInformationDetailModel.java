/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines ClosingInformationDetail in JSON response
 * @author sboragala
 *
 */
public class ClosingInformationDetailModel implements Serializable {

	private static long serialVersionUID = -6319164577319948138L;
	
	private String cashFromBorrowerAtClosingAmount;
	private String cashFromSellerAtClosingAmount;
	private String cashToBorrowerAtClosingAmount;
	private String cashToSellerAtClosingAmount;
	private String closingAgentOrderNumberIdentifier;
	private String closingDate;
	private String closingRateSetDate;
	private String currentRateSetDate;
	private String disbursementDate;
	private String documentOrderClassificationType;
	
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
	 * @return the cashFromSellerAtClosingAmount
	 */
	public String getCashFromSellerAtClosingAmount() {
		return cashFromSellerAtClosingAmount;
	}
	/**
	 * @param cashFromSellerAtClosingAmount the cashFromSellerAtClosingAmount to set
	 */
	public void setCashFromSellerAtClosingAmount(String cashFromSellerAtClosingAmount) {
		this.cashFromSellerAtClosingAmount = cashFromSellerAtClosingAmount;
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
	/**
	 * @return the cashToSellerAtClosingAmount
	 */
	public String getCashToSellerAtClosingAmount() {
		return cashToSellerAtClosingAmount;
	}
	/**
	 * @param cashToSellerAtClosingAmount the cashToSellerAtClosingAmount to set
	 */
	public void setCashToSellerAtClosingAmount(String cashToSellerAtClosingAmount) {
		this.cashToSellerAtClosingAmount = cashToSellerAtClosingAmount;
	}
	/**
	 * @return the closingAgentOrderNumberIdentifier
	 */
	public String getClosingAgentOrderNumberIdentifier() {
		return closingAgentOrderNumberIdentifier;
	}
	/**
	 * @param closingAgentOrderNumberIdentifier the closingAgentOrderNumberIdentifier to set
	 */
	public void setClosingAgentOrderNumberIdentifier(String closingAgentOrderNumberIdentifier) {
		this.closingAgentOrderNumberIdentifier = closingAgentOrderNumberIdentifier;
	}
	/**
	 * @return the closingDate
	 */
	public String getClosingDate() {
		return closingDate;
	}
	/**
	 * @param closingDate the closingDate to set
	 */
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	/**
	 * @return the closingRateSetDate
	 */
	public String getClosingRateSetDate() {
		return closingRateSetDate;
	}
	/**
	 * @param closingRateSetDate the closingRateSetDate to set
	 */
	public void setClosingRateSetDate(String closingRateSetDate) {
		this.closingRateSetDate = closingRateSetDate;
	}
	/**
	 * @return the currentRateSetDate
	 */
	public String getCurrentRateSetDate() {
		return currentRateSetDate;
	}
	/**
	 * @param currentRateSetDate the currentRateSetDate to set
	 */
	public void setCurrentRateSetDate(String currentRateSetDate) {
		this.currentRateSetDate = currentRateSetDate;
	}
	/**
	 * @return the disbursementDate
	 */
	public String getDisbursementDate() {
		return disbursementDate;
	}
	/**
	 * @param disbursementDate the disbursementDate to set
	 */
	public void setDisbursementDate(String disbursementDate) {
		this.disbursementDate = disbursementDate;
	}
	/**
	 * @return the documentOrderClassificationType
	 */
	public String getDocumentOrderClassificationType() {
		return documentOrderClassificationType;
	}
	/**
	 * @param documentOrderClassificationType the documentOrderClassificationType to set
	 */
	public void setDocumentOrderClassificationType(String documentOrderClassificationType) {
		this.documentOrderClassificationType = documentOrderClassificationType;
	}
	
	
}
