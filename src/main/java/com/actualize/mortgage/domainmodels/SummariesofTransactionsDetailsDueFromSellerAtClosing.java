/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines DueFromSellerAtClosing for SummariesofTransactions in JSON response
 * @author sboragala
 *
 */
public class SummariesofTransactionsDetailsDueFromSellerAtClosing implements Serializable{


	private static final long serialVersionUID = -3735613389375681749L;
	
	private ClosingCostFundModel excessDeposit = new ClosingCostFundModel();
	private LiabilityModel payoffFirstMortgage = new LiabilityModel();
	private LiabilityModel payOffSecondMortgage = new LiabilityModel();
	
	/**
	 * @return the excessDeposit
	 */
	public ClosingCostFundModel getExcessDeposit() {
		return excessDeposit;
	}
	/**
	 * @param excessDeposit the excessDeposit to set
	 */
	public void setExcessDeposit(ClosingCostFundModel excessDeposit) {
		this.excessDeposit = excessDeposit;
	}
	/**
	 * @return the payoffFirstMortgage
	 */
	public LiabilityModel getPayoffFirstMortgage() {
		return payoffFirstMortgage;
	}
	/**
	 * @param payoffFirstMortgage the payoffFirstMortgage to set
	 */
	public void setPayoffFirstMortgage(LiabilityModel payoffFirstMortgage) {
		this.payoffFirstMortgage = payoffFirstMortgage;
	}
	/**
	 * @return the payOffSecondMortgage
	 */
	public LiabilityModel getPayOffSecondMortgage() {
		return payOffSecondMortgage;
	}
	/**
	 * @param payOffSecondMortgage the payOffSecondMortgage to set
	 */
	public void setPayOffSecondMortgage(LiabilityModel payOffSecondMortgage) {
		this.payOffSecondMortgage = payOffSecondMortgage;
	}

}
