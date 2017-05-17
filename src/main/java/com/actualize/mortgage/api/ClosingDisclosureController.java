/**
 * @(#)ClosingDisclosureController.java 1.0 04/11/2017
 */

package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.cdservices.ClosingDisclosureService;

/**
 * This controller is used to define all the endpoints (APIs) for Closing Disclosure
 * @author rsudula
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/trident/closingdisclosure")
public class ClosingDisclosureController {

    @Autowired
    private ClosingDisclosureService closingDisclosureService;

    /**
     * Generates JSON response for closing disclosure on giving xml as input in
     * String format
     * 
     * @param xmldoc
     * @return JSON response for closing disclosure
     * @throws Exception
     */
    @RequestMapping(value = "/v1/convertXmlToJson", method = { RequestMethod.POST })
    public ClosingDisclosure convertXMLtoObject(@RequestBody String xmldoc) throws Exception {
        InputStream in = new ByteArrayInputStream(xmldoc.getBytes(StandardCharsets.UTF_8));
        return closingDisclosureService.createClosingDisclosureObjectfromXMLDoc(in);
    }
    
    /**
     * Generates JSON response for closing disclosure on giving xml as input in
     * String format
     * 
     * @param xmldoc
     * @return JSON response for closing disclosure
     * @throws Exception
     */
    @RequestMapping(value = "/{version}/convertJsonToXml", method = { RequestMethod.POST })
    public Document convertObjecttoXML(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception {
        return closingDisclosureService.createClosingDisclosureXMLfromObject(closingDisclosure);
    }
}
