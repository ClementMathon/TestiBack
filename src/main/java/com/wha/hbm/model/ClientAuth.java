package com.wha.hbm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "clientAuth")
	public class ClientAuth {

	@Id
	@Column(name = "clientAuth_id")
	private int clientAuthId;

	@Column(name = "client_username")
	private String username;

	@Column(name = "clientpasword")
	private String password;

}
