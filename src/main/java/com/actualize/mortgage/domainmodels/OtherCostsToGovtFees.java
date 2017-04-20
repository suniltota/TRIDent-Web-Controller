package com.actualize.mortgage.domainmodels;

/**
 * Defines ToGovtFees in Othercosts of Page Two in CD for UI Response
 * @author sboragala
 *
 */
public class OtherCostsToGovtFees extends ClosingCostProperties{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3838593012086916344L;
	
	private String deedAmt;
	private String mrtgAmt;
	
	/**
	 * @return the deedAmt
	 */
	public String getDeedAmt() {
		return deedAmt;
	}
	/**
	 * @param deedAmt the deedAmt to set
	 */
	public void setDeedAmt(String deedAmt) {
		this.deedAmt = deedAmt;
	}
	/**
	 * @return the mrtgAmt
	 */
	public String getMrtgAmt() {
		return mrtgAmt;
	}
	/**
	 * @param mrtgAmt the mrtgAmt to set
	 */
	public void setMrtgAmt(String mrtgAmt) {
		this.mrtgAmt = mrtgAmt;
	}
	
	
}
