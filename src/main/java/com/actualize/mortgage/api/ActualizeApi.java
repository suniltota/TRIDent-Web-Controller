package com.actualize.mortgage.api;

import java.util.List;

import org.mismo.residential._2009.schemas.MESSAGE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.PDFDocument;
import com.actualize.mortgage.sercurity.SessionContext;
import com.actualize.mortgage.services.MortgageServices;

@RestController
@RequestMapping(value="/actualize")
public class ActualizeApi {
	
	@Autowired
	private MortgageServices mortgageServices;
	
	@Autowired
    SessionContext sessionContext;
	
	@RequestMapping(value = "/ucdxml", method = { RequestMethod.POST })
    public List<PDFDocument> fillFormByXML(@RequestBody MESSAGE messageXMLObject) throws Exception {
			sessionContext.getUserDetails().setMessage(messageXMLObject);
		 return  mortgageServices.createDocument(messageXMLObject);
    }
	
	
	@RequestMapping(value = "/readTxt", method = { RequestMethod.POST })
    public List<PDFDocument> fillFormByTxt(@RequestBody MESSAGE messageXMLObject) throws Exception {
		 return  mortgageServices.createDocument(messageXMLObject);
    }
	
	@RequestMapping(value = "/saveUCD", method = { RequestMethod.POST })
    public void saveModifiedUCD(@RequestBody PDFDocument modifiedJSONObject) throws Exception {
		MESSAGE currentXMLObject = sessionContext.getUserDetails().getMessage();
		   mortgageServices.updateMismoObject(currentXMLObject, modifiedJSONObject);
    }
	
}
