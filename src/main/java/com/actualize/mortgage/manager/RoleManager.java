/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import com.actualize.mortgage.datamodels.RoleEntity;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface RoleManager {
	
	public RoleEntity addRole(RoleEntity roleEntity);
	
	public RoleEntity getRoleById(String roleId);
	
	public RoleEntity getRoleByRoleName(String roleName) throws ServiceException;
	
	public List<RoleEntity> getAllRoles() throws ServiceException;
	
	public void deleteRole(String roleId);

}
