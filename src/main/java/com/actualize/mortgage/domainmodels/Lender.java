package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lender implements Serializable {
	
	
	private static final long serialVersionUID = 8480544187555095113L;
	
	private String type;
	@JsonProperty("lenderDetails")
	private NameModel nameModel;
	private String partyRoleType;
	private String partyRoleOtherDescription;
	private Address address;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public NameModel getNameModel() {
		return nameModel;
	}

	public void setNameModel(NameModel nameModel) {
		this.nameModel = nameModel;
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
		
	
}
