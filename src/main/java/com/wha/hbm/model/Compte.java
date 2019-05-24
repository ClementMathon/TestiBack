package com.wha.hbm.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the comptes database table.
 * 
 */
@Entity
@Table(name="comptes")

public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="compte_id")
	private int compteId;

	private int compte_decouvertAutorise;

	private short compte_plafondAutorise;

	@Column(name="compte_solde", nullable = false)
	private float compteSolde;

	@Column(name="compte_type", nullable = false)
	private byte compteType;

	//bi-directional many-to-one association to Client
	
	@ManyToOne
	@JoinColumn(name="client_id", nullable = false)
	@JsonIgnore
	private Clients client;

	public Comptes() {
	}

	public int getCompteId() {
		return this.compteId;
	}

	public void setCompteId(int compteId) {
		this.compteId = compteId;
	}

	public int getCompte_decouvertAutorise() {
		return this.compte_decouvertAutorise;
	}

	public void setCompte_decouvertAutorise(int compte_decouvertAutorise) {
		this.compte_decouvertAutorise = compte_decouvertAutorise;
	}

	public short getCompte_plafondAutorise() {
		return this.compte_plafondAutorise;
	}

	public void setCompte_plafondAutorise(short compte_plafondAutorise) {
		this.compte_plafondAutorise = compte_plafondAutorise;
	}

	public float getCompteSolde() {
		return this.compteSolde;
	}

	public void setCompteSolde(float compteSolde) {
		this.compteSolde = compteSolde;
	}

	public byte getCompteType() {
		return this.compteType;
	}

	public void setCompteType(byte compteType) {
		this.compteType = compteType;
	}

	public Clients getClient() {
		return this.client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

}