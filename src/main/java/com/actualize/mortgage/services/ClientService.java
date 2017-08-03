/**
 * 
 */
package com.actualize.mortgage.services;

import java.util.List;

import com.actualize.mortgage.domainmodels.ClientModel;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * defines all services regarding client
 * @author sboragala
 *
 */
public interface ClientService {
	
	public ClientModel addClient(ClientModel clientModel) throws ServiceException;
	public ClientModel updateClient(ClientModel clientModel) throws ServiceException;
	public ClientModel viewClientById(String clientId) throws ServiceException;
	public ClientModel viewClientByName(String clientName) throws ServiceException;
	public List<ClientModel> viewAllClients() throws ServiceException;

}
