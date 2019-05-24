package com.wha.hbm.iservice;

import java.util.List;

import com.wha.hbm.model.Transaction;

public interface TransactionService {

	public void createTransaction(Transaction transaction, int id);

	public void deleteTransaction(Transaction transaction);

	public Transaction findTransactionById(int id);

	public List<Transaction> findAllTransactions();
	
	public List<Transaction> findAllTransactionsByCompteId(int id);

}
