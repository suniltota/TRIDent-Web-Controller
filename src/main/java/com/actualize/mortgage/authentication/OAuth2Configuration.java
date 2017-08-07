package com.actualize.mortgage.authentication;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This class will configure oAuth2. Authorization Server will grant the token after authenticating the user and  Resource Server will check for authorization before accessing the protected resources. 
 * @author msura
 *
 */
@Configuration
public class OAuth2Configuration {

	@Configuration
	@EnableAuthorizationServer
	protected static class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {
	  
	    @Autowired
	    @Qualifier("authenticationManagerBean")
	    private AuthenticationManager authenticationManager;
	 
	    @Override
	    public void configure(
	      AuthorizationServerSecurityConfigurer oauthServer) 
	      throws Exception {
	        oauthServer
	          .tokenKeyAccess("permitAll()").accessDeniedHandler(new ActualizeAccessDeniedHandler())
	          .checkTokenAccess("isAuthenticated()");
	    }
	 
	    @Override
	    public void configure(ClientDetailsServiceConfigurer clients) 
	      throws Exception {
	        clients.inMemory()//jdbc(dataSource())
	          .withClient("sampleClientId")
	          .authorizedGrantTypes("implicit")
	          .scopes("read")
	          .autoApprove(true)
	          .and()
	          .withClient("clientIdPassword")
	          .secret("secret")
	          .authorizedGrantTypes(
	            "password","authorization_code", "refresh_token")
	          .scopes("read")
	          .and()
	          .withClient("TRIDENTOOLKITAPP")
	          .secret("exc9ll9ntapp")
	          .authorizedGrantTypes(
	            "password","authorization_code", "refresh_token")
	          .scopes("read").accessTokenValiditySeconds(24 * 3600);
	    }
	 
	        
	    @Override
	    public void configure(
	      AuthorizationServerEndpointsConfigurer endpoints) 
	      throws Exception {
	    	final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
			tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
	        endpoints
	        .tokenStore(tokenStore())
	        .tokenEnhancer(tokenEnhancerChain).exceptionTranslator(providerExceptionHandler())
	          .authenticationManager(authenticationManager);
	    }
	 
	    @Bean
	    public WebResponseExceptionTranslator providerExceptionHandler() {
	        return new DefaultWebResponseExceptionTranslator() {
	        	private final Logger LOG = LogManager.getLogger(RESTAuthenticationFailureHandler.class);

	            @Override
	            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
	                ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
	                OAuth2Exception body = responseEntity.getBody();
	                HttpHeaders headers = new HttpHeaders();
	                headers.setAll(responseEntity.getHeaders().toSingleValueMap());
	                // do something with header or response
	                LOG.error("responseEntity.getStatusCode() :"+responseEntity.getStatusCode());
	                return new ResponseEntity<>(body, headers, responseEntity.getStatusCode());
	            }
	        };
	    }
	    @Autowired
	    private DataSource dataSource;

	    @Bean
	    public TokenStore tokenStore() {
	        return new JdbcTokenStore(dataSource);
	    }    
	    

	    @Bean public CustomTokenEnhancer tokenEnhancer() {
	        return new CustomTokenEnhancer();
	    }
	}
	
	
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Autowired
        private RESTAuthenticationEntryPoint authenticationEntryPoint;

        @Autowired
        private AcutalizeLogoutSuccessHandler logoutSuccessHandler;

        @Override
        public void configure(HttpSecurity http) throws Exception {

            http
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint)
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .and()
                    .csrf()
                    .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
                    .disable()
                    .headers()
                    .frameOptions().disable()
                    .and()
                    .authorizeRequests()
                   // .antMatchers("/users/**").hasAuthority("admin")
                   // .antMatchers("/users/**").hasAuthority("admin")
                  //  .antMatchers("/users/**").hasAuthority("admin")
                 //   .antMatchers("/oauth/token").permitAll()
                    .anyRequest().authenticated();
            	
            http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
        
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        	// TODO Auto-generated method stub
        	
        	super.configure(resources);
        }
        
    }
	
}

