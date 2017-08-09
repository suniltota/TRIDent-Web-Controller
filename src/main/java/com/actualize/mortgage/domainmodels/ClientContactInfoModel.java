/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class ClientContactInfoModel implements Serializable {

	private static final long serialVersionUID = 8882947611344579769L;
	private String contactInfoId;
	private String contactType;
	private String name;
	private String email;
	private String phone;
	private ClientModel client;
	private String creationDate;
	private String modificationDate;

	/**
	 * @return the contactInfoId
	 */
	public String getContactInfoId() {
		return contactInfoId;
	}
	/**
	 * @param contactInfoId the contactInfoId to set
	 */
	public void setContactInfoId(String contactInfoId) {
		this.contactInfoId = contactInfoId;
	}
	/**
	 * @return the contactType
	 */
	public String getContactType() {
		return contactType;
	}
	/**
	 * @param contactType the contactType to set
	 */
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
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
	/**
	 * @return the client
	 */
	public ClientModel getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(ClientModel client) {
		this.client = client;
	}
	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the modificationDate
	 */
	public String getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}


}
