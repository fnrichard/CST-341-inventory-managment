/*
	@Author Alex J. Zoller
*/
package com.gcu.main;

import org.springframework.stereotype.Controller;

import com.gcu.model.User;

@Controller
public class Cashe {
	
	public static User loggedUser = new User(0, "Not Logged In", "", "");

	public static void clearUser() {
		loggedUser = new User(0, "Not Logged In", "", "");
	}
	
	public static User getLoggedUser() {
		return loggedUser;
	}

	public static void setLoggedUser(User loggedUser) {
		Cashe.loggedUser = loggedUser;
	}
	
	

}
