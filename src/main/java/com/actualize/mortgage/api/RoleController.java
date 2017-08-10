package com.actualize.mortgage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.ClientModel;
import com.actualize.mortgage.domainmodels.RoleModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.RoleService;

@RestController
@RequestMapping(value = "/actualize/transformx/")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value={"/roles"}, method = RequestMethod.GET)
	public List<RoleModel> getRoles() throws ServiceException {
		return roleService.getAllRoles();
	}
	
	@RequestMapping(value={"/roles/{id}"}, method = RequestMethod.GET)
	public RoleModel getRoleById(@PathVariable("id") String roleId) throws ServiceException {
		return roleService.getRoleDetailsById(roleId);
	}
	
	@RequestMapping(value={"/roles"}, method = RequestMethod.POST)
	public RoleModel createRole(@RequestBody RoleModel roleModel) throws ServiceException {
		return null;//roleService.
	}
		
	@RequestMapping(value={"/roles/{id}"}, method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") String roleId) throws ServiceException {
		//roleService.
	}
	
	@RequestMapping(value={"/roles"}, method = RequestMethod.PUT)
	public void updateRole(@RequestBody ClientModel clientModel) throws ServiceException {
		//roleService.updateRole(clientModel);
	}
}
