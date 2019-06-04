package com.wha.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.hbm.idao.ClientDao;
import com.wha.hbm.iservice.ClientService;
import com.wha.hbm.model.Clients;
import com.wha.hbm.model.Conseillers;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {
    
    @Autowired
    private ClientDao dao;
    
    public void saveClient(Clients client) {
	dao.saveClient(client);
    }
    public List<Clients> findAllClients() {
	return dao.findAllClients();
    }
   
    public List<Clients> findAllClientswithoutconseiller() {
	return dao.findAllClientswithoutconseiller();
    }
    public Clients findClientById(int id){
	return dao.findClientById(id);
    }
    public void updateClient(Clients client) {
	dao.updateClient(client);
    }
    public void deleteClientById(int id){
	dao.deleteClientById(id);
    }
    public List<Clients> findClientsByConseillerId(int conseillerId){
	return dao.findClientsByConseillerId(conseillerId);
    }
    public int findNumberofClientsByConseillerId(int conseillerId){
    return dao.findNumberofClientsByConseillerId(conseillerId);
    
    }
public void updateClientsByConseillerId(Clients client){

      dao.updateClientsByConseillerId(client);
    
    }
}

