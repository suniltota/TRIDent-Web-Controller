package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

/**
 * Defines ETIA Section in JSON response
 * @author sboragala
 *
 */
public class ETIASection implements Serializable {

	private static final long serialVersionUID = 1185489693159686185L;

	private List<String> escrowTypes;
	private String projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount;
	private List<ETIA> etiaValues;
	
	/**
	 * @return the escrowTypes
	 */
	public List<String> getEscrowTypes() {
		return escrowTypes;
	}
	/**
	 * @param escrowTypes the escrowTypes to set
	 */
	public void setEscrowTypes(List<String> escrowTypes) {
		this.escrowTypes = escrowTypes;
	}
	/**
	 * @return the projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount
	 */
	public String getProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount() {
		return projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount;
	}
	/**
	 * @param projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount the projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount to set
	 */
	public void setProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount(
			String projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount) {
		this.projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount = projectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount;
	}
	/**
	 * @return the etiaValues
	 */
	public List<ETIA> getEtiaValues() {
		return etiaValues;
	}
	/**
	 * @param etiaValues the etiaValues to set
	 */
	public void setEtiaValues(List<ETIA> etiaValues) {
		this.etiaValues = etiaValues;
	}
	
	
	

}
