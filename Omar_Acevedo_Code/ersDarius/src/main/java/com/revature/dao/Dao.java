package com.revature.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, I extends Serializable> {
	
	List<T> getAll();
	T findPw(T obj);
	T findOne(I id);
	T findOne(T obj);
	T insert(T obj);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		return true;
	}

	
}
