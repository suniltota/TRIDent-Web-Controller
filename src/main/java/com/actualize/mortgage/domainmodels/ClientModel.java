/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author sboragala
 *
 */
public class ClientModel implements Serializable {
	
	private static final long serialVersionUID = 4813925494221483774L;
	
	private String clientId;
	private String clientName;
	private String address;
	private boolean isEnabled;
	private String phoneNumber;
	private String passwordExpiryPolicy;
	private String contractEndDate;
	private String sessionTimeOut;
	private List<ClientContactInfoModel> clientContactInfo;
	private String creationDate;
	private String modificationDate;
	
	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the isEnabled
	 */
	public boolean isEnabled() {
		return isEnabled;
	}
	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the passwordExpiryPolicy
	 */
	public String getPasswordExpiryPolicy() {
		return passwordExpiryPolicy;
	}
	/**
	 * @param passwordExpiryPolicy the passwordExpiryPolicy to set
	 */
	public void setPasswordExpiryPolicy(String passwordExpiryPolicy) {
		this.passwordExpiryPolicy = passwordExpiryPolicy;
	}
	/**
	 * @return the contractEndDate
	 */
	public String getContractEndDate() {
		return contractEndDate;
	}
	/**
	 * @param contractEndDate the contractEndDate to set
	 */
	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	/**
	 * @return the sessionTimeOut
	 */
	public String getSessionTimeOut() {
		return sessionTimeOut;
	}
	/**
	 * @param sessionTimeOut the sessionTimeOut to set
	 */
	public void setSessionTimeOut(String sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}
	/**
	 * @return the clientContactInfo
	 */
	public List<ClientContactInfoModel> getClientContactInfo() {
		return clientContactInfo;
	}
	/**
	 * @param clientContactInfo the clientContactInfo to set
	 */
	public void setClientContactInfo(List<ClientContactInfoModel> clientContactInfo) {
		this.clientContactInfo = clientContactInfo;
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
