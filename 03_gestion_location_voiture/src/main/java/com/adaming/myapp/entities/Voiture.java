package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Entity
public class Voiture {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_voiture")
	private Long idVoiture; 
	private String marque; 
	private String modele;
	private String matricule;
	private double prix;
	private int annee;
	private String kilometrage;
	
	@OneToMany(mappedBy="voiture")
	private List<Reservation> reservations; 
	
	@ManyToOne
	@JoinColumn(name="agence_id",referencedColumnName="id_agence")
	private Agence agence;
	
	/**
	 * ctor
	 */
	public Voiture() {
		super();
	}

	/**
	 * ctor charge sans id 
	 * @param marque
	 * @param modele
	 * @param matricule
	 * @param prix
	 * @param annee
	 * @param kilometrage
	 */
	public Voiture(String marque, String modele, String matricule, double prix,
			int annee, String kilometrage) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.matricule = matricule;
		this.prix = prix;
		this.annee = annee;
		this.kilometrage = kilometrage;
	}

	/**
	 * @return the idVoiture
	 */
	public Long getIdVoiture() {
		return idVoiture;
	}

	/**
	 * @param idVoiture the idVoiture to set
	 */
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * @return the kilometrage
	 */
	public String getKilometrage() {
		return kilometrage;
	}

	/**
	 * @param kilometrage the kilometrage to set
	 */
	public void setKilometrage(String kilometrage) {
		this.kilometrage = kilometrage;
	}

	/**
	 * @return the reservations
	 */
	public List<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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
