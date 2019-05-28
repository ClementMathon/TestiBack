package com.wha.hbm.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.hbm.idao.NotificationDAO;
import com.wha.hbm.model.Clients;
import com.wha.hbm.model.Notification;

@Repository
public class NotificationDAOImpl implements NotificationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final static Logger logger = Logger.getLogger(NotificationDAOImpl.class);
	
	public void newNotification(Notification notification) {
		logger.warn("begin create notification process");
		Session session = sessionFactory.getCurrentSession();
		session.persist(notification);	
		logger.debug("end notification compte process");
	}

	
	public Notification findNotificationById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Notification notification = (Notification) session.get(Notification.class, new Integer(id));
		return notification;
	}

	
	@SuppressWarnings("unchecked")
	public List<Notification> listNotifications() {
		Session session = sessionFactory.getCurrentSession();
		List<Notification> NotificationsList = session.createQuery("from Notification").list();
		return NotificationsList;
	}

	
	public List<Notification> listNotificationsByClientId(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Notification> NotificationsList = (List<Notification>) session.createQuery("select n from Notification t where n.client.clientId = :id").setParameter("id", id).list();
		return NotificationsList;
	}

}
