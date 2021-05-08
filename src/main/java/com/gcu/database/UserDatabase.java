/*
	@Author Alex J. Zoller
*/
package com.gcu.database;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.gcu.model.User;
import com.gcu.model.UserMapper;

public class UserDatabase implements DataAccessInterface<User>{

	
	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbc = new DatabaseConnection();
	
	
	public UserDatabase() {
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
	
	
	
	public User userAmount() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM User", User.class);
	}
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM CSUJZvFHVA.User";
		users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}

	@Override
	public User findById(int id) {
		String sql = "SELECT * FROM CSUJZvFHVA.User where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new UserMapper());
	}

	@Override
	public boolean create(User t) {
		setDataSource(mysqlDataSource());
		int submit = jdbcTemplate.update("insert into User values (null, ?, ?, ?)", t.getUsername(), t.getPassword(), t.getEmail());
		System.out.println(submit);
		return (submit == 1);
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	


	

}
