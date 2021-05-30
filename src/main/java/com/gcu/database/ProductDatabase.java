/*
	@Author Alex J. Zoller
*/
package com.gcu.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.gcu.model.Product;
import com.gcu.model.ProductMapper;

public class ProductDatabase implements DataAccessInterface<Product> {

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbc = new DatabaseConnection();

	public ProductDatabase() {
		setDataSource(mysqlDataSource());
	}

	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(dbc.getDBURL());
		dataSource.setUsername(dbc.getNAME());
		dataSource.setPassword(dbc.getPASSWORD());

		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Product> findAll() {
		setDataSource(mysqlDataSource());
		return jdbcTemplate.query("SELECT * FROM CSUJZvFHVA.Product", new ProductMapper());
	}

	@Override
	public Product findById(int id) {
		for (Product products : findAll()) {
			if (products.getID() == id)
				return products;
		}
		return null;
	}

	@Override
	public boolean create(Product t) {
		setDataSource(mysqlDataSource());
		return (jdbcTemplate.update("insert into Product values (null, ?, ?, ?, ?)", t.getProductName(),
				t.getProductCost(), t.getProductAmount(), t.getProductDescription()) == 1);
	}

	@Override
	public boolean update(Product t) {
		Product compare = findById(t.getID());
		int changes = 0;
		if (!compare.getProductName().equals(t.getProductName()))
			changes =  (jdbcTemplate.update("update CSUJZvFHVA.Product set ProductName = ? where id = ?", t.getProductName(), t.getID()));
		if (compare.getProductCost() != t.getProductCost())
			changes = (jdbcTemplate.update("update CSUJZvFHVA.Product set ProductCost = ? where id = ?", t.getProductCost(), t.getID()));
		if (compare.getProductAmount() != t.getProductAmount())
			changes = (jdbcTemplate.update("update CSUJZvFHVA.Product set ProductAmount = ? where id = ?",
					t.getProductAmount(), t.getID()));
		if (!compare.getProductDescription().equals(t.getProductDescription()))
			changes = (jdbcTemplate.update("update CSUJZvFHVA.Product set ProductDescription = ? where id = ?",
					t.getProductDescription(),
					t.getID()));
		return changes > 1;
	}

	@Override
	public boolean delete(Product t) {
		return (jdbcTemplate.update("delete from CSUJZvFHVA.Product where id = ?", t.getID()) == 1);
	}

	// written by Richard Williamson
	@Override
	public List<Product> queryWithString(String query) {
		setDataSource(mysqlDataSource());
		// I don't like this but not sure how to avoid sql injection
        String sql = "SELECT * FROM CSUJZvFHVA.Product where productDescription like '%" + query + "%' or productName like '%" + query + "%'";
        return jdbcTemplate.query(sql, new ProductMapper());
	}
}

