package com.wha.hbm.idao;

import java.util.List;

import com.wha.hbm.model.Notification;



public interface NotificationDAO {
	
	public void newNotification(Notification notification);
	   
    public Notification findNotificationById(int id);
   
    public List<Notification> listNotifications();
    
    public List<Notification> listNotificationsByClientId(int id);

}
