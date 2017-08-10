/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * defines user details table structure on database 
 * @author sboragala
 *
 */
@Entity
@Table(name="groups")
public class GroupEntity implements Serializable {
	

	private static final long serialVersionUID = -1637974905981684170L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "group_id")
	private String groupId;
	
	@Column(name = "group_name")
	private String groupName;
	
	@Column(name = "parent_group_id")
	private String parentGroupId;
	
	@Column(name = "group_sequence")
	private long groupSequence;
	
	@Column(name = "group_path")
	private String groupPath;
	
/*	@ManyToOne
	@JoinColumn(name="clientid")
	private ClientEntity client;*/
	private String clientid;
	
	private String updatedBy;
	
	private Date modificationDate;
	
	private Date creationDate;
	
	private boolean enabled;
	
	@Column(name = "session_time_out")
	private long sessionTimeOut;
	
	@Column(name = "password_days")
	private long passwordExpireDays;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinTable(
            name = "group_services",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
	private Set<ServicesEntity> services;
	
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
	 * @return the parentGroup
	 */
	public String getParentGroupId() {
		return parentGroupId;
	}

	/**
	 * @param parentGroup the parentGroup to set
	 */
	public void setParentGroupId(String parentGroup) {
		this.parentGroupId = parentGroup;
	}

	/**
	 * @return the groupSequence
	 */
	public long getGroupSequence() {
		return groupSequence;
	}

	/**
	 * @param groupSequence the groupSequence to set
	 */
	public void setGroupSequence(long groupSequence) {
		this.groupSequence = groupSequence;
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
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the clientid
	 */
	public String getClientid() {
		return clientid;
	}

	/**
	 * @param clientid the clientid to set
	 */
	public void setClientid(String clientid) {
		this.clientid = clientid;
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
	 * @return the services
	 */
	public Set<ServicesEntity> getServices() {
		return services;
	}

	/**
	 * @param services the services to set
	 */
	public void setServices(Set<ServicesEntity> services) {
		this.services = services;
	}

}
