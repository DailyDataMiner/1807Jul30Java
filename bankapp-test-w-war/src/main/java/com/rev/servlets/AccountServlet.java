package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Account;
import com.rev.service.AccountService;

@WebServlet("/accounts")
public class AccountServlet extends HttpServlet {

	static AccountService as = new AccountService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Account> accounts = as.getAllAccounts();

		if (accounts.size() > 0) {

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(accounts);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
			
		} else {
			resp.setStatus(404);
		}
	}

}
