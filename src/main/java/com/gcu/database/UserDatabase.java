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

public class UserDatabase implements DataAccessInterfaceUser {

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

	public boolean login(User t) {
		setDataSource(mysqlDataSource());
		boolean found = false;
		for (User users : findAll()) {
			if (users.getUsername().equals(t.getUsername()) && users.getPassword().equals(t.getPassword())) {
				found = true;
			}
		}
		return found; 
	}
	
	
	public User loginUser(User t) {
		setDataSource(mysqlDataSource());
		User foundUser = new User();
		for (User users : findAll()) {
			if (users.getUsername().equals(t.getUsername()) && users.getPassword().equals(t.getPassword())) {
				foundUser = users;
			}
		}
		return foundUser; 
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
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserMapper());
	}

	/*
	 * Possible outcomes, 0, 1, 2; 0: There were errors with the mySQL connection
	 * and update; 1: The update was successful and new user was inserted; 2: There
	 * was already a user with Username and Email credentials in the database;
	 * 
	 */
	@Override
	public int create(User t) {
		setDataSource(mysqlDataSource());
		// Check if the user already exhists by Email and Username.
		t.setEmail(t.getEmail().toLowerCase());
		for (User users : findAll()) {
			if (users.getUsername().equals(t.getUsername()) && users.getEmail().equals(t.getEmail())) {
				// User already exhists;
				System.out.println("User already exhists.");
				return 2;
			} else {
				// Create the user
				int submit = jdbcTemplate.update("insert into User values (null, ?, ?, ?)", t.getUsername(),
						t.getPassword(), t.getEmail());
				System.out.println(submit);
				System.out.println("User successfully created!");
				return submit;
			}
		}
		return 0;

	}

	@Override
	public boolean update(User t) {
		setDataSource(mysqlDataSource());

		int id = 0;
		User foundUser = new User();
		boolean updated = false;
		String sql = "";
		// Fist we find the users id in the database;
		for (User users : findAll()) {
			if (users.getUsername().equals(t.getUsername()) || users.getPassword().equals(t.getPassword())
					|| users.getEmail().equals(t.getEmail())) {
				id = users.getID();
				foundUser = users;
			}
		}
		// Once found we find out what needs to be updated;
		if (foundUser.getUsername() != t.getUsername()) {
			sql = "update CSUJZvFHVA.User set Username = ? where id = ?";
			jdbcTemplate.update(sql, t.getUsername(), id);
			updated = true;
		}
		if (foundUser.getPassword() != t.getPassword()) {
			sql = "update CSUJZvFHVA.User set Password = ? where id = ?";
			jdbcTemplate.update(sql, t.getPassword(), id);
			updated = true;
		}
		if (foundUser.getEmail() != t.getEmail()) {
			sql = "update CSUJZvFHVA.User set Email = ? where id = ?";
			jdbcTemplate.update(sql, t.getEmail(), id);
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean delete(User t) {
		setDataSource(mysqlDataSource());
		int id = 0;
		// Fist we find the users id in the database;
		for (User users : findAll()) {
			if (users.getUsername().equals(t.getUsername()) && users.getPassword().equals(t.getPassword())
					&& users.getEmail().equals(t.getEmail())) {
				id = users.getID();
			}
		}
		return (jdbcTemplate.update("delete from CSUJZvFHVA.User where id = ?", id) == 1);
	}

}
