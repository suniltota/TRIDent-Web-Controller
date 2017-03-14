package com.actualize.mortgage.services.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mismo.residential._2009.schemas.ADDRESS;
import org.mismo.residential._2009.schemas.COLLATERAL;
import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.ESTIMATEDPROPERTYCOSTCOMPONENT;
import org.mismo.residential._2009.schemas.INTERESTRATEPERCHANGEADJUSTMENTRULE;
import org.mismo.residential._2009.schemas.LOANIDENTIFIER;
import org.mismo.residential._2009.schemas.LoanPurposeBase;
import org.mismo.residential._2009.schemas.PARTY;
import org.mismo.residential._2009.schemas.PRINCIPALANDINTERESTPAYMENTPERCHANGEADJUSTMENTRULE;
import org.mismo.residential._2009.schemas.PROJECTEDPAYMENT;
import org.mismo.residential._2009.schemas.PartyRoleBase;

import com.actualize.mortgage.domainmodels.Address;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.CostsAtClosingCashToClose;
import com.actualize.mortgage.domainmodels.CostsAtClosingClosingCosts;
import com.actualize.mortgage.domainmodels.Lender;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.LoanTermsBalloonPayment;
import com.actualize.mortgage.domainmodels.LoanTermsInterestRate;
import com.actualize.mortgage.domainmodels.LoanTermsLoanAmount;
import com.actualize.mortgage.domainmodels.LoanTermsPI;
import com.actualize.mortgage.domainmodels.LoanTermsPrepaymentPenalty;
import com.actualize.mortgage.domainmodels.ProjectedPayments;
import com.actualize.mortgage.domainmodels.ProjectedPayments.ProjectedPaymentsPI;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsETIA;
import com.actualize.mortgage.domainmodels.Seller;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.services.PageOneService;
import com.actualize.mortgage.utils.Convertor;
import com.actualize.mortgage.utils.DocumentType;
import com.actualize.mortgage.utils.StringFormatter;

public class PageOneServiceImpl implements PageOneService {
	
	DEAL deal = null;
	Address property = new Address();
	
	Convertor convertor = new Convertor();
	
	String loanId = "";
	String loanMic = "";
	String text4_2_2 = "";
	
