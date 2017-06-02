package com.actualize.mortgage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryDetailModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSectionSummaryModel;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureSubsectionPaymentModel;
import com.actualize.mortgage.domainmodels.MismoPaymentsModel;
import com.actualize.mortgage.domainmodels.MismoProjectedPaymentsModel;
import com.actualize.mortgage.domainmodels.PaymentsModel;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPC;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsPI;

/**
 * This class is perform various operations such as conversions of JSON objects to MISMO Objects
 * @author sboragala
 *
 */
public class Convertor {
	
	/**
	 * converts payment model to Fee payments for inserting into MISMO XML 
	 * @param paymentsModel
	 * @return List of MismoFeePaymentsModels
	 */
	public static List<MismoPaymentsModel> toMismoFeePayments(PaymentsModel paymentsModel, String type)
	{
		List<MismoPaymentsModel> mismoFeePaymentList = new LinkedList<>();
		
		if("FEE".equalsIgnoreCase(type))
		{
			if(!"".equals(paymentsModel.getBpAtClosing()) && null != paymentsModel.getBpAtClosing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpAtClosing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("true");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getBpB4Closing()) && null != paymentsModel.getBpB4Closing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpB4Closing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getSpAtClosing()) && null != paymentsModel.getSpAtClosing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpAtClosing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("true");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getSpB4Closing()) && null != paymentsModel.getSpB4Closing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpB4Closing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getPaidByOthers()) && null != paymentsModel.getPaidByOthers())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getPaidByOthers());
					if(paymentsModel.isLenderStatus())
						mismoPaymentsModel.setPaidByType("Lender");
					else
						mismoPaymentsModel.setPaidByType("ThirdParty");
					mismoPaymentsModel.setClosingIndicator("");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
		}
		else if("ESCROW".equalsIgnoreCase(type))
		{
			if(!"".equals(paymentsModel.getBpAtClosing()) && null != paymentsModel.getBpAtClosing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpAtClosing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("AtClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getBpB4Closing()) && null != paymentsModel.getBpB4Closing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpB4Closing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getSpAtClosing()) && null != paymentsModel.getSpAtClosing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpAtClosing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("AtClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getSpB4Closing()) && null != paymentsModel.getSpB4Closing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpB4Closing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getPaidByOthers()) && null != paymentsModel.getPaidByOthers())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getPaidByOthers());
					if(paymentsModel.isLenderStatus())
						mismoPaymentsModel.setPaidByType("Lender");
					else
						mismoPaymentsModel.setPaidByType("ThirdParty");
					mismoPaymentsModel.setClosingIndicator("");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
		}
		else if("PREPAID".equalsIgnoreCase(type))
		{
			if(!"".equals(paymentsModel.getBpAtClosing()) && null != paymentsModel.getBpAtClosing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpAtClosing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("AtClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getBpB4Closing()) && null != paymentsModel.getBpB4Closing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpB4Closing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("BeforeClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getSpAtClosing()) && null != paymentsModel.getSpAtClosing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpAtClosing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("AtClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getSpB4Closing()) && null != paymentsModel.getSpB4Closing())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpB4Closing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("BeforeClosing");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getPaidByOthers()) && null != paymentsModel.getPaidByOthers())
			{
				MismoPaymentsModel mismoPaymentsModel = new MismoPaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getPaidByOthers());
					if(paymentsModel.isLenderStatus())
						mismoPaymentsModel.setPaidByType("Lender");
					else
						mismoPaymentsModel.setPaidByType("ThirdParty");
					mismoPaymentsModel.setClosingIndicator("");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
		}
		return mismoFeePaymentList;
	}
	
	/**
	 * converts ProjectedPaymentsDetails to MismoProjectedPaymentsModel
	 * @param projectedPayments
	 * @return list of MismoProjectedPaymentsModel 
	 */
	public static List<MismoProjectedPaymentsModel> createMismoProjectedPayments(ProjectedPaymentsDetails projectedPayments)
	{
		List<MismoProjectedPaymentsModel> mismoProjectedPaymentsModels = new LinkedList<>();
		
		for(ProjectedPaymentsPC projectedPaymentsPC : projectedPayments.getPaymentCalculation())
		{
			MismoProjectedPaymentsModel mismoProjectedPaymentsModel = new MismoProjectedPaymentsModel();
				mismoProjectedPaymentsModel.setPaymentFrequencyType(projectedPayments.getPaymentFrequencyType());
				mismoProjectedPaymentsModel.setProjectedPaymentCalculationPeriodEndNumber(projectedPaymentsPC.getProjectedPaymentCalculationPeriodEndNumber());
				mismoProjectedPaymentsModel.setProjectedPaymentCalculationPeriodStartNumber(projectedPaymentsPC.getProjectedPaymentCalculationPeriodStartNumber());
				mismoProjectedPaymentsModel.setSequenceNumber(projectedPaymentsPC.getSequenceNumber());
				mismoProjectedPaymentsModel.setProjectedPaymentCalculationPeriodTermType(projectedPaymentsPC.getProjectedPaymentCalculationPeriodTermType());
				mismoProjectedPaymentsModel.setProjectedPaymentCalculationPeriodTermTypeOtherDescription(projectedPaymentsPC.getProjectedPaymentCalculationPeriodTermTypeOtherDescription());				
			mismoProjectedPaymentsModels.add(mismoProjectedPaymentsModel);
		}
		
		for(int i=0; i<projectedPayments.getPrincipalInterest().size(); i++)
		{
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentPrincipalAndInterestMaximumPaymentAmount(projectedPayments.getPrincipalInterest().get(i).getProjectedPaymentPrincipalAndInterestMaximumPaymentAmount());
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentPrincipalAndInterestMinimumPaymentAmount(projectedPayments.getPrincipalInterest().get(i).getProjectedPaymentPrincipalAndInterestMinimumPaymentAmount());
		}
		
		for(int i=0; i<projectedPayments.getMortgageInsurance().size(); i++)
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentMIPaymentAmount(projectedPayments.getMortgageInsurance().get(i).getProjectedPaymentMIPaymentAmount());
		
		for(int i=0; i<projectedPayments.getEstimatedEscrow().size(); i++)
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentEstimatedEscrowPaymentAmount(projectedPayments.getEstimatedEscrow().get(i).getProjectedPaymentEstimatedEscrowPaymentAmount());
		
		for(int i=0; i<projectedPayments.getEstimatedTotal().size(); i++)
		{
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentEstimatedTotalMaximumPaymentAmount(projectedPayments.getEstimatedTotal().get(i).getProjectedPaymentEstimatedTotalMaximumPaymentAmount());
			mismoProjectedPaymentsModels.get(i).setProjectedPaymentEstimatedTotalMinimumPaymentAmount(projectedPayments.getEstimatedTotal().get(i).getProjectedPaymentEstimatedTotalMinimumPaymentAmount());
		}
		
		return mismoProjectedPaymentsModels;
	}
	
	/**
	 * calculates IntegratedDisclosureSectionSummaryModels to insert into MISMO XML
	 * @param json
	 * @return list of IntegratedDisclosureSectionSummaryModel
	 */
	public static List<IntegratedDisclosureSectionSummaryModel> createIntegratedDisclosureSectionSummaryModels(ClosingDisclosure json)
	{
		List<IntegratedDisclosureSectionSummaryModel> integratedDisclosureSectionSummaryModels = new LinkedList<>();
		
		if(!"".equals(json.getClosingCostDetailsLoanCosts().getOcTotalAmount()) && null != json.getClosingCostDetailsLoanCosts().getOcTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsLoanCosts().getOcTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("OriginationCharges");
			
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(!"".equals(json.getClosingCostDetailsLoanCosts().getSbDidShopTotalAmount()) && null != json.getClosingCostDetailsLoanCosts().getSbDidShopTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsLoanCosts().getSbDidShopTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("ServicesBorrowerDidShopFor");
			
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(!"".equals(json.getClosingCostDetailsLoanCosts().getSbDidNotShopTotalAmount()) && null != json.getClosingCostDetailsLoanCosts().getSbDidNotShopTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsLoanCosts().getSbDidNotShopTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("ServicesBorrowerDidNotShopFor");
			
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(!"".equals(json.getClosingCostDetailsLoanCosts().getTlCostsTotalAmount()) && null != json.getClosingCostDetailsLoanCosts().getTlCostsTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			List<IntegratedDisclosureSubsectionPaymentModel> integratedDisclosureSubsectionPaymentModels = new LinkedList<>();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsLoanCosts().getTlCostsTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("TotalLoanCosts");
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSubsectionType("LoanCostsSubtotal");
			
			
			List<MismoPaymentsModel> mismoPaymentsModels = toMismoFeePayments(json.getClosingCostDetailsLoanCosts().getTlCosts(),"PREPAID");
			for(MismoPaymentsModel payment : mismoPaymentsModels)
			{
				IntegratedDisclosureSubsectionPaymentModel integratedDisclosureSubsectionPayment = new IntegratedDisclosureSubsectionPaymentModel();
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaidByType(payment.getPaidByType());
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentAmount(payment.getAmount());
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentTimingType(payment.getClosingIndicator());
				
			   integratedDisclosureSubsectionPaymentModels.add(integratedDisclosureSubsectionPayment);
			}
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSubsectionPayments(integratedDisclosureSubsectionPaymentModels);
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(!"".equals(json.getClosingCostDetailsOtherCosts().gettOGovtFeesTotalAmount()) && null != json.getClosingCostDetailsOtherCosts().gettOGovtFeesTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsOtherCosts().gettOGovtFeesTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("TaxesAndOtherGovernmentFees");
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(!"".equals(json.getClosingCostDetailsOtherCosts().getPrepaidsTotalAmount()) && null != json.getClosingCostDetailsOtherCosts().getPrepaidsTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsOtherCosts().getPrepaidsTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("Prepaids");
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(!"".equals(json.getClosingCostDetailsOtherCosts().getEscrowItemsTotalAmount()) && null != json.getClosingCostDetailsOtherCosts().getEscrowItemsTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsOtherCosts().getEscrowItemsTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("InitialEscrowPaymentAtClosing");
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(!"".equals(json.getClosingCostDetailsOtherCosts().getOtherTotalAmount()) && null != json.getClosingCostDetailsOtherCosts().getOtherTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsOtherCosts().getOtherTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("OtherCosts");
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		if(!"".equals(json.getClosingCostDetailsOtherCosts().getTotalOtherCostsTotalAmount()) && null != json.getClosingCostDetailsOtherCosts().getTotalOtherCostsTotalAmount())
		{
			IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
			IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetailModel = new IntegratedDisclosureSectionSummaryDetailModel();
			List<IntegratedDisclosureSubsectionPaymentModel> integratedDisclosureSubsectionPaymentModels = new LinkedList<>();
			
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionTotalAmount(json.getClosingCostDetailsOtherCosts().getTotalOtherCostsTotalAmount());
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSectionType("TotalOtherCosts");
			integratedDisclosureSectionSummaryDetailModel.setIntegratedDisclosureSubsectionType("OtherCostsSubtotal");
			
			
			List<MismoPaymentsModel> mismoPaymentsModels = toMismoFeePayments(json.getClosingCostDetailsLoanCosts().getTlCosts(),"PREPAID");
			for(MismoPaymentsModel payment : mismoPaymentsModels)
			{
				IntegratedDisclosureSubsectionPaymentModel integratedDisclosureSubsectionPayment = new IntegratedDisclosureSubsectionPaymentModel();
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaidByType(payment.getPaidByType());
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentAmount(payment.getAmount());
					integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentTimingType(payment.getClosingIndicator());
				
			   integratedDisclosureSubsectionPaymentModels.add(integratedDisclosureSubsectionPayment);
			}
			
			
			
			integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
			
			integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
		}
		
		return integratedDisclosureSectionSummaryModels;
	}
	
	
	/*private IntegratedDisclosureSectionSummaryModel createIntegratedDisclosureSectionSummaryModels(String amount, String sectionType, String subSectionType, boolean hasPayments, PaymentsModel paymentsModel)
	{
		IntegratedDisclosureSectionSummaryModel integratedDisclosureSectionSummaryModel = new IntegratedDisclosureSectionSummaryModel();
		IntegratedDisclosureSectionSummaryDetailModel integratedDisclosureSectionSummaryDetail = new IntegratedDisclosureSectionSummaryDetailModel();
		List<IntegratedDisclosureSubsectionPaymentModel> integratedDisclosureSubsectionPaymentModels = new LinkedList<>();
		
		List<MismoPaymentsModel> mismoPaymentsModels = toMismoFeePayments(json.getClosingCostDetailsLoanCosts().getTlCosts(),"PREPAID");
		for(MismoPaymentsModel payment : mismoPaymentsModels)
		{
			IntegratedDisclosureSubsectionPaymentModel integratedDisclosureSubsectionPayment = new IntegratedDisclosureSubsectionPaymentModel();
				integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaidByType(payment.getPaidByType());
				integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentAmount(payment.getAmount());
				integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentTimingType(payment.getClosingIndicator());
			
		   integratedDisclosureSubsectionPaymentModels.add(integratedDisclosureSubsectionPayment);
		}
		
		integratedDisclosureSectionSummaryModel.setIntegratedDisclosureSectionSummaryDetailModel(integratedDisclosureSectionSummaryDetailModel);
		
		integratedDisclosureSectionSummaryModels.add(integratedDisclosureSectionSummaryModel);
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
		if(status.equalsIgnoreCase("true"))
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
	
	/**
	 * get the current date and time with UTC time zone formatted as yyyy-MM-dd'T'HH:mm:ss.SSS'Z
	 * @return date as String 
	 */
	public static String getUTCDate()
	{
		Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);  
		
	}
}
