package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SummariesofTransactionsBorrowerSection  implements Serializable{
	

	private static final long serialVersionUID = 7158968648557225534L;

	private String dueFromBorrowerAtClosingTotalAmount;
	private String paidAlreadybyoronBehalfofBorroweratClosing;
	@JsonProperty(value = "duefromBorroweratClosing")
	private SummariesofTransactionsDetailsDueFromBorrowerAtClosing duefromBorroweratClosing;
	@JsonProperty(value = "paidAlreadybyoronBehalf")
	private SummariesofTransactionsDetailsPaidAlreadyby paidAlreadyby; 
	@JsonProperty(value = "calculation") 
	private List<SummariesofTransactionsCalculation> summariesofTransactionsCalculation;
	
	public String getDueFromBorrowerAtClosingTotalAmount() {
		return dueFromBorrowerAtClosingTotalAmount;
	}
	public void setDueFromBorrowerAtClosingTotalAmount(String dueFromBorrowerAtClosingTotalAmount) {
		this.dueFromBorrowerAtClosingTotalAmount = dueFromBorrowerAtClosingTotalAmount;
	}
	public String getPaidAlreadybyoronBehalfofBorroweratClosing() {
		return paidAlreadybyoronBehalfofBorroweratClosing;
	}
	public void setPaidAlreadybyoronBehalfofBorroweratClosing(String paidAlreadybyoronBehalfofBorroweratClosing) {
		this.paidAlreadybyoronBehalfofBorroweratClosing = paidAlreadybyoronBehalfofBorroweratClosing;
	}
	public SummariesofTransactionsDetailsDueFromBorrowerAtClosing getDuefromBorroweratClosing() {
		return duefromBorroweratClosing;
	}
	public void setDuefromBorroweratClosing(
			SummariesofTransactionsDetailsDueFromBorrowerAtClosing duefromBorroweratClosing) {
		this.duefromBorroweratClosing = duefromBorroweratClosing;
	}
	public List<SummariesofTransactionsCalculation> getSummariesofTransactionsCalculation() {
		return summariesofTransactionsCalculation;
	}
	public void setSummariesofTransactionsCalculation(
			List<SummariesofTransactionsCalculation> summariesofTransactionsCalculation) {
		this.summariesofTransactionsCalculation = summariesofTransactionsCalculation;
	}
	public SummariesofTransactionsDetailsPaidAlreadyby getPaidAlreadyby() {
		return paidAlreadyby;
	}
	public void setPaidAlreadyby(SummariesofTransactionsDetailsPaidAlreadyby paidAlreadyby) {
		this.paidAlreadyby = paidAlreadyby;
	}
	
	
	
}
