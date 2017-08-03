/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import com.actualize.mortgage.datamodels.UserDetailsEntity;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface UserManager  {
	
	
	public UserDetailsEntity getUserById(String userId) throws ServiceException;
	
	public UserDetailsEntity getUserByEmail(String email) throws ServiceException;
	
	public UserDetailsEntity getUserByUserName(String userName) throws ServiceException;
	
	public UserDetailsEntity addUser(UserDetailsEntity userDetailsEntity);
	
	public UserDetailsEntity updateUser(UserDetailsEntity userDetailsEntity);
	
	public void deleteUser(String id);
	
	public List<UserDetailsEntity> getAllUsersbyClientId(String clientId) throws ServiceException;
	
	public List<UserDetailsEntity> getAllUsers() throws ServiceException;

	
}
