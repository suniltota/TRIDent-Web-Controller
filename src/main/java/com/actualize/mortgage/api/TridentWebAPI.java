/**
 * 
 */
package com.actualize.mortgage.api;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.actualize.mortgage.cd.domainmodels.LoanInformationLoanIdentifier;
import com.actualize.mortgage.domainmodels.CalculateCDResponse;
import com.actualize.mortgage.domainmodels.CalculateLEResponse;
import com.actualize.mortgage.domainmodels.LoanEstimate;
import com.actualize.mortgage.domainmodels.PDFResponse;
import com.actualize.mortgage.services.UserActivityService;
import com.actualize.mortgage.services.impl.ClosingDisclosureServicesImpl;
import com.actualize.mortgage.services.impl.LoanEstimateServicesImpl;
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
	
	@Autowired
	private ClosingDisclosureServicesImpl closingDisclosureServices;
	
	@Autowired
	private LoanEstimateServicesImpl loanEstimateServices;
	
	@Autowired
	private UserActivityService userActivityServiceImpl;
	
	@RequestMapping(value = "/{version}/templatetocdjson", method = { RequestMethod.POST })
	public ClosingDisclosure templatetocdjson(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody String txtdoc) throws Exception {
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
	public String calculateCDPayments(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		String loanId = getLoanIdFromCD(closingDisclosure);
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "CDJSON to CDXMLWithCalculations");
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" with Loan Id: "+getLoanIdFromCD(closingDisclosure)+ " used Service: CD JSON to CDXML With Calculations");
		return triDentWebService.calculateCDPayments(closingDisclosure);
	}
	
	@RequestMapping(value = "/{version}/calculatecdjson", method = { RequestMethod.POST })
	public CalculateCDResponse calculateCDJSON(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		String loanId = getLoanIdFromCD(closingDisclosure);
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "CDJSON to CDJSONWithCalculations");
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" with Loan Id: "+loanId+ " used Service:CD JSON to CD JSON with Calculations ");
		return triDentWebService.createCalculateCDResponse(closingDisclosure);
	}
	
	@RequestMapping(value = "/{version}/calculatelejson", method = { RequestMethod.POST })
	public CalculateLEResponse calculateLEJSON(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		String loanId = getLoanIdFromLE(loanEstimateJSON);
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "LEJSON to LEJSONWithCalculations");
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" with Loan Id: "+loanId+ " used Service:LE JSON to LE JSON with Calculations ");
		return triDentWebService.createCalculateLEResponse(loanEstimateJSON);
	}
	
	@RequestMapping(value = "/{version}/calculatelepayments", method = { RequestMethod.POST })
	public String calculateLEPayments(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		String loanId = getLoanIdFromLE(loanEstimateJSON);
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "LECalculations");
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" with Loan Id: "+loanId+ " used Service: LE Calculations");
		return triDentWebService.calculateLEPayments(loanEstimateJSON);
	}
	
	@RequestMapping(value = "/{version}/cdjsontopdf", method = { RequestMethod.POST })
	public List<PDFResponse> cdJsonToPdf(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		String loanId = getLoanIdFromCD(closingDisclosure);
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" with Loan Id: "+loanId+ " used Service: CDJSONtoPDF");
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "CDJSONtoPDF");
		return triDentWebService.cdJsonToPdf(closingDisclosure);
	}
	
	@RequestMapping(value = "/{version}/lejsontopdf", method = { RequestMethod.POST })
	public PDFResponse leJsonToPdf(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody LoanEstimate loanEstimateJSON) throws Exception
	{
		String loanId = getLoanIdFromLE(loanEstimateJSON);
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName() +" with Loan Id: "+loanId+ " used Service: LEJSONtoPDF");
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "LEJSONtoPDF");
    	return triDentWebService.leJsonToPdf(loanEstimateJSON);
	}
	
	@RequestMapping(value = "/{version}/validatecdjson", method = { RequestMethod.POST })
	public UCDValidationErrors validateCDJson(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		String loanId = getLoanIdFromCD(closingDisclosure);
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" with Loan Id: "+loanId+ " used Service: ValidateCDJSON");
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "ValidateCDJSON");
    	return triDentWebService.validateCDJson(closingDisclosure, true);
	}
	
	/**
	 * generate mismo ucd xml from CD JSON
	 * @param version
	 * @param closingDisclosure
	 * @return string 
	 * @throws Exception
	 */
	@RequestMapping(value = "/{version}/cdjsontrim", method = { RequestMethod.POST })
	public String trimCDJson(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		String loanId = getLoanIdFromCD(closingDisclosure);
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" with Loan Id: "+loanId+ " used Service: CDJSONTOUCDXML");
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "CDJSONTOUCDXML");
		return triDentWebService.trimCDJson(closingDisclosure);
	}
	
	
	@RequestMapping(value = "/cd/{version}/calculateLateCharge", method = { RequestMethod.POST })
	public ClosingDisclosure cdCalculateLateCharge(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody ClosingDisclosure closingDisclosure) throws Exception
	{
		String loanId = getLoanIdFromCD(closingDisclosure);
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName()+" with Loan Id: "+loanId+ " used Service: CD CalculateLateCharge");
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "CDCalculateLateCharge");
		String mismoXML = lateChargeRuleService.calculateLateChargeRule(closingDisclosureServices.createClosingDisclosureXMLfromObject(closingDisclosure));
		InputStream in = new ByteArrayInputStream(mismoXML.getBytes(StandardCharsets.UTF_8));
		return closingDisclosureServices.createClosingDisclosureObjectfromXMLDoc(in);
		
	}
	
	@RequestMapping(value = "/le/{version}/calculateLateCharge", method = { RequestMethod.POST })
	public LoanEstimate leCalculateLateCharge(HttpServletRequest request, HttpServletResponse response, @PathVariable String version, @RequestBody LoanEstimate loanEstimate) throws Exception
	{
		String loanId = getLoanIdFromLE(loanEstimate);
		LOG.info("user "+SecurityContextHolder.getContext().getAuthentication().getName() +" with Loan Id: "+loanId +" used Service: LE CalculateLateCharge");
		//userActivityServiceImpl.insertUserActivity(request, response, loanId, "LECalculateLateCharge");
		String mismoXML = lateChargeRuleService.calculateLateChargeRule(loanEstimateServices.createLoanEstimateXMLfromObject(loanEstimate));
		InputStream in = new ByteArrayInputStream(mismoXML.getBytes(StandardCharsets.UTF_8));
		return loanEstimateServices.createLoanEstimateDocumentObjectfromXMLDoc(in);
	}
	
	private String getLoanIdFromCD(ClosingDisclosure closingDisclosure)
	{
		String loanId = "Not Defined";
		
		List<LoanInformationLoanIdentifier> loanIdentifierors =  closingDisclosure.getLoanInformation().getLoanIdentifiers();
		
		for(LoanInformationLoanIdentifier loanIdentifier : loanIdentifierors)
			if("LenderLoan".equalsIgnoreCase(loanIdentifier.getLoanIdentifierType()))
					loanId = loanIdentifier.getLoanIdentifier();	
		
		return loanId;
	}
	
	private String getLoanIdFromLE(LoanEstimate loanEstimate)
	{
		String loanId = "Not Defined";
		
		List<com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier> loanIdentifierors =  loanEstimate.getLoanInformation().getLoanIdentifiers();
		
		for(com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier loanIdentifier : loanIdentifierors)
			if("LenderLoan".equalsIgnoreCase(loanIdentifier.getLoanIdentifierType()))
					loanId = loanIdentifier.getLoanIdentifier();	
		
		return loanId;
	}
}
