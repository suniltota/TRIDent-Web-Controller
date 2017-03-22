package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class LoanInformationLoanIdentifier implements Serializable{

	private static final long serialVersionUID = -5623308632774423007L;
	
	private String loanIdentifierType;
	private String loanIdentifier;
	
	public String getLoanIdentifierType() {
		return loanIdentifierType;
	}
	public void setLoanIdentifierType(String loanIdentifierType) {
		this.loanIdentifierType = loanIdentifierType;
	}
	public String getLoanIdentifier() {
		return loanIdentifier;
	}
	public void setLoanIdentifier(String loanIdentifier) {
		this.loanIdentifier = loanIdentifier;
	}
	
	

}
