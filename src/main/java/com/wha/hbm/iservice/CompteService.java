package com.wha.hbm.iservice;

import java.util.List;

import com.wha.hbm.model.Compte;

public interface CompteService {
	
    public void createCompte(Compte compte);
    
    public Compte updateCompte(Compte compte);
   
    public Compte findCompteById(int id);
     
    public List<Compte> findAllComptes();

}
