/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines MIDataDetail in JSON response
 * @author sboragala
 *
 */
public class MIDataDetailModel implements Serializable {

	private static final long serialVersionUID = -305279742510530074L;
	
	private String miCertificateIdentifier;
	private String miCompanyNameType;
	private String miCompanyNameTypeOtherDescription;
	private String miScheduledTerminationDate;
	private String miInitialPremiumAmount;
	
	/**
	 * @return the miCertificateIdentifier
	 */
	public String getMiCertificateIdentifier() {
		return miCertificateIdentifier;
	}
	/**
	 * @param miCertificateIdentifier the miCertificateIdentifier to set
	 */
	public void setMiCertificateIdentifier(String miCertificateIdentifier) {
		this.miCertificateIdentifier = miCertificateIdentifier;
	}
	/**
	 * @return the miCompanyNameType
	 */
	public String getMiCompanyNameType() {
		return miCompanyNameType;
	}
	/**
	 * @param miCompanyNameType the miCompanyNameType to set
	 */
	public void setMiCompanyNameType(String miCompanyNameType) {
		this.miCompanyNameType = miCompanyNameType;
	}
	/**
	 * @return the miCompanyNameTypeOtherDescription
	 */
	public String getMiCompanyNameTypeOtherDescription() {
		return miCompanyNameTypeOtherDescription;
	}
	/**
	 * @param miCompanyNameTypeOtherDescription the miCompanyNameTypeOtherDescription to set
	 */
	public void setMiCompanyNameTypeOtherDescription(String miCompanyNameTypeOtherDescription) {
		this.miCompanyNameTypeOtherDescription = miCompanyNameTypeOtherDescription;
	}
	/**
	 * @return the miScheduledTerminationDate
	 */
	public String getMiScheduledTerminationDate() {
		return miScheduledTerminationDate;
	}
	/**
	 * @param miScheduledTerminationDate the miScheduledTerminationDate to set
	 */
	public void setMiScheduledTerminationDate(String miScheduledTerminationDate) {
		this.miScheduledTerminationDate = miScheduledTerminationDate;
	}
	/**
	 * @return the miInitialPremiumAmount
	 */
	public String getMiInitialPremiumAmount() {
		return miInitialPremiumAmount;
	}
	/**
	 * @param miInitialPremiumAmount the miInitialPremiumAmount to set
	 */
	public void setMiInitialPremiumAmount(String miInitialPremiumAmount) {
		this.miInitialPremiumAmount = miInitialPremiumAmount;
	}
	
	
}
