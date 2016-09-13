package com.adaming.myapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IFactureDao;
import com.adaming.myapp.entities.Facture;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Transactional
public class FactureServiceImpl implements IFactureService {
	
	Logger log = Logger.getLogger("FactureServiceImpl");
	
	private IFactureDao dao = null; 
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IFactureDao dao) {
		this.dao = dao;
	}

	@Override
	public Facture add(Facture facture,  Long idReservation, Long idAgence) {
		// TODO Auto-generated method stub
		return dao.add(facture, idReservation, idAgence);
	}

	@Override
	public Facture update(Facture facture) {
		// TODO Auto-generated method stub
		return dao.update(facture);
	}

	@Override
	public List<Facture> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Facture getById(Long pId) {
		// TODO Auto-generated method stub
		return dao.getById(pId);
	}

	public void printPdf(Facture facture){
		
	}

}
