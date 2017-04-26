package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class EscrowDetail extends MISMODataAccessObject{
	
    public final String EscrowAggregateAccountingAdjustmentAmount;
    
	protected EscrowDetail(Element element) {
		super(element);
		EscrowAggregateAccountingAdjustmentAmount = getValue("EscrowAggregateAccountingAdjustmentAmount");
	}

}
