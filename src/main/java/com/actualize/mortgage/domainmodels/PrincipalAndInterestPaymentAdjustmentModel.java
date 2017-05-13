/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines PrincipalAndInterestPaymentAdjustment in JSON Response
 * @author sboragala
 *
 */
public class PrincipalAndInterestPaymentAdjustmentModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3217953125740847843L;
	
	private String firstPrincipalAndInterestPaymentChangeMonthsCount;
	private String principalAndInterestPaymentMaximumAmount;
	private String principalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount;
	private String firstAdjustmentRuleType;
	private String firstPerChangeMaximumPrincipalAndInterestPaymentAmount;
	private String firstPerChangeMinimumPrincipalAndInterestPaymentAmount;
	private String firstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	private String subsequentAdjustmentRuleType;
	private String subsequentPerChangeMaximumPrincipalAndInterestPaymentAmount;
	private String subsequentPerChangeMinimumPrincipalAndInterestPaymentAmount;
	private String subsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	
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
	 * @return the firstAdjustmentRuleType
	 */
	public String getFirstAdjustmentRuleType() {
		return firstAdjustmentRuleType;
	}
	/**
	 * @param firstAdjustmentRuleType the firstAdjustmentRuleType to set
	 */
	public void setFirstAdjustmentRuleType(String firstAdjustmentRuleType) {
		this.firstAdjustmentRuleType = firstAdjustmentRuleType;
	}
	/**
	 * @return the firstPerChangeMaximumPrincipalAndInterestPaymentAmount
	 */
	public String getFirstPerChangeMaximumPrincipalAndInterestPaymentAmount() {
		return firstPerChangeMaximumPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @param firstPerChangeMaximumPrincipalAndInterestPaymentAmount the firstPerChangeMaximumPrincipalAndInterestPaymentAmount to set
	 */
	public void setFirstPerChangeMaximumPrincipalAndInterestPaymentAmount(
			String firstPerChangeMaximumPrincipalAndInterestPaymentAmount) {
		this.firstPerChangeMaximumPrincipalAndInterestPaymentAmount = firstPerChangeMaximumPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @return the firstPerChangeMinimumPrincipalAndInterestPaymentAmount
	 */
	public String getFirstPerChangeMinimumPrincipalAndInterestPaymentAmount() {
		return firstPerChangeMinimumPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @param firstPerChangeMinimumPrincipalAndInterestPaymentAmount the firstPerChangeMinimumPrincipalAndInterestPaymentAmount to set
	 */
	public void setFirstPerChangeMinimumPrincipalAndInterestPaymentAmount(
			String firstPerChangeMinimumPrincipalAndInterestPaymentAmount) {
		this.firstPerChangeMinimumPrincipalAndInterestPaymentAmount = firstPerChangeMinimumPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @return the firstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount
	 */
	public String getFirstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount() {
		return firstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @param firstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount the firstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount to set
	 */
	public void setFirstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(
			String firstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount) {
		this.firstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = firstPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @return the subsequentAdjustmentRuleType
	 */
	public String getSubsequentAdjustmentRuleType() {
		return subsequentAdjustmentRuleType;
	}
	/**
	 * @param subsequentAdjustmentRuleType the subsequentAdjustmentRuleType to set
	 */
	public void setSubsequentAdjustmentRuleType(String subsequentAdjustmentRuleType) {
		this.subsequentAdjustmentRuleType = subsequentAdjustmentRuleType;
	}
	/**
	 * @return the subsequentPerChangeMaximumPrincipalAndInterestPaymentAmount
	 */
	public String getSubsequentPerChangeMaximumPrincipalAndInterestPaymentAmount() {
		return subsequentPerChangeMaximumPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @param subsequentPerChangeMaximumPrincipalAndInterestPaymentAmount the subsequentPerChangeMaximumPrincipalAndInterestPaymentAmount to set
	 */
	public void setSubsequentPerChangeMaximumPrincipalAndInterestPaymentAmount(
			String subsequentPerChangeMaximumPrincipalAndInterestPaymentAmount) {
		this.subsequentPerChangeMaximumPrincipalAndInterestPaymentAmount = subsequentPerChangeMaximumPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @return the subsequentPerChangeMinimumPrincipalAndInterestPaymentAmount
	 */
	public String getSubsequentPerChangeMinimumPrincipalAndInterestPaymentAmount() {
		return subsequentPerChangeMinimumPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @param subsequentPerChangeMinimumPrincipalAndInterestPaymentAmount the subsequentPerChangeMinimumPrincipalAndInterestPaymentAmount to set
	 */
	public void setSubsequentPerChangeMinimumPrincipalAndInterestPaymentAmount(
			String subsequentPerChangeMinimumPrincipalAndInterestPaymentAmount) {
		this.subsequentPerChangeMinimumPrincipalAndInterestPaymentAmount = subsequentPerChangeMinimumPrincipalAndInterestPaymentAmount;
	}
	/**
	 * @return the subsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount
	 */
	public String getSubsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount() {
		return subsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @param subsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount the subsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount to set
	 */
	public void setSubsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount(
			String subsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount) {
		this.subsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount = subsequentPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount;
	}
	
	

}
