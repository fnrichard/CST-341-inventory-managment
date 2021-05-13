/*
	@Author Alex J. Zoller
*/
package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.database.DataAccessInterface;
import com.gcu.database.ProductDatabase;
import com.gcu.model.Product;

@Controller
public class HomeController {
	
public DataAccessInterface<Product> pdb;
	
	@Autowired
	public void setProductDatabase(DataAccessInterface<Product> service) {
		this.pdb = service; 
	}
	
	@RequestMapping(path="/home", method=RequestMethod.GET)
	public ModelAndView displayForm() {
		return new ModelAndView("home", "products", pdb.findAll());
	}
	
	
	
	

}
