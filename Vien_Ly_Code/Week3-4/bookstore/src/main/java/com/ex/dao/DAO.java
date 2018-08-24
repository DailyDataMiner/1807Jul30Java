package com.ex.dao;

import java.util.List;

import com.ex.pojos.Book;

import java.io.Serializable;

public interface DAO<T, I extends Serializable> {
	List<T> getAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	default boolean isUnique(T obj) {
		return true;
	}
}
