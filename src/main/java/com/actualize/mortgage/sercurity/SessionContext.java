package com.actualize.mortgage.sercurity;
import java.io.Serializable;

import com.actualize.mortgage.UserDetails;

public class SessionContext implements CurrentUserIdProvider, Serializable{

    private static final long serialVersionUID = 10863223L;

    UserDetails userDetails;
    
    String sessionId;

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    
    public UserDetails getUserDetails() {
        return userDetails;
    }
  
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public Long getUserId() {
        return userDetails.getId();
    }

    @Override
    public String getUsername() {
        return userDetails.getLoginName();
    }
}
