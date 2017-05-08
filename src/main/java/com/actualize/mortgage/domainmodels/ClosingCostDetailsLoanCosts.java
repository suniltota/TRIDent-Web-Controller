package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;
/**
 * defines loan costs for ClosingCostDetails in JOSN response
 * @author sboragala
 *
 */
public class ClosingCostDetailsLoanCosts implements Serializable {
	
	private static final long serialVersionUID = 1765551938020808255L;
	
	private String ocTotalAmount;
	private String sbDidNotShopTotalAmount;
	private String sbDidShopTotalAmount;
	private String tlCostsTotalAmount;
	private List<ClosingCostProperties> originationCharges;
	private List<ClosingCostProperties> sbDidNotShopFors;
	private List<ClosingCostProperties> sbDidShopFors;
	private PaymentsModel tlCosts;
	
	/**
	 * @return the ocTotalAmount
	 */
	public String getOcTotalAmount() {
		return ocTotalAmount;
	}
	/**
	 * @param ocTotalAmount the ocTotalAmount to set
	 */
	public void setOcTotalAmount(String ocTotalAmount) {
		this.ocTotalAmount = ocTotalAmount;
	}
	/**
	 * @return the sbDidNotShopTotalAmount
	 */
	public String getSbDidNotShopTotalAmount() {
		return sbDidNotShopTotalAmount;
	}
	/**
	 * @param sbDidNotShopTotalAmount the sbDidNotShopTotalAmount to set
	 */
	public void setSbDidNotShopTotalAmount(String sbDidNotShopTotalAmount) {
		this.sbDidNotShopTotalAmount = sbDidNotShopTotalAmount;
	}
	/**
	 * @return the sbDidShopTotalAmount
	 */
	public String getSbDidShopTotalAmount() {
		return sbDidShopTotalAmount;
	}
	/**
	 * @param sbDidShopTotalAmount the sbDidShopTotalAmount to set
	 */
	public void setSbDidShopTotalAmount(String sbDidShopTotalAmount) {
		this.sbDidShopTotalAmount = sbDidShopTotalAmount;
	}
	/**
	 * @return the tlCostsTotalAmount
	 */
	public String getTlCostsTotalAmount() {
		return tlCostsTotalAmount;
	}
	/**
	 * @param tlCostsTotalAmount the tlCostsTotalAmount to set
	 */
	public void setTlCostsTotalAmount(String tlCostsTotalAmount) {
		this.tlCostsTotalAmount = tlCostsTotalAmount;
	}
	/**
	 * @return the originationCharges
	 */
	public List<ClosingCostProperties> getOriginationCharges() {
		return originationCharges;
	}
	/**
	 * @param originationCharges the originationCharges to set
	 */
	public void setOriginationCharges(List<ClosingCostProperties> originationCharges) {
		this.originationCharges = originationCharges;
	}
	/**
	 * @return the sbDidNotShopFors
	 */
	public List<ClosingCostProperties> getSbDidNotShopFors() {
		return sbDidNotShopFors;
	}
	/**
	 * @param sbDidNotShopFors the sbDidNotShopFors to set
	 */
	public void setSbDidNotShopFors(List<ClosingCostProperties> sbDidNotShopFors) {
		this.sbDidNotShopFors = sbDidNotShopFors;
	}
	/**
	 * @return the sbDidShopFors
	 */
	public List<ClosingCostProperties> getSbDidShopFors() {
		return sbDidShopFors;
	}
	/**
	 * @param sbDidShopFors the sbDidShopFors to set
	 */
	public void setSbDidShopFors(List<ClosingCostProperties> sbDidShopFors) {
		this.sbDidShopFors = sbDidShopFors;
	}
	/**
	 * @return the tlCosts
	 */
	public PaymentsModel getTlCosts() {
		return tlCosts;
	}
	/**
	 * @param tlCosts the tlCosts to set
	 */
	public void setTlCosts(PaymentsModel tlCosts) {
		this.tlCosts = tlCosts;
	}
	
	
	
	
}
