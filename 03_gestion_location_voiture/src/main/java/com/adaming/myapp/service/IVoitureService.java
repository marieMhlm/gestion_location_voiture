package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
public interface IVoitureService {

	public Voiture add(Voiture voiture, Long pIdAgence);
	
	public Voiture update(Voiture voiture);
	
	public List<Voiture> getAll();
	
	public Voiture getById(Long pId);
}
