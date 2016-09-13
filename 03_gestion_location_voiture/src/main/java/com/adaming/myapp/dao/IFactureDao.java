package com.adaming.myapp.dao;

import com.adaming.myapp.entities.Facture;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
public interface IFactureDao extends IGenericDAO<Facture> {
	
	public Facture add(Facture f, Long idReservation, Long idAgence);

}
