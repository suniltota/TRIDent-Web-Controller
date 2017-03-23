package com.actualize.mortgage.services.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mismo.residential._2009.schemas.ADDRESS;
import org.mismo.residential._2009.schemas.AddressBase;
import org.mismo.residential._2009.schemas.AddressUnitDesignatorBase;
import org.mismo.residential._2009.schemas.COLLATERAL;
import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.ESTIMATEDPROPERTYCOSTCOMPONENT;
import org.mismo.residential._2009.schemas.INTEGRATEDDISCLOSURESECTIONSUMMARY;
import org.mismo.residential._2009.schemas.INTEGRATEDDISCLOSURESUBSECTIONPAYMENT;
import org.mismo.residential._2009.schemas.INTERESTRATEPERCHANGEADJUSTMENTRULE;
import org.mismo.residential._2009.schemas.LOANIDENTIFIER;
import org.mismo.residential._2009.schemas.LoanPurposeBase;
import org.mismo.residential._2009.schemas.MortgageBase;
import org.mismo.residential._2009.schemas.PARTY;
import org.mismo.residential._2009.schemas.PRINCIPALANDINTERESTPAYMENTPERCHANGEADJUSTMENTRULE;
import org.mismo.residential._2009.schemas.PROJECTEDPAYMENT;
import org.mismo.residential._2009.schemas.PartyRoleBase;
import org.mismo.residential._2009.schemas.PaymentFrequencyBase;
import org.mismo.residential._2009.schemas.ProjectedPaymentCalculationPeriodTermBase;
import org.mismo.residential._2009.schemas.ProjectedPaymentEscrowedBase;
import org.mismo.residential._2009.schemas.ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase;
import org.mismo.residential._2009.schemas.TERMSOFLOAN;

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
import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.domainmodels.PDFDocument;
import com.actualize.mortgage.domainmodels.ProjectedPayments;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsETIA;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPI;
import com.actualize.mortgage.domainmodels.Seller;
import com.actualize.mortgage.services.PageOneMappingService;
import com.actualize.mortgage.utils.Convertor;
import com.actualize.mortgage.utils.DocumentType;
import com.actualize.mortgage.utils.PopulateData;
import com.actualize.mortgage.utils.StringFormatter;

public class PageOneMappingServiceImpl  implements PageOneMappingService{

	DEAL deal = null;

	Address property = new Address();
	Convertor convertor = new Convertor();
	
	String loanId = "";
	String loanMic = "";
	String text4_2_2 = "";
	
	@Override
	public DOCUMENT mapClosingInformation(DOCUMENT document, PDFDocument pdfDocument) {
		
		ClosingInformation closingInformation = pdfDocument.getPageOne().getClosingInformation();
		String dateIssued = closingInformation.getDateIssued();
		String closingDate = closingInformation.getClosingDate();
		String disbursementDate = closingInformation.getDisbursementDate();
		String settlementAgent = closingInformation.getSettlementAgent();
		String fileNo = closingInformation.getFileNo();
		ADDRESS mismoAddress = new ADDRESS(); 
		Address jsonAddress = closingInformation.getProperty(); 
		
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		if(null != dateIssued)
		deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureIssuedDate().setValue(dateIssued);
		if(null != closingDate)
		deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingDate().setValue(closingDate);
		if(null != disbursementDate)
		deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getDisbursementDate().setValue(disbursementDate);
		if(null != fileNo)
		deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingAgentOrderNumberIdentifier().setValue(fileNo);
		
		List<COLLATERAL> collaterals = deal.getCOLLATERALS().getCOLLATERAL();
		for(COLLATERAL collateral : collaterals)
		{
			 mismoAddress = collateral.getSUBJECTPROPERTY().getADDRESS();
			 
			if(null != mismoAddress)
			{
				if(null != jsonAddress.getAddressLineText() && !"".equalsIgnoreCase(jsonAddress.getAddressLineText()))
					mismoAddress.getAddressLineText().setValue(jsonAddress.getAddressLineText());
				if(null != jsonAddress.getAddressType() && !"".equalsIgnoreCase(jsonAddress.getAddressType()))
					mismoAddress.getAddressType().setValue(AddressBase.fromValue(String.valueOf(jsonAddress.getAddressType())));
				if(null != jsonAddress.getAddressUnitDesignatorType() && !"".equalsIgnoreCase(jsonAddress.getAddressUnitDesignatorType()))
					mismoAddress.getAddressUnitDesignatorType().setValue(AddressUnitDesignatorBase.fromValue(jsonAddress.getAddressUnitDesignatorType()));
				if(null != jsonAddress.getAddressUnitIdentifier() && !"".equalsIgnoreCase(jsonAddress.getAddressUnitIdentifier()))
					mismoAddress.getAddressUnitIdentifier().setValue(jsonAddress.getAddressUnitIdentifier());
				if(null != jsonAddress.getCityName() && !"".equalsIgnoreCase(jsonAddress.getCityName()))
					mismoAddress.getCityName().setValue(jsonAddress.getCityName());
				if(null != jsonAddress.getCountryCode() && !"".equalsIgnoreCase(jsonAddress.getCountryCode()))
					mismoAddress.getCountryCode().setValue(jsonAddress.getCountryCode());
				if(null != jsonAddress.getPostalCode() && !"".equalsIgnoreCase(jsonAddress.getPostalCode()))
					mismoAddress.getPostalCode().setValue(jsonAddress.getPostalCode());
				if(null != jsonAddress.getStateCode() && !"".equalsIgnoreCase(jsonAddress.getStateCode()))
					mismoAddress.getStateCode().setValue(jsonAddress.getStateCode());
				
			}
			
		}
		
		List<PARTY> parties = deal.getPARTIES().getPARTY();
		parties.forEach(party ->{
			if(null != party.getROLES())
			{
				if(null != party.getROLES().getROLE().getROLEDETAIL())
					if(PartyRoleBase.CLOSING_AGENT == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
						if(null != party.getLEGALENTITY())
							party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().setValue(settlementAgent);
			}
		});
		
		
		
		
		if(LoanPurposeBase.PURCHASE == deal.getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue())
		{
			collaterals.forEach(collateral ->{
				if(!"".equals(closingInformation.getSalePrice()))
						collateral.getSUBJECTPROPERTY().getSALESCONTRACTS().getSALESCONTRACT().getSALESCONTRACTDETAIL().getSalesContractAmount().setValue(new BigDecimal(closingInformation.getSalePrice().replaceAll(",", "")));
			});
		}
		
		document.getDEALSETS().getDEALSET().getDEALS().setDEAL(deal);
		return document;
	}

	@Override
	public DOCUMENT mapLoanInformation(DOCUMENT document, PDFDocument pdfDocument) {

		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		LoanInformation loanInformation = pdfDocument.getPageOne().getLoanInformation();
		String loanTotalTerm = loanInformation.getLoanTerm();
		String loanPurpose = loanInformation.getPurpose();
		String loanProduct = loanInformation.getProduct();
		String loanType = loanInformation.getLoanType();
		loanId = loanInformation.getLoanId();
		loanMic = loanInformation.getMic();
		int loanterm = convertor.convertYearsToMonthsFormat(loanTotalTerm);
		
		//Loan Terms
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getConstructionLoanIndicator().isValue() && "ConstructionToPermanent".equalsIgnoreCase(deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanType().getValue().value()))
		{
			loanterm = convertor.convertYearsToMonthsFormat(loanTotalTerm);
			deal.getLOANS().getLOAN().getCONSTRUCTION().getConstructionLoanTotalTermMonthsCount().setValue(loanterm);
		}
		else if("Year".equalsIgnoreCase(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodType().getValue().value()))
		{
			loanterm = convertor.convertYearsToMonthsFormat(loanTotalTerm);
			deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().setValue(loanterm);
		}
		else if("Month".equalsIgnoreCase(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodType().getValue().value()) && !"".equalsIgnoreCase(Integer.toString(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().getValue())))
		{
			loanterm = convertor.convertYearsToMonthsFormat(loanTotalTerm);
			deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().setValue(loanterm);
		}
		

		//Loan Purpose
		if(null != loanPurpose && !"".equalsIgnoreCase(loanPurpose)){
			//termsofloan.getLoanPurposeType().setValue(LoanPurposeBase.fromValue(loanPurpose));
		}
		
		/*if(("Purchase").equalsIgnoreCase(deal.getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue().value()))
		    termsofloan.getLoanPurposeType().setValue(LoanPurposeBase.fromValue("Purchase"));
		else if(("true").equalsIgnoreCase(deal.getLOANS().getLOAN().getLOANDETAIL().getConstructionLoanIndicator().getLabel()))
	        termsofloan.getLoanPurposeType().setValue(loanPurpose == null ? LoanPurposeBase.fromValue(null) : LoanPurposeBase.fromValue("Construction"));
		else if(("true").equalsIgnoreCase(deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureHomeEquityLoanIndicator().getLabel()))
	        termsofloan.getLoanPurposeType().setValue(loanPurpose == null ? LoanPurposeBase.fromValue(null) : LoanPurposeBase.fromValue("Home Equity Loan"));
		else
	        termsofloan.getLoanPurposeType().setValue(loanPurpose == null ? LoanPurposeBase.fromValue(null) : LoanPurposeBase.fromValue("Refinance"));
		*/
		
		//Loan Product    
		deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureLoanProductDescription().setValue(loanProduct);
		//Loan Type
		if(null != loanType && !"".equalsIgnoreCase(loanType)){
			//termsofloan.getMortgageType().setValue(loanType == null ? MortgageBase.fromValue(String.valueOf(null)) : MortgageBase.fromValue(String.valueOf(loanType)));
		}
		//Loan Id	
		List<LOANIDENTIFIER> loanidentifiers = deal.getLOANS().getLOAN().getLOANIDENTIFIERS().getLOANIDENTIFIER();
		loanidentifiers.forEach(loanidentifier ->{
			if("LenderLoan".equalsIgnoreCase(loanidentifier.getLoanIdentifierType().getValue().value()))
				loanidentifier.getLoanIdentifier().setValue(loanId);
		});
		//Loan Mic
		if(deal.getLOANS().getLOAN().getLOANDETAIL().getMIRequiredIndicator().isValue())
			if("Conventional".equalsIgnoreCase(deal.getLOANS().getLOAN().getTERMSOFLOAN().getMortgageType().getValue().value()))
				deal.getLOANS().getLOAN().getMIDATA().getMIDATADETAIL().getMICertificateIdentifier().setValue(loanMic);
			else
			{
				loanidentifiers.forEach(loanidentifier ->{
					if("AgencyCase".equalsIgnoreCase(loanidentifier.getLoanIdentifier().getValue()))
						loanidentifier.getLoanIdentifier().setValue(loanMic);
				});
			}
		
		
        document.getDEALSETS().getDEALSET().getDEALS().setDEAL(deal);
		return document;
	}

