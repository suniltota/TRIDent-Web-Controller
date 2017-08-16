/**
 * 
 */
package com.actualize.mortgage.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.datamodels.ClientEntity;
import com.actualize.mortgage.domainmodels.ClientModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.ClientManager;
import com.actualize.mortgage.services.ClientService;
import com.actualize.mortgage.web.utils.Convertor;

/**
 * @author sboragala
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientManager clientManager;

	@Autowired
	Convertor convertor;

	@Override
	public ClientModel addClient(ClientModel clientModel) throws ServiceException {
		ClientModel client = new ClientModel();
		if(null == clientModel.getClientName() || clientModel.getClientName().isEmpty())
			throw new ServiceException("Client Name cannot be Empty");
		ClientEntity clientEntity = clientManager.getClientByClientName(clientModel.getClientName());
		if(null != clientEntity)
			throw new ServiceException("Client Name already exists");
		try {
			client = convertor.toClientModel(clientManager.addClient(convertor.toClientEntity(clientModel)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public ClientModel updateClient(ClientModel clientModel) throws ServiceException {
		getClientById(clientModel.getClientId());

		return convertor.toClientModel(clientManager.updateClient(convertor.toClientEntity(clientModel)));
	}

	@Override
	public ClientModel getClientById(String clientId) throws ServiceException {
		ClientEntity clientEntity = clientManager.getClientById(clientId);
		if(null == clientEntity)
			throw new ServiceException("Invalid Client");

		return convertor.toClientModel(clientEntity);
	}

	@Override
	public ClientModel getClientByName(String clientName) throws ServiceException {
		ClientEntity clientEntity = clientManager.getClientByClientName(clientName);
		if(null == clientEntity)
			throw new ServiceException("Invalid Client");

		return convertor.toClientModel(clientEntity);
	}

	@Override
	public List<ClientModel> getAllActiveClients() throws ServiceException {
		List<ClientEntity> clientEntityList = clientManager.getAllActiveClients();
		List<ClientModel> clientModelList = new LinkedList<>();
		if(null == clientEntityList)
			throw new ServiceException("No Entries Found");
		for(ClientEntity clientEntity : clientEntityList)
			clientModelList.add(convertor.toClientModel(clientEntity));
		return clientModelList;
	}

	@Override
	public void activeClient(String clientId) throws ServiceException {
		clientManager.activeOrDeactiveClient(clientId,true);
	}

	@Override
	public void deactiveClient(String clientId) throws ServiceException {
		clientManager.activeOrDeactiveClient(clientId,false);
		clientManager.activeOrDeactiveClientsGroups(clientId, false);
		clientManager.activeOrDeactiveClientsUsers(clientId, false);
	}

}
