/**
 * @(#)ClosingDisclosureController.java 1.0 04/11/2017
 */

package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
import com.actualize.mortgage.domainmodels.PDFResponse;
import com.uniformdisclosure.UniformDisclosureBuilder;
import com.uniformdisclosure.UniformDisclosureBuilderSeller;

import datalayer.InputData;
import datalayer.PopulateInputData;

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
    public String convertObjecttoXML(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception {
        return closingDisclosureService.createClosingDisclosureXMLfromObject(closingDisclosure);
    }
    
    @RequestMapping(value = "/{version}/generatePDF", method = { RequestMethod.POST })
    public List<PDFResponse> closingDisclosurePdf(@PathVariable String version, @RequestBody String xmldoc) throws Exception {
        PopulateInputData reader = new PopulateInputData();
        List<InputData> inputData = reader.getData(new ByteArrayInputStream(xmldoc.getBytes("utf-8")));
        ByteArrayOutputStream pdfOutStream = null;
        List<PDFResponse> pdfResponseList = new ArrayList<>();
        for(InputData data: inputData) {
            PDFResponse outputResponse = new PDFResponse();
            outputResponse.setFilename("ClosingDisclosure");
            outputResponse.setOutputType("application/pdf");
            if (data.isSellerOnly()){
                UniformDisclosureBuilderSeller pdfbuilder = new UniformDisclosureBuilderSeller();
                pdfOutStream = pdfbuilder.run(data);
                outputResponse.setResponseData(pdfOutStream.toByteArray());
            } else {
                UniformDisclosureBuilder pdfbuilder = new UniformDisclosureBuilder();
                pdfOutStream = pdfbuilder.run(data);
                outputResponse.setResponseData(pdfOutStream.toByteArray());
            }
            pdfResponseList.add(outputResponse);
        }
        return pdfResponseList;
    }
    
    @RequestMapping(value = "/{version}/ucdxml", method = { RequestMethod.POST })
    public String generateUCD(@PathVariable String version, @RequestBody String xmldoc) throws Exception {
    	 InputStream doc = new ByteArrayInputStream(xmldoc.getBytes(StandardCharsets.UTF_8));
        return closingDisclosureService.createClosingDisclosureUCDXML(doc);
    }
}
