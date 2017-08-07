package com.actualize.mortgage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.actualize.mortgage.domainmodels.ClientModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.ClientService;

@RestController
public class ClientsController {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value={"/clients"}, method = RequestMethod.GET)
	public List<ClientModel> getclients() throws ServiceException {
		return clientService.viewAllClients();
	}
	
	@RequestMapping(value={"/clients/{id}"}, method = RequestMethod.GET)
	public ClientModel getClientById(@PathVariable("id") String clientId) throws ServiceException {
		return clientService.viewClientById(clientId);
	}
	
	@RequestMapping(value={"/clients"}, method = RequestMethod.POST)
	public ClientModel createClient(@RequestBody ClientModel clientModel) throws ServiceException {
		return clientService.addClient(clientModel);
	}
	
	@RequestMapping(value={"/clients/{id}"}, method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable("id") String clientId) throws ServiceException {
		//clientService.
	}
	
	@RequestMapping(value={"/clients"}, method = RequestMethod.PUT)
	public void updateClient(@RequestBody ClientModel clientModel) throws ServiceException {
		clientService.updateClient(clientModel);
	}
}
