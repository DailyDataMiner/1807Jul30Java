package Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.ReimbursementService;
import Services.UserService;

public class MasterDispatcher {
	
	public MasterDispatcher() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("reached here 2");
		System.out.println(req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/LSProject1/login.ng":
			return UserService.login(req, resp);
		case "/LSProject1/userPage.ng":
			System.out.println("reached here 5");
			String input = "";
			try (BufferedReader bf = req.getReader()) {
			input = bf.readLine();
			System.out.println("Input: " + input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ReimbursementService.getAllByAuthor(Integer.parseInt(input));
		case "/LSProject1/userupdateuser.ng":
			return UserService.userUpdateUser(req, resp);
		default:
			return null;
		}
	}
	
}