	@Override
	public DOCUMENT mapTransactionInformation(DOCUMENT document, PDFDocument pdfDocument) {
		
		//TransactionInformation transactionInformation = new TransactionInformation();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		List<PARTY> parties = deal.getPARTIES().getPARTY();
		int borrowerNo = 0;
		int sellerNo = 0;
		int lenderNo = 0;
		List<Borrower> borrowers = pdfDocument.getPageOne().getTransactionInformation().getBorrower();
		List<Seller> sellers = pdfDocument.getPageOne().getTransactionInformation().getSeller();
		List<Lender> lenders = pdfDocument.getPageOne().getTransactionInformation().getLender();
		for(PARTY party : parties){
			if(null != party.getROLES())
			{
				if(null != party.getROLES().getROLE().getROLEDETAIL())
				{
					if( PartyRoleBase.BORROWER == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
					{
						if(null != party.getLEGALENTITY() && "O".equalsIgnoreCase(borrowers.get(borrowerNo).getType()))
						{
					
							String bName = borrowers.get(borrowerNo).getNameModel().getFirstName();
							party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().setValue(bName);
							
							Address bproperty = borrowers.get(borrowerNo).getAddress();
							ADDRESS bAddress = null;
							if(null != party.getADDRESSES())
								bAddress = party.getADDRESSES().getADDRESS();
							
							if(null != bproperty.getAddressLineText() && !"".equalsIgnoreCase(bproperty.getAddressLineText()))
								bAddress.getAddressLineText().setValue(bproperty.getAddressLineText());
							/*if(null != bproperty.getAddressType() && !"".equalsIgnoreCase(bproperty.getAddressType()))
								bAddress.getAddressType().setValue(bproperty.getAddressType()== null ? AddressBase.fromValue(null) : AddressBase.fromValue(bproperty.getAddressType()));
							bAddress.getAddressUnitDesignatorType().setValue(bproperty.getAddressUnitDesignatorType() == null ? AddressUnitDesignatorBase.fromValue(null) : AddressUnitDesignatorBase.fromValue(bproperty.getAddressUnitDesignatorType()));
							bAddress.getAddressUnitIdentifier().setValue(bproperty.getAddressUnitIdentifier()== null ? "" :bproperty.getAddressUnitIdentifier());*/
							if(null != bproperty.getCityName() && !"".equalsIgnoreCase(bproperty.getCityName()))
								bAddress.getCityName().setValue(bproperty.getCityName());
							if(null != bproperty.getCountryCode() && !"".equalsIgnoreCase(bproperty.getCountryCode()))
								bAddress.getCountryCode().setValue(bproperty.getCountryCode());
							if(null != bproperty.getPostalCode() && !"".equalsIgnoreCase(bproperty.getPostalCode()))
								bAddress.getPostalCode().setValue(bproperty.getPostalCode());
							if(null != bproperty.getStateCode() && !"".equalsIgnoreCase(bproperty.getStateCode()))
								bAddress.getStateCode().setValue(bproperty.getStateCode());
							borrowerNo++;
						}
						else if(null != party.getINDIVIDUAL() && "I".equalsIgnoreCase(borrowers.get(borrowerNo).getType()))
						{
							NameModel name = borrowers.get(borrowerNo).getNameModel();
							
							if(null != name.getFirstName() && null != party.getINDIVIDUAL().getNAME().getFirstName())
								party.getINDIVIDUAL().getNAME().getFirstName().setValue(name.getFirstName());
							if(null != name.getLastName() && null != party.getINDIVIDUAL().getNAME().getLastName())
								party.getINDIVIDUAL().getNAME().getLastName().setValue(name.getLastName());
							if(null != name.getMiddleName() && null != party.getINDIVIDUAL().getNAME().getMiddleName())
								party.getINDIVIDUAL().getNAME().getMiddleName().setValue(name.getMiddleName());
							if(null != name.getSuffixName() && null != party.getINDIVIDUAL().getNAME().getSuffixName())
								party.getINDIVIDUAL().getNAME().getSuffixName().setValue(name.getSuffixName());
							
							Address bproperty = borrowers.get(borrowerNo).getAddress();
							ADDRESS bAddress = null;
							if(null != party.getADDRESSES())
								bAddress = party.getADDRESSES().getADDRESS();
							
							if(null != bproperty.getAddressLineText() && !"".equalsIgnoreCase(bproperty.getAddressLineText()))
								bAddress.getAddressLineText().setValue(bproperty.getAddressLineText());
							/*if(null != bproperty.getAddressType() && !"".equalsIgnoreCase(bproperty.getAddressType()))
								bAddress.getAddressType().setValue(bproperty.getAddressType()== null ? AddressBase.fromValue(null) : AddressBase.fromValue(bproperty.getAddressType()));
							bAddress.getAddressUnitDesignatorType().setValue(bproperty.getAddressUnitDesignatorType() == null ? AddressUnitDesignatorBase.fromValue(null) : AddressUnitDesignatorBase.fromValue(bproperty.getAddressUnitDesignatorType()));
							bAddress.getAddressUnitIdentifier().setValue(bproperty.getAddressUnitIdentifier()== null ? "" :bproperty.getAddressUnitIdentifier());*/
							if(null != bproperty.getCityName() && !"".equalsIgnoreCase(bproperty.getCityName()))
								bAddress.getCityName().setValue(bproperty.getCityName());
							if(null != bproperty.getCountryCode() && !"".equalsIgnoreCase(bproperty.getCountryCode()))
								bAddress.getCountryCode().setValue(bproperty.getCountryCode());
							if(null != bproperty.getPostalCode() && !"".equalsIgnoreCase(bproperty.getPostalCode()))
								bAddress.getPostalCode().setValue(bproperty.getPostalCode());
							if(null != bproperty.getStateCode() && !"".equalsIgnoreCase(bproperty.getStateCode()))
								bAddress.getStateCode().setValue(bproperty.getStateCode());
							borrowerNo++;
							}
						}
				else if(PartyRoleBase.PROPERTY_SELLER == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
				{
				
					if(party.getLEGALENTITY() !=null && "O".equalsIgnoreCase(sellers.get(sellerNo).getType()))
					{
						String sName = sellers.get(sellerNo).getNameModel().getFirstName();
							party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().setValue(sName);
						
						Address sproperty = sellers.get(sellerNo).getAddress();
						ADDRESS sAddress = null;
						if(null != party.getADDRESSES())
							sAddress = party.getADDRESSES().getADDRESS();
						
						if(null != sproperty.getAddressLineText() && !"".equalsIgnoreCase(sproperty.getAddressLineText()))
							sAddress.getAddressLineText().setValue(sproperty.getAddressLineText());
						/*sAddress.getAddressType().setValue(sproperty.getAddressType()== null ? AddressBase.fromValue(null) : AddressBase.fromValue(sproperty.getAddressType()));
						sAddress.getAddressUnitDesignatorType().setValue(sproperty.getAddressUnitDesignatorType() == null ? AddressUnitDesignatorBase.fromValue(null) : AddressUnitDesignatorBase.fromValue(sproperty.getAddressUnitDesignatorType()));*/
						if(null != sproperty.getAddressUnitIdentifier() && !"".equalsIgnoreCase(sproperty.getAddressUnitIdentifier()))
							sAddress.getAddressUnitIdentifier().setValue(sproperty.getAddressUnitIdentifier());
						if(null != sproperty.getCityName() && !"".equalsIgnoreCase(sproperty.getCityName()))
							sAddress.getCityName().setValue(sproperty.getCityName());
						if(null != sproperty.getCountryCode() && !"".equalsIgnoreCase(sproperty.getCountryCode()))
							sAddress.getCountryCode().setValue(sproperty.getCountryCode());
						if(null != sproperty.getPostalCode() && !"".equalsIgnoreCase(sproperty.getPostalCode()))
							sAddress.getPostalCode().setValue(sproperty.getPostalCode());
						if(null != sproperty.getStateCode() && !"".equalsIgnoreCase(sproperty.getStateCode()))
							sAddress.getStateCode().setValue(sproperty.getStateCode());
						sellerNo++;
					}
					
					else if(null != party.getINDIVIDUAL() && "I".equalsIgnoreCase(sellers.get(sellerNo).getType()))
					{
						Address sproperty = sellers.get(sellerNo).getAddress();
						ADDRESS sAddress = null;
						NameModel name = sellers.get(sellerNo).getNameModel();
						
						if(null != name.getFirstName() && null != party.getINDIVIDUAL().getNAME().getFirstName())
							party.getINDIVIDUAL().getNAME().getFirstName().setValue(name.getFirstName());
						if(null != name.getLastName() && null != party.getINDIVIDUAL().getNAME().getLastName())
							party.getINDIVIDUAL().getNAME().getLastName().setValue(name.getLastName());
						if(null != name.getMiddleName() && null != party.getINDIVIDUAL().getNAME().getMiddleName())
							party.getINDIVIDUAL().getNAME().getMiddleName().setValue(name.getMiddleName());
						if(null != name.getSuffixName() && null != party.getINDIVIDUAL().getNAME().getSuffixName())
							party.getINDIVIDUAL().getNAME().getSuffixName().setValue(name.getSuffixName());
						
						if(null != party.getADDRESSES())
							sAddress = party.getADDRESSES().getADDRESS();
						
						if(null != sproperty.getAddressLineText() && !"".equalsIgnoreCase(sproperty.getAddressLineText()))
							sAddress.getAddressLineText().setValue(sproperty.getAddressLineText());
						/*sAddress.getAddressType().setValue(sproperty.getAddressType()== null ? AddressBase.fromValue(null) : AddressBase.fromValue(sproperty.getAddressType()));
						sAddress.getAddressUnitDesignatorType().setValue(sproperty.getAddressUnitDesignatorType() == null ? AddressUnitDesignatorBase.fromValue(null) : AddressUnitDesignatorBase.fromValue(sproperty.getAddressUnitDesignatorType()));*/
						if(null != sproperty.getAddressUnitIdentifier() && !"".equalsIgnoreCase(sproperty.getAddressUnitIdentifier()))
							sAddress.getAddressUnitIdentifier().setValue(sproperty.getAddressUnitIdentifier());
						if(null != sproperty.getCityName() && !"".equalsIgnoreCase(sproperty.getCityName()))
							sAddress.getCityName().setValue(sproperty.getCityName());
						if(null != sproperty.getCountryCode() && !"".equalsIgnoreCase(sproperty.getCountryCode()))
							sAddress.getCountryCode().setValue(sproperty.getCountryCode());
						if(null != sproperty.getPostalCode() && !"".equalsIgnoreCase(sproperty.getPostalCode()))
							sAddress.getPostalCode().setValue(sproperty.getPostalCode());
						if(null != sproperty.getStateCode() && !"".equalsIgnoreCase(sproperty.getStateCode()))
							sAddress.getStateCode().setValue(sproperty.getStateCode());
						sellerNo++;
					}
				}
				else if(PartyRoleBase.NOTE_PAY_TO == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
				{
					if(null != party.getLEGALENTITY() && "O".equalsIgnoreCase(lenders.get(lenderNo).getType()))
					{
						String lName = lenders.get(lenderNo).getNameModel().getFirstName();
						party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().setValue(lName);
						Address lproperty = lenders.get(lenderNo).getAddress();
						
						ADDRESS lAddress = null;
						if(null != party.getADDRESSES())
							lAddress = party.getADDRESSES().getADDRESS();
					
						if(null != lproperty.getAddressLineText() && !"".equalsIgnoreCase(lproperty.getAddressLineText()))
							lAddress.getAddressLineText().setValue(lproperty.getAddressLineText());
						/*lAddress.getAddressType().setValue(lproperty.getAddressType()== null ? AddressBase.fromValue(null) :AddressBase.fromValue(lproperty.getAddressType()));
						lAddress.getAddressUnitDesignatorType().setValue(lproperty.getAddressUnitDesignatorType()== null ? AddressUnitDesignatorBase.fromValue(null) :  AddressUnitDesignatorBase.fromValue(lproperty.getAddressUnitDesignatorType()));*/
						if(null != lproperty.getAddressUnitIdentifier() && !"".equalsIgnoreCase(lproperty.getAddressUnitIdentifier()))
							lAddress.getAddressUnitIdentifier().setValue(lproperty.getAddressUnitIdentifier());
						if(null != lproperty.getCityName() && !"".equalsIgnoreCase(lproperty.getCityName()))
							lAddress.getCityName().setValue(lproperty.getCityName());
						if(null != lproperty.getCountryCode() && !"".equalsIgnoreCase(lproperty.getCountryCode()))
							lAddress.getCountryCode().setValue(lproperty.getCountryCode());
						if(null != lproperty.getPostalCode() && !"".equalsIgnoreCase(lproperty.getPostalCode()))
							lAddress.getPostalCode().setValue(lproperty.getPostalCode());
						if(null != lproperty.getStateCode() && !"".equalsIgnoreCase(lproperty.getStateCode()))
							lAddress.getStateCode().setValue(lproperty.getStateCode());
							
						lenderNo++;
						}
					}
				}
			}
		}
		document.getDEALSETS().getDEALSET().getDEALS().setDEAL(deal);
		return document;
	}

	@Override
	public DOCUMENT mapLoanTerms(DOCUMENT document, PDFDocument pdfDocument) {
		LoanTerms loanTerms = pdfDocument.getPageOne().getLoanTerms();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		LoanTermsLoanAmount loanTermsLoanAmount = loanTerms.getLoanTermsLoanAmount();
		
		text4_2_2 = "";
		//Loan Amount
		deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteAmount().setValue(new BigDecimal(loanTermsLoanAmount.getAmount().replaceAll(",", "")));	
		if(loanTermsLoanAmount.getStatus().equalsIgnoreCase("YES"))
		{
			deal.getLOANS().getLOAN().getLOANDETAIL().getNegativeAmortizationIndicator().setValue(true);
			String text4_1_2 = "Can go as high as ";
			String text4_1_3 = "Can increase until year ";
			if(deal.getLOANS().getLOAN().getLOANDETAIL().getLoanAmountIncreaseIndicator().isValue())
			{
				if("ScheduledNegativeAmortization".equalsIgnoreCase(deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationType().getValue().value()))
				{
					text4_1_2 = "Does go as high as ";
					text4_1_3 = "Does increase until year ";
				}
			}
			text4_1_2 = text4_1_2 + " " + deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationMaximumLoanBalanceAmount().getValue().toPlainString();
			text4_1_3 = text4_1_3 + " " +Integer.toString(deal.getLOANS().getLOAN().getNEGATIVEAMORTIZATION().getNEGATIVEAMORTIZATIONRULE().getNegativeAmortizationLimitMonthsCount().getValue()); 
			
			//loanTermsLoanAmount.setStatus("YES");
			List<String> details = new LinkedList<>();
				details.add(text4_1_2);
				details.add(text4_1_3);
			loanTermsLoanAmount.setDetails(details);
		}			
		else if(loanTermsLoanAmount.getStatus().equalsIgnoreCase("NO"))
		{
			deal.getLOANS().getLOAN().getLOANDETAIL().getNegativeAmortizationIndicator().setValue(false);
		}
		
		LoanTermsInterestRate loanTermsInterestRate = loanTerms.getLoanTermsInterestRate();
		String[] interestrate = loanTermsInterestRate.getInterest().split("%");
		
		//TERMSOFLOAN termsofloan = new TERMSOFLOAN();
		//String text4_2 ="";
		//DEAL.LOANS.LOAN.BUYDOWN.BUYDOWN_RULE.EXTENSION.OTHER.BuydownReflectedInNoteIndicator['__text']).equalsIgnoreCase("true") 
        //&& !DEAL.LOANS.LOAN.BUYDOWN.BUYDOWN_OCCURRENCES.BUYDOWN_OCCURRENCE.BuydownInitialEffectiveInterestRatePercent['__text']).equals(""))
		if(null != deal.getLOANS().getLOAN().getBUYDOWN())
		{
			if(deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNRULE().getEXTENSION().getOTHER().isBuydownReflectedInNoteIndicator() && !("").equals(deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNOCCURRENCES().getBUYDOWNOCCURRENCE().getBuydownInitialEffectiveInterestRatePercent().getValue().toPlainString()))
			    deal.getLOANS().getLOAN().getBUYDOWN().getBUYDOWNOCCURRENCES().getBUYDOWNOCCURRENCE().getBuydownInitialEffectiveInterestRatePercent().setValue(new BigDecimal(interestrate[0].replaceAll(",", "")));
		}
		else if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getDisclosedFullyIndexedRatePercent())
			deal.getLOANS().getLOAN().getTERMSOFLOAN().getDisclosedFullyIndexedRatePercent().setValue(new BigDecimal(interestrate[0].replaceAll(",", "")));
		else if(null != deal.getLOANS().getLOAN().getTERMSOFLOAN().getWeightedAverageInterestRatePercent())
			deal.getLOANS().getLOAN().getTERMSOFLOAN().getWeightedAverageInterestRatePercent().setValue(new BigDecimal(interestrate[0].replaceAll(",", "")));
		else
			deal.getLOANS().getLOAN().getTERMSOFLOAN().getNoteRatePercent().setValue(new BigDecimal(interestrate[0].replaceAll(",", "")));
		//loanTermsInterestRate.setInterest(text4_2);
		
		//Adjustable Rate AIR message
		if(loanTermsInterestRate.getStatus().equalsIgnoreCase("YES"))
		{
			//loanTermsInterestRate.setStatus("YES");
			deal.getLOANS().getLOAN().getLOANDETAIL().getInterestRateIncreaseIndicator().setValue(true);
			List<INTERESTRATEPERCHANGEADJUSTMENTRULE> interestrateperchangeadjustmentrules = deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATEPERCHANGEADJUSTMENTRULES().getINTERESTRATEPERCHANGEADJUSTMENTRULE();
			interestrateperchangeadjustmentrules.forEach(interestrateperchangeadjustmentrule ->{
				if("First".equalsIgnoreCase(interestrateperchangeadjustmentrule.getAdjustmentRuleType().getValue().value()))
					{
						text4_2_2 = Integer.toString(interestrateperchangeadjustmentrule.getPerChangeRateAdjustmentFrequencyMonthsCount().getValue());
					}
			});
		//StringFormatter.ROUNDUPYEARS.formatString(DEAL.LOANS.LOAN.ADJUSTMENT.INTEREST_RATE_ADJUSTMENT.INTEREST_RATE_LIFETIME_ADJUSTMENT_RULE.FirstRateChangeMonthsCount['__text']
		text4_2_2 = StringFormatter.YEARS.formatString(text4_2_2);
		List<String> detail = new LinkedList<>();
			detail.add("Adjusts <b>every "+ ("1".equals(text4_2_2) ? "year" : (text4_2_2 + " years") +"</b> starting in year "+ StringFormatter.ROUNDUPYEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getFirstRateChangeMonthsCount().getValue()))));
			detail.add("Can go <b>as high as " + StringFormatter.PERCENT.formatString(deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getCeilingRatePercent().getValue().toPlainString())+"</b> in year "+StringFormatter.YEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getADJUSTMENT().getINTERESTRATEADJUSTMENT().getINTERESTRATELIFETIMEADJUSTMENTRULE().getCeilingRatePercentEarliestEffectiveMonthsCount().getValue())));
			detail.add("See <b>AIR Table on page 4</b> for details");
		loanTermsInterestRate.setDetails(detail);
		}
		else if(loanTermsInterestRate.getStatus().equalsIgnoreCase("NO"))
		{
			deal.getLOANS().getLOAN().getLOANDETAIL().getInterestRateIncreaseIndicator().setValue(false);
		}
		
		LoanTermsPI loanTermsPI = loanTerms.getLoanTermsPI();
		
		List<String> piDetails = new LinkedList<>();
		//DEAL.LOANS.LOAN.PAYMENT.PAYMENT_RULE.PaymentFrequencyType['__text']).equalsIgnoreCase("")
		if(null != loanTermsPI.getPaymentFrequencyType())
		{
			//deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().setValue(loanTermsPI.getPaymentFrequencyType() == null ? PaymentFrequencyBase.fromValue(null) : PaymentFrequencyBase.fromValue(loanTermsPI.getPaymentFrequencyType()));
		}
		
		//DEAL.LOANS.LOAN.PAYMENT.PAYMENT_RULE.InitialPrincipalAndInterestPaymentAmount['__text']).equalsIgnoreCase("")
		if(null != loanTermsPI.getAmount() && !"".equalsIgnoreCase(loanTermsPI.getAmount()) && null != deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getInitialPrincipalAndInterestPaymentAmount())
			deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getInitialPrincipalAndInterestPaymentAmount().setValue(new BigDecimal(loanTermsPI.getAmount().replaceAll(",", "")));
		/*if(!"".equalsIgnoreCase(principalAmount))
			principalAmount = StringFormatter.NODOLLARS.formatString(principalAmount);*/
		else
			deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getFullyIndexedInitialPrincipalAndInterestPaymentAmount().setValue(new BigDecimal(loanTermsPI.getAmount().replaceAll(",", "")));
		
		//DEAL.LOANS.LOAN.LOAN_DETAIL.PaymentIncreaseIndicator['__text']).equalsIgnoreCase("true")
		if("YES".equalsIgnoreCase(loanTermsPI.getStatus()))
		{
			//loanTermsPI.setStatus("YES");
			deal.getLOANS().getLOAN().getLOANDETAIL().getPaymentIncreaseIndicator().setValue(true);
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
				deal.getLOANS().getLOAN().getLOANDETAIL().getPaymentIncreaseIndicator().setValue(false);
		}
		
		/*loanTermsPI.setPaymentFrequencyType(frequency);
		loanTermsPI.setAmount(principalAmount);*/
		
		//Prepayment Penalty
		LoanTermsPrepaymentPenalty loanTermsPrepaymentPenalty = loanTerms.getLoanTermsPrepaymentPenalty();
		List<String> prepaymentDetails = new LinkedList<>();
			//DEAL.LOANS.LOAN.LOAN_DETAIL.PrepaymentPenaltyIndicator['__text']).equalsIgnoreCase("true")){
		if(loanTermsPrepaymentPenalty.getStatus().equalsIgnoreCase("YES"))
		{
			//loanTermsPrepaymentPenalty.setStatus("YES");
			deal.getLOANS().getLOAN().getLOANDETAIL().getPrepaymentPenaltyIndicator().setValue(true);
			//StringFormatter.NODOLLARS.formatString(DEAL.LOANS.LOAN.PREPAYMENT_PENALTY.PREPAYMENT_PENALTY_LIFETIME_RULE.PrepaymentPenaltyMaximumLifeOfLoanAmount['__text']
			String para4_4_1 = "<b>As high as "+StringFormatter.NODOLLARS.formatString(deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE().getPrepaymentPenaltyMaximumLifeOfLoanAmount().getValue().toPlainString()+"</b> if you payoff the");
			prepaymentDetails.add(para4_4_1);
			//StringFormatter.YEARS.formatString(closingMap.getClosingMapValue("PREPAYMENT_PENALTY_LIFETIME_RULE.PrepaymentPenaltyExpirationMonthsCount")) + " years"
			para4_4_1 = "loan during the first"+StringFormatter.YEARS.formatString(Integer.toString(deal.getLOANS().getLOAN().getPREPAYMENTPENALTY().getPREPAYMENTPENALTYLIFETIMERULE().getPrepaymentPenaltyExpirationMonthsCount().getValue())) +" years";
			prepaymentDetails.add(para4_4_1);
			loanTermsPrepaymentPenalty.setDetails(prepaymentDetails);
		}
		else if(loanTermsPrepaymentPenalty.getStatus().equalsIgnoreCase("NO"))
			deal.getLOANS().getLOAN().getLOANDETAIL().getPrepaymentPenaltyIndicator().setValue(false);
		
		//Balloon Payment
		LoanTermsBalloonPayment loanTermsBalloonPayment = loanTerms.getLoanTermsBalloonPayment();
		List<String> bIndicatorDetails = new LinkedList<>();
		//DEAL.LOANS.LOAN.LOAN_DETAIL.BalloonIndicator['__text']
		if(loanTermsBalloonPayment.getStatus().equalsIgnoreCase("YES"))
		{
			deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonIndicator().setValue(true);
			String para4_5_1 = "";
			para4_5_1 = "You will have to pay ";
			//DEAL.LOANS.LOAN.LOAN_DETAIL.BalloonPaymentAmount
			para4_5_1 = para4_5_1 + "<b>"+StringFormatter.NODOLLARS.formatString(deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonPaymentAmount().getValue().toPlainString())+"</b> at the end of ";
	        //DEAL_SET.DEALS.DEAL.LOANS.LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodType['__text']).toLowerCase() 
	        //LOAN.MATURITY.MATURITY_RULE.LoanMaturityPeriodCount['__text'])
			para4_5_1 = para4_5_1 + deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodType().getValue().value().toLowerCase()+" "+ Integer.toString(deal.getLOANS().getLOAN().getMATURITY().getMATURITYRULE().getLoanMaturityPeriodCount().getValue());
			bIndicatorDetails.add(para4_5_1);
			//loanTermsBalloonPayment.setStatus("YES");
			loanTermsBalloonPayment.setDetails(bIndicatorDetails);
		}
		else if(loanTermsBalloonPayment.getStatus().equalsIgnoreCase("NO"))
		    deal.getLOANS().getLOAN().getLOANDETAIL().getBalloonIndicator().setValue(false);
			
	/*	loanTerms.setLoanTermsLoanAmount(loanTermsLoanAmount);
		loanTerms.setLoanTermsInterestRate(loanTermsInterestRate);
		loanTerms.setLoanTermsPI(loanTermsPI);
		loanTerms.setLoanTermsPrepaymentPenalty(loanTermsPrepaymentPenalty);
		loanTerms.setLoanTermsBalloonPayment(loanTermsBalloonPayment);*/
		
		return document;
	}

	@Override
	public DOCUMENT mapProjectedPayments(DOCUMENT document, PDFDocument pdfDocument) {
		
		ProjectedPayments projectedPayments = pdfDocument.getPageOne().getProjectedPayments();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		List<String> projectedPaymentsPaymentCalculation = projectedPayments.getProjectedPaymentsPaymentCalculation();
		List<ProjectedPaymentsPI> projectedPaymentsPrincipalInterest = projectedPayments.getProjectedPaymentsPrincipalInterest();
		List<String> projectedPaymentsMortgageInsurance = projectedPayments.getProjectedPaymentsMortgageInsurance();
		List<String> projectedPaymentsEstimatedEscrow = projectedPayments.getProjectedPaymentsEstimatedEscrow();
		List<String> projectedPaymentsEstimatedTotalPayment = projectedPayments.getProjectedPaymentsEstimatedTotalPayment();
		//String projectedPaymentsEstimatedTotalPaymentType = "";
		
		int column = 1;
		/*boolean everMI = false;
		boolean everEscrow = false;*/
		
		Map<Integer,String> paymentsmap = new LinkedHashMap<Integer, String>();
		String values = "";
		
		for(int i=0;i<projectedPaymentsPaymentCalculation.size();i++){
			values = projectedPaymentsPaymentCalculation.get(i)+"&"+projectedPaymentsMortgageInsurance.get(i)+"&"+projectedPaymentsEstimatedEscrow.get(i)+"&"+projectedPaymentsEstimatedTotalPayment.get(i);
			paymentsmap.put(i,values);
		}
		
		List<String> pps = new LinkedList<String>();
		
		for(Map.Entry m:paymentsmap.entrySet()){  
			   //System.out.println(m.getKey()+" "+m.getValue());  
			   pps.add(m.getValue().toString());
	    } 
		
		String[] ppsvalues = null;
		String[] years = null;
		String[] year = null;
		String startYear = "";
		String endYear = "";
		int count = 0;
		List<PROJECTEDPAYMENT> projectedpayments2 = deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getPROJECTEDPAYMENTS().getPROJECTEDPAYMENT();
			for(PROJECTEDPAYMENT projectedpayment :projectedpayments2)
			{
				StringFormatter format = StringFormatter.NODOLLARS;
				//System.out.println(pps.get(j)); 
				ppsvalues = pps.get(count).split("&");
				year = ppsvalues[0].split(" ");
			
				if (column == 1 || null != projectedPaymentsPrincipalInterest.get(count).getMinValue())
					format = StringFormatter.NODOLLARS;
				
				// Print date range
				if ("FinalPayment".equalsIgnoreCase(projectedpayment.getProjectedPaymentCalculationPeriodTermType().getValue().value())){
					//projectedPaymentsPaymentCalculation.add("Final Payment");
					projectedpayment.getProjectedPaymentCalculationPeriodTermType().setValue(ProjectedPaymentCalculationPeriodTermBase.fromValue("Final Payment"));
				} else {
					if(year[1].indexOf("-") != -1){
						years = year[1].split("-");
						startYear = years[0].trim();
						endYear = years[1].trim();
						//System.out.println(startYear+" And "+ endYear); 
						projectedpayment.getProjectedPaymentCalculationPeriodStartNumber().setValue(new BigDecimal(startYear));
						projectedpayment.getProjectedPaymentCalculationPeriodEndNumber().setValue(new BigDecimal(endYear));
						projectedpayment.getProjectedPaymentCalculationPeriodTermType().setValue(ProjectedPaymentCalculationPeriodTermBase.fromValue("Yearly"));
					}
					else{
						String yearly = year[1];
						//System.out.println("only year "+ yearly);
						projectedpayment.getProjectedPaymentCalculationPeriodStartNumber().setValue(new BigDecimal(yearly));
						projectedpayment.getProjectedPaymentCalculationPeriodEndNumber().setValue(new BigDecimal(yearly));
						projectedpayment.getProjectedPaymentCalculationPeriodTermType().setValue(ProjectedPaymentCalculationPeriodTermBase.fromValue("Yearly"));
						
					}
				}
				
				//5.2 Principal and Interest
				boolean interestOnly = false;
				String monthscount  = Integer.toString(null != deal.getLOANS().getLOAN().getINTERESTONLY() ? deal.getLOANS().getLOAN().getINTERESTONLY().getInterestOnlyTermMonthsCount().getValue() : 0);
				int interestOnlyTermMonthsCount = 0;
				if(null != monthscount && !"".equalsIgnoreCase(monthscount)){
					interestOnlyTermMonthsCount = Integer.parseInt(monthscount);
				}
				
				//projectedPaymentsEstimatedTotalPaymentType 
				projectedpayment.getPaymentFrequencyType().setValue(projectedPayments.getProjectedPaymentsEstimatedTotalPaymentType() == null ?  PaymentFrequencyBase.fromValue(null): PaymentFrequencyBase.fromValue(projectedPayments.getProjectedPaymentsEstimatedTotalPaymentType()));
				
				// Calculate interest only flag
				if (null != projectedPaymentsPrincipalInterest.get(count).getInterestOnly()) {
					try {
						int startyear = Integer.parseInt(startYear);
			            if((startyear-1)*12 < interestOnlyTermMonthsCount && deal.getLOANS().getLOAN().getLOANDETAIL().getInterestOnlyIndicator().isValue()) 
			            	interestOnly = true;
					} catch (Exception e) {
						// do nothing
					}
				}
				if(null != projectedPaymentsPrincipalInterest.get(count)){
				String min = (null != projectedPaymentsPrincipalInterest.get(count).getMinValue()) ? projectedPaymentsPrincipalInterest.get(count).getMinValue() :"0";
				String max = (null != projectedPaymentsPrincipalInterest.get(count).getMaxValue()) ? projectedPaymentsPrincipalInterest.get(count).getMaxValue() :"0";
				if(column >1 && !"0".equals(min))
				{
					if(interestOnly)
					{
						projectedpayment.getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount().setValue(new BigDecimal(projectedPaymentsPrincipalInterest.get(count).getMinValue().replaceAll(",", "")));
						projectedpayment.getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount().setValue(new BigDecimal(projectedPaymentsPrincipalInterest.get(count).getMaxValue().replaceAll(",", "")));
					}
					else
					{
						projectedpayment.getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount().setValue(new BigDecimal(projectedPaymentsPrincipalInterest.get(count).getMinValue().replaceAll(",", "")));
						projectedpayment.getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount().setValue(new BigDecimal(projectedPaymentsPrincipalInterest.get(count).getMaxValue().replaceAll(",", "")));
					}
					
				}
				else
				{
					if(interestOnly)
					{
						//projectedpayment.getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount().setValue(new BigDecimal(projectedPaymentsPrincipalInterest.get(count).getMinValue()));
						projectedpayment.getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount().setValue(new BigDecimal(projectedPaymentsPrincipalInterest.get(count).getMaxValue().replaceAll(",", "")));
					}
					else
					{
						//projectedpayment.getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount().setValue(new BigDecimal(projectedPaymentsPrincipalInterest.get(count).getMinValue()));
						projectedpayment.getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount().setValue(new BigDecimal(projectedPaymentsPrincipalInterest.get(count).getMaxValue().replaceAll(",", "")));
					}
				}
				}
				//5.3 (MI)
				String miamount = ppsvalues[1];
				miamount = miamount.replaceAll(",", "");
				miamount = miamount.replaceAll(" ", "");
				if(null != projectedpayment.getProjectedPaymentMIPaymentAmount() && !"-----".equalsIgnoreCase(miamount)){
					if (miamount == "0" || miamount == "0.00")
					    projectedpayment.getProjectedPaymentMIPaymentAmount().setValue(new BigDecimal("0.00"));
					else 
						projectedpayment.getProjectedPaymentMIPaymentAmount().setValue(new BigDecimal(miamount));
				}
					
				//5.4 (Escrow)
				String escrowamount = ppsvalues[2];
				escrowamount = escrowamount.replaceAll(",", "");
				escrowamount = escrowamount.replaceAll(" ", "");
					if (escrowamount == "0")
						projectedpayment.getProjectedPaymentEstimatedEscrowPaymentAmount().setValue(new BigDecimal("0.00"));
					else
						projectedpayment.getProjectedPaymentEstimatedEscrowPaymentAmount().setValue(new BigDecimal(escrowamount.replaceAll(",", "")));
				
				//5.5+9 (EstimatedTotalPayment)
					
					String[] etp = null;
					String etpayments =  ppsvalues[3];
					etpayments = etpayments.replaceAll(",", "");
					etpayments = etpayments.replaceAll(" ", "");
					if(etpayments.indexOf("-") != -1) {
						etp = etpayments.split("-");
						String Min = etp[0].trim();
						String Max = etp[1].trim();
					    //System.out.println("Amounts Min:::"+Min+" And Max:::"+Max);
						if(null != projectedpayment.getProjectedPaymentEstimatedTotalMinimumPaymentAmount()){
						    if(Min == "0")
						    	projectedpayment.getProjectedPaymentEstimatedTotalMinimumPaymentAmount().setValue(new BigDecimal("0.00"));
						    else 
						    	projectedpayment.getProjectedPaymentEstimatedTotalMinimumPaymentAmount().setValue(new BigDecimal(Min.replaceAll(",", "")));
						}
						if(null != projectedpayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount()){
						    if(Max == "0")
						    	projectedpayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount().setValue(new BigDecimal("0.00"));
						    else 
						    	projectedpayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount().setValue(new BigDecimal(Max.replaceAll(",", "")));
						}
					}
					else {
						if(null != projectedpayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount()){
							if(etpayments == "0")
						    	projectedpayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount().setValue(new BigDecimal("0.00"));
							else 
							    projectedpayment.getProjectedPaymentEstimatedTotalMaximumPaymentAmount().setValue(new BigDecimal(etpayments.replaceAll(",", "")));
						}
					}
				column++;
				count++;
			}
			
			/*projectedPayments.setProjectedPaymentsPaymentCalculation(projectedPaymentsPaymentCalculation);
			projectedPayments.setProjectedPaymentsPrincipalInterest(projectedPaymentsPrincipalInterest);
			projectedPayments.setProjectedPaymentsMortgageInsurance(projectedPaymentsMortgageInsurance);
			projectedPayments.setProjectedPaymentsEstimatedEscrow(projectedPaymentsEstimatedEscrow);
			projectedPayments.setProjectedPaymentsEstimatedTotalPayment(projectedPaymentsEstimatedTotalPayment);
			projectedPayments.setProjectedPaymentsEstimatedTotalPaymentType(projectedPaymentsEstimatedTotalPaymentType);
			projectedPayments.setProjectedPaymentsETIA(createProjectedPaymentsETIA());*/
			

			ProjectedPaymentsETIA projectedPaymentsETIA = pdfDocument.getPageOne().getProjectedPayments().getProjectedPaymentsETIA();

			
			deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getESTIMATEDPROPERTYCOST().getESTIMATEDPROPERTYCOSTDETAIL().getProjectedPaymentEstimatedTaxesInsuranceAssessmentTotalAmount().setValue(new BigDecimal(projectedPaymentsETIA.getAmount().replaceAll(",", "")));
			
			if(null != deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getESTIMATEDPROPERTYCOST().getESTIMATEDPROPERTYCOSTCOMPONENTS())
			{
				List<ESTIMATEDPROPERTYCOSTCOMPONENT> estimatedpropertycostcomponents = deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getESTIMATEDPROPERTYCOST().getESTIMATEDPROPERTYCOSTCOMPONENTS().getESTIMATEDPROPERTYCOSTCOMPONENT();
				for (ESTIMATEDPROPERTYCOSTCOMPONENT estimatedpropertycostcomponent:estimatedpropertycostcomponents) {
					switch (estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().getValue().value()) {
					case "PropertyTaxes":
						if ("YES".equals(projectedPaymentsETIA.getPropertyTaxesInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType() ){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("Escrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("PropertyTaxes"));
						}
						else if ("NO".equals(projectedPaymentsETIA.getPropertyTaxesInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType() ){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("NotEscrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("PropertyTaxes"));
						}
						else if ("SOME".equals(projectedPaymentsETIA.getPropertyTaxesInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType() ){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("SomeEscrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("PropertyTaxes"));
						}
						break;
					case "HomeownersInsurance":
						if ("YES".equals(projectedPaymentsETIA.getHomeownersInsuranceInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType() ){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("Escrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("HomeownersInsurance"));
						}
						else if ("NO".equals(projectedPaymentsETIA.getHomeownersInsuranceInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType()){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("NotEscrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("HomeownersInsurance"));
						}
						else if ("SOME".equals(projectedPaymentsETIA.getHomeownersInsuranceInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType()){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("SomeEscrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("HomeownersInsurance"));
						}
						break;
					default: // All other escrows go here
					    if("".equalsIgnoreCase(projectedPaymentsETIA.getOtherDescription()) && null != estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription())
					    	estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentTypeOtherDescription().setValue(projectedPaymentsETIA.getOtherDescription());
					    if ("YES".equals(projectedPaymentsETIA.getOtherInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType()){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("Escrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("Other"));
						}
						else if ("NO".equals(projectedPaymentsETIA.getOtherInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType()){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("NotEscrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("Other"));
						}
						else if ("SOME".equals(projectedPaymentsETIA.getOtherInEscrow()) && null != estimatedpropertycostcomponent.getProjectedPaymentEscrowedType()){
						    estimatedpropertycostcomponent.getProjectedPaymentEscrowedType().setValue(ProjectedPaymentEscrowedBase.fromValue("SomeEscrowed"));
						    estimatedpropertycostcomponent.getProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentType().setValue(ProjectedPaymentEstimatedTaxesInsuranceAssessmentComponentBase.fromValue("Other"));
						}
						break;
					}
				}
			}
			
	       //DEAL.LOANS.LOAN.DOCUMENT_SPECIFIC_DATA_SETS.DOCUMENT_SPECIFIC_DATA_SET.INTEGRATED_DISCLOSURE.PROJECTED_PAYMENTS.PROJECTED_PAYMENT.PaymentFrequencyType
			switch(projectedPaymentsETIA.getFrequencyType()){
				
			case "a month":
				deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().setValue(PaymentFrequencyBase.fromValue("Monthly"));
				break;
			case "at maturity":
				deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().setValue(PaymentFrequencyBase.fromValue("AtMaturity"));
				break;
			case "a bi week":
				deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().setValue(PaymentFrequencyBase.fromValue("Biweekly"));
				break;
			case "a quarter":
				deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().setValue(PaymentFrequencyBase.fromValue("Quarterly"));
				break;
			case "a semiannual":
				deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().setValue(PaymentFrequencyBase.fromValue("Semiannual"));
				break;
			case "a semimonth":
				deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().setValue(PaymentFrequencyBase.fromValue("Semimonthly"));
				break;
			case "a week":
				deal.getLOANS().getLOAN().getPAYMENT().getPAYMENTRULE().getPaymentFrequencyType().setValue(PaymentFrequencyBase.fromValue("Weekly"));
			}
			
			/*projectedPaymentsETIA.setAmount(StringFormatter.NODOLLARS.formatString(etia));
			projectedPaymentsETIA.setFrequencyType(str);
			projectedPaymentsETIA.setPropertyTaxesStatus(hasCost(countPIYes, countPINo, countPISome) ? "true" : "false");
			projectedPaymentsETIA.setHomeownersInsuranceStatus(hasCost(countHIYes, countHINo, countHISome) ? "true" : "false");
			projectedPaymentsETIA.setOtherStatus(hasCost(countOtherYes, countOtherNo, countOtherSome) ? "true" : "false");
			projectedPaymentsETIA.setPropertyTaxesInEscrow(inEscrowText(countPIYes, countPINo, countPISome));
			projectedPaymentsETIA.setHomeownersInsuranceInEscrow(inEscrowText(countHIYes, countHINo, countHISome));
			projectedPaymentsETIA.setOtherInEscrow(inEscrowText(countOtherYes, countOtherNo, countOtherSome));
			projectedPaymentsETIA.setOtherDescription(otherStr);*/
		
		return document;
	}

	
	@Override
	public DOCUMENT mapCostsAtClosing(DOCUMENT document, PDFDocument pdfDocument) {

		CostsAtClosing costsAtClosing = pdfDocument.getPageOne().getCostsAtClosing();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		CostsAtClosingClosingCosts costsAtClosingClosingCosts = costsAtClosing.getCostsAtClosingClosingCosts();
		CostsAtClosingCashToClose costsAtClosingCashToClose = costsAtClosing.getCostsAtClosingCashToClose();
		List<String> closingCostsDetails = new LinkedList<>();
		List<String> cashToCloseDetails = new LinkedList<>();
		String totalLoanCosts = "";
		String totalOtherCosts = "";
		String lenderCredits = "";
		//StringFormatter.NODOLLARS.formatString(	DEAL.LOANS.LOAN.DOCUMENT_SPECIFIC_DATA_SETS.DOCUMENT_SPECIFIC_DATA_SET.INTEGRATED_DISCLOSURE.INTEGRATED_DISCLOSURE_SECTION_SUMMARIES.INTEGRATED_DISCLOSURE_SECTION_SUMMARY.INTEGRATED_DISCLOSURE_SECTION_SUMMARY_DETAIL.TotalClosingCosts['__text']), SUMMARY_AMOUNT));
		List<INTEGRATEDDISCLOSURESECTIONSUMMARY>  integrateddisclosuresectionsummary = deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSURESECTIONSUMMARIES().getINTEGRATEDDISCLOSURESECTIONSUMMARY();
		List<INTEGRATEDDISCLOSURESUBSECTIONPAYMENT> integrateddisclosuresubsectionpayments = new LinkedList<>();
		for(INTEGRATEDDISCLOSURESECTIONSUMMARY ids : integrateddisclosuresectionsummary) {
		     Map<String,String> integratedDisclosureSectionTypeValues = Convertor.getIntegratedDisclosureSectionTypes(document);
			
				if(null != costsAtClosingClosingCosts.getAmount() && !"".equalsIgnoreCase(costsAtClosingClosingCosts.getAmount())){
					if(null != ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType()){
						if("TotalClosingCosts".equalsIgnoreCase(ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType().getValue().toString())
								&& "ClosingCostsSubtotal".equalsIgnoreCase(ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().toString())){
							ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionTotalAmount().setValue(new BigDecimal(costsAtClosingClosingCosts.getAmount().replaceAll(",", "")));
						}
					}
				}
		     
				totalLoanCosts = integratedDisclosureSectionTypeValues.get("TotalLoanCosts");
				/*if(null == totalLoanCosts || totalLoanCosts.isEmpty())
					totalLoanCosts = "0";*/
				if(null != ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType()){
					if("TotalLoanCosts".equalsIgnoreCase(ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType().getValue().toString())){
						//ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionTotalAmount().setValue(new BigDecimal(costsAtClosingClosingCosts.getTotalLoanCostsAmount()));
						//totalLoanCosts = "0";
					}
				}
				totalOtherCosts = integratedDisclosureSectionTypeValues.get("TotalOtherCosts");
				/*if(null == totalOtherCosts || totalOtherCosts.isEmpty())
					totalOtherCosts = "0";*/
				if(null != ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType()){
					if("TotalOtherCosts".equalsIgnoreCase(ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType().getValue().toString())){
						//ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionTotalAmount().setValue(new BigDecimal(costsAtClosingClosingCosts.getTotalOtherCostsAmount()));
						//totalOtherCosts = "0";
					}
				}
				
				lenderCredits = StringFormatter.NODOLLARS.formatString(Convertor.getLenderCredits("LenderCredits", document));
				if(null == lenderCredits || lenderCredits.isEmpty())
					lenderCredits = "0";

				if(null != costsAtClosingClosingCosts.getAmount() && !"".equalsIgnoreCase(costsAtClosingClosingCosts.getAmount())){
					if(null != ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType()){
						if("TotalClosingCosts".equalsIgnoreCase(ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType().getValue().toString())
								&& "LenderCredits".equalsIgnoreCase(ids.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().toString())){
							integrateddisclosuresubsectionpayments = ids.getINTEGRATEDDISCLOSURESUBSECTIONPAYMENTS().getINTEGRATEDDISCLOSURESUBSECTIONPAYMENT();
							for(INTEGRATEDDISCLOSURESUBSECTIONPAYMENT idp : integrateddisclosuresubsectionpayments)
							{
								if(null != idp.getIntegratedDisclosureSubsectionPaymentAmount()){
									//idp.getIntegratedDisclosureSubsectionPaymentAmount().setValue(costsAtClosingClosingCosts.getlenderCreditsAmount());
								}
							}
						}
					}
				}
		}				
		closingCostsDetails.add("Includes "+totalLoanCosts+" in Loan Costs + "+totalOtherCosts+" in Other Costs -"+lenderCredits);
		closingCostsDetails.add("in Lender Credits. <i>See page 2 for details.</i>");
		costsAtClosingClosingCosts.setDetails(closingCostsDetails);
		
		
		return document;
	}

	
	
}
