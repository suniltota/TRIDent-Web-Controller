package com.actualize.mortgage.services.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.LOAN;
import org.mismo.residential._2009.schemas.LOANDETAIL;
import org.mismo.residential._2009.schemas.TERMSOFLOAN;

import com.actualize.mortgage.domainmodels.AdjustmentsModel;
import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.CashToCloseModel;
import com.actualize.mortgage.domainmodels.ClosingCostFundModel;
import com.actualize.mortgage.domainmodels.ID_SubsectionModel;
import com.actualize.mortgage.domainmodels.LiabilitiesModel;
import com.actualize.mortgage.domainmodels.ProrationsModel;
import com.actualize.mortgage.domainmodels.SalesContractDetailModel;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsBorrowerSection;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetails;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsDueFromBorrowerAtClosing;
import com.actualize.mortgage.domainmodels.SummariesofTransactionsDetailsPaidAlreadyby;
import com.actualize.mortgage.services.PageThreeService;
import com.actualize.mortgage.utils.DocumentType;
import com.actualize.mortgage.utils.PopulateData;
import com.actualize.mortgage.utils.StringFormatter;

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
								cashToClose.setDtcStatus("YES");
							} else if(cashToCloseModel.getItemPaymentType().equalsIgnoreCase("ToBorrower")){
								cashToClose.setDtcStatus("NO");
							}
						} else if(!cashToCloseModel.getItemFinalAmount().isEmpty()) {
							if (cashToCloseModel.getItemPaymentType().equalsIgnoreCase("FromBorrower")) {
								cashToClose.setDtcStatus("YES");
							} else if(cashToCloseModel.getItemPaymentType().equalsIgnoreCase("ToBorrower")){
								cashToClose.setDtcStatus("NO");
							}
						}
						if(!closingCostsFinancedFinalAmount.isEmpty()){
							cashToClose.setClosingCostsFinancedTotalAmount(closingCostsFinancedFinalAmount);
							cashToClose.setDtcDetail(closingCostsFinancedDetail);
						}
					}
					cashToClose.setType(cashToCloseModel.getItemType());
					cashToClose.setLeFromBorrower(cashToCloseModel.getItemEstimatedAmount());
					cashToClose.setFinalFromBorrower(cashToCloseModel.getItemFinalAmount());
					cashToCloseList.add(cashToClose);
					break;
			}
		}
		
		Collections.sort(cashToCloseList,new Comparator<CashToClose>(){
			@Override
			public int compare(CashToClose o1, CashToClose o2) {
				return o1.getIndex().compareTo(o2.getIndex());
			}
		});
		
		return cashToCloseList;
	}
	
	
	private void setValuesAndInsert(CashToCloseModel cashToCloseModel, String displayLabel, String index)
	{
		if(!"-1".equals(index))
		{
			CashToClose cashToClose = new CashToClose();
				cashToClose.setLabel(displayLabel);
				cashToClose.setType(cashToCloseModel.getItemType());
				cashToClose.setLeFromBorrower(cashToCloseModel.getItemEstimatedAmount());
				cashToClose.setFinalFromBorrower(cashToCloseModel.getItemFinalAmount());
				cashToClose.setDtcStatus(cashToCloseModel.getIsAmountChangedIndicator());
				cashToClose.setDtcDetail(cashToCloseModel.getItemChangeDescription());
				cashToClose.setIndex(index);
			cashToCloseList.add(cashToClose);
		}
	}
	
	@Override
	public SummariesofTransactions createSummariesofTransactions(DOCUMENT document) {
		SummariesofTransactions summariesofTransactions = new SummariesofTransactions();
		SummariesofTransactionsBorrowerSection borrowerSection = new SummariesofTransactionsBorrowerSection();
		SummariesofTransactionsDetailsDueFromBorrowerAtClosing dueFromBorrowerAtClosing = new SummariesofTransactionsDetailsDueFromBorrowerAtClosing();
		SummariesofTransactionsDetailsPaidAlreadyby paidAlreadyby = new SummariesofTransactionsDetailsPaidAlreadyby();
		List<SummariesofTransactionsDetails> duefromBorrowerList = new LinkedList<>();
		List<SummariesofTransactionsDetails> adjustmentsList = new LinkedList<>();
		List<SummariesofTransactionsDetails> adjustmentsforItemsList = new LinkedList<>();
		List<SummariesofTransactionsDetails> sectionL = new LinkedList<>();
		List<SummariesofTransactionsDetails> otherCredits = new LinkedList<>();
		List<SummariesofTransactionsDetails> adjustments = new LinkedList<>();
		List<SummariesofTransactionsDetails> adjustmentsfor = new LinkedList<>();
		List<ID_SubsectionModel> id_Subsections = PopulateData.populateID_SubsectionModel(document);
		List<LiabilitiesModel> liabilitiesModels = PopulateData.populateLiabilitiesModel(document);
		List<AdjustmentsModel> adjustmentsModels = PopulateData.populateAdjustmentsModel(document);
		List<ProrationsModel> prorationsModels = PopulateData.populateProrationsModel(document);
		List<ClosingCostFundModel> closingCostFundModels = PopulateData.populateClosingCostFundModel(document);
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
		String[] dueFromBorrowerLabel = {"Sale Price of Property","Sale Price of Any Personal Property Included in Sale", "Closing Costs Paid at Closing (J)"};
		LOAN loan = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN();
		String str = "";
		ID_SubsectionModel payment = null;
		ID_SubsectionModel lenderCredit = null;
		
		if(null != loan.getTERMSOFLOAN() && null != loan.getTERMSOFLOAN().getLienPriorityType())
			str = loan.getTERMSOFLOAN().getLienPriorityType().getValue().value();
		
		boolean firstLien = str.equals("") || str.equalsIgnoreCase("FirstLien");
		
		if(!DocumentType.isSellerOnly(document))
		{
			 Map<String,String> IDSSummaryDetail = PopulateData.getIntegrateddisclosuresectionsummariesAmountMap(document);
			 	borrowerSection.setDueFromBorrowerAtClosingTotalAmount(IDSSummaryDetail.get("DueFromBorrowerAtClosing"));
			 	borrowerSection.setPaidAlreadybyoronBehalfofBorroweratClosing(IDSSummaryDetail.get("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing"));
			
				SalesContractDetailModel contractDetail = PopulateData.populateSalesContractDetail(document);
				 for(int i=0;i<dueFromBorrowerLabel.length;i++)
				 {
					 SummariesofTransactionsDetails dueFromBorrower = new SummariesofTransactionsDetails();
					 	
					 	if("Sale Price of Property".equalsIgnoreCase(dueFromBorrowerLabel[i]) && firstLien)
					 	{
					 		dueFromBorrower.setLabel(dueFromBorrowerLabel[i]);
					 		dueFromBorrower.setAmount("".equals(contractDetail.getRealPropertyAmount()) ? contractDetail.getSaleContractAmount() : contractDetail.getRealPropertyAmount() );
					 	}
					 	else if("Sale Price of Any Personal Property Included in Sale".equalsIgnoreCase(dueFromBorrowerLabel[i]))
					 	{
					 		dueFromBorrower.setLabel(dueFromBorrowerLabel[i]);
					 		dueFromBorrower.setAmount(contractDetail.getPersonalPropertyAmount());
					 	}
					 	else if("Closing Costs Paid at Closing (J)".equalsIgnoreCase(dueFromBorrowerLabel[i]))
					 	{	
					 		dueFromBorrower.setLabel(dueFromBorrowerLabel[i]);
					 		for(ID_SubsectionModel id_Subsection :id_Subsections)
					 		{
					 			if (id_Subsection.getIntegratedDisclosureSubsectionType().equals("LenderCredits"))
									lenderCredit = id_Subsection;
								else if (id_Subsection.getIntegratedDisclosureSectionType().equals("TotalClosingCosts")
										&& id_Subsection.getIntegratedDisclosureSubsectionType().equals("ClosingCostsSubtotal")
										&& id_Subsection.getPaymentPaidByType().equals("Buyer")
										&& !id_Subsection.isPaidOutsideOfClosingIndicator())
									payment = id_Subsection;
					 		}
					 		
					 		if (payment != null) {
								double netPayment = 0;
								try {
									netPayment = Double.valueOf(payment.getPaymentAmount());
									if (lenderCredit != null && !lenderCredit.getPaymentAmount().equals(""))
										netPayment += Double.valueOf(lenderCredit.getPaymentAmount());
								} catch (Exception e) {
									e.printStackTrace();
								}
								dueFromBorrower.setAmount(String.valueOf(netPayment));
							}
					 	
					 	}
					 	duefromBorrowerList.add(dueFromBorrower);
				}
				for(LiabilitiesModel liability: liabilitiesModels)
				{
					if (!liability.getType().equals("") && liability.getIDSection().equalsIgnoreCase("DueFromBorrowerAtClosing")) {
						SummariesofTransactionsDetails dueFromBorrower = new SummariesofTransactionsDetails();
							dueFromBorrower.setLabel(liability.getLabel()+" "+liability.getFullName());
							dueFromBorrower.setAmount(liability.getPayoffAmount());
						duefromBorrowerList.add(dueFromBorrower);
					}
				}
				
				for (AdjustmentsModel adjustment : adjustmentsModels) {
					if (adjustment.getIntegratedDisclosureSectionType().equals("DueFromBorrowerAtClosing")
							&& adjustment.getIntegratedDisclosureSubsectionType().equals("Adjustments")
							&& adjustmentTypes.contains(adjustment.getType())){
						SummariesofTransactionsDetails adjustmentDetail = new SummariesofTransactionsDetails();
							adjustmentDetail.setLabel(adjustment.getLabel());
							adjustmentDetail.setAmount(adjustment.getPaymentAmount());
							adjustmentsList.add(adjustmentDetail);
						} 
				}
				SummariesofTransactionsDetails cityTaxFee = new SummariesofTransactionsDetails();
				SummariesofTransactionsDetails countyTaxFee = new SummariesofTransactionsDetails();
				SummariesofTransactionsDetails assesmentFee = new SummariesofTransactionsDetails();
				cityTaxFee.setLabel("City/Town Taxes");
				countyTaxFee.setLabel("County Taxes");
				assesmentFee.setLabel("Assessments");
				for (ProrationsModel proration :prorationsModels )
				{
					if (proration.getIntegratedDisclosureSectionType().equals("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing")
							&& proration.getIntegratedDisclosureSubsectionType().equals("AdjustmentsForItemsUnpaidBySeller")){
						if (cityTaxFees.contains(proration.getType())) {
							if (!proration.getProrationItemPaidFromDate().equals(""))
								 cityTaxFee.setFromPeriod(StringFormatter.SHORTDATE.formatString(proration.getProrationItemPaidFromDate()));
							if (!proration.getProrationItemPaidThroughDate().equals(""))
								cityTaxFee.setToPeriod(StringFormatter.SHORTDATE.formatString(proration.getProrationItemPaidThroughDate()));
							if (!proration.getPaymentAmount().equals(""))
								cityTaxFee.setAmount(proration.getPaymentAmount());
							adjustmentsforItemsList.add(cityTaxFee);
						}
						else if (countyTaxFees.contains(proration.getType())) {
								
								if (!proration.getProrationItemPaidFromDate().equals(""))
									countyTaxFee.setFromPeriod(StringFormatter.SHORTDATE.formatString(proration.getProrationItemPaidFromDate()));
								if (!proration.getProrationItemPaidThroughDate().equals(""))
									countyTaxFee.setToPeriod(StringFormatter.SHORTDATE.formatString(proration.getProrationItemPaidThroughDate()));
								if (!proration.getPaymentAmount().equals(""))
									countyTaxFee.setAmount(proration.getPaymentAmount());
								adjustmentsforItemsList.add(countyTaxFee);
							}
						else if (assesmentFees.contains(proration.getType())) {
							
							if (!proration.getProrationItemPaidFromDate().equals(""))
								assesmentFee.setFromPeriod(StringFormatter.SHORTDATE.formatString(proration.getProrationItemPaidFromDate()));
							if (!proration.getProrationItemPaidThroughDate().equals(""))
								assesmentFee.setToPeriod(StringFormatter.SHORTDATE.formatString(proration.getProrationItemPaidThroughDate()));
							if (!proration.getPaymentAmount().equals(""))
								assesmentFee.setAmount(StringFormatter.DOLLARS.formatString(proration.getPaymentAmount()));
							adjustmentsforItemsList.add(assesmentFee);
						}
						else if (Arrays.asList(adjustmentFees).contains(proration.getType())) {
							SummariesofTransactionsDetails adjustmentFee = new SummariesofTransactionsDetails();
							str = proration.getLabel();
							if ("".equalsIgnoreCase(str))
								str = StringFormatter.CAMEL.formatString(proration.getType());
							if (!proration.getProrationItemPaidFromDate().equals(""))
								adjustmentFee.setFromPeriod(StringFormatter.SHORTDATE.formatString(proration.getProrationItemPaidFromDate()));
							if (!proration.getProrationItemPaidThroughDate().equals(""))
								adjustmentFee.setToPeriod(StringFormatter.SHORTDATE.formatString(proration.getProrationItemPaidThroughDate()));
							if (!proration.getPaymentAmount().equals(""))
								adjustmentFee.setAmount(proration.getPaymentAmount());
							adjustmentFee.setLabel(str);
							adjustmentsforItemsList.add(adjustmentFee);
						}
					}
			}
			SummariesofTransactionsDetails secL = new SummariesofTransactionsDetails();
			secL.setLabel("Deposit");
			for (ClosingCostFundModel fundsLocal : closingCostFundModels)
				if (fundsLocal.getIntegratedDisclosureSectionType().equals("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing")
						&& fundsLocal.getFundsType().equals("DepositOnSalesContract")) {
					secL.setAmount(fundsLocal.getClosingCostFundAmount());
					break;
				}
			sectionL.add(secL);
			SummariesofTransactionsDetails loanAmount = new SummariesofTransactionsDetails();
			SummariesofTransactionsDetails existingLoan = new SummariesofTransactionsDetails();
			loanAmount.setLabel("Loan Amount");
			existingLoan.setLabel("Existing Loan(s) Assumed or Taken Subject to");
			if(null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN() && null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN())
			{
				TERMSOFLOAN termsofloan = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getTERMSOFLOAN();
				loanAmount.setAmount(null != termsofloan.getNoteAmount() ? termsofloan.getNoteAmount().getValue().toPlainString() : "");
				existingLoan.setAmount(null!= termsofloan.getAssumedLoanAmount() ? termsofloan.getAssumedLoanAmount().getValue().toPlainString() : "");
			}
			sectionL.add(loanAmount);
			sectionL.add(existingLoan);
			
			for (AdjustmentsModel adjustment : adjustmentsModels) {
				SummariesofTransactionsDetails subordinatedLien = new SummariesofTransactionsDetails();
				if (adjustment.getIntegratedDisclosureSectionType().equals("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing") && !adjustment.getType().equals("SellerCredit")) {
					if (!adjustment.getIntegratedDisclosureSubsectionType().equals("OtherCredits") && !adjustment.getIntegratedDisclosureSubsectionType().equals("Adjustments")) {
						if (paidAlready.contains(adjustment.getType()) && paidAlready.contains(adjustment.getTypeOtherDescription())){
							subordinatedLien.setLabel("Second Loan (Principal Balance");
							if(null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN() && null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getLOANDETAIL())
							{
								LOANDETAIL loandetail = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getLOANDETAIL();
									subordinatedLien.setFromPeriod(null != loandetail.getTotalSubordinateFinancingAmount() ? loandetail.getTotalSubordinateFinancingAmount().getValue().toPlainString() : "" );
							}
						}
						else
							subordinatedLien.setLabel(adjustment.getLabel());
							subordinatedLien.setAmount(adjustment.getPaymentAmount());
							sectionL.add(subordinatedLien);
					}
				}
				else if (adjustment.getType().equals("SellerCredit") && adjustment.getIntegratedDisclosureSectionType().equalsIgnoreCase("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing")) {
					subordinatedLien.setLabel("Seller Credit");
					subordinatedLien.setAmount(adjustment.getPaymentAmount());
					sectionL.add(subordinatedLien);
				}
				else if(adjustment.getIntegratedDisclosureSubsectionType().equals("OtherCredits")) {
					SummariesofTransactionsDetails otherCredit = new SummariesofTransactionsDetails();
					otherCredit.setLabel(adjustment.getLabel());
					if (!adjustment.getPaymentPaidByType().equals(""))
						otherCredit.setFromPeriod(adjustment.getPaymentPaidByType());
					else if (!adjustment.getPaymentToEntity().equals(""))
						otherCredit.setFromPeriod(adjustment.getPaymentToEntity());
						otherCredit.setAmount(adjustment.getPaymentAmount());
					otherCredits.add(otherCredit);	
					}
				else if (adjustment.getIntegratedDisclosureSectionType().equals("PaidAlreadyByOrOnBehalfOfBorrowerAtClosing") && adjustment.getIntegratedDisclosureSubsectionType().equals("Adjustments") && adjustmentTypes.contains(adjustment.getType())){
					SummariesofTransactionsDetails adjustmentL = new SummariesofTransactionsDetails();
						adjustmentL.setLabel(adjustment.getLabel());
						if (!adjustment.getPaymentPaidByType().equals(""))
							adjustmentL.setFromPeriod(adjustment.getPaymentPaidByType());
						if (!adjustment.getPaymentToEntity().equals(""))
							adjustmentL.setFromPeriod(adjustment.getPaymentPaidByType());
							adjustmentL.setAmount(adjustment.getPaymentAmount());
						adjustments.add(adjustmentL);
					}
			}
			
			dueFromBorrowerAtClosing.setDuefromBorrowerList(duefromBorrowerList);
			dueFromBorrowerAtClosing.setAdjustmentsList(adjustmentsList);
			dueFromBorrowerAtClosing.setAdjustmentsforItemsList(adjustmentsforItemsList);
			paidAlreadyby.setPaidAlreadyby(sectionL);
			paidAlreadyby.setAdjustments(adjustments);
		}
		borrowerSection.setDuefromBorroweratClosing(dueFromBorrowerAtClosing);
		borrowerSection.setPaidAlreadyby(paidAlreadyby);
		summariesofTransactions.setBorrowerSection(borrowerSection);
		return summariesofTransactions;
		
	}
}
