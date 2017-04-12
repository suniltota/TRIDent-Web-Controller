package com.actualize.mortgage.leservices.impl;

import java.io.InputStream;

import com.actualize.mortgage.convertors.LoanEstimateConvertor;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.lepagemodels.LoanEstimateDocument;
import com.actualize.mortgage.leservices.LoanEstimateServices;
/**
 * This class implements all the services required to prepare, plot and generate XML and PDF for loan Estimate
 * @author sboragala
 *
 */
public class LoanEstimateServicesImpl implements LoanEstimateServices {

	/*
	 * (non-Javadoc)
	 * @see com.actualize.mortgage.leservices.LoanEstimateServices#createLoanEstimateDocumentObjectfromXMLDoc(java.io.InputStream)
	 */
	@Override
	public LoanEstimateDocument createLoanEstimateDocumentObjectfromXMLDoc(InputStream inputXmlStream)
			throws Exception {
			MISMODocument document = new MISMODocument(inputXmlStream); 
			LoanEstimateConvertor loanEstimateConvertor = new LoanEstimateConvertor();
			LoanEstimateDocument loanEstimateDocument = loanEstimateConvertor.convertXmltoJSON(document);	
		return loanEstimateDocument;
	}

	
	
}
