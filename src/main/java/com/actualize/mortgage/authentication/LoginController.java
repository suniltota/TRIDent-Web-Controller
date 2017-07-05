package com.actualize.mortgage.authentication;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
   
	@RequestMapping(value={"/isLoggedIn"}, method = RequestMethod.GET)
	public String isLoggedIn(HttpServletRequest request,
            HttpServletResponse response, Principal principal){
		return principal.getName()+" user session exists";
	}
	
	@RequestMapping(value={"/logoutSuccess"}, method = RequestMethod.GET)
	public String logoutSuccess(HttpServletRequest request,
            HttpServletResponse response){
		return "Logout Sucessfully";
	}
	
}
