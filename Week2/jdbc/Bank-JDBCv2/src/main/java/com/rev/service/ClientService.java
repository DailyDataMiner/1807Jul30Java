package com.rev.service;

import java.util.List;

import com.rev.dao.ClientDao;
import com.rev.pojo.Client;

public class ClientService {

	static ClientDao cDao = new ClientDao();
	
	public boolean verifyClient(String cl1, String cl2) {
		return cDao.verify(cl1, cl2);
	}
	
	public boolean isOnly(String usr) {
		return cDao.verify(usr);
	}
	
	public Client add(Client cli) {
		return cDao.addClient(cli);
	}
	
	public Client pullAccount(String usr, String pwd) {
		return cDao.checkAcc(usr, pwd);
	}
	
	public void nuke(int id) {
		cDao.delete(id);
	}
	
}