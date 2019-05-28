package com.wha.hbm.model;
// Generated 21 mai 2019 à 10:33:07 by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Conseillers generated by hbm2java
 */
@Entity
@Table(name="conseillers")

public class Conseillers  implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

     private int consId;
     private String consDateEmbauche;
     private String consNom;
     private String consPrenom;
     private String consEmail;
     private String consTel;
     private String consAdresse;
     private int consCp;
     private String consVille;
     
    public Conseillers() {
    }

    /*
     * public Conseillers(String consDateEmbauche, String consNom, String
     * consPrenom, String consEmail, String consTel, String consAdresse, int consCp,
     * String consVille) { this.consDateEmbauche = consDateEmbauche; this.consNom =
     * consNom;
     * 
     * this.consPrenom = consPrenom; this.consEmail = consEmail; this.consTel =
     * consTel; this.consAdresse = consAdresse; this.consCp = consCp; this.consVille
     * = consVille; }
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name="cons_Id", unique=true, nullable=false)
    public int getconsId() {
        return this.consId;
    }
    
    public void setconsId(int consId) {
        this.consId = consId;
    }
    
    @Column(name="cons_DateEmbauche", nullable=true, length=10)
    public String getconsDateEmbauche() {
        return this.consDateEmbauche;
    }
    
    public void setconsDateEmbauche(String consDateEmbauche) {
        this.consDateEmbauche = consDateEmbauche;
    }
    
    @Column(name="cons_Nom", nullable=true, length=30)
    public String getconsNom() {
        return this.consNom;
    }
    
    public void setconsNom(String consNom) {
        this.consNom = consNom;
    }
    
    @Column(name="cons_Prenom", nullable=true, length=30)
    public String getconsPrenom() {
        return this.consPrenom;
    }
    
    public void setconsPrenom(String consPrenom) {
        this.consPrenom = consPrenom;
    }
    
    @Column(name="cons_Email", nullable=true, length=50)
    public String getconsEmail() {
        return this.consEmail;
    }
    
    public void setconsEmail(String consEmail) {
        this.consEmail = consEmail;
    }
    
    @Column(name="cons_Tel", nullable=true, length=15)
    public String getconsTel() {
        return this.consTel;
    }
    
    public void setconsTel(String consTel) {
        this.consTel = consTel;
    }
    
    @Column(name="cons_Adresse", nullable=true)
    public String getconsAdresse() {
        return this.consAdresse;
    }
    
    public void setconsAdresse(String consAdresse) {
        this.consAdresse = consAdresse;
    }
    
    @Column(name="cons_Cp", nullable=true)
    public int getconsCp() {
        return this.consCp;
    }
    
    public void setconsCp(int consCp) {
        this.consCp = consCp;
    }
    
    @Column(name="cons_Ville", nullable=true, length=30)
    public String getconsVille() {
        return this.consVille;
    }
    
    public void setconsVille(String consVille) {
        this.consVille = consVille;
    }



}


