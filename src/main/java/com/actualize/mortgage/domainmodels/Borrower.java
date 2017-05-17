package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class Borrower implements Serializable {

	private static final long serialVersionUID = -6243514603739727710L;
	
	private String type;
	private NameModel nameModel;
	private String partyRoleType;
	private String partyRoleOtherDescription;
	private AddressModel addressModel;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the nameModel
	 */
	public NameModel getNameModel() {
		return nameModel;
	}
	/**
	 * @param nameModel the nameModel to set
	 */
	public void setNameModel(NameModel nameModel) {
		this.nameModel = nameModel;
	}
	/**
	 * @return the partyRoleType
	 */
	public String getPartyRoleType() {
		return partyRoleType;
	}
	/**
	 * @param partyRoleType the partyRoleType to set
	 */
	public void setPartyRoleType(String partyRoleType) {
		this.partyRoleType = partyRoleType;
	}
	/**
	 * @return the partyRoleOtherDescription
	 */
	public String getPartyRoleOtherDescription() {
		return partyRoleOtherDescription;
	}
	/**
	 * @param partyRoleOtherDescription the partyRoleOtherDescription to set
	 */
	public void setPartyRoleOtherDescription(String partyRoleOtherDescription) {
		this.partyRoleOtherDescription = partyRoleOtherDescription;
	}
	/**
	 * @return the address
	 */
	public AddressModel getAddress() {
		return addressModel;
	}
	/**
	 * @param addressModel the address to set
	 */
	public void setAddress(AddressModel addressModel) {
		this.addressModel = addressModel;
	}
		
	
}
