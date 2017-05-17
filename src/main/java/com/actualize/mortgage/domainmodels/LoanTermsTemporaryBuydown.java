package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * This defines the TemporaryBuydown of Loan Terms in JSON Response 
 * @author sboragala
 *
 */
public class LoanTermsTemporaryBuydown implements Serializable {
	
	private static final long serialVersionUID = 4018555262212370899L;
	
	private String buydownInitialEffectiveInterestRatePercent;
	private boolean gseBuydownReflectedInNoteIndicator;
	private String buydownChangeFrequencyMonthsCount;
	private String buydownDurationMonthsCount;
	private String buydownIncreaseRatePercent;
	
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
	 * @return the buydownDurationMonthsCount
	 */
	public String getBuydownDurationMonthsCount() {
		return buydownDurationMonthsCount;
	}
	/**
	 * @param buydownDurationMonthsCount the buydownDurationMonthsCount to set
	 */
	public void setBuydownDurationMonthsCount(String buydownDurationMonthsCount) {
		this.buydownDurationMonthsCount = buydownDurationMonthsCount;
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
