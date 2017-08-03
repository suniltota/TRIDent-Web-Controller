/**
 * 
 */
package com.actualize.mortgage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.UserService;

/**
 * @author sboragala
 *
 */
@RestController
@RequestMapping(value = "/actualize/transformx/")
public class UserApiImpl {
	
	@Autowired
	private UserService userServiceImpl;
	
	
	@RequestMapping(value = "/{version}/user", method = { RequestMethod.POST })
	public UserDetailsModel addUser(@PathVariable String version, @RequestBody UserDetailsModel userDetails) throws ServiceException{
		userServiceImpl.addUserDetails(userDetails);
		return userDetails;
	}

}
