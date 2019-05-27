package com.wha.hbm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.hbm.idao.TransactionDAO;
import com.wha.hbm.model.Compte;
import com.wha.hbm.model.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void newTransaction(Transaction transaction, int id) { // méthode qui permet d'enregistrer une nouvelle
																	// transaction dans la BDD, de modifier le solde du
																	// compte correspondant et de mettre à jour dans la
																	// BDD
		Session session = sessionFactory.getCurrentSession();
		Compte c = (Compte) session.get(Compte.class, id);
		float solde = c.getCompteSolde();
		int typeTransaction = transaction.getTypeTransaction();
		float montant = transaction.getMontantTransaction();
		if (typeTransaction == 1) { // 1= depot sur le compte
			solde += montant;
		} else if (typeTransaction == 2) { // 2= retrait sur le compte
			solde -= montant;
		}
		c.setCompteSolde(solde);
		session.saveOrUpdate(c);
		transaction.setCompte(c);
		session.persist(transaction);
	}

	public Transaction findTransactionById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = (Transaction) session.get(Transaction.class, new Integer(id));
		return transaction;
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> listTransactions() {
		Session session = sessionFactory.getCurrentSession();
		List<Transaction> TransactionsList = session.createQuery("from Transaction").list();
		return TransactionsList;
	}

	public void deleteTransaction(Transaction transaction) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(transaction);
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> listTransactionsByCompteId(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Transaction> transactionsList = (List<Transaction>) session
				.createQuery("select t from Transaction t where t.compte.compteId = :id").setParameter("id", id).list();
		return transactionsList;
	}

}
