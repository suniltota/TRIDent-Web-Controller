package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class EstimatedPropertyCostComponent extends MISMODataAccessObject {
	public final String ProjectedPaymentEscrowedType;
	public final String ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType;
	public final String ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription;
	
	public EstimatedPropertyCostComponent(Element element) {
		super(element);
		ProjectedPaymentEscrowedType = getValueAddNS("ProjectedPaymentEscrowedType");
		ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType = getValueAddNS("ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType");
		ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription = getValueAddNS("ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription");
	}
}
