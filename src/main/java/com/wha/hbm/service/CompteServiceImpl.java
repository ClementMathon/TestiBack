package com.wha.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.hbm.idao.CompteDAO;
import com.wha.hbm.iservice.CompteService;
import com.wha.hbm.model.Compte;

@Service
public class CompteServiceImpl implements CompteService {
	
	@Autowired
    private CompteDAO compteDAO;
 
    public void setCompteDAO(CompteDAO compteDAO) {
        this.compteDAO = compteDAO;
    }
 
    @Transactional
    public Compte updateCompte(Compte compte) {
        compteDAO.updateCompte(compte);
        return this.compteDAO.findCompteById(1);
    }
    
    @Transactional
    public void createCompte(Compte compte) {
        compteDAO.addCompte(compte);
    }
    
    @Transactional
    public List<Compte>  findAllComptes() {
        return this.compteDAO.listComptes();
    }
 
    @Transactional
    public Compte findCompteById(int id) {
        return compteDAO.findCompteById(id);
    }
 
   

}
