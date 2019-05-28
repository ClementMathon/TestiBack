package com.wha.hbm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.hbm.idao.CompteDAO;
import com.wha.hbm.model.Clients;
import com.wha.hbm.model.Compte;

@Repository
public class CompteDAOImpl implements CompteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final static Logger logger = Logger.getLogger(CompteDAOImpl.class);

	public void addCompte(Compte compte, int id) {
		logger.warn("begin create compte process");
		Session session = sessionFactory.getCurrentSession();
		Clients c = (Clients) session.get(Clients.class, id);
		compte.setClient(c);
		session.persist(compte);	
		logger.debug("end create compte process");
	}

	public void updateCompte(Compte compte) {
		logger.warn("begin update compte process");
		Session session = sessionFactory.getCurrentSession();
		session.merge(compte);
		logger.debug("end update compte process");
	}


	@SuppressWarnings({ "unchecked" })
	public List<Compte> listComptes() {
		Session session = sessionFactory.getCurrentSession();
		List<Compte> ComptesList = session.createQuery("from Compte").list();
		return ComptesList;
	}

	public Compte findCompteById(int id) {
		logger.info("find compte by id");
		Session session = sessionFactory.getCurrentSession();
		Compte compte = (Compte) session.get(Compte.class, new Integer(id));
		return compte;
	}
	
	@SuppressWarnings("unchecked")
	public List<Compte> listComptesByClientId(int id) {
		logger.info("find compte by client id");
		 Session session = sessionFactory.getCurrentSession();
		 List<Compte> comptesList = (List<Compte>) session.createQuery("select co from Compte co where co.client.clientId = :id").setParameter("id", id).list();
		return comptesList;
	 }

}
