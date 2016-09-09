package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Reservation;


/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
public interface IReservationService {

	public Reservation add(Reservation reservation);
	
	public Reservation update(Reservation reservation);
	
	public List<Reservation> getAll();
	
	public Reservation getById(Long pId);
}
