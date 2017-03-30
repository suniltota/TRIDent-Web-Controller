package com.actualize.mortgage.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.ESCROWITEM;
import org.mismo.residential._2009.schemas.FEE;
import org.mismo.residential._2009.schemas.FEEPAYMENT;
import org.mismo.residential._2009.schemas.FEEPAYMENTS;
import org.mismo.residential._2009.schemas.INTEGRATEDDISCLOSURESECTIONSUMMARY;
import org.mismo.residential._2009.schemas.INTEGRATEDDISCLOSURESUBSECTIONPAYMENT;
import org.mismo.residential._2009.schemas.PREPAIDITEM;
import org.mismo.residential._2009.schemas.PREPAIDITEMPAYMENT;

import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostProperties;
import com.actualize.mortgage.domainmodels.EscrowsModel;
import com.actualize.mortgage.domainmodels.IEPatClosing;
import com.actualize.mortgage.domainmodels.Prepaids;
import com.actualize.mortgage.domainmodels.PrepaidsModel;
import com.actualize.mortgage.services.PageTwoService;
import com.actualize.mortgage.utils.Convertor;
import com.actualize.mortgage.utils.DocumentType;
import com.actualize.mortgage.utils.StringFormatter;

public class PageTwoServiceImpl implements PageTwoService{

