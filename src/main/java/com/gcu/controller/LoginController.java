/**
 * Author: Richard Williamson
 */
package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.User;

import com.gcu.business.LoginService;
import com.gcu.main.Cashe;

@Controller
public class LoginController {
	
	
	private LoginService service = new LoginService();
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView displayForm() {
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model) {
		if (this.service.isValidLogin(username, password)) {
			Cashe.loggedUser = this.service.loginUser(username, password);
			return new ModelAndView("MainLanding", "user", this.service.loginUser(username, password));
		} else {
			User user = new User();
			user.setUsername(username);
			return new ModelAndView("login", "user", user);
		}
	}
}