	@Override
	public ClosingInformation createClosingInformation(DOCUMENT document) {
		
		ClosingInformation closingInformation = new ClosingInformation();
		ADDRESS address = new ADDRESS();
		
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		//DEAL.LOANS.LOAN.CLOSING_INFORMATION.CLOSING_INFORMATION_DETAIL.ClosingDate['__text'];
		if(null != deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingDate())
			closingInformation.setClosingDate(deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingDate().getValue());
		
		//DEAL.LOANS.LOAN.DOCUMENT_SPECIFIC_DATA_SETS.DOCUMENT_SPECIFIC_DATA_SET.INTEGRATED_DISCLOSURE.INTEGRATED_DISCLOSURE_DETAIL.IntegratedDisclosureIssuedDate['__text'];
		if(null != deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureIssuedDate())
			closingInformation.setDateIssued(deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureIssuedDate().getValue());
		
		//DEAL.LOANS.LOAN.CLOSING_INFORMATION.CLOSING_INFORMATION_DETAIL.DisbursementDate['__text'];
		if(null != deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getDisbursementDate())
			closingInformation.setDisbursementDate(deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getDisbursementDate().getValue());
		
		//DEAL.LOANS.LOAN.CLOSING_INFORMATION.CLOSING_INFORMATION_DETAIL.ClosingAgentOrderNumberIdentifier['__text'];
		if(null != deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingAgentOrderNumberIdentifier())
			closingInformation.setFileNo(deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingAgentOrderNumberIdentifier().getValue());
		
		//DEAL.COLLATERALS.COLLATERAL.SUBJECT_PROPERTY.ADDRESS
		List<COLLATERAL> collaterals = deal.getCOLLATERALS().getCOLLATERAL();
		for(COLLATERAL collateral : collaterals)
		{
			 address = collateral.getSUBJECTPROPERTY().getADDRESS();
		}
		property.setAddressLineText(address.getAddressLineText()== null ? "" : address.getAddressLineText().getValue());
		property.setAddressType(address.getAddressType() == null ? "" : address.getAddressType().getValue().value());
		property.setAddressUnitDesignatorType(address.getAddressUnitDesignatorType()== null ? "" :address.getAddressUnitDesignatorType().getValue().value());
		property.setAddressUnitIdentifier(address.getAddressUnitIdentifier()== null ? "" :address.getAddressUnitDesignatorType().getValue().value());
		property.setCityName(address.getCityName()== null ? "" : address.getCityName().getValue());
		property.setCountryCode(address.getCountryCode()== null ? "" :address.getCountryCode().getValue());
		property.setPostalCode(address.getPostalCode()== null ? "" :address.getPostalCode().getValue());
		property.setStateCode(address.getStateCode()== null ? "" :address.getStateCode().getValue());
		
		closingInformation.setProperty(property);
		
		List<PARTY> parties = deal.getPARTIES().getPARTY();
		parties.forEach(party ->{
			if(null != party.getROLES())
			{
				if(null != party.getROLES().getROLE().getROLEDETAIL())
					if(PartyRoleBase.CLOSING_AGENT == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
				closingInformation.setSettlementAgent( null != party.getLEGALENTITY() ? party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().getValue():"");
			}
		});
				
		if(LoanPurposeBase.PURCHASE == deal.getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue())
		{
			collaterals.forEach(collateral ->{
				closingInformation.setSalePrice(collateral.getSUBJECTPROPERTY().getSALESCONTRACTS().getSALESCONTRACT().getSALESCONTRACTDETAIL().getSalesContractAmount().getValue().toString());
			});
		}
				
		return closingInformation;
	}

	@Override
	public LoanInformation createLoanInformation(DOCUMENT document) {
		
		LoanInformation loanInformation = new LoanInformation();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		String loanTotalTerm = "";
		String loanPurpose = "";
		String loanProduct = "";
		String loanType = "";
		loanId = "";
		loanMic = "";
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getConstructionLoanIndicator().isValue() && "ConstructionToPermanent".equalsIgnoreCase(deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanType().getValue().value()))
		{
			//months = jsonOutput.MESSAGE.DOCUMENT_SETS.DOCUMENT_SET.DOCUMENTS.DOCUMENT.DEAL_SETS.DEAL_SET.DEALS.DEAL.LOANS.LOAN.CONSTRUCTION.ConstructionLoanTotalTermMonthsCount['__text'];
			loanTotalTerm = convertor.convertMonthsToDisplayFormat(deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanTotalTermMonthsCount().getValue());
		}
		//else if((DEAL.LOANS.LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodType['__text']).equals("Year")){
		else if("Year".equalsIgnoreCase(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodType().getValue().value()))
		{
			//value = DEAL.LOANS.LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodCount['__text'];
			loanTotalTerm = Integer.toString(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().getValue()) + " Year";
		}
		//DEAL.LOANS.LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodType['__text']).equals("Month") && !DEAL.LOANS.LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodCount['__text'].equals("")
		else if("Month".equalsIgnoreCase(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodType().getValue().value()) && !("").equalsIgnoreCase(Integer.toString(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().getValue())))
		{
			//DEAL.LOANS.LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodCount['__text'];
			loanTotalTerm = convertor.convertMonthsToDisplayFormat(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().getValue());
		}
		
		//DEAL.LOANS.LOAN.TERMS_OF_LOAN.LoanPurposeType['__text']).equals("Purchase")) {
		if(("Purchase").equalsIgnoreCase(deal.getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue().value()))
			loanPurpose = "Purchase";
		//DEAL.LOANS.LOAN.LOAN_DETAIL.ConstructionLoanIndicator['__text']).equals("true")
		else if(("true").equalsIgnoreCase(deal.getLOANS().getLOAN().getLOANDETAIL().getConstructionLoanIndicator().getLabel()))
			loanPurpose = "Construction";
		//DEAL.LOANS.LOAN.DOCUMENT_SPECIFIC_DATA_SETS.DOCUMENT_SPECIFIC_DATA_SET.INTEGRATED_DISCLOSURE.INTEGRATED_DISCLOSURE_DETAIL.IntegratedDisclosureHomeEquityLoanIndicator").equals("true")
		else if(("true").equalsIgnoreCase(deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureHomeEquityLoanIndicator().getLabel()))
			loanPurpose = "Home Equity Loan";
		else
			loanPurpose = "Refinance";
		//DEAL.LOANS.LOAN.DOCUMENT_SPECIFIC_DATA_SETS.DOCUMENT_SPECIFIC_DATA_SET.INTEGRATED_DISCLOSURE.INTEGRATED_DISCLOSURE_DETAIL.IntegratedDisclosureLoanProductDescription['__text']
		loanProduct = deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureLoanProductDescription().getValue();
		
		//DEAL.LOANS.LOAN.TERMS_OF_LOAN.MortgageType['__text'].equals("Conventional  | FHA  | LocalAgency  | Other  | PublicAndIndianHousing  | StateAgency  | USDARuralDevelopment  | VA")
			loanType = deal.getLOANS().getLOAN().getTERMSOFLOAN().getMortgageType().getValue().value();
			
		//DEAL.LOANS.LOAN.LOAN_IDENTIFIERS.LOAN_IDENTIFIER.LenderLoan['__text']
		List<LOANIDENTIFIER> loanidentifiers = deal.getLOANS().getLOAN().getLOANIDENTIFIERS().getLOANIDENTIFIER();
		loanidentifiers.forEach(loanidentifier ->{
			if("LenderLoan".equalsIgnoreCase(loanidentifier.getLoanIdentifierType().getValue().value()))
				loanId = loanidentifier.getLoanIdentifier().getValue();
		});
		
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getMIRequiredIndicator().isValue())
			if("Conventional".equalsIgnoreCase(deal.getLOANS().getLOAN().getTERMSOFLOAN().getMortgageType().getValue().value()))
				loanMic = deal.getLOANS().getLOAN().getMIDATA().getMIDATADETAIL().getMICertificateIdentifier().getValue();
			else
			{
				loanidentifiers.forEach(loanidentifier ->{
					if("AgencyCase".equalsIgnoreCase(loanidentifier.getLoanIdentifier().getValue()))
						loanMic = loanidentifier.getLoanIdentifier().getValue();
				});
			}	 
		loanInformation.setLoanTerm(loanTotalTerm);
		loanInformation.setPurpose(loanPurpose);
		loanInformation.setLoanType(loanType);
		loanInformation.setProduct(loanProduct);
		loanInformation.setLoanId(loanId);
		loanInformation.setMic(loanMic);

