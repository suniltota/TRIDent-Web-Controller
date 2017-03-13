package com.actualize.mortgage.services.impl;

import java.util.Collections;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.UserDetails;
import com.actualize.mortgage.services.User;
import com.actualize.mortgage.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {
    
    @Resource(name="users")
    private Properties users;
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = this.findUserDetailsByUserName(username);
        if (null == userDetails) {
            throw new UsernameNotFoundException("The user with name " + username + " was not found");
        }

        User user = new User();
        user.setName(userDetails.getLoginName());
        user.setPassword(userDetails.getPassword());
        user.setRoles(Collections.singleton("ADMIN"));
        return user;
    }

    public UserDetails findUserDetailsByUserName(String userName) throws UsernameNotFoundException {
        if (userName != null) {
            UserDetails userDetails = new UserDetails();
            if(users.getProperty(userName) != null) 
            userDetails.setLoginName(userName);
            userDetails.setPassword(users.getProperty(userName));
            userDetails.setId(1L);
            return userDetails;
        } else
            throw new UsernameNotFoundException("No Users Found :" + userName);
    }

}
