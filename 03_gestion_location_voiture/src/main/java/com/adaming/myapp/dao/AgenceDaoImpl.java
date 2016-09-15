package com.adaming.myapp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
@Repository
public class AgenceDaoImpl extends GenericDaoImpl<Agence> implements IAgenceDao {
	
	@PersistenceContext
	protected EntityManager em; 
		
	Logger log = Logger.getLogger("AgenceDaoImpl");
	
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	

	@Override
	public Agence add(Agence agence) {
		em.persist(agence);
		log.info("l'agence a bien été ajouté ");
		return agence;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> findCarLocated(Long pIdAgence, String dateRetour) {
		Date dRetour;
		try {
			dRetour = date.parse(dateRetour);
			Query query = em.createQuery("from Reservation r where r.dateFin=:y and r.agence.idAgence =:x");
			query.setParameter("y", dRetour);
			query.setParameter("x", pIdAgence);
			log.info("il existe "+ query.getResultList().size() +" réservations se terminant à la date demandée et pour l'agence demandée");
			List<Reservation> r = query.getResultList();
			
			List<Voiture> voituresRendues = new ArrayList<Voiture>();
			
			for (Reservation resa : r) {
				voituresRendues.add(resa.getVoiture());
			}

			log.info("il existe "+ voituresRendues.size() +" voitures rendues ");
			
			return voituresRendues;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; 
	}

	@Override
	public List<Voiture> findCarDispo(Long pIdAgence,String dateDebut ,String dateRetour){
		//recup agence 
		Agence a = em.find(Agence.class, pIdAgence);
		List<Voiture> vList = a.getVoitures();
		
		//recup des resa de l'agence 
		List<Reservation> resaList = a.getReservations();
		
		//def liste voitures dispo	
		List<Voiture> voituresDispo = new ArrayList<Voiture>();
		voituresDispo = vList;
		try{
		
			Date dDebut = date.parse(dateDebut);
			Date dRetour = date.parse(dateRetour);
			
			for (Reservation resa : resaList) {
				if (!dRetour.before(resa.getDateDebut()) && !dDebut.after(resa.getDateFin())) {
					voituresDispo.remove(resa.getVoiture());
				}
			}
			log.info("il existe "+ voituresDispo.size() +" de voitures dispo ");
			
			return voituresDispo;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double getChiffreAffaireAnnuel(Long pIdAgence, String annee) {
		
		double ca = 0; 
		
		Agence a = em.find(Agence.class, pIdAgence);
		List<Facture> factures = a.getFactures();
		
//		//recup de l'annee actuelle
//		Calendar nowDate = Calendar.getInstance();
//		int year = nowDate.get(Calendar.YEAR);
		
		int anneeSuivanteInt = Integer.parseInt(annee);
		anneeSuivanteInt = anneeSuivanteInt + 1;
		String anneeSuivante = String.valueOf(anneeSuivanteInt);
			
		try{
			String debutAN = "01/01/"+annee;
			Date dateDebutAn = date.parse(debutAN);
						
			String finAN = "01/01/"+anneeSuivante;
			Date dateFinAn = date.parse(finAN);

			for (Facture facture : factures) {
				if (facture.getDateFacturation().after(dateDebutAn) && facture.getDateFacturation().before(dateFinAn)) {
					log.info("start 1 "+facture.getDateFacturation());
					ca = ca + facture.getReservation().getPrixTotal();
					log.info("le ca annuel est de " + ca +"------------------");
				}
			}
			
			log.info("le chiffre affaire annuel est de " + ca);
			
			return ca;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findResaByClient(Long pIdAgence, Long pIdClient) {
		
		Query query = em.createQuery("from Reservation r where r.agence.idAgence =:x AND r.client.idCLient =:y");
		query.setParameter("x", pIdAgence);
		query.setParameter("y", pIdClient);
		
		log.info("il existe "+ query.getResultList().size() +" réservations à l'agence et au client demandés");

		List<Reservation> r = query.getResultList();
		
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findResaByAgence(Long pIdAgence) {

		Query query = em.createQuery("from Reservation r where r.agence.idAgence =:x");
		query.setParameter("x", pIdAgence);
		
		log.info("il existe "+ query.getResultList().size() +" réservations à l'agence demandée");

		List<Reservation> r = query.getResultList();
		
		return r;
	}

}
