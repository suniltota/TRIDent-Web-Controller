package com.actualize.mortgage.sercurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * When an authentication error occurs most often we will want to send an exception up to the front end.
 * If you append the parameter 'form' to the URL it will present the default spring security login page. 
 * @author smutyala
 *
 */
public class AMAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	@Autowired
	@Qualifier("standardFormLoginEntryPoint")
	private final LoginUrlAuthenticationEntryPoint formLoginEntryPoint = null;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,	AuthenticationException ex) throws IOException, ServletException {
		
		if (request.getParameter("form") != null) {
			formLoginEntryPoint.commence(request, response, ex);
		} else {	    
		}
	}

}
