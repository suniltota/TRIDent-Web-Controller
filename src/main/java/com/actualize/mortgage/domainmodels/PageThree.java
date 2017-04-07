package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageThree implements Serializable {
	
	private static final long serialVersionUID = 9098482987190939510L;
	
	@JsonProperty(value="CalculatingCashtoClose")
	private List<CashToClose> cashToCloses;
	
	@JsonProperty(value="SummariesofTransactions")
	private SummariesofTransactions summariesofTransactions;
	
	public List<CashToClose> getCashToCloses() {
		return cashToCloses;
	}

	public void setCashToCloses(List<CashToClose> cashToCloses) {
		this.cashToCloses = cashToCloses;
	}

	public SummariesofTransactions getSummariesofTransactions() {
		return summariesofTransactions;
	}

	public void setSummariesofTransactions(SummariesofTransactions summariesofTransactions) {
		this.summariesofTransactions = summariesofTransactions;
	}
	
	
}
