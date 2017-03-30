package com.actualize.mortgage.domainmodels;

import com.actualize.mortgage.utils.Expenses;

public class PrepaidsModel extends Expenses {
	
	private String PrepaidItemMonthsPaidCount = "";
	private String PrepaidItemPaidFromDate = "";
	private String PrepaidItemPaidThroughDate = "";
	private String PrepaidItemPerDiemAmount = "";
	private String PrepaidItemPerDiemCalculationMethodType = "";
	private String BuyerOutsideClosingAmount = "";
	private String BuyerAtClosingAmount = "";
	private String SellerOutsideClosingAmount = "";
	private String SellerAtClosingAmount = "";
	private String OtherEntity = "";
	private String OtherAmount = "";
	private String lenderStatus;
	
	public String getPrepaidItemMonthsPaidCount() {
		return PrepaidItemMonthsPaidCount;
	}
	public void setPrepaidItemMonthsPaidCount(String prepaidItemMonthsPaidCount) {
		PrepaidItemMonthsPaidCount = prepaidItemMonthsPaidCount;
	}
	public String getPrepaidItemPaidFromDate() {
		return PrepaidItemPaidFromDate;
	}
	public void setPrepaidItemPaidFromDate(String prepaidItemPaidFromDate) {
		PrepaidItemPaidFromDate = prepaidItemPaidFromDate;
	}
	public String getPrepaidItemPaidThroughDate() {
		return PrepaidItemPaidThroughDate;
	}
	public void setPrepaidItemPaidThroughDate(String prepaidItemPaidThroughDate) {
		PrepaidItemPaidThroughDate = prepaidItemPaidThroughDate;
	}
	public String getPrepaidItemPerDiemAmount() {
		return PrepaidItemPerDiemAmount;
	}
	public void setPrepaidItemPerDiemAmount(String prepaidItemPerDiemAmount) {
		PrepaidItemPerDiemAmount = prepaidItemPerDiemAmount;
	}
	public String getPrepaidItemPerDiemCalculationMethodType() {
		return PrepaidItemPerDiemCalculationMethodType;
	}
	public void setPrepaidItemPerDiemCalculationMethodType(String prepaidItemPerDiemCalculationMethodType) {
		PrepaidItemPerDiemCalculationMethodType = prepaidItemPerDiemCalculationMethodType;
	}
	public String getBuyerOutsideClosingAmount() {
		return BuyerOutsideClosingAmount;
	}
	public void setBuyerOutsideClosingAmount(String amount) {
		BuyerOutsideClosingAmount = amount;
	}
	public String getBuyerAtClosingAmount() {
		return BuyerAtClosingAmount;
	}
	public void setBuyerAtClosingAmount(String amount) {
		BuyerAtClosingAmount = amount;
	}
	public String getSellerOutsideClosingAmount() {
		return SellerOutsideClosingAmount;			
	}
	public void setSellerOutsideClosingAmount(String amount) {
		SellerOutsideClosingAmount = amount;			
	}
	public String getSellerAtClosingAmount() {
		return SellerAtClosingAmount;
	}
	public void setSellerAtClosingAmount(String amount) {
		SellerAtClosingAmount = amount;
	}
	public String getOtherEntity() {
		return OtherEntity;
	}
	public void setOtherEntity(String otherEntity) {
		OtherEntity = otherEntity;
	}
	public String getOtherAmount() {
		return OtherAmount;
	}
	public void setOtherAmount(String amount) {
		OtherAmount = amount;
	}
	public String getLenderStatus() {
		return lenderStatus;
	}
	public void setLenderStatus(String lenderStatus) {
		this.lenderStatus = lenderStatus;
	}

}
