package com.adaming.myapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Client;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao{
	
	@PersistenceContext
	protected EntityManager em; 
		
	Logger log = Logger.getLogger("ClientDaoImpl");

	@Override
	public Client add(Client client, Long pIdAgence) {
		Agence a = em.find(Agence.class, pIdAgence);
		client.setAgence(a);;
		em.persist(client);
		log.info("le client a bien été ajouté ");
		return client;
	}

	@Override
	public boolean isExistMail(String mail) {
		Query query = em.createQuery("select count(*) from Client c where c.mail=:x");
		query.setParameter("x", mail);
		Long resultat = (Long) query.getSingleResult();
		log.info("il existe "+ resultat +" de mail");
		int r = resultat.intValue(); 
		if (r == 0) {
			log.info("mail n'existe pas ");
			return false; 
			
		}
		log.info("mail existe");
		return true;
		
	}

}