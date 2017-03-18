package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class ClosingCostDetailsLoanCosts implements Serializable {
	
	private static final long serialVersionUID = 1765551938020808255L;
	
	private String ocTotalAmount;
	private String sbDidNotShopTotalAmount;
	private String sbDidShopTotalAmount;
	private String tlCostsTotalAmount;
	private List<ClosingCostProperties> originationCharges;
	private List<ClosingCostProperties> sbDidNotShopFors;
	private List<ClosingCostProperties> sbDidShopFors;
	private ClosingCostProperties tlCosts;
	
	
	public String getOcTotalAmount() {
		return ocTotalAmount;
	}
	public void setOcTotalAmount(String ocTotalAmount) {
		this.ocTotalAmount = ocTotalAmount;
	}
	public String getSbDidNotShopTotalAmount() {
		return sbDidNotShopTotalAmount;
	}
	public void setSbDidNotShopTotalAmount(String sbDidNotShopTotalAmount) {
		this.sbDidNotShopTotalAmount = sbDidNotShopTotalAmount;
	}
	public String getSbDidShopTotalAmount() {
		return sbDidShopTotalAmount;
	}
	public void setSbDidShopTotalAmount(String sbDidShopTotalAmount) {
		this.sbDidShopTotalAmount = sbDidShopTotalAmount;
	}
	public String getTlCostsTotalAmount() {
		return tlCostsTotalAmount;
	}
	public void setTlCostsTotalAmount(String tlCostsTotalAmount) {
		this.tlCostsTotalAmount = tlCostsTotalAmount;
	}
	public List<ClosingCostProperties> getOriginationCharges() {
		return originationCharges;
	}
	public void setOriginationCharges(List<ClosingCostProperties> originationCharges) {
		this.originationCharges = originationCharges;
	}
	public List<ClosingCostProperties> getSbDidNotShopFors() {
		return sbDidNotShopFors;
	}
	public void setSbDidNotShopFors(List<ClosingCostProperties> sbDidNotShopFors) {
		this.sbDidNotShopFors = sbDidNotShopFors;
	}
	public List<ClosingCostProperties> getSbDidShopFors() {
		return sbDidShopFors;
	}
	public void setSbDidShopFors(List<ClosingCostProperties> sbDidShopFors) {
		this.sbDidShopFors = sbDidShopFors;
	}
	public ClosingCostProperties getTlCosts() {
		return tlCosts;
	}
	public void setTlCosts(ClosingCostProperties tlCosts) {
		this.tlCosts = tlCosts;
	}
	
	
}
