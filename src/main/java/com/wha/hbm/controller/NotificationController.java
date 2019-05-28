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

import com.wha.hbm.iservice.NotificationService;
import com.wha.hbm.model.Notification;

@RestController
@RequestMapping(value="/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Notification> getNotificationById (@PathVariable int id) {
		Notification resultat = notificationService.findNotificationById(id);
		return new ResponseEntity<Notification>(resultat, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Notification>> getAllTransactions () {
		List<Notification> list = notificationService.findAllNotifications();
		return new ResponseEntity<List<Notification>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void newNotification(@RequestBody Notification notification) {
		notificationService.createNotification(notification);	
	}
	
	@RequestMapping(value = "/findAllNotificationsByClientId/{clientId}", method = RequestMethod.GET)
	public ResponseEntity<List<Notification>> getNotificationsByCompteId(@PathVariable int clientId) {
	    List<Notification> resultat = notificationService.findAllNotificationsByClientId(clientId);
		return new ResponseEntity<List<Notification>>(resultat, HttpStatus.OK);
	} 

}
