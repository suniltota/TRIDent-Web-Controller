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

import com.actualize.mortgage.datamodels.ClientEntity;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.ClientManager;

/**
 * @author sboragala
 *
 */
@Repository
@Transactional
public class ClientManagerImpl implements ClientManager {
	
	@PersistenceContext
	private EntityManager entityManager;

	public ClientEntity getClientById(String clientId) {
		return (ClientEntity) entityManager.find(ClientEntity.class, clientId);
	}
	
	@Override
	public ClientEntity getClientByClientName(String clientName) throws ServiceException {
		try{
			return (ClientEntity) entityManager.createQuery(
			        "from ClientEntity where clientname = :clientName")
			        .setParameter("clientName", clientName)
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

	public ClientEntity addClient(ClientEntity clientEntity) {
		entityManager.persist(clientEntity);
		return clientEntity;
	}

	public ClientEntity updateClient(ClientEntity clientEntity) {
		return entityManager.merge(clientEntity);
	}

	public void deleteClient(String clientId) {
		entityManager.remove(clientId);
	}

	public List<ClientEntity> getAllClients() {
		try{
			return (List<ClientEntity>) entityManager.createQuery(
			        "from ClientEntity").getResultList();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

}
