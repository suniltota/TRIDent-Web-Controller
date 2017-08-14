/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class InvestorUserDetailsModel implements Serializable {


	private static final long serialVersionUID = -413227409998901777L;

	private String investorUserId;

	private String loanDeliveryFile;

	private String username;

	private String password;

	private InvestorModel investorModel;
	
	private ClientModel client;

	private String creationDate;

	private String modificationDate;

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
	 * @return the investorModel
	 */
	public InvestorModel getInvestorModel() {
		return investorModel;
	}

	/**
	 * @param investorModel the investorModel to set
	 */
	public void setInvestorModel(InvestorModel investorModel) {
		this.investorModel = investorModel;
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
