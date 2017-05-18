/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines 
 * @author sboragala
 *
 */
public class LicenseDetailModel implements Serializable {
	
	private static final long serialVersionUID = -6907090439453120366L;
	private String licenseAuthorityLevelType = "";
	private String licenseIdentifier = "";
	public String identifierOwnerURI = "";
	private String licenseIssueDate = "";
	private String licenseIssuingAuthorityName = "";
	private String licenseIssuingAuthorityStateCode = "";
	
	/**
	 * @return the licenseAuthorityLevelType
	 */
	public String getLicenseAuthorityLevelType() {
		return licenseAuthorityLevelType;
	}
	/**
	 * @param licenseAuthorityLevelType the licenseAuthorityLevelType to set
	 */
	public void setLicenseAuthorityLevelType(String licenseAuthorityLevelType) {
		this.licenseAuthorityLevelType = licenseAuthorityLevelType;
	}
	/**
	 * @return the licenseIdentifier
	 */
	public String getLicenseIdentifier() {
		return licenseIdentifier;
	}
	/**
	 * @param licenseIdentifier the licenseIdentifier to set
	 */
	public void setLicenseIdentifier(String licenseIdentifier) {
		this.licenseIdentifier = licenseIdentifier;
	}
	/**
	 * @return the identifierOwnerURI
	 */
	public String getIdentifierOwnerURI() {
		return identifierOwnerURI;
	}
	/**
	 * @param identifierOwnerURI the identifierOwnerURI to set
	 */
	public void setIdentifierOwnerURI(String identifierOwnerURI) {
		this.identifierOwnerURI = identifierOwnerURI;
	}
	/**
	 * @return the licenseIssueDate
	 */
	public String getLicenseIssueDate() {
		return licenseIssueDate;
	}
	/**
	 * @param licenseIssueDate the licenseIssueDate to set
	 */
	public void setLicenseIssueDate(String licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}
	/**
	 * @return the licenseIssuingAuthorityName
	 */
	public String getLicenseIssuingAuthorityName() {
		return licenseIssuingAuthorityName;
	}
	/**
	 * @param licenseIssuingAuthorityName the licenseIssuingAuthorityName to set
	 */
	public void setLicenseIssuingAuthorityName(String licenseIssuingAuthorityName) {
		this.licenseIssuingAuthorityName = licenseIssuingAuthorityName;
	}
	/**
	 * @return the licenseIssuingAuthorityStateCode
	 */
	public String getLicenseIssuingAuthorityStateCode() {
		return licenseIssuingAuthorityStateCode;
	}
	/**
	 * @param licenseIssuingAuthorityStateCode the licenseIssuingAuthorityStateCode to set
	 */
	public void setLicenseIssuingAuthorityStateCode(String licenseIssuingAuthorityStateCode) {
		this.licenseIssuingAuthorityStateCode = licenseIssuingAuthorityStateCode;
	}
	
	

}
