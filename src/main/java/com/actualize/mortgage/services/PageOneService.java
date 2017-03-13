package com.actualize.mortgage.services;

import org.mismo.residential._2009.schemas.DOCUMENT;

import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.ProjectedPayments;
import com.actualize.mortgage.domainmodels.TransactionInformation;

public interface PageOneService {

	public ClosingInformation createClosingInformation(DOCUMENT document);
	public LoanInformation createLoanInformation(DOCUMENT document);
	public TransactionInformation createTransactionInformation(DOCUMENT document);
	public LoanTerms createLoanTerms(DOCUMENT document);
	public ProjectedPayments createProjectedPayments(DOCUMENT document);
	public CostsAtClosing createCostsAtClosing(DOCUMENT document);
}
