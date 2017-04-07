package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class SummariesofTransactionsDetailsDueFromBorrowerAtClosing implements Serializable{
	

	private static final long serialVersionUID = -7422950890798131710L;

	private List<SummariesofTransactionsDetails> duefromBorrowerList;
	private List<SummariesofTransactionsDetails> adjustmentsList;
	private List<SummariesofTransactionsDetails> adjustmentsforItemsList;
	
	public List<SummariesofTransactionsDetails> getDuefromBorrowerList() {
		return duefromBorrowerList;
	}
	public void setDuefromBorrowerList(List<SummariesofTransactionsDetails> duefromBorrowerList) {
		this.duefromBorrowerList = duefromBorrowerList;
	}
	public List<SummariesofTransactionsDetails> getAdjustmentsList() {
		return adjustmentsList;
	}
	public void setAdjustmentsList(List<SummariesofTransactionsDetails> adjustmentsList) {
		this.adjustmentsList = adjustmentsList;
	}
	public List<SummariesofTransactionsDetails> getAdjustmentsforItemsList() {
		return adjustmentsforItemsList;
	}
	public void setAdjustmentsforItemsList(List<SummariesofTransactionsDetails> adjustmentsforItemsList) {
		this.adjustmentsforItemsList = adjustmentsforItemsList;
	}
	
}
