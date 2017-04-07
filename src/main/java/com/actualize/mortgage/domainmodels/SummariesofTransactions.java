package com.actualize.mortgage.domainmodels;

public class SummariesofTransactions {
	
	private SummariesofTransactionsBorrowerSection borrowerSection;
	private SummariesofTransactionsSellerSection sellerSection;
	
	public SummariesofTransactionsBorrowerSection getBorrowerSection() {
		return borrowerSection;
	}
	public void setBorrowerSection(SummariesofTransactionsBorrowerSection borrowerSection) {
		this.borrowerSection = borrowerSection;
	}
	public SummariesofTransactionsSellerSection getSellerSection() {
		return sellerSection;
	}
	public void setSellerSection(SummariesofTransactionsSellerSection sellerSection) {
		this.sellerSection = sellerSection;
	}
	
	
	 
}
