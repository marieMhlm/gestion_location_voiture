package com.adaming.myapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
@Repository
public class VoitureDaoImpl extends GenericDaoImpl<Voiture> implements IVoitureDao {
	
	@PersistenceContext
	protected EntityManager em; 
	
	Logger log = Logger.getLogger("VoitureDaoImpl");

	@Override
	public Voiture add(Voiture voiture, Long pIdAgence) {
		Agence a = em.find(Agence.class, pIdAgence);
		voiture.setAgence(a);
		
		em.persist(voiture);
		
		log.info("la voiture a bien été ajoutée ");
		
		return voiture;
	}
	

}
