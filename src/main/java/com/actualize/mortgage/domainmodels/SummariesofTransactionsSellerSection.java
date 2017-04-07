package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class SummariesofTransactionsSellerSection implements Serializable{

	private static final long serialVersionUID = 3636097337611112788L;

	private String duetoSelleratClosing;
	private String duefromSelleratClosing;
	private List<SummariesofTransactionsCalculation> summariesofTransactionsCalculation;
	
	public String getDuetoSelleratClosing() {
		return duetoSelleratClosing;
	}
	public void setDuetoSelleratClosing(String duetoSelleratClosing) {
		this.duetoSelleratClosing = duetoSelleratClosing;
	}
	public String getDuefromSelleratClosing() {
		return duefromSelleratClosing;
	}
	public void setDuefromSelleratClosing(String duefromSelleratClosing) {
		this.duefromSelleratClosing = duefromSelleratClosing;
	}
	
	public List<SummariesofTransactionsCalculation> getSummariesofTransactionsCalculation() {
		return summariesofTransactionsCalculation;
	}
	public void setSummariesofTransactionsCalculation(
			List<SummariesofTransactionsCalculation> summariesofTransactionsCalculation) {
		this.summariesofTransactionsCalculation = summariesofTransactionsCalculation;
	}
	
	
	
}
