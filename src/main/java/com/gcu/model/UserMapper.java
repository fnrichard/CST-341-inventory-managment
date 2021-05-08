/*
	@Author Alex J. Zoller
*/
package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setID(rs.getInt("ID"));
		user.setUsername(rs.getString("Username"));
		user.setPassword(rs.getString("Password"));
		user.setEmail(rs.getString("Email"));
		return user;
	}

}
