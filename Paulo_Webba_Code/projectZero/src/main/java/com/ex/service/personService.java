package com.ex.service;

import java.util.List;

import com.ex.dao.InterDao;
import com.ex.dao.PersonDao;
import com.ex.pojos.Person;

public class personService {
	 static InterDao<Person, Integer> pDao = new PersonDao();
	   public Person newClient(){
		   Person p  = new Person();
			return pDao.save(p);
		}
	public List<Person> getAll() {
		return pDao.findAll();
	}
}
