package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class NameModel implements Serializable{

	private static final long serialVersionUID = -2947131579922774607L;

	private String firstName = "";
	private String lastName = "";
	private String middleName = "";
	private String suffixName = "";
	private String fullName = "";
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the suffixName
	 */
	public String getSuffixName() {
		return suffixName;
	}
	/**
	 * @param suffixName the suffixName to set
	 */
	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
