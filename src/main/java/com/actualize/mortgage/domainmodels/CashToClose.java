package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class CashToClose implements Serializable{

	private static final long serialVersionUID = 4357130776769001121L;
	
	private String label;
	private String type;
	private String leFromBorrower;
	private String finalFromBorrower;
	private String dtcStatus;
	private String dtcDetail;
	private String index;
	private String closingCostsFinancedTotalAmount;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLeFromBorrower() {
		return leFromBorrower;
	}
	public void setLeFromBorrower(String leFromBorrower) {
		this.leFromBorrower = leFromBorrower;
	}
	public String getFinalFromBorrower() {
		return finalFromBorrower;
	}
	public void setFinalFromBorrower(String finalFromBorrower) {
		this.finalFromBorrower = finalFromBorrower;
	}
	public String getDtcStatus() {
		return dtcStatus;
	}
	public void setDtcStatus(String dtcStatus) {
		this.dtcStatus = dtcStatus;
	}
	public String getDtcDetail() {
		return dtcDetail;
	}
	public void setDtcDetail(String dtcDetail) {
		this.dtcDetail = dtcDetail;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getClosingCostsFinancedTotalAmount() {
		return closingCostsFinancedTotalAmount;
	}
	public void setClosingCostsFinancedTotalAmount(String closingCostsFinancedTotalAmount) {
		this.closingCostsFinancedTotalAmount = closingCostsFinancedTotalAmount;
	}
	
}
