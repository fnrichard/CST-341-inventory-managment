package com.gcu.database;

import java.util.List;

public interface DataAccessInterface <T> 
{
	public List<T> findAll();
	public List<T> queryWithString(String query);
	public T findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}

