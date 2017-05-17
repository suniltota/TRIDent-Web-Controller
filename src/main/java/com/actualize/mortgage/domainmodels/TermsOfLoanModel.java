/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * defines TermsOfLoan in JSON response
 * @author sboragala
 *
 */
public class TermsOfLoanModel implements Serializable {

	private static  long serialVersionUID = -2962206706752424316L;
	
	private String assumedLoanAmount;
	private String disclosedFullyIndexedRatePercent;
	private String lienPriorityType;
	private String loanPurposeType;
	private String mortgageType;
	private String mortgageTypeOtherDescription;
	private String noteAmount;
	private String noteRatePercent;
	private String weightedAverageInterestRatePercent;
	
	/**
	 * @return the assumedLoanAmount
	 */
	public String getAssumedLoanAmount() {
		return assumedLoanAmount;
	}
	/**
	 * @param assumedLoanAmount the assumedLoanAmount to set
	 */
	public void setAssumedLoanAmount(String assumedLoanAmount) {
		this.assumedLoanAmount = assumedLoanAmount;
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
	 * @return the loanPurposeType
	 */
	public String getLoanPurposeType() {
		return loanPurposeType;
	}
	/**
	 * @param loanPurposeType the loanPurposeType to set
	 */
	public void setLoanPurposeType(String loanPurposeType) {
		this.loanPurposeType = loanPurposeType;
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
	/**
	 * @return the mortgageTypeOtherDescription
	 */
	public String getMortgageTypeOtherDescription() {
		return mortgageTypeOtherDescription;
	}
	/**
	 * @param mortgageTypeOtherDescription the mortgageTypeOtherDescription to set
	 */
	public void setMortgageTypeOtherDescription(String mortgageTypeOtherDescription) {
		this.mortgageTypeOtherDescription = mortgageTypeOtherDescription;
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
	 * @return the weightedAverageInterestRatePercent
	 */
	public String getWeightedAverageInterestRatePercent() {
		return weightedAverageInterestRatePercent;
	}
	/**
	 * @param weightedAverageInterestRatePercent the weightedAverageInterestRatePercent to set
	 */
	public void setWeightedAverageInterestRatePercent(String weightedAverageInterestRatePercent) {
		this.weightedAverageInterestRatePercent = weightedAverageInterestRatePercent;
	}
	
}
