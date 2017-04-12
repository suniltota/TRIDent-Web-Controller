package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.actualize.mortgage.utils.Expenses;


public class AdjustmentsModel extends Expenses implements Serializable{

	private static final long serialVersionUID = -5437068188309869048L;
	private String typeOtherDescription = "";
	private String integratedDisclosureSubsectionType = "";
	
	public String getTypeOtherDescription() {
		return typeOtherDescription;
	}
	public void setTypeOtherDescription(String typeOtherDescription) {
		this.typeOtherDescription = typeOtherDescription;
	}
	public String getIntegratedDisclosureSubsectionType() {
		return integratedDisclosureSubsectionType;
	}
	public void setIntegratedDisclosureSubsectionType(String integratedDisclosureSubsectionType) {
		this.integratedDisclosureSubsectionType = integratedDisclosureSubsectionType;
	}
	
	
}
