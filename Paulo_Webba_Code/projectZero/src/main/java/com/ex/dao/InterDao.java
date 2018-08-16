package com.ex.dao;

import java.io.Serializable;
import java.util.List;

public interface InterDao <T,I extends Serializable> {
       
	 T findOne(I id);
	   List <T> findAll();
	   T save(T obj);
	   T update(T obj);
	   void delete(T obj);
	   default boolean isUnique(T obj) {
		   return true;
	   }
}
