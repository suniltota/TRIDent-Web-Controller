/**
 * 
 */
package com.actualize.mortgage.web.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.actualize.mortgage.datamodels.ClientContactInfoEntity;
import com.actualize.mortgage.datamodels.ClientEntity;
import com.actualize.mortgage.datamodels.GroupEntity;
import com.actualize.mortgage.datamodels.InvestorEntity;
import com.actualize.mortgage.datamodels.InvestorUserDetailsEntity;
import com.actualize.mortgage.datamodels.RoleEntity;
import com.actualize.mortgage.datamodels.ServicesEntity;
import com.actualize.mortgage.datamodels.UserActivityEntity;
import com.actualize.mortgage.datamodels.UserDetailsEntity;
import com.actualize.mortgage.domainmodels.ClientContactInfoModel;
import com.actualize.mortgage.domainmodels.ClientModel;
import com.actualize.mortgage.domainmodels.GroupModel;
import com.actualize.mortgage.domainmodels.InvestorModel;
import com.actualize.mortgage.domainmodels.InvestorUserDetailsModel;
import com.actualize.mortgage.domainmodels.RoleModel;
import com.actualize.mortgage.domainmodels.ServicesModel;
import com.actualize.mortgage.domainmodels.UserActivityModel;
import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.ClientManager;
import com.actualize.mortgage.manager.GroupManager;
import com.actualize.mortgage.manager.InvestorManager;
import com.actualize.mortgage.manager.InvestorUserDetailsManager;
import com.actualize.mortgage.manager.RoleManager;
import com.actualize.mortgage.manager.ServiceManager;
import com.actualize.mortgage.manager.UserManager;

/**
 * this class defines the conversion of domain models to data models and vice versa
 * @author sboragala
 *
 */
@Service
public class Convertor {

	@Autowired
	private RoleManager roleManager;

	@Autowired
	private ClientManager clientManager; 

	@Autowired
	private UserManager userManager;

	@Autowired
	private GroupManager groupManager;

	@Autowired
	private ServiceManager serviceManager;

	@Autowired
	private InvestorManager investorManager;
	
	@Autowired
	private InvestorUserDetailsManager investorUserDetailsManager;

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
		//userDetails.setAuthorities(setAuthorities(userDetailsEntity.getAuthorities()));
		userDetails.setGroup(toGroupModel(userDetailsEntity.getGroup()));
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
		userDetails.setCreationDate(toStringFromDate(userDetailsEntity.getCreationDate()));
		userDetails.setModificationDate(toStringFromDate(userDetailsEntity.getModificationDate()));
		if(!ObjectUtils.isEmpty(userDetailsEntity.getServices())){
			userDetails.setServices(toServiceModelList(userDetailsEntity.getServices()));
		}
		if(!ObjectUtils.isEmpty(userDetailsEntity.getClient())){
			userDetails.setClientId(userDetailsEntity.getClient().getClientId());
		}
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
		role.setCreationDate(toStringFromDate(roleEntity.getCreationDate()));
		role.setModificationDate(toStringFromDate(roleEntity.getModificationDate()));
		return role;
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
		//userDetailsEntity.setAuthorities(toAuthoritiesEntity(userDetails.getAuthorities()));
		if(null == userDetails.getGroup())
			throw new ServiceException("Please select a group!");
		GroupEntity groupEntity =  groupManager.findOne(userDetails.getGroup().getGroupId());

		userDetailsEntity.setGroup(groupEntity);
		userDetailsEntity.setEmail(userDetails.getEmail());
		userDetailsEntity.setEnabled(userDetails.isEnabled());
		userDetailsEntity.setFailedLoginAttempts(userDetails.getFailedLoginAttempts());
		userDetailsEntity.setPassword(userDetails.getPassword());
		userDetailsEntity.setResetPassword(userDetails.isResetPassword());
		RoleEntity roleEntity = roleManager.getRoleById(userDetails.getRole().getRoleId());
		if(null == roleEntity)
			throw new ServiceException("Invalid Role");
		userDetailsEntity.setRole(roleEntity);
		userDetailsEntity.setPasswordExpiryDate(userDetails.getPasswordExpiryDate());
		userDetailsEntity.setUpdatedBy(userDetails.getUpdatedBy());
		userDetailsEntity.setPasswordExpiryDate(userDetails.getPasswordExpiryDate());
		userDetailsEntity.setLastSuccessfulLogin(userDetails.getLastSuccessfulLogin());
		userDetailsEntity.setLastSuccessfulLogout(userDetails.getLastSuccessfulLogout());
		userDetailsEntity.setSessionTimeOut(userDetails.getSessionTimeOut());
		if(!ObjectUtils.isEmpty(userDetails.getServices())){
			userDetailsEntity.setServices(toServiceEntitySet(userDetails.getServices()));
		}
		if(!ObjectUtils.isEmpty(userDetails.getClientId())){
			userDetailsEntity.setClient(clientManager.getClientById(userDetails.getClientId()));
		}
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

