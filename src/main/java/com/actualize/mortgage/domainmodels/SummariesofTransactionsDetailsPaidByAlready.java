package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class SummariesofTransactionsDetailsPaidByAlready implements Serializable{
	
	
	private static final long serialVersionUID = -5690104701135903828L;
	
	//initializing objects to send empty objects if no values found
	
	private ClosingCostFundModel deposit =  new ClosingCostFundModel();
	private ClosingAdjustmentItemModel sellerCredit = new ClosingAdjustmentItemModel();
	private String disclosureDescription;
	private ClosingAdjustmentItemModel subordinateLien = new ClosingAdjustmentItemModel() ; 
	private String totalSubordinateFinancingAmount;
	
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
	
}
