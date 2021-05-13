package com.gcu.business;

import com.gcu.database.UserDatabase;
import com.gcu.model.User;

public class LoginService {

	public UserDatabase db = new UserDatabase();

	

	public User loginUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return this.db.loginUser(user);
	}

	public boolean isValidLogin(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return this.db.login(user);
	}
}
