package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class Lender implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8480544187555095113L;
	
	private String lenderFullName;
	private Address address;
	
	/**
	 * @return the lenderFullName
	 */
	public String getLenderFullName() {
		return lenderFullName;
	}
	/**
	 * @param lenderFullName the lenderFullName to set
	 */
	public void setLenderFullName(String lenderFullName) {
		this.lenderFullName = lenderFullName;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
		
	
}
