package com.actualize.mortgage.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class RESTAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static final Logger LOG = LogManager.getLogger(RESTAuthenticationFailureHandler.class);
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		LOG.error("RESTAuthenticationFailureHandler---------- "+exception.getMessage());
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        PrintWriter writer = response.getWriter();
        writer.write(exception.getMessage());
        writer.flush();	
      }
}