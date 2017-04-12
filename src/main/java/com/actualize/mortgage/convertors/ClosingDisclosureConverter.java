/**
 * @(#)ClosingDisclosureConverter.java 1.0 04/11/2017
 */

package com.actualize.mortgage.convertors;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.cdpagemodels.ClosingDisclosurePageOne;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.ledatamodels.ClosingInformationDetail;
import com.actualize.mortgage.ledatamodels.Document;
import com.actualize.mortgage.ledatamodels.MISMODocument;

import mismodao.Deal;
import mismodao.IntegratedDisclosureDetail;

/**
 * This class will map all the Closing Disclosure XPATH elements to JSON Objects and its attributes 
 * @author rsudula
 * @version 1.0
 * 
 */

public class ClosingDisclosureConverter {

    public ClosingDisclosure convertXmltoJSON(MISMODocument mismodoc) {
        ClosingDisclosure closingDisclosure = new ClosingDisclosure();
        Document document = null;
        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
        IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
        ClosingInformationDetail closingInformationDetail = new ClosingInformationDetail((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"));
        
        // Page -1 method
     // Page -2 method
     // Page -3 method
     // Page -4 method
     // Page -5 method
        
        //PAGE - 1 Closing Information Section Mapping
        ClosingDisclosurePageOne closingDisclosurePageOne = new ClosingDisclosurePageOne();
        ClosingInformation closingInformationSection = new ClosingInformation();
        closingInformationSection.setDateIssued(idDetail.IntegratedDisclosureIssuedDate);
        closingInformationSection.setClosingDate(closingInformationDetail.ClosingDate);
        closingInformationSection.setDisbursementDate(closingInformationDetail.DisbursementDate);
        
        
        closingDisclosurePageOne.setClosingInformation(closingInformationSection);
        closingDisclosure.setClosingDisclosurePageOne(closingDisclosurePageOne);
        
        return closingDisclosure;
    }
    
    
}
