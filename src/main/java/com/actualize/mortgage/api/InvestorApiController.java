/**
 * 
 */
package com.actualize.mortgage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.InvestorModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.InvestorService;

/**
 * @author sboragala
 *
 */
@RestController
@RequestMapping(value = "/actualize/transformx/")
public class InvestorApiController {
	
	@Autowired
	private InvestorService investorServiceImpl;
	
	
	@RequestMapping(value={"/investors/{id}"}, method = RequestMethod.GET)
	public InvestorModel getInvestorById(@PathVariable("id") String investorId) throws ServiceException {
		return investorServiceImpl.getInvestorByInvestorId(investorId);
	}
	
	@RequestMapping(value={"/investors"}, method = RequestMethod.GET)
	public List<InvestorModel> getAllInvestors() throws ServiceException {
		return investorServiceImpl.getAllInvestors();
	}
	
	@RequestMapping(value={"/investors"}, method = RequestMethod.POST)
	public void addInvestor(@RequestBody InvestorModel investorModel) throws ServiceException {
		investorServiceImpl.addInvestor(investorModel);
	}
	
	@RequestMapping(value={"/investors"}, method = RequestMethod.PUT)
	public void updateInvestor(@RequestBody InvestorModel investorModel) throws ServiceException {
		investorServiceImpl.updateInvestor(investorModel);
	}
	
	@RequestMapping(value={"/investors/{id}"}, method = RequestMethod.DELETE)
	public void deleteInvestorById(@PathVariable("id") String investorId) throws ServiceException {
		 investorServiceImpl.deleteInvestor(investorId);
	}


}
