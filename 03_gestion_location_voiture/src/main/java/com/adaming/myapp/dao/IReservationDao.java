package com.adaming.myapp.dao;

import com.adaming.myapp.entities.Reservation;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
public interface IReservationDao extends IGenericDAO<Reservation>{

	public Reservation add(Reservation reservation, Long pIdAgence, Long pIdClient, Long pIdVoiture);

}
