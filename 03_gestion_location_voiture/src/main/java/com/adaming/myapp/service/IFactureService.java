package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Facture;

public interface IFactureService {

	public Facture add(Client client);
	
	public Client update(Client client);
	
	public List<Client> getAll();
	
	public Client getById(Long pId);
}
