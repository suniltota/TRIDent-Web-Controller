package com.actualize.mortgage.services;

import java.util.List;

import com.actualize.mortgage.domainmodels.GroupModel;
import com.actualize.mortgage.exceptions.ServiceException;

public interface GroupService {

	public GroupModel createorUpdateGroup(GroupModel groupModel) throws ServiceException;

	public GroupModel getGroupById(String groupId) throws ServiceException;

	public GroupModel getGroupByName(String groupName) throws ServiceException;

	public List<GroupModel> getAllGroups() throws ServiceException;

	public List<GroupModel> getGroupByParentGroupId(String parentgroupId) throws ServiceException;

	public GroupModel getGroupBySequence(Long sequence) throws ServiceException;

	public void activateOrDeActivateGroups(List<String> groupIds, Boolean enabled) throws ServiceException;

	public void activateOrDeActivateGroup(String groupId, Boolean enabled) throws ServiceException;

	public List<GroupModel> getGroupsByGroupPath(String groupPath) throws ServiceException;

	public Boolean isGroupNameAvailable(String groupname) throws ServiceException;
	
	public List<GroupModel> getChildGroups(long groupSequence,String groupPath) throws ServiceException;	
	
}
