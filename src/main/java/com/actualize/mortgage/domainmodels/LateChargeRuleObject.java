/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.util.List;

/**
 * @author sboragala
 *
 */
public class LateChargeRuleObject {

	private String stateCode;
	private String lienPriorityType;
	private LateRuleProperties noteAmount;
	private String loanPurpose;
	private LateRuleProperties loanToValuePercent;
	private LateRuleProperties loanMaturityPeriodCount;
	private LateRuleProperties aprPercent;
	private LateRuleProperties noteRatePercent;
	private List<String> mortgageType;
	private String lateChargeGracePeriodDaysCount;
	private String lateChargeRatePercent;
	private String lateChargeMinimumAmount;
	private String lateChargeMaximumAmount;
	
	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}
	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * @return the lienPriorityType
	 */
	public String getLienPriorityType() {
		return lienPriorityType;
	}
	/**
	 * @param lienPriorityType the lienPriorityType to set
	 */
	public void setLienPriorityType(String lienPriorityType) {
		this.lienPriorityType = lienPriorityType;
	}
	/**
	 * @return the noteAmount
	 */
	public LateRuleProperties getNoteAmount() {
		return noteAmount;
	}
	/**
	 * @param noteAmount the noteAmount to set
	 */
	public void setNoteAmount(LateRuleProperties noteAmount) {
		this.noteAmount = noteAmount;
	}
	/**
	 * @return the loanPurpose
	 */
	public String getLoanPurpose() {
		return loanPurpose;
	}
	/**
	 * @param loanPurpose the loanPurpose to set
	 */
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	/**
	 * @return the loanToValuePercent
	 */
	public LateRuleProperties getLoanToValuePercent() {
		return loanToValuePercent;
	}
	/**
	 * @param loanToValuePercent the loanToValuePercent to set
	 */
	public void setLoanToValuePercent(LateRuleProperties loanToValuePercent) {
		this.loanToValuePercent = loanToValuePercent;
	}
	/**
	 * @return the loanMaturityPeriodCount
	 */
	public LateRuleProperties getLoanMaturityPeriodCount() {
		return loanMaturityPeriodCount;
	}
	/**
	 * @param loanMaturityPeriodCount the loanMaturityPeriodCount to set
	 */
	public void setLoanMaturityPeriodCount(LateRuleProperties loanMaturityPeriodCount) {
		this.loanMaturityPeriodCount = loanMaturityPeriodCount;
	}
	/**
	 * @return the aprPercent
	 */
	public LateRuleProperties getAprPercent() {
		return aprPercent;
	}
	/**
	 * @param aprPercent the aprPercent to set
	 */
	public void setAprPercent(LateRuleProperties aprPercent) {
		this.aprPercent = aprPercent;
	}
	/**
	 * @return the noteRatePercent
	 */
	public LateRuleProperties getNoteRatePercent() {
		return noteRatePercent;
	}
	/**
	 * @param noteRatePercent the noteRatePercent to set
	 */
	public void setNoteRatePercent(LateRuleProperties noteRatePercent) {
		this.noteRatePercent = noteRatePercent;
	}
	/**
	 * @return the mortgageType
	 */
	public List<String> getMortgageType() {
		return mortgageType;
	}
	/**
	 * @param mortgageType the mortgageType to set
	 */
	public void setMortgageType(List<String> mortgageType) {
		this.mortgageType = mortgageType;
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
	 * @return the lateChargeMinimumAmount
	 */
	public String getLateChargeMinimumAmount() {
		return lateChargeMinimumAmount;
	}
	/**
	 * @param lateChargeMinimumAmount the lateChargeMinimumAmount to set
	 */
	public void setLateChargeMinimumAmount(String lateChargeMinimumAmount) {
		this.lateChargeMinimumAmount = lateChargeMinimumAmount;
	}
	/**
	 * @return the lateChargeMaximumAmount
	 */
	public String getLateChargeMaximumAmount() {
		return lateChargeMaximumAmount;
	}
	/**
	 * @param lateChargeMaximumAmount the lateChargeMaximumAmount to set
	 */
	public void setLateChargeMaximumAmount(String lateChargeMaximumAmount) {
		this.lateChargeMaximumAmount = lateChargeMaximumAmount;
	}
	
	
}
