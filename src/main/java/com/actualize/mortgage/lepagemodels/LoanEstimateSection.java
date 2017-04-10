package com.actualize.mortgage.lepagemodels;

import com.actualize.mortgage.ledatamodels.Address;

/**
 * This model describes first section of Loan Estimate and serves as response to front end.  
 * @author sboragala
 *
 */
public class LoanEstimateSection {
	
	private String dateIssued;
	private Address applicants;
	private Address property;
	private String estimatedPropValue;
	private String loanTerm;
	private String purpose;
	private String product;
	private String loanType;
	private String loanId;
	private String rateLock;
	private String untillDate;
	private String untillTime;
	private String expireDate;
	private String expireTime;
	
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
	 * @return the applicants
	 */
	public Address getApplicants() {
		return applicants;
	}
	/**
	 * @param applicants the applicants to set
	 */
	public void setApplicants(Address applicants) {
		this.applicants = applicants;
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
	 * @return the estimatedPropValue
	 */
	public String getEstimatedPropValue() {
		return estimatedPropValue;
	}
	/**
	 * @param estimatedPropValue the estimatedPropValue to set
	 */
	public void setEstimatedPropValue(String estimatedPropValue) {
		this.estimatedPropValue = estimatedPropValue;
	}
	/**
	 * @return the loanTerm
	 */
	public String getLoanTerm() {
		return loanTerm;
	}
	/**
	 * @param loanTerm the loanTerm to set
	 */
	public void setLoanTerm(String loanTerm) {
		this.loanTerm = loanTerm;
	}
	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}
	/**
	 * @param purpose the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return the loanType
	 */
	public String getLoanType() {
		return loanType;
	}
	/**
	 * @param loanType the loanType to set
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	/**
	 * @return the loanId
	 */
	public String getLoanId() {
		return loanId;
	}
	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	/**
	 * @return the rateLock
	 */
	public String getRateLock() {
		return rateLock;
	}
	/**
	 * @param rateLock the rateLock to set
	 */
	public void setRateLock(String rateLock) {
		this.rateLock = rateLock;
	}
	/**
	 * @return the untillDate
	 */
	public String getUntillDate() {
		return untillDate;
	}
	/**
	 * @param untillDate the untillDate to set
	 */
	public void setUntillDate(String untillDate) {
		this.untillDate = untillDate;
	}
	/**
	 * @return the untillTime
	 */
	public String getUntillTime() {
		return untillTime;
	}
	/**
	 * @param untillTime the untillTime to set
	 */
	public void setUntillTime(String untillTime) {
		this.untillTime = untillTime;
	}
	/**
	 * @return the expireDate
	 */
	public String getExpireDate() {
		return expireDate;
	}
	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	/**
	 * @return the expireTime
	 */
	public String getExpireTime() {
		return expireTime;
	}
	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	
}
