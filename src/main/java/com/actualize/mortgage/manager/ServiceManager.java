/**
 * 
 */
package com.actualize.mortgage.manager;

import com.actualize.mortgage.datamodels.ServicesEntity;

/**
 * @author sboragala
 *
 */
public interface ServiceManager {
	
	public ServicesEntity  addService(ServicesEntity servicesEntity);
	public ServicesEntity  getServiceByServiceId(String serviceId);
	public ServicesEntity  getServiceByServiceName(String serviceName);
	public ServicesEntity  getAllSevices();
	public void  deleteService(String ServiceId);

}
