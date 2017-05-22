package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;
/**
 * this class defines Other Costs for  Closing Cost Details in JSON response 
 * @author sboragala
 *
 */
public class ClosingCostDetailsOtherCosts implements Serializable {

	private static final long serialVersionUID = -4429240770157151663L;
	private String tOGovtFeesTotalAmount;
	private String prepaidsTotalAmount;
	private String escrowItemsTotalAmount;
	private String otherTotalAmount;
	private String totalOtherCostsTotalAmount;
	private PaymentsModel totalOtherCosts;
	private List<ClosingCostProperties> tOGovtFeesList;
	private List<Prepaids> prepaidsList;
	private List<EscrowItemModel> escrowItemsList;
	private List<ClosingCostProperties> otherCostsList;
	
	/**
	 * @return the tOGovtFeesTotalAmount
	 */
	public String gettOGovtFeesTotalAmount() {
		return tOGovtFeesTotalAmount;
	}
	/**
	 * @param tOGovtFeesTotalAmount the tOGovtFeesTotalAmount to set
	 */
	public void settOGovtFeesTotalAmount(String tOGovtFeesTotalAmount) {
		this.tOGovtFeesTotalAmount = tOGovtFeesTotalAmount;
	}
	/**
	 * @return the prepaidsTotalAmount
	 */
	public String getPrepaidsTotalAmount() {
		return prepaidsTotalAmount;
	}
	/**
	 * @param prepaidsTotalAmount the prepaidsTotalAmount to set
	 */
	public void setPrepaidsTotalAmount(String prepaidsTotalAmount) {
		this.prepaidsTotalAmount = prepaidsTotalAmount;
	}
	/**
	 * @return the escrowItemsTotalAmount
	 */
	public String getEscrowItemsTotalAmount() {
		return escrowItemsTotalAmount;
	}
	/**
	 * @param escrowItemsTotalAmount the escrowItemsTotalAmount to set
	 */
	public void setEscrowItemsTotalAmount(String escrowItemsTotalAmount) {
		this.escrowItemsTotalAmount = escrowItemsTotalAmount;
	}
	/**
	 * @return the otherTotalAmount
	 */
	public String getOtherTotalAmount() {
		return otherTotalAmount;
	}
	/**
	 * @param otherTotalAmount the otherTotalAmount to set
	 */
	public void setOtherTotalAmount(String otherTotalAmount) {
		this.otherTotalAmount = otherTotalAmount;
	}
	/**
	 * @return the totalOtherCostsTotalAmount
	 */
	public String getTotalOtherCostsTotalAmount() {
		return totalOtherCostsTotalAmount;
	}
	/**
	 * @param totalOtherCostsTotalAmount the totalOtherCostsTotalAmount to set
	 */
	public void setTotalOtherCostsTotalAmount(String totalOtherCostsTotalAmount) {
		this.totalOtherCostsTotalAmount = totalOtherCostsTotalAmount;
	}
	/**
	 * @return the totalOtherCosts
	 */
	public PaymentsModel getTotalOtherCosts() {
		return totalOtherCosts;
	}
	/**
	 * @param totalOtherCosts the totalOtherCosts to set
	 */
	public void setTotalOtherCosts(PaymentsModel totalOtherCosts) {
		this.totalOtherCosts = totalOtherCosts;
	}
	/**
	 * @return the tOGovtFeesList
	 */
	public List<ClosingCostProperties> gettOGovtFeesList() {
		return tOGovtFeesList;
	}
	/**
	 * @param tOGovtFeesList the tOGovtFeesList to set
	 */
	public void settOGovtFeesList(List<ClosingCostProperties> tOGovtFeesList) {
		this.tOGovtFeesList = tOGovtFeesList;
	}
	/**
	 * @return the prepaidsList
	 */
	public List<Prepaids> getPrepaidsList() {
		return prepaidsList;
	}
	/**
	 * @param prepaidsList the prepaidsList to set
	 */
	public void setPrepaidsList(List<Prepaids> prepaidsList) {
		this.prepaidsList = prepaidsList;
	}
	/**
	 * @return the escrowItemsList
	 */
	public List<EscrowItemModel> getEscrowItemsList() {
		return escrowItemsList;
	}
	/**
	 * @param escrowItemsList the escrowItemsList to set
	 */
	public void setEscrowItemsList(List<EscrowItemModel> escrowItemsList) {
		this.escrowItemsList = escrowItemsList;
	}
	/**
	 * @return the otherCostsList
	 */
	public List<ClosingCostProperties> getOtherCostsList() {
		return otherCostsList;
	}
	/**
	 * @param otherCostsList the otherCostsList to set
	 */
	public void setOtherCostsList(List<ClosingCostProperties> otherCostsList) {
		this.otherCostsList = otherCostsList;
	}
	
	
}
