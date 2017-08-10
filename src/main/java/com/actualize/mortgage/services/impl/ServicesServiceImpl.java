/**
 * 
 */
package com.actualize.mortgage.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.datamodels.ServicesEntity;
import com.actualize.mortgage.domainmodels.ServicesModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.ServiceManager;
import com.actualize.mortgage.services.ServicesService;
import com.actualize.mortgage.web.utils.Convertor;

/**
 * @author sboragala
 *
 */
@Service
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	ServiceManager serviceManagerImpl;

	@Autowired
	Convertor convertor;

	@Override
	public ServicesModel addService(ServicesModel servicesModel) throws ServiceException {
		serviceManagerImpl.addService(convertor.toServicesEntity(servicesModel));
		return servicesModel;
	}

	@Override
	public ServicesModel updateService(ServicesModel servicesModel) throws ServiceException {
		serviceManagerImpl.updateService(convertor.toServicesEntity(servicesModel));
		return servicesModel;
	}

	@Override
	public ServicesModel getServiceByServiceId(String serviceId) throws ServiceException {
		ServicesEntity servicesEntity = serviceManagerImpl.getServiceByServiceId(serviceId);
		if(null == servicesEntity)
			throw new ServiceException("Invalid service Id");
		return convertor.toServiceModel(servicesEntity);
	}

	@Override
	public ServicesModel getServiceByServiceName(String serviceName) throws ServiceException {
		if(null == serviceName || serviceName.isEmpty() || serviceName.trim().contains(" "))
			throw new ServiceException("Invalid Service Name");
		ServicesEntity servicesEntity = serviceManagerImpl.getServiceByServiceId(serviceName);
		if(null == servicesEntity)
			throw new ServiceException("No results found with service Name: "+ serviceName);
		return convertor.toServiceModel(servicesEntity);
	}

	@Override
	public List<ServicesModel> getAllSevices() throws ServiceException {
		List<ServicesEntity> servicesEntities = serviceManagerImpl.getAllSevices();
		List<ServicesModel> servicesModels = new LinkedList<>();
		for(ServicesEntity servicesEntity: servicesEntities)
			servicesModels.add(convertor.toServiceModel(servicesEntity));
		return servicesModels;
	}

	@Override
	public void deleteService(String serviceId) throws ServiceException {
		serviceManagerImpl.deleteService(serviceId);
	}

}
