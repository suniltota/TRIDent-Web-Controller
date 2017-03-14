package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class ClosingCostDetailsOtherCosts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 132247422580755292L;
	
	private String tOGovtFeesTotalAmount;
	private String prepaidsTotalAmount;
	private String iEPatClosingTotalAmount;
	private String otherTotalAmount;
	private String totalOtherCostsTotalAmount;
	private String totalClosingCostsTotalAmount;
	
	private List<TOGovtFees> tOGovtFeesList;
	private List<Prepaids> prepaidsList;
	private List<IEPatClosing> iEPatClosingList;
	private List<OtherCosts> otherCostsList;
	private ClosingCostProperties totalOtherCosts;
	private List<ClosingCostProperties> totalClosingCosts;
	
	
	public List<TOGovtFees> gettOGovtFeesList() {
		return tOGovtFeesList;
	}

	public void settOGovtFeesList(List<TOGovtFees> tOGovtFeesList) {
		this.tOGovtFeesList = tOGovtFeesList;
	}

	public List<Prepaids> getPrepaidsList() {
		return prepaidsList;
	}

	public List<OtherCosts> getOtherCostsList() {
		return otherCostsList;
	}

	public void setOtherCostsList(List<OtherCosts> otherCostsList) {
		this.otherCostsList = otherCostsList;
	}

	public void setPrepaidsList(List<Prepaids> prepaidsList) {
		this.prepaidsList = prepaidsList;
	}

	public List<IEPatClosing> getiEPatClosingList() {
		return iEPatClosingList;
	}

	public void setiEPatClosingList(List<IEPatClosing> iEPatClosingList) {
		this.iEPatClosingList = iEPatClosingList;
	}

	public ClosingCostProperties getTotalOtherCosts() {
		return totalOtherCosts;
	}

	public void setTotalOtherCosts(ClosingCostProperties totalOtherCosts) {
		this.totalOtherCosts = totalOtherCosts;
	}

	public List<ClosingCostProperties> getTotalClosingCosts() {
		return totalClosingCosts;
	}

	public void setTotalClosingCosts(List<ClosingCostProperties> totalClosingCosts) {
		this.totalClosingCosts = totalClosingCosts;
	}

	public class TOGovtFees extends ClosingCostProperties
	{
		private static final long serialVersionUID = -5607371913730688612L;
	}
	
	public class Prepaids extends ClosingCostProperties
	{

		private static final long serialVersionUID = -2388094560107574546L;
		
	}
	
	public class IEPatClosing extends ClosingCostProperties
	{

		private static final long serialVersionUID = 8592775879789983999L;
		
		private String escrowAmount;

		public String getEscrowAmount() {
			return escrowAmount;
		}

		public void setEscrowAmount(String escrowAmount) {
			this.escrowAmount = escrowAmount;
		}
		
	}

	public class OtherCosts extends ClosingCostProperties
	{

		private static final long serialVersionUID = 7229610447684578762L;

	}
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
	 * @return the totalClosingCostsTotalAmount
	 */
	public String getTotalClosingCostsTotalAmount() {
		return totalClosingCostsTotalAmount;
	}

	/**
	 * @param totalClosingCostsTotalAmount the totalClosingCostsTotalAmount to set
	 */
	public void setTotalClosingCostsTotalAmount(String totalClosingCostsTotalAmount) {
		this.totalClosingCostsTotalAmount = totalClosingCostsTotalAmount;
	}
	
}
