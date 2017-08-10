/**
 * 
 */
package com.actualize.mortgage.manager.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.actualize.mortgage.datamodels.InvestorEntity;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.InvestorManager;

/**
 * @author sboragala
 *
 */
@Repository
@Transactional
public class InvestorManagerImpl implements InvestorManager {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public InvestorEntity getInvestorByInvestorId(String investorId) throws ServiceException {
		return entityManager.find(InvestorEntity.class, investorId);
	}

	
	@Override
	public InvestorEntity getInvestorByInvestorName(String investorName) throws ServiceException {
		try{
			return (InvestorEntity) entityManager.createQuery(
					"from InvestorEntity where investorName = :investorName")
					.setParameter("investorName", investorName)
					.getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
		catch(NonUniqueResultException e)
		{
			throw new ServiceException("More than one Result found");
		}
	}

	@Override
	public InvestorEntity addInvestor(InvestorEntity investorEntity) {
		entityManager.merge(investorEntity);
		return investorEntity; 
	}

	@Override
	public InvestorEntity updateInvestor(InvestorEntity investorEntity) {
		entityManager.merge(investorEntity);
		return investorEntity; 
	}

	@Override
	public void deleteInvestor(String investorId) {
	entityManager.remove(entityManager.find(InvestorEntity.class, investorId));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvestorEntity> getAllInvestors() {
		try{
			return (List<InvestorEntity>) entityManager.createQuery("from InvestorEntity").getResultList();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

	
}
