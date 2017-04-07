package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class CostsAtClosingCashToClose implements Serializable {
	
	private static final long serialVersionUID = -3001522846265870603L;
	
	private String amount;
	private List<String> details;
	private String docType;
	private String fromType;
	private String toType;
	private String cashFromBorrowerAtClosingAmount;
	private String cashToBorrowerAtClosingAmount;
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public List<String> getDetails() {
		return details;
	}
	
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	public String getDocType() {
		return docType;
	}
	
	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	public String getFromType() {
		return fromType;
	}
	
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}
	
	public String getToType() {
		return toType;
	}
	
	public void setToType(String toType) {
		this.toType = toType;
	}
	public String getCashFromBorrowerAtClosingAmount() {
		return cashFromBorrowerAtClosingAmount;
	}
	public void setCashFromBorrowerAtClosingAmount(String cashFromBorrowerAtClosingAmount) {
		this.cashFromBorrowerAtClosingAmount = cashFromBorrowerAtClosingAmount;
	}
	public String getCashToBorrowerAtClosingAmount() {
		return cashToBorrowerAtClosingAmount;
	}
	public void setCashToBorrowerAtClosingAmount(String cashToBorrowerAtClosingAmount) {
		this.cashToBorrowerAtClosingAmount = cashToBorrowerAtClosingAmount;
	}
	
}
