package com.wha.hbm.service;

import java.util.List;

import com.wha.hbm.model.Conseillers;
import com.wha.hbm.service.*;




 


public interface ConseillerService {
   
    public void addConseillers(Conseillers conseillers);
   
    public void updateConseillers(Conseillers conseillers);
   
    public Conseillers getConseillersById(int id);
   
    public void removeConseillers(int id);
   
    public List<Conseillers> listConseillers();
 
 
}