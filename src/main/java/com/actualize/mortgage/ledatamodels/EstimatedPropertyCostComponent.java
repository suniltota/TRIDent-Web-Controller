package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * 
 * @author sboragala
 *
 */
public class EstimatedPropertyCostComponent extends MISMODataAccessObject {
	public final String projectedPaymentEscrowedType;
	public final String projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType;
	public final String projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription;
	
	public EstimatedPropertyCostComponent(Element element) {
		super(element);
		projectedPaymentEscrowedType = getValueAddNS("ProjectedPaymentEscrowedType");
		projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType = getValueAddNS("ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType");
		projectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription = getValueAddNS("ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription");
	}
}
