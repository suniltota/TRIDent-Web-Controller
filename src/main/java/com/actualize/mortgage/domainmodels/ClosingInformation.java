package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class ClosingInformation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8557982875024822649L;
	
	private String dateIssued;
	private String closingDate;
	private String disbursementDate;
	private String settlementAgent;
	private String fileNo;
	private Address property;
	private String salePrice;
	
	/**
	 * @return the dateIssued
	 */
	public String getDateIssued() {
		return dateIssued;
	}
	/**
	 * @param dateIssued the dateIssued to set
	 */
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
	/**
	 * @return the closingDate
	 */
	public String getClosingDate() {
		return closingDate;
	}
	/**
	 * @param closingDate the closingDate to set
	 */
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	/**
	 * @return the disbursementDate
	 */
	public String getDisbursementDate() {
		return disbursementDate;
	}
	/**
	 * @param disbursementDate the disbursementDate to set
	 */
	public void setDisbursementDate(String disbursementDate) {
		this.disbursementDate = disbursementDate;
	}
	/**
	 * @return the settlementAgent
	 */
	public String getSettlementAgent() {
		return settlementAgent;
	}
	/**
	 * @param settlementAgent the settlementAgent to set
	 */
	public void setSettlementAgent(String settlementAgent) {
		this.settlementAgent = settlementAgent;
	}
	/**
	 * @return the fileNo
	 */
	public String getFileNo() {
		return fileNo;
	}
	/**
	 * @param fileNo the fileNo to set
	 */
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	/**
	 * @return the property
	 */
	public Address getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(Address property) {
		this.property = property;
	}
	/**
	 * @return the salePrice
	 */
	public String getSalePrice() {
		return salePrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	

}
