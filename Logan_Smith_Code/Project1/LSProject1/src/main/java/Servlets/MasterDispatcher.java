package Servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.ReimbursementService;
import Services.UserService;

public class MasterDispatcher {
	
	public MasterDispatcher() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("reached here 2");
		System.out.println(req.getRequestURI());
		/*HttpSession session = req.getSession(false);
		if (!req.getRequestURI().equals("/LSProject1/login.ng") && session.getAttribute("User") == null) {
			System.out.println("session: " + session.getId());
			return null;
		}*/
		switch (req.getRequestURI()) {
		case "/LSProject1/login.ng":
			return UserService.login(req, resp);
		case "/LSProject1/userPage.ng":
			System.out.println("reached here 5");
			return ReimbursementService.servletGetAllByAuthor(req, resp);
		case "/LSProject1/userupdateuser.ng":
			return UserService.userUpdateUser(req, resp);
		case "/LSProject1/newReimb.ng":
			return ReimbursementService.createUserReimb(req, resp);
		case "/LSProject1/adminPage.ng":
			return ReimbursementService.getAll();
		case "/LSProject1/updateReimb.ng":
			return ReimbursementService.approveReimb(req, resp);
		case "/LSProject1/getAssociates.ng":
			return UserService.getAssociates();
		case "/LSProject1/promoteAssociate.ng":
			return UserService.promoteUser(req, resp);
		case "/LSProject1/addUser.ng":
			return UserService.addUser(req, resp);
		case "/LSProject1/checkLogin.ng":
			return UserService.checkLogin(req, resp);
		default:
			return null;
		}
	}
	
}