package Servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import POJOs.UserInformation;
import Services.UserService;

public class MasterDispatcher {

	public MasterDispatcher() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserInformation process(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getRequestURI()) {
		case "/ServletTester2/login.ng":
			System.out.println("Broken");
			return UserService.login(req, resp);
		default:
			return null;
		}
	}
	
}
