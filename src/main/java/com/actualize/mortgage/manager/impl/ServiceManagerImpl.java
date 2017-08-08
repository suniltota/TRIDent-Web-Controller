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

import com.actualize.mortgage.datamodels.ServicesEntity;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.ServiceManager;

/**
 * @author sboragala
 *
 */
@Repository
@Transactional
public class ServiceManagerImpl implements ServiceManager{

	@PersistenceContext
	EntityManager entityManager;


	@Override
	public ServicesEntity addService(ServicesEntity servicesEntity) {
		entityManager.persist(servicesEntity);
		return servicesEntity;
	}

	@Override
	public ServicesEntity getServiceByServiceId(String serviceId) {
		return entityManager.find(ServicesEntity.class, serviceId);
	}

	@Override
	public ServicesEntity getServiceByServiceName(String serviceName) {
		try{
			return (ServicesEntity) entityManager.createQuery(
					"from ServicesEntity where serviceName = :serviceName")
					.setParameter("serviceName", serviceName)
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicesEntity> getAllSevices() {
		try{
			return (List<ServicesEntity>) entityManager.createQuery("from ServicesEntity").getResultList();
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

	@Override
	public void deleteService(String serviceId) {
		entityManager.remove(serviceId);
	}

	@Override
	public ServicesEntity updateService(ServicesEntity servicesEntity) {
		entityManager.merge(servicesEntity);
		return servicesEntity;
	}


}
