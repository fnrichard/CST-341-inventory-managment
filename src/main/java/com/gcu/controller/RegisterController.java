/*
	@Author Alex J. Zoller
*/
package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.database.DataAccessInterfaceUser;
import com.gcu.model.Product;
import com.gcu.model.User;

@Controller
@RequestMapping("/user")
public class RegisterController {

	public DataAccessInterfaceUser udb;
	
	@Autowired
	public void setUserDatabase(DataAccessInterfaceUser service) {
		this.udb = service;
	}
	
	

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView displayForm() {
		return new ModelAndView("register", "user", new User());
	}

	@RequestMapping(path = "/confirmUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
		// Here we will check for errors, database and add or check if exhists.
		if (!result.hasErrors()) {
			System.out.println("Before:");
			switch (udb.create(user)) {
			case 0:
				return new ModelAndView("register", "user", user);
			case 1:
				return new ModelAndView("confirmUser", "user", user);
			case 2:
				return new ModelAndView("register", "user", user);
			default:
				return new ModelAndView("register", "user", user);
			}
		}
		return new ModelAndView("register", "user", user);

	}

}
