package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class Other extends MISMODataAccessObject {
	public final String IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
	public final String LockExpirationTimezoneType;
	public final String BuydownReflectedInNoteIndicator;                                 
	public final String DocumentSignatureRequiredIndicator;                              
	public final String EscrowAccountRolloverAmount;                                     
	public final String IntegratedDisclosureSectionType;                                 
	public final String LiabilitySecuredBySubjectPropertyIndicator;                      
	public final String TotalOptionalPaymentCount;                                       
	public final String TotalStepCount;                                                  
	public final String TotalStepPaymentCount;                                           
	public final String SubordinateFinancingIsNewIndicator;                              
	
	
	
	public Other(Element element) {
		super(element);
		IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType = getValue("gse:IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType");
		LockExpirationTimezoneType = getValue("gse:LockExpirationTimezoneType");
		BuydownReflectedInNoteIndicator = getValue("gse:BuydownReflectedInNoteIndicator");
		DocumentSignatureRequiredIndicator = getValue("gse:DocumentSignatureRequiredIndicator");
		EscrowAccountRolloverAmount = getValue("gse:EscrowAccountRolloverAmount");
		IntegratedDisclosureSectionType = getValue("gse:IntegratedDisclosureSectionType");
		LiabilitySecuredBySubjectPropertyIndicator = getValue("gse:LiabilitySecuredBySubjectPropertyIndicator");
		TotalOptionalPaymentCount = getValue("gse:TotalOptionalPaymentCount");
		TotalStepCount = getValue("gse:TotalStepCount");
		TotalStepPaymentCount = getValue("gse:TotalStepPaymentCount");
		SubordinateFinancingIsNewIndicator = getValue("gse:SubordinateFinancingIsNewIndicator");
	
	}
}
