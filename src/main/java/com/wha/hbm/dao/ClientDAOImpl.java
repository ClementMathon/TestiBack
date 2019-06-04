package com.wha.hbm.dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wha.hbm.idao.ClientDao;
import com.wha.hbm.model.Clients;
import com.wha.hbm.model.Conseillers;
import com.wha.hbm.service.ConseillerService;


@Repository("employeeDao")
public class ClientDAOImpl extends AbstractDao implements ClientDao {
@Autowired private SessionFactory sessionFactory;
   
    public void saveClient(Clients client) {
	getSession().save(client);
    }
    
    public List<Clients> findAllClients() {
	String req = "from Clients c";
	Query q = getSession().createQuery(req);
	List<Clients> res = (List <Clients>) q.list();
	return res;
    }
public List<Clients> findAllClientswithoutconseiller() {
  String req = "from Clients c where cons_Id=null";
  Query q = getSession().createQuery(req);
  List<Clients> res = (List<Clients>)q.list();
  return res;
}
    public Clients findClientById(int id) {
	return (Clients) getSession().get(Clients.class, id);
	
    }

    
    
    public void updateClient(Clients client) {
	  Session session = sessionFactory.getCurrentSession();
        session.merge(client);
    }


    public void deleteClientById(int id) {
	    Session session = getSession();

	    //start a transaction
	    session.beginTransaction();
	    
	    // getting the student
	   Clients ClientToBeDeleted = (Clients) session.get(Clients.class, id);
	    
	    //Deleting the student
	    session.delete(ClientToBeDeleted);

	    session.getTransaction().commit();
	    
	    session.close();	    
    }
    public List<Clients> findClientsByConseillerId(int conseillerId){
		String req = "from Clients c where cons_Id="+conseillerId;
		Query q = getSession().createQuery(req);
		List<Clients> res = (List <Clients>) q.list();
		return res;
    }
    public void updateClientsByConseillerId(Clients client){
		
		Session session = sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx = session.beginTransaction();
		
		
			Clients c = (Clients) session.get(Clients.class,client.getClientId());

c.setConseiller(client.getConseiller());

			session.update(c);
			tx.commit();
	}
	catch (Exception e) {
			if (tx!=null) tx.rollback();
			throw e;
	}
	finally {
			session.close();
	}
		
		}
		

	public int findNumberofClientsByConseillerId(int conseillerId){
		String req = "from Clients c where cons_Id="+conseillerId;
		Query q = getSession().createQuery(req);
		List<Clients> res = (List <Clients>) q.list();
		return res.size();
    }

}
