package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

public class TransactionInformation implements Serializable {
	
	private static final long serialVersionUID = 2048295015514864504L;
	
	private List<Borrower> borrower;
	private List<Seller> seller;
	private List<Lender> lender;	
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
	public List<Seller> getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(List<Seller> seller) {
		this.seller = seller;
	}
	/**
	 * @return the lender
	 */
	public List<Lender> getLender() {
		return lender;
	}
	/**
	 * @param lender the lender to set
	 */
	public void setLender(List<Lender> lender) {
		this.lender = lender;
	}
	
	
	
	
}
