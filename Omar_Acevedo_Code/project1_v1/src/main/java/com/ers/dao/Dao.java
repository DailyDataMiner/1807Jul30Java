package com.ers.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, I extends Serializable> {
	
	// CRUD Section
	List<T> readAll();
	public void create(T obj);
	public void update(T obj);

}
