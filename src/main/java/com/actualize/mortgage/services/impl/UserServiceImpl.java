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
import org.springframework.util.ObjectUtils;

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
		return convertor.toUserDetails(userDetailsEntity);
	}

	@Override
	public UserDetailsModel addUserDetails(UserDetailsModel userDetails) throws ServiceException {
		
		if(ObjectUtils.isEmpty(userDetails)){
			throw new ServiceException("User details mandatory!");
		}
		
		if(ObjectUtils.isEmpty(userDetails.getUsername())){
			throw new ServiceException("Username is empty/null!");
		}
		
		if(ObjectUtils.isEmpty(userDetails.getPassword())){
			throw new ServiceException("Password is empty/null!");
		}
		
		if(ObjectUtils.isEmpty(userDetails.getEmail())){
			throw new ServiceException("Email is empty/null!");
		}
		if(ObjectUtils.isEmpty(userDetails)){
			throw new ServiceException("User details mandatory!");
		}
		UserDetailsEntity userDetailsEntity = userManagerImpl.getUserByUserName(userDetails.getUsername());
		if(null != userDetailsEntity)
			throw new ServiceException("Username already taken");
		userDetailsEntity = userManagerImpl.getUserByEmail(userDetails.getEmail());
		if(null != userDetailsEntity)
			throw new ServiceException("Email already taken");
		userDetails.setPasswordExpiryDate(LocalDate.now().plusDays(30).toString());
		userDetails.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		userDetails.setPassword(new BCryptPasswordEncoder().encode(userDetails.getPassword().trim()));
		userDetails.setAccountNonExpired(true);
		userDetails.setAccountNonLocked(true);
		userDetails.setCredentialsNonExpired(true);
		userDetails.setEnabled(true);
		userDetails.setLastSuccessfulLogin("1");
		userDetails.setLastSuccessfulLogout("1");
		if(userDetails.getSessionTimeOut() == null || userDetails.getSessionTimeOut().length() == 0){
			userDetails.setSessionTimeOut(DEFAULT_SESSION_TIME);
		}
		return convertor.toUserDetails(userManagerImpl.addUser(convertor.toUserDetailsEntity(userDetails)));
	}

	@Override
	public UserDetailsModel updateUser(UserDetailsModel userDetails) throws ServiceException {
		UserDetailsEntity userDetailsEntity = userManagerImpl.getUserById(userDetails.getUserId());
		if(null == userDetailsEntity)
			throw new ServiceException("Invalid user id");
		UserDetailsModel userDetailsModel = convertor.toUserDetails(userDetailsEntity);
		userDetails.setUsername(userDetailsModel.getUsername());
		userDetails.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

		return convertor.toUserDetails(userManagerImpl.updateUser(convertor.toUserDetailsEntity(userDetails)));
	}

	@Override
	public void deleteUser(String userId) {
		userManagerImpl.activeOrdeActivate(userId, false);
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

	@Override
	public UserDetailsModel resetPassword(String userName, String desiredPassword) throws ServiceException {
		if( desiredPassword.contains(" "))
			throw new ServiceException("Spaces not allowed in password");
		if(desiredPassword.trim().isEmpty())
			throw new ServiceException("Password Required");
		if("[PROTECTED]".equalsIgnoreCase(desiredPassword))
			throw new ServiceException("Invalid New Password");
		if(userName.trim().isEmpty())
			throw new ServiceException("User Name Required");

		UserDetailsModel userDetails = getUserDetailsByUsername(userName);
		if(null == userDetails)
			throw new ServiceException("Invalid UserName");
		userDetails.setPassword(new BCryptPasswordEncoder().encode(desiredPassword));
		updateUser(userDetails);

		return userDetails;
	}

	@Override
	public void activeorDeactiveGroupUsers(String groupId, Boolean enabled) throws ServiceException {
		userManagerImpl.activeorDeactiveGroupUsers(groupId, enabled);
	}

	@Override
	public void activeorDeactiveMultipleGroupUsers(List<String> groupIds, Boolean enabled) throws ServiceException {
		userManagerImpl.activeorDeactiveMultipleGroupUsers(groupIds, enabled);
	}

}
