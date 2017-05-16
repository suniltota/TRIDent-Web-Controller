package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;
/**
 * this class defines BuydownRule in MISMO XML
 * @author sboragala
 *
 */
public class BuydownRule extends MISMODataAccessObject {
	private static final long serialVersionUID = 4905319655422045100L;
	public final String buydownChangeFrequencyMonthsCount;
	public final String buydownDurationMonthsCount;
	public final String buydownIncreaseRatePercent;
	public final Extension extension;
	public BuydownRule(Element element) {
		super(element);
		buydownChangeFrequencyMonthsCount = getValueAddNS("BuydownChangeFrequencyMonthsCount");
		buydownDurationMonthsCount = getValueAddNS("BuydownDurationMonthsCount");
		buydownIncreaseRatePercent = getValueAddNS("BuydownIncreaseRatePercent");
		extension = new Extension((Element)getElementAddNS("EXTENSION"));
	}
}
