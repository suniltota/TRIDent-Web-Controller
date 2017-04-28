package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * this class defines SalesContractDetail in JSON Response
 * @author sboragala
 *
 */
public class SalesContractDetailModel implements Serializable{
	
	private static final long serialVersionUID = -3763131948453549811L;

	private boolean personalPropertyIndicator;
	private String personalPropertyAmount;
	private String realPropertyAmount;
	private String saleContractAmount;
	
	/**
	 * @return the personalPropertyIndicator
	 */
	public boolean isPersonalPropertyIndicator() {
		return personalPropertyIndicator;
	}
	/**
	 * @param personalPropertyIndicator the personalPropertyIndicator to set
	 */
	public void setPersonalPropertyIndicator(boolean personalPropertyIndicator) {
		this.personalPropertyIndicator = personalPropertyIndicator;
	}
	/**
	 * @return the personalPropertyAmount
	 */
	public String getPersonalPropertyAmount() {
		return personalPropertyAmount;
	}
	/**
	 * @param personalPropertyAmount the personalPropertyAmount to set
	 */
	public void setPersonalPropertyAmount(String personalPropertyAmount) {
		this.personalPropertyAmount = personalPropertyAmount;
	}
	/**
	 * @return the realPropertyAmount
	 */
	public String getRealPropertyAmount() {
		return realPropertyAmount;
	}
	/**
	 * @param realPropertyAmount the realPropertyAmount to set
	 */
	public void setRealPropertyAmount(String realPropertyAmount) {
		this.realPropertyAmount = realPropertyAmount;
	}
	/**
	 * @return the saleContractAmount
	 */
	public String getSaleContractAmount() {
		return saleContractAmount;
	}
	/**
	 * @param saleContractAmount the saleContractAmount to set
	 */
	public void setSaleContractAmount(String saleContractAmount) {
		this.saleContractAmount = saleContractAmount;
	}
	
	
	

}
