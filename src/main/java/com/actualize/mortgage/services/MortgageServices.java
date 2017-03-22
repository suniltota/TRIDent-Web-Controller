package com.actualize.mortgage.services;

import java.util.List;

import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.MESSAGE;

import com.actualize.mortgage.domainmodels.PDFDocument;
import com.actualize.mortgage.domainmodels.PageOne;
import com.actualize.mortgage.domainmodels.PageTwo;
import com.actualize.mortgage.utils.DocumentType;

public interface MortgageServices {
	
	public List<PDFDocument> createDocument(MESSAGE message) throws Exception;
	public DocumentType documentDetail(DOCUMENT document) throws Exception;
	public PageOne populatePageOne(DOCUMENT document) throws Exception;
	public PageTwo populatePageTwo(DOCUMENT document) throws Exception;
	public MESSAGE updateMismoObject(MESSAGE currentXMLObject,PDFDocument modifiedJSONObject) throws Exception;
	public MESSAGE mapPageOne(MESSAGE currentXMLObject,PDFDocument modifiedJSONObject) throws Exception;
	public MESSAGE mapPageTwo(MESSAGE currentXMLObject,PDFDocument modifiedJSONObject) throws Exception;
}
