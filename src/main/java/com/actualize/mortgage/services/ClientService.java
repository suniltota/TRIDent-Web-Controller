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
	public ClientModel getClientById(String clientId) throws ServiceException;
	public ClientModel getClientByName(String clientName) throws ServiceException;
	public List<ClientModel> getAllActiveClients() throws ServiceException;
	public void activeClient(String clientId) throws ServiceException;
	public void deactiveClient(String clientId) throws ServiceException;
	public List<ClientModel> getAllClients()throws ServiceException;
	public boolean isClientNameAvailable(String clientname);
}
