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
	private List<AutomatedUnderwritingsModel> automatedUnderwritings;
	private String loanManualUnderwritingIndicator;
	private String interestRateIncreaseIndicator;
	private String negativeAmoritzationIndicator;
	private String interestOnlyTermMonthsCount;
	
	
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
	 * @return the constructionLoanType
	 */
	public String getConstructionLoanType() {
		return constructionLoanType;
	}
	/**
	 * @param constructionLoanType the constructionLoanType to set
	 */
	public void setConstructionLoanType(String constructionLoanType) {
		this.constructionLoanType = constructionLoanType;
	}
	/**
	 * @return the constructionPeriodNumberOfMonthsCount
	 */
	public String getConstructionPeriodNumberOfMonthsCount() {
		return constructionPeriodNumberOfMonthsCount;
	}
	/**
	 * @param constructionPeriodNumberOfMonthsCount the constructionPeriodNumberOfMonthsCount to set
	 */
	public void setConstructionPeriodNumberOfMonthsCount(String constructionPeriodNumberOfMonthsCount) {
		this.constructionPeriodNumberOfMonthsCount = constructionPeriodNumberOfMonthsCount;
	}
	/**
	 * @return the constructionLoanTotalTermMonthsCount
	 */
	public String getConstructionLoanTotalTermMonthsCount() {
		return constructionLoanTotalTermMonthsCount;
	}
	/**
	 * @param constructionLoanTotalTermMonthsCount the constructionLoanTotalTermMonthsCount to set
	 */
	public void setConstructionLoanTotalTermMonthsCount(String constructionLoanTotalTermMonthsCount) {
		this.constructionLoanTotalTermMonthsCount = constructionLoanTotalTermMonthsCount;
	}
	/**
	 * @return the loanMaturityPeriodType
	 */
	public String getLoanMaturityPeriodType() {
		return loanMaturityPeriodType;
	}
	/**
	 * @param loanMaturityPeriodType the loanMaturityPeriodType to set
	 */
	public void setLoanMaturityPeriodType(String loanMaturityPeriodType) {
		this.loanMaturityPeriodType = loanMaturityPeriodType;
	}
	/**
	 * @return the loanMaturityPeriodCount
	 */
	public String getLoanMaturityPeriodCount() {
		return loanMaturityPeriodCount;
	}
	/**
	 * @param loanMaturityPeriodCount the loanMaturityPeriodCount to set
	 */
	public void setLoanMaturityPeriodCount(String loanMaturityPeriodCount) {
		this.loanMaturityPeriodCount = loanMaturityPeriodCount;
	}
	/**
	 * @return the integratedDisclosureHomeEquityLoanIndicator
	 */
	public String getIntegratedDisclosureHomeEquityLoanIndicator() {
		return integratedDisclosureHomeEquityLoanIndicator;
	}
	/**
	 * @param integratedDisclosureHomeEquityLoanIndicator the integratedDisclosureHomeEquityLoanIndicator to set
	 */
	public void setIntegratedDisclosureHomeEquityLoanIndicator(String integratedDisclosureHomeEquityLoanIndicator) {
		this.integratedDisclosureHomeEquityLoanIndicator = integratedDisclosureHomeEquityLoanIndicator;
	}
	/**
	 * @return the lienPriorityType
	 */
	public String getLienPriorityType() {
		return lienPriorityType;
	}
	/**
	 * @param lienPriorityType the lienPriorityType to set
	 */
	public void setLienPriorityType(String lienPriorityType) {
		this.lienPriorityType = lienPriorityType;
	}
	/**
	 * @return the amortizationType
	 */
	public String getAmortizationType() {
		return amortizationType;
	}
	/**
	 * @param amortizationType the amortizationType to set
	 */
	public void setAmortizationType(String amortizationType) {
		this.amortizationType = amortizationType;
	}
	/**
	 * @return the integratedDisclosureLoanProductDescription
	 */
	public String getIntegratedDisclosureLoanProductDescription() {
		return integratedDisclosureLoanProductDescription;
	}
	/**
	 * @param integratedDisclosureLoanProductDescription the integratedDisclosureLoanProductDescription to set
	 */
	public void setIntegratedDisclosureLoanProductDescription(String integratedDisclosureLoanProductDescription) {
		this.integratedDisclosureLoanProductDescription = integratedDisclosureLoanProductDescription;
	}
	/**
	 * @return the mortgageType
	 */
	public String getMortgageType() {
		return mortgageType;
	}
	/**
	 * @param mortgageType the mortgageType to set
	 */
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	/**
	 * @return the mortgageTypeOtherDescription
	 */
	public String getMortgageTypeOtherDescription() {
		return mortgageTypeOtherDescription;
	}
	/**
	 * @param mortgageTypeOtherDescription the mortgageTypeOtherDescription to set
	 */
	public void setMortgageTypeOtherDescription(String mortgageTypeOtherDescription) {
		this.mortgageTypeOtherDescription = mortgageTypeOtherDescription;
	}
	/**
	 * @return the loanIdentifiers
	 */
	public List<LoanInformationLoanIdentifier> getLoanIdentifiers() {
		return loanIdentifiers;
	}
	/**
	 * @param loanIdentifiers the loanIdentifiers to set
	 */
	public void setLoanIdentifiers(List<LoanInformationLoanIdentifier> loanIdentifiers) {
		this.loanIdentifiers = loanIdentifiers;
	}
	/**
	 * @return the miRequiredIndicator
	 */
	public String getMiRequiredIndicator() {
		return miRequiredIndicator;
	}
	/**
	 * @param miRequiredIndicator the miRequiredIndicator to set
	 */
	public void setMiRequiredIndicator(String miRequiredIndicator) {
		this.miRequiredIndicator = miRequiredIndicator;
	}
	/**
	 * @return the miCertificateIdentifier
	 */
	public String getMiCertificateIdentifier() {
		return miCertificateIdentifier;
	}
	/**
	 * @param miCertificateIdentifier the miCertificateIdentifier to set
	 */
	public void setMiCertificateIdentifier(String miCertificateIdentifier) {
		this.miCertificateIdentifier = miCertificateIdentifier;
	}
	/**
	 * @return the automatedUnderwritings
	 */
	public List<AutomatedUnderwritingsModel> getAutomatedUnderwritings() {
		return automatedUnderwritings;
	}
	/**
	 * @param automatedUnderwritings the automatedUnderwritings to set
	 */
	public void setAutomatedUnderwritings(List<AutomatedUnderwritingsModel> automatedUnderwritings) {
		this.automatedUnderwritings = automatedUnderwritings;
	}
	/**
	 * @return the loanManualUnderwritingIndicator
	 */
	public String getLoanManualUnderwritingIndicator() {
		return loanManualUnderwritingIndicator;
	}
	/**
	 * @param loanManualUnderwritingIndicator the loanManualUnderwritingIndicator to set
	 */
	public void setLoanManualUnderwritingIndicator(String loanManualUnderwritingIndicator) {
		this.loanManualUnderwritingIndicator = loanManualUnderwritingIndicator;
	}
	/**
	 * @return the interestRateIncreaseIndicator
	 */
	public String getInterestRateIncreaseIndicator() {
		return interestRateIncreaseIndicator;
	}
	/**
	 * @param interestRateIncreaseIndicator the interestRateIncreaseIndicator to set
	 */
	public void setInterestRateIncreaseIndicator(String interestRateIncreaseIndicator) {
		this.interestRateIncreaseIndicator = interestRateIncreaseIndicator;
	}
	/**
	 * @return the negativeAmoritzationIndicator
	 */
	public String getNegativeAmoritzationIndicator() {
		return negativeAmoritzationIndicator;
	}
	/**
	 * @param negativeAmoritzationIndicator the negativeAmoritzationIndicator to set
	 */
	public void setNegativeAmoritzationIndicator(String negativeAmoritzationIndicator) {
		this.negativeAmoritzationIndicator = negativeAmoritzationIndicator;
	}
	/**
	 * @return the interestOnlyTermMonthsCount
	 */
	public String getInterestOnlyTermMonthsCount() {
		return interestOnlyTermMonthsCount;
	}
	/**
	 * @param interestOnlyTermMonthsCount the interestOnlyTermMonthsCount to set
	 */
	public void setInterestOnlyTermMonthsCount(String interestOnlyTermMonthsCount) {
		this.interestOnlyTermMonthsCount = interestOnlyTermMonthsCount;
	} 
	
	

		
}
