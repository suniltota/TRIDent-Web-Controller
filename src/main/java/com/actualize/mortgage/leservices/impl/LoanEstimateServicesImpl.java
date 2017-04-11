package com.actualize.mortgage.leservices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.lepagemodels.LoanEstimateDocument;
import com.actualize.mortgage.lepagemodels.LoanEstimatePageOne;
import com.actualize.mortgage.leservices.LoanEstimateResponseServices;
import com.actualize.mortgage.leservices.LoanEstimateServices;
/**
 * This class implements all the services required to prepare, plot and generate XML and PDF for loan Estimate
 * @author sboragala
 *
 */
public class LoanEstimateServicesImpl implements LoanEstimateServices {
	
	@Autowired
	LoanEstimateResponseServices loanEstimateResponseServices;
	
	/*
	 * (non-Javadoc)
	 * @see com.actualize.mortgage.leservices.LoanEstimateServices#createLoanEstimateDocument(com.actualize.mortgage.ledatamodels.MISMODocument)
	 */
	@Override
	public LoanEstimateDocument createLoanEstimateDocument(MISMODocument mismoDocument) throws Exception {
		LoanEstimateDocument loanEstimateDocument = new LoanEstimateDocument();
		LoanEstimatePageOne loanEstimatePageOne = new LoanEstimatePageOne();
		Deal deal = null;
		NodeList nodes = mismoDocument.getElementsAddNS("//DEAL");
		
		if (nodes.getLength() > 0)
		{
			deal = new Deal(Deal.NS, (Element)nodes.item(0));
			loanEstimatePageOne = loanEstimateResponseServices.createLoanEstimatePageOne(deal);
		}
		loanEstimateDocument.setLoanEstimatePageOne(loanEstimatePageOne);
		return loanEstimateDocument;
	}

	
	
}
