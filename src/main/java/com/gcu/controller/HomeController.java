/*
	@Author Alex J. Zoller
*/
package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(path="/delete", method=RequestMethod.GET)
	public ModelAndView deleteModal(@RequestParam("id") int id) {
		return new ModelAndView("deleteProduct", "product", pdb.findById(id));
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.POST)
	public ModelAndView deleteProduct(@RequestParam("id") int id) {
		Product p = pdb.findById(id);
		if (p != null && p.getID() > 0) {
			pdb.delete(p);
		}
		return new ModelAndView("home", "products", pdb.findAll());
	}
	
	@RequestMapping(path="/edit", method=RequestMethod.GET)
	public ModelAndView editModal(@RequestParam("id") int id) {
		return new ModelAndView("editProduct", "product", pdb.findById(id));
	}
	
	@RequestMapping(path="/edit", method=RequestMethod.POST)
	public ModelAndView updateProduct(Product product) {
		if (product.getID() > 0) {
			pdb.update(product);
		}
		return new ModelAndView("home", "products", pdb.findAll());
	}
	
	@RequestMapping(path="/search", method=RequestMethod.GET)
	@ResponseBody
	public List<Product> searchProducts(@RequestParam("query") String query) {
		return  pdb.queryWithString(query);
	}
	
	@RequestMapping(path="/products", method=RequestMethod.GET)
	@ResponseBody
	public List<Product> listProducts() {
		return  pdb.findAll();
	}
}
