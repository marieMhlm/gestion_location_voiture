package com.adaming.myapp.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agence")
	private Long idAgence; 
	private String nom; 
	private String telephone;
	private String adresse;
	private String mail;
	
	@OneToMany(mappedBy="agence")
	private List<Facture> factures;
	
	@OneToMany(mappedBy="agence")
	private List<Voiture> voitures;
	
	@OneToMany(mappedBy="agence", fetch=FetchType.EAGER)
	private List<Reservation> reservations; 
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="agences_clients",joinColumns=@JoinColumn(name="agence_id", referencedColumnName="id_agence"),
//									inverseJoinColumns=@JoinColumn(name="client_id"))		
	@OneToMany(mappedBy="agence")
	private List<Client> clients; 
	
	/**
	 * ctor
	 */
	public Agence() {
		super();
	}

	/**
	 * ctor charge sans id 
	 * @param nom
	 * @param telephone
	 * @param adresse
	 * @param mail
	 */
	public Agence(String nom, String telephone, String adresse, String mail) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.mail = mail;
	}

	/**
	 * @return the idAgence
	 */
	public Long getIdAgence() {
		return idAgence;
	}

	/**
	 * @param idAgence the idAgence to set
	 */
	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the factures
	 */
	public List<Facture> getFactures() {
		return factures;
	}

	/**
	 * @param factures the factures to set
	 */
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	/**
	 * @return the voitures
	 */
	public List<Voiture> getVoitures() {
		return voitures;
	}

	/**
	 * @param voitures the voitures to set
	 */
	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
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
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
}
