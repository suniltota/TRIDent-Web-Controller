package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class SummariesofTransactionsDetailsPaidByAlready implements Serializable{
	
	
	private static final long serialVersionUID = -5690104701135903828L;
	
	private ClosingCostFundModel deposit;
	private String existingLoan;
	private ClosingAdjustmentItemModel sellerCredit;
	private String disclosureDescription;
	private ClosingAdjustmentItemModel subordinateLien; 
	private String totalSubordinateFinancingAmount;
	private List<ClosingAdjustmentItemModel> otherCredits;
	//private List<ClosingAdjustmentItemModel> adjustments;
	//private List<ProrationModel> adjustmentsUnpaidBySeller;
	private IntegratedDisclosureSectionSummaryModel paidByAlreadyTotalAmount;
	
	/**
	 * @return the deposit
	 */
	public ClosingCostFundModel getDeposit() {
		return deposit;
	}
	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(ClosingCostFundModel deposit) {
		this.deposit = deposit;
	}
	/**
	 * @return the existingLoan
	 */
	public String getExistingLoan() {
		return existingLoan;
	}
	/**
	 * @param existingLoan the existingLoan to set
	 */
	public void setExistingLoan(String existingLoan) {
		this.existingLoan = existingLoan;
	}
	/**
	 * @return the sellerCredit
	 */
	public ClosingAdjustmentItemModel getSellerCredit() {
		return sellerCredit;
	}
	/**
	 * @param sellerCredit the sellerCredit to set
	 */
	public void setSellerCredit(ClosingAdjustmentItemModel sellerCredit) {
		this.sellerCredit = sellerCredit;
	}
	/**
	 * @return the disclosureDescription
	 */
	public String getDisclosureDescription() {
		return disclosureDescription;
	}
	/**
	 * @param disclosureDescription the disclosureDescription to set
	 */
	public void setDisclosureDescription(String disclosureDescription) {
		this.disclosureDescription = disclosureDescription;
	}
	/**
	 * @return the subordinateLien
	 */
	public ClosingAdjustmentItemModel getSubordinateLien() {
		return subordinateLien;
	}
	/**
	 * @param subordinateLien the subordinateLien to set
	 */
	public void setSubordinateLien(ClosingAdjustmentItemModel subordinateLien) {
		this.subordinateLien = subordinateLien;
	}
	/**
	 * @return the totalSubordinateFinancingAmount
	 */
	public String getTotalSubordinateFinancingAmount() {
		return totalSubordinateFinancingAmount;
	}
	/**
	 * @param totalSubordinateFinancingAmount the totalSubordinateFinancingAmount to set
	 */
	public void setTotalSubordinateFinancingAmount(String totalSubordinateFinancingAmount) {
		this.totalSubordinateFinancingAmount = totalSubordinateFinancingAmount;
	}
	/**
	 * @return the otherCredits
	 */
	public List<ClosingAdjustmentItemModel> getOtherCredits() {
		return otherCredits;
	}
	/**
	 * @param otherCredits the otherCredits to set
	 */
	public void setOtherCredits(List<ClosingAdjustmentItemModel> otherCredits) {
		this.otherCredits = otherCredits;
	}
	/**
	 * @return the paidByAlreadyTotalAmount
	 */
	public IntegratedDisclosureSectionSummaryModel getPaidByAlreadyTotalAmount() {
		return paidByAlreadyTotalAmount;
	}
	/**
	 * @param paidByAlreadyTotalAmount the paidByAlreadyTotalAmount to set
	 */
	public void setPaidByAlreadyTotalAmount(IntegratedDisclosureSectionSummaryModel paidByAlreadyTotalAmount) {
		this.paidByAlreadyTotalAmount = paidByAlreadyTotalAmount;
	}
	
	
}
