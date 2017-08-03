package com.actualize.mortgage.authentication.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.actualize.mortgage.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userServiceImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == null || username.trim().length() == 0 )
			throw new UsernameNotFoundException("User Name can't be empty ");
		
			UserDetailsModel userDetails = userServiceImpl.getUserDetailsByUsername(username);
			
	        return userDetails;
	}
}
