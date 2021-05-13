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

import com.gcu.database.DataAccessInterface;
import com.gcu.database.ProductDatabase;
import com.gcu.model.Product;

@Controller
public class CreateProductController {
	
	public DataAccessInterface<Product> pdb;
	
	@Autowired
	public void setProductDatabase(DataAccessInterface<Product> service) {
		this.pdb = service; 
	}
	
	@RequestMapping(path = "/createProduct", method = RequestMethod.GET)
	public ModelAndView displayForm() {
		return new ModelAndView("createProduct", "product", new Product());
	}
	
	
	@RequestMapping(path = "/createProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") @Valid Product product, BindingResult result) {
		if (!result.hasErrors()) {
			pdb.create(product);
			return new ModelAndView("home", "products", pdb.findAll());
		}
		return new ModelAndView("createProduct", "product", product);
	}
	

}
