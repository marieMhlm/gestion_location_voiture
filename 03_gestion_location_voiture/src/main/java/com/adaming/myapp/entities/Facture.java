package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Entity
public class Facture {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_facture")
	private Long idFacture; 
	@Temporal(TemporalType.DATE)
	private Date dateFacturation;
	
	@OneToOne
	@JoinColumn(name="id_reservation", referencedColumnName="id_reservation")
	private Reservation reservation;
	
	@ManyToOne
	@JoinColumn(name="agence_id",referencedColumnName="id_agence")
	private Agence agence; 
	
	/**
	 * ctor
	 */
	public Facture() {
		super();
	}
	
	/**
	 * ctor charge sans id 
	 * @param dateFacturation
	 */
	public Facture(Date dateFacturation) {
		super();
		this.dateFacturation = dateFacturation;
	}
	/**
	 * @return the idFacture
	 */
	public Long getIdFacture() {
		return idFacture;
	}
	/**
	 * @param idFacture the idFacture to set
	 */
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	/**
	 * @return the dateFacturation
	 */
	public Date getDateFacturation() {
		return dateFacturation;
	}
	/**
	 * @param dateFacturation the dateFacturation to set
	 */
	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	/**
	 * @return the reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}

	/**
	 * @param reservation the reservation to set
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
}
