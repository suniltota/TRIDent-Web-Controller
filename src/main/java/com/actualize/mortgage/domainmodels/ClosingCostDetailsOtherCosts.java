package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;
/**
 * this class defines Other Costs for  Closing Cost Details in JSON response 
 * @author sboragala
 *
 */
public class ClosingCostDetailsOtherCosts implements Serializable {


	private static final long serialVersionUID = 132247422580755292L;
	
	private String tOGovtFeesTotalAmount;
	private String prepaidsTotalAmount;
	private String iEPatClosingTotalAmount;
	private String otherTotalAmount;
	private String totalOtherCostsTotalAmount;
	private TLCostsModel totalOtherCosts;
	private List<ClosingCostProperties> tOGovtFeesList;
	private List<Prepaids> prepaidsList;
	private List<IEPatClosing> iEPatClosingList;
	private List<ClosingCostProperties> OtherCostsList;
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
	 * @return the iEPatClosingTotalAmount
	 */
	public String getiEPatClosingTotalAmount() {
		return iEPatClosingTotalAmount;
	}
	/**
	 * @param iEPatClosingTotalAmount the iEPatClosingTotalAmount to set
	 */
	public void setiEPatClosingTotalAmount(String iEPatClosingTotalAmount) {
		this.iEPatClosingTotalAmount = iEPatClosingTotalAmount;
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
	public TLCostsModel getTotalOtherCosts() {
		return totalOtherCosts;
	}
	/**
	 * @param totalOtherCosts the totalOtherCosts to set
	 */
	public void setTotalOtherCosts(TLCostsModel totalOtherCosts) {
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
	 * @return the iEPatClosingList
	 */
	public List<IEPatClosing> getiEPatClosingList() {
		return iEPatClosingList;
	}
	/**
	 * @param iEPatClosingList the iEPatClosingList to set
	 */
	public void setiEPatClosingList(List<IEPatClosing> iEPatClosingList) {
		this.iEPatClosingList = iEPatClosingList;
	}
	/**
	 * @return the otherCostsList
	 */
	public List<ClosingCostProperties> getOtherCostsList() {
		return OtherCostsList;
	}
	/**
	 * @param otherCostsList the otherCostsList to set
	 */
	public void setOtherCostsList(List<ClosingCostProperties> otherCostsList) {
		OtherCostsList = otherCostsList;
	}

	

	
}
