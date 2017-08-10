/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import com.actualize.mortgage.datamodels.ServicesEntity;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface ServiceManager {

	public ServicesEntity  addService(ServicesEntity servicesEntity) throws ServiceException;
	public ServicesEntity  updateService(ServicesEntity servicesEntity) throws ServiceException;
	public ServicesEntity  getServiceByServiceId(String serviceId) throws ServiceException;
	public ServicesEntity  getServiceByServiceName(String serviceName) throws ServiceException;
	public List<ServicesEntity>  getAllSevices() throws ServiceException;
	public void  deleteService(String serviceId) throws ServiceException;

}
