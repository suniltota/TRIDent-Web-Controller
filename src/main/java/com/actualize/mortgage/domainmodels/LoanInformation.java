package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class LoanInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6382855685415511549L;
	
	private String loanTerm;
	private String purpose;
	private String product;
	private String loanType;
	private String loanId;
	private String mic;
	private String constructionLoanType;
	private String constructionPeriodNumberOfMonthsCount;
	private String constructionLoanTotalTermMonthsCount;
	private String loanMaturityPeriodType;
	private String loanMaturityPeriodCount;
	private String integratedDisclosureHomeEquityLoanIndicator;
	private String lienPriorityType;
	private String amortizationType;
	private String integratedDisclosureLoanProductDescription;
	private String mortgageType;
	private String mortgageTypeOtherDescription;
	private List<LoanInformationLoanIdentifier> loanIdentifiers;
	private String miRequiredIndicator;
	private String miCertificateIdentifier;
	
	public String getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(String loanTerm) {
		this.loanTerm = loanTerm;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getMic() {
		return mic;
	}
	public void setMic(String mic) {
		this.mic = mic;
	}
	public String getConstructionLoanType() {
		return constructionLoanType;
	}
	public void setConstructionLoanType(String constructionLoanType) {
		this.constructionLoanType = constructionLoanType;
	}
	public String getConstructionPeriodNumberOfMonthsCount() {
		return constructionPeriodNumberOfMonthsCount;
	}
	public void setConstructionPeriodNumberOfMonthsCount(String constructionPeriodNumberOfMonthsCount) {
		this.constructionPeriodNumberOfMonthsCount = constructionPeriodNumberOfMonthsCount;
	}
	public String getConstructionLoanTotalTermMonthsCount() {
		return constructionLoanTotalTermMonthsCount;
	}
	public void setConstructionLoanTotalTermMonthsCount(String constructionLoanTotalTermMonthsCount) {
		this.constructionLoanTotalTermMonthsCount = constructionLoanTotalTermMonthsCount;
	}
	public String getLoanMaturityPeriodType() {
		return loanMaturityPeriodType;
	}
	public void setLoanMaturityPeriodType(String loanMaturityPeriodType) {
		this.loanMaturityPeriodType = loanMaturityPeriodType;
	}
	public String getLoanMaturityPeriodCount() {
		return loanMaturityPeriodCount;
	}
	public void setLoanMaturityPeriodCount(String loanMaturityPeriodCount) {
		this.loanMaturityPeriodCount = loanMaturityPeriodCount;
	}
	public String getIntegratedDisclosureHomeEquityLoanIndicator() {
		return integratedDisclosureHomeEquityLoanIndicator;
	}
	public void setIntegratedDisclosureHomeEquityLoanIndicator(String integratedDisclosureHomeEquityLoanIndicator) {
		this.integratedDisclosureHomeEquityLoanIndicator = integratedDisclosureHomeEquityLoanIndicator;
	}
	public String getLienPriorityType() {
		return lienPriorityType;
	}
	public void setLienPriorityType(String lienPriorityType) {
		this.lienPriorityType = lienPriorityType;
	}
	public String getIntegratedDisclosureLoanProductDescription() {
		return integratedDisclosureLoanProductDescription;
	}
	public void setIntegratedDisclosureLoanProductDescription(String integratedDisclosureLoanProductDescription) {
		this.integratedDisclosureLoanProductDescription = integratedDisclosureLoanProductDescription;
	}
	public String getMortgageType() {
		return mortgageType;
	}
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	public String getMortgageTypeOtherDescription() {
		return mortgageTypeOtherDescription;
	}
	public void setMortgageTypeOtherDescription(String mortgageTypeOtherDescription) {
		this.mortgageTypeOtherDescription = mortgageTypeOtherDescription;
	}
	
	public String getMiRequiredIndicator() {
		return miRequiredIndicator;
	}
	public void setMiRequiredIndicator(String miRequiredIndicator) {
		this.miRequiredIndicator = miRequiredIndicator;
	}
	public String getMiCertificateIdentifier() {
		return miCertificateIdentifier;
	}
	public void setMiCertificateIdentifier(String miCertificateIdentifier) {
		this.miCertificateIdentifier = miCertificateIdentifier;
	}
	public List<LoanInformationLoanIdentifier> getLoanIdentifiers() {
		return loanIdentifiers;
	}
	public void setLoanIdentifiers(List<LoanInformationLoanIdentifier> loanIdentifiers) {
		this.loanIdentifiers = loanIdentifiers;
	}
	public String getAmortizationType() {
		return amortizationType;
	}
	public void setAmortizationType(String amortizationType) {
		this.amortizationType = amortizationType;
	}
	
		
}
