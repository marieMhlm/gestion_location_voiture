package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IAgenceDao;
import com.adaming.myapp.entities.Agence;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Service
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
	public List<Voiture> findCarLocated(Long pIdAgence, Date dateRetour) {
		return dao.findCarLocated(pIdAgence, dateRetour);
	}

	@Override
	public List<Voiture> findCarDispo(Long pIdAgence, Date dateDebut,
			Date dateRetour) {
		// TODO Auto-generated method stub
		return dao.findCarDispo(pIdAgence, dateDebut, dateRetour);
	}

	@Override
	public double getChiffreAffaireAnnuel(Long pIdAgence) {
		// TODO Auto-generated method stub
		return 0;
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
