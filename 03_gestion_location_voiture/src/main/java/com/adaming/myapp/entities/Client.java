package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private Long idCLient; 
	private String nom; 
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance; 
	private String telephone;
	private String adresse;
	private String mail;
	@Temporal(TemporalType.DATE)
	private Date datePermis;
	
//	@ManyToMany(mappedBy="clients", cascade=CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="agence_id",referencedColumnName="id_agence")
	private Agence agence; 
	
	@OneToMany(mappedBy="client")
	private List<Reservation> reservations; 
	
	/**
	 * ctor
	 */
	public Client() {
		super();
	}

	/**
	 * ctor charge sans id 
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param telephone
	 * @param adresse
	 * @param mail
	 * @param datePermis
	 */
	public Client(String nom, String prenom, Date dateNaissance,
			String telephone, String adresse, String mail, Date datePermis) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.adresse = adresse;
		this.mail = mail;
		this.datePermis = datePermis;
	}

	/**
	 * @return the idCLient
	 */
	public Long getIdCLient() {
		return idCLient;
	}

	/**
	 * @param idCLient the idCLient to set
	 */
	public void setIdCLient(Long idCLient) {
		this.idCLient = idCLient;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	 * @return the datePermis
	 */
	public Date getDatePermis() {
		return datePermis;
	}

	/**
	 * @param datePermis the datePermis to set
	 */
	public void setDatePermis(Date datePermis) {
		this.datePermis = datePermis;
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

}
