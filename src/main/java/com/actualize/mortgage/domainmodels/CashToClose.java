package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
/**
 * this class defines cash to close  in JSON response
 * @author sboragala
 *
 */
public class CashToClose implements Serializable{

	private static final long serialVersionUID = 4357130776769001121L;
	
	private CashToCloseModel loanAmount = new CashToCloseModel();
	private CashToCloseModel totalClosingCosts = new CashToCloseModel();
	private CashToCloseModel closingCostsPaidBeforeClosing = new CashToCloseModel();
	private CashToCloseModel closingCostsFinanced = new CashToCloseModel();
	private CashToCloseModel downPayment = new CashToCloseModel();
	private CashToCloseModel totalPayoffsAndPayments = new CashToCloseModel();
	private CashToCloseModel deposit = new CashToCloseModel();
	private CashToCloseModel fundsForBorrower = new CashToCloseModel();
	private CashToCloseModel sellerCredits = new CashToCloseModel();
	private CashToCloseModel adjustmentsAndOtherCredits = new CashToCloseModel();
	private List<CashToCloseModel> cashToCloseTotal = new LinkedList<>();
	
	/**
	 * @return the loanAmount
	 */
	public CashToCloseModel getLoanAmount() {
		return loanAmount;
	}
	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(CashToCloseModel loanAmount) {
		this.loanAmount = loanAmount;
	}
	/**
	 * @return the totalClosingCosts
	 */
	public CashToCloseModel getTotalClosingCosts() {
		return totalClosingCosts;
	}
	/**
	 * @param totalClosingCosts the totalClosingCosts to set
	 */
	public void setTotalClosingCosts(CashToCloseModel totalClosingCosts) {
		this.totalClosingCosts = totalClosingCosts;
	}
	/**
	 * @return the closingCostsPaidBeforeClosing
	 */
	public CashToCloseModel getClosingCostsPaidBeforeClosing() {
		return closingCostsPaidBeforeClosing;
	}
	/**
	 * @param closingCostsPaidBeforeClosing the closingCostsPaidBeforeClosing to set
	 */
	public void setClosingCostsPaidBeforeClosing(CashToCloseModel closingCostsPaidBeforeClosing) {
		this.closingCostsPaidBeforeClosing = closingCostsPaidBeforeClosing;
	}
	/**
	 * @return the closingCostsFinanced
	 */
	public CashToCloseModel getClosingCostsFinanced() {
		return closingCostsFinanced;
	}
	/**
	 * @param closingCostsFinanced the closingCostsFinanced to set
	 */
	public void setClosingCostsFinanced(CashToCloseModel closingCostsFinanced) {
		this.closingCostsFinanced = closingCostsFinanced;
	}
	/**
	 * @return the downPayment
	 */
	public CashToCloseModel getDownPayment() {
		return downPayment;
	}
	/**
	 * @param downPayment the downPayment to set
	 */
	public void setDownPayment(CashToCloseModel downPayment) {
		this.downPayment = downPayment;
	}
	/**
	 * @return the totalPayoffsAndPayments
	 */
	public CashToCloseModel getTotalPayoffsAndPayments() {
		return totalPayoffsAndPayments;
	}
	/**
	 * @param totalPayoffsAndPayments the totalPayoffsAndPayments to set
	 */
	public void setTotalPayoffsAndPayments(CashToCloseModel totalPayoffsAndPayments) {
		this.totalPayoffsAndPayments = totalPayoffsAndPayments;
	}
	/**
	 * @return the deposit
	 */
	public CashToCloseModel getDeposit() {
		return deposit;
	}
	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(CashToCloseModel deposit) {
		this.deposit = deposit;
	}
	/**
	 * @return the fundsForBorrower
	 */
	public CashToCloseModel getFundsForBorrower() {
		return fundsForBorrower;
	}
	/**
	 * @param fundsForBorrower the fundsForBorrower to set
	 */
	public void setFundsForBorrower(CashToCloseModel fundsForBorrower) {
		this.fundsForBorrower = fundsForBorrower;
	}
	/**
	 * @return the sellerCredits
	 */
	public CashToCloseModel getSellerCredits() {
		return sellerCredits;
	}
	/**
	 * @param sellerCredits the sellerCredits to set
	 */
	public void setSellerCredits(CashToCloseModel sellerCredits) {
		this.sellerCredits = sellerCredits;
	}
	/**
	 * @return the adjustmentsAndOtherCredits
	 */
	public CashToCloseModel getAdjustmentsAndOtherCredits() {
		return adjustmentsAndOtherCredits;
	}
	/**
	 * @param adjustmentsAndOtherCredits the adjustmentsAndOtherCredits to set
	 */
	public void setAdjustmentsAndOtherCredits(CashToCloseModel adjustmentsAndOtherCredits) {
		this.adjustmentsAndOtherCredits = adjustmentsAndOtherCredits;
	}
	/**
	 * @return the cashToCloseTotal
	 */
	public List<CashToCloseModel> getCashToCloseTotal() {
		return cashToCloseTotal;
	}
	/**
	 * @param cashToCloseTotal the cashToCloseTotal to set
	 */
	public void setCashToCloseTotal(List<CashToCloseModel> cashToCloseTotal) {
		this.cashToCloseTotal = cashToCloseTotal;
	}
	
	
}
