/**
 * 
 */
package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.authentication.services.impl.LateChargeRuleServiceImpl;
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
	
	@Autowired
	private LateChargeRuleServiceImpl lateChargeRuleService;
	
	@RequestMapping(value = "/{version}/templatetocdjson", method = { RequestMethod.POST })
	public ClosingDisclosure templatetocdjson(@PathVariable String version, @RequestBody String txtdoc) throws Exception {
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: CD Text Template to CD JSON");
		return  triDentWebService.convertTemplateToCDJson(txtdoc);	
	}
	
	@RequestMapping(value = "/{version}/templatetolejson", method = { RequestMethod.POST })
	public LoanEstimate templatetolejson(@PathVariable String version, @RequestBody String txtdoc) throws Exception
	{
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: LE Text Template to LE JSON");
		return triDentWebService.convertTemplateToLEJson(txtdoc);
		
	}
	
	@RequestMapping(value = "/{version}/calculatecdpayments", method = { RequestMethod.POST })
	public String calculateCDPayments(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: CD Calculations");
		return triDentWebService.calculateCDPayments(closingDisclosure);
	}
	
	@RequestMapping(value = "/{version}/calculatelepayments", method = { RequestMethod.POST })
	public String calculateLEPayments(@PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: LE Calculations");
		return triDentWebService.calculateLEPayments(loanEstimateJSON);
	}
	
	@RequestMapping(value = "/{version}/cdjsontopdf", method = { RequestMethod.POST })
	public List<PDFResponse> cdJsonToPdf(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: CDJSONtoPDF");
		return triDentWebService.cdJsonToPdf(closingDisclosure);
	}
	
	@RequestMapping(value = "/{version}/lejsontopdf", method = { RequestMethod.POST })
	public PDFResponse leJsonToPdf(@PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: LEJSONtoPDF");
    	return triDentWebService.leJsonToPdf(loanEstimateJSON);
	}
	
	@RequestMapping(value = "/{version}/validatecdjson", method = { RequestMethod.POST })
	public UCDValidationErrors validateCDJson(@PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: ValidateCDJSON");
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
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: CDJSONtoPDF");
    	return triDentWebService.trimCDJson(closingDisclosure);
	}
	
	
	@RequestMapping(value = "/{version}/calculateLateCharge", method = { RequestMethod.POST })
	public String calculateLateCharge(@PathVariable String version, @RequestBody String mismoString) throws Exception
	{
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" used Service: CalculateLateCharge");
		
		return lateChargeRuleService.calculateLateChargeRule(mismoString);
	}
}
