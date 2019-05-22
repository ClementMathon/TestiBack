package com.wha.hbm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Compte {

	
	@Entity
	@Table(name="Comptes")
	public class Employee {
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    @Column(name = "compte_id")
	    private int compteId;
	   
	    @Column(name = "client_id")
	    private int clientId;
	   
	    @Column(name = "compte_type")
	    private int comptetype;
	   
	    @Column(name = "compte_decouvertAutorise")
	    private int compteDecouvert;
	   
	    @Column(name = "compte_plafondAutorise")
	    private int compteAutorise;
	   
	    @Column(name = "compte_solde")
	    private Double compteSolde;

	    //Getters and setters
		public int getCompteId() {
			return compteId;
		}

		public void setCompteId(int compteId) {
			this.compteId = compteId;
		}

		public int getClientId() {
			return clientId;
		}

		public void setClientId(int clientId) {
			this.clientId = clientId;
		}

		public int getComptetype() {
			return comptetype;
		}

		public void setComptetype(int comptetype) {
			this.comptetype = comptetype;
		}

		public int getCompteDecouvert() {
			return compteDecouvert;
		}

		public void setCompteDecouvert(int compteDecouvert) {
			this.compteDecouvert = compteDecouvert;
		}

		public int getCompteAutorise() {
			return compteAutorise;
		}

		public void setCompteAutorise(int compteAutorise) {
			this.compteAutorise = compteAutorise;
		}

		public Double getCompteSolde() {
			return compteSolde;
		}

		public void setCompteSolde(Double compteSolde) {
			this.compteSolde = compteSolde;
		}
	   
	  
	}
}
