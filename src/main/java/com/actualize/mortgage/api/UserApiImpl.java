package com.actualize.mortgage.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.UserDetails;
import com.actualize.mortgage.sercurity.SessionContext;
import com.actualize.mortgage.sercurity.StringUtil;
import com.actualize.mortgage.services.UserServices;


@RestController
@RequestMapping(value="/user")
public class UserApiImpl {

    private static final Logger log = Logger.getLogger(UserApiImpl.class);

    @Autowired
    UserServices userServices;

    @Autowired
    SessionContext sessionContext;
    
    @Autowired
    @Qualifier("authenticationManager")
    ProviderManager providerManager = null;

    @ResponseBody
    @RequestMapping(value="/login", method = {RequestMethod.POST})
    public UserDetails login(@RequestParam("username") String username, @RequestParam("password") String password) throws UsernameNotFoundException {

        final String actualUsername = StringUtil.stripWhitespaceFrom(username).replaceAll("['\"\n\\]\\[]", "");
        String actualPassword = password.replaceAll("['\"\n\\]\\[]", "");

        if (username == null || password == null) {
            throw new UsernameNotFoundException("Invalid Credentials");
        }
        SecurityContext context = SecurityContextHolder.getContext();
        try {
            Authentication auth = new UsernamePasswordAuthenticationToken(actualUsername, actualPassword);
            auth = providerManager.authenticate(auth);
            UserDetails userDetails = userServices.findUserDetailsByUserName(actualUsername);
            context.setAuthentication(auth);
            log.info("successful user login: " + actualUsername);
            userDetails.setPassword("********");
            sessionContext.setUserDetails(userDetails);
            return userDetails;
        } catch (AuthenticationException e) {
            context.setAuthentication(null);
            sessionContext.setUserDetails(null);
            log.warn(e.getMessage());
            throw e;
        }
    }
    
    @RequestMapping(value = "/isLoggedIn", method = { RequestMethod.GET, RequestMethod.POST })
    public UserDetails isLoggedIn() throws Exception {
    	 UserDetails userDetails = new UserDetails(); 
    	if (sessionContext.getUserDetails()!=null) {
            userDetails = sessionContext.getUserDetails();
        }
        return userDetails;
    }
}
