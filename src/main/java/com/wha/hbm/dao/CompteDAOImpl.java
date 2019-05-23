package com.wha.hbm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.hbm.idao.CompteDAO;
import com.wha.hbm.model.Compte;

@Repository
public class CompteDAOImpl implements CompteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCompte(Compte compte) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(compte);
	}

	public void updateCompte(Compte compte) {
		Session session = sessionFactory.getCurrentSession();
		session.update(compte);
	}

	@SuppressWarnings({ "unchecked" })
	public List<Compte> listComptes() {
		Session session = sessionFactory.getCurrentSession();
		List<Compte> ComptesList = session.createQuery("from Compte").list();
		return ComptesList;
	}

	public Compte findCompteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Compte compte = (Compte) session.get(Compte.class, new Integer(id));
		return compte;
	}

}
