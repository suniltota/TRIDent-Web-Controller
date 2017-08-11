package com.actualize.mortgage.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.actualize.mortgage.datamodels.GroupEntity;
import com.actualize.mortgage.domainmodels.GroupModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.GroupManager;
import com.actualize.mortgage.services.GroupService;
import com.actualize.mortgage.web.utils.Convertor;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupManager groupManager;

	@Autowired
	private Convertor convertor;

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public GroupModel createorUpdateGroup(GroupModel groupModel) throws ServiceException {
		GroupEntity groupEntity = groupManager.save(convertor.toGroupEntity(groupModel));
		return convertor.toGroupModel(groupEntity);
	}

	@Override
	public GroupModel getGroupById(String groupId) throws ServiceException {
		return convertor.toGroupModel(groupManager.findOne(groupId));
	}

	@Override
	public GroupModel getGroupByName(String groupName) throws ServiceException {
		return convertor.toGroupModel(groupManager.getGroupByName(groupName));
	}

	@Override
	public GroupModel getGroupBySequence(Long sequence) throws ServiceException {
		return convertor.toGroupModel(groupManager.getGroupBySequence(sequence));
	}

	@Override
	public List<GroupModel> getAllGroups() throws ServiceException {
		List<GroupModel> groupModels = new ArrayList<>();
		Iterable<GroupEntity> groups = groupManager.findAll();
		if (groups != null) {
			groups.forEach(group -> groupModels.add(convertor.toGroupModel(group)));
		}
		return groupModels;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void activateOrDeActivateGroups(List<String> groupIds, Boolean enabled) throws ServiceException {
		if (!ObjectUtils.isEmpty(groupIds)) {
			groupManager.activateOrDeActivateGroups(groupIds, enabled);
		} else {
			throw new ServiceException("Group Id is mandatory to enable/disable a group!");
		}
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void activateOrDeActivateGroup(String groupId, Boolean enabled) throws ServiceException {
		if (!ObjectUtils.isEmpty(groupId)){
			groupManager.activateOrDeActivateGroup(groupId, enabled);
		} else {
			throw new ServiceException("Group Id is mandatory to enable/disable a group!");
		}
	}

	@Override
	public List<GroupModel> getGroupByParentGroupId(String parentgroupId) throws ServiceException {
		List<GroupModel> groupModels = new ArrayList<>();
		List<GroupEntity> groups = groupManager.getGroupByParentGroupId(parentgroupId);
		if (groups != null) {
			groups.forEach(group -> groupModels.add(convertor.toGroupModel(group)));
		}
		return groupModels;
	}

	@Override
	public List<GroupModel> getGroupsByGroupPath(String groupPath) throws ServiceException {
		List<GroupModel> groupModels = new ArrayList<>();
		List<GroupEntity> groups = groupManager.getGroupsByGroupPath(groupPath);
		if (groups != null) {
			groups.forEach(group -> groupModels.add(convertor.toGroupModel(group)));
		}
		return groupModels;
	}

	@Override
	public Boolean isGroupNameAvailable(String groupname) throws ServiceException{
		return groupManager.isGroupNameAvailable(groupname) > 0 ? false : true;
	}

	@Override
	public List<GroupModel> getChildGroups(long groupSequence, String groupPath)
			throws ServiceException {
			if(groupPath == null){
				groupPath = groupSequence+ "" ;
			}
		List<GroupModel> groupModels = new ArrayList<>();
		List<GroupEntity> groups = groupManager.getChildGroups(groupSequence, groupPath);
		if (groups != null) {
			groups.forEach(group -> groupModels.add(convertor.toGroupModel(group)));
		}
		return groupModels;
	}
}
