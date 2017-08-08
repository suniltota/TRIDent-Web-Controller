/**
 * 
 */
package com.actualize.mortgage.web.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.datamodels.ClientEntity;
import com.actualize.mortgage.datamodels.RoleEntity;
import com.actualize.mortgage.datamodels.UserDetailsEntity;
import com.actualize.mortgage.domainmodels.ClientModel;
import com.actualize.mortgage.domainmodels.RoleModel;
import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.ClientManager;
import com.actualize.mortgage.manager.RoleManager;

/**
 * this class defines the conversion of domain models to data models and vice versa
 * @author sboragala
 *
 */
@Service
public class Convertor {
	
	@Autowired
	private RoleManager roleManagerImpl;
	
	@Autowired
	private ClientManager clientManagerImpl; 
	
		
	public UserDetailsModel toUserDetails(final UserDetailsEntity userDetailsEntity)
	{
		UserDetailsModel userDetails = new UserDetailsModel();
			userDetails.setUserId(userDetailsEntity.getUserId());
			userDetails.setUsername(userDetailsEntity.getUsername());
			userDetails.setFirstName(userDetailsEntity.getFirstName());
			userDetails.setMiddleName(userDetailsEntity.getMiddleName());
			userDetails.setLastName(userDetailsEntity.getLastName());
			userDetails.setSurName(userDetailsEntity.getSuffix());
			userDetails.setAccountNonExpired(userDetailsEntity.isAccountNonExpired());
			userDetails.setAccountNonLocked(userDetailsEntity.isAccountNonLocked());
			userDetails.setCredentialsNonExpired(userDetailsEntity.isCredentialsNonExpired());
			userDetails.setAuthorities(setAuthorities(userDetailsEntity.getAuthorities()));
			userDetails.setClient(toClientModel(userDetailsEntity.getClient()));
			userDetails.setEmail(userDetailsEntity.getEmail());
			userDetails.setEnabled(userDetailsEntity.isEnabled());
			userDetails.setFailedLoginAttempts(userDetailsEntity.getFailedLoginAttempts());
			userDetails.setPassword(userDetailsEntity.getPassword());
			userDetails.setResetPassword(userDetailsEntity.isResetPassword());
			userDetails.setLastSuccessfulLogin(userDetailsEntity.getLastSuccessfulLogin());
			userDetails.setLastSuccessfulLogout(userDetailsEntity.getLastSuccessfulLogout());
			userDetails.setSessionTimeOut(userDetailsEntity.getSessionTimeOut());
			userDetails.setRole(toRoleModel(userDetailsEntity.getRole()));
			userDetails.setPasswordExpiryDate(userDetailsEntity.getPasswordExpiryDate().toString());
			userDetails.setUpdatedBy(userDetailsEntity.getUpdatedBy());
			//userDetails.setCreationDate(userDetailsEntity.getCreationDate().toString());
			//userDetails.setModificationDate(userDetailsEntity.getModificationDate().toString());
		return userDetails;
	}
	private Set<String> setAuthorities(String authorities) {
		Set<String> authoritiesList = new HashSet<>();
		if(authorities.contains(","))
		{
			String[] services = authorities.split(",");
			authoritiesList.addAll(Arrays.asList(services));
		}
		else
			authoritiesList.add(authorities);
		return authoritiesList;
	}
	public RoleModel toRoleModel(RoleEntity roleEntity) {
		RoleModel role = new RoleModel();
			role.setRoleId(roleEntity.getRoleId());
			role.setRoleName(roleEntity.getRoleName());
			role.setDisplayName(roleEntity.getDisplayName());
			//role.setCreationDate(roleEntity.getCreationDate().toString());
			role.setModificationDate(roleEntity.getModificationDate().toString());
		return role;
	}

