package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines LateChargeRule in MISMO XML
 * @author sboragala
 *
 */
public class LateChargeRule extends MISMODataAccessObject {

	private static final long serialVersionUID = -4163076749563272406L;
	public final String lateChargeAmount;
	public final String lateChargeGracePeriodDaysCount;
	public final String lateChargeMaximumAmount;
	public final String lateChargeMinimumAmount;
	public final String lateChargeRatePercent;
	public final String lateChargeType;
	
	public LateChargeRule(Element element) {
		super(element);
		lateChargeAmount = getValueAddNS("LateChargeAmount");
		lateChargeGracePeriodDaysCount = getValueAddNS("LateChargeGracePeriodDaysCount");
		lateChargeMaximumAmount = getValueAddNS("LateChargeMaximumAmount");
		lateChargeMinimumAmount = getValueAddNS("LateChargeMinimumAmount");
		lateChargeRatePercent = getValueAddNS("LateChargeRatePercent");
		lateChargeType = getValueAddNS("LateChargeType");
	}
}
