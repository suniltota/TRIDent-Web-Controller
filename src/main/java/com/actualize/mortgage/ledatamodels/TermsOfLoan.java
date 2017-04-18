package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * Maps to TermsOfLoan in XML
 * @author sboragala
 *
 */
public class TermsOfLoan extends MISMODataAccessObject {
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
