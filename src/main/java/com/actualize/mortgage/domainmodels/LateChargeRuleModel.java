/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class LateChargeRuleModel implements Serializable {

	private static final long serialVersionUID = -1672022915224742394L;
	
	private String lateChargeAmount;
    private String lateChargeGracePeriodDaysCount;
    private String lateChargeRatePercent;
    private String lateChargeType;
    
	/**
	 * @return the lateChargeAmount
	 */
	public String getLateChargeAmount() {
		return lateChargeAmount;
	}
	/**
	 * @param lateChargeAmount the lateChargeAmount to set
	 */
	public void setLateChargeAmount(String lateChargeAmount) {
		this.lateChargeAmount = lateChargeAmount;
	}
	/**
	 * @return the lateChargeGracePeriodDaysCount
	 */
	public String getLateChargeGracePeriodDaysCount() {
		return lateChargeGracePeriodDaysCount;
	}
	/**
	 * @param lateChargeGracePeriodDaysCount the lateChargeGracePeriodDaysCount to set
	 */
	public void setLateChargeGracePeriodDaysCount(String lateChargeGracePeriodDaysCount) {
		this.lateChargeGracePeriodDaysCount = lateChargeGracePeriodDaysCount;
	}
	/**
	 * @return the lateChargeRatePercent
	 */
	public String getLateChargeRatePercent() {
		return lateChargeRatePercent;
	}
	/**
	 * @param lateChargeRatePercent the lateChargeRatePercent to set
	 */
	public void setLateChargeRatePercent(String lateChargeRatePercent) {
		this.lateChargeRatePercent = lateChargeRatePercent;
	}
	/**
	 * @return the lateChargeType
	 */
	public String getLateChargeType() {
		return lateChargeType;
	}
	/**
	 * @param lateChargeType the lateChargeType to set
	 */
	public void setLateChargeType(String lateChargeType) {
		this.lateChargeType = lateChargeType;
	}
    
    
	
}
