package com.adaming.myapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IVoitureDao;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Service
@Transactional
public class VoitureServiceImpl implements IVoitureService{
	
	Logger log = Logger.getLogger("VoitureServiceImpl");
	
	private IVoitureDao dao = null; 
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IVoitureDao dao) {
		this.dao = dao;
	}

	@Override
	public Voiture add(Voiture voiture) {
		// TODO Auto-generated method stub
		return dao.add(voiture);
	}

	@Override
	public Voiture update(Voiture voiture) {
		// TODO Auto-generated method stub
		return dao.update(voiture);
	}

	@Override
	public List<Voiture> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Voiture getById(Long pId) {
		// TODO Auto-generated method stub
		return dao.getById(pId);
	}

}
