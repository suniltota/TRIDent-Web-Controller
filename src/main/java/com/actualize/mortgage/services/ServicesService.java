/**
 * 
 */
package com.actualize.mortgage.services;

import java.util.List;

import com.actualize.mortgage.domainmodels.ServicesModel;

/**
 * @author sboragala
 *
 */
public interface ServicesService {


	public ServicesModel  addService(ServicesModel servicesModel);
	public ServicesModel  updateService(ServicesModel servicesModel);
	public ServicesModel  getServiceByServiceId(String serviceId);
	public ServicesModel  getServiceByServiceName(String serviceName);
	public List<ServicesModel>  getAllSevices();
	public void  deleteService(String serviceId);


}
