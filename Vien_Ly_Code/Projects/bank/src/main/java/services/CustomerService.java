package services;

import beans.Customer;
import dao.CustomerDAO;
import dao.DAO;
import exceptions.UsernameNotAvailableException;

public class CustomerService {
	static DAO<Customer, Integer> custDAO = new CustomerDAO();
	
	public Customer save(Customer acc) {
		return custDAO.save(acc);
	}
	
	public Customer findOne(String username) {
		return ((CustomerDAO) custDAO).findOne(username);
	}
}