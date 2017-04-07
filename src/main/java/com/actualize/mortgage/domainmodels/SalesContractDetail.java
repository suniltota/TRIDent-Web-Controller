package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class SalesContractDetail implements Serializable{
	
	private static final long serialVersionUID = -3763131948453549811L;

	private boolean personalPropertyIndicator;
	private String personalPropertyAmount;
	private String realPropertyAmount;
	private String saleContractAmount;
	
	public String getPersonalPropertyAmount() {
		return personalPropertyAmount;
	}
	public void setPersonalPropertyAmount(String personalPropertyAmount) {
		this.personalPropertyAmount = personalPropertyAmount;
	}
	public String getRealPropertyAmount() {
		return realPropertyAmount;
	}
	public void setRealPropertyAmount(String realPropertyAmount) {
		this.realPropertyAmount = realPropertyAmount;
	}
	public String getSaleContractAmount() {
		return saleContractAmount;
	}
	public void setSaleContractAmount(String saleContractAmount) {
		this.saleContractAmount = saleContractAmount;
	}
	public boolean isPersonalPropertyIndicator() {
		return personalPropertyIndicator;
	}
	public void setPersonalPropertyIndicator(boolean personalPropertyIndicator) {
		this.personalPropertyIndicator = personalPropertyIndicator;
	}
	

}
