package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * defines TermsOfLoan in MISMO XML
 * @author sboragala
 *
 */
public class TermsOfLoan extends MISMODataAccessObject {
	private static final long serialVersionUID = -5795505327156218503L;
	public final String assumedLoanAmount;
	public final String disclosedFullyIndexedRatePercent;
	public final String lienPriorityType;
	public final String loanPurposeType;
	public final String mortgageType;
	public final String mortgageTypeOtherDescription;
	public final String noteAmount;
	public final String noteRatePercent;
	public final String weightedAverageInterestRatePercent;
	
	public TermsOfLoan(Element element) {
		super(element);
		assumedLoanAmount = getValueAddNS("AssumedLoanAmount");
		disclosedFullyIndexedRatePercent = getValueAddNS("DisclosedFullyIndexedRatePercent");
		lienPriorityType = getValueAddNS("LienPriorityType");
		loanPurposeType = getValueAddNS("LoanPurposeType");
		mortgageType = getValueAddNS("MortgageType");
		mortgageTypeOtherDescription = getValueAddNS("MortgageTypeOtherDescription");
		noteAmount = getValueAddNS("NoteAmount");
		noteRatePercent = getValueAddNS("NoteRatePercent");
		weightedAverageInterestRatePercent = getValueAddNS("WeightedAverageInterestRatePercent");
	}
}
