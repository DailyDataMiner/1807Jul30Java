package com.revature.project0.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, I extends Serializable> {

	List<T> findAll();
	T findOne(I id);
	T save(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		return true;
	}
}
