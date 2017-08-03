package com.actualize.mortgage.web.utils;

import java.util.Random;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
/**
 * 
 * @author sboragala
 *
 */
public class PasswordHelper{

    private static final PasswordEncoder myEncoder = new ShaPasswordEncoder( 256 );

    public static String encodePassword(String password, String userName) {
        return myEncoder.encodePassword(password, userName);
    }
    
  /*  public static void main(String args[]){
    	String password = encodePassword("1234", "admin1");
    	System.out.println(password);
    	
    }*/
    public static String getDefaultPassword()
	{
		Random random = new Random();
		String passwordSourceStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%*";
		int passwordLength = 8;
		String password = "";
		while (passwordLength > 0)
		{
			password += passwordSourceStr.charAt(random.nextInt(passwordSourceStr.length()) + 0);
			passwordLength--;
		}
		return password;
	}
}