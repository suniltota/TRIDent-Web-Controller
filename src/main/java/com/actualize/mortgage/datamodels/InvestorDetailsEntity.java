/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author sboragala
 *
 */
public class InvestorDetailsEntity implements Serializable {
	
	private static final long serialVersionUID = 8774727571980748276L;
	
	@Column(name="investor_id")
	private String investorUserId;
	@Column(name="investor_id")
	private String loanDeliveryFile;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="investor_id", insertable=false, updatable=false)
	private InvestorEntity investorEntity;
	@Column(name="creation_date")
	private Timestamp creationDate;
	@Column(name="modification_date")
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
