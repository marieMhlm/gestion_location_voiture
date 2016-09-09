package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Facture;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
public interface IFactureService {

	public Facture add(Facture facture);
	
	public Facture update(Facture facture);
	
	public List<Facture> getAll();
	
	public Facture getById(Long pId);	
}
