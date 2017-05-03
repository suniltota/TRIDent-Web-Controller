package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author sboragala
 *
 */
public class TransactionInformation implements Serializable {
	
	private static final long serialVersionUID = 2048295015514864504L;
	
	private String refinanceSameLender;
	@JsonProperty(value="borrowerDetails")
	private List<Borrower> borrower;
	@JsonProperty(value="sellerDetails")
	private List<Borrower> seller;
	@JsonProperty(value="lenderDetails")
	private List<Borrower> lender;
	
	/**
	 * @return the refinanceSameLender
	 */
	public String getRefinanceSameLender() {
		return refinanceSameLender;
	}
	/**
	 * @param refinanceSameLender the refinanceSameLender to set
	 */
	public void setRefinanceSameLender(String refinanceSameLender) {
		this.refinanceSameLender = refinanceSameLender;
	}
	/**
	 * @return the borrower
	 */
	public List<Borrower> getBorrower() {
		return borrower;
	}
	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(List<Borrower> borrower) {
		this.borrower = borrower;
	}
	/**
	 * @return the seller
	 */
	public List<Borrower> getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(List<Borrower> seller) {
		this.seller = seller;
	}
	/**
	 * @return the lender
	 */
	public List<Borrower> getLender() {
		return lender;
	}
	/**
	 * @param lender the lender to set
	 */
	public void setLender(List<Borrower> lender) {
		this.lender = lender;
	}
	
	
	

}
