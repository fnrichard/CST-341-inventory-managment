/*
	@Author Alex J. Zoller
*/
package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	private int ID;
	
	@NotNull(message = "username cannot be null") @Size(min=2,max=50,message="username must be between 2 and 50 chars")
	private String username;
	
	@NotNull(message = "password cannot be null") @Size(min=2,max=50,message="password must be between 2 and 50 chars")
	private String password;
	
	@NotNull(message = "Email cannot be null") @Size(min=2,max=50,message="Please submit a valid email")
	private String email;
	
	public User() {}
	
	
	public User(int ID, String username, String password, String email) {
		super();
		this.ID = ID;
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	


	

}