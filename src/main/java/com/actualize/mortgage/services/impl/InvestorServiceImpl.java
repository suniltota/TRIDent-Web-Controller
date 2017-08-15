/**
 * 
 */
package com.actualize.mortgage.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.actualize.mortgage.datamodels.InvestorEntity;
import com.actualize.mortgage.domainmodels.InvestorModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.InvestorManager;
import com.actualize.mortgage.services.InvestorService;
import com.actualize.mortgage.web.utils.Convertor;

/**
 * @author sboragala
 *
 */
@Service
public class InvestorServiceImpl implements InvestorService {

	@Autowired
	private InvestorManager investorManagerImpl;

	@Autowired
	private Convertor convertor;

	@Override
	public InvestorModel getInvestorByInvestorId(String investorId) throws ServiceException {
		
		validateInvestor(investorId, "Investor Id");
		
		InvestorEntity investorEntity = investorManagerImpl.getInvestorByInvestorId(investorId);
		
		if(null == investorEntity)
			throw new ServiceException("No investor found with investor id: "+investorId);
		
		return convertor.toInvestorModel(investorEntity);
	}

	@Override
	public InvestorModel getInvestorByInvestorName(String investorName) throws ServiceException {
		
		validateInvestor(investorName, "Investor Name");
		
		InvestorEntity investorEntity = investorManagerImpl.getInvestorByInvestorName(investorName);
		
		if(null == investorEntity)
			throw new ServiceException("No Investor found with investor name: "+investorName);
		
		return convertor.toInvestorModel(investorEntity);
	}

	@Override
	public InvestorModel addInvestor(InvestorModel investorModel) throws ServiceException {

		validateInvestor(investorModel);

		InvestorEntity investorEntity = investorManagerImpl.getInvestorByInvestorName(investorModel.getInvestorName());
		
		if(null != investorEntity)
			throw new ServiceException("Investor name not unavailable");

		return convertor.toInvestorModel(investorManagerImpl.addInvestor(convertor.toInvestorEntity(investorModel)));
	}

	@Override
	public InvestorModel updateInvestor(InvestorModel investorModel) throws ServiceException {

		validateInvestor(investorModel);

		InvestorEntity investorEntity =  investorManagerImpl.updateInvestor(convertor.toInvestorEntity(investorModel));
		
		if(!investorModel.getInvestorName().equalsIgnoreCase(investorEntity.getInvestorName()))
			throw new ServiceException("Investor Name cannot be updated");

		return convertor.toInvestorModel(investorEntity);
	}

	@Override
	public void deleteInvestor(String investorId) throws ServiceException {
		
		validateInvestor(investorId, "Investor Id");
		
		investorManagerImpl.deleteInvestor(investorId);

	}

	@Override
	public List<InvestorModel> getAllInvestors() throws ServiceException {
		
		List<InvestorEntity> investorEntities =  investorManagerImpl.getAllInvestors();
		
		List<InvestorModel> investorModels = new LinkedList<>();
		
		investorEntities.forEach(investorEntity -> {
			investorModels.add(convertor.toInvestorModel(investorEntity));
		});
		
		return investorModels;
	}

	private void validateInvestor(InvestorModel investorModel)
	{
		if(ObjectUtils.isEmpty(investorModel) || ObjectUtils.isEmpty(investorModel.getInvestorName()))
			throw new ServiceException("Investor Name cannot be empty");

		if(ObjectUtils.isEmpty(investorModel.getInvestorUrl()))
			throw new ServiceException("Investor URL cannot be empty");
	}
	
	private void validateInvestor(String investor, String message)
	{
		if(ObjectUtils.isEmpty(investor))
			throw new ServiceException(message + " cannot be empty");
	}
}
