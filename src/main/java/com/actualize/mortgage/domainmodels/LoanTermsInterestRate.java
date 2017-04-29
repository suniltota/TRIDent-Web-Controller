package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class LoanTermsInterestRate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7964998098675066631L;
	
	private boolean buydownTemporarySubsidyFundingIndicator;
	private boolean gseBuydownReflectedInNoteIndicator;
	private String buydownInitialEffectiveInterestRatePercent;
	private String buydownChangeFrequencyMonthsCount;
	private String buydownIncreaseRatePercent;
	private String noteRatePercent;
	private String disclosedFullyIndexedRatePercent;
	private boolean interestRateIncreaseIndicator;
	private String adjustmentRuleTypeFirst;
	private String perChangeRateAdjustmentFrequencyMonthsCount;
	private String firstRateChangeMonthsCount;
	private String ceilingRatePercentEarliestEffectiveMonthsCount;
	private String ceilingRatePercent;
	
	/**
	 * @return the buydownTemporarySubsidyFundingIndicator
	 */
	public boolean isBuydownTemporarySubsidyFundingIndicator() {
		return buydownTemporarySubsidyFundingIndicator;
	}
	/**
	 * @param buydownTemporarySubsidyFundingIndicator the buydownTemporarySubsidyFundingIndicator to set
	 */
	public void setBuydownTemporarySubsidyFundingIndicator(boolean buydownTemporarySubsidyFundingIndicator) {
		this.buydownTemporarySubsidyFundingIndicator = buydownTemporarySubsidyFundingIndicator;
	}
	/**
	 * @return the gseBuydownReflectedInNoteIndicator
	 */
	public boolean isGseBuydownReflectedInNoteIndicator() {
		return gseBuydownReflectedInNoteIndicator;
	}
	/**
	 * @param gseBuydownReflectedInNoteIndicator the gseBuydownReflectedInNoteIndicator to set
	 */
	public void setGseBuydownReflectedInNoteIndicator(boolean gseBuydownReflectedInNoteIndicator) {
		this.gseBuydownReflectedInNoteIndicator = gseBuydownReflectedInNoteIndicator;
	}
	/**
	 * @return the buydownInitialEffectiveInterestRatePercent
	 */
	public String getBuydownInitialEffectiveInterestRatePercent() {
		return buydownInitialEffectiveInterestRatePercent;
	}
	/**
	 * @param buydownInitialEffectiveInterestRatePercent the buydownInitialEffectiveInterestRatePercent to set
	 */
	public void setBuydownInitialEffectiveInterestRatePercent(String buydownInitialEffectiveInterestRatePercent) {
		this.buydownInitialEffectiveInterestRatePercent = buydownInitialEffectiveInterestRatePercent;
	}
	/**
	 * @return the buydownChangeFrequencyMonthsCount
	 */
	public String getBuydownChangeFrequencyMonthsCount() {
		return buydownChangeFrequencyMonthsCount;
	}
	/**
	 * @param buydownChangeFrequencyMonthsCount the buydownChangeFrequencyMonthsCount to set
	 */
	public void setBuydownChangeFrequencyMonthsCount(String buydownChangeFrequencyMonthsCount) {
		this.buydownChangeFrequencyMonthsCount = buydownChangeFrequencyMonthsCount;
	}
	/**
	 * @return the buydownIncreaseRatePercent
	 */
	public String getBuydownIncreaseRatePercent() {
		return buydownIncreaseRatePercent;
	}
	/**
	 * @param buydownIncreaseRatePercent the buydownIncreaseRatePercent to set
	 */
	public void setBuydownIncreaseRatePercent(String buydownIncreaseRatePercent) {
		this.buydownIncreaseRatePercent = buydownIncreaseRatePercent;
	}
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
	
	
	
}
