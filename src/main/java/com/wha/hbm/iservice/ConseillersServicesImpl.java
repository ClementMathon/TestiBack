package com.wha.hbm.iservice;

import java.util.List;

import com.wha.hbm.*;
import com.wha.hbm.dao.ConseillersDAO;
import com.wha.hbm.model.Conseillers;
import com.wha.hbm.service.ConseillerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
 
public class ConseillersServicesImpl implements ConseillerService {
   
    @Autowired
     ConseillersDAO  conseillersDAO;
 
    
    @Transactional
    public void addConseillers(Conseillers conseillers) {
        conseillersDAO.addConseillers(conseillers);
    }

    
    @Transactional
    public void updateConseillers(Conseillers conseillers) {
        conseillersDAO.updateConseillers(conseillers);
    }
   
    
    @Transactional
    public Conseillers getConseillersById(int id) {
        return this.conseillersDAO.getConseillersById(id);
    }

    
    @Transactional
    public void removeConseillers(int id){
        conseillersDAO.removeConseillers(id);
    }

    
    @Transactional
    public List<Conseillers> listConseillers()

    {
        return this.conseillersDAO.listConseillers();
    }




   
 
    
    
    
 
 
    

 
    
    
    
    

   
}