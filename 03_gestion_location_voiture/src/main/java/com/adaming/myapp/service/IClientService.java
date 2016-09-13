package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Client;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
public interface IClientService {

	public Client add(Client client, Long pIdAgence);
	
	public Client update(Client client);
	
	public List<Client> getAll();
	
	public Client getById(Long pId);
}
