package com.actualize.mortgage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.actualize.mortgage.domainmodels.ClientModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.services.ClientService;

@RestController
@RequestMapping(value = "/actualize/transformx/")
public class ClientsController {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value={"/clients"}, method = RequestMethod.GET)
	public List<ClientModel> getclients() throws ServiceException {
		return clientService.getAllClients();
	}
	
	@RequestMapping(value={"/clients/{id}"}, method = RequestMethod.GET)
	public ClientModel getClientById(@PathVariable("id") String clientId) throws ServiceException {
		return clientService.getClientById(clientId);
	}
	
	@RequestMapping(value={"/clients"}, method = RequestMethod.POST)
	public ResponseEntity<String> createClient(@RequestBody ClientModel clientModel) throws ServiceException {
		 clientService.addClient(clientModel);
		 return new ResponseEntity<String>("Client ceated Successfully",HttpStatus.OK);
	}
	
	@RequestMapping(value={"/clients/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteClient(@PathVariable("id") String clientId) throws ServiceException {
		clientService.deactiveClient(clientId);
		return new ResponseEntity<String>("Client deactivated Successfully",HttpStatus.OK);
	}

	@RequestMapping(value={"/clients/active/{id}"}, method = RequestMethod.POST)
	public ResponseEntity<String> activeClient(@PathVariable("id") String clientId) throws ServiceException {
		clientService.activeClient(clientId);
		return new ResponseEntity<String>("Client activated Successfully",HttpStatus.OK);
	}

	@RequestMapping(value={"/clients"}, method = RequestMethod.PUT)
	public ResponseEntity<String> updateClient(@RequestBody ClientModel clientModel) throws ServiceException {
		clientService.updateClient(clientModel);
		return new ResponseEntity<String>("Client updated Successfully",HttpStatus.OK);
	}
}
