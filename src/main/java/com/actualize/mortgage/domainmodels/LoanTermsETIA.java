package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class LoanTermsETIA implements Serializable {

	private static final long serialVersionUID = -3720790984820770245L;
	
	private String projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType;
	private String projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription;
	private String projectedPaymentEscrowedType;
	
	public String getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType() {
		return projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType;
	}
	public void setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType(
			String projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType) {
		this.projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType = projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType;
	}
	public String getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription() {
		return projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription;
	}
	public void setProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription(
			String projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription) {
		this.projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription = projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription;
	}
	public String getProjectedPaymentEscrowedType() {
		return projectedPaymentEscrowedType;
	}
	public void setProjectedPaymentEscrowedType(String projectedPaymentEscrowedType) {
		this.projectedPaymentEscrowedType = projectedPaymentEscrowedType;
	}
	
	
}
