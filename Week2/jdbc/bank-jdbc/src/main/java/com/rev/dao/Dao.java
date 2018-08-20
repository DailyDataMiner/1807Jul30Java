package com.rev.dao;

import java.util.List;

import com.rev.pojos.MoneyAccount;
import com.rev.pojos.UserClient;

import java.io.Serializable;

public interface Dao <T, I extends Serializable> {
	List<T> findAll();
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	//void delete(T obj);
	default boolean isUnique(String str) {
		return true;
	}
	
}
