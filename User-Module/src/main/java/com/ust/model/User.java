package com.ust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user-id")
	private int userId;
	@Column(name="user-name")
	@NotNull
	private String username;
	@Column(name="gmail-address")
	@NotNull
	private String gmail;
	@Column(name="user-password")
	@NotNull
	private String Password;
	
	
	public User(int userId, String username, String gmail, String password) {
		this.userId = userId;
		this.username = username;
		this.gmail = gmail;
		Password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}
	
}
