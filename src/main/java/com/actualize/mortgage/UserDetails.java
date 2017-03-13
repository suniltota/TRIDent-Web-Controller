package com.actualize.mortgage;

import java.io.Serializable;
import java.util.Date;

import org.mismo.residential._2009.schemas.MESSAGE;


public class UserDetails implements Serializable{

    private Long id;
    private static final long serialVersionUID = 100062L;
    private String loginName;
    private String password;
    private MESSAGE message;
    public MESSAGE getMessage() {
		return message;
	}
	public void setMessage(MESSAGE message) {
		this.message = message;
	}
	/**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }
    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
