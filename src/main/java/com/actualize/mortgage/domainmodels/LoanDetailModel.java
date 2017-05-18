/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines LoanDetail in MISMO XML
 * @author sboragala
 *
 */
public class LoanDetailModel implements Serializable {
	
	private static final long serialVersionUID = 5490338960551764090L;
	private boolean assumabilityIndicator;
	private boolean balloonIndicator;
	private String balloonPaymentAmount;
	private boolean buydownTemporarySubsidyFundingIndicator;
	private boolean constructionLoanIndicator;
	private String creditorServicingOfLoanStatementType;
	private boolean demandFeatureIndicator;
	private String escrowAbsenceReasonType;
	private boolean escrowIndicator;
	private boolean interestOnlyIndicator;
	private boolean interestRateIncreaseIndicator;
	private boolean loanAmountIncreaseIndicator;
	private boolean miRequiredIndicator;
	private boolean negativeAmortizationIndicator;
	private boolean paymentIncreaseIndicator;
	private boolean prepaymentPenaltyIndicator;
	private boolean seasonalPaymentFeatureIndicator;
	private String stepPaymentsFeatureDescription;
	private String totalSubordinateFinancingAmount;
	private boolean subordinateFinancingIsNewIndicator;
	
	/**
	 * @return the assumabilityIndicator
	 */
	public boolean isAssumabilityIndicator() {
		return assumabilityIndicator;
	}
	/**
	 * @param assumabilityIndicator the assumabilityIndicator to set
	 */
	public void setAssumabilityIndicator(boolean assumabilityIndicator) {
		this.assumabilityIndicator = assumabilityIndicator;
	}
	/**
	 * @return the balloonIndicator
	 */
	public boolean isBalloonIndicator() {
		return balloonIndicator;
	}
	/**
	 * @param balloonIndicator the balloonIndicator to set
	 */
	public void setBalloonIndicator(boolean balloonIndicator) {
		this.balloonIndicator = balloonIndicator;
	}
	/**
	 * @return the balloonPaymentAmount
	 */
	public String getBalloonPaymentAmount() {
		return balloonPaymentAmount;
	}
	/**
	 * @param balloonPaymentAmount the balloonPaymentAmount to set
	 */
	public void setBalloonPaymentAmount(String balloonPaymentAmount) {
		this.balloonPaymentAmount = balloonPaymentAmount;
	}
	/**
	 * @return the buydownTemporarySubsidyFundingIndicator
	 */
	public boolean isBuydownTemporarySubsidyFundingIndicator() {
		return buydownTemporarySubsidyFundingIndicator;
	}
	/**
	 * @param buydownTemporarySubsidyFundingIndicator the buydownTemporarySubsidyFundingIndicator to set
	 */
	public void setBuydownTemporarySubsidyFundingIndicator(boolean buydownTemporarySubsidyFundingIndicator) {
		this.buydownTemporarySubsidyFundingIndicator = buydownTemporarySubsidyFundingIndicator;
	}
	/**
	 * @return the constructionLoanIndicator
	 */
	public boolean isConstructionLoanIndicator() {
		return constructionLoanIndicator;
	}
	/**
	 * @param constructionLoanIndicator the constructionLoanIndicator to set
	 */
	public void setConstructionLoanIndicator(boolean constructionLoanIndicator) {
		this.constructionLoanIndicator = constructionLoanIndicator;
	}
	/**
	 * @return the creditorServicingOfLoanStatementType
	 */
	public String getCreditorServicingOfLoanStatementType() {
		return creditorServicingOfLoanStatementType;
	}
	/**
	 * @param creditorServicingOfLoanStatementType the creditorServicingOfLoanStatementType to set
	 */
	public void setCreditorServicingOfLoanStatementType(String creditorServicingOfLoanStatementType) {
		this.creditorServicingOfLoanStatementType = creditorServicingOfLoanStatementType;
	}
	/**
	 * @return the demandFeatureIndicator
	 */
	public boolean isDemandFeatureIndicator() {
		return demandFeatureIndicator;
	}
	/**
	 * @param demandFeatureIndicator the demandFeatureIndicator to set
	 */
	public void setDemandFeatureIndicator(boolean demandFeatureIndicator) {
		this.demandFeatureIndicator = demandFeatureIndicator;
	}
	/**
	 * @return the escrowAbsenceReasonType
	 */
	public String getEscrowAbsenceReasonType() {
		return escrowAbsenceReasonType;
	}
	/**
	 * @param escrowAbsenceReasonType the escrowAbsenceReasonType to set
	 */
	public void setEscrowAbsenceReasonType(String escrowAbsenceReasonType) {
		this.escrowAbsenceReasonType = escrowAbsenceReasonType;
	}
	/**
	 * @return the escrowIndicator
	 */
	public boolean isEscrowIndicator() {
		return escrowIndicator;
	}
	/**
	 * @param escrowIndicator the escrowIndicator to set
	 */
	public void setEscrowIndicator(boolean escrowIndicator) {
		this.escrowIndicator = escrowIndicator;
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
	 * @return the loanAmountIncreaseIndicator
	 */
	public boolean isLoanAmountIncreaseIndicator() {
		return loanAmountIncreaseIndicator;
	}
	/**
	 * @param loanAmountIncreaseIndicator the loanAmountIncreaseIndicator to set
	 */
	public void setLoanAmountIncreaseIndicator(boolean loanAmountIncreaseIndicator) {
		this.loanAmountIncreaseIndicator = loanAmountIncreaseIndicator;
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
	 * @return the paymentIncreaseIndicator
	 */
	public boolean isPaymentIncreaseIndicator() {
		return paymentIncreaseIndicator;
	}
	/**
	 * @param paymentIncreaseIndicator the paymentIncreaseIndicator to set
	 */
	public void setPaymentIncreaseIndicator(boolean paymentIncreaseIndicator) {
		this.paymentIncreaseIndicator = paymentIncreaseIndicator;
	}
	/**
	 * @return the prepaymentPenaltyIndicator
	 */
	public boolean isPrepaymentPenaltyIndicator() {
		return prepaymentPenaltyIndicator;
	}
	/**
	 * @param prepaymentPenaltyIndicator the prepaymentPenaltyIndicator to set
	 */
	public void setPrepaymentPenaltyIndicator(boolean prepaymentPenaltyIndicator) {
		this.prepaymentPenaltyIndicator = prepaymentPenaltyIndicator;
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
	 * @return the stepPaymentsFeatureDescription
	 */
	public String getStepPaymentsFeatureDescription() {
		return stepPaymentsFeatureDescription;
	}
	/**
	 * @param stepPaymentsFeatureDescription the stepPaymentsFeatureDescription to set
	 */
	public void setStepPaymentsFeatureDescription(String stepPaymentsFeatureDescription) {
		this.stepPaymentsFeatureDescription = stepPaymentsFeatureDescription;
	}
	/**
	 * @return the totalSubordinateFinancingAmount
	 */
	public String getTotalSubordinateFinancingAmount() {
		return totalSubordinateFinancingAmount;
	}
	/**
	 * @param totalSubordinateFinancingAmount the totalSubordinateFinancingAmount to set
	 */
	public void setTotalSubordinateFinancingAmount(String totalSubordinateFinancingAmount) {
		this.totalSubordinateFinancingAmount = totalSubordinateFinancingAmount;
	}
	/**
	 * @return the subordinateFinancingIsNewIndicator
	 */
	public boolean isSubordinateFinancingIsNewIndicator() {
		return subordinateFinancingIsNewIndicator;
	}
	/**
	 * @param subordinateFinancingIsNewIndicator the subordinateFinancingIsNewIndicator to set
	 */
	public void setSubordinateFinancingIsNewIndicator(boolean subordinateFinancingIsNewIndicator) {
		this.subordinateFinancingIsNewIndicator = subordinateFinancingIsNewIndicator;
	}
	
}
