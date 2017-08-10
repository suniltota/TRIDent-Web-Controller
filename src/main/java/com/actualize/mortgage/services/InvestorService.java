/**
 * 
 */
package com.actualize.mortgage.services;

import java.util.List;

import com.actualize.mortgage.domainmodels.InvestorModel;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface InvestorService {

	public InvestorModel getInvestorByInvestorId(String investorId) throws ServiceException;

	public InvestorModel getInvestorByInvestorName(String investorName) throws ServiceException;

	public InvestorModel addInvestor(InvestorModel InvestorModel) throws ServiceException;

	public InvestorModel updateInvestor(InvestorModel InvestorModel) throws ServiceException;

	public void deleteInvestor(String investorId) throws ServiceException;

	public List<InvestorModel> getAllInvestors() throws ServiceException;

}
