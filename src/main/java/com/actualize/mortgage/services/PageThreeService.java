package com.actualize.mortgage.services;

import java.util.List;

import org.mismo.residential._2009.schemas.DOCUMENT;

import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;
/**
 * 
 * @author sboragala
 *
 */
public interface PageThreeService {
	
	public List<CashToClose> createCalculatingCashtoClose(DOCUMENT document);
	public SummariesofTransactions createSummariesofTransactions(DOCUMENT document);
	
}
