/*
	@Author Alex J. Zoller
*/
package com.gcu.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.User;

@Controller
@RequestMapping("/user")
public class RegisterController {
	
	
	@RequestMapping(path = "/register", method = RequestMethod.GET) 
	public ModelAndView displayForm() {
		return new ModelAndView("register", "user", new User());
	}
	
	
	@RequestMapping(path="/confirmUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
		//Here we will check for errors, database and add or check if exhists.
		if(result.hasErrors()) {
			return new ModelAndView("register", "user", user);
		} else {
			return new ModelAndView("confirmUser", "user", user);
		}
	}
	
	

}
