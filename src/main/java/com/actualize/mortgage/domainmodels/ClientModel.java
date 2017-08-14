/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

/**
 * @author sboragala
 *
 */
public class ClientModel implements Serializable {
	
	private static final long serialVersionUID = 4813925494221483774L;
	
	private String clientId;
	private String clientName;
	private String address;
	private boolean enabled;
	private String phoneNumber;
	private List<ClientContactInfoModel> clientContactInfo;
	private List<ServicesModel> servicesModel;
	private List<InvestorUserDetailsModel> investorUserDetailsModel;
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
		return enabled;
	}
	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.enabled = isEnabled;
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
	 * @return the servicesModel
	 */
	public List<ServicesModel> getServicesModel() {
		return servicesModel;
	}
	/**
	 * @param servicesModel the servicesModel to set
	 */
	public void setServicesModel(List<ServicesModel> servicesModel) {
		this.servicesModel = servicesModel;
	}
	/**
	 * @return the investorUserDetailsModel
	 */
	public List<InvestorUserDetailsModel> getInvestorUserDetailsModel() {
		return investorUserDetailsModel;
	}
	/**
	 * @param investorUserDetailsModel the investorUserDetailsModel to set
	 */
	public void setInvestorUserDetailsModel(List<InvestorUserDetailsModel> investorUserDetailsModel) {
		this.investorUserDetailsModel = investorUserDetailsModel;
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
