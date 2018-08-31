package DAO;

import java.util.List;

import exceptions.UsernameTakenException;

public interface DAO<T> {
	List<T> findAll();

	T findOne(int id);

	boolean insert(T obj) throws UsernameTakenException;

	boolean update(T obj);

	boolean delete(T obj);
}
