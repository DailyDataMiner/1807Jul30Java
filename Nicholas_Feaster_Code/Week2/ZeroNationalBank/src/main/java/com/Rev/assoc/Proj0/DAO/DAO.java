package com.Rev.assoc.Proj0.DAO;

import java.io.Serializable;

public interface DAO<T, I extends Serializable>  {
	T findOne(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
}
