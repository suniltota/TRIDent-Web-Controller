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
	private SummariesofTransactionsDetailsPaidByAlready paidByAlready;
	private SummariesofTransactionsDetailsDueToSellerAtClosing dueToSeller;
	private SummariesofTransactionsDetailsDueFromSellerAtClosing dueFromSeller;
	private SummariesofTransactionsDetailsBorrowerTransaction borrowerTransaction;
	private SummariesofTransactionsDetailsSellerTransaction sellerTransaction;
	
	/**
	 * @return the borrowerTransaction
	 */
	public SummariesofTransactionsDetailsBorrowerTransaction getBorrowerTransaction() {
		return borrowerTransaction;
	}
	/**
	 * @param borrowerTransaction the borrowerTransaction to set
	 */
	public void setBorrowerTransaction(SummariesofTransactionsDetailsBorrowerTransaction borrowerTransaction) {
		this.borrowerTransaction = borrowerTransaction;
	}
	/**
	 * @return the sellerTransaction
	 */
	public SummariesofTransactionsDetailsSellerTransaction getSellerTransaction() {
		return sellerTransaction;
	}
	/**
	 * @param sellerTransaction the sellerTransaction to set
	 */
	public void setSellerTransaction(SummariesofTransactionsDetailsSellerTransaction sellerTransaction) {
		this.sellerTransaction = sellerTransaction;
	}
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
