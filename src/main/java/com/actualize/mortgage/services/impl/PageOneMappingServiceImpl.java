package com.actualize.mortgage.services.impl;

import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;

import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.PDFDocument;
import com.actualize.mortgage.services.PageOneMappingService;

public class PageOneMappingServiceImpl  implements PageOneMappingService{

	@Override
	public DOCUMENT mapClosingInformation(DOCUMENT document, PDFDocument pdfDocument) {
		
		ClosingInformation closingInformation = pdfDocument.getPageOne().getClosingInformation();
		String dateIssued = closingInformation.getDateIssued();
		
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingDate().setValue(dateIssued);
		document.getDEALSETS().getDEALSET().getDEALS().setDEAL(deal);
		return document;
	}

	@Override
	public DOCUMENT mapLoanInformation(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DOCUMENT mapTransactionInformation(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DOCUMENT mapLoanTerms(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DOCUMENT mapProjectedPayments(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DOCUMENT mapCostsAtClosing(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
