package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class PageOne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1863609605772249336L;
	
	private ClosingInformationModel closingInformationModel;
	private TransactionInformation transactionInformation;
	private LoanInformation loanInformation;
	private LoanTerms loanTerms;
	private ProjectedPaymentsMI projectedPaymentsMI;
	private CostsAtClosing costsAtClosing;
	
	/**
	 * @return the closingInformation
	 */
	public ClosingInformationModel getClosingInformation() {
		return closingInformationModel;
	}
	/**
	 * @param closingInformationModel the closingInformation to set
	 */
	public void setClosingInformation(ClosingInformationModel closingInformationModel) {
		this.closingInformationModel = closingInformationModel;
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
	public ProjectedPaymentsMI getProjectedPayments() {
		return projectedPaymentsMI;
	}
	/**
	 * @param projectedPaymentsMI the projectedPayments to set
	 */
	public void setProjectedPayments(ProjectedPaymentsMI projectedPaymentsMI) {
		this.projectedPaymentsMI = projectedPaymentsMI;
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
