package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class SummariesofTransactionsDetailsDueToSellerAtClosing implements Serializable{

	private static final long serialVersionUID = 3636097337611112788L;

	private String salePriceOfProperty;
	private String salePriceOfPersonalProperty;
	private String closingCostsPaidAtClosing;
	private List<ClosingAdjustmentItemModel> dueToSellerAdjustments;
	private List<ProrationModel> dueToSellerAdjustmentsPaidBySeller;
	private String dueToSellerTotalAmount;
	
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
	public String getClosingCostsPaidAtClosing() {
		return closingCostsPaidAtClosing;
	}
	/**
	 * @param closingCostsPaidAtClosing the closingCostsPaidAtClosing to set
	 */
	public void setClosingCostsPaidAtClosing(String closingCostsPaidAtClosing) {
		this.closingCostsPaidAtClosing = closingCostsPaidAtClosing;
	}
	/**
	 * @return the dueToSellerAdjustments
	 */
	public List<ClosingAdjustmentItemModel> getDueToSellerAdjustments() {
		return dueToSellerAdjustments;
	}
	/**
	 * @param dueToSellerAdjustments the dueToSellerAdjustments to set
	 */
	public void setDueToSellerAdjustments(List<ClosingAdjustmentItemModel> dueToSellerAdjustments) {
		this.dueToSellerAdjustments = dueToSellerAdjustments;
	}
	/**
	 * @return the dueToSellerAdjustmentsPaidBySeller
	 */
	public List<ProrationModel> getDueToSellerAdjustmentsPaidBySeller() {
		return dueToSellerAdjustmentsPaidBySeller;
	}
	/**
	 * @param dueToSellerAdjustmentsPaidBySeller the dueToSellerAdjustmentsPaidBySeller to set
	 */
	public void setDueToSellerAdjustmentsPaidBySeller(List<ProrationModel> dueToSellerAdjustmentsPaidBySeller) {
		this.dueToSellerAdjustmentsPaidBySeller = dueToSellerAdjustmentsPaidBySeller;
	}
	/**
	 * @return the dueToSellerTotalAmount
	 */
	public String getDueToSellerTotalAmount() {
		return dueToSellerTotalAmount;
	}
	/**
	 * @param dueToSellerTotalAmount the dueToSellerTotalAmount to set
	 */
	public void setDueToSellerTotalAmount(String dueToSellerTotalAmount) {
		this.dueToSellerTotalAmount = dueToSellerTotalAmount;
	}
	
}