	@Override
	public ClosingCostDetailsLoanCosts createClosingCostDetailsLoanCosts(DOCUMENT document) {
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();

		List<ClosingCostProperties> originationChargeList = new LinkedList<>();
		List<ClosingCostProperties> sbDidNotShopFors = new LinkedList<>();
		List<ClosingCostProperties> sbDidShopFors = new LinkedList<>();
		ClosingCostProperties tlCosts = new ClosingCostProperties();
		
		Map<String, String> integratedDisclosureSectionTypes = Convertor.getIntegratedDisclosureSectionTypes(document);			
		closingCostDetailsLoanCosts.setOcTotalAmount(integratedDisclosureSectionTypes.get("OriginationCharges"));
		closingCostDetailsLoanCosts.setSbDidNotShopTotalAmount(integratedDisclosureSectionTypes.get("ServicesBorrowerDidNotShopFor"));
		closingCostDetailsLoanCosts.setSbDidShopTotalAmount(integratedDisclosureSectionTypes.get("ServicesBorrowerDidShopFor"));
		 if (!DocumentType.isSellerOnly(document)) 
		 {	
			closingCostDetailsLoanCosts.setTlCostsTotalAmount(integratedDisclosureSectionTypes.get("TotalLoanCosts"));
			tlCosts = calculateTLCosts(Convertor.getIntegratedDisclosureSectionSummary("TotalLoanCosts", document));
		 }
			
			List<FEE> fees = Convertor.getFees(document);
		for(FEE fee : fees)
		{
			if("OriginationCharges".equalsIgnoreCase(fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value()))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = LoanCostsTable(fee,"OriginationCharges");
					if(null != closingCostProperties.getFeeType())
					{
						originationChargeList.add(closingCostProperties);
					}
			}
			else if("ServicesBorrowerDidNotShopFor".equalsIgnoreCase(fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value()))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = LoanCostsTable(fee,"ServicesBorrowerDidNotShopFor");
					if(null != closingCostProperties.getFeeType())
					{
						
						sbDidNotShopFors.add(closingCostProperties);
					}
			}
			else if("ServicesBorrowerDidShopFor".equalsIgnoreCase(fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value()))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = LoanCostsTable(fee,"ServicesBorrowerDidShopFor");
					if(null != closingCostProperties.getFeeType())
					{
							sbDidShopFors.add(closingCostProperties);
					}
			}
		}
		
		Collections.sort(originationChargeList,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		Collections.sort(sbDidNotShopFors,new Comparator<ClosingCostProperties>(){

			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		Collections.sort(sbDidShopFors,new Comparator<ClosingCostProperties>(){

			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		closingCostDetailsLoanCosts.setOriginationCharges(originationChargeList);
		closingCostDetailsLoanCosts.setSbDidNotShopFors(sbDidNotShopFors);
		closingCostDetailsLoanCosts.setSbDidShopFors(sbDidShopFors);
		closingCostDetailsLoanCosts.setTlCosts(tlCosts);
		
		return closingCostDetailsLoanCosts;
	}

	@Override
	public ClosingCostDetailsOtherCosts createClosingCostDetailsOtherCosts(DOCUMENT document) {
		
		ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts = new ClosingCostDetailsOtherCosts();
		
		List<ClosingCostProperties> tOGovtFeesList = new ArrayList<>();
		List<Prepaids> prepaidsList = new LinkedList<>();
		List<IEPatClosing> iePatClosingList = new LinkedList<>();
		List<ClosingCostProperties> otherCostsList = new LinkedList<>();
		
		Map<String, String> integratedDisclosureSectionTypes = Convertor.getIntegratedDisclosureSectionTypes(document);
	
		closingCostDetailsOtherCosts.settOGovtFeesTotalAmount(integratedDisclosureSectionTypes.get("TaxesAndOtherGovernmentFees"));
		closingCostDetailsOtherCosts.setPrepaidsTotalAmount(integratedDisclosureSectionTypes.get("Prepaids"));
		closingCostDetailsOtherCosts.setiEPatClosingTotalAmount(integratedDisclosureSectionTypes.get("InitialEscrowPaymentAtClosing"));
		closingCostDetailsOtherCosts.setOtherTotalAmount(integratedDisclosureSectionTypes.get("OtherCosts"));
		closingCostDetailsOtherCosts.setTotalOtherCostsTotalAmount(integratedDisclosureSectionTypes.get("TotalOtherCosts"));
		closingCostDetailsOtherCosts.setTotalClosingCostsTotalAmount(integratedDisclosureSectionTypes.get("TotalClosingCosts"));
		
		String deedAmt = "";
		String mrtgAmt = "";
		FEE recordingFee = null;
		
		List<FEE> fees = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getFEEINFORMATION().getFEES().getFEE();
		for(FEE fee : fees)
		{
			if("TaxesAndOtherGovernmentFees".equalsIgnoreCase(fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value()))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
				switch (fee.getFEEDETAIL().getFeeType().getValue().value()){
				case "RecordingFeeForDeed":
					deedAmt += StringFormatter.NODOLLARS.formatString(fee.getFEEDETAIL().getFeeActualTotalAmount().getValue().toPlainString());
					break;
					//8.2.1
				case "RecordingFeeForMortgage":
					mrtgAmt += StringFormatter.NODOLLARS.formatString(fee.getFEEDETAIL().getFeeActualTotalAmount().getValue().toPlainString());
					break;
				case "RecordingFeeTotal":
					recordingFee = fee;
					break;
				default:
					closingCostProperties = FeeCostsTableRow(fee, true, fee.getFEEDETAIL().getFeeType().getValue().value(), null);
					
				}
				
				if(null != closingCostProperties.getFeeType())
				{
					tOGovtFeesList.add(closingCostProperties);	
				}
			}
			
		}
		Collections.sort(tOGovtFeesList,new Comparator<ClosingCostProperties>(){
			@Override
			public int compare(ClosingCostProperties o1, ClosingCostProperties o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		String str = "Recording Fees          " +"Deed: "+ deedAmt+ " Mortgage: " + mrtgAmt;
		
		if (recordingFee == null)
		{
			ClosingCostProperties closingCostProperties = new ClosingCostProperties();
				closingCostProperties.setFeeType(str);
				closingCostProperties.setFeeType("RecordingFees");
			tOGovtFeesList.add(0, closingCostProperties);
		}	
		else
		{	
			tOGovtFeesList.add(0, FeeCostsTableRow(recordingFee, false, str, null));
		}
		
		List<PREPAIDITEM> prepaidItems = Convertor.getPrepaidItemList(document);
		
		//8.5
		List<String> prepaidItemsToDisplay = new LinkedList<>();
		prepaidItemsToDisplay.add("HomeownersInsurancePremium");
		prepaidItemsToDisplay.add("MortgageInsurancePremium");
		prepaidItemsToDisplay.add("PrepaidInterest");
		
		for(String prepaidItem : prepaidItemsToDisplay)
		{
			Prepaids prepaids = new Prepaids();
			if(null != prepaidItems)
			prepaids = addPrepaidByType(prepaidItems, prepaidItem);
		
			if(null != prepaids.getFeeType() && prepaidItem.equalsIgnoreCase(prepaids.getFeeType()))
			{		
				prepaidsList.add(prepaids);	
			}
			else
			{
				prepaids.setDisplayLabel(StringFormatter.CAMEL.formatString(prepaidItem));
				prepaids.setFeeType(prepaidItem);
				prepaidsList.add(prepaids);
			}
		}

		//8.7 Find "Property Taxes" and display
		PREPAIDITEM propertyTaxes = null;
		if(null != prepaidItems)
		for (PREPAIDITEM prepaid : prepaidItems)
			if (("Property Taxes").equalsIgnoreCase(prepaid.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value())) {
				propertyTaxes = prepaid;
				break;
			} else if (propertyTaxes == null && isPropertyTax(prepaid.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value())) {
				propertyTaxes = prepaid;
			}
		
		if (propertyTaxes == null)
		{
			Prepaids prepaids = new Prepaids();
				prepaids.setDisplayLabel("Property Taxes");
				prepaids.setFeeType("Property Tax");
			prepaidsList.add(prepaids);
		}
		else
		{
			prepaidsList.add(PrepaidCostsTableRow(propertyTaxes,true , "Property Taxes"));
		}
		if(null != prepaidItems)
		for(PREPAIDITEM prepaiditem : prepaidItems)
		{
			String prepaidType = prepaiditem.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value();
			if(checkOtherPrepaids(prepaidType))
			{
				prepaidsList.add(PrepaidCostsTableRow(prepaiditem, true, prepaidType));
			}
		}
		
		//ESCROWS
		List<ESCROWITEM> escrowsItems = (null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getESCROW()) ? document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getESCROW().getESCROWITEMS().getESCROWITEM(): null;
		
		List<String> escrowItemsToDisplay = new LinkedList<>();
		escrowItemsToDisplay.add("HomeownersInsurance");
		escrowItemsToDisplay.add("MortgageInsurance");
		
		for(String escrowItem : escrowItemsToDisplay)
		{
			IEPatClosing iepAtClosing = new IEPatClosing();
			if(null != escrowsItems)
			iepAtClosing = addEscrowByType(escrowsItems, escrowItem);
		
			if(null != iepAtClosing.getFeeType())
			{
				iePatClosingList.add(iepAtClosing);	
			}
			else
			{
				IEPatClosing iePatClosing = new IEPatClosing();
					iePatClosing.setDisplayLabel(StringFormatter.CAMEL.formatString(escrowItem));
					iePatClosing.setFeeType(escrowItem);
				iePatClosingList.add(iePatClosing);	
			}
		}
		
		// Find "Property Taxes" and display
		
		EscrowsModel propertyTaxesEscrow = null;
		if(null != escrowsItems)
		for (ESCROWITEM escrowItem : escrowsItems)
		{
			EscrowsModel escrow = Convertor.getEscrowModel(escrowItem);
			if(null != escrow.getType())
			{
				if (escrow.getLabel().equals("Property Tax")) {
					propertyTaxesEscrow = escrow;
					break;
				} 
				else if (propertyTaxesEscrow == null && isPropertyTax(escrow.getType())) {
					propertyTaxesEscrow = escrow;
				}
			}
		}
			if (propertyTaxesEscrow == null)
			{
				IEPatClosing iePatClosing = new IEPatClosing();
				iePatClosing.setDisplayLabel("Property Taxes");
				iePatClosing.setFeeType("Property Tax");
				iePatClosingList.add(iePatClosing);
			}
			else
				{
				IEPatClosing iepAtClosing = new IEPatClosing();
				iepAtClosing =	EscrowCostsTableRow( propertyTaxesEscrow, true, "Property Taxes");
					iePatClosingList.add(iepAtClosing);
				}
			if(null != escrowsItems)
			for (ESCROWITEM escrowItem : escrowsItems)
			{
				EscrowsModel escrow = Convertor.getEscrowModel(escrowItem);
				if(null != escrow.getType() && checkOtherEscrows(escrow.getType()))
				{
					IEPatClosing iepAtClosing = new IEPatClosing();
					iepAtClosing =	EscrowCostsTableRow(escrow, true, escrow.getLabel());
					iePatClosingList.add(iepAtClosing);
				}
			}
	
		//Other
		for(FEE fee : fees)
		{
			String disclosureType = fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value();
			if( "OtherCosts".equalsIgnoreCase(disclosureType) )
			{	
				otherCostsList.add(FeeCostsTableRow(fee, true, null, null));
			}
		}
		
		//Total Other Costs
		//Total Closing Costs
		ClosingCostProperties totalOtherCosts = new ClosingCostProperties();
		List<ClosingCostProperties> totalClosingCostsList = new LinkedList<>();
		ClosingCostProperties ClosingCostsSubTotal = new ClosingCostProperties();
		ClosingCostProperties LenderCredits = new ClosingCostProperties();
		
		List<INTEGRATEDDISCLOSURESECTIONSUMMARY> integrateddisclosuresectionsummaries = Convertor.getIntegrateddisclosuresectionsummaries(document);
		for(INTEGRATEDDISCLOSURESECTIONSUMMARY integrateddisclosuresectionsummary : integrateddisclosuresectionsummaries)
		{
			if(null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType() )
			if(("OtherCostsSubtotal").equalsIgnoreCase(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().value()))
			{
				totalOtherCosts = Convertor.createIDSectionSummary(integrateddisclosuresectionsummary);
			}
			else if(DocumentType.isSellerOnly(document))
			{
				if("TotalClosingCostsSellerOnly".equalsIgnoreCase(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().value()))
						ClosingCostsSubTotal = Convertor.createIDSectionSummary(integrateddisclosuresectionsummary);
			}	
			else if("ClosingCostsSubtotal".equalsIgnoreCase(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().value()))
			{
				ClosingCostsSubTotal = Convertor.createIDSectionSummary(integrateddisclosuresectionsummary);
			}
			else if("LenderCredits".equalsIgnoreCase(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().value()))
			{
				LenderCredits = Convertor.createIDSectionSummary(integrateddisclosuresectionsummary);
			}		
		}

		totalOtherCosts.setDisplayLabel("Other Costs Subtotals (E + F + G + H)");
		ClosingCostsSubTotal.setDisplayLabel("Closing Costs Subtotals (D + I)");
		LenderCredits.setDisplayLabel("Lender Credits");
		totalClosingCostsList.add(ClosingCostsSubTotal);
		totalClosingCostsList.add(LenderCredits);
		
		
		closingCostDetailsOtherCosts.settOGovtFeesList(tOGovtFeesList);
		closingCostDetailsOtherCosts.setPrepaidsList(prepaidsList);
		closingCostDetailsOtherCosts.setiEPatClosingList(iePatClosingList);
		closingCostDetailsOtherCosts.setOtherCostsList(otherCostsList);
		closingCostDetailsOtherCosts.setTotalOtherCosts(totalOtherCosts);
		closingCostDetailsOtherCosts.setTotalClosingCosts(totalClosingCostsList);
		
		return closingCostDetailsOtherCosts;
	}

	private ClosingCostProperties LoanCostsTable(FEE fee,String sectionType) {
		
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		
		if(sectionType.equalsIgnoreCase(fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value()))
		{
			if (("LoanDiscountPoints").equalsIgnoreCase(fee.getFEEDETAIL().getFeeType().getValue().value()))
				if(null !=fee.getFEEDETAIL().getFeeTotalPercent() && !"0.0000".equalsIgnoreCase(fee.getFEEDETAIL().getFeeTotalPercent().getValue().toPlainString())&& null != fee.getFEEDETAIL().getFeePaidToType())
				{
					closingCostProperties = FeeCostsTableRow(fee, true, "of Loan Amount (Points)", null);
					closingCostProperties.setToEntity(StringFormatter.PERCENTWITHOUTPRECEEDING.formatString(fee.getFEEDETAIL().getFeeTotalPercent().getValue().toPlainString()));
				}
				else
				{
					closingCostProperties = FeeCostsTableRow(fee, true, "of Loan Amount (Points)",null);
				}
			else
				closingCostProperties = FeeCostsTableRow(fee, true, null, null);
		}
		return closingCostProperties;
	}
	
	private ClosingCostProperties FeeCostsTableRow(FEE fee, boolean withTo, String label, String to)
	{
		String str = label;
		String buyerOutsideClosingAmount = "";
		String buyerAtClosingAmount = "";
		String sellerOutsideClosingAmount = "";
		String sellerAtClosingAmount = "";
		String otherAmount = "";
		String strLabel = "";
		String paidTo = null != fee.getFEEPAIDTO() ? fee.getFEEPAIDTO().getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().getValue():"";
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		
		if (label == null || label.equals(""))
		{
			if(!"".equals(fee.getFEEDETAIL().getFeeType().getDisplayLabelText()))
				strLabel = fee.getFEEDETAIL().getFeeType().getDisplayLabelText();
			if(("").equals(strLabel) || null == strLabel) 
				strLabel = 	StringFormatter.CAMEL.formatString(null != fee.getFEEDETAIL().getFeeType() ? fee.getFEEDETAIL().getFeeType().getValue().value():"");
		}
		else
			strLabel = StringFormatter.CAMEL.formatString(label);
		
		if("Other".equalsIgnoreCase(strLabel) && null != fee.getFEEDETAIL().getFeeTypeOtherDescription())
			strLabel = StringFormatter.CAMEL.formatString(fee.getFEEDETAIL().getFeeTypeOtherDescription().getValue());
			
			str += StringFormatter.STRINGCLEAN.formatString(null != fee.getFEEDETAIL().getFeePaidToTypeOtherDescription() ? fee.getFEEDETAIL().getFeePaidToTypeOtherDescription().toString():"");
		if (null != fee.getFEEDETAIL().getOptionalCostIndicator() && fee.getFEEDETAIL().getOptionalCostIndicator().isValue() && null != fee.getFEEDETAIL().getFeePaidToTypeOtherDescription() && !fee.getFEEDETAIL().getFeePaidToTypeOtherDescription().toString().toLowerCase().contains("optional"))
			str += " (optional)";
		//add(Columns.CostLabel, str); //cmted

		// Insert to entity
		str = " ";
		
		if (!("").equals(paidTo))
			str += StringFormatter.STRINGCLEAN.formatString(fee.getFEEPAIDTO().getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().getValue());
		if(!"".equals(str)|| null != str)
			closingCostProperties.setToEntity(str);	
		if(null != strLabel || !"".equals(strLabel))
		{
			closingCostProperties.setDisplayLabel(strLabel);
			closingCostProperties.setFeeType(fee.getFEEDETAIL().getFeeType().getValue().value());
		}
		else
		{
			closingCostProperties.setDisplayLabel("");
			closingCostProperties.setFeeType(null);
		}
		
		strLabel = "";
		List<FEEPAYMENTS> feepayments = fee.getFEEPAYMENTS();
		for(FEEPAYMENTS feepayment :feepayments)
		{
			List<FEEPAYMENT> feepays = feepayment.getFEEPAYMENT();
			for(FEEPAYMENT feepay :feepays)
			{
				if( null != feepay.getFeePaymentPaidByType())
				{
					String paidBy = feepay.getFeePaymentPaidByType().getValue().value();
					if( "Buyer".equalsIgnoreCase(paidBy)) 
						if( feepay.getFeePaymentPaidOutsideOfClosingIndicator().isValue())
							buyerOutsideClosingAmount = feepay.getFeeActualPaymentAmount().getValue().toPlainString();
						else
							buyerAtClosingAmount = feepay.getFeeActualPaymentAmount().getValue().toPlainString();
					else if("Seller".equalsIgnoreCase(paidBy))
						if(feepay.getFeePaymentPaidOutsideOfClosingIndicator().isValue())
							sellerOutsideClosingAmount = feepay.getFeeActualPaymentAmount().getValue().toPlainString();
						else
							sellerAtClosingAmount = feepay.getFeeActualPaymentAmount().getValue().toPlainString();
					else
						otherAmount = feepay.getFeeActualPaymentAmount().getValue().toPlainString();
					
					if("Lender".equalsIgnoreCase(paidBy))
						closingCostProperties.setLenderStatus("YES");
					else
						closingCostProperties.setLenderStatus("NO");
				
				}
			}
		}
		str = buyerAtClosingAmount;
			if (!str.equals("") && StringFormatter.doubleValue(str) != 0)
				closingCostProperties.setBpAtClosing(StringFormatter.NODOLLARS.formatString(str));
		str = buyerOutsideClosingAmount;
			if (!str.equals("") && StringFormatter.doubleValue(str) != 0)
				closingCostProperties.setBpB4Closing(StringFormatter.NODOLLARS.formatString(str));
		str = sellerAtClosingAmount;
			if (!str.equals("") && StringFormatter.doubleValue(str) != 0)
				closingCostProperties.setSpAtClosing(StringFormatter.NODOLLARS.formatString(str));
		str = sellerOutsideClosingAmount;
			if (!str.equals("") && StringFormatter.doubleValue(str) != 0)
				closingCostProperties.setSpB4Closing(StringFormatter.NODOLLARS.formatString(str));
		str = otherAmount;
		if (!str.equals("") && StringFormatter.doubleValue(str) != 0)
			closingCostProperties.setPaidByOthers(StringFormatter.NODOLLARS.formatString(str));
		
		return closingCostProperties;
	}
	
	private ClosingCostProperties calculateTLCosts(INTEGRATEDDISCLOSURESECTIONSUMMARY integrateddisclosuresectionsummary)
	{
		ClosingCostProperties tlCosts = new ClosingCostProperties();
		if(null != integrateddisclosuresectionsummary)	
		if(null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType() &&
				"LoanCostsSubtotal".equalsIgnoreCase(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().value()))
			{
				tlCosts.setDisplayLabel("Loan Costs Subtotals (A + B + C)");
				List<INTEGRATEDDISCLOSURESUBSECTIONPAYMENT> integrateddisclosuresubsectionpayments =  integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESUBSECTIONPAYMENTS().getINTEGRATEDDISCLOSURESUBSECTIONPAYMENT();
				for(INTEGRATEDDISCLOSURESUBSECTIONPAYMENT integrateddisclosuresubsectionpayment : integrateddisclosuresubsectionpayments)
				{
					if(("Buyer").equalsIgnoreCase(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaidByType().getValue().value()))
					{
						if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentTimingType().getValue().value()))
							tlCosts.setBpAtClosing(StringFormatter.NODOLLARS.formatString(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString()));
						else
							tlCosts.setBpB4Closing(StringFormatter.NODOLLARS.formatString(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString()));
					}
					else if(("Seller").equalsIgnoreCase(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaidByType().getValue().value()))
					{
						if(("AtClosing").equalsIgnoreCase(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentTimingType().getValue().value()))
							tlCosts.setBpAtClosing(StringFormatter.NODOLLARS.formatString(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString()));
						else
							tlCosts.setBpB4Closing(StringFormatter.NODOLLARS.formatString(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString()));
					}
					if("Lender".equalsIgnoreCase(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaidByType().getValue().value()))
						tlCosts.setLenderStatus("YES");
					else
						tlCosts.setLenderStatus("NO");
				}
			}
		return tlCosts;
	}
	
	
	private Prepaids addPrepaidByType(List<PREPAIDITEM> prepaidItems, String prepaidType)
	{
		Prepaids prepaids = new Prepaids();
		String label = "";
		label = StringFormatter.CAMEL.formatString(prepaidType);
		if(prepaidType.equalsIgnoreCase("HomeownersInsurancePremium")){
		      label = "Homeowner's Insurance Premium";
		}
		
		PREPAIDITEM found = null;
		for (PREPAIDITEM prepaid : prepaidItems)
			if ((prepaidType).equalsIgnoreCase(prepaid.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value())) {
				found = prepaid;
				break;
			}
		boolean to = false;
		if(null != found)
			to = true;
		
		if (found == null)
		{
			prepaids.setDisplayLabel(label);
			prepaids.setFeeType(prepaidType);
			
		}
			else
			prepaids = PrepaidCostsTableRow(found, to, label);
		
		return prepaids;
	}
	
	private boolean isPropertyTax(String type)
	{
		if(null != type)
		return	   type.equalsIgnoreCase("BoroughPropertyTax")
				|| type.equalsIgnoreCase("CityPropertyTax")
				|| type.equalsIgnoreCase("CountyPropertyTax")
				|| type.equalsIgnoreCase("DistrictPropertyTax")
				|| type.equalsIgnoreCase("PropertyTaxes")
				|| type.equalsIgnoreCase("StatePropertyTax")
				|| type.equalsIgnoreCase("TownPropertyTax");
		return false;
	}
	
	private Prepaids PrepaidCostsTableRow(PREPAIDITEM prepaidItem, boolean to, String label) 
	{
		Prepaids prepaids = new Prepaids();
		String str = label == null ? getPrepaidPaidToLabel(prepaidItem) : label;
		String buyerOutsideClosingAmount = "";
		String buyerAtClosingAmount = "";
		String sellerOutsideClosingAmount = "";
		String sellerAtClosingAmount = "";
		String otherAmount = "";
		String value = "";
		PrepaidsModel prepaid = Convertor.getPrepaidModel(prepaidItem);
		if (to)
		{
			if(("PrepaidInterest").equalsIgnoreCase(prepaid.getType()))
			{
				prepaids.setMonths(prepaid.getPrepaidItemPerDiemAmount());
				prepaids.setToDate(prepaid.getPrepaidItemPaidFromDate());
				prepaids.setFromDate(prepaid.getPrepaidItemPaidThroughDate());
			}
			else
			{
				if(null != prepaid.getPrepaidItemMonthsPaidCount() && !"".equalsIgnoreCase(prepaid.getPrepaidItemMonthsPaidCount()) ){
					 prepaids.setMonths(prepaid.getPrepaidItemMonthsPaidCount());
					if (null != prepaid.getPaymentToEntity() && !"".equalsIgnoreCase(prepaid.getPaymentToEntity()) ){
						prepaids.setToEntity(" to " + prepaid.getPaymentToEntity());
					}
				}
			}
		}
		
		List<PREPAIDITEMPAYMENT> prepaidPayments = prepaidItem.getPREPAIDITEMPAYMENTS().getPREPAIDITEMPAYMENT();
		for(PREPAIDITEMPAYMENT prepaidPayment :prepaidPayments)
		{
			if( null != prepaidPayment.getPrepaidItemPaymentPaidByType())
				{
					String paidBy = prepaidPayment.getPrepaidItemPaymentPaidByType().getValue().value();
					if( "Buyer".equalsIgnoreCase(paidBy)) 
						if("BeforeClosing".equalsIgnoreCase(prepaidPayment.getPrepaidItemPaymentTimingType().getValue().value()))
							buyerOutsideClosingAmount = prepaidPayment.getPrepaidItemActualPaymentAmount().getValue().toPlainString();
						else
							buyerAtClosingAmount = prepaidPayment.getPrepaidItemActualPaymentAmount().getValue().toPlainString();
					else if("Seller".equalsIgnoreCase(paidBy))
						if("BeforeClosing".equalsIgnoreCase(prepaidPayment.getPrepaidItemPaymentTimingType().getValue().value()))
							sellerOutsideClosingAmount = prepaidPayment.getPrepaidItemActualPaymentAmount().getValue().toPlainString();
						else
							sellerAtClosingAmount = prepaidPayment.getPrepaidItemActualPaymentAmount().getValue().toPlainString();
					else
						otherAmount = prepaidPayment.getPrepaidItemActualPaymentAmount().getValue().toPlainString();
				
					if("Lender".equalsIgnoreCase(paidBy))
						prepaids.setLenderStatus("YES");
					else
						prepaids.setLenderStatus("NO");
				}
		
			}
		prepaids.setDisplayLabel(StringFormatter.CAMEL.formatString(str));
		prepaids.setFeeType(prepaid.getType());
		value = buyerAtClosingAmount;
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
			prepaids.setBpAtClosing(StringFormatter.NODOLLARS.formatString(value));
		value = buyerOutsideClosingAmount;
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
			prepaids.setBpB4Closing(StringFormatter.NODOLLARS.formatString(value));
		value = sellerAtClosingAmount;
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
			prepaids.setSpAtClosing(StringFormatter.NODOLLARS.formatString(value));
		value = sellerOutsideClosingAmount;
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
			prepaids.setSpB4Closing(StringFormatter.NODOLLARS.formatString(value));
		value = otherAmount;
		String prefix = otherAmount.equalsIgnoreCase("Lender") ? "(L)": "";
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
		prepaids.setPaidByOthers(prefix	+ StringFormatter.NODOLLARS.formatString(value));
		
		return prepaids;
		
	}
	
	private String getPrepaidPaidToLabel(PREPAIDITEM prepaidItem)
	{
		String value = "";
		if(null != prepaidItem.getPREPAIDITEMDETAIL().getFeePaidToType())
			value = prepaidItem.getPREPAIDITEMDETAIL().getFeePaidToType().getValue().value();
			if ("Other".equalsIgnoreCase(value))
				value = prepaidItem.getPREPAIDITEMDETAIL().getFeePaidToTypeOtherDescription().getValue().value();
			
		return StringFormatter.CAMEL.formatString(value);
	}
	
	private boolean checkOtherPrepaids(String prepaidType)
	{
		if("HomeownersInsurancePremium".equalsIgnoreCase(prepaidType) || "MortgageInsurancePremium".equalsIgnoreCase(prepaidType) || "PrepaidInterest".equalsIgnoreCase(prepaidType)
				||"Property Taxes".equalsIgnoreCase(prepaidType) || isPropertyTax(prepaidType) || null == prepaidType || ("").equals(prepaidType) )
			return false;
		return true;
	}
	
	private boolean checkOtherEscrows(String escrowType)
	{
		if("HomeownersInsurance".equalsIgnoreCase(escrowType) || "MortgageInsurance".equalsIgnoreCase(escrowType) || "PrepaidInterest".equalsIgnoreCase(escrowType)
				||"Property Taxes".equalsIgnoreCase(escrowType) || isPropertyTax(escrowType) ||null == escrowType || "".equals(escrowType))
			return false;
		return true;
	}
	
	private IEPatClosing addEscrowByType(List<ESCROWITEM> escrows, String escrowType) {
		
		IEPatClosing iepAtClosing = new IEPatClosing();
		
		String label = StringFormatter.CAMEL.formatString(escrowType);
		if(label.equalsIgnoreCase("Homeowners Insurance")){
		      label = "Homeowner's Insurance";
		}
		EscrowsModel found = null;
		for (ESCROWITEM escrowItem : escrows)
		{
			EscrowsModel escrow =	Convertor.getEscrowModel(escrowItem);
			if (null != escrow.getType() && escrow.getType().equalsIgnoreCase(escrowType)) {
				found = escrow;
				break;
			}
		}
		if(null != found) 
			iepAtClosing = EscrowCostsTableRow(found, true, label);
		
		return iepAtClosing;
	}
	
	private IEPatClosing EscrowCostsTableRow(EscrowsModel found, boolean to, String label)
	{
		IEPatClosing iepAtClosing = new IEPatClosing();
		String str = label == null ? found.getLabel() : label;
		String buyerOutsideClosingAmount = "";
		String buyerAtClosingAmount = "";
		String sellerOutsideClosingAmount = "";
		String sellerAtClosingAmount = "";
		String otherAmount = "";
		if (to)
		{
			iepAtClosing.setEscrowAmount(found.getMonthlyPaymentAmount());
			iepAtClosing.setToEntity(found.getCollectedNumberOfMonthsCount());
		}	
		
		iepAtClosing.setDisplayLabel(str);
		iepAtClosing.setFeeType(found.getType());
		buyerAtClosingAmount = found.getBuyerAtClosingAmount();
		if (!buyerAtClosingAmount.equals("") && StringFormatter.doubleValue(buyerAtClosingAmount) != 0)
			iepAtClosing.setBpAtClosing(StringFormatter.NODOLLARS.formatString(buyerAtClosingAmount));
		buyerOutsideClosingAmount = found.getBuyerOutsideClosingAmount();
		if (!buyerOutsideClosingAmount.equals("") && StringFormatter.doubleValue(buyerOutsideClosingAmount) != 0)
			iepAtClosing.setBpB4Closing(StringFormatter.NODOLLARS.formatString(buyerOutsideClosingAmount));
		sellerAtClosingAmount = found.getSellerAtClosingAmount();
		if (!sellerAtClosingAmount.equals("") && StringFormatter.doubleValue(sellerAtClosingAmount) != 0)
			iepAtClosing.setSpAtClosing(StringFormatter.NODOLLARS.formatString(sellerAtClosingAmount));
		sellerOutsideClosingAmount = found.getSellerOutsideClosingAmount();
		if (!sellerOutsideClosingAmount.equals("") && StringFormatter.doubleValue(sellerOutsideClosingAmount) != 0)
			iepAtClosing.setSpB4Closing(StringFormatter.NODOLLARS.formatString(sellerOutsideClosingAmount));
		otherAmount = found.getOtherAmount();
		String prefix = otherAmount.equalsIgnoreCase("Lender") ? "(L)": "";
		if (!otherAmount.equals("") && StringFormatter.doubleValue(otherAmount) != 0)
		iepAtClosing.setPaidByOthers(StringFormatter.NODOLLARS.formatString(otherAmount));
		iepAtClosing.setLenderStatus(found.getLenderStatus());	
		return iepAtClosing;
	
	}
}
