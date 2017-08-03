/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author sboragala
 *
 */
public class UserDetailsModel implements UserDetails  {
	
	private static final long serialVersionUID = -4782585539283649741L;

	private String userId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String surName;
	private String username;
	private String password;
	private String email;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private int failedLoginAttempts;
	private boolean resetPassword;
	private boolean enabled;
	private String passwordExpiryDate; 
	private String lastSuccessfulLogin;
	private String lastSuccessfulLogout;
	private String sessionTimeOut;
	private Set<GrantedAuthority> authorities;
	private RoleModel role;
	private ClientModel client;
	private String updatedBy;
	private String modificationDate;
	private String creationDate;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	/**
	 * @return the lastSuccessfulLogin
	 */
	public String getLastSuccessfulLogin() {
		return lastSuccessfulLogin;
	}
	/**
	 * @param lastSuccessfulLogin the lastSuccessfulLogin to set
	 */
	public void setLastSuccessfulLogin(String lastSuccessfulLogin) {
		this.lastSuccessfulLogin = lastSuccessfulLogin;
	}
	/**
	 * @return the lastSuccessfulLogout
	 */
	public String getLastSuccessfulLogout() {
		return lastSuccessfulLogout;
	}
	/**
	 * @param lastSuccessfulLogout the lastSuccessfulLogout to set
	 */
	public void setLastSuccessfulLogout(String lastSuccessfulLogout) {
		this.lastSuccessfulLogout = lastSuccessfulLogout;
	}
	/**
	 * @return the sessionTimeOut
	 */
	public String getSessionTimeOut() {
		return sessionTimeOut;
	}
	/**
	 * @param sessionTimeOut the sessionTimeOut to set
	 */
	public void setSessionTimeOut(String sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the accountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	/**
	 * @return the accountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	/**
	 * @return the credentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	/**
	 * @return the failedLoginAttempts
	 */
	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}
	/**
	 * @param failedLoginAttempts the failedLoginAttempts to set
	 */
	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}
	/**
	 * @return the resetPassword
	 */
	public boolean isResetPassword() {
		return resetPassword;
	}
	/**
	 * @param resetPassword the resetPassword to set
	 */
	public void setResetPassword(boolean resetPassword) {
		this.resetPassword = resetPassword;
	}
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return the passwordExpiryDate
	 */
	public String getPasswordExpiryDate() {
		return passwordExpiryDate;
	}
	/**
	 * @param passwordExpiryDate the passwordExpiryDate to set
	 */
	public void setPasswordExpiryDate(String passwordExpiryDate) {
		this.passwordExpiryDate = passwordExpiryDate;
	}
	/**
	 * @return the authorities
	 */
	public Set<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<String> authorities) {
		Set<GrantedAuthority> authoritiesList = new HashSet<>();
		for(String authority: authorities)
			authoritiesList.add(new SimpleGrantedAuthority(authority));
		this.authorities = authoritiesList;
	}
	/**
	 * @return the role
	 */
	public RoleModel getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(RoleModel role) {
		this.role = role;
	}
	/**
	 * @return the client
	 */
	public ClientModel getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(ClientModel client) {
		this.client = client;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the modificationDate
	 */
	public String getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
}
