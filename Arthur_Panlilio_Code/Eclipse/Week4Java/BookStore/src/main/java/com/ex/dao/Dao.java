package com.ex.dao;


import java.util.List;

public interface Dao<T, I>{
	
	List<T> findAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		return true;
	}

}
