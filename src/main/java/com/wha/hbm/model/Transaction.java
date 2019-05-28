package com.wha.hbm.model;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.Table;

 @Entity
 @Table(name="transactions")
public class Transaction {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id_transaction")
		private int idTransaction;
		
		@Column(name="montant_transaction", nullable = false)
		private float montantTransaction;
		
		@Column(name="date_transaction", nullable = false)
		private Date dateTransaction;

		@Column(name="type_transaction", nullable = false)
		private int typeTransaction;

		@Column(name="libelle_transaction")
		private String libelleTransaction;

		private int compteDestTransaction;


		//bi-directional many-to-one association to Client
		@ManyToOne
		@JoinColumn(name="compte_id", nullable = false)
		private Compte compte;

	
		
		//Getters setters
		public long getIdTransaction() {
			return idTransaction;
		}


		public void setIdTransaction(int idTransaction) {
			this.idTransaction = idTransaction;
		}


		public float getMontantTransaction() {
			return montantTransaction;
		}


		public void setMontantTransaction(float montantTransaction) {
			this.montantTransaction = montantTransaction;
		}


		public Date getDateTransaction() {
			return dateTransaction;
		}


		public void setDateTransaction(Date dateTransaction) {
			this.dateTransaction = dateTransaction;
		}


		public int getTypeTransaction() {
			return typeTransaction;
		}


		public void setTypeTransaction(int typeTransaction) {
			this.typeTransaction = typeTransaction;
		}


		public String getLibelleTransaction() {
			return libelleTransaction;
		}


		public void setLibelleTransaction(String libelleTransaction) {
			this.libelleTransaction = libelleTransaction;
		}


		


		public int getCompteDestTransaction() {
			return compteDestTransaction;
		}


		public void setCompteDestTransaction(int compteDestTransaction) {
			this.compteDestTransaction = compteDestTransaction;
		}


		public Compte getCompte() {
			return compte;
		}


		public void setCompte(Compte compte) {
			this.compte = compte;
		}

		
		
		
}
