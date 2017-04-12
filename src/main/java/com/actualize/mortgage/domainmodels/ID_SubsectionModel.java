package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.actualize.mortgage.utils.Expenses;


public class ID_SubsectionModel extends Expenses implements Serializable{
	
	private static final long serialVersionUID = -1007218479530583378L;
	
	private String integratedDisclosureSectionType;
	private String integratedDisclosureSubsectionType;
	private String lenderTolerance;
	
	public String getIntegratedDisclosureSectionType() {
		return integratedDisclosureSectionType;
	}
	public void setIntegratedDisclosureSectionType(String integratedDisclosureSectionType) {
		this.integratedDisclosureSectionType = integratedDisclosureSectionType;
	}
	public String getIntegratedDisclosureSubsectionType() {
		return integratedDisclosureSubsectionType;
	}
	public void setIntegratedDisclosureSubsectionType(String integratedDisclosureSubsectionType) {
		this.integratedDisclosureSubsectionType = integratedDisclosureSubsectionType;
	}
	public String getLenderTolerance() {
		return lenderTolerance;
	}
	public void setLenderTolerance(String lenderTolerance) {
		this.lenderTolerance = lenderTolerance;
	}
	
	

}
