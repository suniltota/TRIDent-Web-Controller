package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class LoanInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6382855685415511549L;
	
	private String loanMaturityPeriodType;
	private String loanMaturityPeriodCount;
	private String amortizationType;
	private List<LoanInformationLoanIdentifier> loanIdentifiers;
	private List<AutomatedUnderwritingsModel> automatedUnderwritings;
	private boolean loanManualUnderwritingIndicator;
	private boolean interestRateIncreaseIndicator;
	private String interestOnlyTermMonthsCount;
	private String negativeAmortizationType;
	
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
	public boolean isLoanManualUnderwritingIndicator() {
		return loanManualUnderwritingIndicator;
	}
	/**
	 * @param loanManualUnderwritingIndicator the loanManualUnderwritingIndicator to set
	 */
	public void setLoanManualUnderwritingIndicator(boolean loanManualUnderwritingIndicator) {
		this.loanManualUnderwritingIndicator = loanManualUnderwritingIndicator;
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
			
}
