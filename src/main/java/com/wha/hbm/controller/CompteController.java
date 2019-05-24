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

import com.wha.hbm.iservice.CompteService;
import com.wha.hbm.model.Clients;
import com.wha.hbm.model.Compte;



@RestController
@RequestMapping(value="/compte")
public class CompteController {

	@Autowired
	private CompteService compteService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Compte> getCompteById (@PathVariable int id) {
		Compte resultat = compteService.findCompteById(id); 
		return new ResponseEntity<Compte>(resultat, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Compte>> getAllComptes () {
		List<Compte> list = compteService.findAllComptes();
		return new ResponseEntity<List<Compte>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateCompte (@RequestBody Compte compte) {
		 compteService.updateCompte(compte);
	}
		
	@RequestMapping(value = "/create/{idClient}", method = RequestMethod.POST)
	public void createCompte(@RequestBody Compte cpt, @PathVariable int idClient) {
		compteService.createCompte(cpt, idClient);	
	}
	
	@RequestMapping(value = "/findAllComptesByClientId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Compte>> getComptesByClientId(@PathVariable int id) {
	    List<Compte> resultat = compteService.findComptesByClientId(id);
		return new ResponseEntity<List<Compte>>(resultat, HttpStatus.OK);
	}
}
