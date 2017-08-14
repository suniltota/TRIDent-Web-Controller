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

import com.actualize.mortgage.datamodels.InvestorUserDetailsEntity;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.InvestorUserDetailsManager;

/**
 * @author sboragala
 *
 */
@Repository
@Transactional
public class InvestorUserDetailsManagerImpl implements InvestorUserDetailsManager {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public InvestorUserDetailsEntity getInvestorUserDetailsById(String investorUserId) throws ServiceException {
		return entityManager.find(InvestorUserDetailsEntity.class, investorUserId);
	}

	@Override
	public InvestorUserDetailsEntity getInvestorUserDetailsByInvestorUserName(String investorUserName, String clientId)
			throws ServiceException {
		try{
			return (InvestorUserDetailsEntity) entityManager.createQuery(
					"from InvestorUserDetailsEntity where username = :investorUserName")
					.setParameter("investorUserName", investorUserName)
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
	public InvestorUserDetailsEntity addInvestorUserDetailsEntity(InvestorUserDetailsEntity investorUserDetailsEntity)
			throws ServiceException {
		entityManager.persist(investorUserDetailsEntity);
		return investorUserDetailsEntity;
	}

	@Override
	public InvestorUserDetailsEntity updateInvestorUserDetails(InvestorUserDetailsEntity investorUserDetailsEntity)
			throws ServiceException {
		entityManager.merge(investorUserDetailsEntity);
		return investorUserDetailsEntity;
	}

	@Override
	public void deleteInvestorUserDetails(String investorUserId) throws ServiceException {
		entityManager.remove(entityManager.find(InvestorUserDetailsEntity.class, investorUserId));
	}

	@Override
	public List<InvestorUserDetailsEntity> getAllInvestorUserDetailsByClientId(String clientId)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
