package com.wha.hbm.idao;

import java.util.List;

import com.wha.hbm.model.Client;
import com.wha.hbm.model.Conseiller;

public interface ClientDAO {

	
	public void addClient(Client client);
	public void removeClient(Client client);
	public Client findClient(int id);
	public void updateClient(Client client);
	
	public List<Client> listeClient();
	public List<Client> listeClientByConseiller(Conseiller conseiller);
	public List<Client> NumberClientByConseiller(Conseiller conseiller);
	
	public void AffectConseiller(Client client, Conseiller conseiller);
	
}
