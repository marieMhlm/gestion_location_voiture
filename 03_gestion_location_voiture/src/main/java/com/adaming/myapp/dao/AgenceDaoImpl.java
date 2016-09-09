package com.adaming.myapp.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
@Repository("agenceDao")
public class AgenceDaoImpl extends GenericDaoImpl<Agence> implements IAgenceDao {
	
//	@PersistenceContext
//	private EntityManager em; 
//	
//	Logger log = Logger.getLogger("AgenceDaoImpl");
//
//	@Override
//	public Agence add(Agence agence) {
//		em.persist(agence);
//		log.info("l'agence " + agence.getIdAgence() +" a bien été ajouté ");
//		return agence;
//	}
//
//	@Override
//	public Agence update(Agence agence) {
//		em.merge(agence);
//		log.info("l'agence " + agence.getIdAgence() +" a bien été modifié ");
//		return agence;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Agence> getAll() {
//		Query query = em.createQuery("from Agence");
//		log.info("il existe "+ query.getResultList().size() +" dans la base de données ");
//		return query.getResultList();
//	}
//
//	@Override
//	public Agence getById(Long pId) {
//		Agence a = em.find(Agence.class, pId);
//		log.info("l'agence " + a.getIdAgence() +" a bien été trouvé ");
//		return a;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> findCarLocated(Long pIdAgence, Date dateRetour) {
		
		Query query = em.createQuery("from Reservation r where r.dateFin=:y and r.agence.idAgence =:x");
		query.setParameter("y", dateRetour);
		query.setParameter("x", pIdAgence);
		log.info("il existe "+ query.getResultList().size() +" réservations se terminant à la date demandée et pour l'agence demandée");
		List<Reservation> r = query.getResultList();
		
		List<Voiture> voituresRendues = new ArrayList<Voiture>();
		
		for (Reservation resa : r) {
			voituresRendues.add(resa.getVoiture());
		}

		return voituresRendues;
	}

	@Override
	public List<Voiture> findCarDispo(Long pIdAgence,Date dateDebut ,Date dateRetour) {
		//recup agence 
		Agence a = em.find(Agence.class, pIdAgence);
		List<Voiture> vList = a.getVoitures();
		
		//recup des resa de l'agence 
		List<Reservation> resaList = a.getReservations();
		
		//def liste voitures dispo	
		List<Voiture> voituresDispo = new ArrayList<Voiture>();
		voituresDispo = vList;
		
		for (Reservation resa : resaList) {
			if (!dateRetour.before(resa.getDateDebut()) && !dateDebut.after(resa.getDateFin())) {
				voituresDispo.remove(resa.getVoiture());
			}
		}
		log.info("il existe "+ voituresDispo.size() +" de voitures dispo ");
		
		return voituresDispo;
	}

	@Override
	public double getChiffreAffaireAnnuel(Long pIdAgence) {
		double ca = 0; 
		
		Agence a = em.find(Agence.class, pIdAgence);
		List<Reservation> resaList = a.getReservations(); 
		
		//recup de l'annee actuelle
		Calendar nowDate = Calendar.getInstance();
		int year = nowDate.get(Calendar.YEAR);
		
		
		//date 01/01/Year 
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//		String annee = String.valueOf(year);
//		String jourAN = "01/01/"+annee;
//		Date dateAn = date.parse(jourAN);
		
		for (Reservation resa : resaList) {
			if (resa.getFacture().getDateFacturation().after(null)) {
				ca = ca + resa.getPrixTotal();
			}
		}
		
		 log.info("le chiffre d'affaire annuel est de "+ca);
		
		return ca;
	}

	@Override
	public List<Reservation> findResaByClient(Long pIdAgence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findResaByAgence(Long pIdAgence) {
		// TODO Auto-generated method stub
		return null;
	}

}
