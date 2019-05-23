package com.wha.hbm.idao;

import java.util.List;

import com.wha.hbm.model.Transaction;

public interface TransactionDAO {
	
	public void newTransaction(Transaction transaction);
   
    public Transaction findTransactionById(int id);
   
    public List<Transaction> listTransactions();
    
    public void deleteTransaction(Transaction transaction);
}
