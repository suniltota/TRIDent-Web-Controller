package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class ClosingInformation implements Serializable {
	
	private static final long serialVersionUID = 8557982875024822649L;
	
	private String dateIssued;
	private String closingDate;
	private String disbursementDate;
	private String settlementAgent;
	private String fileNo;
	private Address property;
	//below field is saleContractAmount, shall be removed later
	private String salePrice;
	private String partyRoleType;
	private SalesContractDetail salesContractDetail;
	private PropertyValuationDetail propertyValuationDetail;
	
	
	public String getDateIssued() {
		return dateIssued;
	}
	
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
	
	public String getClosingDate() {
		return closingDate;
	}
	
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	
	public String getDisbursementDate() {
		return disbursementDate;
	}
	
	public void setDisbursementDate(String disbursementDate) {
		this.disbursementDate = disbursementDate;
	}
	
	public String getSettlementAgent() {
		return settlementAgent;
	}
	
	public void setSettlementAgent(String settlementAgent) {
		this.settlementAgent = settlementAgent;
	}
	
	public String getFileNo() {
		return fileNo;
	}
	
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	
	public Address getProperty() {
		return property;
	}
	
	public void setProperty(Address property) {
		this.property = property;
	}
	
	public String getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	
	public String getPartyRoleType() {
		return partyRoleType;
	}
	
	public void setPartyRoleType(String partyRoleType) {
		this.partyRoleType = partyRoleType;
	}

	public SalesContractDetail getSalesContractDetail() {
		return salesContractDetail;
	}

	public void setSalesContractDetail(SalesContractDetail salesContractDetail) {
		this.salesContractDetail = salesContractDetail;
	}

	public PropertyValuationDetail getPropertyValuationDetail() {
		return propertyValuationDetail;
	}

	public void setPropertyValuationDetail(PropertyValuationDetail propertyValuationDetail) {
		this.propertyValuationDetail = propertyValuationDetail;
	}
	

}
