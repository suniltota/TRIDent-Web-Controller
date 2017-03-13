package com.actualize.mortgage.sercurity;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.actualize.mortgage.UserDetails;
import com.actualize.mortgage.services.User;
import com.actualize.mortgage.services.UserServices;

public class AuthenticationListener implements ApplicationListener<AbstractAuthenticationEvent> {

    @Autowired
    private final UserServices userServices = null;

    @Autowired
    HttpSession httpSession;
    
    @Autowired
    private final SessionContext sessionContext = null;

    private final Logger logger = Logger.getLogger(AuthenticationListener.class);

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent authEvent) {

        Object principal = authEvent.getAuthentication().getPrincipal();
        final String userName = principal instanceof User ? ( (User) principal ).getUsername() : principal.toString();

            if (authEvent instanceof AuthenticationSuccessEvent) {
                try {
                    UserDetails userRecord = userServices.findUserDetailsByUserName(userName);
                    sessionContext.setUserDetails(userRecord);
                    httpSession.setAttribute(UserSession.sessionId, userRecord);
                } catch (UsernameNotFoundException e) {
                    logger.error("Invalid username. Check Authentication Token", e);
                } 
            }
    }
}