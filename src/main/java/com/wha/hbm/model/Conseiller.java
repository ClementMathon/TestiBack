package com.wha.hbm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the conseillers database table.
 * 
 */
@Entity
@Table(name="conseillers")
@NamedQuery(name="Conseiller.findAll", query="SELECT c FROM Conseiller c")
public class Conseiller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cons_id")
	private int consId;

	@Column(name="cons_adresse")
	private String consAdresse;

	@Column(name="cons_cp")
	private int consCp;

	private String cons_dateEmbauche;

	@Column(name="cons_email")
	private String consEmail;

	@Column(name="cons_nom")
	private String consNom;

	@Column(name="cons_prenom")
	private String consPrenom;

	@Column(name="cons_tel")
	private String consTel;

	@Column(name="cons_ville")
	private String consVille;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="conseiller")
	private List<Clients> clients;

	public Conseiller() {
	}

	public int getConsId() {
		return this.consId;
	}

	public void setConsId(int consId) {
		this.consId = consId;
	}

	public String getConsAdresse() {
		return this.consAdresse;
	}

	public void setConsAdresse(String consAdresse) {
		this.consAdresse = consAdresse;
	}

	public int getConsCp() {
		return this.consCp;
	}

	public void setConsCp(int consCp) {
		this.consCp = consCp;
	}

	public String getCons_dateEmbauche() {
		return this.cons_dateEmbauche;
	}

	public void setCons_dateEmbauche(String cons_dateEmbauche) {
		this.cons_dateEmbauche = cons_dateEmbauche;
	}

	public String getConsEmail() {
		return this.consEmail;
	}

	public void setConsEmail(String consEmail) {
		this.consEmail = consEmail;
	}

	public String getConsNom() {
		return this.consNom;
	}

	public void setConsNom(String consNom) {
		this.consNom = consNom;
	}

	public String getConsPrenom() {
		return this.consPrenom;
	}

	public void setConsPrenom(String consPrenom) {
		this.consPrenom = consPrenom;
	}

	public String getConsTel() {
		return this.consTel;
	}

	public void setConsTel(String consTel) {
		this.consTel = consTel;
	}

	public String getConsVille() {
		return this.consVille;
	}

	public void setConsVille(String consVille) {
		this.consVille = consVille;
	}

	public List<Clients> getClients() {
		return this.clients;
	}

	public void setClients(List<Clients> clients) {
		this.clients = clients;
	}

	public Clients addClient(Clients client) {
		getClients().add(client);
		client.setConseiller(this);

		return client;
	}

	public Clients removeClient(Clients client) {
		getClients().remove(client);
		client.setConseiller(null);

		return client;
	}

}