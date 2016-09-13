package com.adaming.myapp.dao;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
@Repository
public class ReservationDaoImpl extends GenericDaoImpl<Reservation> implements IReservationDao{

	@PersistenceContext
	protected EntityManager em; 
	
	Logger log = Logger.getLogger("ReservationDaoImpl");
	
	@Override
	public Reservation add(Reservation reservation, Long pIdAgence, Long pIdClient, Long pIdVoiture) {
		Agence a = em.find(Agence.class, pIdAgence);
		Client c = em.find(Client.class, pIdClient);
		Voiture v = em.find(Voiture.class, pIdVoiture);
		
		reservation.setAgence(a);
		reservation.setClient(c);
		reservation.setVoiture(v);
		double pTot = caculatePrixTotal(reservation);
		reservation.setPrixTotal(pTot);
		em.persist(reservation);
		
		log.info("la reservation a bien été ajoutée ");
		
		return reservation;
	}

	/**
	 * calcul du prix total 
	 * @return prix total
	 */
	public double caculatePrixTotal(Reservation r) {
		
		Date dateDebut = r.getDateDebut();
		Date dateFin = r.getDateFin();
		
		//calcul de la duree de location entre deux dates 
		Long dureeJour = dateFin.getTime() - dateDebut.getTime();
		Long duree = TimeUnit.DAYS.convert(dureeJour, TimeUnit.MILLISECONDS);
	
		//calcul du prix total		
		//double prixTot = this.voiture.getPrix() * duree; 
		Double prixTot = r.getVoiture().getPrix() * duree; 
		return prixTot;

	}
}
