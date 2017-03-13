package com.actualize.mortgage.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.actualize.mortgage.UserDetails;

public interface UserServices {
    org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    UserDetails findUserDetailsByUserName(String userName) throws UsernameNotFoundException ;
}
