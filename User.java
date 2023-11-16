package com.regis_login.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String pass;
	
	public String getUsername() {
		return username;
	}
	public User(Long id, String username, String pass) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User() {
        // Default constructor
    }
}
