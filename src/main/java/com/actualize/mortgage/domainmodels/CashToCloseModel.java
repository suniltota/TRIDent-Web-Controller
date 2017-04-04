package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class CashToCloseModel implements Serializable {

	private static final long serialVersionUID = -4771787160333094672L;
	
	private String isAmountChangedIndicator = "";
	private String  itemChangeDescription = "";
	private String  itemEstimatedAmount = "";
	private String  itemFinalAmount = "";
	private String  itemType = "";
	private String  itemPaymentType = "";
	
	public String getItemChangeDescription() {
		return itemChangeDescription;
	}
	public void setItemChangeDescription(String itemChangeDescription) {
		this.itemChangeDescription = itemChangeDescription;
	}
	public String getItemEstimatedAmount() {
		return itemEstimatedAmount;
	}
	public void setItemEstimatedAmount(String itemEstimatedAmount) {
		this.itemEstimatedAmount = itemEstimatedAmount;
	}
	public String getItemFinalAmount() {
		return itemFinalAmount;
	}
	public void setItemFinalAmount(String itemFinalAmount) {
		this.itemFinalAmount = itemFinalAmount;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemPaymentType() {
		return itemPaymentType;
	}
	public void setItemPaymentType(String itemPaymentType) {
		this.itemPaymentType = itemPaymentType;
	}
	public String getIsAmountChangedIndicator() {
		return isAmountChangedIndicator;
	}
	public void setIsAmountChangedIndicator(String isAmountChangedIndicator) {
		this.isAmountChangedIndicator = isAmountChangedIndicator;
	}
	
	
	
}
