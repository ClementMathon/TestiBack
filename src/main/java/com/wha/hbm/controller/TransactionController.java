package com.wha.hbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wha.hbm.iservice.TransactionService;
import com.wha.hbm.model.Transaction;

@RestController
@RequestMapping(value="/compte")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "/transactions/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Transaction> getTransactionById (@PathVariable int id) {
		Transaction resultat = transactionService.findTransactionById(id);
		return new ResponseEntity<Transaction>(resultat, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/transactions/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getAllTransactions () {
		List<Transaction> list = transactionService.findAllTransactions();
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/transactions/delete", method = RequestMethod.DELETE)
	public void deleteTransaction (@RequestBody Transaction transaction) {
		 transactionService.deleteTransaction(transaction);
	}
		
	@RequestMapping(value = "/transactions/create", method = RequestMethod.POST)
	public void newTransaction(@RequestBody Transaction transaction) {
		transactionService.createTransaction(transaction);	
	}
}
