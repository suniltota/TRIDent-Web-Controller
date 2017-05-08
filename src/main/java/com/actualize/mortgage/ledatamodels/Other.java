package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Other extends MISMODataAccessObject {
	public final String integratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
	public final String lockExpirationTimezoneType;
	public final String buydownReflectedInNoteIndicator;                                 
	public final String documentSignatureRequiredIndicator;                              
	public final String escrowAccountRolloverAmount;                                     
	public final String integratedDisclosureSectionType;                                 
	public final String liabilitySecuredBySubjectPropertyIndicator;                      
	public final String totalOptionalPaymentCount;                                       
	public final String totalStepCount;                                                  
	public final String totalStepPaymentCount;                                           
	public final String subordinateFinancingIsNewIndicator;                              
	
	
	
	public Other(Element element) {
		super(element);
		integratedDisclosureEstimatedClosingCostsExpirationTimezoneType = getValue("gse:IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType");
		lockExpirationTimezoneType = getValue("gse:LockExpirationTimezoneType");
		buydownReflectedInNoteIndicator = getValue("gse:BuydownReflectedInNoteIndicator");
		documentSignatureRequiredIndicator = getValue("gse:DocumentSignatureRequiredIndicator");
		escrowAccountRolloverAmount = getValue("gse:EscrowAccountRolloverAmount");
		integratedDisclosureSectionType = getValue("gse:IntegratedDisclosureSectionType");
		liabilitySecuredBySubjectPropertyIndicator = getValue("gse:LiabilitySecuredBySubjectPropertyIndicator");
		totalOptionalPaymentCount = getValue("gse:TotalOptionalPaymentCount");
		totalStepCount = getValue("gse:TotalStepCount");
		totalStepPaymentCount = getValue("gse:TotalStepPaymentCount");
		subordinateFinancingIsNewIndicator = getValue("gse:SubordinateFinancingIsNewIndicator");
	
	}
}
