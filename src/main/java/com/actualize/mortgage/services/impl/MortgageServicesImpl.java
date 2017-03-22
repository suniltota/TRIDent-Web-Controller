package com.actualize.mortgage.services.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.mismo.residential._2009.schemas.ADDRESS;
import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.MESSAGE;
import org.springframework.beans.factory.annotation.Autowired;

import com.actualize.mortgage.domainmodels.Address;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.Lender;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.PDFDocument;
import com.actualize.mortgage.domainmodels.PageOne;
import com.actualize.mortgage.domainmodels.PageTwo;
import com.actualize.mortgage.domainmodels.ProjectedPayments;
import com.actualize.mortgage.domainmodels.Seller;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.services.MortgageServices;
import com.actualize.mortgage.services.PageOneMappingService;
import com.actualize.mortgage.services.PageOneService;
import com.actualize.mortgage.services.PageTwoService;
import com.actualize.mortgage.utils.Convertor;
import com.actualize.mortgage.utils.DocumentType;

public class MortgageServicesImpl implements MortgageServices{
	
	
	DEAL deal = null;
	Address property = new Address();
	ADDRESS address = new ADDRESS();
	Convertor convertor = new Convertor();
	ClosingInformation closingInformation = new ClosingInformation();
	TransactionInformation transactionInformation = new TransactionInformation();
	LoanInformation loanInformation = new LoanInformation();
	DocumentType documentType = new DocumentType();
	
	List<Borrower> borrowers = new LinkedList<>();
	List<Seller> sellers = new LinkedList<>();
	List<Lender> lenders = new LinkedList<>();
	
	
	@Autowired
	private PageOneService pageOneService;
	
	@Autowired
	private PageTwoService pageTwoService;
	
	@Autowired
	private PageOneMappingService pageOneMappingService;
	
	@Override
	public DocumentType documentDetail(DOCUMENT document) throws Exception {
		DocumentType documentType = new DocumentType();
			documentType.setStandardView(DocumentType.isStandardView(document));
			documentType.setLoanType(documentType.getLoanType(document));
			documentType.setAlternateView(DocumentType.isAlternateView(document));
			documentType.setHomeEquityLoanIndicator(DocumentType.isHomeEquityLoanIndicator(document));
			documentType.setPayoffsAndPayments(DocumentType.isPayoffsAndPayments(document));
			documentType.setRefinanceTypeLoan(DocumentType.isRefinanceTypeLoan(document));
			documentType.setSellerOnly(DocumentType.isSellerOnly(document));
			documentType.setLoanId(documentType.getLoanIdentifier(document));
		return documentType;
	}
	
	@Override
	public PageOne populatePageOne(DOCUMENT document) throws Exception {
		
		
		ClosingInformation closingInformation = new ClosingInformation();
		TransactionInformation transactionInformation = new TransactionInformation();
		LoanInformation loanInformation = new LoanInformation();
		LoanTerms loanTerms = new LoanTerms();
		ProjectedPayments projectedPayments = new ProjectedPayments();
		CostsAtClosing costsAtClosing = new CostsAtClosing();
		
		closingInformation = pageOneService.createClosingInformation(document);
		transactionInformation = pageOneService.createTransactionInformation(document);
		loanInformation = pageOneService.createLoanInformation(document);
		loanTerms = pageOneService.createLoanTerms(document);
		projectedPayments = pageOneService.createProjectedPayments(document);
		costsAtClosing = pageOneService.createCostsAtClosing(document);
				
		PageOne pageOne = new PageOne();
		
			pageOne.setClosingInformation(closingInformation);
			pageOne.setTransactionInformation(transactionInformation);
			pageOne.setLoanInformation(loanInformation);
			pageOne.setLoanTerms(loanTerms);
			pageOne.setProjectedPayments(projectedPayments);
			pageOne.setCostsAtClosing(costsAtClosing);
		
		return pageOne;
	}

	@Override
	public List<PDFDocument> createDocument(MESSAGE message) throws Exception {
		List<PDFDocument> pdfDocuments = new ArrayList<>();
		List<DOCUMENT> documents = message.getDOCUMENTSETS().getDOCUMENTSET().getDOCUMENTS().getDOCUMENT();
			
		for(DOCUMENT document : documents)
		{
			PDFDocument pdfDocument = new PDFDocument();
			DocumentType documentType = new DocumentType();
			PageOne pageOne = new PageOne();
			PageTwo pageTwo = new PageTwo();
			documentType = documentDetail(document);
			documentType.setAboutVersionIdentifier(DocumentType.getAboutVersionIdentifier(message));
			pageOne = populatePageOne(document);
			pageTwo = populatePageTwo(document);
			pdfDocument.setDocumentType(documentType);
			pdfDocument.setPageOne(pageOne);
			pdfDocument.setPageTwo(pageTwo);
			pdfDocuments.add(pdfDocument);
		}
		return pdfDocuments;
	}

	@Override
	public PageTwo populatePageTwo(DOCUMENT document) throws Exception {
		PageTwo pageTwo = new PageTwo();
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();
		ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts = new ClosingCostDetailsOtherCosts();
		
		closingCostDetailsLoanCosts = pageTwoService.createClosingCostDetailsLoanCosts(document);
		closingCostDetailsOtherCosts = pageTwoService.createClosingCostDetailsOtherCosts(document);
		
		pageTwo.setClosingCostDetailsLoanCosts(closingCostDetailsLoanCosts);
		pageTwo.setClosingCostDetailsOtherCosts(closingCostDetailsOtherCosts);
		
		return pageTwo;
	}

    @Override
    public MESSAGE updateMismoObject(MESSAGE currentXMLObject, PDFDocument modifiedJSONObject) throws Exception {

        MESSAGE message = currentXMLObject;
        List<DOCUMENT> documents = currentXMLObject.getDOCUMENTSETS().getDOCUMENTSET().getDOCUMENTS().getDOCUMENT();
        for (DOCUMENT document : documents) {
            document = pageOneMappingService.mapClosingInformation(document, modifiedJSONObject);
            document = pageOneMappingService.mapLoanInformation(document, modifiedJSONObject);
            document = pageOneMappingService.mapTransactionInformation(document, modifiedJSONObject);
            document = pageOneMappingService.mapLoanTerms(document, modifiedJSONObject);
            document = pageOneMappingService.mapProjectedPayments(document, modifiedJSONObject);
            document = pageOneMappingService.mapCostsAtClosing(document, modifiedJSONObject);
        }
        return message;
    }

	@Override
	public MESSAGE mapPageOne(MESSAGE currentXMLObject, PDFDocument modifiedJSONObject) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MESSAGE mapPageTwo(MESSAGE currentXMLObject, PDFDocument modifiedJSONObject) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
