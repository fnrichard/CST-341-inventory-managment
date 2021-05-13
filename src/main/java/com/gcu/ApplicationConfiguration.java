/*
	@Author Alex J. Zoller
*/
package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.controller.LoginController;
import com.gcu.controller.RegisterController;
import com.gcu.database.ProductDatabase;
import com.gcu.database.UserDatabase;

@Configuration
public class ApplicationConfiguration {

	@Bean(name="loginController")
	public LoginController getLoginController() {
		return new LoginController();
	}
	
	@Bean(name="registerController")
	public RegisterController getRegisterController() {
		return new RegisterController();
	}
	
	@Bean(name="userDatabase")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserDatabase getUserDatabase() {
		return new UserDatabase();
	}
	
	@Bean(name="productDatabase")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ProductDatabase getProductDatabase() {
		return new ProductDatabase();
	}
	
}
