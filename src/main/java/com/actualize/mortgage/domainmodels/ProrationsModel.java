package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.actualize.mortgage.utils.Expenses;


public class ProrationsModel extends Expenses  implements Serializable{
	
	private static final long serialVersionUID = 550984752620805502L;
	
	private String integratedDisclosureSubsectionType;
	private String prorationItemPaidFromDate;
	private String prorationItemPaidThroughDate;
	
	public String getIntegratedDisclosureSubsectionType() {
		return integratedDisclosureSubsectionType;
	}
	public void setIntegratedDisclosureSubsectionType(String integratedDisclosureSubsectionType) {
		this.integratedDisclosureSubsectionType = integratedDisclosureSubsectionType;
	}
	public String getProrationItemPaidFromDate() {
		return prorationItemPaidFromDate;
	}
	public void setProrationItemPaidFromDate(String prorationItemPaidFromDate) {
		this.prorationItemPaidFromDate = prorationItemPaidFromDate;
	}
	public String getProrationItemPaidThroughDate() {
		return prorationItemPaidThroughDate;
	}
	public void setProrationItemPaidThroughDate(String prorationItemPaidThroughDate) {
		this.prorationItemPaidThroughDate = prorationItemPaidThroughDate;
	}
}
