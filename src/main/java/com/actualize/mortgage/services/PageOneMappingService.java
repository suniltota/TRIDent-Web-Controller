package com.actualize.mortgage.services;

import org.mismo.residential._2009.schemas.DOCUMENT;

import com.actualize.mortgage.domainmodels.PDFDocument;

public interface PageOneMappingService {
	
	public DOCUMENT mapClosingInformation(DOCUMENT document,PDFDocument pdfDocument);
	public DOCUMENT mapLoanInformation(DOCUMENT document,PDFDocument pdfDocument);
	public DOCUMENT mapTransactionInformation(DOCUMENT document,PDFDocument pdfDocument);
	public DOCUMENT mapLoanTerms(DOCUMENT document,PDFDocument pdfDocument);
	public DOCUMENT mapProjectedPayments(DOCUMENT document,PDFDocument pdfDocument);
	public DOCUMENT mapCostsAtClosing(DOCUMENT document,PDFDocument pdfDocument);

}
