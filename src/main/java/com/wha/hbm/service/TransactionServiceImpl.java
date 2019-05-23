package com.wha.hbm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wha.hbm.idao.TransactionDAO;
import com.wha.hbm.iservice.TransactionService;
import com.wha.hbm.model.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
    private TransactionDAO transactionDAO;
 
    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }
	
	public void createTransaction(Transaction transaction) {
		transactionDAO.newTransaction(transaction);
	}

	public void deleteTransaction(Transaction transaction) {
		transactionDAO.deleteTransaction(transaction);
	}

	public Transaction findTransactionById(int id) {
		return this.transactionDAO.findTransactionById(id);
	}

	public List<Transaction> findAllTransactions() {
		return this.transactionDAO.listTransactions();
	}

}
