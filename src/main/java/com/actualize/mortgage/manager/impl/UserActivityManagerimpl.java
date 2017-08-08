/**
 * 
 */
package com.actualize.mortgage.manager.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.actualize.mortgage.datamodels.UserActivityEntity;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.UserActivityManager;

/**
 * @author sboragala
 *
 */
@Repository
@Transactional
public class UserActivityManagerimpl implements UserActivityManager {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public UserActivityEntity insertUserActivity(UserActivityEntity userActivityEntity) throws ServiceException {
		entityManager.persist(userActivityEntity);
		return userActivityEntity;
	}

	@Override
	public List<UserActivityEntity> getAllUserActivity() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserActivityEntity> getUserActivityByUserId(String userId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserActivityEntity> getUserActivityByClientId(String clientId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserActivityEntity> getUserActivityByUserIdWithSpecificNumberOfRecords(String userId,
			String numberOfRecords) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserActivityEntity> getUserActivityByClientIdWithSpecificNumberOfRecords(String clientId,
			String numberOfRecords) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserActivityEntity> getUserActivityBySpecificLoanId(String loanId, String clientId)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
