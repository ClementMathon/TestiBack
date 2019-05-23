package com.wha.hbm.iservice;

import java.util.List;

import com.wha.hbm.model.Compte;
import com.wha.hbm.model.Transaction;

public interface TransactionService {

	public void createTransaction(Transaction transaction);

	public void updateCompte(Transaction transaction);

	public Compte findCompteById(int id);

	public List<Compte> findAllComptes();

}
