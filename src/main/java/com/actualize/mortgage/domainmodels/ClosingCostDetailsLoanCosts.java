package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class ClosingCostDetailsLoanCosts implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1765551938020808255L;
	
	private String ocTotalAmount;
	private String sbDidNotShopTotalAmount;
	private String sbDidShopTotalAmount;
	private String tlCostsTotalAmount;
	private List<OriginationCharges> originationCharges;
	private List<SBDidNotShopFor> sbDidNotShopFors;
	private List<SBDidShopFor> sbDidShopFors;
	private TLCOSTS tlCosts;
		
	public class OriginationCharges extends ClosingCostProperties{

		/**
		 * 
		 */
		private static final long serialVersionUID = -2367627974658304679L;
		
	}

	public class SBDidNotShopFor extends ClosingCostProperties{

		/**
		 * 
		 */
		private static final long serialVersionUID = 2364632866227147401L;
		
	}
	
	public class SBDidShopFor extends ClosingCostProperties{

		/**
		 * 
		 */
		private static final long serialVersionUID = -6143723302350416236L;
		
	}
	
	public class TLCOSTS extends ClosingCostProperties{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1566826121121432029L;
		
	} 
	/**
	 * @return the originationCharges
	 */
	public List<OriginationCharges> getOriginationCharges() {
		return originationCharges;
	}



	/**
	 * @param originationCharges the originationCharges to set
	 */
	public void setOriginationCharges(List<OriginationCharges> originationCharges) {
		this.originationCharges = originationCharges;
	}



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
	 * @return the sbDidNotShopFors
	 */
	public List<SBDidNotShopFor> getSbDidNotShopFors() {
		return sbDidNotShopFors;
	}



	/**
	 * @param sbDidNotShopFors the sbDidNotShopFors to set
	 */
	public void setSbDidNotShopFors(List<SBDidNotShopFor> sbDidNotShopFors) {
		this.sbDidNotShopFors = sbDidNotShopFors;
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
	 * @return the sbDidShopFor
	 */
	public List<SBDidShopFor> getSbDidShopFors() {
		return sbDidShopFors;
	}



	/**
	 * @param sbDidShopFor the sbDidShopFor to set
	 */
	public void setSbDidShopFors(List<SBDidShopFor> sbDidShopFors) {
		this.sbDidShopFors = sbDidShopFors;
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
	 * @return the tlCosts
	 */
	public TLCOSTS getTlCosts() {
		return tlCosts;
	}



	/**
	 * @param tlCosts the tlCosts to set
	 */
	public void setTlCosts(TLCOSTS tlCosts) {
		this.tlCosts = tlCosts;
	}



	
}
