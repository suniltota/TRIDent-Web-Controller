package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Borrower implements Serializable {

	private static final long serialVersionUID = -6243514603739727710L;
	
	private String borrowerFullName;
	@JsonProperty("borrowerDetails")
	private NameModel name;
	private String partyRoleType;
	private String partyRoleOtherDescription;
	private Address address;
	
	
	public String getBorrowerFullName() {
		return borrowerFullName;
	}
	
	public void setBorrowerFullName(String borrowerFullName) {
		this.borrowerFullName = borrowerFullName;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPartyRoleType() {
		return partyRoleType;
	}
	
	public void setPartyRoleType(String partyRoleType) {
		this.partyRoleType = partyRoleType;
	}
	
	public String getPartyRoleOtherDescription() {
		return partyRoleOtherDescription;
	}
	public void setPartyRoleOtherDescription(String partyRoleOtherDescription) {
		this.partyRoleOtherDescription = partyRoleOtherDescription;
	}

	public NameModel getName() {
		return name;
	}

	public void setName(NameModel name) {
		this.name = name;
	}
	
	
}
