package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.database.ProductDatabase;

@Controller
public class HomeController {
	
	ProductDatabase pdb = new ProductDatabase();
	
	@RequestMapping(path="/home", method=RequestMethod.GET)
	public ModelAndView displayForm() {
		System.out.println("Hello! " + pdb.findAll().size());
		return new ModelAndView("home", "products", pdb.findAll());
	}
	
	
	
	

}
