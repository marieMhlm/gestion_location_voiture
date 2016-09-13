package com.adaming.myapp.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IAgenceDao;
import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Transactional
public class AgenceServiceImpl implements IAgenceService {
	
	Logger log = Logger.getLogger("AgenceServiceImpl");
	
	private IAgenceDao dao = null;

	/**
	 * @param dao the dao to set
	 */
	public void setDao(IAgenceDao dao) {
		this.dao = dao;
	}

	@Override
	public Agence add(Agence agence) {
		return dao.add(agence);
	}

	@Override
	public Agence update(Agence agence) {
		return dao.update(agence);
	}

	@Override
	public List<Agence> getAll() {
		return dao.getAll();
	}

	@Override
	public Agence getById(Long pId) {
		return dao.getById(pId);
	}

	@Override
	public List<Voiture> findCarLocated(Long pIdAgence, String dateRetour) {
		return dao.findCarLocated(pIdAgence, dateRetour);
	}

	@Override
	public List<Voiture> findCarDispo(Long pIdAgence, String dateDebut,
			String dateRetour) {
		// TODO Auto-generated method stub
		return dao.findCarDispo(pIdAgence, dateDebut, dateRetour);
	}

	@Override
	public double getChiffreAffaireAnnuel(Long pIdAgence, String annee){
		// TODO Auto-generated method stub
		return dao.getChiffreAffaireAnnuel(pIdAgence, annee);
	}

	@Override
	public List<Reservation> findResaByClient(Long pIdAgence, Long pIdClient) {
		// TODO Auto-generated method stub
		return dao.findResaByClient(pIdAgence, pIdClient);
	}

	@Override
	public List<Reservation> findResaByAgence(Long pIdAgence) {
		// TODO Auto-generated method stub
		return dao.findResaByAgence(pIdAgence);
	}

}
