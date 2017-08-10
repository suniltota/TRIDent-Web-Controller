/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class InvestorModel implements Serializable {
	
	private static final long serialVersionUID = -7104104259306223922L;
	
	private String investorId;
	private String investorName;
	private String investorUrl;
	private String creationDate;
	private String modificationDate;
	
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
