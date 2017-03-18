package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seller implements Serializable {

	private static final long serialVersionUID = 7085207535329224318L;
	
	private String sellerFullName;
	@JsonProperty("sellerDetails")
	private NameModel nameModel;
	private String partyRoleType;
	private String partyRoleOtherDescription;
	private Address address;

	public String getSellerFullName() {
		return sellerFullName;
	}
	
	public void setSellerFullName(String sellerFullName) {
		this.sellerFullName = sellerFullName;
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

	public NameModel getNameModel() {
		return nameModel;
	}

	public void setNameModel(NameModel nameModel) {
		this.nameModel = nameModel;
	}
	
	
}
