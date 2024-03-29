package com.wha.hbm.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the clients database table.
 *
 */
@Entity
@Table(name="clients")
public class Clients implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="client_id")
	private int clientId;

	@Column(name="client_adresse")
	private String clientAdresse;

	@Column(name="client_cp")
	private int clientCp;

	@Column(name="client_email")
	private String clientEmail;

	@Column(name="client_mdp")
	private String clientMdp;

	private int client_nbEnfant;

	@Column(name="client_nom")
	private String clientNom;

	@Column(name="client_prenom")
	private String clientPrenom;

	@Column(name="client_situation")
	private String clientSituation;

	@Column(name="client_tel")
	private String clientTel;

	@Column(name="client_ville")
	private String clientVille;

	//bi-directional many-to-one association to Conseiller
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cons_Id")
	private Conseillers conseiller;


	//bi-directional many-to-one association to Compte
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Compte> comptes;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "client_id")
	private ClientAuth clientAuth;

	public Clients() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientAdresse() {
		return this.clientAdresse;
	}

	public void setClientAdresse(String clientAdresse) {
		this.clientAdresse = clientAdresse;
	}

	public int getClientCp() {
		return this.clientCp;
	}

	public void setClientCp(int clientCp) {
		this.clientCp = clientCp;
	}

	public String getClientEmail() {
		return this.clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientMdp() {
		return this.clientMdp;
	}

	public void setClientMdp(String clientMdp) {
		this.clientMdp = clientMdp;
	}

	public int getClient_nbEnfant() {
		return this.client_nbEnfant;
	}

	public void setClient_nbEnfant(int client_nbEnfant) {
		this.client_nbEnfant = client_nbEnfant;
	}

	public String getClientNom() {
		return this.clientNom;
	}

	public void setClientNom(String clientNom) {
		this.clientNom = clientNom;
	}

	public String getClientPrenom() {
		return this.clientPrenom;
	}

	public void setClientPrenom(String clientPrenom) {
		this.clientPrenom = clientPrenom;
	}

	public String getClientSituation() {
		return this.clientSituation;
	}

	public void setClientSituation(String clientSituation) {
		this.clientSituation = clientSituation;
	}

	public String getClientTel() {
		return this.clientTel;
	}

	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
	}

	public String getClientVille() {
		return this.clientVille;
	}

	public void setClientVille(String clientVille) {
		this.clientVille = clientVille;
	}

	public Conseillers getConseiller() {
		return this.conseiller;
	}

	public void setConseiller(Conseillers conseiller) {
		this.conseiller = conseiller;
	}

//	public List<Compte> getComptes() {
//		return this.comptes;
//	}
//
//	public void setComptes(List<Compte> comptes) {
//		this.comptes = comptes;
//	}


}