		return loanInformation;
	}

	@Override
	public TransactionInformation createTransactionInformation(DOCUMENT document) {
		
		TransactionInformation transactionInformation = new TransactionInformation();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		List<Borrower> borrowers = new LinkedList<>();
		List<Seller> sellers = new LinkedList<>();
		List<Lender> lenders = new LinkedList<>();
		
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		List<PARTY> parties = deal.getPARTIES().getPARTY();
		parties.forEach(party ->{
			if(null != party.getROLES())
			{
				if(null != party.getROLES().getROLE().getROLEDETAIL())
				if( PartyRoleBase.BORROWER == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
				{
					//DEAL.PARTIES.PARTY.LEGAL_ENTITY.LEGAL_ENTITY_DETAIL.FullName['__text']
					Borrower borrower = new Borrower();
					Address bproperty = new Address();
					String bName = party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().getValue();
					borrower.setBorrowerFullName(bName);
					ADDRESS bAddress = party.getADDRESSES().getADDRESS();
					bproperty.setAddressLineText(bAddress.getAddressLineText()== null ? "" :bAddress.getAddressLineText().getValue());
					bproperty.setAddressType(bAddress.getAddressType()== null ? "" :bAddress.getAddressType().getValue().value());
					bproperty.setAddressUnitDesignatorType(bAddress.getAddressUnitDesignatorType()== null ? "" :bAddress.getAddressUnitDesignatorType().getValue().value());
					bproperty.setAddressUnitIdentifier(bAddress.getAddressUnitIdentifier()== null ? "" :bAddress.getAddressUnitIdentifier().getValue());
					bproperty.setCityName(bAddress.getCityName()== null ? "" :bAddress.getCityName().getValue());
					bproperty.setCountryCode(bAddress.getCountryCode()== null ? "" :bAddress.getCountryCode().getValue());
					bproperty.setPostalCode(bAddress.getPostalCode()== null ? "" :bAddress.getPostalCode().getValue());
					bproperty.setStateCode(bAddress.getStateCode()== null ? "" :bAddress.getStateCode().getValue());
					borrower.setAddress(bproperty);
					borrowers.add(borrower);
				}
				else if(PartyRoleBase.PROPERTY_SELLER == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
				{
					Seller seller = new Seller();
					Address sproperty = new Address();
					String sName = "";
					
					if(party.getLEGALENTITY() !=null)
					{
						sName = party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().getValue();
						seller.setSellerFullName(sName);
						ADDRESS sAddress = party.getADDRESSES().getADDRESS();
						sproperty.setAddressLineText(sAddress.getAddressLineText()== null ? "" :sAddress.getAddressLineText().getValue());
						sproperty.setAddressType(sAddress.getAddressType()== null ? "" :sAddress.getAddressType().getValue().value());
						sproperty.setAddressUnitDesignatorType(sAddress.getAddressUnitDesignatorType()== null ? "" :sAddress.getAddressUnitDesignatorType().getValue().value());
						sproperty.setAddressUnitIdentifier(sAddress.getAddressUnitIdentifier()== null ? "" :sAddress.getAddressUnitIdentifier().getValue());
						sproperty.setCityName(sAddress.getCityName()== null ? "" :sAddress.getCityName().getValue());
						sproperty.setCountryCode(sAddress.getCountryCode()== null ? "" :sAddress.getCountryCode().getValue());
						sproperty.setPostalCode(sAddress.getPostalCode()== null ? "" :sAddress.getPostalCode().getValue());
						sproperty.setStateCode(sAddress.getStateCode()== null ? "" :sAddress.getStateCode().getValue());
						seller.setAddress(sproperty);
					}
					sellers.add(seller);
				}
				else if(PartyRoleBase.NOTE_PAY_TO == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
				{
					Lender lender = new Lender();
					Address lproperty = new Address();
					String lName = "";
					
					if(null != party.getLEGALENTITY())
					{
						lName = party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().getValue();
						lender.setLenderFullName(lName);
						ADDRESS lAddress = party.getADDRESSES().getADDRESS();
						lproperty.setAddressLineText(lAddress.getAddressLineText()== null ? "" :lAddress.getAddressLineText().getValue());
						lproperty.setAddressType(lAddress.getAddressType()== null ? "" :lAddress.getAddressType().getValue().value());
						lproperty.setAddressUnitDesignatorType(lAddress.getAddressUnitDesignatorType()== null ? "" :lAddress.getAddressUnitDesignatorType().getValue().value());
						lproperty.setAddressUnitIdentifier(lAddress.getAddressUnitIdentifier()== null ? "" :lAddress.getAddressUnitIdentifier().getValue());
						lproperty.setCityName(lAddress.getCityName()== null ? "" :lAddress.getCityName().getValue());
						lproperty.setCountryCode(lAddress.getCountryCode()== null ? "" :lAddress.getCountryCode().getValue());
						lproperty.setPostalCode(lAddress.getPostalCode()== null ? "" :lAddress.getPostalCode().getValue());
						lproperty.setStateCode(lAddress.getStateCode()== null ? "" :lAddress.getStateCode().getValue());
						lender.setAddress(lproperty);
						lenders.add(lender);
					}
				}
			}
		});
		
		transactionInformation.setBorrower(borrowers);
		transactionInformation.setSeller(sellers);
		transactionInformation.setLender(lenders);
		
		return transactionInformation;
	}

	@Override
	public LoanTerms createLoanTerms(DOCUMENT document ) {
		LoanTerms loanTerms = new LoanTerms();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		LoanTermsLoanAmount loanTermsLoanAmount = new LoanTermsLoanAmount();
		String loanAmount = "";
		text4_2_2 = "";
		//DEAL.LOANS.LOAN.TERMS_OF_LOAN.NoteAmount['__text']
		loanAmount = deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteAmount().getValue().toPlainString();	
		loanTermsLoanAmount.setAmount(loanAmount);
		//DEAL.LOANS.LOAN.LOAN_DETAIL.NegativeAmortizationIndicator['__text']).equalsIgnoreCase("true")
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getNegativeAmortizationIndicator().isValue())
		{
			String text4_1_2 = "Can go as high as ";
			String text4_1_3 = "Can increase until year ";
			//DEAL.LOANS.LOAN.LOAN_DETAIL.LoanAmountIncreaseIndicator
			if(deal.getLOANS().getLOAN().getLOANDETAIL().getLoanAmountIncreaseIndicator().isValue())
			{
				//DEAL.LOANS.LOAN.NEGATIVE_AMORTIZATION.NEGATIVE_AMORTIZATION_RULE.NegativeAmortizationType['__text']).equalsIgnoreCase("ScheduledNegativeAmortization")
				if("ScheduledNegativeAmortization".equalsIgnoreCase(deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationType().getValue().value()))
				{
					text4_1_2 = "Does go as high as ";
					text4_1_3 = "Does increase until year ";
				}
			}
			//DEAL.LOANS.LOAN.NEGATIVE_AMORTIZATION.NEGATIVE_AMORTIZATION_RULE.NegativeAmortizationMaximumLoanBalanceAmount['__text']
			text4_1_2 = text4_1_2 + " " + deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationMaximumLoanBalanceAmount().getValue().toPlainString();
			//DEAL.LOANS.LOAN.NEGATIVE_AMORTIZATION.NegativeAmortizationLimitMonthsCount['__text']
			text4_1_3 = text4_1_3 + " " +Integer.toString(deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationLimitMonthsCount().getValue()); 
			
			loanTermsLoanAmount.setStatus("YES");
			List<String> details = new LinkedList<>();
				details.add(text4_1_2);
				details.add(text4_1_3);
			loanTermsLoanAmount.setDetails(details);
		}			
		else
			loanTermsLoanAmount.setStatus("NO");
		
		LoanTermsInterestRate loanTermsInterestRate = new LoanTermsInterestRate();
		String text4_2 ="";
		//DEAL.LOANS.LOAN.BUYDOWN.BUYDOWN_RULE.EXTENSION.OTHER.BuydownReflectedInNoteIndicator['__text']).equalsIgnoreCase("true") 
        //&& !DEAL.LOANS.LOAN.BUYDOWN.BUYDOWN_OCCURRENCES.BUYDOWN_OCCURRENCE.BuydownInitialEffectiveInterestRatePercent['__text']).equals(""))
		if(null != deal.getLOANS().getLOAN().getBUYDOWN())
		{
		if(deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getEXTENSION().getOTHER().isBuydownReflectedInNoteIndicator() && !("").equals(deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNOCCURRENCES().getBUYDOWNOCCURRENCE().getBuydownInitialEffectiveInterestRatePercent().getValue().toPlainString()))
		//text4_2 = DEAL.LOANS.LOAN.BUYDOWN.BUYDOWN_OCCURRENCES.BUYDOWN_OCCURRENCE.BuydownInitialEffectiveInterestRatePercent['__text'];
			text4_2 = deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNOCCURRENCES().getBUYDOWNOCCURRENCE().getBuydownInitialEffectiveInterestRatePercent().getValue().toPlainString() + "%";
		//DEAL.LOANS.LOAN.TERMS_OF_LOAN.DisclosedFullyIndexedRatePercent['__text']).equals("")
		}
		else if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getDisclosedFullyIndexedRatePercent())
			text4_2 = deal.getLOANS().getLOAN().getTERMSOFLOAN().getDisclosedFullyIndexedRatePercent().getValue().toPlainString() + "%";
		else if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getWeightedAverageInterestRatePercent())
			text4_2 = deal.getLOANS().getLOAN().getTERMSOFLOAN().getWeightedAverageInterestRatePercent().getValue().toPlainString() + "%";
		else
			//DEAL.LOANS.LOAN.TERMS_OF_LOAN.NoteRatePercent['__text'])
			text4_2 = deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteRatePercent().getValue().toPlainString() + "%";
		loanTermsInterestRate.setInterest(text4_2);
		
		//Adjustable Rate AIR message
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getInterestRateIncreaseIndicator().isValue())
		{
			loanTermsInterestRate.setStatus("YES");
			
			List<INTERESTRATEPERCHANGEADJUSTMENTRULE> interestrateperchangeadjustmentrules = deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATEPERCHANGEADJUSTMENTRULES().getINTERESTRATEPERCHANGEADJUSTMENTRULE();
			interestrateperchangeadjustmentrules.forEach(interestrateperchangeadjustmentrule ->{
				/*if("DDOFileNumber".equalsIgnoreCase(message.getABOUTVERSIONS().getABOUTVERSION().getAboutVersionIdentifier().getValue()))
				{
					text4_2_2 = Integer.toString(interestrateperchangeadjustmentrule.getPerChangeRateAdjustmentFrequencyMonthsCount().getValue());
				}
				else
				{*/
					//"First".equalsIgnoreCase(DEAL.LOANS.LOAN.ADJUSTMENT.INTEREST_RATE_ADJUSTMENT.INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULES.INTEREST_RATE_PER_CHANGE_ADJUSTMENT_RULE.AdjustmentRuleType['__text'])
					if("First".equalsIgnoreCase(interestrateperchangeadjustmentrule.getAdjustmentRuleType().getValue().value()))
					{
						text4_2_2 = Integer.toString(interestrateperchangeadjustmentrule.getPerChangeRateAdjustmentFrequencyMonthsCount().getValue());
					}
				//}
			});
		//StringFormatter.ROUNDUPYEARS.formatString(DEAL.LOANS.LOAN.ADJUSTMENT.INTEREST_RATE_ADJUSTMENT.INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE.FirstRateChangeMonthsCount['__text']
		text4_2_2 = StringFormatter.YEARS.formatString(text4_2_2);
		List<String> detail = new LinkedList<>();
			detail.add("Adjusts <b>every "+ ("1".equals(text4_2_2) ? "year" : (text4_2_2 + " years") +"</b> starting in year "+ StringFormatter.ROUNDUPYEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getFirstRateChangeMonthsCount().getValue()))));
			detail.add("Can go <b>as high as " + StringFormatter.PERCENT.formatString(deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getCeilingRatePercent().getValue().toPlainString())+"</b> in year "+StringFormatter.YEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getCeilingRatePercentEarliestEffectiveMonthsCount().getValue())));
			detail.add("See <b>AIR Table on page 4</b> for details");
		loanTermsInterestRate.setDetails(detail);
		}
		else
		{
			loanTermsInterestRate.setStatus("NO");
		}
		
		LoanTermsPI loanTermsPI = new LoanTermsPI();
		
		String frequency = "";
		String principalAmount = "";
		List<String> piDetails = new LinkedList<>();
		//DEAL.LOANS.LOAN.PAYMENT.PAYMENT_RULE.PaymentFrequencyType['__text']).equalsIgnoreCase("")
		if(null != deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType())
		{
			frequency = deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().getValue().value();
		}
		
		//DEAL.LOANS.LOAN.PAYMENT.PAYMENT_RULE.InitialPrincipalAndInterestPaymentAmount['__text']).equalsIgnoreCase("")
		if(null != deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getInitialPrincipalAndInterestPaymentAmount())
			principalAmount = deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getInitialPrincipalAndInterestPaymentAmount().getValue().toPlainString();
		if(!"".equalsIgnoreCase(principalAmount))
			principalAmount = StringFormatter.NODOLLARS.formatString(principalAmount);
		else
			principalAmount = StringFormatter.NODOLLARS.formatString(deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getFullyIndexedInitialPrincipalAndInterestPaymentAmount().getValue().toPlainString());
		
		//DEAL.LOANS.LOAN.LOAN_DETAIL.PaymentIncreaseIndicator['__text']).equalsIgnoreCase("true")
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getPaymentIncreaseIndicator().isValue())
		{
			loanTermsPI.setStatus("YES");
			String adjustment = "";
			List<PRINCIPALANDINTERESTPAYMENTPERCHANGEADJUSTMENTRULE> principalandinterestpaymentperchangeadjustmentrules = deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTPERCHANGEADJUSTMENTRULES().getPRINCIPALANDINTERESTPAYMENTPERCHANGEADJUSTMENTRULE();
			
			for(PRINCIPALANDINTERESTPAYMENTPERCHANGEADJUSTMENTRULE principalandinterestpaymentperchangeadjustmentrule : principalandinterestpaymentperchangeadjustmentrules)
			{
				if("First".equalsIgnoreCase(principalandinterestpaymentperchangeadjustmentrule.getAdjustmentRuleType().getValue().value()))
				{
					adjustment = Integer.toString(principalandinterestpaymentperchangeadjustmentrule.getPerChangePrincipalAndInterestPaymentAdjustmentFrequencyMonthsCount().getValue());
					break;
				}
			}
			String text4_3_1 ="";
			String years = StringFormatter.YEARS.formatString(adjustment);
			//DEAL.LOANS.LOAN.LOAN_DETAIL.InterestRateIncreaseIndicator['__text']).equalsIgnoreCase("true")
			if(deal.getLOANS().getLOAN().getLOANDETAIL().getInterestRateIncreaseIndicator().isValue())
			{
				text4_3_1 = "Adjusts <b>every " + ("1".equals(years) ? "year" : (years + " years"))+"</b> starting in year ";
				//DEAL.LOANS.LOAN.ADJUSTMENT.PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT.PRINCIPAL_AND_INTEREST_PAYMENT_LIFETIME_ADJUSTMENT_RULE.FirstPrincipalAndInterestPaymentChangeMonthsCount['__text']
				text4_3_1 = text4_3_1 + StringFormatter.ROUNDUPYEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getFirstPrincipalAndInterestPaymentChangeMonthsCount().getValue()));
				piDetails.add(text4_3_1);
