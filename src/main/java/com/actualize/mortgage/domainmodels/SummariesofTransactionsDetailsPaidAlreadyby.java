package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class SummariesofTransactionsDetailsPaidAlreadyby implements Serializable{
	
	
	private static final long serialVersionUID = -5690104701135903828L;
	
	private List<SummariesofTransactionsDetails> paidAlreadyby;
	private List<SummariesofTransactionsDetails> otherCredits;
	private List<SummariesofTransactionsDetails> adjustments;
	private List<SummariesofTransactionsDetails> adjustmentsforItems;
	
	public List<SummariesofTransactionsDetails> getPaidAlreadyby() {
		return paidAlreadyby;
	}
	public void setPaidAlreadyby(List<SummariesofTransactionsDetails> paidAlreadyby) {
		this.paidAlreadyby = paidAlreadyby;
	}
	public List<SummariesofTransactionsDetails> getOtherCredits() {
		return otherCredits;
	}
	public void setOtherCredits(List<SummariesofTransactionsDetails> otherCredits) {
		this.otherCredits = otherCredits;
	}
	public List<SummariesofTransactionsDetails> getAdjustments() {
		return adjustments;
	}
	public void setAdjustments(List<SummariesofTransactionsDetails> adjustments) {
		this.adjustments = adjustments;
	}
	public List<SummariesofTransactionsDetails> getAdjustmentsforItems() {
		return adjustmentsforItems;
	}
	public void setAdjustmentsforItems(List<SummariesofTransactionsDetails> adjustmentsforItems) {
		this.adjustmentsforItems = adjustmentsforItems;
	}
	
}
