package com.actualize.mortgage.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.mismo.residential._2009.schemas.DOCUMENT;

import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.CashToCloseModel;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;
import com.actualize.mortgage.services.PageThreeService;
import com.actualize.mortgage.utils.DocumentType;
import com.actualize.mortgage.utils.PopulateData;

public class PageThreeServiceImpl implements PageThreeService{
	
	List<CashToClose> cashToCloseList = new LinkedList<>();

	@Override
	public List<CashToClose> createCalculatingCashtoClose(DOCUMENT document) {
		List<CashToCloseModel> cashToCloseModels = PopulateData.populateCashToCloseModel(document);
		String closingCostsFinancedDetail = "";
		String closingCostsFinancedFinalAmount = "";
		boolean alternateView = DocumentType.isAlternateView(document);
		for (CashToCloseModel cashToCloseModel : cashToCloseModels) {
			switch (cashToCloseModel.getItemType()) {
				case "LoanAmount":
					setValuesAndInsert(cashToCloseModel,"Loan Amount",!alternateView ? "-1" : "1");
					break;
				case "TotalClosingCosts":
					setValuesAndInsert(cashToCloseModel,"Total Closing Costs (J)",!alternateView ? "1" : "2");
					break;
				case "ClosingCostsPaidBeforeClosing":
					setValuesAndInsert(cashToCloseModel,"Closing Costs Paid Before Closing",!alternateView ? "2" : "3");
					break;
				case "ClosingCostsFinanced":
					closingCostsFinancedDetail = "Closing Costs Financed (Paid from your Loan Amount)";
					closingCostsFinancedFinalAmount =  cashToCloseModel.getItemFinalAmount();
					setValuesAndInsert(cashToCloseModel,"Closing Costs Financed \n (Paid from your Loan Amount)",!alternateView ? "3" : "-1");
					break;
				case "DownPayment":
					setValuesAndInsert(cashToCloseModel,"Down Payment/Funds from Borrower",!alternateView ? "4" : "-1");
					break;
				case "TotalPayoffsAndPayments":
					setValuesAndInsert(cashToCloseModel,"Total Payoffs and Payments (K)",!alternateView ? "-1" : "4");
					break;
				case "Deposit":
					setValuesAndInsert(cashToCloseModel,"Deposit",!alternateView ? "5" : "-1");
					break;
				case "FundsForBorrower":
					setValuesAndInsert(cashToCloseModel,"Funds for Borrower",!alternateView ? "6" : "-1");
					break;
				case "SellerCredits":
					setValuesAndInsert(cashToCloseModel,"Seller Credits",!alternateView ? "7" : "-1");
					break;
				case "AdjustmentsAndOtherCredits":
					setValuesAndInsert(cashToCloseModel,"Adjustments and Other Credits",!alternateView ? "8" : "-1");
					break;
				case "CashToCloseTotal":
					CashToClose cashToClose = new CashToClose();
					cashToClose.setLabel("Cash to Close");
					cashToClose.setIndex(!alternateView ? "9" : "5");
					if(alternateView){
						if (!cashToCloseModel.getItemEstimatedAmount().isEmpty()) {
							if(cashToCloseModel.getItemPaymentType().equalsIgnoreCase("FromBorrower")){
								cashToClose.setLeFromBorrower("YES");
							} else if(cashToCloseModel.getItemPaymentType().equalsIgnoreCase("ToBorrower")){
								cashToClose.setLeFromBorrower("NO");
							}
						} else if(!cashToCloseModel.getItemFinalAmount().isEmpty()) {
							if (cashToCloseModel.getItemPaymentType().equalsIgnoreCase("FromBorrower")) {
								cashToClose.setFinalFromBorrower("YES");
							} else if(cashToCloseModel.getItemPaymentType().equalsIgnoreCase("ToBorrower")){
								cashToClose.setFinalFromBorrower("NO");
							}
						}
						if(!closingCostsFinancedFinalAmount.isEmpty()){
							cashToClose.setClosingCostsFinancedTotalAmount(closingCostsFinancedFinalAmount);
							cashToClose.setDtcDetail(closingCostsFinancedDetail);
						}
					}
					cashToCloseList.add(cashToClose);
					break;
			}
		}
		return cashToCloseList;
	}
	
	private void setValuesAndInsert(CashToCloseModel cashToCloseModel, String displayLabel, String index)
	{
		CashToClose cashToClose = new CashToClose();
		cashToClose.setDtcStatus(cashToCloseModel.getIsAmountChangedIndicator());
		cashToClose.setDtcStatus(cashToCloseModel.getItemChangeDescription());
		cashToCloseList.add(cashToClose);
	}

	@Override
	public SummariesofTransactions createSummariesofTransactions(DOCUMENT document) {
		SummariesofTransactions summariesofTransactions = new SummariesofTransactions();
		String adjustmentTypes ="FuelCosts,RelocationFunds,Repairs,SellersEscrowAssumption,SellersMortgageInsuranceAssumption,SweatEquity.TenantSecurityDeposit,TradeEquity,Other";
		String cityTaxFees   = "CityPropertyTax,DistrictPropertyTax,TownPropertyTax";
		String countyTaxFees = "BoroughPropertyTax,CountyPropertyTax";
		String assesmentFees = "CondominiumAssociationSpecialAssessment,CooperativeAssociationSpecialAssessment,HomeownersAssociationSpecialAssessment";
		String[] adjustmentFees	 = {"CondominiumAssociationDues","CooperativeAssociationDues","EarthquakeInsurancePremium","FloodInsurancePremium",
								"GroundRent","HailInsurancePremium","HazardInsurancePremium","HomeownersAssociationDues",
								"HomeownersInsurancePremium","InterestOnLoanAssumption","MortgageInsurancePremium","PastDuePropertyTax",
								"RentFromSubjectProperty","StatePropertyTax","Utilities","VolcanoInsurancePremium","WindAndStormInsurancePremium","Other"};
		String paidAlready   =  "ProceedsOfSubordinateLiens,SatisfactionOfSubordinateLien,";
		String liabilityFromSeller = "DelinquentTaxes,HELOC,TaxLien,Taxes,ThirdPositionMortgage,Other";
		
		
		
		
		return summariesofTransactions;
		
	}
}
