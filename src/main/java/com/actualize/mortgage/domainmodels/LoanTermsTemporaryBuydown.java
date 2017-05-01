package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * This defines the TemporaryBuydown of Loan Terms in JSON Response 
 * @author sboragala
 *
 */
public class LoanTermsTemporaryBuydown implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6107484815432690161L;
	
	private boolean buydownTemporarySubsidyFundingIndicator; 
	private String buydownInitialEffectiveInterestRatePercent;
	private boolean gseBuydownReflectedInNoteIndicator;
	private String rateAfterBuydownApplied;//TBD
	private String buydownChangeFrequencyMonthsCount;
	private String totalNumberOfMonths; //TBD
	private String buydownIncreaseRatePercent;
	
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
	 * @return the rateAfterBuydownApplied
	 */
	public String getRateAfterBuydownApplied() {
		return rateAfterBuydownApplied;
	}
	/**
	 * @param rateAfterBuydownApplied the rateAfterBuydownApplied to set
	 */
	public void setRateAfterBuydownApplied(String rateAfterBuydownApplied) {
		this.rateAfterBuydownApplied = rateAfterBuydownApplied;
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
	 * @return the totalNumberOfMonths
	 */
	public String getTotalNumberOfMonths() {
		return totalNumberOfMonths;
	}
	/**
	 * @param totalNumberOfMonths the totalNumberOfMonths to set
	 */
	public void setTotalNumberOfMonths(String totalNumberOfMonths) {
		this.totalNumberOfMonths = totalNumberOfMonths;
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

	
	
}
