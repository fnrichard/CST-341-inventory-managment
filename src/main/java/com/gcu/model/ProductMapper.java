/*
	@Author Alex J. Zoller
*/
package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int num) throws SQLException {
		Product product = new Product();
		product.setID(rs.getInt("ID"));
		product.setProductName(rs.getString("ProductName"));
		product.setProductCost(rs.getFloat("ProductCost"));
		product.setProductAmount(rs.getInt("ProductAmount"));
		product.setProductDescription(rs.getString("ProductDescription"));
		return product;
	}

}
