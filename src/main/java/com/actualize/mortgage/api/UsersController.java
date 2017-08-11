package com.actualize.mortgage.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.UserService;

@RestController
@RequestMapping(value = "actualize/transformx/")
public class UsersController {

	private static final Logger LOG = LogManager.getLogger(UsersController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/users"}, method = RequestMethod.GET)
	public List<UserDetailsModel> getUsers() throws ServiceException {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value={"/users/{id}"}, method = RequestMethod.GET)
	public UserDetailsModel getUserById(@PathVariable("id") String userId) throws ServiceException {
		return userService.getUserDetailsById(userId);
	}
	
	@RequestMapping(value={"/users"}, method = RequestMethod.POST)
	public ResponseEntity<String>  createUser(@RequestBody UserDetailsModel userDetails) throws ServiceException {
		userService.addUserDetails(userDetails);
		return new ResponseEntity<String>("User created Successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value={"/users/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("id") String userId) throws ServiceException {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User created Successfully", HttpStatus.OK);
	}

	@RequestMapping(value={"/users"}, method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody UserDetailsModel userDetails) throws ServiceException {
		userService.updateUser(userDetails);
		return new ResponseEntity<String>("User updated Successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value={"/users/userAvailability"}, method = RequestMethod.GET)
	public Boolean userAvailability(@PathVariable("username") String userName) throws ServiceException {
		UserDetailsModel userDetailsModel= userService.getUserDetailsByUsername(userName);
		return userDetailsModel == null ? false : true;
	}
	
	@RequestMapping(value={"/getClientUsers/{id}"}, method = RequestMethod.GET)
	public List<UserDetailsModel> clientUsers(@PathVariable("id") String clientId) throws ServiceException {
		return userService.getAllUsersbyClientId(clientId);
	}
}
