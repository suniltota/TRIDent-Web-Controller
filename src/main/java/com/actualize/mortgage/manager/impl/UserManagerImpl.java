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

import com.actualize.mortgage.datamodels.UserDetailsEntity;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.UserManager;

/**
 * @author sboragala
 *
 */
@Repository
@Transactional
public class UserManagerImpl implements UserManager{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public UserDetailsEntity getUserById(String userId) throws ServiceException  {
		try{
			return (UserDetailsEntity) entityManager.find(UserDetailsEntity.class, userId);
		}catch(NoResultException e){
	    	throw new ServiceException("No results found with userId: "+ userId);
	    }
	}

	@Override
	public UserDetailsEntity getUserByUserName(String userName) throws ServiceException {
		try{
		 return (UserDetailsEntity) entityManager.createQuery(
			        "from UserDetailsEntity where username = :userName")
			        .setParameter("userName", userName)
			        .getSingleResult();
		}
		catch(NoResultException e){
			return null;
	    }catch(NonUniqueResultException e){
	    	throw new ServiceException("More than one record found with userName: "+ userName);
	    }
	}
	
	@Override
	public UserDetailsEntity getUserByEmail(String email) throws ServiceException {
		
		try{
			return (UserDetailsEntity) entityManager.createQuery(
			        "from UserDetailsEntity where email = :email")
			        .setParameter("email", email)
			        .getSingleResult();
		    }catch(NoResultException e){
		    	return null;
		    }catch(NonUniqueResultException e){
		    	throw new ServiceException("More than one record found with email: "+ email);
		    }
		
	}
	
	@Override
	public UserDetailsEntity addUser(UserDetailsEntity userDetailsEntity) {
		entityManager.persist(userDetailsEntity);
		return userDetailsEntity;
	}

	@Override
	public UserDetailsEntity updateUser(UserDetailsEntity userDetailsEntity) {
		return entityManager.merge(userDetailsEntity);
	}

	@Override
	public void deleteUser(String userId) {
		entityManager.remove(entityManager.find(UserDetailsEntity.class, userId));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetailsEntity> getAllUsersbyClientId(String clientId) throws ServiceException {
	 try{
		 return entityManager.createQuery("from UserDetailsEntity u where u.client.clientId=:clientId")
				 	.setParameter("clientId", clientId).getResultList();
	    }catch(NoResultException e){
	    	throw new ServiceException("No results found with client Id: "+ clientId);
	    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetailsEntity> getAllUsers() throws ServiceException {
		 try{
			 return (List<UserDetailsEntity>) entityManager.createQuery("from UserDetailsEntity where enabled = true").getResultList();
		    }catch(NoResultException e){
		    	throw new ServiceException("No results found");
		    }
	}

	
}
