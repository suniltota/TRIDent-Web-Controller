package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * this class defines summaries of transactions in JSON response 
 * @author sboragala
 *
 */
public class SummariesofTransactions implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1672551641387366652L;
	
	private SummariesofTransactionsDetailsDueFromBorrowerAtClosing dueFromBorroweratClosing;
	private v PaidByAlready paidByAlready;
	private SummariesofTransactionsDetailsDueToSellerAtClosing dueToSeller;
	private SummariesofTransactionsDetailsDueFromSellerAtClosing dueFromSeller;
	
	/**
	 * @return the dueFromBorroweratClosing
	 */
	public SummariesofTransactionsDetailsDueFromBorrowerAtClosing getDueFromBorroweratClosing() {
		return dueFromBorroweratClosing;
	}
	/**
	 * @param dueFromBorroweratClosing the dueFromBorroweratClosing to set
	 */
	public void setDueFromBorroweratClosing(
			SummariesofTransactionsDetailsDueFromBorrowerAtClosing dueFromBorroweratClosing) {
		this.dueFromBorroweratClosing = dueFromBorroweratClosing;
	}
	/**
	 * @return the paidByAlready
	 */
	public SummariesofTransactionsDetailsPaidByAlready getPaidByAlready() {
		return paidByAlready;
	}
	/**
	 * @param paidByAlready the paidByAlready to set
	 */
	public void setPaidByAlready(SummariesofTransactionsDetailsPaidByAlready paidByAlready) {
		this.paidByAlready = paidByAlready;
	}
	/**
	 * @return the dueToSeller
	 */
	public SummariesofTransactionsDetailsDueToSellerAtClosing getDueToSeller() {
		return dueToSeller;
	}
	/**
	 * @param dueToSeller the dueToSeller to set
	 */
	public void setDueToSeller(SummariesofTransactionsDetailsDueToSellerAtClosing dueToSeller) {
		this.dueToSeller = dueToSeller;
	}
	/**
	 * @return the dueFromSeller
	 */
	public SummariesofTransactionsDetailsDueFromSellerAtClosing getDueFromSeller() {
		return dueFromSeller;
	}
	/**
	 * @param dueFromSeller the dueFromSeller to set
	 */
	public void setDueFromSeller(SummariesofTransactionsDetailsDueFromSellerAtClosing dueFromSeller) {
		this.dueFromSeller = dueFromSeller;
	}

	
	 
}
