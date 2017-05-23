package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * This class defines Payment Calculation for Projected Payments in JSON Response
 * @author sboragala
 *
 */
public class ProjectedPaymentsPC  implements Serializable{
	
	private static final long serialVersionUID = -3182209711085503326L;
	private String sequenceNumber = "";
	private String projectedPaymentCalculationPeriodEndNumber = "";
    private String projectedPaymentCalculationPeriodStartNumber = "";
    private String projectedPaymentCalculationPeriodTermType = "";
    private String projectedPaymentCalculationPeriodTermTypeOtherDescription = "";
    
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
    
}
