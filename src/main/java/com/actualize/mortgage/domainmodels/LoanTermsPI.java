package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class LoanTermsPI implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7607077895798951633L;
	
	private String paymentFrequencyType;
	private String amount;
	private String initialPrincipalAndInterestPaymentAmount;
	private String fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	private String adjustmentRuleType;
	private String perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	private String firstPrincipalAndInterestPaymentChangeMonthsCount;
	private String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
	private String principalAndInterestPaymentMaximumAmount;
	private String paymentIncreaseIndicator;
	
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
	 * @return the initialPrincipalAndInterestPaymentAmount
	 */
	public String getInitialPrincipalAndInterestPaymentAmount() {
		return initialPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @param initialPrincipalAndInterestPaymentAmount the initialPrincipalAndInterestPaymentAmount to set
	 */
	public void setInitialPrincipalAndInterestPaymentAmount(String initialPrincipalAndInterestPaymentAmount) {
		this.initialPrincipalAndInterestPaymentAmount = initialPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @return the fullyIndexedInitialPrincipalAndInterestPaymentAmount
	 */
	public String getFullyIndexedInitialPrincipalAndInterestPaymentAmount() {
		return fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @param fullyIndexedInitialPrincipalAndInterestPaymentAmount the fullyIndexedInitialPrincipalAndInterestPaymentAmount to set
	 */
	public void setFullyIndexedInitialPrincipalAndInterestPaymentAmount(
			String fullyIndexedInitialPrincipalAndInterestPaymentAmount) {
		this.fullyIndexedInitialPrincipalAndInterestPaymentAmount = fullyIndexedInitialPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @return the adjustmentRuleType
	 */
	public String getAdjustmentRuleType() {
		return adjustmentRuleType;
	}
	/**
	 * @param adjustmentRuleType the adjustmentRuleType to set
	 */
	public void setAdjustmentRuleType(String adjustmentRuleType) {
		this.adjustmentRuleType = adjustmentRuleType;
	}
	/**
	 * @return the perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount
	 */
	public String getPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount() {
		return perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @param perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount the perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount to set
	 */
	public void setPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(
			String perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount) {
		this.perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = perChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @return the firstPrincipalAndInterestPaymentChangeMonthsCount
	 */
	public String getFirstPrincipalAndInterestPaymentChangeMonthsCount() {
		return firstPrincipalAndInterestPaymentChangeMonthsCount;
	}
	/**
	 * @param firstPrincipalAndInterestPaymentChangeMonthsCount the firstPrincipalAndInterestPaymentChangeMonthsCount to set
	 */
	public void setFirstPrincipalAndInterestPaymentChangeMonthsCount(
			String firstPrincipalAndInterestPaymentChangeMonthsCount) {
		this.firstPrincipalAndInterestPaymentChangeMonthsCount = firstPrincipalAndInterestPaymentChangeMonthsCount;
	}
	/**
	 * @return the principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount
	 */
	public String getPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount() {
		return principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
	}
	/**
	 * @param principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount the principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount to set
	 */
	public void setPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount(
			String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount) {
		this.principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount = principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
	}
	/**
	 * @return the principalAndInterestPaymentMaximumAmount
	 */
	public String getPrincipalAndInterestPaymentMaximumAmount() {
		return principalAndInterestPaymentMaximumAmount;
	}
	/**
	 * @param principalAndInterestPaymentMaximumAmount the principalAndInterestPaymentMaximumAmount to set
	 */
	public void setPrincipalAndInterestPaymentMaximumAmount(String principalAndInterestPaymentMaximumAmount) {
		this.principalAndInterestPaymentMaximumAmount = principalAndInterestPaymentMaximumAmount;
	}
	/**
	 * @return the paymentIncreaseIndicator
	 */
	public String getPaymentIncreaseIndicator() {
		return paymentIncreaseIndicator;
	}
	/**
	 * @param paymentIncreaseIndicator the paymentIncreaseIndicator to set
	 */
	public void setPaymentIncreaseIndicator(String paymentIncreaseIndicator) {
		this.paymentIncreaseIndicator = paymentIncreaseIndicator;
	}
	
	
	
}
