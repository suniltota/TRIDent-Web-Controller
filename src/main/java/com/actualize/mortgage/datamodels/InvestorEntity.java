/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author sboragala
 *
 */
@Entity
@Table(name="investor_types")
public class InvestorEntity implements Serializable{

	private static final long serialVersionUID = 210558328053899119L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="investor_id")
	private String investorId;
	@Column(name="investor_name")
	private String investorName;
	@Column(name="investor_url")
	private String investorUrl;
	@Column(name="creation_date", insertable=false, updatable=false)
	private Timestamp creationDate;
	@Column(name="modification_date", insertable=false, updatable=false)
	private Timestamp modificationDate;

	/**
	 * @return the investorId
	 */
	public String getInvestorId() {
		return investorId;
	}
	/**
	 * @param investorId the investorId to set
	 */
	public void setInvestorId(String investorId) {
		this.investorId = investorId;
	}
	/**
	 * @return the investorName
	 */
	public String getInvestorName() {
		return investorName;
	}
	/**
	 * @param investorName the investorName to set
	 */
	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}
	/**
	 * @return the investorUrl
	 */
	public String getInvestorUrl() {
		return investorUrl;
	}
	/**
	 * @param investorUrl the investorUrl to set
	 */
	public void setInvestorUrl(String investorUrl) {
		this.investorUrl = investorUrl;
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
