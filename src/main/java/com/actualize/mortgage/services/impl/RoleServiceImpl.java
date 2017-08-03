/**
 * 
 */
package com.actualize.mortgage.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.datamodels.RoleEntity;
import com.actualize.mortgage.domainmodels.RoleModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.RoleManager;
import com.actualize.mortgage.services.RoleService;
import com.actualize.mortgage.web.utils.Convertor;

/**
 * @author sboragala
 *
 */
@Service
public class RoleServiceImpl  implements RoleService{
	
	@Autowired
	RoleManager roleManagerImpl;
		
	@Autowired
	Convertor convertor;

	@Override
	public RoleModel getRoleDetailsById(String roleId) throws ServiceException {
		RoleEntity roleEntity = roleManagerImpl.getRoleById(roleId);
		if(null == roleEntity)
			throw new ServiceException("Invalid role id");
		return convertor.toRoleModel(roleEntity);
	}

	@Override
	public RoleModel getRoleDetailsByRoleName(String roleName) throws ServiceException {
		RoleEntity roleEntity = roleManagerImpl.getRoleByRoleName(roleName);
		if(null == roleEntity)
			throw new ServiceException("Invalid role name");
		return convertor.toRoleModel(roleEntity);
	}

	@Override
	public List<RoleModel> getAllRoles() throws ServiceException {
		List<RoleEntity> roleEntityList = roleManagerImpl.getAllRoles();
		List<RoleModel> roleModelList = new LinkedList<>();
		if(null == roleEntityList)
			throw new ServiceException("No entries found");
		for(RoleEntity roleEntity: roleEntityList)
			roleModelList.add(convertor.toRoleModel(roleEntity));
		return roleModelList;
	}

	@Override
	public RoleModel addRole(RoleModel roleModel) throws ServiceException {
		
		return convertor.toRoleModel(convertor.toRoleEntity(roleModel));
	}

	@Override
	public void deleteRole(String roleId) throws ServiceException {
		roleManagerImpl.deleteRole(roleId);
	}

}
