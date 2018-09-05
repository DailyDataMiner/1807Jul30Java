package com.rev.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.UsersDao;
import com.rev.pojos.Users;

public class UsersService {

	static ArrayList<Users> many = new ArrayList<Users>();

//	//another way to pull info by Usersname
//	public Users getByUsersname(String Usersname) {
//		Users u = many.stream().filter(x -> x.getUsersname().equals(Usersname)).findAny().orElse(null);
//		return u;
//	}

	private static UsersDao uDao = new UsersDao();

	// 1. Read the Request body (JSON, and set it to the 'json' String variable
	// 2. Using the Object Mapper, map the json into an object of type Users
	// 3. Perform rest of logic that requires a Users POJO

	public static Users login(HttpServletRequest req, HttpServletResponse res) {
		ObjectMapper mapper = new ObjectMapper();
		Users rec = null;

		try {
			rec = mapper.readValue(req.getReader(), Users.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Users authorized = uDao.checkAcc(rec.getUsername());
		System.out.println(authorized.getPassword() + " " + authorized.getUsername());
		if (authorized.getUsername() == null) {
			return null;
		}
		if (uDao.checkAcc(rec.getUsername()).getPassword().equals(rec.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("userinfo", uDao.checkAcc(rec.getUsername()));

			return uDao.checkAcc(rec.getUsername());
		} else
			return null;
	}

	public static Object logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return null;
	}
	
	public static Object sessionCheck(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		return session.getAttribute("userinfo");
	}

	public Users getAccInfo(String username) {
		return uDao.checkAcc(username);
	}
}
