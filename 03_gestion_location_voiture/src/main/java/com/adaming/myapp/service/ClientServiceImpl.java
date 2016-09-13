package com.adaming.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IClientDao;
import com.adaming.myapp.entities.Client;


/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 */
@Transactional
public class ClientServiceImpl implements IClientService{
	
	Logger log = Logger.getLogger("ClientServiceImpl");
	
	@Inject
	private IClientDao dao = null; 
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IClientDao dao) {
		this.dao = dao;
	}

	@Override
	public Client add(Client client, Long pIdAgence) {
		// TODO Auto-generated method stub
		return dao.add(client, pIdAgence);
	}

	@Override
	public Client update(Client client) {
		// TODO Auto-generated method stub
		return dao.update(client);
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Client getById(Long pId) {
		// TODO Auto-generated method stub
		return dao.getById(pId);
	}

}
