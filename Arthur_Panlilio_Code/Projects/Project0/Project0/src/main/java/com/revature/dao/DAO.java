package com.revature.dao;

import java.util.List;

public interface DAO<T, I> {
	
	
	/**
	 * Finds all objects of that type in database
	 * 
	 * @return a list of objects
	 */
	List<T> findAll();
	
	/**
	 * Adds object to database
	 * 
	 * @param t is the object to be saved
	 * @return the object
	 */
	T save(T t);

}
