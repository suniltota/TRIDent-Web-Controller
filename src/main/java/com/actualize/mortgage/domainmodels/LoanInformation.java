package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class LoanInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6382855685415511549L;
	
	private String amortizationType;
	private List<LoanInformationLoanIdentifier> loanIdentifiers;
	private List<AutomatedUnderwritingsModel> automatedUnderwritings;
	private boolean loanManualUnderwritingIndicator;
	
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
}