	public ClientModel toClientModel(ClientEntity clientEntity) {
		ClientModel client = new ClientModel();
		client.setClientId(clientEntity.getClientId());
		client.setClientName(clientEntity.getClientName());
		client.setAddress(clientEntity.getAddress());
		client.setEnabled(clientEntity.isEnabled());
		client.setPhoneNumber(clientEntity.getPhoneNumber());
		client.setClientContactInfo(toClientContactInfoModel(clientEntity.getClientContactInfo()));
		client.setServicesModel(toServiceModelList(clientEntity.getServicesEntities()));
		//client.setInvestorUserDetailsModel(toInvestorUserDetailsModelList(clientEntity.getInvestorUserDetailsEntity()));
		client.setInvestorModels(toInvestorModelList(clientEntity.getInvestorEntities()));
		client.setCreationDate(toStringFromDate(clientEntity.getCreationDate()));
		client.setModificationDate(toStringFromDate(clientEntity.getModificationDate()));
		client.setWebSite(clientEntity.getWebSite());
		return client;
	}

	public ClientEntity toClientEntity(ClientModel client) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setClientId(client.getClientId());
		clientEntity.setClientName(client.getClientName());
		clientEntity.setEnabled(client.isEnabled());
		clientEntity.setPhoneNumber(client.getPhoneNumber());
		clientEntity.setPhoneNumber(client.getPhoneNumber());
		clientEntity.setClientContactInfo(toClientContactInfoEntity(client.getClientContactInfo()));
		clientEntity.setServicesEntities(toServiceEntitySet(client.getServicesModel()));
		//clientEntity.setInvestorUserDetailsEntity(toClientInvestorUserDetailsEntity(client.getInvestorUserDetailsModel()));
		clientEntity.setInvestorEntities(toInvestorEntityList(client.getInvestorModels()));
		clientEntity.setAddress(client.getAddress());
		clientEntity.setWebSite(client.getWebSite());
		return clientEntity;
	}

	public List<ClientContactInfoModel> toClientContactInfoModel(List<ClientContactInfoEntity> clientContactInfoEntityList){

		List<ClientContactInfoModel> clientContactInfoModels = new LinkedList<>();

		clientContactInfoEntityList.forEach(clientContactInfoEntity -> {

			ClientContactInfoModel clientContactInfoModel = new ClientContactInfoModel();
			clientContactInfoModel.setContactInfoId(clientContactInfoEntity.getContactInfoId());
			clientContactInfoModel.setContactType(clientContactInfoEntity.getContactType());
			clientContactInfoModel.setEmail(clientContactInfoEntity.getEmail());
			clientContactInfoModel.setName(clientContactInfoEntity.getName());
			clientContactInfoModel.setPhone(clientContactInfoEntity.getPhone());
			clientContactInfoModel.setCreationDate(toStringFromDate(clientContactInfoEntity.getCreationDate()));
			clientContactInfoModel.setModificationDate(toStringFromDate(clientContactInfoEntity.getModificationDate()));
			clientContactInfoModels.add(clientContactInfoModel);

		});
		return clientContactInfoModels;

	}

	public List<ClientContactInfoEntity> toClientContactInfoEntity(List<ClientContactInfoModel> clientContactInfoModelList){

		List<ClientContactInfoEntity> clientContactInfoEntityList = new LinkedList<>();

		if (!ObjectUtils.isEmpty(clientContactInfoModelList)) {
			clientContactInfoModelList.forEach(clientContactInfoModel -> {

				ClientContactInfoEntity clientContactInfoEntity = new ClientContactInfoEntity();
				clientContactInfoEntity.setContactInfoId(clientContactInfoModel.getContactInfoId());
				clientContactInfoEntity.setContactType(clientContactInfoModel.getContactType());
				clientContactInfoEntity.setEmail(clientContactInfoModel.getEmail());
				clientContactInfoEntity.setName(clientContactInfoModel.getName());
				clientContactInfoEntity.setPhone(clientContactInfoModel.getPhone());

				clientContactInfoEntityList.add(clientContactInfoEntity);
			});
		}
		return clientContactInfoEntityList;
	}

	public List<ServicesModel> toServiceModelList(Collection<ServicesEntity> servicesEntities)
	{
		List<ServicesModel> servicesModels = new LinkedList<>();
		if (!ObjectUtils.isEmpty(servicesEntities)) {
			servicesEntities.forEach(serviceEntity -> {
				servicesModels.add(toServiceModel(serviceEntity));
			});
		}
		return servicesModels;
	}

	public List<ServicesEntity> toServiceEntityList(List<ServicesModel> servicesModels)
	{
		List<ServicesEntity> servicesEntities = new LinkedList<>();
		if (!ObjectUtils.isEmpty(servicesEntities)) {
			servicesModels.forEach(servicesModel -> {
				servicesEntities.add(toServicesEntity(servicesModel));
			});
		}
		return servicesEntities;
	}

	public Set<ServicesEntity> toServiceEntitySet(Collection<ServicesModel> servicesModels)
	{
		Set<ServicesEntity> servicesEntities = new HashSet<ServicesEntity>();
		if(! ObjectUtils.isEmpty(servicesModels)){
			servicesModels.forEach(servicesModel -> {
				validate(servicesModel.getServiceId(), "Service Id");
				ServicesEntity servicesEntity = serviceManager.getServiceByServiceId(servicesModel.getServiceId());
				if(null == servicesEntity)
					new ServiceException("Invalid Service found");
				servicesEntities.add(servicesEntity);
			});
		}
		return servicesEntities;
	}

	public UserActivityEntity toUserActivityEntity(HttpServletRequest request, HttpServletResponse response, String loanId, String serviceName){
		UserActivityEntity userActivity = new UserActivityEntity();
		UserDetailsModel userDetails = (UserDetailsModel)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userActivity.setLoanId(loanId);
		userActivity.setRequestSize(request.getContentLengthLong());
		userActivity.setResponseStatus(Integer.toString(response.getStatus()));
		UserDetailsEntity userDetailsEntity = userManager.getUserById(userDetails.getUserId());
		if(null == userDetailsEntity)
			throw new ServiceException("Invalid User");
		userActivity.setUserDetails(userDetailsEntity);
		userActivity.setRequestStartTime(new SimpleDateFormat("MM/dd/YYYY HH:mm:ss.SSS").format(new Date().getTime()));
		userActivity.setServiceUtilized(serviceName);
		DataOutputStream data = null;
		try {
			data = new DataOutputStream(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		userActivity.setResponseSize(Long.valueOf(data.size()));

		return userActivity;
	}

	public UserActivityModel toUserActivityModel(UserActivityEntity userActivityEntity){
		UserActivityModel userActivityModel = new UserActivityModel();
		userActivityModel.setLoanId(userActivityEntity.getLoanId());
		userActivityModel.setRequestSize(userActivityEntity.getRequestSize());
		userActivityModel.setRequestStartTime(userActivityEntity.getRequestStartTime());
		userActivityModel.setResponseSize(userActivityEntity.getResponseSize());
		userActivityModel.setResponseStatus(userActivityEntity.getResponseStatus());
		userActivityModel.setServiceUtilized(userActivityEntity.getServiceUtilized());
		userActivityModel.setTimeLapsedForRequest(userActivityEntity.getTimeLapsedForRequest());
		userActivityModel.setUseractivityId(userActivityEntity.getUseractivityId());
		userActivityModel.setUserDetailsModel(toUserDetails(userActivityEntity.getUserDetails()));

		return userActivityModel;
	}

	public ServicesModel toServiceModel(ServicesEntity serviceEntity){
		ServicesModel servicesModel = new ServicesModel();
		servicesModel.setServiceId(serviceEntity.getServiceId());
		servicesModel.setServiceName(serviceEntity.getServiceName());
		servicesModel.setServiceDisplayName(serviceEntity.getServiceDisplayName());
		servicesModel.setServiceDescription(serviceEntity.getServiceDescription());
		servicesModel.setCreationDate(toStringFromDate(serviceEntity.getCreationDate()));
		servicesModel.setModificationDate(toStringFromDate(serviceEntity.getModificationDate()));
		return servicesModel;
	}

	public ServicesEntity toServicesEntity(ServicesModel servicesModel)
	{
		ServicesEntity servicesEntity = new ServicesEntity();
		servicesEntity.setServiceId(servicesModel.getServiceId());
		servicesEntity.setServiceName(servicesModel.getServiceName());
		servicesEntity.setServiceDisplayName(servicesModel.getServiceDisplayName());
		servicesEntity.setServiceDescription(servicesModel.getServiceDescription());
		return servicesEntity;
	}

	public GroupEntity toGroupEntity(GroupModel groupModel) {
		GroupEntity groupEntity = null;

		if(ObjectUtils.isEmpty(groupModel.getGroupId())){
			groupEntity = new GroupEntity();
			groupEntity.setCreatedBy(groupModel.getCreatedBy());

		}else{
			groupEntity = groupManager.findOne(groupModel.getGroupId());
			groupEntity.setUpdatedBy(groupModel.getUpdatedBy());
			
			/*groupEntity.setGroupPath(groupModel.getGroupPath());
			if(groupModel.getGroupSequence() != null){
				groupEntity.setGroupSequence(Long.parseLong(groupModel.getGroupSequence()));
			}*/
		}
		if(!ObjectUtils.isEmpty(groupModel.getGroupParentId())){
			groupEntity.setGroupId(groupModel.getGroupId());
			GroupEntity parentGroup = groupManager.findOne(groupModel.getGroupParentId());
			if(!ObjectUtils.isEmpty(parentGroup.getGroupPath())){
				groupEntity.setGroupPath(parentGroup.getGroupPath()+"|"+parentGroup.getGroupSequence());
			}else{
				groupEntity.setGroupPath(parentGroup.getGroupSequence()+"");
			}
		}
		groupEntity.setGroupName(groupModel.getGroupName());
		groupEntity.setParentGroupId(groupModel.getGroupParentId());
		groupEntity.setClientid(groupModel.getClientId());
		groupEntity.setEnabled(groupModel.isEnabled());
		groupEntity.setServices(toServiceEntitySet(groupModel.getServices()));
		groupEntity.setPasswordExpireDays(groupModel.getPasswordExpireDays());
		groupEntity.setSessionTimeOut(groupModel.getSessionTimeOut());
		return groupEntity;
	}
	public GroupModel toGroupModel(GroupEntity groupEntity) {
		GroupModel groupModel = new GroupModel();
		groupModel.setGroupId(groupEntity.getGroupId());
		groupModel.setGroupName(groupEntity.getGroupName());
		groupModel.setGroupPath(groupEntity.getGroupPath());
		groupModel.setGroupSequence(groupEntity.getGroupSequence());
		groupModel.setGroupParentId(groupEntity.getParentGroupId());
		if(!ObjectUtils.isEmpty(groupEntity.getParentGroupId())){
			GroupEntity parentGroup = groupManager.findOne(groupEntity.getParentGroupId());
			groupModel.setParentGroupName(parentGroup.getGroupName());
		}
		groupModel.setUpdatedBy(groupEntity.getUpdatedBy());
		groupModel.setEnabled(groupEntity.isEnabled());
		groupModel.setServices(toServiceModelList(groupEntity.getServices()));
		if(! ObjectUtils.isEmpty(groupEntity.getServices())){
			//	groupModel.setServiceDisplayNames(groupModel.getServices().stream().reduce());
		}
		groupModel.setPasswordExpireDays(groupEntity.getPasswordExpireDays());
		groupModel.setSessionTimeOut(groupEntity.getSessionTimeOut());
		return groupModel;
	}

	public InvestorModel toInvestorModel(InvestorEntity investorEntity)
	{
		InvestorModel investorModel = new InvestorModel();
		investorModel.setInvestorId(investorEntity.getInvestorId());
		investorModel.setInvestorName(investorEntity.getInvestorName());
		investorModel.setInvestorUrl(investorEntity.getInvestorUrl());
		investorModel.setCreationDate(toStringFromDate(investorEntity.getCreationDate()));
		investorModel.setModificationDate(toStringFromDate(investorEntity.getModificationDate()));
		return investorModel;
	}
	
	public Set<InvestorModel> toInvestorModelList(Collection<InvestorEntity> investorEntityList)
	{
		Set<InvestorModel> investorModels = new HashSet<>();
		if(null == investorEntityList)
			throw new ServiceException("list of investors are missing");
		for(InvestorEntity investorEntity : investorEntityList){
			InvestorModel investorModel = new InvestorModel();
			investorModel.setInvestorId(investorEntity.getInvestorId());
			investorModel.setInvestorName(investorEntity.getInvestorName());
			investorModel.setInvestorUrl(investorEntity.getInvestorUrl());
			investorModel.setCreationDate(toStringFromDate(investorEntity.getCreationDate()));
			investorModel.setModificationDate(toStringFromDate(investorEntity.getModificationDate()));
			investorModels.add(investorModel);
		}
			
		return investorModels;
	}

	public InvestorEntity toInvestorEntity(InvestorModel investorModel)
	{
		InvestorEntity investorEntity = new InvestorEntity();
		investorEntity.setInvestorId(investorModel.getInvestorId());
		investorEntity.setInvestorName(investorModel.getInvestorName());
		investorEntity.setInvestorUrl(investorModel.getInvestorUrl());
		return investorEntity;
	}
	
	public Set<InvestorEntity> toInvestorEntityList(Set<InvestorModel> investorModelList)
	{
		Set<InvestorEntity> investorEntities = new HashSet<>();
		if(null == investorModelList)
			throw new ServiceException("list of investors are missing");
		for(InvestorModel investorModel : investorModelList){
			validate(investorModel.getInvestorId(), "Investor Id");
			investorEntities.add(investorManager.getInvestorByInvestorId(investorModel.getInvestorId()));
		}
			
		return investorEntities;
	}

	public InvestorUserDetailsEntity toInvestorUserDetailsEntity(InvestorUserDetailsModel investorUserDetailsModel)
	{
		InvestorUserDetailsEntity investorUserDetailsEntity = new InvestorUserDetailsEntity();
		investorUserDetailsEntity.setInvestorUserId(investorUserDetailsModel.getInvestorUserId());
		investorUserDetailsEntity.setLoanDeliveryFile(investorUserDetailsModel.getLoanDeliveryFile());
		investorUserDetailsEntity.setUsername(investorUserDetailsModel.getUsername());
		investorUserDetailsEntity.setPassword(investorUserDetailsModel.getPassword());
		validate(investorUserDetailsModel.getInvestorModel().getInvestorId(), "Investor Id");
		InvestorEntity investorEntity =  investorManager.getInvestorByInvestorId(investorUserDetailsModel.getInvestorModel().getInvestorId());
		if(null == investorEntity)
			throw new ServiceException("Invalid Investor");
		investorUserDetailsEntity.setInvestorEntity(investorEntity);

		return investorUserDetailsEntity;

	}
	
	public List<InvestorUserDetailsEntity> toClientInvestorUserDetailsEntity(List<InvestorUserDetailsModel> investorUserDetailsModelList)
	{
		List<InvestorUserDetailsEntity> investorUserDetailsEntities = new LinkedList<>();
		
		investorUserDetailsModelList.forEach(investorUserDetailsModel -> {
			investorUserDetailsEntities.add(toInvestorUserDetailsEntity(investorUserDetailsModel));
		});
		return investorUserDetailsEntities;

	}


	public InvestorUserDetailsModel toInvestorUserDetailsModel(InvestorUserDetailsEntity investorUserDetailsEntity)
	{
		InvestorUserDetailsModel investorUserDetailsModel = new InvestorUserDetailsModel();

		investorUserDetailsModel.setInvestorUserId(investorUserDetailsEntity.getInvestorUserId());
		investorUserDetailsModel.setLoanDeliveryFile(investorUserDetailsEntity.getLoanDeliveryFile());
		investorUserDetailsModel.setUsername(investorUserDetailsEntity.getUsername());
		investorUserDetailsModel.setPassword(investorUserDetailsEntity.getPassword());
		investorUserDetailsModel.setInvestorModel(toInvestorModel(investorUserDetailsEntity.getInvestorEntity()));
		investorUserDetailsModel.setCreationDate(toStringFromDate(investorUserDetailsEntity.getCreationDate()));
		investorUserDetailsModel.setModificationDate(toStringFromDate(investorUserDetailsEntity.getModificationDate()));

		return investorUserDetailsModel;

	}
	
	public List<InvestorUserDetailsModel> toInvestorUserDetailsModelList(List<InvestorUserDetailsEntity> investorUserDetailsEntityList)
	{
		List<InvestorUserDetailsModel> investorUserDetailsModels = new LinkedList<>();
		investorUserDetailsEntityList.forEach(investorUserDetailsEntity -> {
			investorUserDetailsModels.add(toInvestorUserDetailsModel(investorUserDetailsEntity));
		});
		return investorUserDetailsModels;

	}
	
	private String toStringFromDate(Timestamp timeStamp)
	{
		if(null != timeStamp )
			return new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(timeStamp.getTime());
		else
			return "";
	}

	private void validate(String validate, String message)
	{
		if(ObjectUtils.isEmpty(validate))
			throw new ServiceException(message+" cannot be empty");
	}
}
