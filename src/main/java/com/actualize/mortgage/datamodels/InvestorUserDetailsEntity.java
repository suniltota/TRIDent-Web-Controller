/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="investor_user_details")
public class InvestorUserDetailsEntity implements Serializable {
	
	private static final long serialVersionUID = 8774727571980748276L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="investor_user_id")
	private String investorUserId;
	
	@Column(name="loan_delivery_file", nullable= false)
	private String loanDeliveryFile;
	
	@Column(name="username", nullable= false)
	private String username;
	
	@Column(name="password", nullable= false)
	private String password;
	
	/*@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="investor_users_investor", joinColumns= @JoinColumn(name= "investor_user_id"),
	inverseJoinColumns = @JoinColumn(name="investor_id"))*/
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "investor_id", updatable = false, insertable = false, nullable= false)
	private InvestorEntity investorEntity;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "client_id", updatable = false, insertable = false, nullable= false)
	private ClientEntity client;
	
	@Column(name = "creation_date", insertable = false, updatable = false, nullable= false)
	private Timestamp creationDate;
	
	@Column(name="modification_date", insertable=false, updatable=false, nullable= false)
	private Timestamp modificationDate;
	
	/**
	 * @return the investorUserId
	 */
	public String getInvestorUserId() {
		return investorUserId;
	}
	/**
	 * @param investorUserId the investorUserId to set
	 */
	public void setInvestorUserId(String investorUserId) {
		this.investorUserId = investorUserId;
	}
	/**
	 * @return the loanDeliveryFile
	 */
	public String getLoanDeliveryFile() {
		return loanDeliveryFile;
	}
	/**
	 * @param loanDeliveryFile the loanDeliveryFile to set
	 */
	public void setLoanDeliveryFile(String loanDeliveryFile) {
		this.loanDeliveryFile = loanDeliveryFile;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the investorEntity
	 */
	public InvestorEntity getInvestorEntity() {
		return investorEntity;
	}
	/**
	 * @param investorEntity the investorEntity to set
	 */
	public void setInvestorEntity(InvestorEntity investorEntity) {
		this.investorEntity = investorEntity;
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
