/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines ContactPoints while creating XML from JSON Object 
 * @author sboragala
 *
 */
public class MismoContactPointsModel implements Serializable {
	
	private static final long serialVersionUID = 6496539290453436383L;
	
	private String email = "";
	private String phone = "";
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
