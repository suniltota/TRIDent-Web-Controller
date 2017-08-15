/**
 * 
 */
package com.actualize.mortgage.manager.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger LOG = LogManager.getLogger(UserActivityManagerimpl.class);

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public UserActivityEntity insertUserActivity(UserActivityEntity userActivityEntity) throws ServiceException {
		try{
		entityManager.merge(userActivityEntity);
		return userActivityEntity;
		}
		catch(Exception e)
		{
			LOG.error("failed to insert user activity"+ userActivityEntity.toString());
			LOG.error("failed to insert user activity for reason: "+ e.toString());
		}
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
