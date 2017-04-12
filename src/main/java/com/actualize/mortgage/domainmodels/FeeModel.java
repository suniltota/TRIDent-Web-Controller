package com.actualize.mortgage.domainmodels;

import com.actualize.mortgage.utils.Expenses;

public class FeeModel extends Expenses  {

	private String  percentBasisType = "";
	private String  buyerAtClosingAmount = "";
	private String  buyerOutsideClosingAmount = "";
	private String  sellerAtClosingAmount = "";
	private String  sellerOutsideClosingAmount = "";
	private String  otherAmount = "";
	private String  otherEntity = "";
	private String  totalPercent = "";
	private String  totalAmount = "";
	private boolean OptionalCostIndicator = false;
	private String lenderStatus;
	
	public String getPercentBasisType() {
		return percentBasisType;
	}
	public void setPercentBasisType(String percentBasisType) {
		this.percentBasisType = percentBasisType;
	}
	public String getBuyerAtClosingAmount() {
		return buyerAtClosingAmount;
	}
	public void setBuyerAtClosingAmount(String buyerAtClosingAmount) {
		this.buyerAtClosingAmount = buyerAtClosingAmount;
	}
	public String getBuyerOutsideClosingAmount() {
		return buyerOutsideClosingAmount;
	}
	public void setBuyerOutsideClosingAmount(String buyerOutsideClosingAmount) {
		this.buyerOutsideClosingAmount = buyerOutsideClosingAmount;
	}
	public String getSellerAtClosingAmount() {
		return sellerAtClosingAmount;
	}
	public void setSellerAtClosingAmount(String sellerAtClosingAmount) {
		this.sellerAtClosingAmount = sellerAtClosingAmount;
	}
	public String getSellerOutsideClosingAmount() {
		return sellerOutsideClosingAmount;
	}
	public void setSellerOutsideClosingAmount(String sellerOutsideClosingAmount) {
		this.sellerOutsideClosingAmount = sellerOutsideClosingAmount;
	}
	public String getOtherAmount() {
		return otherAmount;
	}
	public void setOtherAmount(String otherAmount) {
		this.otherAmount = otherAmount;
	}
	public String getOtherEntity() {
		return otherEntity;
	}
	public void setOtherEntity(String otherEntity) {
		this.otherEntity = otherEntity;
	}
	public String getTotalPercent() {
		return totalPercent;
	}
	public void setTotalPercent(String totalPercent) {
		this.totalPercent = totalPercent;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isOptionalCostIndicator() {
		return OptionalCostIndicator;
	}
	public void setOptionalCostIndicator(boolean optionalCostIndicator) {
		OptionalCostIndicator = optionalCostIndicator;
	}
	public String getLenderStatus() {
		return lenderStatus;
	}
	public void setLenderStatus(String lenderStatus) {
		this.lenderStatus = lenderStatus;
	}
	
}
