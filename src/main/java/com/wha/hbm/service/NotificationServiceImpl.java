package com.wha.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.hbm.idao.NotificationDAO;
import com.wha.hbm.iservice.NotificationService;
import com.wha.hbm.model.Notification;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
    private NotificationDAO notificationDAO;

	 public void setNotificationDAO(NotificationDAO notificationDAO) {
	        this.notificationDAO = notificationDAO;
	    }
	
	public void createNotification(Notification notification) {
		notificationDAO.newNotification(notification);
	}


	public Notification findNotificationById(int id) {
		return this.notificationDAO.findNotificationById(id);
	}


	public List<Notification> findAllNotifications() {
		return this.notificationDAO.listNotifications();
	}

	
	public List<Notification> findAllNotificationsByClientId(int id) {
		return this.notificationDAO.listNotificationsByClientId(id);
	}

}
