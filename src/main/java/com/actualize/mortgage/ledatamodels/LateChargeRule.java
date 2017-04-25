package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class LateChargeRule extends MISMODataAccessObject {
	public final String LateChargeAmount;
	public final String LateChargeGracePeriodDaysCount;
	public final String LateChargeMaximumAmount;
	public final String LateChargeMinimumAmount;
	public final String LateChargeRatePercent;
	public final String LateChargeType;
	
	public LateChargeRule(Element element) {
		super(element);
		LateChargeAmount = getValueAddNS("LateChargeAmount");
		LateChargeGracePeriodDaysCount = getValueAddNS("LateChargeGracePeriodDaysCount");
		LateChargeMaximumAmount = getValueAddNS("LateChargeMaximumAmount");
		LateChargeMinimumAmount = getValueAddNS("LateChargeMinimumAmount");
		LateChargeRatePercent = getValueAddNS("LateChargeRatePercent");
		LateChargeType = getValueAddNS("LateChargeType");
	}
}