package com.actualize.mortgage.ledatamodels;

import org.w3c.dom.Element;

import com.actualize.mortgage.domainmodels.MISMODataAccessObject;

public class EscrowDetail extends MISMODataAccessObject{
	
	private static final long serialVersionUID = -9031296076021358307L;
	public final String escrowAggregateAccountingAdjustmentAmount;
    
	public EscrowDetail(Element element) {
		super(element);
		escrowAggregateAccountingAdjustmentAmount = getValue("EscrowAggregateAccountingAdjustmentAmount");
	}

}