	public ClientModel toClientModel(ClientEntity clientEntity) {
		ClientModel client = new ClientModel();
			client.setClientId(clientEntity.getClientId());
			client.setClientName(clientEntity.getClientName());
			client.setAddress(clientEntity.getAddress());
			client.setSessionTimeOut(clientEntity.getSessionTimeOut());
			//client.setCreationDate(clientEntity.getCreationDate().toString());
			client.setModificationDate(clientEntity.getModificationDate().toString());
		return client;
	}

	public UserDetailsEntity toUserDetailsEntity(final UserDetailsModel userDetails) throws ServiceException
	{
		UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
			userDetailsEntity.setUserId(userDetails.getUserId());
			userDetailsEntity.setUsername(userDetails.getUsername());
			userDetailsEntity.setFirstName(userDetails.getFirstName());
			userDetailsEntity.setMiddleName(userDetails.getMiddleName());
			userDetailsEntity.setLastName(userDetails.getLastName());
			userDetailsEntity.setSuffix(userDetails.getSurName());
			userDetailsEntity.setAccountNonExpired(userDetails.isAccountNonExpired());
			userDetailsEntity.setAccountNonLocked(userDetails.isAccountNonLocked());
			userDetailsEntity.setCredentialsNonExpired(userDetails.isCredentialsNonExpired());
			userDetailsEntity.setAuthorities(toAuthoritiesEntity(userDetails.getAuthorities()));
			ClientEntity clientEntity =  clientManagerImpl.getClientById(userDetails.getClient().getClientId());
			if(null == clientEntity)
				throw new ServiceException("Invalid Client");
			userDetailsEntity.setClient(clientEntity);
			userDetailsEntity.setEmail(userDetails.getEmail());
			userDetailsEntity.setEnabled(userDetails.isEnabled());
			userDetailsEntity.setFailedLoginAttempts(userDetails.getFailedLoginAttempts());
			userDetailsEntity.setPassword(userDetails.getPassword());
			userDetailsEntity.setResetPassword(userDetails.isResetPassword());
			RoleEntity roleEntity = roleManagerImpl.getRoleById(userDetails.getRole().getRoleId());
			if(null == roleEntity)
				throw new ServiceException("Invalid Role");
			userDetailsEntity.setRole(roleEntity);
			userDetailsEntity.setPasswordExpiryDate(userDetails.getPasswordExpiryDate());
			userDetailsEntity.setUpdatedBy(userDetails.getUpdatedBy());
			userDetailsEntity.setPasswordExpiryDate(userDetails.getPasswordExpiryDate());
			userDetailsEntity.setLastSuccessfulLogin(userDetails.getLastSuccessfulLogin());
			userDetailsEntity.setLastSuccessfulLogout(userDetails.getLastSuccessfulLogout());
			userDetailsEntity.setModificationDate(Date.valueOf(LocalDate.now()));
			userDetailsEntity.setCreationDate((Date.valueOf(LocalDate.now())));
			userDetailsEntity.setSessionTimeOut(userDetails.getSessionTimeOut());
		return userDetailsEntity;
	}

	private String toAuthoritiesEntity(Set<GrantedAuthority> authoritiesList) {
		String separator = ",";
		int total = authoritiesList.size() * separator.length();
		
		for(GrantedAuthority authority: authoritiesList)
		    total += authority.toString().length();
		
		StringBuilder sb = new StringBuilder(total);

		for (GrantedAuthority s : authoritiesList)
		    sb.append(separator).append(s);
			
		return sb.substring(separator.length());
	}
	
	public RoleEntity toRoleEntity(RoleModel role) {
		RoleEntity roleEntity = new RoleEntity();
			roleEntity.setRoleId(role.getRoleId());
			roleEntity.setRoleName(role.getRoleName());
			roleEntity.setDisplayName(role.getDisplayName());
			
		return roleEntity;
	}

	public ClientEntity toClientEntity(ClientModel client) {
		ClientEntity clientEntity = new ClientEntity();
			clientEntity.setClientId(client.getClientId());
			clientEntity.setClientName(client.getClientName());
			clientEntity.setAddress(client.getAddress());
			clientEntity.setSessionTimeOut(client.getSessionTimeOut());
		return clientEntity;
	}
}