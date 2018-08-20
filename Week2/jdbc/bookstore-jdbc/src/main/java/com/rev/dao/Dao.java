package com.rev.dao;

import java.util.List;

import java.io.Serializable;

public interface Dao <T, I extends Serializable> {
	List<T> findAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		return true;
	}
	
	
}
