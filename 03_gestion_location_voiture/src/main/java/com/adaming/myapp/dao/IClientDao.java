package com.adaming.myapp.dao;

import com.adaming.myapp.entities.Client;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
public interface IClientDao extends IGenericDAO<Client>{

	public Client add(Client client, Long pIdAgence);

}
