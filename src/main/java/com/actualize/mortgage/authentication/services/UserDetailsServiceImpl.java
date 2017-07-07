package com.actualize.mortgage.authentication.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserConfig userConfig;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == null || username.trim().length() ==0 )
			throw new UsernameNotFoundException("User Name can't be empty ");
		String password = userConfig.getEnv().getProperty(username.toLowerCase());
		if(password!=null && password.length()>0){
			String userRoles = userConfig.getEnv().getProperty(username+"-roles");
			if(userRoles == null || userRoles.trim().length() == 0){
				throw new UsernameNotFoundException("User roles not found: "+ username);
			}
			String[] roles = userRoles.split(",");
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (String role : roles){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role));
	        }
			return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
		}else{
			throw new UsernameNotFoundException("User not found: "+ username);
		}
	}
}
