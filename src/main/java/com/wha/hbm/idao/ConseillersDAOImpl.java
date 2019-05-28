package com.wha.hbm.idao;

import java.util.List;

import com.wha.hbm.dao.ConseillersDAO;
import com.wha.hbm.model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 

 
@Repository
public class ConseillersDAOImpl implements ConseillersDAO {
   
    @Autowired
     private SessionFactory sessionFactory;
   
    
    public void addConseillers(Conseillers conseillers) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(conseillers);
    }
 
   
    public void updateConseillers(Conseillers conseillers) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(conseillers);
    }
 
    @SuppressWarnings("unchecked")

    public List<Conseillers> listConseillers() {
        Session session = sessionFactory.getCurrentSession();
        List<Conseillers> ConseillerssList = session.createQuery("from Conseillers").list();
        return ConseillerssList;
    }
 
    
    public Conseillers getConseillersById(int id) {
        Session session = sessionFactory.getCurrentSession();      
        Conseillers conseillers = (Conseillers) session.get(Conseillers.class, new Integer(id));
        return conseillers;
    }
 
    
    public void removeConseillers(int id) {
        Session session = sessionFactory.getCurrentSession();
        Conseillers conseillers = (Conseillers) session.get(Conseillers.class, new Integer(id));
        if(null != conseillers){
            session.delete(conseillers);
        }
    }
}