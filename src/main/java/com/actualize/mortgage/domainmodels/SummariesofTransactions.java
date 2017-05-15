package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * this class defines summaries of transactions in JSON response 
 * @author sboragala
 *
 */
public class SummariesofTransactions implements Serializable {
	
	private static final long serialVersionUID = 1672551641387366652L;
	
	private SummariesofTransactionsDetailsPaidByAlready paidByAlready;
	private SummariesofTransactionsDetailsDueFromSellerAtClosing dueFromSeller;
	private SummariesofTransactionsDetailsBorrowerTransaction borrowerTransaction;
	private SummariesofTransactionsDetailsSellerTransaction sellerTransaction;
	
	
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
	
	
	 
}
