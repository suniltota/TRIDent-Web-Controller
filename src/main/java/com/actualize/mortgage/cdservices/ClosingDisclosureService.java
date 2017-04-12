package com.actualize.mortgage.cdservices;

import java.io.InputStream;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
/**
 * This is service interface for the Closing Disclosure which is used to define 
 * different methods for example create ClosingDisclosure XML / PDF and generate Page Objects to represents
 * the all the pages present in Closing Disclosure.
 * 
 * @author rsudula
 * @version 1.0
 * 
 */
public interface ClosingDisclosureService {

    public ClosingDisclosure createClosingDisclosureObjectfromXMLDoc(InputStream inputXmlStream) throws Exception;
    
    public ClosingDisclosure createClosingDisclosureXMLfromObject(ClosingDisclosure closingDisclosure) throws Exception;

}
