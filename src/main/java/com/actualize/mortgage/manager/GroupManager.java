/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.actualize.mortgage.datamodels.GroupEntity;


public interface GroupManager extends CrudRepository<GroupEntity,String>{

	@Modifying
	@Query("UPDATE GroupEntity g set g.enabled = ?2 WHERE g.groupId = ?1")
	public void activateOrDeActivateGroup(String groupId,Boolean enabled);

	@Modifying
	@Query("UPDATE GroupEntity g set g.enabled = ?2 WHERE g.groupId IN ?1")
	public void activateOrDeActivateGroups(List<String> groupIds,Boolean enabled);
	
	@Query("FROM GroupEntity g WHERE g.enabled = true and g.parentGroupId = ?1")
	public List<GroupEntity> getGroupByParentGroupId(String parentgroupId);

	@Query("FROM GroupEntity g WHERE g.enabled = true and g.groupName = ?1")
	public GroupEntity getGroupByName(String groupName);

	@Query("FROM GroupEntity g WHERE g.enabled = true and g.groupSequence = ?1")
	public GroupEntity getGroupBySequence(Long sequence);
	
	@Query("FROM GroupEntity g WHERE g.enabled = true and g.groupPath like ?1%")
	public List<GroupEntity> getGroupsByGroupPath(String groupPath);

	@Query("SELECT COUNT(g) FROM GroupEntity g WHERE g.groupName = ?1")
	public long isGroupNameAvailable(String groupname);	
	
	@Query("FROM GroupEntity g WHERE g.groupPath like ?1%")
	public List<GroupEntity> getChildGroups(String groupPath);

	@Query("FROM GroupEntity g WHERE g.enabled = true")
	public Iterable<GroupEntity> getAllActiveGroups();	
}
