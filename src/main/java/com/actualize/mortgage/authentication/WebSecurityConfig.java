package com.actualize.mortgage.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RESTAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private RESTAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
    private LogoutHandler logoutHandler;
	@Autowired
	private UserDetailsService userDetailsService;
	
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
       return new BCryptPasswordEncoder();
    }
    
	
	/*@Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
      
	auth.inMemoryAuthentication()
	  .withUser("admin").password("123456").roles("ADMIN");
    }*/
  /* public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("Compugain@123"));
	}*/
  /*  @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }*/
    
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*ReflectionSaltSource rss = new ReflectionSaltSource();
        rss.setUserPropertyToUse("username");
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setSaltSource(rss);
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        auth.authenticationProvider(provider);
       */
    	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    /*
    @SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder passwordEncoder() throws Exception{
    	return new PasswordEncoder() {
    		 private final PasswordEncoder myEncoder = new ShaPasswordEncoder( 256 );
			
			@Override
			public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
				if(encPass.equalsIgnoreCase(encodePassword(rawPass, salt)))
					return true;
				return false;
			}
			
			@Override
			public String encodePassword(String rawPass, Object salt) {
				return myEncoder.encodePassword(rawPass, salt);
			}
			
		};
    	
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated().and().formLogin().permitAll().and().csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		http.formLogin().successHandler(authenticationSuccessHandler);
		http.formLogin().failureHandler(authenticationFailureHandler);
		http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutHandler).deleteCookies("JSESSIONID").logoutSuccessUrl("/logoutSuccess");
    }
    
 	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}