package com.wha.hbm.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 @Entity
 @Table(name="operations_bancaire")
public class OPBancaire {
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name="id_op")
		private long IDOP;
		
		@Column(name="montant_op")
		private double montantOP;
		
		@Column(name="date_op")
		private Date dateOP;

		@Column(name="type_op")
		private String typeOP;

		@Column(name="libelle_op")
		private String libelleOP;

		@Column(name="compteDest_op")
		private String compteDestOP;


		//bi-directional many-to-one association to Client
		@ManyToOne
		@JoinColumn(name="compte_id")
		private Compte compte;

		//Getters setters
		public long getIDOP() {
			return IDOP;
		}


		public void setIDOP(long iDOP) {
			IDOP = iDOP;
		}


		public double getMontantOP() {
			return montantOP;
		}


		public void setMontantOP(double montantOP) {
			this.montantOP = montantOP;
		}


		public Date getDateOP() {
			return dateOP;
		}


		public void setDateOP(Date dateOP) {
			this.dateOP = dateOP;
		}


		public String getTypeOP() {
			return typeOP;
		}


		public void setTypeOP(String typeOP) {
			this.typeOP = typeOP;
		}


		public String getLibelleOP() {
			return libelleOP;
		}


		public void setLibelleOP(String libelleOP) {
			this.libelleOP = libelleOP;
		}


		public String getCompteDestOP() {
			return compteDestOP;
		}


		public void setCompteDestOP(String compteDestOP) {
			this.compteDestOP = compteDestOP;
		}


		public Compte getCompte() {
			return compte;
		}


		public void setCompte(Compte compte) {
			this.compte = compte;
		}

		
}
