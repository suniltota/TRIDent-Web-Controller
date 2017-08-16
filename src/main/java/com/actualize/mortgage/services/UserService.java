/**
 * 
 */
package com.actualize.mortgage.services;

import java.util.List;

import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface UserService {

	public UserDetailsModel getUserDetailsById(String userId) throws ServiceException;

	public UserDetailsModel getUserDetailsByUsername(String userName) throws ServiceException;

	public UserDetailsModel addUserDetails(UserDetailsModel userDetails) throws ServiceException;

	public UserDetailsModel updateUser(UserDetailsModel userDetails) throws ServiceException;

	public void deleteUser(String userId);

	public List<UserDetailsModel> getAllUsersbyClientId(String clientId) throws ServiceException;

	public List<UserDetailsModel> getAllUsers() throws ServiceException;

	public UserDetailsModel changePassword(String currentPassword, String newPassword, String confirmNewPassword)
			throws ServiceException;

	public UserDetailsModel resetPassword(String userName, String desiredPassword) throws ServiceException;

	public void activeorDeactiveGroupUsers(String groupId, Boolean enabled) throws ServiceException;

	public void activeorDeactiveMultipleGroupUsers(List<String> groupIds, Boolean enabled) throws ServiceException;
}
