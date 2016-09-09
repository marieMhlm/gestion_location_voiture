package com.adaming.myapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IReservationDao;
import com.adaming.myapp.entities.Reservation;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{
	
	Logger log = Logger.getLogger("ReservationServiceImpl");
	
	private IReservationDao dao = null; 

	/**
	 * @param dao the dao to set
	 */
	public void setDao(IReservationDao dao) {
		this.dao = dao;
	}

	@Override
	public Reservation add(Reservation reservation) {
		// TODO Auto-generated method stub
		return dao.add(reservation);
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