//String maxAmount = DEAL.LOANS.LOAN.ADJUSTMENT.PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT.PRINCIPAL_AND_INTEREST_PAYMENT_LIFETIME_ADJUSTMENT_RULE.PrincipalAndInterestPaymentMaximumAmount['__text'];
				String maxAmount = deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getPrincipalAndInterestPaymentMaximumAmount().getValue().toPlainString();
				if (!("").equals(maxAmount))
				{
					text4_3_1 ="Can go <b>as high as " + StringFormatter.NODOLLARS.formatString(maxAmount) +"</b> in year ";
//StringFormatter.ROUNDUPYEARS.formatString(DEAL.LOANS.LOAN.ADJUSTMENT.PRINCIPAL_AND_INTEREST_PAYMENT_ADJUSTMENT.PRINCIPAL_AND_INTEREST_PAYMENT_LIFETIME_ADJUSTMENT_RULE.PrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount['__text'])),
					text4_3_1 = text4_3_1 + StringFormatter.ROUNDUPYEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTADJUSTMENT().getPRINCIPALANDINTERESTPAYMENTLIFETIMEADJUSTMENTRULE().getPrincipalAndInterestPaymentMaximumAmountEarliestEffectiveMonthsCount().getValue()));
					piDetails.add(text4_3_1);
				}
				if(deal.getLOANS().getLOAN().getLOANDETAIL().getInterestOnlyIndicator().isValue())
				{
					text4_3_1 ="Includes <b>only interest</b> and <b>no principal</b> until ";
//StringFormatter.MONTHSORYEARS.formatString(DEAL.LOANS.LOAN.INTEREST_ONLY.InterestOnlyTermMonthsCount['__text'])),
					text4_3_1 = text4_3_1 + StringFormatter.MONTHSORYEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getINTERESTONLY().getInterestOnlyTermMonthsCount().getValue()));
					piDetails.add(text4_3_1);
					text4_3_1 = "See <b>AP Table on page 4</b>  for details";
					piDetails.add(text4_3_1);
					
				}
				loanTermsPI.setDetails(piDetails);
			}
			else
				loanTermsPI.setStatus("NO");
		}
		
		loanTermsPI.setPaymentFrequencyType(frequency);
		loanTermsPI.setAmount(principalAmount);
		
		LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty = new LoanTermsPrepaymentPenalty();
		List<String> prepaymentDetails = new LinkedList<>();
