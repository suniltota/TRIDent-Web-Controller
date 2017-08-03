/**
 * 
 */
package com.actualize.mortgage.services;

import java.util.List;

import com.actualize.mortgage.domainmodels.RoleModel;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface RoleService {
	
	public RoleModel addRole(RoleModel roleModel) throws ServiceException;
	
	public RoleModel getRoleDetailsById(String roleId) throws ServiceException;
	
	public RoleModel getRoleDetailsByRoleName(String roleName) throws ServiceException;
	
	public List<RoleModel> getAllRoles() throws ServiceException;
	
	public void deleteRole(String roleId) throws ServiceException;
}
