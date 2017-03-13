package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class Seller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7085207535329224318L;
	
	private String sellerFullName;
	private Address address;
	
	/**
	 * @return the sellerFullName
	 */
	public String getSellerFullName() {
		return sellerFullName;
	}
	/**
	 * @param sellerFullName the sellerFullName to set
	 */
	public void setSellerFullName(String sellerFullName) {
		this.sellerFullName = sellerFullName;
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
