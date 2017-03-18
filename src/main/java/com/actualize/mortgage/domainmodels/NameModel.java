package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class NameModel implements Serializable{

	private static final long serialVersionUID = 99840591485463395L;
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String suffixName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getSuffixName() {
		return suffixName;
	}
	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}
	
	 

}
