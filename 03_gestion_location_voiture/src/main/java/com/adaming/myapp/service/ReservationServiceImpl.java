package com.adaming.myapp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IReservationDao;
import com.adaming.myapp.dao.IVoitureDao;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Transactional
public class ReservationServiceImpl implements IReservationService{
	
	Logger log = Logger.getLogger("ReservationServiceImpl");
	
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	
	private IReservationDao dao = null; 

	/**
	 * @param dao the dao to set
	 */
	public void setDao(IReservationDao dao) {
		this.dao = dao;
	}

	@Override
	public Reservation add(Reservation reservation, Long pIdAgence, Long pIdClient, Long pIdVoiture) {
		return dao.add(reservation, pIdAgence, pIdClient, pIdVoiture);
	}

	@Override
	public Reservation update(Reservation reservation) {
		// TODO Auto-generated method stub
		return dao.update(reservation);
	}

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Reservation getById(Long pId) {
		// TODO Auto-generated method stub
		return dao.getById(pId);
	}

}
