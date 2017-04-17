/**
 * @(#)ClosingDisclosurePageOne.java 1.0 04/10/2017
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
 * This class represents all the sections present in Closing Disclosure Form Page-1
 * @author rsudula
 * @version 1.0
 */
public class ClosingDisclosurePageOne implements Serializable {

    private static final long serialVersionUID = 2984894173936813847L;

    private ClosingInformation closingInformation;
    private TransactionInformation transactionInformation;
    private LoanInformation loanInformation;
    private LoanTerms loanTerms;
    private ProjectedPaymentsModel projectedPayments;
    private CostsAtClosing costsAtClosing;
    
    
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

  
    
}
