/*
 * @(#)ClosingDisclosureServiceImpl.java 1.0 04/11/2017
 * 
 */
package com.actualize.mortgage.cdservices.impl;

import java.io.InputStream;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.cdservices.ClosingDisclosureService;
import com.actualize.mortgage.convertors.ClosingDisclosureConverter;
import com.actualize.mortgage.ledatamodels.MISMODocument;

/**
 * This is the implementation class for the {@link ClosingDisclosureService} which is used to write 
 * the business logic to create ClosingDisclosure XML / PDF and generate Page Objects to represents
 *  the all the pages present in Closing Disclosure
 * 
 * @author rsudula
 * @version 1.0
 * 
 */
public class ClosingDisclosureServiceImpl implements ClosingDisclosureService {

    @Override
    public ClosingDisclosure createClosingDisclosureObjectfromXMLDoc(InputStream inputXmlStream) throws Exception {
        MISMODocument document = new MISMODocument(inputXmlStream); 
        ClosingDisclosureConverter closingDisclosureConverter = new ClosingDisclosureConverter();
        ClosingDisclosure closingDisclosure = closingDisclosureConverter.convertXmltoJSON(document);
        return closingDisclosure;
    }

    @Override
    public ClosingDisclosure createClosingDisclosureXMLfromObject(ClosingDisclosure closingDisclosure) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}