package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class EstimatedPropertyCost extends MISMODataAccessObject {
	public final EstimatedPropertyCostComponents estimatedPropertyCostComponents;
	public final EstimatedPropertyCostDetail estimatedPropertyCostDetail;

	public EstimatedPropertyCost(Element element) {
		super(element);
		estimatedPropertyCostComponents = new EstimatedPropertyCostComponents((Element)getElementAddNS("ESTIMATED_PROPERTY_COST_COMPONENTS"));
		estimatedPropertyCostDetail = new EstimatedPropertyCostDetail((Element)getElementAddNS("ESTIMATED_PROPERTY_COST_DETAIL"));
	}
}
