package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class LoanTermsInterestRate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7964998098675066631L;
	
	
	
	private String noteRatePercent;
	private String disclosedFullyIndexedRatePercent;
	private boolean interestRateIncreaseIndicator;
	private String adjustmentRuleTypeFirst;
	private String perChangeRateAdjustmentFrequencyMonthsCount;
	private String firstRateChangeMonthsCount;
	private String ceilingRatePercentEarliestEffectiveMonthsCount;
	private String ceilingRatePercent;
	private String currentRateSetDate ="TBD";
	private String loanPriceQuote = "TBD";
	private String apor = "TBD";
	
	/**
	 * @return the noteRatePercent
	 */
	public String getNoteRatePercent() {
		return noteRatePercent;
	}
	/**
	 * @param noteRatePercent the noteRatePercent to set
	 */
	public void setNoteRatePercent(String noteRatePercent) {
		this.noteRatePercent = noteRatePercent;
	}
	/**
	 * @return the disclosedFullyIndexedRatePercent
	 */
	public String getDisclosedFullyIndexedRatePercent() {
		return disclosedFullyIndexedRatePercent;
	}
	/**
	 * @param disclosedFullyIndexedRatePercent the disclosedFullyIndexedRatePercent to set
	 */
	public void setDisclosedFullyIndexedRatePercent(String disclosedFullyIndexedRatePercent) {
		this.disclosedFullyIndexedRatePercent = disclosedFullyIndexedRatePercent;
	}
	/**
	 * @return the interestRateIncreaseIndicator
	 */
	public boolean isInterestRateIncreaseIndicator() {
		return interestRateIncreaseIndicator;
	}
	/**
	 * @param interestRateIncreaseIndicator the interestRateIncreaseIndicator to set
	 */
	public void setInterestRateIncreaseIndicator(boolean interestRateIncreaseIndicator) {
		this.interestRateIncreaseIndicator = interestRateIncreaseIndicator;
	}
	/**
	 * @return the adjustmentRuleTypeFirst
	 */
	public String getAdjustmentRuleTypeFirst() {
		return adjustmentRuleTypeFirst;
	}
	/**
	 * @param adjustmentRuleTypeFirst the adjustmentRuleTypeFirst to set
	 */
	public void setAdjustmentRuleTypeFirst(String adjustmentRuleTypeFirst) {
		this.adjustmentRuleTypeFirst = adjustmentRuleTypeFirst;
	}
	/**
	 * @return the perChangeRateAdjustmentFrequencyMonthsCount
	 */
	public String getPerChangeRateAdjustmentFrequencyMonthsCount() {
		return perChangeRateAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @param perChangeRateAdjustmentFrequencyMonthsCount the perChangeRateAdjustmentFrequencyMonthsCount to set
	 */
	public void setPerChangeRateAdjustmentFrequencyMonthsCount(String perChangeRateAdjustmentFrequencyMonthsCount) {
		this.perChangeRateAdjustmentFrequencyMonthsCount = perChangeRateAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @return the firstRateChangeMonthsCount
	 */
	public String getFirstRateChangeMonthsCount() {
		return firstRateChangeMonthsCount;
	}
	/**
	 * @param firstRateChangeMonthsCount the firstRateChangeMonthsCount to set
	 */
	public void setFirstRateChangeMonthsCount(String firstRateChangeMonthsCount) {
		this.firstRateChangeMonthsCount = firstRateChangeMonthsCount;
	}
	/**
	 * @return the ceilingRatePercentEarliestEffectiveMonthsCount
	 */
	public String getCeilingRatePercentEarliestEffectiveMonthsCount() {
		return ceilingRatePercentEarliestEffectiveMonthsCount;
	}
	/**
	 * @param ceilingRatePercentEarliestEffectiveMonthsCount the ceilingRatePercentEarliestEffectiveMonthsCount to set
	 */
	public void setCeilingRatePercentEarliestEffectiveMonthsCount(String ceilingRatePercentEarliestEffectiveMonthsCount) {
		this.ceilingRatePercentEarliestEffectiveMonthsCount = ceilingRatePercentEarliestEffectiveMonthsCount;
	}
	/**
	 * @return the ceilingRatePercent
	 */
	public String getCeilingRatePercent() {
		return ceilingRatePercent;
	}
	/**
	 * @param ceilingRatePercent the ceilingRatePercent to set
	 */
	public void setCeilingRatePercent(String ceilingRatePercent) {
		this.ceilingRatePercent = ceilingRatePercent;
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
	 * @return the loanPriceQuote
	 */
	public String getLoanPriceQuote() {
		return loanPriceQuote;
	}
	/**
	 * @param loanPriceQuote the loanPriceQuote to set
	 */
	public void setLoanPriceQuote(String loanPriceQuote) {
		this.loanPriceQuote = loanPriceQuote;
	}
	/**
	 * @return the apor
	 */
	public String getApor() {
		return apor;
	}
	/**
	 * @param apor the apor to set
	 */
	public void setApor(String apor) {
		this.apor = apor;
	}
	
	
	
}
