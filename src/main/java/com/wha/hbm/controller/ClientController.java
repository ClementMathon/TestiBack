package com.wha.hbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wha.hbm.iservice.ClientService;
import com.wha.hbm.model.Clients;

@Controller
@RequestMapping ("clients")
public class ClientController {

	@Autowired
	ClientService service;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Clients>> findAllClients() {
		List<Clients> resultat = service.findAllClients();
		return new ResponseEntity<List<Clients>>(resultat, HttpStatus.OK);
	}
	@RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
	public ResponseEntity<Clients> findClientById(@PathVariable int id) {
	    Clients resultat = service.findClientById(id);
		return new ResponseEntity<Clients>(resultat, HttpStatus.OK);
	}
	@RequestMapping(value = "/findbyconseillerid/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Clients>> getEmployeeById(@PathVariable int id) {
	    List<Clients> resultat = service.findClientsByConseillerId(id);
		return new ResponseEntity<List<Clients>>(resultat, HttpStatus.OK);
	}
	@RequestMapping(value = "/createclient", method = RequestMethod.POST)
	public void createClient(@RequestBody Clients cli)
	{
	    service.saveClient(cli);
	  
	}
	@RequestMapping(value = "/updateclient", method = RequestMethod.POST)
	public void updateClient(@RequestBody Clients cli)
	{
	    service.updateClient(cli);

	}
	@RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.GET)
	public void deleteClientById(@PathVariable int id) {
	    service.deleteClientById(id);	
	}
	
	
	
	
}
