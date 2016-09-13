package com.adaming.myapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
@Repository
public class FactureDaoImpl extends GenericDaoImpl<Facture> implements IFactureDao {
	
	@PersistenceContext
	protected EntityManager em; 
	
	Logger log = Logger.getLogger("FactureDaoImpl");

	@Override
	public Facture add(Facture f, Long idReservation, Long idAgence) {
		Reservation r = em.find(Reservation.class,idReservation);
		Agence a = em.find(Agence.class,idAgence);
		f.setAgence(a);
		f.setReservation(r);
		em.persist(f);
		log.info("la facture a bien été ajoutée ");
		return f;
	}

}
