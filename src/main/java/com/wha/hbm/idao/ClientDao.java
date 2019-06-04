package com.wha.hbm.idao;

import java.util.List;

import com.wha.hbm.model.Clients;
import com.wha.hbm.model.Conseillers;

public interface ClientDao {
    
    void saveClient(Clients client);

    List<Clients> findAllClients();

    Clients findClientById(int id);
    
    void updateClient (Clients client);
    
    void deleteClientById(int id);

    public List<Clients> findClientsByConseillerId(int conseillerId);
    public int findNumberofClientsByConseillerId(int conseillerId);
    public List<Clients> findAllClientswithoutconseiller();
      public void updateClientsByConseillerId(Clients client);
}
