/*
	@Author Alex J. Zoller
*/
package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Product {
	
	
	private int ID;
	@NotNull(message = "Product name cannot be null") @Size(min=2,max=50,message="Product name must be between 2 and 50 chars")
	private String productName;
	@NotNull(message = "Product cost cannot be null") @Range(min=1,max=50,message="Product cost must be between 1 and 50 chars")
	private float productCost;
	@NotNull(message = "Product amount cannot be null") @Range(min=0,max=1000,message="Product amount must be between 1 and 1000 chars")
	private int productAmount;
	@NotNull(message = "Product description cannot be null") @Size(min=1,max=1000,message="Product description must be between 1 and 1000 chars")
	private String productDescription;
	
	
	public Product() {}
	
	public Product(int iD, String productName, float productCost, int productAmount, String productDescription) {
		super();
		ID = iD;
		this.productName = productName;
		this.productCost = productCost;
		this.productAmount = productAmount;
		this.productDescription = productDescription;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductCost() {
		return productCost;
	}

	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	
	

}
