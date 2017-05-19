package com.actualize.mortgage.utils;

import java.util.LinkedList;
import java.util.List;

import com.actualize.mortgage.domainmodels.MismoFeePaymentsModel;
import com.actualize.mortgage.domainmodels.PaymentsModel;

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
	public static List<MismoFeePaymentsModel> toMismoFeePayments(PaymentsModel paymentsModel, String type)
	{
		List<MismoFeePaymentsModel> mismoFeePaymentList = new LinkedList<>();
		
		if("FEE".equalsIgnoreCase(type))
		{
			if(!"".equals(paymentsModel.getBpAtClosing()) && null != paymentsModel.getBpAtClosing())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpAtClosing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("true");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getBpB4Closing()) && null != paymentsModel.getBpB4Closing())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpB4Closing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if("".equals(paymentsModel.getSpAtClosing()) && null != paymentsModel.getSpAtClosing())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpAtClosing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("true");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if("".equals(paymentsModel.getSpB4Closing()) && null != paymentsModel.getSpB4Closing())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpB4Closing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if("".equals(paymentsModel.getPaidByOthers()) && null != paymentsModel.getPaidByOthers())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
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
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpAtClosing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("true");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if(!"".equals(paymentsModel.getBpB4Closing()) && null != paymentsModel.getBpB4Closing())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getBpB4Closing());
					mismoPaymentsModel.setPaidByType("Buyer");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if("".equals(paymentsModel.getSpAtClosing()) && null != paymentsModel.getSpAtClosing())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpAtClosing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("true");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if("".equals(paymentsModel.getSpB4Closing()) && null != paymentsModel.getSpB4Closing())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
					mismoPaymentsModel.setAmount(paymentsModel.getSpB4Closing());
					mismoPaymentsModel.setPaidByType("Seller");
					mismoPaymentsModel.setClosingIndicator("false");
				mismoFeePaymentList.add(mismoPaymentsModel);
			}
			if("".equals(paymentsModel.getPaidByOthers()) && null != paymentsModel.getPaidByOthers())
			{
				MismoFeePaymentsModel mismoPaymentsModel = new MismoFeePaymentsModel();
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
}
