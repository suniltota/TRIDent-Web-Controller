package com.actualize.mortgage.leservices;

import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.lepagemodels.LoanEstimateDocument;

public interface LoanEstimateServices {
	
	public LoanEstimateDocument createLoanEstimateDocument(MISMODocument mismoDocument) throws Exception;

}
