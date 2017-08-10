package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class GroupModel implements Serializable {

	private String groupId;
	private String groupName;
	private String groupSequence;
	private String groupParentId;
	private String groupPath;
	private String updatedBy;
	private String clientId;
	private boolean enabled;
	private long sessionTimeOut;
	private long passwordExpireDays;
	private String parentGroupName;
	private String serviceDisplayNames;
	private List<ServicesModel> services;
	
	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return the groupSequence
	 */
	public String getGroupSequence() {
		return groupSequence;
	}
	/**
	 * @param groupSequence the groupSequence to set
	 */
	public void setGroupSequence(String groupSequence) {
		this.groupSequence = groupSequence;
	}
	/**
	 * @return the groupParentId
	 */
	public String getGroupParentId() {
		return groupParentId;
	}
	/**
	 * @param groupParentId the groupParentId to set
	 */
	public void setGroupParentId(String groupParentId) {
		this.groupParentId = groupParentId;
	}
	/**
	 * @return the groupPath
	 */
	public String getGroupPath() {
		return groupPath;
	}
	/**
	 * @param groupPath the groupPath to set
	 */
	public void setGroupPath(String groupPath) {
		this.groupPath = groupPath;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
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
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return the sessionTimeOut
	 */
	public long getSessionTimeOut() {
		return sessionTimeOut;
	}
	/**
	 * @param sessionTimeOut the sessionTimeOut to set
	 */
	public void setSessionTimeOut(long sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}
	/**
	 * @return the passwordDays
	 */
	public long getPasswordExpireDays() {
		return passwordExpireDays;
	}
	/**
	 * @param passwordDays the passwordDays to set
	 */
	public void setPasswordExpireDays(long passwordDays) {
		this.passwordExpireDays = passwordDays;
	}

	
	/**
	 * @return the groupServices
	 */
	public List<ServicesModel> getServices() {
		return services;
	}
	/**
	 * @param groupServices the groupServices to set
	 */
	public void setServices(List<ServicesModel> services) {
		this.services = services;
	}
	/**
	 * @return the parentGroupName
	 */
	public String getParentGroupName() {
		return parentGroupName;
	}
	/**
	 * @param parentGroupName the parentGroupName to set
	 */
	public void setParentGroupName(String parentGroupName) {
		this.parentGroupName = parentGroupName;
	}
	/**
	 * @return the serviceDisplayNames
	 */
	public String getServiceDisplayNames() {
		return serviceDisplayNames;
	}
	/**
	 * @param serviceDisplayNames the serviceDisplayNames to set
	 */
	public void setServiceDisplayNames(String serviceDisplayNames) {
		this.serviceDisplayNames = serviceDisplayNames;
	}
	
}