//DEAL.LOANS.LOAN.LOAN_DETAIL.PrepaymentPenaltyIndicator['__text']).equalsIgnoreCase("true")){
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getPrepaymentPenaltyIndicator().isValue())
		{
			loanTermsPrepaymentPenalty.setStatus("YES");
//StringFormatter.NODOLLARS.formatString(DEAL.LOANS.LOAN.PREPAYMENT_PENALTY.PREPAYMENT_PENALTY_LIFETIME_RULE.PrepaymentPenaltyMaximumLifeOfLoanAmount['__text']
			String para4_4_1 = "<b>As high as "+StringFormatter.NODOLLARS.formatString(deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE().getPrepaymentPenaltyMaximumLifeOfLoanAmount().getValue().toPlainString()+"</b> if you payoff the");
			prepaymentDetails.add(para4_4_1);
//StringFormatter.YEARS.formatString(closingMap.getClosingMapValue("PREPAYMENT_PENALTY_LIFETIME_RULE.PrepaymentPenaltyExpirationMonthsCount")) + " years"
			para4_4_1 = "loan during the first"+StringFormatter.YEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE().getPrepaymentPenaltyExpirationMonthsCount().getValue())) +" years";
			prepaymentDetails.add(para4_4_1);
			loanTermsPrepaymentPenalty.setDetails(prepaymentDetails);
		}
		else
			loanTermsPrepaymentPenalty.setStatus("NO");
		LoanTermsBalloonPayment loanTermsBalloonPayment = new LoanTermsBalloonPayment();
		List<String> bIndicatorDetails = new LinkedList<>();
		//DEAL.LOANS.LOAN.LOAN_DETAIL.BalloonIndicator['__text']
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonIndicator().isValue())
		{
			String para4_5_1 = "";
			para4_5_1 = "You will have to pay ";
			//DEAL.LOANS.LOAN.LOAN_DETAIL.BalloonPaymentAmount
			para4_5_1 = para4_5_1 + "<b>"+StringFormatter.NODOLLARS.formatString(deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonPaymentAmount().getValue().toPlainString())+"</b> at the end of ";
	//DEAL_SET.DEALS.DEAL.LOANS.LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodType['__text']).toLowerCase() 
	//LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodCount['__text'])
			para4_5_1 = para4_5_1 + deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodType().getValue().value().toLowerCase()+" "+ Integer.toString(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().getValue());
			bIndicatorDetails.add(para4_5_1);
			loanTermsBalloonPayment.setStatus("YES");
			loanTermsBalloonPayment.setDetails(bIndicatorDetails);
		}
		else
			loanTermsBalloonPayment.setStatus("NO");
			
		loanTerms.setLoanTermsLoanAmount(loanTermsLoanAmount);
		loanTerms.setLoanTermsInterestRate(loanTermsInterestRate);
		loanTerms.setLoanTermsPI(loanTermsPI);
		loanTerms.setLoanTermsPrepaymentPenalty(loanTermsPrepaymentPenalty);
		loanTerms.setLoanTermsBalloonPayment(loanTermsBalloonPayment);
		
		return loanTerms;
	}

	@Override
	public ProjectedPayments createProjectedPayments(DOCUMENT document) {
		
		ProjectedPayments projectedPayments = new ProjectedPayments();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		List<String> projectedPaymentsPaymentCalculation = new LinkedList<>();
		List<ProjectedPaymentsPI> projectedPaymentsPrincipalInterest = new LinkedList<>();
		List<String> projectedPaymentsMortgageInsurance = new LinkedList<>();
		List<String> projectedPaymentsEstimatedEscrow = new LinkedList<>();
		List<String> projectedPaymentsEstimatedTotalPayment = new LinkedList<>();
		String projectedPaymentsEstimatedTotalPaymentType = "";
		
		int column = 1;
		boolean everMI = false;
		boolean everEscrow = false;
		List<PROJECTEDPAYMENT> projectedpayments2 = deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getPROJECTEDPAYMENTS().getPROJECTEDPAYMENT();
			for(PROJECTEDPAYMENT projectedpayment :projectedpayments2)
			{
				StringFormatter format = StringFormatter.NODOLLARS;
				if (column == 1 || null != projectedpayment.getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount())
					format = StringFormatter.NODOLLARS;
				
				// Print date range
				if ("FinalPayment".equalsIgnoreCase(projectedpayment.getProjectedPaymentCalculationPeriodTermType().getValue().value())){
					projectedPaymentsPaymentCalculation.add("Final Payment");
				} else {
					String startYear = projectedpayment.getProjectedPaymentCalculationPeriodStartNumber().getValue().toPlainString();
					String endYear = projectedpayment.getProjectedPaymentCalculationPeriodEndNumber().getValue().toPlainString();
					if (startYear.equals(endYear))
						projectedPaymentsPaymentCalculation.add("Year " + startYear);
					else
						projectedPaymentsPaymentCalculation.add("Years " + startYear + "-" + endYear);
				}
				
				//5.2 Principal and Interest
				boolean interestOnly = false;
				String monthscount  = Integer.toString(null != deal.getLOANS().getLOAN().getINTERESTONLY() ? deal.getLOANS().getLOAN().getINTERESTONLY().getInterestOnlyTermMonthsCount().getValue() : 0);
				int interestOnlyTermMonthsCount = 0;
				if(null != monthscount && !"".equalsIgnoreCase(monthscount)){
					interestOnlyTermMonthsCount = Integer.parseInt(monthscount);
				}
				
				projectedPaymentsEstimatedTotalPaymentType = projectedpayment.getPaymentFrequencyType().getValue().value();
				
				// Calculate interest only flag
				interestOnly = deal.getLOANS().getLOAN().getLOANDETAIL().getInterestOnlyIndicator().isValue();
				if (!interestOnly) {
					try {
						int startYear = Integer.parseInt(projectedpayment.getProjectedPaymentCalculationPeriodStartNumber().getValue().toPlainString());
			            if((startYear-1)*12 < interestOnlyTermMonthsCount && deal.getLOANS().getLOAN().getLOANDETAIL().getInterestOnlyIndicator().isValue()) 
			            	interestOnly = true;
					} catch (Exception e) {
						// do nothing
					}
				}
				
				String min = format.formatString((null != projectedpayment.getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount()) ? projectedpayment.getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount().getValue().toPlainString():"0");
				String max = format.formatString((null != projectedpayment.getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount()) ? projectedpayment.getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount().getValue().toPlainString():"0");
				if(column >1 && !"0".equals(min))
				{
					ProjectedPaymentsPI projectedPaymentsPI = projectedPayments.new ProjectedPaymentsPI();
					if(interestOnly)
					{
						projectedPaymentsPI.setMinValue(min);
						projectedPaymentsPI.setMaxValue(max);
						projectedPaymentsPI.setInterestOnly("<i>interestonly</i>");
						projectedPaymentsPrincipalInterest.add(projectedPaymentsPI);
					}
						else
					{
							projectedPaymentsPI.setMinValue(min);
							projectedPaymentsPI.setMaxValue(max);
							projectedPaymentsPrincipalInterest.add(projectedPaymentsPI);
					}
					
				}
				else
				{
					ProjectedPaymentsPI projectedPaymentsPI2 = projectedPayments.new ProjectedPaymentsPI();
					if(interestOnly)
					{
						projectedPaymentsPI2.setMinValue(min);
						projectedPaymentsPI2.setMaxValue(max);
						projectedPaymentsPI2.setInterestOnly("<i>interestonly</i>");
						projectedPaymentsPrincipalInterest.add(projectedPaymentsPI2);
					}
					else
					{
						projectedPaymentsPI2.setMinValue(min);
						projectedPaymentsPI2.setMaxValue(max);
						projectedPaymentsPrincipalInterest.add(projectedPaymentsPI2);
					}
				}
				//5.3 (MI)
				float value = (null == projectedpayment.getProjectedPaymentMIPaymentAmount()) ? 0.0f : Float.parseFloat(projectedpayment.getProjectedPaymentMIPaymentAmount().getValue().toPlainString());
				String valueStr = "";
				if (value != 0)
					everMI = true;
				if (everMI && value == 0)
					valueStr = "-----";
				else {
					if (value == 0)
						valueStr = "0";
					else
						valueStr = StringFormatter.NODOLLARS.formatString(String.valueOf(value));
				}
				projectedPaymentsMortgageInsurance.add(valueStr);
				
				//5.4 (Escrow)
				value = null == projectedpayment.getProjectedPaymentEstimatedEscrowPaymentAmount() ? 0.0f : Float.parseFloat(projectedpayment.getProjectedPaymentEstimatedEscrowPaymentAmount().getValue().toPlainString());
				valueStr = "";
				if (value != 0)
					everEscrow = true;
				if (everEscrow && value == 0)
					valueStr = "-----";
				else {
					if (value == 0)
						valueStr = "0";
					else
						valueStr = StringFormatter.NODOLLARS.formatString(String.valueOf(value));
				}
				projectedPaymentsEstimatedEscrow.add(valueStr);
				
				//5.5+9
				String str = "";
				min = format.formatString(null != projectedpayment.getProjectedPaymentEstimatedTotalMinimumPaymentAmount() ? projectedpayment.getProjectedPaymentEstimatedTotalMinimumPaymentAmount().getValue().toPlainString() : "0");
				max = format.formatString(null != projectedpayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount() ? projectedpayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount().getValue().toPlainString() : "0");
				
				if (!min.equals("0")) {
					 str = min+ " - " + max;
				} else {
					 str = max;
				}
				projectedPaymentsEstimatedTotalPayment.add(str);
				column++;
			}
			
			projectedPayments.setProjectedPaymentsPaymentCalculation(projectedPaymentsPaymentCalculation);
			projectedPayments.setProjectedPaymentsPrincipalInterest(projectedPaymentsPrincipalInterest);
			projectedPayments.setProjectedPaymentsMortgageInsurance(projectedPaymentsMortgageInsurance);
			projectedPayments.setProjectedPaymentsEstimatedEscrow(projectedPaymentsEstimatedEscrow);
			projectedPayments.setProjectedPaymentsEstimatedTotalPayment(projectedPaymentsEstimatedTotalPayment);
			projectedPayments.setProjectedPaymentsEstimatedTotalPaymentType(projectedPaymentsEstimatedTotalPaymentType);
			projectedPayments.setProjectedPaymentsETIA(createProjectedPaymentsETIA());
			
		return projectedPayments;
	}

	@Override
	public CostsAtClosing createCostsAtClosing(DOCUMENT document) {

		CostsAtClosing costsAtClosing = new CostsAtClosing();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		CostsAtClosingClosingCosts costsAtClosingClosingCosts = new CostsAtClosingClosingCosts();
		CostsAtClosingCashToClose costsAtClosingCashToClose = new CostsAtClosingCashToClose();
		List<String> closingCostsDetails = new LinkedList<>();
		List<String> cashToCloseDetails = new LinkedList<>();
		String totalLoanCosts = "";
		String totalOtherCosts = "";
		String lenderCredits = "";
		//StringFormatter.NODOLLARS.formatString(	DEAL.LOANS.LOAN.DOCUMENT_SPECIFIC_DATA_SETS.DOCUMENT_SPECIFIC_DATA_SET.INTEGRATED_DISCLOSURE.INTEGRATED_DISCLOSURE_SECTION_SUMMARIES.INTEGRATED_DISCLOSURE_SECTION_SUMMARY.INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL.TotalClosingCosts['__text']), SUMMARY_AMOUNT));
		
		     Map<String,String> integratedDisclosureSectionTypeValues = Convertor.getIntegratedDisclosureSectionTypes(document);		       
				costsAtClosingClosingCosts.setAmount(integratedDisclosureSectionTypeValues.get("TotalClosingCosts"));
				totalLoanCosts = integratedDisclosureSectionTypeValues.get("TotalLoanCosts");
				if(null == totalLoanCosts || totalLoanCosts.isEmpty())
					totalLoanCosts = "0";
				
				totalOtherCosts = integratedDisclosureSectionTypeValues.get("TotalOtherCosts");
				if(null == totalOtherCosts || totalOtherCosts.isEmpty())
					totalOtherCosts = "0";
			
				lenderCredits = StringFormatter.NODOLLARS.formatString(Convertor.getLenderCredits("LenderCredits", document));
				if(null == lenderCredits || lenderCredits.isEmpty())
					lenderCredits = "0";
		
		closingCostsDetails.add("Includes "+totalLoanCosts+" in Loan Costs + "+totalOtherCosts+" in Other Costs -"+lenderCredits);
		closingCostsDetails.add("in Lender Credits. <i>See page 2 for details.</i>");
		costsAtClosingClosingCosts.setDetails(closingCostsDetails);
		
		//6.2
		//DEAL.LOANS.LOAN.CLOSING_INFORMATION.CLOSING_INFORMATION_DETAIL.CashFromBorrowerAtClosingAmount
		if(null != deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getCashFromBorrowerAtClosingAmount())
			costsAtClosingCashToClose.setAmount(StringFormatter.NODOLLARS.formatString(deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getCashFromBorrowerAtClosingAmount().getValue().toPlainString()));
		else if(null != deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getCashToBorrowerAtClosingAmount())
			if(DocumentType.isStandardView(document))
				costsAtClosingCashToClose.setAmount(StringFormatter.NODOLLARS.formatString(deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getCashToBorrowerAtClosingAmount().getValue().toPlainString()));
			else
				costsAtClosingCashToClose.setAmount(StringFormatter.NODOLLARS.formatString(deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getCashToBorrowerAtClosingAmount().getValue().toPlainString()));
		
		if(DocumentType.isStandardView(document))
		{
			costsAtClosingCashToClose.setDocType("true");
			if(null != deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getCashFromBorrowerAtClosingAmount())
				costsAtClosingCashToClose.setFromType("true");
				else if(null != deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getCashToBorrowerAtClosingAmount())
					costsAtClosingCashToClose.setToType("true");	
		}
		cashToCloseDetails.add("Includes Closing Costs. <i>See Calculating Cash to Close on page 3 for details.</i>");
		costsAtClosingCashToClose.setDetails(cashToCloseDetails);
		
		costsAtClosing.setCostsAtClosingClosingCosts(costsAtClosingClosingCosts);
		costsAtClosing.setCostsAtClosingCashToClose(costsAtClosingCashToClose);
		return costsAtClosing;
	}
	
	private ProjectedPaymentsETIA createProjectedPaymentsETIA()
	{
		ProjectedPaymentsETIA projectedPaymentsETIA = new ProjectedPaymentsETIA();
		
		// Count escrows
		int countPIYes = 0 ;
		int countPINo = 0 ;
		int countPISome = 0;
		int countHIYes = 0 ;
		int countHINo = 0 ;
		int countHISome = 0;
		int countOtherYes = 0 ;
		int countOtherNo = 0 ;
		int countOtherSome = 0;
		String otherStr = "";
		
		String etia = deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getESTIMATEDPROPERTYCOST().getESTIMATEDPROPERTYCOSTDETAIL().getProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount().getValue().toPlainString();
		
		if(null != deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getESTIMATEDPROPERTYCOST().getESTIMATEDPROPERTYCOSTCOMPONENTS())
		{
			List<ESTIMATEDPROPERTYCOSTCOMPONENT> estimatedpropertycostcomponents = deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getESTIMATEDPROPERTYCOST().getESTIMATEDPROPERTYCOSTCOMPONENTS().getESTIMATEDPROPERTYCOSTCOMPONENT();
			for (ESTIMATEDPROPERTYCOSTCOMPONENT estimatedpropertycostcomponent:estimatedpropertycostcomponents) {
				switch (estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().getValue().value()) {
				case "PropertyTaxes":
					if ("Escrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countPIYes++;
					else if ("NotEscrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countPINo++;
					else if ("SomeEscrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countPISome++;
					break;
				case "HomeownersInsurance":
					if ("Escrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countHIYes++;
					else if ("NotEscrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countHINo++;
					else if ("SomeEscrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countHISome++;
					break;
				default: // All other escrows go here
				    if("".equalsIgnoreCase(otherStr))
				    	otherStr = StringFormatter.STRINGCLEAN.formatString(estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription().getValue());
					if ("Escrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countOtherYes++;
					else if ("NotEscrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countOtherNo++;
					else if ("SomeEscrowed".equals(estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().getValue().value()))
						countOtherSome++;
					break;
				}
			}
		}
		
//DEAL.LOANS.LOAN.DOCUMENT_SPECIFIC_DATA_SETS.DOCUMENT_SPECIFIC_DATA_SET.INTEGRATED_DISCLOSURE.PROJECTED_PAYMENTS.PROJECTED_PAYMENT.PaymentFrequencyType
		String str = "";
		switch(deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getPROJECTEDPAYMENTS().getPROJECTEDPAYMENT().get(0).getPaymentFrequencyType().getValue().value()){
			
		case "Monthly":
			str = "a month";
			break;
		case "AtMaturity":
			str = "at maturity";
			break;
		case "Biweekly":
			str = "a bi week";
			break;
		case "Quarterly":
			str = "a quarter";
			break;
		case "Semiannual":
			str = "a semiannual";
			break;
		case "Semimonthly":
			str = "a semimonth";
			break;
		case "Weekly":
			str = "a week";
		}
		
		projectedPaymentsETIA.setAmount(StringFormatter.NODOLLARS.formatString(etia));
		projectedPaymentsETIA.setFrequencyType(str);
		projectedPaymentsETIA.setPropertyTaxesStatus(hasCost(countPIYes, countPINo, countPISome) ? "true" : "false");
		projectedPaymentsETIA.setHomeownersInsuranceStatus(hasCost(countHIYes, countHINo, countHISome) ? "true" : "false");
		projectedPaymentsETIA.setOtherStatus(hasCost(countOtherYes, countOtherNo, countOtherSome) ? "true" : "false");
		projectedPaymentsETIA.setPropertyTaxesInEscrow(inEscrowText(countPIYes, countPINo, countPISome));
		projectedPaymentsETIA.setHomeownersInsuranceInEscrow(inEscrowText(countHIYes, countHINo, countHISome));
		projectedPaymentsETIA.setOtherInEscrow(inEscrowText(countOtherYes, countOtherNo, countOtherSome));
		projectedPaymentsETIA.setOtherDescription(otherStr);
		
		return projectedPaymentsETIA;
	}
	
	private boolean hasCost(int countYes, int countNo, int countSome) {
		return countYes > 0 || countNo > 0 || countSome > 0;
	}
	
	private String inEscrowText(int countYes, int countNo, int countSome) {
		if (countSome > 0 || countYes > 0 && countNo > 0)
			return "SOME";
		if (countYes > 0)
			return "YES";
		if (countNo > 0)
			return "NO";
		return "";
	}

}
