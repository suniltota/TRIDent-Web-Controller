/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines the input parameters for calculating Late Charge Rule 
 * @author sboragala
 *
 */
public class LateChargeRuleUIObject implements Serializable{
	
	private static final long serialVersionUID = 7200073701320611824L;
	
	private String stateCode;
	private String lienPriorityType;
	private String noteAmount;
	private String loanPurpose;
	private String loanToValuePercent;
	private String loanMaturityPeriodCount;
	private String aprPercent;
	private String noteRatePercent;
	private String mortgageType;
	
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
	public String getNoteAmount() {
		return noteAmount;
	}
	/**
	 * @param noteAmount the noteAmount to set
	 */
	public void setNoteAmount(String noteAmount) {
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
	public String getLoanToValuePercent() {
		return loanToValuePercent;
	}
	/**
	 * @param loanToValuePercent the loanToValuePercent to set
	 */
	public void setLoanToValuePercent(String loanToValuePercent) {
		this.loanToValuePercent = loanToValuePercent;
	}
	/**
	 * @return the loanMaturityPeriodCount
	 */
	public String getLoanMaturityPeriodCount() {
		return loanMaturityPeriodCount;
	}
	/**
	 * @param loanMaturityPeriodCount the loanMaturityPeriodCount to set
	 */
	public void setLoanMaturityPeriodCount(String loanMaturityPeriodCount) {
		this.loanMaturityPeriodCount = loanMaturityPeriodCount;
	}
	/**
	 * @return the aprPercent
	 */
	public String getAprPercent() {
		return aprPercent;
	}
	/**
	 * @param aprPercent the aprPercent to set
	 */
	public void setAprPercent(String aprPercent) {
		this.aprPercent = aprPercent;
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
	 * @return the mortgageType
	 */
	public String getMortgageType() {
		return mortgageType;
	}
	/**
	 * @param mortgageType the mortgageType to set
	 */
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	
	

}
