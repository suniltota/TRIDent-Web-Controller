package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class PageOne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1863609605772249336L;
	
	private ClosingInformation closingInformation;
	private TransactionInformation transactionInformation;
	private LoanInformation loanInformation;
	private LoanTerms loanTerms;
	private ProjectedPaymentsModel projectedPaymentsModel;
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
		return projectedPaymentsModel;
	}
	/**
	 * @param projectedPaymentsModel the projectedPayments to set
	 */
	public void setProjectedPayments(ProjectedPaymentsModel projectedPaymentsModel) {
		this.projectedPaymentsModel = projectedPaymentsModel;
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
