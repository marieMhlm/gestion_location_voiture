package com.adaming.myapp.dao;

import java.util.Date;
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

	public List<Voiture> findCarLocated(Long pIdAgence, Date dateRetour);
	
	public List<Voiture> findCarDispo(Long pIdAgence, Date dateDebut ,Date dateRetour);
	
	public double getChiffreAffaireAnnuel(Long pIdAgence); 
	
	public List<Reservation> findResaByClient(Long pIdAgence);
	
	public List<Reservation> findResaByAgence(Long pIdAgence);
	
}
