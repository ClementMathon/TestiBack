package com.wha.hbm.controller;

import java.util.List;

import com.wha.hbm.model.Conseillers;
import com.wha.hbm.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/conseiller")

public class ConseillersController {

    @Autowired
    private ConseillerService conseillersService;

    @RequestMapping(value = "/conseillers", method = RequestMethod.GET)
    public List<Conseillers> listConseillers() {
        
        return conseillersService.listConseillers();
    }
  
	
    @RequestMapping(value = "/conseillers/{id}", method = RequestMethod.GET)
    public Conseillers getConseillersById(@PathVariable int id) {

        return conseillersService.getConseillersById(id);
    }
    
    @RequestMapping(value = "/conseillersdelete/{id}", method = RequestMethod.PUT)
    public void removeConseillers(@PathVariable int id) {

        conseillersService.removeConseillers(id);
    }
 
    @RequestMapping(value = "/conseillersadd", method = RequestMethod.POST)
    
    public void addConseillers(@RequestBody Conseillers conseiller) {
       conseillersService.addConseillers(conseiller);
    
    }

    @RequestMapping(value = "/conseillersupdate", method = RequestMethod.POST)
    public void updateConseiller(@RequestBody Conseillers conseiller) {

      conseillersService.updateConseillers(conseiller);
    }

    // Same method For both Add and Update Employee

}