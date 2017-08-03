/**
 * 
 */
package com.actualize.mortgage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.actualize.mortgage.domainmodels.RoleModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.RoleService;

/**
 * @author sboragala
 *
 */
@RestController
@RequestMapping(value = "/actualize/transformx/")
public class RoleApiImpl {
	
	@Autowired
	private RoleService roleServiceImpl;
	
	@RequestMapping(value = "/{version}/getRoleById", method = { RequestMethod.GET })
	public RoleModel addUser(@PathVariable String version, @RequestParam String roleId) throws ServiceException{
		return roleServiceImpl.getRoleDetailsById(roleId);
	}

}
