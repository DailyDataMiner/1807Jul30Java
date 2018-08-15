package com.rev.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, I extends Serializable> {
	List<T> findAll();
	T findOneID(T obj);
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	T insert(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		return true;
		
		
	}
}