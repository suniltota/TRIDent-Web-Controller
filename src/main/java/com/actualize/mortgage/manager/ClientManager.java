/**
 * 
 */
package com.actualize.mortgage.manager;

import java.util.List;

import com.actualize.mortgage.datamodels.ClientEntity;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */
public interface ClientManager {
	
	public ClientEntity getClientById(String clientId);
	
	public ClientEntity getClientByClientName(String clientName) throws ServiceException;
	
	public ClientEntity addClient(ClientEntity clientEntity);
	
	public ClientEntity updateClient(ClientEntity clientEntity);
	
	public void activeOrDeactiveClient(String clientId,Boolean enabled);
		
	public List<ClientEntity> getAllActiveClients();

	void activeOrDeactiveClientsGroups(String clientId, Boolean enabled);

	void activeOrDeactiveClientsUsers(String clientId, Boolean enabled);
	public List<ClientEntity> getAllClients();

	public long isClientNameAvailable(String clientname);
}
