/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines ContactInformation properties in JSON response
 * @author sboragala
 *
 */
public class ContactInformationDetailModel implements Serializable {

	private static final long serialVersionUID = 5757669572320827341L;

	private String partyRoleType = "";
	private String organizationName = "";  
	private AddressModel address = new AddressModel();
	private LicenseDetailModel organizationLicenseDetail = new LicenseDetailModel();
	private NameModel name = new NameModel();
	private LicenseDetailModel individualLicenseDetail = new LicenseDetailModel();
	private String individualEmail = "";
	private String individualPhone = "";
	
	/**
	 * @return the partyRoleType
	 */
	public String getPartyRoleType() {
		return partyRoleType;
	}
	/**
	 * @param partyRoleType the partyRoleType to set
	 */
	public void setPartyRoleType(String partyRoleType) {
		this.partyRoleType = partyRoleType;
	}
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * @return the address
	 */
	public AddressModel getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressModel address) {
		this.address = address;
	}
	/**
	 * @return the organizationLicenseDetail
	 */
	public LicenseDetailModel getOrganizationLicenseDetail() {
		return organizationLicenseDetail;
	}
	/**
	 * @param organizationLicenseDetail the organizationLicenseDetail to set
	 */
	public void setOrganizationLicenseDetail(LicenseDetailModel organizationLicenseDetail) {
		this.organizationLicenseDetail = organizationLicenseDetail;
	}
	/**
	 * @return the name
	 */
	public NameModel getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(NameModel name) {
		this.name = name;
	}
	/**
	 * @return the individualLicenseDetail
	 */
	public LicenseDetailModel getIndividualLicenseDetail() {
		return individualLicenseDetail;
	}
	/**
	 * @param individualLicenseDetail the individualLicenseDetail to set
	 */
	public void setIndividualLicenseDetail(LicenseDetailModel individualLicenseDetail) {
		this.individualLicenseDetail = individualLicenseDetail;
	}
	/**
	 * @return the individualEmail
	 */
	public String getIndividualEmail() {
		return individualEmail;
	}
	/**
	 * @param individualEmail the individualEmail to set
	 */
	public void setIndividualEmail(String individualEmail) {
		this.individualEmail = individualEmail;
	}
	/**
	 * @return the individualPhone
	 */
	public String getIndividualPhone() {
		return individualPhone;
	}
	/**
	 * @param individualPhone the individualPhone to set
	 */
	public void setIndividualPhone(String individualPhone) {
		this.individualPhone = individualPhone;
	}
	
}
