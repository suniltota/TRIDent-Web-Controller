package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class SalesContractDetail implements Serializable{
	
	private static final long serialVersionUID = -3763131948453549811L;

	private String personalPropertyIndicator;
	private String personalPropertyAmount;
	private String realPropertyAmount;
	private String saleContractAmount;
	
	public String getPersonalPropertyIndicator() {
		return personalPropertyIndicator;
	}
	public void setPersonalPropertyIndicator(String personalPropertyIndicator) {
		this.personalPropertyIndicator = personalPropertyIndicator;
	}
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
	

}
