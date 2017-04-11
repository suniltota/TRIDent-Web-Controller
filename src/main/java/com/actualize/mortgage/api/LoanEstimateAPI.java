package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.lepagemodels.LoanEstimateDocument;
import com.actualize.mortgage.leservices.LoanEstimateServices;

@RestController
@RequestMapping(value="/trident/le")
public class LoanEstimateAPI {
	
	@Autowired
	LoanEstimateServices loanEstimateServices;
	
	/**
	 * Generates the JSON response for LE on uploading xml 
	 * @param xmldoc
	 * @return JSON response for LE 
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1/letojson", method = { RequestMethod.POST })
    public LoanEstimateDocument generateresponse(@RequestBody String xmldoc) throws Exception {
		LoanEstimateDocument loanEstimateDocument = new LoanEstimateDocument();
		InputStream stream = new ByteArrayInputStream(xmldoc.getBytes(StandardCharsets.UTF_8));
			MISMODocument mismoDocument = new MISMODocument(stream);
			loanEstimateDocument = loanEstimateServices.createLoanEstimateDocument(mismoDocument);
		return loanEstimateDocument;
	}
}
