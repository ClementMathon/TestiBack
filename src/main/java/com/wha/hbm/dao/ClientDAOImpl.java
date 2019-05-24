package com.wha.hbm.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.hbm.idao.ClientDAO;
import com.wha.hbm.model.Client;
import com.wha.hbm.model.Conseiller;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addClient(Client client) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(client);
		
	}

	public void removeClient(Client client) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(client);
		
	}

	public Client findClient(int id) {
		Session session = sessionFactory.getCurrentSession();
		Client client = (Client) session.get(Client.class, new Integer(id));
		return client;
	}

	public void updateClient(Client client) {
		Session session = sessionFactory.getCurrentSession();
		session.update(client);
		
	}

	public List<Client> listeClient() {
		Session session = sessionFactory.getCurrentSession();
		List<Client> clientListe = session.createQuery("from Client").list();
		return clientListe;
	}


	public List<Client> listeClientByConseiller(Conseiller conseiller) {
		Session session = sessionFactory.getCurrentSession();
		
		List<Client> clientListe = session.createQuery("from Client where Conseiller = ?1").setParameter(1, conseiller).list();
		
		return clientListe;
	}

	public List<Client> NumberClientByConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return null;
	}

	public void AffectConseiller(Client client, Conseiller conseiller) {
		// TODO Auto-generated method stub
		
	}

}
