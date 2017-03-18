package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class ClosingCostDetailsOtherCosts implements Serializable {


	private static final long serialVersionUID = 132247422580755292L;
	
	private String tOGovtFeesTotalAmount;
	private String prepaidsTotalAmount;
	private String iEPatClosingTotalAmount;
	private String otherTotalAmount;
	private String totalOtherCostsTotalAmount;
	private String totalClosingCostsTotalAmount;
	private ClosingCostProperties totalOtherCosts;
	private List<ClosingCostProperties> totalClosingCosts;
	private List<ClosingCostProperties> tOGovtFeesList;
	private List<Prepaids> prepaidsList;
	private List<IEPatClosing> iEPatClosingList;
	private List<ClosingCostProperties> OtherCostsList;

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

	public String gettOGovtFeesTotalAmount() {
		return tOGovtFeesTotalAmount;
	}

	
	public void settOGovtFeesTotalAmount(String tOGovtFeesTotalAmount) {
		this.tOGovtFeesTotalAmount = tOGovtFeesTotalAmount;
	}

	
	public String getPrepaidsTotalAmount() {
		return prepaidsTotalAmount;
	}

	
	public void setPrepaidsTotalAmount(String prepaidsTotalAmount) {
		this.prepaidsTotalAmount = prepaidsTotalAmount;
	}

	
	public String getiEPatClosingTotalAmount() {
		return iEPatClosingTotalAmount;
	}

	
	public void setiEPatClosingTotalAmount(String iEPatClosingTotalAmount) {
		this.iEPatClosingTotalAmount = iEPatClosingTotalAmount;
	}

	
	public String getOtherTotalAmount() {
		return otherTotalAmount;
	}

	
	public void setOtherTotalAmount(String otherTotalAmount) {
		this.otherTotalAmount = otherTotalAmount;
	}

	
	public String getTotalOtherCostsTotalAmount() {
		return totalOtherCostsTotalAmount;
	}

	
	public void setTotalOtherCostsTotalAmount(String totalOtherCostsTotalAmount) {
		this.totalOtherCostsTotalAmount = totalOtherCostsTotalAmount;
	}

	
	public String getTotalClosingCostsTotalAmount() {
		return totalClosingCostsTotalAmount;
	}

	
	public void setTotalClosingCostsTotalAmount(String totalClosingCostsTotalAmount) {
		this.totalClosingCostsTotalAmount = totalClosingCostsTotalAmount;
	}

	public List<Prepaids> getPrepaidsList() {
		return prepaidsList;
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

	

	public List<ClosingCostProperties> gettOGovtFeesList() {
		return tOGovtFeesList;
	}

	public void settOGovtFeesList(List<ClosingCostProperties> tOGovtFeesList) {
		this.tOGovtFeesList = tOGovtFeesList;
	}

	public List<ClosingCostProperties> getOtherCostsList() {
		return OtherCostsList;
	}

	public void setOtherCostsList(List<ClosingCostProperties> otherCostsList) {
		OtherCostsList = otherCostsList;
	}


	
}
