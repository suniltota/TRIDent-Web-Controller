package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines HighCostMortgages in MISMO XML
 * @author sboragala
 *
 */
public class HighCostMortgages extends MISMODataAccessObject {
	
	public final String regulationZExcludedBonaFideDiscountPointsIndicator;
	public final String regulationZExcludedBonaFideDiscountPointsPercent;
	public final String regulationZTotalAffiliateFeesAmount;
	public final String regulationZTotalLoanAmount;
	public final String regulationZTotalPointsAndFeesAmount;
	public final String averagePrimeOfferRatePercent;
	public HighCostMortgages(String NS, Element element) {
		super(element);
		 regulationZExcludedBonaFideDiscountPointsIndicator = getValueAddNS("RegulationZExcludedBonaFideDiscountPointsIndicator");
		 regulationZExcludedBonaFideDiscountPointsPercent = getValueAddNS("RegulationZExcludedBonaFideDiscountPointsPercent");
		 regulationZTotalAffiliateFeesAmount = getValueAddNS("RegulationZTotalAffiliateFeesAmount");
		 regulationZTotalLoanAmount = getValueAddNS("RegulationZTotalLoanAmount");
		 regulationZTotalPointsAndFeesAmount = getValueAddNS("RegulationZTotalPointsAndFeesAmount");
		 averagePrimeOfferRatePercent = getValueAddNS("AveragePrimeOfferRatePercent");
	}
}
