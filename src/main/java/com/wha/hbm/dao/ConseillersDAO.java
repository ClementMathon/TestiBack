package com.wha.hbm.dao;

import java.util.List;

import com.wha.hbm.model.Conseillers;






 

 
public interface ConseillersDAO {
   
    public void addConseillers(Conseillers conseillers);
   
    public void updateConseillers(Conseillers conseillers);
   
    public Conseillers getConseillersById(int id);
   
    public void removeConseillers(int id);
   
    public List<Conseillers> listConseillers();
 
}