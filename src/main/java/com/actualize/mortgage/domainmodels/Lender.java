package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lender implements Serializable {
	
	
	private static final long serialVersionUID = 8480544187555095113L;
	
	private String lenderFullName;
	@JsonProperty("lenderDetails")
	private NameModel nameModel;
	private String partyRoleType;
	private String partyRoleOtherDescription;
	private Address address;
	
	public String getLenderFullName() {
		return lenderFullName;
	}
	
	public void setLenderFullName(String lenderFullName) {
		this.lenderFullName = lenderFullName;
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
