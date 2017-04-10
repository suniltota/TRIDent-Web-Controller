package com.actualize.mortgage.services;

import org.mismo.residential._2009.schemas.DOCUMENT;

import com.actualize.mortgage.domainmodels.ClosingDisclosureDocument;
/**
 * 
 * @author sboragala
 *
 */
public interface PageOneMappingService {
	
	public DOCUMENT mapClosingInformation(DOCUMENT document,ClosingDisclosureDocument pdfDocument);
	public DOCUMENT mapLoanInformation(DOCUMENT document,ClosingDisclosureDocument pdfDocument);
	public DOCUMENT mapTransactionInformation(DOCUMENT document,ClosingDisclosureDocument pdfDocument);
	public DOCUMENT mapLoanTerms(DOCUMENT document,ClosingDisclosureDocument pdfDocument);
	public DOCUMENT mapProjectedPayments(DOCUMENT document,ClosingDisclosureDocument pdfDocument);
	public DOCUMENT mapCostsAtClosing(DOCUMENT document,ClosingDisclosureDocument pdfDocument);

}
