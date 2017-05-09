package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;
/**
 * this class defines DueFromBorrowerAtClosing for SummariesofTransactions in JSON response
 * @author sboragala
 *
 */
public class SummariesofTransactionsDetailsDueFromBorrowerAtClosing implements Serializable{
	

	private static final long serialVersionUID = -7422950890798131710L;
	
	private String salePriceOfProperty;
	private String salePriceOfPersonalProperty;
	private IntegratedDisclosureSectionSummaryModel closingCostsPaidAtClosing;
	private List<LiabilityModel> dueFromBorrowerAtClosing;
	private List<ClosingAdjustmentItemModel> adjustments;
	private List<ProrationModel> adjustmentsPaidBySellerInAdvance;
	private IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosingTotalAmount;
	
	/**
	 * @return the salePriceOfProperty
	 */
	public String getSalePriceOfProperty() {
		return salePriceOfProperty;
	}
	/**
	 * @param salePriceOfProperty the salePriceOfProperty to set
	 */
	public void setSalePriceOfProperty(String salePriceOfProperty) {
		this.salePriceOfProperty = salePriceOfProperty;
	}
	/**
	 * @return the salePriceOfPersonalProperty
	 */
	public String getSalePriceOfPersonalProperty() {
		return salePriceOfPersonalProperty;
	}
	/**
	 * @param salePriceOfPersonalProperty the salePriceOfPersonalProperty to set
	 */
	public void setSalePriceOfPersonalProperty(String salePriceOfPersonalProperty) {
		this.salePriceOfPersonalProperty = salePriceOfPersonalProperty;
	}
	/**
	 * @return the closingCostsPaidAtClosing
	 */
	public IntegratedDisclosureSectionSummaryModel getClosingCostsPaidAtClosing() {
		return closingCostsPaidAtClosing;
	}
	/**
	 * @param closingCostsPaidAtClosing the closingCostsPaidAtClosing to set
	 */
	public void setClosingCostsPaidAtClosing(IntegratedDisclosureSectionSummaryModel closingCostsPaidAtClosing) {
		this.closingCostsPaidAtClosing = closingCostsPaidAtClosing;
	}
	/**
	 * @return the dueFromBorrowerAtClosing
	 */
	public List<LiabilityModel> getDueFromBorrowerAtClosing() {
		return dueFromBorrowerAtClosing;
	}
	/**
	 * @param dueFromBorrowerAtClosing the dueFromBorrowerAtClosing to set
	 */
	public void setDueFromBorrowerAtClosing(List<LiabilityModel> dueFromBorrowerAtClosing) {
		this.dueFromBorrowerAtClosing = dueFromBorrowerAtClosing;
	}
	/**
	 * @return the adjustments
	 */
	public List<ClosingAdjustmentItemModel> getAdjustments() {
		return adjustments;
	}
	/**
	 * @param adjustments the adjustments to set
	 */
	public void setAdjustments(List<ClosingAdjustmentItemModel> adjustments) {
		this.adjustments = adjustments;
	}
	/**
	 * @return the adjustmentsPaidBySellerInAdvance
	 */
	public List<ProrationModel> getAdjustmentsPaidBySellerInAdvance() {
		return adjustmentsPaidBySellerInAdvance;
	}
	/**
	 * @param adjustmentsPaidBySellerInAdvance the adjustmentsPaidBySellerInAdvance to set
	 */
	public void setAdjustmentsPaidBySellerInAdvance(List<ProrationModel> adjustmentsPaidBySellerInAdvance) {
		this.adjustmentsPaidBySellerInAdvance = adjustmentsPaidBySellerInAdvance;
	}
	/**
	 * @return the dueFromBorrowerAtClosingTotalAmount
	 */
	public IntegratedDisclosureSectionSummaryModel getDueFromBorrowerAtClosingTotalAmount() {
		return dueFromBorrowerAtClosingTotalAmount;
	}
	/**
	 * @param dueFromBorrowerAtClosingTotalAmount the dueFromBorrowerAtClosingTotalAmount to set
	 */
	public void setDueFromBorrowerAtClosingTotalAmount(
			IntegratedDisclosureSectionSummaryModel dueFromBorrowerAtClosingTotalAmount) {
		this.dueFromBorrowerAtClosingTotalAmount = dueFromBorrowerAtClosingTotalAmount;
	}
	
	
	
}
