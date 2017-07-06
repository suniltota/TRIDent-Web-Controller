/**
 * 
 */
package com.actualize.mortgage.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.authentication.services.impl.TRIDentWebServiceImpl;
import com.actualize.mortgage.cd.domainmodels.ClosingDisclosure;
import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.domainmodels.PDFResponse;
import com.actualize.mortgage.validation.domainmodels.UCDValidationErrors;

/**
 * @author sboragala
 *
 */
@RestController
@RequestMapping(value = "/actualize/transformx/")
public class TridentWebAPI {
	
	private static final Logger LOG = LogManager.getLogger(TridentWebAPI.class);
	
	@Autowired
	private TRIDentWebServiceImpl triDentWebService;
	
	@RequestMapping(value = "/{version}/templatetocdjson", method = { RequestMethod.POST })
	public ClosingDisclosure templatetocdjson(@PathVariable String version, @RequestBody String txtdoc) throws Exception {
		LOG.info("Service: CD text template to json object api invoked");

		return  triDentWebService.convertTemplateToCDJson(txtdoc);	
	}
	
	@RequestMapping(value = "/{version}/templatetolejson", method = { RequestMethod.POST })
	public LoanEstimate templatetolejson(@PathVariable String version, @RequestBody String txtdoc) throws Exception
	{
		LOG.info("Service: LE text template to json object called");
		return triDentWebService.convertTemplateToLEJson(txtdoc);
		
	}
	
	@RequestMapping(value = "/{version}/calculatecdpayments", method = { RequestMethod.POST })
	public String calculateCDPayments(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("Service call: cd calculations");
		return triDentWebService.calculateCDPayments(closingDisclosure);
	}
	
	@RequestMapping(value = "/{version}/calculatelepayments", method = { RequestMethod.POST })
	public String calculateLEPayments(@PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		LOG.info("Service call: le calculations");
		return triDentWebService.calculateLEPayments(loanEstimateJSON);
	}
	
	@RequestMapping(value = "/{version}/cdjsontopdf", method = { RequestMethod.POST })
	public List<PDFResponse> cdJsonToPdf(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("Service: cdjsontopdf called");
    	
		return triDentWebService.cdJsonToPdf(closingDisclosure);
	}
	
	@RequestMapping(value = "/{version}/lejsontopdf", method = { RequestMethod.POST })
	public PDFResponse leJsonToPdf(@PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		LOG.info("Service: lejsontopdf called");
    	return triDentWebService.leJsonToPdf(loanEstimateJSON);
	}
	
	@RequestMapping(value = "/{version}/validatecdjson", method = { RequestMethod.POST })
	public UCDValidationErrors validateCDJson(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("Service: validatecdjson called");
    	return triDentWebService.validateCDJson(closingDisclosure);
	}
	
	/**
	 * generate mismo ucd xml from CD JSON
	 * @param version
	 * @param closingDisclosure
	 * @return string 
	 * @throws Exception
	 */
	@RequestMapping(value = "/{version}/cdjsontrim", method = { RequestMethod.POST })
	public String trimCDJson(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("Service: cdjsontopdf called");
    	return triDentWebService.trimCDJson(closingDisclosure);
	}
}
