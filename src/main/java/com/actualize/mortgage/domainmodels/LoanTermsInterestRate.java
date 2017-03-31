package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class LoanTermsInterestRate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7964998098675066631L;
	
	private String interest;
	private String status;
	private List<String> details;
	private String buydownTemporarySubsidyFundingIndicator;
	private String gseBuydownReflectedInNoteIndicator;
	private String buydownInitialEffectiveInterestRatePercent;
	private String buydownChangeFrequencyMonthsCount;
	private String buydownIncreaseRatePercent;
	private String noteRatePercent;
	private String disclosedFullyIndexedRatePercent;
	private String interestRateIncreaseIndicator;
	private String adjustmentRuleTypeFirst;
	private String perChangeRateAdjustmentFrequencyMonthsCount;
	private String firstRateChangeMonthsCount;
	private String ceilingRatePercentEarliestEffectiveMonthsCount;
	private String ceilingRatePercent;
	
	
	
	/**
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
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
	public String getBuydownTemporarySubsidyFundingIndicator() {
		return buydownTemporarySubsidyFundingIndicator;
	}
	public void setBuydownTemporarySubsidyFundingIndicator(String buydownTemporarySubsidyFundingIndicator) {
		this.buydownTemporarySubsidyFundingIndicator = buydownTemporarySubsidyFundingIndicator;
	}
	public String getGseBuydownReflectedInNoteIndicator() {
		return gseBuydownReflectedInNoteIndicator;
	}
	public void setGseBuydownReflectedInNoteIndicator(String gseBuydownReflectedInNoteIndicator) {
		this.gseBuydownReflectedInNoteIndicator = gseBuydownReflectedInNoteIndicator;
	}
	public String getBuydownInitialEffectiveInterestRatePercent() {
		return buydownInitialEffectiveInterestRatePercent;
	}
	public void setBuydownInitialEffectiveInterestRatePercent(String buydownInitialEffectiveInterestRatePercent) {
		this.buydownInitialEffectiveInterestRatePercent = buydownInitialEffectiveInterestRatePercent;
	}
	public String getBuydownChangeFrequencyMonthsCount() {
		return buydownChangeFrequencyMonthsCount;
	}
	public void setBuydownChangeFrequencyMonthsCount(String buydownChangeFrequencyMonthsCount) {
		this.buydownChangeFrequencyMonthsCount = buydownChangeFrequencyMonthsCount;
	}
	public String getBuydownIncreaseRatePercent() {
		return buydownIncreaseRatePercent;
	}
	public void setBuydownIncreaseRatePercent(String buydownIncreaseRatePercent) {
		this.buydownIncreaseRatePercent = buydownIncreaseRatePercent;
	}
	public String getNoteRatePercent() {
		return noteRatePercent;
	}
	public void setNoteRatePercent(String noteRatePercent) {
		this.noteRatePercent = noteRatePercent;
	}
	public String getDisclosedFullyIndexedRatePercent() {
		return disclosedFullyIndexedRatePercent;
	}
	public void setDisclosedFullyIndexedRatePercent(String disclosedFullyIndexedRatePercent) {
		this.disclosedFullyIndexedRatePercent = disclosedFullyIndexedRatePercent;
	}
	public String getInterestRateIncreaseIndicator() {
		return interestRateIncreaseIndicator;
	}
	public void setInterestRateIncreaseIndicator(String interestRateIncreaseIndicator) {
		this.interestRateIncreaseIndicator = interestRateIncreaseIndicator;
	}
	public String getAdjustmentRuleTypeFirst() {
		return adjustmentRuleTypeFirst;
	}
	public void setAdjustmentRuleTypeFirst(String adjustmentRuleTypeFirst) {
		this.adjustmentRuleTypeFirst = adjustmentRuleTypeFirst;
	}
	public String getPerChangeRateAdjustmentFrequencyMonthsCount() {
		return perChangeRateAdjustmentFrequencyMonthsCount;
	}
	public void setPerChangeRateAdjustmentFrequencyMonthsCount(String perChangeRateAdjustmentFrequencyMonthsCount) {
		this.perChangeRateAdjustmentFrequencyMonthsCount = perChangeRateAdjustmentFrequencyMonthsCount;
	}
	public String getFirstRateChangeMonthsCount() {
		return firstRateChangeMonthsCount;
	}
	public void setFirstRateChangeMonthsCount(String firstRateChangeMonthsCount) {
		this.firstRateChangeMonthsCount = firstRateChangeMonthsCount;
	}
	public String getCeilingRatePercentEarliestEffectiveMonthsCount() {
		return ceilingRatePercentEarliestEffectiveMonthsCount;
	}
	public void setCeilingRatePercentEarliestEffectiveMonthsCount(String ceilingRatePercentEarliestEffectiveMonthsCount) {
		this.ceilingRatePercentEarliestEffectiveMonthsCount = ceilingRatePercentEarliestEffectiveMonthsCount;
	}
	public String getCeilingRatePercent() {
		return ceilingRatePercent;
	}
	public void setCeilingRatePercent(String ceilingRatePercent) {
		this.ceilingRatePercent = ceilingRatePercent;
	}
	
	
}
