package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class LoanTermsPI implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7607077895798951633L;
	
	private String paymentFrequencyType;
	private String amount;
	private String status;
	private List<String> details;
	private String initialPrincipalAndInterestPaymentAmount;
	private String fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	private String interestOnlyIndicator;
	private String interestOnlyTermMonthsCount;
	private String adjustmentRuleType;
	private String perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	private String firstPrincipalAndInterestPaymentChangeMonthsCount;
	private String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
	private String principalAndInterestPaymentMaximumAmount;
	
	/**
	 * @return the paymentFrequencyType
	 */
	public String getPaymentFrequencyType() {
		return paymentFrequencyType;
	}
	/**
	 * @param paymentFrequencyType the paymentFrequencyType to set
	 */
	public void setPaymentFrequencyType(String paymentFrequencyType) {
		this.paymentFrequencyType = paymentFrequencyType;
	}
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public String getInitialPrincipalAndInterestPaymentAmount() {
		return initialPrincipalAndInterestPaymentAmount;
	}
	public void setInitialPrincipalAndInterestPaymentAmount(String initialPrincipalAndInterestPaymentAmount) {
		this.initialPrincipalAndInterestPaymentAmount = initialPrincipalAndInterestPaymentAmount;
	}
	public String getFullyIndexedInitialPrincipalAndInterestPaymentAmount() {
		return fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	}
	public void setFullyIndexedInitialPrincipalAndInterestPaymentAmount(
			String fullyIndexedInitialPrincipalAndInterestPaymentAmount) {
		this.fullyIndexedInitialPrincipalAndInterestPaymentAmount = fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	}
	public String getInterestOnlyIndicator() {
		return interestOnlyIndicator;
	}
	public void setInterestOnlyIndicator(String interestOnlyIndicator) {
		this.interestOnlyIndicator = interestOnlyIndicator;
	}
	public String getInterestOnlyTermMonthsCount() {
		return interestOnlyTermMonthsCount;
	}
	public void setInterestOnlyTermMonthsCount(String interestOnlyTermMonthsCount) {
		this.interestOnlyTermMonthsCount = interestOnlyTermMonthsCount;
	}
	public String getAdjustmentRuleType() {
		return adjustmentRuleType;
	}
	public void setAdjustmentRuleType(String adjustmentRuleType) {
		this.adjustmentRuleType = adjustmentRuleType;
	}
	public String getPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount() {
		return perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	}
	public void setPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(
			String perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount) {
		this.perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	}
	public String getFirstPrincipalAndInterestPaymentChangeMonthsCount() {
		return firstPrincipalAndInterestPaymentChangeMonthsCount;
	}
	public void setFirstPrincipalAndInterestPaymentChangeMonthsCount(
			String firstPrincipalAndInterestPaymentChangeMonthsCount) {
		this.firstPrincipalAndInterestPaymentChangeMonthsCount = firstPrincipalAndInterestPaymentChangeMonthsCount;
	}
	public String getPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount() {
		return principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
	}
	public void setPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount(
			String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount) {
		this.principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount = principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
	}
	public String getPrincipalAndInterestPaymentMaximumAmount() {
		return principalAndInterestPaymentMaximumAmount;
	}
	public void setPrincipalAndInterestPaymentMaximumAmount(String principalAndInterestPaymentMaximumAmount) {
		this.principalAndInterestPaymentMaximumAmount = principalAndInterestPaymentMaximumAmount;
	}
	
	
}
