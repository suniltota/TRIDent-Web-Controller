package com.actualize.mortgage.authentication;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
   
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public String login(HttpServletRequest request,
            HttpServletResponse response){
		return "Login Success";
	}
	
	@RequestMapping(value={"/check"}, method = RequestMethod.GET)
	public String check(HttpServletRequest request,
            HttpServletResponse response){
		return "check Success";
	}
	
	@RequestMapping(value={"/okcheck"}, method = RequestMethod.GET)
	public String checkOk(HttpServletRequest request,
            HttpServletResponse response){
		return "ok Success";
	}
	
}
