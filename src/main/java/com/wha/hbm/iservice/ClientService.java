package com.wha.hbm.iservice;

import java.util.List;

import com.wha.hbm.model.Clients;



public interface ClientService {
    // Crud
    void saveClient(Clients client);
    //cRud
    List<Clients> findAllClients();
    Clients findClientById(int id);
    //crUd
    void updateClient(Clients client);
    //cruD
    void deleteClientById (int id);

    // autres methodes
    List<Clients> findClientsByConseillerId(int conseillerID);
    public int findNumberofClientsByConseillerId(int conseillerId); 
}
