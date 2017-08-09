/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author sboragala
 *
 */
@Entity
@Table(name="client_contact_info")
public class ClientContactInfoEntity implements Serializable {

	private static final long serialVersionUID = -8883837225210015943L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String contactInfoId;
	private String contactType;
	private String name;
	private String email;
	private String phone;
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="clientId")
	private ClientEntity clientId;
	private Timestamp creationDate;
	private Timestamp modificationDate;
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
	 * @return the clientId
	 */
	public ClientEntity getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(ClientEntity clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the creationDate
	 */
	public Timestamp getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the modificationDate
	 */
	public Timestamp getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}

}
