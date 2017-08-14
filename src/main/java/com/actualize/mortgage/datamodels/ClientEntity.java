/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author sboragala
 *
 */
@Entity
@Table(name="client")
public class ClientEntity implements Serializable {

	private static final long serialVersionUID = -7857213242827507858L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String clientId;
	private String clientName;
	private String address;
	@Column(name="isEnabled")
	private boolean enabled; 
	private String phoneNumber;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="client_client_contact_info", joinColumns= @JoinColumn(name= "client_id"),
	inverseJoinColumns = @JoinColumn(name="contact_info_id"))
	private List<ClientContactInfoEntity> clientContactInfo;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="client_services", joinColumns= @JoinColumn(name= "client_id"),
	inverseJoinColumns = @JoinColumn(name="service_id"))
	private Set<ServicesEntity> servicesEntities;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="client_investor_users", joinColumns= @JoinColumn(name= "client_id"),
	inverseJoinColumns = @JoinColumn(name="investor_user_id"))
	private List<InvestorUserDetailsEntity> investorUserDetailsEntity;
	@Column(name="creationDate", insertable=false, updatable=false)
	private Timestamp creationDate;
	@Column(name="modificationDate", insertable=false, updatable=false)
	private Timestamp modificationDate;
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
	public List<ClientContactInfoEntity> getClientContactInfo() {
		return clientContactInfo;
	}
	/**
	 * @param clientContactInfo the clientContactInfo to set
	 */
	public void setClientContactInfo(List<ClientContactInfoEntity> clientContactInfo) {
		this.clientContactInfo = clientContactInfo;
	}
	/**
	 * @return the servicesEntities
	 */
	public Set<ServicesEntity> getServicesEntities() {
		return servicesEntities;
	}
	/**
	 * @param servicesEntities the servicesEntities to set
	 */
	public void setServicesEntities(Set<ServicesEntity> servicesEntities) {
		this.servicesEntities = servicesEntities;
	}
	/**
	 * @return the investorUserDetailsEntity
	 */
	public List<InvestorUserDetailsEntity> getInvestorUserDetailsEntity() {
		return investorUserDetailsEntity;
	}
	/**
	 * @param investorUserDetailsEntity the investorUserDetailsEntity to set
	 */
	public void setInvestorUserDetailsEntity(List<InvestorUserDetailsEntity> investorUserDetailsEntity) {
		this.investorUserDetailsEntity = investorUserDetailsEntity;
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
