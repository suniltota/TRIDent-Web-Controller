/**
 * 
 */
package com.actualize.mortgage.services.impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.datamodels.UserDetailsEntity;
import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.UserManager;
import com.actualize.mortgage.services.UserService;
import com.actualize.mortgage.web.utils.Convertor;

/**
 * @author sboragala
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final String DEFAULT_SESSION_TIME = "21600";

	@Autowired
	private UserManager userManagerImpl;
	
	@Autowired
	private Convertor convertor;

	@Override
	public UserDetailsModel getUserDetailsById(String userId) throws ServiceException {
		UserDetailsEntity userDetailsEntity = userManagerImpl.getUserById(userId);
		if(null == userDetailsEntity)
			throw new ServiceException("No results found with userId: "+ userId);
		
		return convertor.toUserDetails(userDetailsEntity);
	}

	@Override
	public UserDetailsModel getUserDetailsByUsername(String userName) throws ServiceException {
		
		UserDetailsEntity userDetailsEntity = userManagerImpl.getUserByUserName(userName);
		if(null == userDetailsEntity)
			throw new ServiceException("No results found with userName: "+ userName);
		return convertor.toUserDetails(userDetailsEntity);
	}

	//@SuppressWarnings("deprecation")
	@Override
	public UserDetailsModel addUserDetails(UserDetailsModel userDetails) throws ServiceException {
		
		UserDetailsEntity userDetailsEntity = userManagerImpl.getUserByUserName(userDetails.getUsername());
		if(null != userDetailsEntity)
			throw new ServiceException("Username not available");
		/*userDetailsEntity = userManagerImpl.getUserByEmail(userDetails.getEmail());
		if(null != userDetailsEntity)
			throw new ServiceException("Email not available");*/
			userDetails.setPasswordExpiryDate(LocalDate.now().plusDays(30).toString());
			userDetails.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
			userDetails.setPassword(new BCryptPasswordEncoder().encode(userDetails.getPassword().trim()));
			String current = LocalDate.now().toString();
			userDetails.setModificationDate(current);
			userDetails.setCreationDate(current);
			userDetails.setLastSuccessfulLogin(current);
			userDetails.setLastSuccessfulLogout(current);
			if(userDetails.getSessionTimeOut() == null || userDetails.getSessionTimeOut().length() == 0){
				userDetails.setSessionTimeOut(DEFAULT_SESSION_TIME);
			}
		return convertor.toUserDetails(userManagerImpl.addUser(convertor.toUserDetailsEntity(userDetails)));
	}

	@Override
	public UserDetailsModel updateUser(UserDetailsModel userDetails) throws ServiceException {
		UserDetailsModel userDetailsModel = convertor.toUserDetails(userManagerImpl.getUserByUserName(userDetails.getUsername()));
		userDetails.setPassword(userDetailsModel.getPassword());
		return convertor.toUserDetails(userManagerImpl.updateUser(convertor.toUserDetailsEntity(userDetails)));
	}

	@Override
	public void deleteUser(String userId) {
		userManagerImpl.deleteUser(userId);
	}

	@Override
	public List<UserDetailsModel> getAllUsersbyClientId(String clientId) throws ServiceException {
		List<UserDetailsModel> userDetailsList = new LinkedList<>();
		
		List<UserDetailsEntity> userDetailsEntities = userManagerImpl.getAllUsersbyClientId(clientId);
		for(UserDetailsEntity  userDetailsEntity: userDetailsEntities)
		{
			UserDetailsModel userDetails = convertor.toUserDetails(userDetailsEntity);
			userDetails.setPassword("[PROTECTED]");
			userDetailsList.add(userDetails);
		}
		
		return userDetailsList;
	}

	@Override
	public List<UserDetailsModel> getAllUsers() throws ServiceException {
		
		List<UserDetailsModel> userDetailsList = new LinkedList<>();
		
		List<UserDetailsEntity> userDetailsEntities = userManagerImpl.getAllUsers();
		for(UserDetailsEntity  userDetailsEntity: userDetailsEntities)
		{
			UserDetailsModel userDetails = convertor.toUserDetails(userDetailsEntity);
			userDetails.setPassword("[PROTECTED]");
			userDetailsList.add(userDetails);
		}
		
		return userDetailsList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public UserDetailsModel changePassword(String currentPassword, String newPassword, String confirmNewPassword) throws ServiceException {
		
		if( currentPassword.contains(" ") || newPassword.contains(" ") || confirmNewPassword.contains(" ") )
			throw new ServiceException("Spaces not allowed in password");
		if(currentPassword.trim().isEmpty())
			throw new ServiceException("Current Password Required");
		if(newPassword.trim().isEmpty())
			throw new ServiceException("New Password Required");
		if("[PROTECTED]".equalsIgnoreCase(newPassword))
			throw new ServiceException("Invalid New Password");
		if(confirmNewPassword.trim().isEmpty())
			throw new ServiceException("Confirm New Password Required");
		if(currentPassword.equals(newPassword))
			throw new ServiceException("Old Password and New Password can't be same");
		UserDetailsModel userDetails = new UserDetailsModel();
		if(newPassword.equalsIgnoreCase(confirmNewPassword))
		{
			userDetails = getUserDetailsByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			
			if(userDetails.getPassword().equals(new BCryptPasswordEncoder().encode(currentPassword)))
			{
				userDetails.setPassword(new BCryptPasswordEncoder().encode(newPassword));
				updateUser(userDetails);
			}
			
		}
		else
			throw new ServiceException("New Password and Confirm New Password does not match");
		return userDetails;
	}
}
