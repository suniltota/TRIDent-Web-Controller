/*
 * @(#)ClosingDisclosure.java 1.0 04/10/2017
 * 
 */

package com.actualize.mortgage.cdpagemodels;

import java.io.Serializable;

import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostsTotal;
import com.actualize.mortgage.domainmodels.ClosingInformationModel;
import com.actualize.mortgage.domainmodels.ContactInformationModel;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.ETIASection;
import com.actualize.mortgage.domainmodels.InterestRateAdjustmentModel;
import com.actualize.mortgage.domainmodels.LoanCalculationsQualifiedMortgage;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.ledatamodels.PayoffsAndPayments;

/**
 * This class represents the all the pages present in Closing Disclosure
 * 
 * @author rsudula
 * @version 1.0
 * 
 */
public class ClosingDisclosure implements Serializable {

    private static final long serialVersionUID = 3808831045060865597L;
    private ClosingDisclosureDocumentDetails closingDisclosureDocType;
    private ClosingInformationModel closingInformation;
    private TransactionInformation transactionInformation;
    private LoanInformation loanInformation;
    private LoanTerms loanTerms;
    private ProjectedPaymentsDetails projectedPayments;
    private ETIASection etiaSection;
    private CostsAtClosing costsAtClosing;
    private ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts;
    private ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts;
    private ClosingCostsTotal closingCostsTotal;
    private CashToClose cashToCloses;
    private SummariesofTransactions summariesofTransactions;
    private PayoffsAndPayments payoffsAndPayments;
    private InterestRateAdjustmentModel interestRateAdjustment;
    private LoanCalculationsQualifiedMortgage loanCalculationsQualifiedMortgage;
    private ContactInformationModel contactInformation;
     
    
	/**
	 * @return the closingDisclosureDocType
	 */
	public ClosingDisclosureDocumentDetails getClosingDisclosureDocType() {
		return closingDisclosureDocType;
	}
	/**
	 * @param closingDisclosureDocType the closingDisclosureDocType to set
	 */
	public void setClosingDisclosureDocType(ClosingDisclosureDocumentDetails closingDisclosureDocType) {
		this.closingDisclosureDocType = closingDisclosureDocType;
	}
	/**
	 * @return the closingInformation
	 */
	public ClosingInformationModel getClosingInformation() {
		return closingInformation;
	}
	/**
	 * @param closingInformation the closingInformation to set
	 */
	public void setClosingInformation(ClosingInformationModel closingInformation) {
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
	public ProjectedPaymentsDetails getProjectedPayments() {
		return projectedPayments;
	}
	/**
	 * @param projectedPayments the projectedPayments to set
	 */
	public void setProjectedPayments(ProjectedPaymentsDetails projectedPayments) {
		this.projectedPayments = projectedPayments;
	}
	/**
	 * @return the etiaSection
	 */
	public ETIASection getEtiaSection() {
		return etiaSection;
	}
	/**
	 * @param etiaSection the etiaSection to set
	 */
	public void setEtiaSection(ETIASection etiaSection) {
		this.etiaSection = etiaSection;
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
	 * @return the closingCostDetailsLoanCosts
	 */
	public ClosingCostDetailsLoanCosts getClosingCostDetailsLoanCosts() {
		return closingCostDetailsLoanCosts;
	}
	/**
	 * @param closingCostDetailsLoanCosts the closingCostDetailsLoanCosts to set
	 */
	public void setClosingCostDetailsLoanCosts(ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts) {
		this.closingCostDetailsLoanCosts = closingCostDetailsLoanCosts;
	}
	/**
	 * @return the closingCostDetailsOtherCosts
	 */
	public ClosingCostDetailsOtherCosts getClosingCostDetailsOtherCosts() {
		return closingCostDetailsOtherCosts;
	}
	/**
	 * @param closingCostDetailsOtherCosts the closingCostDetailsOtherCosts to set
	 */
	public void setClosingCostDetailsOtherCosts(ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts) {
		this.closingCostDetailsOtherCosts = closingCostDetailsOtherCosts;
	}
	/**
	 * @return the closingCostsTotal
	 */
	public ClosingCostsTotal getClosingCostsTotal() {
		return closingCostsTotal;
	}
	/**
	 * @param closingCostsTotal the closingCostsTotal to set
	 */
	public void setClosingCostsTotal(ClosingCostsTotal closingCostsTotal) {
		this.closingCostsTotal = closingCostsTotal;
	}
	/**
	 * @return the cashToCloses
	 */
	public CashToClose getCashToCloses() {
		return cashToCloses;
	}
	/**
	 * @param cashToCloses the cashToCloses to set
	 */
	public void setCashToCloses(CashToClose cashToCloses) {
		this.cashToCloses = cashToCloses;
	}
	/**
	 * @return the summariesofTransactions
	 */
	public SummariesofTransactions getSummariesofTransactions() {
		return summariesofTransactions;
	}
	/**
	 * @param summariesofTransactions the summariesofTransactions to set
	 */
	public void setSummariesofTransactions(SummariesofTransactions summariesofTransactions) {
		this.summariesofTransactions = summariesofTransactions;
	}
	/**
	 * @return the payoffsAndPayments
	 */
	public PayoffsAndPayments getPayoffsAndPayments() {
		return payoffsAndPayments;
	}
	/**
	 * @param payoffsAndPayments the payoffsAndPayments to set
	 */
	public void setPayoffsAndPayments(PayoffsAndPayments payoffsAndPayments) {
		this.payoffsAndPayments = payoffsAndPayments;
	}
	/**
	 * @return the interestRateAdjustment
	 */
	public InterestRateAdjustmentModel getInterestRateAdjustment() {
		return interestRateAdjustment;
	}
	/**
	 * @param interestRateAdjustment the interestRateAdjustment to set
	 */
	public void setInterestRateAdjustment(InterestRateAdjustmentModel interestRateAdjustment) {
		this.interestRateAdjustment = interestRateAdjustment;
	}
	/**
	 * @return the loanCalculationsQualifiedMortgage
	 */
	public LoanCalculationsQualifiedMortgage getLoanCalculationsQualifiedMortgage() {
		return loanCalculationsQualifiedMortgage;
	}
	/**
	 * @param loanCalculationsQualifiedMortgage the loanCalculationsQualifiedMortgage to set
	 */
	public void setLoanCalculationsQualifiedMortgage(LoanCalculationsQualifiedMortgage loanCalculationsQualifiedMortgage) {
		this.loanCalculationsQualifiedMortgage = loanCalculationsQualifiedMortgage;
	}
	/**
	 * @return the contactInformation
	 */
	public ContactInformationModel getContactInformation() {
		return contactInformation;
	}
	/**
	 * @param contactInformation the contactInformation to set
	 */
	public void setContactInformation(ContactInformationModel contactInformation) {
		this.contactInformation = contactInformation;
	}
    
	
}
