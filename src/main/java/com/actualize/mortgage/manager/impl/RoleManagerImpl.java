/**
 * 
 */
package com.actualize.mortgage.manager.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.actualize.mortgage.datamodels.RoleEntity;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.RoleManager;

/**
 * @author sboragala
 *
 */
@Repository
@Transactional
public class RoleManagerImpl implements RoleManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public RoleEntity getRoleById(String roleId) {
		try{
			return (RoleEntity) entityManager.find(RoleEntity.class, roleId);
		}
		catch(NoResultException e)
		{
			return null;
		}
		
	}

	@Override
	public RoleEntity getRoleByRoleName(String roleName) throws ServiceException {
		try{
			 return (RoleEntity) entityManager.createQuery(
				        "from RoleEntity where roleName = :roleName")
				        .setParameter("roleName", roleName)
				        .getSingleResult();
		}
		catch(NoResultException e)
		{
			return null;
		}
		catch(NonUniqueResultException e)
		{
			throw new ServiceException("More than one Result found");
		}
	}

	@Override
	public List<RoleEntity> getAllRoles() throws ServiceException {
		try{
			return (List<RoleEntity>) entityManager.createQuery("from RoleEntity").getResultList();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

	@Override
	public RoleEntity addRole(RoleEntity roleEntity) {
		entityManager.persist(roleEntity);
		return roleEntity; 
	}

	@Override
	public void deleteRole(String roleId) {
		entityManager.remove(roleId);
	}

}
