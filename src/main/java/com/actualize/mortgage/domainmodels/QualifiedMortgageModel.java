/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines QualifiedMortgage in JSON response
 * @author sboragala
 *
 */
public class QualifiedMortgageModel implements Serializable {

	private static final long serialVersionUID = 6235846447496780592L;
	
	private boolean regulationZExcludedBonaFideDiscountPointsIndicator;
	private String regulationZExcludedBonaFideDiscountPointsPercent;
	private String regulationZTotalAffiliateFeesAmount;
	private String regulationZTotalLoanAmount;
	private String regulationZTotalPointsAndFeesAmount;
	private String averagePrimeOfferRatePercent;
	private String abilityToRepayExemptionReasonType;
	private String abilityToRepayMethodType;
	
	/**
	 * @return the regulationZExcludedBonaFideDiscountPointsIndicator
	 */
	public boolean isRegulationZExcludedBonaFideDiscountPointsIndicator() {
		return regulationZExcludedBonaFideDiscountPointsIndicator;
	}
	/**
	 * @param regulationZExcludedBonaFideDiscountPointsIndicator the regulationZExcludedBonaFideDiscountPointsIndicator to set
	 */
	public void setRegulationZExcludedBonaFideDiscountPointsIndicator(
			boolean regulationZExcludedBonaFideDiscountPointsIndicator) {
		this.regulationZExcludedBonaFideDiscountPointsIndicator = regulationZExcludedBonaFideDiscountPointsIndicator;
	}
	/**
	 * @return the regulationZExcludedBonaFideDiscountPointsPercent
	 */
	public String getRegulationZExcludedBonaFideDiscountPointsPercent() {
		return regulationZExcludedBonaFideDiscountPointsPercent;
	}
	/**
	 * @param regulationZExcludedBonaFideDiscountPointsPercent the regulationZExcludedBonaFideDiscountPointsPercent to set
	 */
	public void setRegulationZExcludedBonaFideDiscountPointsPercent(
			String regulationZExcludedBonaFideDiscountPointsPercent) {
		this.regulationZExcludedBonaFideDiscountPointsPercent = regulationZExcludedBonaFideDiscountPointsPercent;
	}
	/**
	 * @return the regulationZTotalAffiliateFeesAmount
	 */
	public String getRegulationZTotalAffiliateFeesAmount() {
		return regulationZTotalAffiliateFeesAmount;
	}
	/**
	 * @param regulationZTotalAffiliateFeesAmount the regulationZTotalAffiliateFeesAmount to set
	 */
	public void setRegulationZTotalAffiliateFeesAmount(String regulationZTotalAffiliateFeesAmount) {
		this.regulationZTotalAffiliateFeesAmount = regulationZTotalAffiliateFeesAmount;
	}
	/**
	 * @return the regulationZTotalLoanAmount
	 */
	public String getRegulationZTotalLoanAmount() {
		return regulationZTotalLoanAmount;
	}
	/**
	 * @param regulationZTotalLoanAmount the regulationZTotalLoanAmount to set
	 */
	public void setRegulationZTotalLoanAmount(String regulationZTotalLoanAmount) {
		this.regulationZTotalLoanAmount = regulationZTotalLoanAmount;
	}
	/**
	 * @return the regulationZTotalPointsAndFeesAmount
	 */
	public String getRegulationZTotalPointsAndFeesAmount() {
		return regulationZTotalPointsAndFeesAmount;
	}
	/**
	 * @param regulationZTotalPointsAndFeesAmount the regulationZTotalPointsAndFeesAmount to set
	 */
	public void setRegulationZTotalPointsAndFeesAmount(String regulationZTotalPointsAndFeesAmount) {
		this.regulationZTotalPointsAndFeesAmount = regulationZTotalPointsAndFeesAmount;
	}
	/**
	 * @return the averagePrimeOfferRatePercent
	 */
	public String getAveragePrimeOfferRatePercent() {
		return averagePrimeOfferRatePercent;
	}
	/**
	 * @param averagePrimeOfferRatePercent the averagePrimeOfferRatePercent to set
	 */
	public void setAveragePrimeOfferRatePercent(String averagePrimeOfferRatePercent) {
		this.averagePrimeOfferRatePercent = averagePrimeOfferRatePercent;
	}
	/**
	 * @return the abilityToRepayExemptionReasonType
	 */
	public String getAbilityToRepayExemptionReasonType() {
		return abilityToRepayExemptionReasonType;
	}
	/**
	 * @param abilityToRepayExemptionReasonType the abilityToRepayExemptionReasonType to set
	 */
	public void setAbilityToRepayExemptionReasonType(String abilityToRepayExemptionReasonType) {
		this.abilityToRepayExemptionReasonType = abilityToRepayExemptionReasonType;
	}
	/**
	 * @return the abilityToRepayMethodType
	 */
	public String getAbilityToRepayMethodType() {
		return abilityToRepayMethodType;
	}
	/**
	 * @param abilityToRepayMethodType the abilityToRepayMethodType to set
	 */
	public void setAbilityToRepayMethodType(String abilityToRepayMethodType) {
		this.abilityToRepayMethodType = abilityToRepayMethodType;
	}
	
	
}
