/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import javax.transaction.Transactional;

import com.actualize.mortgage.datamodels.ServicesEntity;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface ServiceManager {

	@Transactional
	public ServicesEntity  addService(ServicesEntity servicesEntity) throws ServiceException;
	@Transactional
	public ServicesEntity  updateService(ServicesEntity servicesEntity) throws ServiceException;
	@Transactional
	public ServicesEntity  getServiceByServiceId(String serviceId) throws ServiceException;
	@Transactional
	public ServicesEntity  getServiceByServiceName(String serviceName) throws ServiceException;
	@Transactional
	public List<ServicesEntity>  getAllSevices() throws ServiceException;
	@Transactional
	public void  deleteService(String serviceId) throws ServiceException;

}
