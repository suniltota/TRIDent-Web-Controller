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
	private boolean constructionLoan;
	private String constructionLoanType;
	private String constructionPeriodNumberOfMonthsCount;
	private String constructionLoanTotalTermMonthsCount;
	private String loanMaturityPeriodType;
	private String loanMaturityPeriodCount;
	private boolean integratedDisclosureHomeEquityLoanIndicator;
	private String lienPriorityType;
	private String amortizationType;
	private String integratedDisclosureLoanProductDescription;
	private String mortgageType;
	private String mortgageTypeOtherDescription;
	private List<LoanInformationLoanIdentifier> loanIdentifiers;
	private boolean miRequiredIndicator;
	private String miCertificateIdentifier;
	private List<AutomatedUnderwritingsModel> automatedUnderwritings;
	private String loanManualUnderwritingIndicator;
	private boolean interestRateIncreaseIndicator;
	private boolean negativeAmortizationIndicator;
	private String interestOnlyTermMonthsCount;
	private boolean interestOnlyIndicator;
	private String negativeAmortizationType;
	private boolean seasonalPaymentFeatureIndicator;
	private boolean stepPaymentsFeatureIndicator;
	private boolean optionalPaymentsFeatureIndicator;
	
	
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
	 * @return the constructionLoan
	 */
	public boolean isConstructionLoan() {
		return constructionLoan;
	}
	/**
	 * @param constructionLoan the constructionLoan to set
	 */
	public void setConstructionLoan(boolean constructionLoan) {
		this.constructionLoan = constructionLoan;
	}
	/**
	 * @return the interestRateIncreaseIndicator
	 */
	public boolean isInterestRateIncreaseIndicator() {
		return interestRateIncreaseIndicator;
	}
	/**
	 * @param interestRateIncreaseIndicator the interestRateIncreaseIndicator to set
	 */
	public void setInterestRateIncreaseIndicator(boolean interestRateIncreaseIndicator) {
		this.interestRateIncreaseIndicator = interestRateIncreaseIndicator;
	}
	/**
	 * @return the negativeAmoritzationIndicator
	 */
	public boolean isNegativeAmoritzationIndicator() {
		return negativeAmortizationIndicator;
	}
	/**
	 * @param negativeAmoritzationIndicator the negativeAmoritzationIndicator to set
	 */
	public void setNegativeAmoritzationIndicator(boolean negativeAmoritzationIndicator) {
		this.negativeAmortizationIndicator = negativeAmoritzationIndicator;
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
	/**
	 * @return the interestOnlyIndicator
	 */
	public boolean isInterestOnlyIndicator() {
		return interestOnlyIndicator;
	}
	/**
	 * @param interestOnlyIndicator the interestOnlyIndicator to set
	 */
	public void setInterestOnlyIndicator(boolean interestOnlyIndicator) {
		this.interestOnlyIndicator = interestOnlyIndicator;
	}
	/**
	 * @return the integratedDisclosureHomeEquityLoanIndicator
	 */
	public boolean isIntegratedDisclosureHomeEquityLoanIndicator() {
		return integratedDisclosureHomeEquityLoanIndicator;
	}
	/**
	 * @param integratedDisclosureHomeEquityLoanIndicator the integratedDisclosureHomeEquityLoanIndicator to set
	 */
	public void setIntegratedDisclosureHomeEquityLoanIndicator(boolean integratedDisclosureHomeEquityLoanIndicator) {
		this.integratedDisclosureHomeEquityLoanIndicator = integratedDisclosureHomeEquityLoanIndicator;
	}
	/**
	 * @return the miRequiredIndicator
	 */
	public boolean isMiRequiredIndicator() {
		return miRequiredIndicator;
	}
	/**
	 * @param miRequiredIndicator the miRequiredIndicator to set
	 */
	public void setMiRequiredIndicator(boolean miRequiredIndicator) {
		this.miRequiredIndicator = miRequiredIndicator;
	}
	/**
	 * @return the negativeAmoritzationType
	 */
	public String getNegativeAmoritzationType() {
		return negativeAmortizationType;
	}
	/**
	 * @param negativeAmoritzationType the negativeAmoritzationType to set
	 */
	public void setNegativeAmoritzationType(String negativeAmoritzationType) {
		this.negativeAmortizationType = negativeAmoritzationType;
	}
	/**
	 * @return the negativeAmortizationIndicator
	 */
	public boolean isNegativeAmortizationIndicator() {
		return negativeAmortizationIndicator;
	}
	/**
	 * @param negativeAmortizationIndicator the negativeAmortizationIndicator to set
	 */
	public void setNegativeAmortizationIndicator(boolean negativeAmortizationIndicator) {
		this.negativeAmortizationIndicator = negativeAmortizationIndicator;
	}
	/**
	 * @return the negativeAmortizationType
	 */
	public String getNegativeAmortizationType() {
		return negativeAmortizationType;
	}
	/**
	 * @param negativeAmortizationType the negativeAmortizationType to set
	 */
	public void setNegativeAmortizationType(String negativeAmortizationType) {
		this.negativeAmortizationType = negativeAmortizationType;
	}
	/**
	 * @return the seasonalPaymentFeatureIndicator
	 */
	public boolean isSeasonalPaymentFeatureIndicator() {
		return seasonalPaymentFeatureIndicator;
	}
	/**
	 * @param seasonalPaymentFeatureIndicator the seasonalPaymentFeatureIndicator to set
	 */
	public void setSeasonalPaymentFeatureIndicator(boolean seasonalPaymentFeatureIndicator) {
		this.seasonalPaymentFeatureIndicator = seasonalPaymentFeatureIndicator;
	}
	/**
	 * @return the stepPaymentsFeatureIndicator
	 */
	public boolean isStepPaymentsFeatureIndicator() {
		return stepPaymentsFeatureIndicator;
	}
	/**
	 * @param stepPaymentsFeatureIndicator the stepPaymentsFeatureIndicator to set
	 */
	public void setStepPaymentsFeatureIndicator(boolean stepPaymentsFeatureIndicator) {
		this.stepPaymentsFeatureIndicator = stepPaymentsFeatureIndicator;
	}
	/**
	 * @return the optionalPaymentsFeatureIndicator
	 */
	public boolean isOptionalPaymentsFeatureIndicator() {
		return optionalPaymentsFeatureIndicator;
	}
	/**
	 * @param optionalPaymentsFeatureIndicator the optionalPaymentsFeatureIndicator to set
	 */
	public void setOptionalPaymentsFeatureIndicator(boolean optionalPaymentsFeatureIndicator) {
		this.optionalPaymentsFeatureIndicator = optionalPaymentsFeatureIndicator;
	}
	

		
}
