package com.actualize.mortgage.authentication;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * This class adds new attributes to the default access Token.
 * @author msura
 *
 */
public class CustomTokenEnhancer implements TokenEnhancer {

	private static final Logger LOG = LogManager.getLogger(CustomTokenEnhancer.class);

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    	UserDetails user = (UserDetails) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();

        additionalInfo.put("user", user);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
     //  ((DefaultOAuth2AccessToken) accessToken).setExpiration(new Date(System.currentTimeMillis() + 600000000));
        return accessToken;
    }

}
