/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * defines user details table structure on database 
 * @author sboragala
 *
 */
@Entity
@Table(name="userdetails")
public class UserDetailsEntity implements Serializable {


	private static final long serialVersionUID = -1637974905981684170L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String userId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String suffix;
	private String username;
	private String password;
	private String email;
	private String authorities;
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
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="roleid")
	private RoleEntity role;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="groupid")
	private GroupEntity group;
	private String updatedBy;
	@Column(name="modificationDate", updatable=false, insertable=false)
	private Timestamp modificationDate;
	@Column(name="creationDate", updatable=false, insertable=false)
	private Timestamp creationDate;
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinTable(
            name = "user_services",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
	private Set<ServicesEntity> services;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="clientid")
	private ClientEntity client;

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
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}
	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
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
	 * @return the authorities
	 */
	public String getAuthorities() {
		return authorities;
	}
	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
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
	 * @return the role
	 */
	public RoleEntity getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	/**
	 * @return the client
	 */
	public GroupEntity getGroup() {
		return group;
	}
	/**
	 * @param client the client to set
	 */
	public void setGroup(GroupEntity group) {
		this.group = group;
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
	public Timestamp getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}
	/**
	 * @return the creationDate
	 */
	public Timestamp getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the services
	 */
	public Set<ServicesEntity> getServices() {
		return services;
	}
	/**
	 * @param services the services to set
	 */
	public void setServices(Set<ServicesEntity> services) {
		this.services = services;
	}
	/**
	 * @return the client
	 */
	public ClientEntity getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	
}
