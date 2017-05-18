package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
/**
 * this class defines Address in JSON response
 * @author sboragala
 *
 */
public class AddressModel implements Serializable {

	private static final long serialVersionUID = 554440887940185066L;
	private String addressLineText = "";
	private String addressType = "";
	private String addressUnitDesignatorType = "";
	private String addressUnitIdentifier = "";
	private String cityName = "";
	private String countryCode = "";
	private String postalCode = "";
	private String stateCode = "";
	private String unparsedLegalDescription = "";
	private boolean isLegalDescription = false;
	
	/**
	 * @return the addressLineText
	 */
	public String getAddressLineText() {
		return addressLineText;
	}
	/**
	 * @param addressLineText the addressLineText to set
	 */
	public void setAddressLineText(String addressLineText) {
		this.addressLineText = addressLineText;
	}
	/**
	 * @return the addressType
	 */
	public String getAddressType() {
		return addressType;
	}
	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	/**
	 * @return the addressUnitDesignatorType
	 */
	public String getAddressUnitDesignatorType() {
		return addressUnitDesignatorType;
	}
	/**
	 * @param addressUnitDesignatorType the addressUnitDesignatorType to set
	 */
	public void setAddressUnitDesignatorType(String addressUnitDesignatorType) {
		this.addressUnitDesignatorType = addressUnitDesignatorType;
	}
	/**
	 * @return the addressUnitIdentifier
	 */
	public String getAddressUnitIdentifier() {
		return addressUnitIdentifier;
	}
	/**
	 * @param addressUnitIdentifier the addressUnitIdentifier to set
	 */
	public void setAddressUnitIdentifier(String addressUnitIdentifier) {
		this.addressUnitIdentifier = addressUnitIdentifier;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}
	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * @return the unparsedLegalDescription
	 */
	public String getUnparsedLegalDescription() {
		return unparsedLegalDescription;
	}
	/**
	 * @param unparsedLegalDescription the unparsedLegalDescription to set
	 */
	public void setUnparsedLegalDescription(String unparsedLegalDescription) {
		this.unparsedLegalDescription = unparsedLegalDescription;
	}
	/**
	 * @return the isLegalDescription
	 */
	public boolean isLegalDescription() {
		return isLegalDescription;
	}
	/**
	 * @param isLegalDescription the isLegalDescription to set
	 */
	public void setLegalDescription(boolean isLegalDescription) {
		this.isLegalDescription = isLegalDescription;
	}
	
	
	
}
