/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines projectedPayments as per MISMO to create MISMO XML
 * @author sboragala
 *
 */
public class MismoProjectedPaymentsModel implements Serializable {
	
	private static final long serialVersionUID = 5798479333459245723L;
	private String sequenceNumber = "";
	private String paymentFrequencyType = "";
	private String projectedPaymentCalculationPeriodEndNumber = "";
	private String projectedPaymentCalculationPeriodStartNumber = "";
	private String projectedPaymentCalculationPeriodTermType = "";
	private String projectedPaymentCalculationPeriodTermTypeOtherDescription = "";
	private String projectedPaymentEstimatedEscrowPaymentAmount = "";
	private String projectedPaymentEstimatedTotalMaximumPaymentAmount = "";
	private String projectedPaymentEstimatedTotalMinimumPaymentAmount = "";
	private String projectedPaymentMIPaymentAmount = "";
	private String projectedPaymentPrincipalAndInterestMaximumPaymentAmount = "";
	private String projectedPaymentPrincipalAndInterestMinimumPaymentAmount = "";
	
	/**
	 * @return the sequenceNumber
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}
	/**
	 * @param sequenceNumber the sequenceNumber to set
	 */
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	/**
	 * @return the paymentFrequencyType
	 */
	public String getPaymentFrequencyType() {
		return paymentFrequencyType;
	}
	/**
	 * @param paymentFrequencyType the paymentFrequencyType to set
	 */
	public void setPaymentFrequencyType(String paymentFrequencyType) {
		this.paymentFrequencyType = paymentFrequencyType;
	}
	/**
	 * @return the projectedPaymentCalculationPeriodEndNumber
	 */
	public String getProjectedPaymentCalculationPeriodEndNumber() {
		return projectedPaymentCalculationPeriodEndNumber;
	}
	/**
	 * @param projectedPaymentCalculationPeriodEndNumber the projectedPaymentCalculationPeriodEndNumber to set
	 */
	public void setProjectedPaymentCalculationPeriodEndNumber(String projectedPaymentCalculationPeriodEndNumber) {
		this.projectedPaymentCalculationPeriodEndNumber = projectedPaymentCalculationPeriodEndNumber;
	}
	/**
	 * @return the projectedPaymentCalculationPeriodStartNumber
	 */
	public String getProjectedPaymentCalculationPeriodStartNumber() {
		return projectedPaymentCalculationPeriodStartNumber;
	}
	/**
	 * @param projectedPaymentCalculationPeriodStartNumber the projectedPaymentCalculationPeriodStartNumber to set
	 */
	public void setProjectedPaymentCalculationPeriodStartNumber(String projectedPaymentCalculationPeriodStartNumber) {
		this.projectedPaymentCalculationPeriodStartNumber = projectedPaymentCalculationPeriodStartNumber;
	}
	/**
	 * @return the projectedPaymentCalculationPeriodTermType
	 */
	public String getProjectedPaymentCalculationPeriodTermType() {
		return projectedPaymentCalculationPeriodTermType;
	}
	/**
	 * @param projectedPaymentCalculationPeriodTermType the projectedPaymentCalculationPeriodTermType to set
	 */
	public void setProjectedPaymentCalculationPeriodTermType(String projectedPaymentCalculationPeriodTermType) {
		this.projectedPaymentCalculationPeriodTermType = projectedPaymentCalculationPeriodTermType;
	}
	/**
	 * @return the projectedPaymentCalculationPeriodTermTypeOtherDescription
	 */
	public String getProjectedPaymentCalculationPeriodTermTypeOtherDescription() {
		return projectedPaymentCalculationPeriodTermTypeOtherDescription;
	}
	/**
	 * @param projectedPaymentCalculationPeriodTermTypeOtherDescription the projectedPaymentCalculationPeriodTermTypeOtherDescription to set
	 */
	public void setProjectedPaymentCalculationPeriodTermTypeOtherDescription(
			String projectedPaymentCalculationPeriodTermTypeOtherDescription) {
		this.projectedPaymentCalculationPeriodTermTypeOtherDescription = projectedPaymentCalculationPeriodTermTypeOtherDescription;
	}
	/**
	 * @return the projectedPaymentEstimatedEscrowPaymentAmount
	 */
	public String getProjectedPaymentEstimatedEscrowPaymentAmount() {
		return projectedPaymentEstimatedEscrowPaymentAmount;
	}
	/**
	 * @param projectedPaymentEstimatedEscrowPaymentAmount the projectedPaymentEstimatedEscrowPaymentAmount to set
	 */
	public void setProjectedPaymentEstimatedEscrowPaymentAmount(String projectedPaymentEstimatedEscrowPaymentAmount) {
		this.projectedPaymentEstimatedEscrowPaymentAmount = projectedPaymentEstimatedEscrowPaymentAmount;
	}
	/**
	 * @return the projectedPaymentEstimatedTotalMaximumPaymentAmount
	 */
	public String getProjectedPaymentEstimatedTotalMaximumPaymentAmount() {
		return projectedPaymentEstimatedTotalMaximumPaymentAmount;
	}
	/**
	 * @param projectedPaymentEstimatedTotalMaximumPaymentAmount the projectedPaymentEstimatedTotalMaximumPaymentAmount to set
	 */
	public void setProjectedPaymentEstimatedTotalMaximumPaymentAmount(
			String projectedPaymentEstimatedTotalMaximumPaymentAmount) {
		this.projectedPaymentEstimatedTotalMaximumPaymentAmount = projectedPaymentEstimatedTotalMaximumPaymentAmount;
	}
	/**
	 * @return the projectedPaymentEstimatedTotalMinimumPaymentAmount
	 */
	public String getProjectedPaymentEstimatedTotalMinimumPaymentAmount() {
		return projectedPaymentEstimatedTotalMinimumPaymentAmount;
	}
	/**
	 * @param projectedPaymentEstimatedTotalMinimumPaymentAmount the projectedPaymentEstimatedTotalMinimumPaymentAmount to set
	 */
	public void setProjectedPaymentEstimatedTotalMinimumPaymentAmount(
			String projectedPaymentEstimatedTotalMinimumPaymentAmount) {
		this.projectedPaymentEstimatedTotalMinimumPaymentAmount = projectedPaymentEstimatedTotalMinimumPaymentAmount;
	}
	/**
	 * @return the projectedPaymentMIPaymentAmount
	 */
	public String getProjectedPaymentMIPaymentAmount() {
		return projectedPaymentMIPaymentAmount;
	}
	/**
	 * @param projectedPaymentMIPaymentAmount the projectedPaymentMIPaymentAmount to set
	 */
	public void setProjectedPaymentMIPaymentAmount(String projectedPaymentMIPaymentAmount) {
		this.projectedPaymentMIPaymentAmount = projectedPaymentMIPaymentAmount;
	}
	/**
	 * @return the projectedPaymentPrincipalAndInterestMaximumPaymentAmount
	 */
	public String getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount() {
		return projectedPaymentPrincipalAndInterestMaximumPaymentAmount;
	}
	/**
	 * @param projectedPaymentPrincipalAndInterestMaximumPaymentAmount the projectedPaymentPrincipalAndInterestMaximumPaymentAmount to set
	 */
	public void setProjectedPaymentPrincipalAndInterestMaximumPaymentAmount(
			String projectedPaymentPrincipalAndInterestMaximumPaymentAmount) {
		this.projectedPaymentPrincipalAndInterestMaximumPaymentAmount = projectedPaymentPrincipalAndInterestMaximumPaymentAmount;
	}
	/**
	 * @return the projectedPaymentPrincipalAndInterestMinimumPaymentAmount
	 */
	public String getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount() {
		return projectedPaymentPrincipalAndInterestMinimumPaymentAmount;
	}
	/**
	 * @param projectedPaymentPrincipalAndInterestMinimumPaymentAmount the projectedPaymentPrincipalAndInterestMinimumPaymentAmount to set
	 */
	public void setProjectedPaymentPrincipalAndInterestMinimumPaymentAmount(
			String projectedPaymentPrincipalAndInterestMinimumPaymentAmount) {
		this.projectedPaymentPrincipalAndInterestMinimumPaymentAmount = projectedPaymentPrincipalAndInterestMinimumPaymentAmount;
	}
	
	

}
