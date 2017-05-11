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
	private SummariesofTransactionsDetailsPaidByAlready paidAlreadyby; 
	
	
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
	public SummariesofTransactionsDetailsPaidByAlready getPaidAlreadyby() {
		return paidAlreadyby;
	}
	public void setPaidAlreadyby(SummariesofTransactionsDetailsPaidByAlready paidAlreadyby) {
		this.paidAlreadyby = paidAlreadyby;
	}
	
	
	
}
