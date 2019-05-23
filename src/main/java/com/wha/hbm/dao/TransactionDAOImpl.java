package com.wha.hbm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.hbm.idao.TransactionDAO;
import com.wha.hbm.model.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void newTransaction (Transaction transaction) {
		Session session = sessionFactory.getCurrentSession();
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

}
