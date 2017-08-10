/**
 * 
 */
package com.actualize.mortgage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.ServicesModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.ServicesService;

/**
 * @author sboragala
 *
 */
@RestController
@RequestMapping(value = "/actualize/transformx/")
public class ServicesController {
	
	@Autowired
	private ServicesService servicesServiceImpl;
	
	@RequestMapping(value={"/services/{id}"}, method = RequestMethod.GET)
	public ServicesModel getServiceById(@PathVariable("id") String serviceId) throws ServiceException {
		return servicesServiceImpl.getServiceByServiceId(serviceId);
	}
	
	@RequestMapping(value={"/services"}, method = RequestMethod.GET)
	public List<ServicesModel> getAllServices() throws ServiceException {
		return servicesServiceImpl.getAllSevices();
	}
	
	@RequestMapping(value={"/services"}, method = RequestMethod.POST)
	public void addService(@RequestBody ServicesModel serviceModel) throws ServiceException {
		servicesServiceImpl.addService(serviceModel);
	}
	
	@RequestMapping(value={"/services"}, method = RequestMethod.PUT)
	public void updateService(@RequestBody ServicesModel serviceModel) throws ServiceException {
		servicesServiceImpl.updateService(serviceModel);
	}
	
	@RequestMapping(value={"/services/{id}"}, method = RequestMethod.DELETE)
	public void deleteServiceById(@PathVariable("id") String serviceId) throws ServiceException {
		 servicesServiceImpl.deleteService(serviceId);
	}

}
