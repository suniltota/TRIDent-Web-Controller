package com.actualize.mortgage.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.actualize.mortgage.services.UserServices;


/**
 * A custom user details service that calls through our services layer to grab a user record
 */
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserServices userServices;
    
    public final static String VALID_CREDENTIALS = "VALID_CREDENTIALS";

    /*
     * (non-Javadoc)
     * @see org.springframework.security.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails result = userServices.loadUserByUsername(username);
        return result;
    }
}
