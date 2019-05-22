package com.wha.hbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wha.hbm.iservice.CompteService;
import com.wha.hbm.model.Compte;



@RestController
@RequestMapping(value="/compte")
public class CompteController {

	@Autowired
	private CompteService compteService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Compte> getCompteById (@PathVariable int id) {
		Compte resultat = compteService.findCompteById(id);
		return new ResponseEntity<Compte>(resultat, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Compte>> getAllComptes () {
		List<Compte> list = compteService.findAllComptes();
		return new ResponseEntity<List<Compte>>(list, HttpStatus.OK);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<Compte> updateCompte (@RequestBody Compte compte) {
		Compte resultat = compteService.updateCompte(compte);
		return new ResponseEntity<Compte>(resultat, HttpStatus.OK);
	}
		
	@PostMapping(value="/create")
	public Compte createCompte(@RequestBody Compte cpt) {
		compteService.createCompte(cpt);
		return cpt;
	}
}
