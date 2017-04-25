/*
 * @(#)ClosingDisclosure.java 1.0 04/10/2017
 * 
 */

package com.actualize.mortgage.cdpagemodels;

import java.io.Serializable;

import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsModel;
import com.actualize.mortgage.domainmodels.TransactionInformation;

/**
 * This class represents the all the pages present in Closing Disclosure
 * 
 * @author rsudula
 * @version 1.0
 * 
 */
public class ClosingDisclosure implements Serializable {

    private static final long serialVersionUID = 3808831045060865597L;
    private ClosingDisclosureDocumentType closingDisclosureDocType;
    private ClosingInformation closingInformation;
    private TransactionInformation transactionInformation;
    private LoanInformation loanInformation;
    private LoanTerms loanTerms;
    private ProjectedPaymentsModel projectedPayments;
    private CostsAtClosing costsAtClosing;
    private ClosingDisclosurePageTwo closingDisclosurePageTwo;
    private ClosingDisclosurePageThree closingDisclosurePageThree;
    private ClosingDisclosurePageFour closingDisclosurePageFour;
    private ClosingDisclosurePageFive closingDisclosurePageFive;
	/**
	 * @return the closingDisclosureDocType
	 */
	public ClosingDisclosureDocumentType getClosingDisclosureDocType() {
		return closingDisclosureDocType;
	}
	/**
	 * @param closingDisclosureDocType the closingDisclosureDocType to set
	 */
	public void setClosingDisclosureDocType(ClosingDisclosureDocumentType closingDisclosureDocType) {
		this.closingDisclosureDocType = closingDisclosureDocType;
	}
	/**
	 * @return the closingInformation
	 */
	public ClosingInformation getClosingInformation() {
		return closingInformation;
	}
	/**
	 * @param closingInformation the closingInformation to set
	 */
	public void setClosingInformation(ClosingInformation closingInformation) {
		this.closingInformation = closingInformation;
	}
	/**
	 * @return the transactionInformation
	 */
	public TransactionInformation getTransactionInformation() {
		return transactionInformation;
	}
	/**
	 * @param transactionInformation the transactionInformation to set
	 */
	public void setTransactionInformation(TransactionInformation transactionInformation) {
		this.transactionInformation = transactionInformation;
	}
	/**
	 * @return the loanInformation
	 */
	public LoanInformation getLoanInformation() {
		return loanInformation;
	}
	/**
	 * @param loanInformation the loanInformation to set
	 */
	public void setLoanInformation(LoanInformation loanInformation) {
		this.loanInformation = loanInformation;
	}
	/**
	 * @return the loanTerms
	 */
	public LoanTerms getLoanTerms() {
		return loanTerms;
	}
	/**
	 * @param loanTerms the loanTerms to set
	 */
	public void setLoanTerms(LoanTerms loanTerms) {
		this.loanTerms = loanTerms;
	}
	/**
	 * @return the projectedPayments
	 */
	public ProjectedPaymentsModel getProjectedPayments() {
		return projectedPayments;
	}
	/**
	 * @param projectedPayments the projectedPayments to set
	 */
	public void setProjectedPayments(ProjectedPaymentsModel projectedPayments) {
		this.projectedPayments = projectedPayments;
	}
	/**
	 * @return the costsAtClosing
	 */
	public CostsAtClosing getCostsAtClosing() {
		return costsAtClosing;
	}
	/**
	 * @param costsAtClosing the costsAtClosing to set
	 */
	public void setCostsAtClosing(CostsAtClosing costsAtClosing) {
		this.costsAtClosing = costsAtClosing;
	}
	/**
	 * @return the closingDisclosurePageTwo
	 */
	public ClosingDisclosurePageTwo getClosingDisclosurePageTwo() {
		return closingDisclosurePageTwo;
	}
	/**
	 * @param closingDisclosurePageTwo the closingDisclosurePageTwo to set
	 */
	public void setClosingDisclosurePageTwo(ClosingDisclosurePageTwo closingDisclosurePageTwo) {
		this.closingDisclosurePageTwo = closingDisclosurePageTwo;
	}
	/**
	 * @return the closingDisclosurePageThree
	 */
	public ClosingDisclosurePageThree getClosingDisclosurePageThree() {
		return closingDisclosurePageThree;
	}
	/**
	 * @param closingDisclosurePageThree the closingDisclosurePageThree to set
	 */
	public void setClosingDisclosurePageThree(ClosingDisclosurePageThree closingDisclosurePageThree) {
		this.closingDisclosurePageThree = closingDisclosurePageThree;
	}
	/**
	 * @return the closingDisclosurePageFour
	 */
	public ClosingDisclosurePageFour getClosingDisclosurePageFour() {
		return closingDisclosurePageFour;
	}
	/**
	 * @param closingDisclosurePageFour the closingDisclosurePageFour to set
	 */
	public void setClosingDisclosurePageFour(ClosingDisclosurePageFour closingDisclosurePageFour) {
		this.closingDisclosurePageFour = closingDisclosurePageFour;
	}
	/**
	 * @return the closingDisclosurePageFive
	 */
	public ClosingDisclosurePageFive getClosingDisclosurePageFive() {
		return closingDisclosurePageFive;
	}
	/**
	 * @param closingDisclosurePageFive the closingDisclosurePageFive to set
	 */
	public void setClosingDisclosurePageFive(ClosingDisclosurePageFive closingDisclosurePageFive) {
		this.closingDisclosurePageFive = closingDisclosurePageFive;
	}

    
}
