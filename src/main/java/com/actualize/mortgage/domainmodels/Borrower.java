package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class Borrower implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6243514603739727710L;
	
	private String borrowerFullName;
	private Address address;
	
	/**
	 * @return the borrowerFullName
	 */
	public String getBorrowerFullName() {
		return borrowerFullName;
	}
	/**
	 * @param borrowerFullName the borrowerFullName to set
	 */
	public void setBorrowerFullName(String borrowerFullName) {
		this.borrowerFullName = borrowerFullName;
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
