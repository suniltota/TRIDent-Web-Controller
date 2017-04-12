package com.actualize.mortgage.leservices;

import java.io.InputStream;

import com.actualize.mortgage.lepagemodels.LoanEstimateDocument;

public interface LoanEstimateServices {
	
	public LoanEstimateDocument createLoanEstimateDocumentObjectfromXMLDoc(InputStream inputXmlStream) throws Exception;
	
}
