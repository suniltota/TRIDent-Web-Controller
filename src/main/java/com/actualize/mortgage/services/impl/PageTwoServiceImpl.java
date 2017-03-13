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
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts.OriginationCharges;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts.SBDidNotShopFor;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts.SBDidShopFor;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts.TLCOSTS;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts.IEPatClosing;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts.OtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts.Prepaids;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts.TOGovtFees;
import com.actualize.mortgage.domainmodels.ClosingCostProperties;
import com.actualize.mortgage.services.PageTwoService;
import com.actualize.mortgage.utils.Convertor;
import com.actualize.mortgage.utils.DocumentType;
import com.actualize.mortgage.utils.EscrowsModel;
import com.actualize.mortgage.utils.PrepaidsModel;
import com.actualize.mortgage.utils.StringFormatter;

public class PageTwoServiceImpl implements PageTwoService{

	@Override
	public ClosingCostDetailsLoanCosts createClosingCostDetailsLoanCosts(DOCUMENT document) {
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();

		List<OriginationCharges> originationChargeList = new LinkedList<>();
		List<SBDidNotShopFor> sbDidNotShopFors = new LinkedList<>();
		List<SBDidShopFor> sbDidShopFors = new LinkedList<>();
		TLCOSTS tlCosts = closingCostDetailsLoanCosts.new TLCOSTS();
		
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
						OriginationCharges originationCharge = closingCostDetailsLoanCosts.new OriginationCharges();
							originationCharge.setFeeType(closingCostProperties.getFeeType());
							originationCharge.setBpAtClosing(closingCostProperties.getBpAtClosing());
							originationCharge.setBpB4Closing(closingCostProperties.getBpB4Closing());
							originationCharge.setSpAtClosing(closingCostProperties.getSpAtClosing());
							originationCharge.setSpB4Closing(closingCostProperties.getSpB4Closing());
							originationCharge.setPaidByOthers(closingCostProperties.getPaidByOthers());
							originationChargeList.add(originationCharge);
					}
			}
			else if("ServicesBorrowerDidNotShopFor".equalsIgnoreCase(fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value()))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = LoanCostsTable(fee,"ServicesBorrowerDidNotShopFor");
					if(null != closingCostProperties.getFeeType())
					{
						SBDidNotShopFor sbDidNotShopFor = closingCostDetailsLoanCosts.new SBDidNotShopFor();
							sbDidNotShopFor.setFeeType(closingCostProperties.getFeeType());
							sbDidNotShopFor.setBpAtClosing(closingCostProperties.getBpAtClosing());
							sbDidNotShopFor.setBpB4Closing(closingCostProperties.getBpB4Closing());
							sbDidNotShopFor.setSpAtClosing(closingCostProperties.getSpAtClosing());
							sbDidNotShopFor.setSpB4Closing(closingCostProperties.getSpB4Closing());
							sbDidNotShopFor.setPaidByOthers(closingCostProperties.getPaidByOthers());
							sbDidNotShopFor.setToEntity(closingCostProperties.getToEntity());
						sbDidNotShopFors.add(sbDidNotShopFor);
					}
			}
			else if("ServicesBorrowerDidShopFor".equalsIgnoreCase(fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value()))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties = LoanCostsTable(fee,"ServicesBorrowerDidShopFor");
					if(null != closingCostProperties.getFeeType())
					{
						SBDidShopFor sbDidShopFor = closingCostDetailsLoanCosts.new SBDidShopFor();
						sbDidShopFor.setFeeType(closingCostProperties.getFeeType());
						sbDidShopFor.setBpAtClosing(closingCostProperties.getBpAtClosing());
						sbDidShopFor.setBpB4Closing(closingCostProperties.getBpB4Closing());
						sbDidShopFor.setSpAtClosing(closingCostProperties.getSpAtClosing());
						sbDidShopFor.setSpB4Closing(closingCostProperties.getSpB4Closing());
						sbDidShopFor.setPaidByOthers(closingCostProperties.getPaidByOthers());
						sbDidShopFor.setToEntity(closingCostProperties.getToEntity());
							sbDidShopFors.add(sbDidShopFor);
					}
			}
		}
		
		Collections.sort(originationChargeList,new Comparator<OriginationCharges>(){
			@Override
			public int compare(OriginationCharges o1, OriginationCharges o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		Collections.sort(sbDidNotShopFors,new Comparator<SBDidNotShopFor>(){

			@Override
			public int compare(SBDidNotShopFor o1, SBDidNotShopFor o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		
		Collections.sort(sbDidShopFors,new Comparator<SBDidShopFor>(){

			@Override
			public int compare(SBDidShopFor o1, SBDidShopFor o2) {
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
		
		List<TOGovtFees> tOGovtFeesList = new ArrayList();
		List<Prepaids> prepaidsList = new LinkedList<>();
		List<IEPatClosing> iePatClosingList = new LinkedList<>();
		List<OtherCosts> otherCostsList = new LinkedList<>();
		
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
					TOGovtFees toGovtFee = closingCostDetailsOtherCosts.new TOGovtFees();
						toGovtFee.setFeeType(closingCostProperties.getFeeType());
						toGovtFee.setBpAtClosing(closingCostProperties.getBpAtClosing());
						toGovtFee.setBpB4Closing(closingCostProperties.getBpB4Closing());
						toGovtFee.setSpAtClosing(closingCostProperties.getSpAtClosing());
						toGovtFee.setSpB4Closing(closingCostProperties.getSpB4Closing());
						toGovtFee.setPaidByOthers(closingCostProperties.getPaidByOthers());
					tOGovtFeesList.add(toGovtFee);	
				}
			}
			
		}
		Collections.sort(tOGovtFeesList,new Comparator<TOGovtFees>(){
			@Override
			public int compare(TOGovtFees o1, TOGovtFees o2) {
				return o1.getFeeType().compareTo(o2.getFeeType());
			}
		});
		String str = "Recording Fees                                          " + deedAmt + mrtgAmt;
		
		if (recordingFee == null)
		{
			TOGovtFees toGovtFee = closingCostDetailsOtherCosts.new TOGovtFees();
				toGovtFee.setFeeType(str);
			tOGovtFeesList.add(0, toGovtFee);
		}	
		else
		{
			ClosingCostProperties closingCostProperties = new ClosingCostProperties();	
			closingCostProperties = FeeCostsTableRow(recordingFee, false, str, null);
			TOGovtFees toGovtFee = closingCostDetailsOtherCosts.new TOGovtFees();
				toGovtFee.setFeeType(closingCostProperties.getFeeType());
				toGovtFee.setBpAtClosing(closingCostProperties.getBpAtClosing());
				toGovtFee.setBpB4Closing(closingCostProperties.getBpB4Closing());
				toGovtFee.setSpAtClosing(closingCostProperties.getSpAtClosing());
				toGovtFee.setSpB4Closing(closingCostProperties.getSpB4Closing());
				toGovtFee.setPaidByOthers(closingCostProperties.getPaidByOthers());
			tOGovtFeesList.add(0, toGovtFee);
		}
		
		//DOCUMENT.DEAL_SETS.DEAL_SET.DEALS.DEAL.LOANS.LOAN.CLOSING_INFORMATION.PREPAID_ITEMS
		List<PREPAIDITEM> prepaidItems = Convertor.getPrepaidItemList(document);
		
		//8.5
		List<String> prepaidItemsToDisplay = new LinkedList<>();
		prepaidItemsToDisplay.add("HomeownersInsurancePremium");
		prepaidItemsToDisplay.add("MortgageInsurancePremium");
		prepaidItemsToDisplay.add("PrepaidInterest");
		
		for(String prepaidItem : prepaidItemsToDisplay)
		{
			ClosingCostProperties closingCostProperties = new ClosingCostProperties();
			if(null != prepaidItems)
			closingCostProperties = addPrepaidByType(prepaidItems, prepaidItem);
		
			if(null != closingCostProperties.getFeeType())
			{
				Prepaids prepaids = closingCostDetailsOtherCosts.new Prepaids();
					prepaids.setFeeType(closingCostProperties.getFeeType());
					prepaids.setBpAtClosing(closingCostProperties.getBpAtClosing());
					prepaids.setBpB4Closing(closingCostProperties.getBpB4Closing());
					prepaids.setSpAtClosing(closingCostProperties.getSpAtClosing());
					prepaids.setSpB4Closing(closingCostProperties.getSpB4Closing());
					prepaids.setPaidByOthers(closingCostProperties.getPaidByOthers());
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
			Prepaids prepaids = closingCostDetailsOtherCosts.new Prepaids();
				prepaids.setFeeType("Property Taxes ");
			prepaidsList.add(prepaids);
		}
			//addRow(new CostsTableRow().add(Columns.CostLabel, "Property Taxes "));
		else
		{
		//	addRow(new PrepaidCostsTableRow(propertyTaxes, getPrepaidItemMonthsPaidCount(propertyTaxes), "Property Taxes"));
			ClosingCostProperties closingCostProperties = new ClosingCostProperties();
			closingCostProperties =	PrepaidCostsTableRow(propertyTaxes, getPrepaidItemMonthsPaidCount(propertyTaxes), "Property Taxes");
			Prepaids prepaids = closingCostDetailsOtherCosts.new Prepaids();
				prepaids.setFeeType(closingCostProperties.getFeeType());
				prepaids.setBpAtClosing(closingCostProperties.getBpAtClosing());
				prepaids.setBpB4Closing(closingCostProperties.getBpB4Closing());
				prepaids.setSpAtClosing(closingCostProperties.getSpAtClosing());
				prepaids.setSpB4Closing(closingCostProperties.getSpB4Closing());
				prepaids.setPaidByOthers(closingCostProperties.getPaidByOthers());
			prepaidsList.add(prepaids);
		}
		if(null != prepaidItems)
		for(PREPAIDITEM prepaiditem : prepaidItems)
		{
			String prepaidType = prepaiditem.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value();
			if(checkOtherPrepaids(prepaidType))
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
				closingCostProperties =	PrepaidCostsTableRow(propertyTaxes, getPrepaidItemMonthsPaidCount(prepaiditem), prepaidType);
				Prepaids prepaids = closingCostDetailsOtherCosts.new Prepaids();
					prepaids.setFeeType(closingCostProperties.getFeeType());
					prepaids.setBpAtClosing(closingCostProperties.getBpAtClosing());
					prepaids.setBpB4Closing(closingCostProperties.getBpB4Closing());
					prepaids.setSpAtClosing(closingCostProperties.getSpAtClosing());
					prepaids.setSpB4Closing(closingCostProperties.getSpB4Closing());
					prepaids.setPaidByOthers(closingCostProperties.getPaidByOthers());
				prepaidsList.add(prepaids);
			}
		}
		
		//ESCROWS
		List<ESCROWITEM> escrowsItems = (null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getESCROW()) ? document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getESCROW().getESCROWITEMS().getESCROWITEM(): null;
		
		List<String> escrowItemsToDisplay = new LinkedList<>();
		escrowItemsToDisplay.add("HomeownersInsurance");
		escrowItemsToDisplay.add("MortgageInsurance");
		
		for(String escrowItem : escrowItemsToDisplay)
		{
			ClosingCostProperties closingCostProperties = new ClosingCostProperties();
			if(null != escrowsItems)
			closingCostProperties = addEscrowByType(escrowsItems, escrowItem);
		
			if(null != closingCostProperties.getFeeType())
			{
				IEPatClosing iePatClosing = closingCostDetailsOtherCosts.new IEPatClosing();
					iePatClosing.setFeeType(closingCostProperties.getFeeType());
					iePatClosing.setBpAtClosing(closingCostProperties.getBpAtClosing());
					iePatClosing.setBpB4Closing(closingCostProperties.getBpB4Closing());
					iePatClosing.setSpAtClosing(closingCostProperties.getSpAtClosing());
					iePatClosing.setSpB4Closing(closingCostProperties.getSpB4Closing());
					iePatClosing.setPaidByOthers(closingCostProperties.getPaidByOthers());
				iePatClosingList.add(iePatClosing);	
			}
			else
			{
				IEPatClosing iePatClosing = closingCostDetailsOtherCosts.new IEPatClosing();
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
			if (escrow.getLabel().equals("Property Tax")) {
				propertyTaxesEscrow = escrow;
				break;
			} 
			else if (propertyTaxesEscrow == null && isPropertyTax(escrow.getType())) {
				propertyTaxesEscrow = escrow;
			}
		}
			if (propertyTaxesEscrow == null)
			{
				IEPatClosing iePatClosing = closingCostDetailsOtherCosts.new IEPatClosing();
				iePatClosing.setFeeType("Property Taxes");
				iePatClosingList.add(iePatClosing);
			}
			else
				{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
				closingCostProperties =	EscrowCostsTableRow( propertyTaxesEscrow, getEscrowMonthsPaidCount(propertyTaxesEscrow), "Property Taxes");
				IEPatClosing iePatClosing = closingCostDetailsOtherCosts.new IEPatClosing();
					iePatClosing.setFeeType(closingCostProperties.getFeeType());
					iePatClosing.setBpAtClosing(closingCostProperties.getBpAtClosing());
					iePatClosing.setBpB4Closing(closingCostProperties.getBpB4Closing());
					iePatClosing.setSpAtClosing(closingCostProperties.getSpAtClosing());
					iePatClosing.setSpB4Closing(closingCostProperties.getSpB4Closing());
					iePatClosing.setPaidByOthers(closingCostProperties.getPaidByOthers());
				iePatClosingList.add(iePatClosing);
				}
			if(null != escrowsItems)
			for (ESCROWITEM escrowItem : escrowsItems)
			{
				EscrowsModel escrow = Convertor.getEscrowModel(escrowItem);
				if((null != escrow.getLabel() || !escrow.getLabel().isEmpty() ) ||checkOtherEscrows(escrow.getLabel()))
				{
					ClosingCostProperties closingCostProperties = new ClosingCostProperties();
					closingCostProperties =	EscrowCostsTableRow(escrow, getEscrowMonthsPaidCount(escrow), escrow.getLabel());
					Prepaids iePatClosing = closingCostDetailsOtherCosts.new Prepaids();
						iePatClosing.setFeeType(closingCostProperties.getFeeType());
						iePatClosing.setBpAtClosing(closingCostProperties.getBpAtClosing());
						iePatClosing.setBpB4Closing(closingCostProperties.getBpB4Closing());
						iePatClosing.setSpAtClosing(closingCostProperties.getSpAtClosing());
						iePatClosing.setSpB4Closing(closingCostProperties.getSpB4Closing());
						iePatClosing.setPaidByOthers(closingCostProperties.getPaidByOthers());
					prepaidsList.add(iePatClosing);
				}
			}
	
		//Other
		for(FEE fee : fees)
		{
			String disclosureType = fee.getFEEDETAIL().getIntegratedDisclosureSectionType().getValue().value();
			if( "OtherCosts".equalsIgnoreCase(disclosureType) )
			{
				ClosingCostProperties closingCostProperties = new ClosingCostProperties();
				closingCostProperties =	FeeCostsTableRow(fee, true, null, null);
				OtherCosts otherCosts = closingCostDetailsOtherCosts.new OtherCosts();
					otherCosts.setFeeType(closingCostProperties.getFeeType());
					otherCosts.setBpAtClosing(closingCostProperties.getBpAtClosing());
					otherCosts.setBpB4Closing(closingCostProperties.getBpB4Closing());
					otherCosts.setSpAtClosing(closingCostProperties.getSpAtClosing());
					otherCosts.setSpB4Closing(closingCostProperties.getSpB4Closing());
					otherCosts.setPaidByOthers(closingCostProperties.getPaidByOthers());
				otherCostsList.add(otherCosts);
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

		totalOtherCosts.setFeeType("Other Costs Subtotals (E + F + G + H)");
		ClosingCostsSubTotal.setFeeType("Closing Costs Subtotals (D + I)");
		LenderCredits.setFeeType("Lender Credits");
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
			if(null != fee.getFEEDETAIL().getFeePaidToType())
			{
				if (("LoanDiscountPoints").equalsIgnoreCase(fee.getFEEDETAIL().getFeeType().getValue().value())){
					if(null !=fee.getFEEDETAIL().getFeeTotalPercent() && !"0.0000".equalsIgnoreCase(fee.getFEEDETAIL().getFeeTotalPercent().getValue().toPlainString())){
						closingCostProperties = FeeCostsTableRow(fee, true, StringFormatter.PERCENTWITHOUTPRECEEDING.formatString(fee.getFEEDETAIL().getFeeTotalPercent().getValue().toPlainString()) + " of Loan Amount (Points)", null);
					}
					else{
						closingCostProperties = FeeCostsTableRow(fee, true, "      % of Loan Amount (Points)",null);
					}
				}
				else
					closingCostProperties = FeeCostsTableRow(fee, true, null, null);
			}
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
		else if("Other".equalsIgnoreCase(label))
			strLabel = fee.getFEEDETAIL().getFeeType().getDisplayLabelText();
		else
			strLabel = label;
			
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
			closingCostProperties.setFeeType(strLabel);
		else
			closingCostProperties.setFeeType("");
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
		String prefix = otherAmount.equalsIgnoreCase("Lender") ? "(L)": "";
		if (!str.equals("") && StringFormatter.doubleValue(str) != 0)
			closingCostProperties.setPaidByOthers(prefix	+ StringFormatter.NODOLLARS.formatString(str));
		
		return closingCostProperties;
	}
	
	private TLCOSTS calculateTLCosts(INTEGRATEDDISCLOSURESECTIONSUMMARY integrateddisclosuresectionsummary)
	{
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();
			TLCOSTS tlCosts = closingCostDetailsLoanCosts.new TLCOSTS();
		if(null != integrateddisclosuresectionsummary)	
		if(null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType() &&
				"LoanCostsSubtotal".equalsIgnoreCase(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().value()))
			{
				tlCosts.setFeeType("Loan Costs Subtotals (A + B + C)");
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
				}
			}
		return tlCosts;
	}
	
	
	private ClosingCostProperties addPrepaidByType(List<PREPAIDITEM> prepaidItems, String prepaidType)
	{
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		
		String label = StringFormatter.CAMEL.formatString(prepaidType);
		if(label.equalsIgnoreCase("Homeowners Insurance Premium")){
		      label = "Homeowner's Insurance Premium";
		}
		PREPAIDITEM found = null;
		for (PREPAIDITEM prepaid : prepaidItems)
			if ((prepaidType).equalsIgnoreCase(prepaid.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value())) {
				found = prepaid;
				break;
			}
		String to = "";
		//if(null != found)
			//to = prepaidType.equalsIgnoreCase("PrepaidInterest") ? getPrepaidPerDiemPaidCount(found) : getPrepaidItemMonthsPaidCount(found);
		
		if (found == null)
		//	addRow(new CostsTableRow(false).add(Columns.CostLabel, label + " " + to));		
		{
			closingCostProperties.setFeeType(label+ " "+to);
		}
			else
			closingCostProperties = PrepaidCostsTableRow(found, to, label);
		
		return closingCostProperties;
	}
	
	private boolean isPropertyTax(String type)
	{
		return	   type.equalsIgnoreCase("BoroughPropertyTax")
				|| type.equalsIgnoreCase("CityPropertyTax")
				|| type.equalsIgnoreCase("CountyPropertyTax")
				|| type.equalsIgnoreCase("DistrictPropertyTax")
				|| type.equalsIgnoreCase("PropertyTaxes")
				|| type.equalsIgnoreCase("StatePropertyTax")
				|| type.equalsIgnoreCase("TownPropertyTax");
	}
	
	private String getPrepaidPerDiemPaidCount(PREPAIDITEM prepaidItem) {
		
		if (prepaidItem == null)
			return "(   per day from   to   )";
		else
		{
			PrepaidsModel prepaid = Convertor.getPrepaidModel(prepaidItem);
			
			return "( " + StringFormatter.NODOLLARS.formatString(prepaid.getPrepaidItemPerDiemAmount()) + "  per day from " +
			StringFormatter.DATE.formatString(prepaid.getPrepaidItemPaidFromDate()) + " to " +
			StringFormatter.DATE.formatString(prepaid.getPrepaidItemPaidThroughDate()) + ")";
		}
			
	}
	
	private String getPrepaidItemMonthsPaidCount(PREPAIDITEM prepaidItem)
	{
		PrepaidsModel prepaid = Convertor.getPrepaidModel(prepaidItem);
		String string = "";
		
		if(null != prepaid.getPrepaidItemMonthsPaidCount() && !"".equalsIgnoreCase(prepaid.getPrepaidItemMonthsPaidCount()) ){
			string = "( " + prepaid.getPrepaidItemMonthsPaidCount() + " mo.)  " ;
			if (null != prepaid.getPaymentToEntity() && !"".equalsIgnoreCase(prepaid.getPaymentToEntity()) ){
				string = string + " to " + prepaid.getPaymentToEntity();
			}
		}
		else {
			if(prepaid.getLabel() == ""){
		    string = "";
		    }
		}
		return string;
	}
	
	private ClosingCostProperties PrepaidCostsTableRow(PREPAIDITEM prepaidItem, String to, String label) 
	{
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		String str = label == null ? getPrepaidPaidToLabel(prepaidItem) : label;
		String buyerOutsideClosingAmount = "";
		String buyerAtClosingAmount = "";
		String sellerOutsideClosingAmount = "";
		String sellerAtClosingAmount = "";
		String otherAmount = "";
		String value = "";
		if (to!=null)
			str = str + " " + to;
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
				}
		
			}
		closingCostProperties.setFeeType(str);
		value = buyerAtClosingAmount;
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
			closingCostProperties.setBpAtClosing(StringFormatter.NODOLLARS.formatString(value));
		value = buyerOutsideClosingAmount;
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
			closingCostProperties.setBpB4Closing(StringFormatter.NODOLLARS.formatString(value));
		value = sellerAtClosingAmount;
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
			closingCostProperties.setSpAtClosing(StringFormatter.NODOLLARS.formatString(value));
		value = sellerOutsideClosingAmount;
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
			closingCostProperties.setSpB4Closing(StringFormatter.NODOLLARS.formatString(value));
		value = otherAmount;
		String prefix = otherAmount.equalsIgnoreCase("Lender") ? "(L)": "";
		if (!value.equals("") && StringFormatter.doubleValue(value) != 0)
		closingCostProperties.setPaidByOthers(prefix	+ StringFormatter.NODOLLARS.formatString(value));
	
		return closingCostProperties;
		
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
		if(null != prepaidType)
		if("HomeownersInsurancePremium".equalsIgnoreCase(prepaidType) || "MortgageInsurancePremium".equalsIgnoreCase(prepaidType) || "PrepaidInterest".equalsIgnoreCase(prepaidType)
				||"Property Taxes".equalsIgnoreCase(prepaidType) || isPropertyTax(prepaidType))
			return false;
		return true;
	}
	
	private boolean checkOtherEscrows(String escrowType)
	{
		if(null != escrowType)
		if("HomeownersInsurance".equalsIgnoreCase(escrowType) || "MortgageInsurance".equalsIgnoreCase(escrowType) || "PrepaidInterest".equalsIgnoreCase(escrowType)
				||"Property Taxes".equalsIgnoreCase(escrowType) || isPropertyTax(escrowType))
			return false;
		return true;
	}
	
	
	
	private ClosingCostProperties addEscrowByType(List<ESCROWITEM> escrows, String prepaidType) {
		
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		
		String label = StringFormatter.CAMEL.formatString(prepaidType);
		if(label.equalsIgnoreCase("Homeowners Insurance")){
		      label = "Homeowner's Insurance";
		}
		EscrowsModel found = null;
		for (ESCROWITEM escrowItem : escrows)
		{
			EscrowsModel escrow =	Convertor.getEscrowModel(escrowItem);
			if (null != escrow.getType() && escrow.getType().equalsIgnoreCase(prepaidType)) {
				found = escrow;
				break;
			}
		}
		if(null != found) 
			closingCostProperties = EscrowCostsTableRow(found, getEscrowMonthsPaidCount(found), label);
		
		return closingCostProperties;
	}
	
	private ClosingCostProperties EscrowCostsTableRow(EscrowsModel found, String to, String label)
	{
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		String str = label == null ? found.getLabel() : label;
		String buyerOutsideClosingAmount = "";
		String buyerAtClosingAmount = "";
		String sellerOutsideClosingAmount = "";
		String sellerAtClosingAmount = "";
		String otherAmount = "";
		String value = "";
		if (to!=null)
			str = str + " " + to;
		
		closingCostProperties.setFeeType(str);
		buyerAtClosingAmount = found.getBuyerAtClosingAmount();
		if (!buyerAtClosingAmount.equals("") && StringFormatter.doubleValue(buyerAtClosingAmount) != 0)
			closingCostProperties.setBpAtClosing(StringFormatter.NODOLLARS.formatString(buyerAtClosingAmount));
		buyerOutsideClosingAmount = found.getBuyerOutsideClosingAmount();
		if (!buyerOutsideClosingAmount.equals("") && StringFormatter.doubleValue(buyerOutsideClosingAmount) != 0)
			closingCostProperties.setBpB4Closing(StringFormatter.NODOLLARS.formatString(buyerOutsideClosingAmount));
		sellerAtClosingAmount = found.getSellerAtClosingAmount();
		if (!sellerAtClosingAmount.equals("") && StringFormatter.doubleValue(sellerAtClosingAmount) != 0)
			closingCostProperties.setSpAtClosing(StringFormatter.NODOLLARS.formatString(sellerAtClosingAmount));
		sellerOutsideClosingAmount = found.getSellerOutsideClosingAmount();
		if (!sellerOutsideClosingAmount.equals("") && StringFormatter.doubleValue(sellerOutsideClosingAmount) != 0)
			closingCostProperties.setSpB4Closing(StringFormatter.NODOLLARS.formatString(sellerOutsideClosingAmount));
		otherAmount = found.getOtherAmount();
		String prefix = otherAmount.equalsIgnoreCase("Lender") ? "(L)": "";
		if (!otherAmount.equals("") && StringFormatter.doubleValue(otherAmount) != 0)
		closingCostProperties.setPaidByOthers(prefix	+ StringFormatter.NODOLLARS.formatString(otherAmount));
	
		return closingCostProperties;
	
	}
	
	private String getEscrowMonthsPaidCount(EscrowsModel found){
		if (found == null)
			return "  per month for    mo.";
		return StringFormatter.NODOLLARS.formatString(found.getMonthlyPaymentAmount()) + " per month for " + found.getCollectedNumberOfMonthsCount() + " mo.";
	}
}
