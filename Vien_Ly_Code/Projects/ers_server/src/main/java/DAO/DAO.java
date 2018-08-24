package DAO;

import java.util.List;

public interface DAO<T> {
	List<T> findAll();

	T findOne(int id);

	boolean insert(T obj);

	boolean update(T obj);

	boolean delete(T obj);
}
