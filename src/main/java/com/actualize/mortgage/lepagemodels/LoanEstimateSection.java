package com.actualize.mortgage.lepagemodels;

import java.io.Serializable;
import java.util.List;

import com.actualize.mortgage.domainmodels.AddressModel;


/**
 * This model describes first section of Loan Estimate and serves as response to front end.  
 * @author sboragala
 *
 */
public class LoanEstimateSection implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4136166273672214432L;
	
	private String lenderFullName;
	private AddressModel lenderAddress;
	private String dateIssued;
	private List<LoanEstimateSectionBorrower> applicants;
	private AddressModel property;
	private String estimatedPropValue;
	private String loanTerm;
	private String purpose;
	private String product;
	private String loanType;
	private String loanId;
	private LoanEstimateSectionRateLock loanEstimateSectionRateLock;
	
	/**
	 * @return the lenderFullName
	 */
	public String getLenderFullName() {
		return lenderFullName;
	}
	/**
	 * @param lenderFullName the lenderFullName to set
	 */
	public void setLenderFullName(String lenderFullName) {
		this.lenderFullName = lenderFullName;
	}
	/**
	 * @return the lenderAddress
	 */
	public AddressModel getLenderAddress() {
		return lenderAddress;
	}
	/**
	 * @param lenderAddress the lenderAddress to set
	 */
	public void setLenderAddress(AddressModel lenderAddress) {
		this.lenderAddress = lenderAddress;
	}
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
	public List<LoanEstimateSectionBorrower> getApplicants() {
		return applicants;
	}
	/**
	 * @param applicants the applicants to set
	 */
	public void setApplicants(List<LoanEstimateSectionBorrower> applicants) {
		this.applicants = applicants;
	}
	/**
	 * @return the property
	 */
	public AddressModel getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(AddressModel property) {
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
	 * @return the loanEstimateSectionRateLock
	 */
	public LoanEstimateSectionRateLock getLoanEstimateSectionRateLock() {
		return loanEstimateSectionRateLock;
	}
	/**
	 * @param loanEstimateSectionRateLock the loanEstimateSectionRateLock to set
	 */
	public void setLoanEstimateSectionRateLock(LoanEstimateSectionRateLock loanEstimateSectionRateLock) {
		this.loanEstimateSectionRateLock = loanEstimateSectionRateLock;
	}
	
	
	
}
