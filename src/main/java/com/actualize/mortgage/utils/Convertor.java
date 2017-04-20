package com.actualize.mortgage.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.ESCROWITEM;
import org.mismo.residential._2009.schemas.ESCROWITEMPAYMENT;
import org.mismo.residential._2009.schemas.FEE;
import org.mismo.residential._2009.schemas.FEEPAYMENT;
import org.mismo.residential._2009.schemas.FEEPAYMENTS;
import org.mismo.residential._2009.schemas.INTEGRATEDDISCLOSURESECTIONSUMMARY;
import org.mismo.residential._2009.schemas.INTEGRATEDDISCLOSURESUBSECTIONPAYMENT;
import org.mismo.residential._2009.schemas.PREPAIDITEM;


/**
 * This class is perform various operations such as conversions and extractions of MISMO Objects
 * @author sboragala
 *
 */
public class Convertor {
	
/*	public static String convertMonthsToDisplayFormat(Integer months){
	    int years = months / 12;
        int modMonths = months % 12;
        String maturity = "";
        if (months == 12)
            maturity = "1 year";
        else if (months < 24)
            maturity = Integer.toString(months) + " mo.";
        else if (modMonths == 0)
            maturity = Integer.toString(years) + " years";
        else
            maturity = Integer.toString(years) + " yr. " + Integer.toString(modMonths) + " mo.";
        return maturity;
	}
	
	/**
	 * 
	 * @param document
	 * @return Integrated Disclosuresection Summaries as a List
	 
	public static List<INTEGRATEDDISCLOSURESECTIONSUMMARY> getIntegrateddisclosuresectionsummaries(DOCUMENT document)
	{
		List<INTEGRATEDDISCLOSURESECTIONSUMMARY> integrateddisclosuresectionsummaries = new LinkedList<INTEGRATEDDISCLOSURESECTIONSUMMARY>();
			integrateddisclosuresectionsummaries = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSURESECTIONSUMMARIES().getINTEGRATEDDISCLOSURESECTIONSUMMARY();
		return integrateddisclosuresectionsummaries;
	}
	*//**
	 * 
	 * @param integratedDisclosureSectionType
	 * @param document
	 * @return Integrated Disclosure Section Summary for specific integrated DisclosureSectionType
	 *//*
	public static INTEGRATEDDISCLOSURESECTIONSUMMARY  getIntegratedDisclosureSectionSummary(String integratedDisclosureSectionType, DOCUMENT document){
		List<INTEGRATEDDISCLOSURESECTIONSUMMARY> integrateddisclosuresectionsummaries = getIntegrateddisclosuresectionsummaries(document);	
		for( INTEGRATEDDISCLOSURESECTIONSUMMARY  integrateddisclosuresectionsummary: integrateddisclosuresectionsummaries)
		{
			if(null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType() && null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionTotalAmount() )
			{
				if(integratedDisclosureSectionType.equalsIgnoreCase(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType().getValue().value()))
						return integrateddisclosuresectionsummary;
			}
		}
		return null;
	}
	
	*//**
	 * 
	 * @param integratedDisclosureSubSectionType
	 * @param document
	 * @return lender credits
	 *//*
	public static String getLenderCredits(String integratedDisclosureSubSectionType, DOCUMENT document )
	{
		String amount = "";
		List<INTEGRATEDDISCLOSURESECTIONSUMMARY> integrateddisclosuresectionsummaries = getIntegrateddisclosuresectionsummaries(document);
		List<INTEGRATEDDISCLOSURESUBSECTIONPAYMENT> integrateddisclosuresubsectionpayments = new LinkedList<>();
		for( INTEGRATEDDISCLOSURESECTIONSUMMARY  integrateddisclosuresectionsummary: integrateddisclosuresectionsummaries)
		{
			if(null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType())
			{
				if(integratedDisclosureSubSectionType.equalsIgnoreCase(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSubsectionType().getValue().value()))
					integrateddisclosuresubsectionpayments = integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESUBSECTIONPAYMENTS().getINTEGRATEDDISCLOSURESUBSECTIONPAYMENT();
				
				for(INTEGRATEDDISCLOSURESUBSECTIONPAYMENT integrateddisclosuresubsectionpayment : integrateddisclosuresubsectionpayments)
				{
					if(null != integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount())
						amount = integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString();
						amount = amount.replaceAll("-", "");
				}
			}
		}
		
		return amount;
	}
	
	*//**
	 * 
	 * @param document
	 * @return a map of IntegratedDisclosureSectionType and its specific Integrated Disclosure Section TotalAmount
	 *//*
	
	public static Map<String,String> getIntegratedDisclosureSectionTypes(DOCUMENT document)
	{
		List<INTEGRATEDDISCLOSURESECTIONSUMMARY> integrateddisclosuresectionsummaries = getIntegrateddisclosuresectionsummaries(document);
		Map<String,String> integratedDisclosureSectionTypeValues = new HashMap<>();
		for( INTEGRATEDDISCLOSURESECTIONSUMMARY  integrateddisclosuresectionsummary: integrateddisclosuresectionsummaries)
		{
			if(null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType() && null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionTotalAmount() )
			{
				integratedDisclosureSectionTypeValues.put(integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionType().getValue().value(), integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESECTIONSUMMARYDETAIL().getIntegratedDisclosureSectionTotalAmount().getValue().toPlainString());
			}
		}
		
		return integratedDisclosureSectionTypeValues;
	}
	*//**
	 * 
	 * @param document
	 * @return FEE List
	 *//*
	public static List<FEE> getFees(DOCUMENT document)
	{
		List<FEE> fees = new LinkedList<>();
			fees = document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getFEEINFORMATION().getFEES().getFEE();
		return fees;
	}
	
	public static List<PREPAIDITEM> getPrepaidItemList(DOCUMENT document)
	{
		List<PREPAIDITEM> prepaiditems = null != document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getCLOSINGINFORMATION().getPREPAIDITEMS() ? document.getDEALSETS().getDEALSET().getDEALS().getDEAL().getLOANS().getLOAN().getCLOSINGINFORMATION().getPREPAIDITEMS().getPREPAIDITEM(): null;
		
		return prepaiditems;
	}
	*//**
	 * 
	 * @param prepaidItem
	 * @return PrepaidsModel
	 *//*
	public static PrepaidsModel getPrepaidModel(PREPAIDITEM prepaidItem)
	{
		PrepaidsModel prepaidsModel = new PrepaidsModel();
		String label = "";
		
		if(null != prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemType())
		{
			label = prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemType().getDisplayLabelText();
			if(null == label || "".equals(label))
				label = prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value();
			if("Other".equalsIgnoreCase(label))
				label = prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemTypeOtherDescription().getValue();
			prepaidsModel.setLabel(StringFormatter.CAMEL.formatString(label));
			prepaidsModel.setType(prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value());
		}
			prepaidsModel.setType(null != prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue() ? prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemType().getValue().value(): "");
			prepaidsModel.setPrepaidItemPerDiemAmount(null != prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemPerDiemAmount() ? prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemPerDiemAmount().getValue().toPlainString(): "");
			prepaidsModel.setPrepaidItemPaidFromDate( null != prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemPaidFromDate() ? prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemPaidFromDate().getValue(): "");
			prepaidsModel.setPrepaidItemPaidThroughDate(null != prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemPaidThroughDate() ? prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemPaidThroughDate().getValue() : "");
			prepaidsModel.setPrepaidItemMonthsPaidCount(null != prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemMonthsPaidCount() ? Integer.toString(prepaidItem.getPREPAIDITEMDETAIL().getPrepaidItemMonthsPaidCount().getValue()):"");
			prepaidsModel.setIntegratedDisclosureSectionType(null != prepaidItem.getPREPAIDITEMDETAIL().getIntegratedDisclosureSectionType() ? prepaidItem.getPREPAIDITEMDETAIL().getIntegratedDisclosureSectionType().getValue().value() :"");
			prepaidsModel.setPaidToType(null != prepaidItem.getPREPAIDITEMDETAIL().getFeePaidToType() ? prepaidItem.getPREPAIDITEMDETAIL().getFeePaidToType().getValue().value() : "" );
			prepaidsModel.setPaymentToEntity(null != prepaidItem.getPREPAIDITEMPAIDTO() ? prepaidItem.getPREPAIDITEMPAIDTO().getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().getValue() : "" );
		
		return prepaidsModel;
		
	}
	
	public static EscrowsModel getEscrowModel(ESCROWITEM escrowItem){
		EscrowsModel escrowsModel = new EscrowsModel();
		String dLabel = "";
		if(null != escrowItem.getESCROWITEMDETAIL().getEscrowItemType())
		{
			dLabel = null != escrowItem.getESCROWITEMDETAIL().getEscrowItemType().getDisplayLabelText() ? escrowItem.getESCROWITEMDETAIL().getEscrowItemType().getDisplayLabelText() : "";
			if(null == dLabel || dLabel.isEmpty())
				dLabel = null != escrowItem.getESCROWITEMDETAIL().getEscrowItemType().getValue() ? StringFormatter.CAMEL.formatString(escrowItem.getESCROWITEMDETAIL().getEscrowItemType().getValue().value()):"";
			if("Other".equalsIgnoreCase(dLabel))
			{
				if(null != escrowItem.getESCROWITEMDETAIL().getEscrowItemTypeOtherDescription() && !escrowItem.getESCROWITEMDETAIL().getEscrowItemTypeOtherDescription().getValue().isEmpty())
					escrowsModel.setLabel(escrowItem.getESCROWITEMDETAIL().getEscrowItemTypeOtherDescription().getValue());
			}
			else
				escrowsModel.setLabel(dLabel);
				
			escrowsModel.setType(null != escrowItem.getESCROWITEMDETAIL().getEscrowItemType().getValue() ? escrowItem.getESCROWITEMDETAIL().getEscrowItemType().getValue().value():null);		
		}
		
		if(null != escrowItem.getESCROWITEMDETAIL().getFeePaidToType())
			escrowsModel.setPaidToType(escrowItem.getESCROWITEMDETAIL().getFeePaidToType().getValue().value());
			
			escrowsModel.setMonthlyPaymentAmount(null != escrowItem.getESCROWITEMDETAIL().getEscrowMonthlyPaymentAmount() ? escrowItem.getESCROWITEMDETAIL().getEscrowMonthlyPaymentAmount().getValue().toPlainString(): "");
			escrowsModel.setCollectedNumberOfMonthsCount(null != escrowItem.getESCROWITEMDETAIL().getEscrowCollectedNumberOfMonthsCount() ? Integer.toString(escrowItem.getESCROWITEMDETAIL().getEscrowCollectedNumberOfMonthsCount().getValue()):"");
			
			List<ESCROWITEMPAYMENT>escrowitempayments =	escrowItem.getESCROWITEMPAYMENTS().getESCROWITEMPAYMENT();
			
			for(ESCROWITEMPAYMENT escrowitempayment : escrowitempayments)
			{
				if( null != escrowitempayment.getEscrowItemPaymentPaidByType())
				{
					String paidBy = escrowitempayment.getEscrowItemPaymentPaidByType().getValue().value();
					escrowsModel.setPaymentPaidByType(paidBy);
					if( "Buyer".equalsIgnoreCase(paidBy)) 
						if("BeforeClosing".equalsIgnoreCase(escrowitempayment.getEscrowItemPaymentTimingType().getValue().value()))
							escrowsModel.setBuyerOutsideClosingAmount(null != escrowitempayment.getEscrowItemActualPaymentAmount() ? escrowitempayment.getEscrowItemActualPaymentAmount().getValue().toPlainString():"");
						else
							escrowsModel.setBuyerAtClosingAmount(null != escrowitempayment.getEscrowItemActualPaymentAmount() ? escrowitempayment.getEscrowItemActualPaymentAmount().getValue().toPlainString():"");
					else if("Seller".equalsIgnoreCase(paidBy))
						if("BeforeClosing".equalsIgnoreCase(escrowitempayment.getEscrowItemPaymentTimingType().getValue().value()))
							escrowsModel.setSellerOutsideClosingAmount(null != escrowitempayment.getEscrowItemActualPaymentAmount() ? escrowitempayment.getEscrowItemActualPaymentAmount().getValue().toPlainString():"");
						else
							escrowsModel.setSellerAtClosingAmount(null != escrowitempayment.getEscrowItemActualPaymentAmount() ? escrowitempayment.getEscrowItemActualPaymentAmount().getValue().toPlainString():"");
					else
						escrowsModel.setOtherAmount(null != escrowitempayment.getEscrowItemActualPaymentAmount() ? escrowitempayment.getEscrowItemActualPaymentAmount().getValue().toPlainString():"");
					
					if("Lender".equalsIgnoreCase(paidBy))
						escrowsModel.setLenderStatus("YES");
					else
						escrowsModel.setLenderStatus("NO");
				}
			}
			
		return escrowsModel;
	}
	
	public static FeeModel getFeeModel(FEE fee)
	{
		FeeModel feeModel = new FeeModel();
		String dLabel = "";
		if(null != fee.getFEEDETAIL().getFeeType())
		{
			dLabel = null != fee.getFEEDETAIL().getFeeType().getDisplayLabelText() ? fee.getFEEDETAIL().getFeeType().getDisplayLabelText()  : "";
			if(null == dLabel || dLabel.isEmpty())
				dLabel = null != fee.getFEEDETAIL().getFeeType().getValue() ? StringFormatter.CAMEL.formatString(fee.getFEEDETAIL().getFeeType().getValue().value()):"";
			if("Other".equalsIgnoreCase(dLabel))
			{
				if(null != fee.getFEEDETAIL().getFeePaidToTypeOtherDescription() && !fee.getFEEDETAIL().getFeePaidToTypeOtherDescription().getValue().value().isEmpty())
					feeModel.setLabel(fee.getFEEDETAIL().getFeePaidToTypeOtherDescription().getValue().value());
			}
			else
				feeModel.setLabel(dLabel);
				
			feeModel.setType(null != fee.getFEEDETAIL().getFeeType().getValue() ? fee.getFEEDETAIL().getFeeType().getValue().value():null);		
		}
		
		if(null != fee.getFEEDETAIL().getFeePaidToType())
			feeModel.setPaidToType(fee.getFEEDETAIL().getFeePaidToType().getValue().value());
		if(null != fee.getFEEDETAIL().getFeeActualTotalAmount())
			feeModel.setTotalAmount(fee.getFEEDETAIL().getFeeActualTotalAmount().getValue().toPlainString());
		if(null != fee.getFEEDETAIL().getOptionalCostIndicator())
			feeModel.setOptionalCostIndicator(fee.getFEEDETAIL().getOptionalCostIndicator().isValue());
		List<FEEPAYMENTS> feePaymentsList =	fee.getFEEPAYMENTS();
		
		for(FEEPAYMENTS feePayments : feePaymentsList)
		{
			List<FEEPAYMENT> feePaymentList =	feePayments.getFEEPAYMENT();
			for(FEEPAYMENT feePayment : feePaymentList)
			{
				if( null != feePayment.getFeePaymentPaidByType())
				{
					String paidBy = feePayment.getFeePaymentPaidByType().getValue().value();
					feeModel.setPaymentPaidByType(paidBy);
					if( "Buyer".equalsIgnoreCase(paidBy)) 
						if(feePayment.getFeePaymentPaidOutsideOfClosingIndicator().isValue())
							feeModel.setBuyerOutsideClosingAmount(null != feePayment.getFeeActualPaymentAmount() ? feePayment.getFeeActualPaymentAmount().getValue().toPlainString():"");
						else
							feeModel.setBuyerAtClosingAmount(null != feePayment.getFeeActualPaymentAmount() ? feePayment.getFeeActualPaymentAmount().getValue().toPlainString():"");
					else if("Seller".equalsIgnoreCase(paidBy))
						if(feePayment.getFeePaymentPaidOutsideOfClosingIndicator().isValue())
							feeModel.setSellerOutsideClosingAmount(null != feePayment.getFeeActualPaymentAmount() ? feePayment.getFeeActualPaymentAmount().getValue().toPlainString():"");
						else
							feeModel.setSellerAtClosingAmount(null != feePayment.getFeeActualPaymentAmount() ? feePayment.getFeeActualPaymentAmount().getValue().toPlainString():"");
					else
						feeModel.setOtherAmount(null != feePayment.getFeeActualPaymentAmount() ? feePayment.getFeeActualPaymentAmount().getValue().toPlainString():"");
					if("Lender".equalsIgnoreCase(paidBy))
						feeModel.setLenderStatus("YES");
					else
						feeModel.setLenderStatus("NO");
				}
			}
		}
		
		return feeModel;
		
	}
	
	
	public static ClosingCostProperties createIDSectionSummary(INTEGRATEDDISCLOSURESECTIONSUMMARY integrateddisclosuresectionsummary)
	{
		ClosingCostProperties closingCostProperties = new ClosingCostProperties();
		if(null != integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESUBSECTIONPAYMENTS())
		{
		List<INTEGRATEDDISCLOSURESUBSECTIONPAYMENT> integrateddisclosuresubsectionpayments  = integrateddisclosuresectionsummary.getINTEGRATEDDISCLOSURESUBSECTIONPAYMENTS().getINTEGRATEDDISCLOSURESUBSECTIONPAYMENT();
		for(INTEGRATEDDISCLOSURESUBSECTIONPAYMENT integrateddisclosuresubsectionpayment: integrateddisclosuresubsectionpayments)
		{
			if( null != integrateddisclosuresubsectionpayment)
			{
				String paidBy = integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaidByType().getValue().value();
				if( "Buyer".equalsIgnoreCase(paidBy)) 
					if("BeforeClosing".equalsIgnoreCase(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentTimingType().getValue().value()))
						closingCostProperties.setBpB4Closing(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString());
					else
						closingCostProperties.setBpAtClosing(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString());
				else if("Seller".equalsIgnoreCase(paidBy))
					if("BeforeClosing".equalsIgnoreCase(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentTimingType().getValue().value()))
						closingCostProperties.setSpB4Closing(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString());
					else
						closingCostProperties.setSpAtClosing(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString());
				else
					closingCostProperties.setPaidByOthers(integrateddisclosuresubsectionpayment.getIntegratedDisclosureSubsectionPaymentAmount().getValue().toPlainString());
			}
		}
		String str = "";
		str = closingCostProperties.getBpAtClosing();
		if((null != str || "" != str ) && StringFormatter.doubleValue(str) != 0)
			closingCostProperties.setBpAtClosing(StringFormatter.NODOLLARS.formatString(str));
		str = closingCostProperties.getBpB4Closing();
		if((null != str || "" != str ) && StringFormatter.doubleValue(str) != 0)
			closingCostProperties.setBpB4Closing(StringFormatter.NODOLLARS.formatString(str));
		str = closingCostProperties.getSpAtClosing();
		if((null != str || "" != str ) && StringFormatter.doubleValue(str) != 0)
			closingCostProperties.setSpAtClosing(StringFormatter.NODOLLARS.formatString(str));
		str = closingCostProperties.getSpB4Closing();
		if((null != str || "" != str ) && StringFormatter.doubleValue(str) != 0)
			closingCostProperties.setSpB4Closing(StringFormatter.NODOLLARS.formatString(str));
		}
		return closingCostProperties;
	}
	*/
	public static String booleanToString(boolean status)
	{
		if(status)
			return "true";
		return "false";
	}
	
	public static boolean stringToBoolean(String status)
	{
		if(status.equalsIgnoreCase("YES"))
			return true;
		return false;
	}
	
	public int convertYearsToMonthsFormat(String yearsdata){
		if(null != yearsdata || "".equals(yearsdata.trim()))
		{
			String[] years = yearsdata.split(" ");
			int month = Math.round(Integer.parseInt(years[0])*12);
	        return month;
		}
		
			return 0;
	        
	}
}
