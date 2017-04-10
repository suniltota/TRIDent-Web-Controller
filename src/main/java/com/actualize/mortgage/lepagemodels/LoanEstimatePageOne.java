package com.actualize.mortgage.lepagemodels;

import java.io.Serializable;

/**
 * This Model defines all the sections of Page One in LE 
 * @author sboragala
 *
 */
public class LoanEstimatePageOne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7446907971982623457L;
	
	private LoanEstimateSection loanEstimateSection;

	/**
	 * @return the loanEstimateSection
	 */
	public LoanEstimateSection getLoanEstimateSection() {
		return loanEstimateSection;
	}

	/**
	 * @param loanEstimateSection the loanEstimateSection to set
	 */
	public void setLoanEstimateSection(LoanEstimateSection loanEstimateSection) {
		this.loanEstimateSection = loanEstimateSection;
	}
	
}
