package com.actualize.mortgage.services;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.MESSAGE;

import com.actualize.mortgage.domainmodels.IntermediateXMLData;
import com.actualize.mortgage.domainmodels.PDFDocument;
import com.actualize.mortgage.domainmodels.PageOne;
import com.actualize.mortgage.domainmodels.PageThree;
import com.actualize.mortgage.domainmodels.PageTwo;
import com.actualize.mortgage.utils.DocumentType;

public interface MortgageServices {
	
	public List<PDFDocument> createDocument(MESSAGE message) throws Exception;
	public DocumentType documentDetail(DOCUMENT document) throws Exception;
	public PageOne populatePageOne(DOCUMENT document) throws Exception;
	public PageTwo populatePageTwo(DOCUMENT document) throws Exception;
	public PageThree populatePageThree(DOCUMENT document) throws Exception;
	public MESSAGE updateMismoObject(MESSAGE currentXMLObject,PDFDocument modifiedJSONObject) throws Exception;
    public IntermediateXMLData generateIntermediateXMLForTxtTemplate(InputStream mappingFileStream, Properties propFile) throws Exception;
    public MESSAGE generateMasterXML(IntermediateXMLData intermediateXMLData) throws Exception;
}
