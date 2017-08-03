package com.actualize.mortgage.authentication;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RESTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private static final Logger LOG = LogManager.getLogger(RESTAuthenticationSuccessHandler.class);
	public final Integer SESSION_TIMEOUT_IN_SECONDS = 60 * 60 * 3; //3 hours

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		LOG.info(authentication.getName()+" user signed in Sucessfully");
		request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);
		
		ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        UserDetailsModel userDetails = (UserDetailsModel) authentication.getPrincipal();
        userDetails.setPassword("");
        writer.write(mapper.writeValueAsString(userDetails));
        writer.flush();	
        
		clearAuthenticationAttributes(request);
		
	}
}
