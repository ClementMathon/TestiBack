package com.wha.hbm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wha.hbm.idao.ClientDao;
import com.wha.hbm.model.Clients;


@Repository("employeeDao")
public class ClientDAOImpl extends AbstractDao implements ClientDao {

   
    public void saveClient(Clients client) {
	getSession().save(client);
    }
    
    public List<Clients> findAllClients() {
	String req = "from Clients c";
	Query q = getSession().createQuery(req);
	List<Clients> res = (List <Clients>) q.list();
	return res;
    }

    public Clients findClientById(int id) {
	return (Clients) getSession().get(Clients.class, id);
	
    }

    
    
    public void updateClient(Clients client) {
	getSession().saveOrUpdate(client);
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
	return null;
    }


}
