/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import com.actualize.mortgage.datamodels.InvestorUserDetailsEntity;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface InvestorUserDetailsManager  {
	
	public InvestorUserDetailsEntity getInvestorUserDetailsById(String investorId) throws ServiceException;
	
	public InvestorUserDetailsEntity getInvestorUserDetailsByInvestorUserName(String investorName, String clientId) throws ServiceException;
	
	public InvestorUserDetailsEntity addInvestorUserDetailsEntity(InvestorUserDetailsEntity investorUserDetailsEntity) throws ServiceException;
	
	public InvestorUserDetailsEntity updateInvestorUserDetails(InvestorUserDetailsEntity investorUserDetailsEntity) throws ServiceException;
	
	public void deleteInvestorUserDetails(String investorUserId) throws ServiceException;
		
	public List<InvestorUserDetailsEntity> getAllInvestorUserDetailsByClientId(String clientId) throws ServiceException;

}
