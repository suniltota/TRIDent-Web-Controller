/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.List;

/**
 * this class defines DueFromSellerAtClosing for SummariesofTransactions in JSON response
 * @author sboragala
 *
 */
public class SummariesofTransactionsDetailsDueFromSellerAtClosing implements Serializable{


	private static final long serialVersionUID = -3735613389375681749L;
	
	private ClosingCostFundModel excessDeposit;
	private IntegratedDisclosureSectionSummaryModel closingCostPaidAtClosing;
	private String existingLoan;
	private LiabilityModel payoffFirstMortgage;
	private LiabilityModel payOffSecondMortgage;
	private String sellerCredit;
	private List<LiabilityModel> dueFromSellerLiabilities;
	private List<ClosingAdjustmentItemModel> dueFromSellerAdjustments;
	private List<ProrationModel> dueFromSellerAdjustmentsUnPaidBySeller;
	private IntegratedDisclosureSectionSummaryModel dueFromSellerTotalAmount;
	
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
	 * @return the closingCostPaidAtClosing
	 */
	public IntegratedDisclosureSectionSummaryModel getClosingCostPaidAtClosing() {
		return closingCostPaidAtClosing;
	}
	/**
	 * @param closingCostPaidAtClosing the closingCostPaidAtClosing to set
	 */
	public void setClosingCostPaidAtClosing(IntegratedDisclosureSectionSummaryModel closingCostPaidAtClosing) {
		this.closingCostPaidAtClosing = closingCostPaidAtClosing;
	}
	/**
	 * @return the existingLoan
	 */
	public String getExistingLoan() {
		return existingLoan;
	}
	/**
	 * @param existingLoan the existingLoan to set
	 */
	public void setExistingLoan(String existingLoan) {
		this.existingLoan = existingLoan;
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
	/**
	 * @return the dueFromSellerLiabilities
	 */
	public List<LiabilityModel> getDueFromSellerLiabilities() {
		return dueFromSellerLiabilities;
	}
	/**
	 * @param dueFromSellerLiabilities the dueFromSellerLiabilities to set
	 */
	public void setDueFromSellerLiabilities(List<LiabilityModel> dueFromSellerLiabilities) {
		this.dueFromSellerLiabilities = dueFromSellerLiabilities;
	}
	/**
	 * @return the sellerCredit
	 */
	public String getSellerCredit() {
		return sellerCredit;
	}
	/**
	 * @param sellerCredit the sellerCredit to set
	 */
	public void setSellerCredit(String sellerCredit) {
		this.sellerCredit = sellerCredit;
	}
	/**
	 * @return the dueFromSellerAdjustments
	 */
	public List<ClosingAdjustmentItemModel> getDueFromSellerAdjustments() {
		return dueFromSellerAdjustments;
	}
	/**
	 * @param dueFromSellerAdjustments the dueFromSellerAdjustments to set
	 */
	public void setDueFromSellerAdjustments(List<ClosingAdjustmentItemModel> dueFromSellerAdjustments) {
		this.dueFromSellerAdjustments = dueFromSellerAdjustments;
	}
	/**
	 * @return the dueFromSellerAdjustmentsUnPaidBySeller
	 */
	public List<ProrationModel> getDueFromSellerAdjustmentsUnPaidBySeller() {
		return dueFromSellerAdjustmentsUnPaidBySeller;
	}
	/**
	 * @param dueFromSellerAdjustmentsUnPaidBySeller the dueFromSellerAdjustmentsUnPaidBySeller to set
	 */
	public void setDueFromSellerAdjustmentsUnPaidBySeller(List<ProrationModel> dueFromSellerAdjustmentsUnPaidBySeller) {
		this.dueFromSellerAdjustmentsUnPaidBySeller = dueFromSellerAdjustmentsUnPaidBySeller;
	}
	/**
	 * @return the dueFromSellerTotalAmount
	 */
	public IntegratedDisclosureSectionSummaryModel getDueFromSellerTotalAmount() {
		return dueFromSellerTotalAmount;
	}
	/**
	 * @param dueFromSellerTotalAmount the dueFromSellerTotalAmount to set
	 */
	public void setDueFromSellerTotalAmount(IntegratedDisclosureSectionSummaryModel dueFromSellerTotalAmount) {
		this.dueFromSellerTotalAmount = dueFromSellerTotalAmount;
	}
	
}
