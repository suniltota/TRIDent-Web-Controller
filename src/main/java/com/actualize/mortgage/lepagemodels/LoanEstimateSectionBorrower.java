package com.actualize.mortgage.lepagemodels;

import java.io.Serializable;

import com.actualize.mortgage.domainmodels.AddressModel;
import com.actualize.mortgage.domainmodels.NameModel;
/**
 * Defines borrower details in JSON response for LoanEstimateSection in Page One of LE 
 * @author sboragala
 *
 */
public class LoanEstimateSectionBorrower implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1616508858110951273L;
	
	private NameModel name;
	private AddressModel addressModel;
	
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
	 * @return the address
	 */
	public AddressModel getAddress() {
		return addressModel;
	}
	/**
	 * @param addressModel the address to set
	 */
	public void setAddress(AddressModel addressModel) {
		this.addressModel = addressModel;
	}
	
}
