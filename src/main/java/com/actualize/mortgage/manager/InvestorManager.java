/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import com.actualize.mortgage.datamodels.InvestorEntity;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface InvestorManager {
	
	public InvestorEntity getInvestorByInvestorId(String investorId) throws ServiceException;
	
	public InvestorEntity getInvestorByInvestorName(String investorName) throws ServiceException;
	
	public InvestorEntity addInvestor(InvestorEntity investorEntity) throws ServiceException;
	
	public InvestorEntity updateInvestor(InvestorEntity investorEntity) throws ServiceException;
	
	public void deleteInvestor(String investorId) throws ServiceException;
		
	public List<InvestorEntity> getAllInvestors() throws ServiceException;

}
