package com.actualize.mortgage.sercurity;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class PasswordHelper {

    private static final PasswordEncoder myEncoder = new ShaPasswordEncoder( 256 );

    public static String encodePassword(String userName, String password) {
        return myEncoder.encodePassword(password, userName);
    }
    
    public static void main(String args[]){
    	String password = encodePassword("user", "123456");
    	System.out.println(password);
    	
    }
}