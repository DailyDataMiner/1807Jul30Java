package com.ers.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, I extends Serializable> {
	List<T> findAll();
}
