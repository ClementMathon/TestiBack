package com.wha.hbm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
@Autowired
private SessionFactory sessionFactory;
    
   public Session getSession() {
    return sessionFactory.getCurrentSession();
       
   }
    
    public void persist(Object entity) {
	getSession().save(entity);
    }
    
    public void delete (Object entity) {
	getSession().delete(entity);
    }

	
    
}
