package com.bank.daos;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, I extends Serializable> {
	
	T create(T obj);
	
	T read(I id);
	
	T update(T obj);
	
	void delete(T obj);
	
	List<T> findAll();
	
	default boolean isUnique(T obj) {
		return true;
	}
	
}
