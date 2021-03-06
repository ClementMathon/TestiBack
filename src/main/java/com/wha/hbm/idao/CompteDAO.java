package com.wha.hbm.idao;

import java.util.List;

import com.wha.hbm.model.Compte;

public interface CompteDAO {

	public void addCompte(Compte compte, int id);
	   
    public void updateCompte(Compte compte);
          
    public Compte findCompteById(int id);
   
    public List<Compte> listComptes();
    
    public List<Compte> listComptesByClientId(int id);
}
