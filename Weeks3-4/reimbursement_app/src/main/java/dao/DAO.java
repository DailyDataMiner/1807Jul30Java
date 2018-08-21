package dao;

import java.util.List;

import java.io.Serializable;

public interface DAO<T, I extends Serializable> {
	List<T> getAll();
	T findOne(T obj);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	//TODO which methods to use???
//	default boolean isUnique(T obj) {
//		return true;
//	}
}