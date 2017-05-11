package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;
/**
 * this class defines summaries of transactions in JSON response 
 * @author sboragala
 *
 */
public class SummariesofTransactions implements Serializable {
	
	private static final long serialVersionUID = 1672551641387366652L;
	
	private List<LiabilityModel> liabilityList;
	private List<ClosingAdjustmentItemModel> ClosingAdjustmentItemList;
	private List<ClosingCostFundModel> closingCostFundList;
	private List<ProrationModel> prorationList;
	private SummariesofTransactionsDetailsDueFromBorrowerAtClosing dueFromBorroweratClosing;
	private SummariesofTransactionsDetailsPaidByAlready paidByAlready;
	private SummariesofTransactionsDetailsDueToSellerAtClosing dueToSeller;
	private SummariesofTransactionsDetailsDueFromSellerAtClosing dueFromSeller;
	private SummariesofTransactionsDetailsBorrowerTransaction borrowerTransaction;
	private SummariesofTransactionsDetailsSellerTransaction sellerTransaction;
	
	/**
	 * @return the liabilityList
	 */
	public List<LiabilityModel> getLiabilityList() {
		return liabilityList;
	}
	/**
	 * @param liabilityList the liabilityList to set
	 */
	public void setLiabilityList(List<LiabilityModel> liabilityList) {
		this.liabilityList = liabilityList;
	}
	/**
	 * @return the closingAdjustmentItemList
	 */
	public List<ClosingAdjustmentItemModel> getClosingAdjustmentItemList() {
		return ClosingAdjustmentItemList;
	}
	/**
	 * @param closingAdjustmentItemList the closingAdjustmentItemList to set
	 */
	public void setClosingAdjustmentItemList(List<ClosingAdjustmentItemModel> closingAdjustmentItemList) {
		ClosingAdjustmentItemList = closingAdjustmentItemList;
	}
	/**
	 * @return the closingCostFundList
	 */
	public List<ClosingCostFundModel> getClosingCostFundList() {
		return closingCostFundList;
	}
	/**
	 * @param closingCostFundList the closingCostFundList to set
	 */
	public void setClosingCostFundList(List<ClosingCostFundModel> closingCostFundList) {
		this.closingCostFundList = closingCostFundList;
	}
	/**
	 * @return the prorationList
	 */
	public List<ProrationModel> getProrationList() {
		return prorationList;
	}
	/**
	 * @param prorationList the prorationList to set
	 */
	public void setProrationList(List<ProrationModel> prorationList) {
		this.prorationList = prorationList;
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
