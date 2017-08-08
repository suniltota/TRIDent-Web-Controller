/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import com.actualize.mortgage.datamodels.UserActivityEntity;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface UserActivityManager {
	
	/**
	 * inserts useractivity
	 * @param userActivityEntity entity to insert
	 * @return userActivityEntity returns the inserted entity
	 * @throws ServiceException throws user defined exception message
	 */
	public UserActivityEntity insertUserActivity(UserActivityEntity userActivityEntity) throws ServiceException;
	
	/**
	 * returns all the records of useractivity
	 * @return List<UserActivityEntity> list of useractivity
	 * @throws ServiceException throws user defined exception message
	 */
	public List<UserActivityEntity> getAllUserActivity() throws ServiceException;
	
	/**
	 * returns all the records of useractivity specific to single user 
	 * @param userId specific userid to get the records
	 * @return List<UserActivityEntity> list of useractivity
	 * @throws ServiceException throws user defined exception message
	 */
	public List<UserActivityEntity> getUserActivityByUserId(String userId) throws ServiceException;
	
	/**
	 * returns all the records of useractivity specific to single client id 
	 * @param clientId specific client id to get the records
	 * @return List<UserActivityEntity> list of useractivity
	 * @throws ServiceException throws user defined exception message
	 */
	public List<UserActivityEntity> getUserActivityByClientId(String clientId) throws ServiceException;
	
	/**
	 * 
	 * @param userId
	 * @param numberOfRecords
	 * @return List<UserActivityEntity> specific number of user activity entries 
	 * @throws ServiceException throws user defined exception message
	 */
	public List<UserActivityEntity> getUserActivityByUserIdWithSpecificNumberOfRecords(String userId, String numberOfRecords) throws ServiceException;
	public List<UserActivityEntity> getUserActivityByClientIdWithSpecificNumberOfRecords(String clientId, String numberOfRecords) throws ServiceException;
	public List<UserActivityEntity>	getUserActivityBySpecificLoanId(String loanId, String clientId) throws ServiceException;
}
