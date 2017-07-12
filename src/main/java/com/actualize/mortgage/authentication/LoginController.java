package com.actualize.mortgage.authentication;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public User logoutSuccess(HttpServletRequest request,
            HttpServletResponse response){
		 User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return authUser;
	}
	
	@RequestMapping(value={"/logout"}, method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
            HttpServletResponse response){
		return "Logout called";
	}
	
}
