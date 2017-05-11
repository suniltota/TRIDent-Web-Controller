/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines response for AIR Table
 * @author sboragala
 *
 */
public class InterestRateAdjustmentModel implements Serializable {

	private static final long serialVersionUID = -6616020790772007494L;

	private String indexType; 
	private String indexTypeOtherDescription;
	private String ceilingRatePercent;
	private String ceilingRatePercentEarliestEffectiveMonthsCount;
	private String firstRateChangeMonthsCount;
	private String floorRatePercent;
	private String marginRatePercent;
	private String totalStepCount;
	private String firstAdjustmentRule;
	private String subsequentAdjustmentRule;
	private String firstPerChangeMaximumIncreaseRatePercent;
	private String firstPerChangeRateAdjustmentFrequencyMonthsCount;
	private String subsequentPerChangeMaximumIncreaseRatePercent;
	private String subsequentPerChangeRateAdjustmentFrequencyMonthsCount;
	
	/**
	 * @return the indexType
	 */
	public String getIndexType() {
		return indexType;
	}
	/**
	 * @param indexType the indexType to set
	 */
	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}
	/**
	 * @return the indexTypeOtherDescription
	 */
	public String getIndexTypeOtherDescription() {
		return indexTypeOtherDescription;
	}
	/**
	 * @param indexTypeOtherDescription the indexTypeOtherDescription to set
	 */
	public void setIndexTypeOtherDescription(String indexTypeOtherDescription) {
		this.indexTypeOtherDescription = indexTypeOtherDescription;
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
	 * @return the floorRatePercent
	 */
	public String getFloorRatePercent() {
		return floorRatePercent;
	}
	/**
	 * @param floorRatePercent the floorRatePercent to set
	 */
	public void setFloorRatePercent(String floorRatePercent) {
		this.floorRatePercent = floorRatePercent;
	}
	/**
	 * @return the marginRatePercent
	 */
	public String getMarginRatePercent() {
		return marginRatePercent;
	}
	/**
	 * @param marginRatePercent the marginRatePercent to set
	 */
	public void setMarginRatePercent(String marginRatePercent) {
		this.marginRatePercent = marginRatePercent;
	}
	/**
	 * @return the totalStepCount
	 */
	public String getTotalStepCount() {
		return totalStepCount;
	}
	/**
	 * @param totalStepCount the totalStepCount to set
	 */
	public void setTotalStepCount(String totalStepCount) {
		this.totalStepCount = totalStepCount;
	}
	/**
	 * @return the firstAdjustmentRule
	 */
	public String getFirstAdjustmentRule() {
		return firstAdjustmentRule;
	}
	/**
	 * @param firstAdjustmentRule the firstAdjustmentRule to set
	 */
	public void setFirstAdjustmentRule(String firstAdjustmentRule) {
		this.firstAdjustmentRule = firstAdjustmentRule;
	}
	/**
	 * @return the subsequentAdjustmentRule
	 */
	public String getSubsequentAdjustmentRule() {
		return subsequentAdjustmentRule;
	}
	/**
	 * @param subsequentAdjustmentRule the subsequentAdjustmentRule to set
	 */
	public void setSubsequentAdjustmentRule(String subsequentAdjustmentRule) {
		this.subsequentAdjustmentRule = subsequentAdjustmentRule;
	}
	/**
	 * @return the firstPerChangeMaximumIncreaseRatePercent
	 */
	public String getFirstPerChangeMaximumIncreaseRatePercent() {
		return firstPerChangeMaximumIncreaseRatePercent;
	}
	/**
	 * @param firstPerChangeMaximumIncreaseRatePercent the firstPerChangeMaximumIncreaseRatePercent to set
	 */
	public void setFirstPerChangeMaximumIncreaseRatePercent(String firstPerChangeMaximumIncreaseRatePercent) {
		this.firstPerChangeMaximumIncreaseRatePercent = firstPerChangeMaximumIncreaseRatePercent;
	}
	/**
	 * @return the firstPerChangeRateAdjustmentFrequencyMonthsCount
	 */
	public String getFirstPerChangeRateAdjustmentFrequencyMonthsCount() {
		return firstPerChangeRateAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @param firstPerChangeRateAdjustmentFrequencyMonthsCount the firstPerChangeRateAdjustmentFrequencyMonthsCount to set
	 */
	public void setFirstPerChangeRateAdjustmentFrequencyMonthsCount(
			String firstPerChangeRateAdjustmentFrequencyMonthsCount) {
		this.firstPerChangeRateAdjustmentFrequencyMonthsCount = firstPerChangeRateAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @return the subsequentPerChangeMaximumIncreaseRatePercent
	 */
	public String getSubsequentPerChangeMaximumIncreaseRatePercent() {
		return subsequentPerChangeMaximumIncreaseRatePercent;
	}
	/**
	 * @param subsequentPerChangeMaximumIncreaseRatePercent the subsequentPerChangeMaximumIncreaseRatePercent to set
	 */
	public void setSubsequentPerChangeMaximumIncreaseRatePercent(String subsequentPerChangeMaximumIncreaseRatePercent) {
		this.subsequentPerChangeMaximumIncreaseRatePercent = subsequentPerChangeMaximumIncreaseRatePercent;
	}
	/**
	 * @return the subsequentPerChangeRateAdjustmentFrequencyMonthsCount
	 */
	public String getSubsequentPerChangeRateAdjustmentFrequencyMonthsCount() {
		return subsequentPerChangeRateAdjustmentFrequencyMonthsCount;
	}
	/**
	 * @param subsequentPerChangeRateAdjustmentFrequencyMonthsCount the subsequentPerChangeRateAdjustmentFrequencyMonthsCount to set
	 */
	public void setSubsequentPerChangeRateAdjustmentFrequencyMonthsCount(
			String subsequentPerChangeRateAdjustmentFrequencyMonthsCount) {
		this.subsequentPerChangeRateAdjustmentFrequencyMonthsCount = subsequentPerChangeRateAdjustmentFrequencyMonthsCount;
	}
	
	
	
}
