package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;
/**
 * populates CashToClose section in CostsAtClosing
 * @author sboragala
 *
 */
public class CostsAtClosingCashToClose implements Serializable {
	
	private static final long serialVersionUID = -3001522846265870603L;
	
	private String amount;
	private List<String> details; //to delete
	private String docType;//to delete
	private String fromType;
	private String toType;//to delete
	private String cashFromBorrowerAtClosingAmount;
	private String cashToBorrowerAtClosingAmount;
	
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}
	/**
	 * @return the docType
	 */
	public String getDocType() {
		return docType;
	}
	/**
	 * @param docType the docType to set
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}
	/**
	 * @return the fromType
	 */
	public String getFromType() {
		return fromType;
	}
	/**
	 * @param fromType the fromType to set
	 */
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}
	/**
	 * @return the toType
	 */
	public String getToType() {
		return toType;
	}
	/**
	 * @param toType the toType to set
	 */
	public void setToType(String toType) {
		this.toType = toType;
	}
	/**
	 * @return the cashFromBorrowerAtClosingAmount
	 */
	public String getCashFromBorrowerAtClosingAmount() {
		return cashFromBorrowerAtClosingAmount;
	}
	/**
	 * @param cashFromBorrowerAtClosingAmount the cashFromBorrowerAtClosingAmount to set
	 */
	public void setCashFromBorrowerAtClosingAmount(String cashFromBorrowerAtClosingAmount) {
		this.cashFromBorrowerAtClosingAmount = cashFromBorrowerAtClosingAmount;
	}
	/**
	 * @return the cashToBorrowerAtClosingAmount
	 */
	public String getCashToBorrowerAtClosingAmount() {
		return cashToBorrowerAtClosingAmount;
	}
	/**
	 * @param cashToBorrowerAtClosingAmount the cashToBorrowerAtClosingAmount to set
	 */
	public void setCashToBorrowerAtClosingAmount(String cashToBorrowerAtClosingAmount) {
		this.cashToBorrowerAtClosingAmount = cashToBorrowerAtClosingAmount;
	}
	

}
