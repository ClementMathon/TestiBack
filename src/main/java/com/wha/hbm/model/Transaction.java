package com.wha.hbm.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 @Entity
 @Table(name="transactions")
public class Transaction {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id_transaction")
		private int idTransaction;
		
		@Column(name="montant_transaction")
		private double montantTransaction;
		
		@Column(name="date_transaction")
		private Date dateTransaction;

		@Column(name="type_transaction")
		private String typeTransaction;

		@Column(name="libelle_transaction")
		private String libelleTransaction;

		@Column(name="compteDest_transaction")
		private String compteDestTransaction;


		//bi-directional many-to-one association to Client
		@ManyToOne
		@JoinColumn(name="compte_id")
		private Compte compte;

		//Getters setters
		public long getIdTransaction() {
			return idTransaction;
		}


		public void setIdTransaction(long idTransaction) {
			this.idTransaction = idTransaction;
		}


		public double getMontantTransaction() {
			return montantTransaction;
		}


		public void setMontantTransaction(double montantTransaction) {
			this.montantTransaction = montantTransaction;
		}


		public Date getDateTransaction() {
			return dateTransaction;
		}


		public void setDateTransaction(Date dateTransaction) {
			this.dateTransaction = dateTransaction;
		}


		public String getTypeTransaction() {
			return typeTransaction;
		}


		public void setTypeTransaction(String typeTransaction) {
			this.typeTransaction = typeTransaction;
		}


		public String getLibelleTransaction() {
			return libelleTransaction;
		}


		public void setLibelleTransaction(String libelleTransaction) {
			this.libelleTransaction = libelleTransaction;
		}


		public String getCompteDestTransaction() {
			return compteDestTransaction;
		}


		public void setCompteDestTransaction(String compteDestTransaction) {
			this.compteDestTransaction = compteDestTransaction;
		}


		public Compte getCompte() {
			return compte;
		}


		public void setCompte(Compte compte) {
			this.compte = compte;
		}

		
		
		
}
