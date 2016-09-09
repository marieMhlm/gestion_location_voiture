package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

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

import org.hibernate.annotations.Fetch;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private Long idReservation; 
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private double prixTotal;
	
	@OneToOne(mappedBy="reservation")
	private Facture facture; 
	
	@ManyToOne
	@JoinColumn(name="client_id",referencedColumnName="id_client")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="agence_id",referencedColumnName="id_agence")
	private Agence agence;
	
	@ManyToOne
	@JoinColumn(name="voiture_id",referencedColumnName="id_voiture")
	private Voiture voiture;
	
	/**
	 * ctor 
	 */
	public Reservation() {
		super();
	}

	/**
	 * ctor charge sans id 
	 * @param dateDebut
	 * @param dateFin
	 */
	public Reservation(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	/**
	 * @return the idReservation
	 */
	public Long getIdReservation() {
		return idReservation;
	}

	/**
	 * @param idReservation the idReservation to set
	 */
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the prixTotal
	 */
	public double getPrixTotal() {
		return prixTotal;
	}

	/**
	 * @param prixTotal the prixTotal to set
	 */
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	/**
	 * @return the facture
	 */
	public Facture getFacture() {
		return facture;
	}

	/**
	 * @param facture the facture to set
	 */
	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
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

	/**
	 * @return the voiture
	 */
	public Voiture getVoiture() {
		return voiture;
	}

	/**
	 * @param voiture the voiture to set
	 */
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
}
