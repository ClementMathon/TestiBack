package com.wha.hbm.iservice;

import java.util.List;

import com.wha.hbm.model.Notification;

public interface NotificationService {
	
	public void createNotification(Notification notification);

	public Notification findNotificationById(int id);

	public List<Notification> findAllNotifications();
	
	public List<Notification> findAllNotificationsByClientId(int id);

}
