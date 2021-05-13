/*
	@Author Alex J. Zoller
*/
package com.gcu.database;

import java.util.List;

import com.gcu.model.User;

public interface DataAccessInterfaceUser {
	
	public List<User> findAll();
	public User findById(int id);
	public int create(User t);
	public boolean update(User t);
	public boolean delete(User t);
	public boolean login(User t);
	public User loginUser(User t);

}
