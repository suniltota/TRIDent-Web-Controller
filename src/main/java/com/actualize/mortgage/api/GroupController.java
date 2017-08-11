package com.actualize.mortgage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.GroupModel;
import com.actualize.mortgage.domainmodels.UserDetailsModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.GroupService;

@RestController
@RequestMapping(value = "/actualize/transformx/")
public class GroupController {

	@Autowired
	private GroupService groupService;

	@RequestMapping(value={"/groups"}, method = RequestMethod.POST)
	public ResponseEntity<String> createGroup(@RequestBody GroupModel groupModel) throws ServiceException {
		 groupService.createorUpdateGroup(groupModel);
		 return new ResponseEntity<String>("Group created Successfully", HttpStatus.OK);
	}

	@RequestMapping(value={"/groups"}, method = RequestMethod.PUT)
	public ResponseEntity<String> updateGroup(@RequestBody GroupModel groupModel) throws ServiceException {
		 groupService.createorUpdateGroup(groupModel);
		 return new ResponseEntity<String>("Group updated Successfully", HttpStatus.OK);
	}

	@RequestMapping(value={"/groups/{id}"}, method = RequestMethod.GET)
	public GroupModel getGroupByid(@PathVariable("id") String groupId) throws ServiceException {
		 return groupService.getGroupById(groupId);
	}

	@RequestMapping(value={"/groups"}, method = RequestMethod.GET)
	public List<GroupModel> getAllGroups() throws ServiceException {
		
		/*UserDetailsModel userDetailsModel = (UserDetailsModel) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (userDetailsModel != null && userDetailsModel.getGroup() != null) {
			return groupService.getChildGroups(userDetailsModel.getGroup().getGroupSequence(),
					 userDetailsModel.getGroup().getGroupPath());
		}*/
		 return groupService.getAllGroups();
	}

	@RequestMapping(value={"/groups/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<String> deactivateGroup(@PathVariable("id") String groupId) throws ServiceException {
		 groupService.activateOrDeActivateGroup(groupId, false);
		 return new ResponseEntity<String>("Group deactivated Successfully", HttpStatus.OK);
	}

	@RequestMapping(value={"/groups/"}, method = RequestMethod.DELETE)
	public ResponseEntity<String> deactivateGroups(@RequestBody List<String> groupIds) throws ServiceException {
		 groupService.activateOrDeActivateGroups(groupIds, false);
		 return new ResponseEntity<String>("Groups deactivated Successfully", HttpStatus.OK);
	}

	@RequestMapping(value={"/groups/activate/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<String> activateGroup(@PathVariable("id") String groupId) throws ServiceException {
		 groupService.activateOrDeActivateGroup(groupId, true);
		 return new ResponseEntity<String>("Group deactivated Successfully", HttpStatus.OK);
	}

	@RequestMapping(value={"/groups/activate/"}, method = RequestMethod.DELETE)
	public ResponseEntity<String> activateGroups(@RequestBody List<String> groupIds) throws ServiceException {
		 groupService.activateOrDeActivateGroups(groupIds, true);
		 return new ResponseEntity<String>("Groups activated Successfully", HttpStatus.OK);
	}

	@RequestMapping(value={"/groups/getGroupSubGroups/{groupPath}"}, method = RequestMethod.GET)
	public List<GroupModel> getGroupSubGroups(@PathVariable("groupPath") String groupPath) throws ServiceException {
		return groupService.getGroupsByGroupPath(groupPath);
	}
	
	@RequestMapping(value={"/group/isGroupNameAvailable/{groupname}"}, method = RequestMethod.GET)
	public boolean isGroupNameAvailable(@PathVariable("groupname") String groupname) throws ServiceException {
		groupService.isGroupNameAvailable(groupname);
		return true;
	}

}
