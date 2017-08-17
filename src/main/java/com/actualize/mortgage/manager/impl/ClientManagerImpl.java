/**
 * 
 */
package com.actualize.mortgage.manager.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		try {
			return (ClientEntity) entityManager.createQuery("from ClientEntity where clientname = :clientName")
					.setParameter("clientName", clientName).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			throw new ServiceException("More than one Result found");
		}
	}

	@Override
	public ClientEntity addClient(ClientEntity clientEntity) {
		entityManager.merge(clientEntity);
		return clientEntity;
	}

	@Override
	public ClientEntity updateClient(ClientEntity clientEntity) {
		return entityManager.merge(clientEntity);
	}

	@Override
	public void activeOrDeactiveClient(String clientId, Boolean enabled) {
		Query query = entityManager.createQuery("UPDATE ClientEntity c set c.enabled = :enabled WHERE c.clientId= :clientId");
		query.setParameter("enabled", enabled);
		query.setParameter("clientId", clientId);
		query.executeUpdate();
	}

	@Override
	public void activeOrDeactiveClientsGroups(String clientId, Boolean enabled) {
		Query query = entityManager.createQuery("UPDATE GroupEntity g set g.enabled = :enabled WHERE g.clientid= :clientId");
		query.setParameter("enabled", enabled);
		query.setParameter("clientId", clientId);
		query.executeUpdate();
	}

	@Override
	public void activeOrDeactiveClientsUsers(String clientId, Boolean enabled) {
		Query query = entityManager.createQuery("UPDATE UserDetailsEntity u set u.enabled = :enabled "
				+ "WHERE u.client.clientId= :clientId)");
		query.setParameter("enabled", enabled);
		query.setParameter("clientId", clientId);
		query.executeUpdate();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientEntity> getAllActiveClients() {
		try {
			return (List<ClientEntity>) entityManager.createQuery("from ClientEntity c where c.enabled =  true")
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<ClientEntity> getAllClients() {
		try {
			return (List<ClientEntity>) entityManager.createQuery("from ClientEntity c")
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public long isClientNameAvailable(String clientname) {
		try {
			return (long) entityManager.createQuery("Select count(c) from ClientEntity c where c.clientName =  :clientname")
					.setParameter("clientname", clientname).getFirstResult();
		} catch (NoResultException e) {
			return 1;
		}
	}

}
