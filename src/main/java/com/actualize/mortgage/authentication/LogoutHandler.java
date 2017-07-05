/**
 * 
 */
package com.actualize.mortgage.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
/**
 * logout success handler
 * @author sboragala
 *
 */
@Component
public class LogoutHandler implements LogoutSuccessHandler {
	
	private static final Logger LOG = LogManager.getLogger(LogoutHandler.class);

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		LOG.info(authentication.getName()+" user logged out");
		
	}

}
