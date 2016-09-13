package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
public interface IAgenceDao extends IGenericDAO<Agence>{
	
	public Agence add(Agence agence);
	
	public List<Voiture> findCarLocated(Long pIdAgence, String dateRetour);
	
	public List<Voiture> findCarDispo(Long pIdAgence, String dateDebut ,String dateRetour);
	
	public double getChiffreAffaireAnnuel(Long pIdAgence, String annee); 
	
	public List<Reservation> findResaByClient(Long pIdAgence, Long pIdClient);
	
	public List<Reservation> findResaByAgence(Long pIdAgence);
	
}
