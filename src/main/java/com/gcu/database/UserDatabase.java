/*
	@Author Alex J. Zoller
*/
package com.gcu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gcu.model.User;

public class UserDatabase {
	
	private DatabaseConnection connection = new DatabaseConnection();
	
	private String dbURL = connection.getDBURL();
	private final String username = connection.getUSERNAME();
	private final String password = connection.getPASSWORD();
	
	private Connection c = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs;
	
	
	public boolean createUser(User user) {
		boolean created = false;
		try {
			
			c = DriverManager.getConnection(dbURL, username, password);
			if (!checkIfUserExhists(user.getEmail())) {
				pstmt = c.prepareStatement("insert into CSUJZvFHVA.User values (null, ?, ?, ?)");
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getEmail().toLowerCase());
				System.out.println("Rows effected: " + pstmt.executeUpdate());
				created = true;
			} else {
				created = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return created;
	}
	
	private boolean checkIfUserExhists(String userEmail) {
		boolean foundUser = false;
		try {
			c = DriverManager.getConnection(dbURL, username, password);
			pstmt = c.prepareStatement("SELECT * FROM CSUJZvFHVA.User WHERE Email = ?");
			pstmt.setString(1, userEmail);
			ResultSet r = pstmt.executeQuery();
			if (r.next()) {
				foundUser = true;
				System.out.println("User already exhists with the email: " + userEmail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return foundUser;
	}
	

}
