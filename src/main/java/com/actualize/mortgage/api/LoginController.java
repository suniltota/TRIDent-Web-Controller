package com.actualize.mortgage.api;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.UserDetailsModel;

@RestController
public class LoginController {
   
	
	@RequestMapping(value={"/login"}, method = RequestMethod.POST)
	public String login(HttpServletRequest request,
            HttpServletResponse response, Principal principal){
		return principal.getName()+" user session";
	}
	
	@RequestMapping(value={"/isLoggedIn"}, method = RequestMethod.GET)
	public String isLoggedIn(HttpServletRequest request,
            HttpServletResponse response, Principal principal){
		return principal.getName()+" user session exists";
	}
	
	@RequestMapping(value={"/userDetails"}, method = RequestMethod.GET)
	public UserDetailsModel getUserDetails(HttpServletRequest request,
            HttpServletResponse response){
		return (UserDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@RequestMapping(value={"/logout"}, method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
            HttpServletResponse response){
		return "Logout called";
	}
	
}
