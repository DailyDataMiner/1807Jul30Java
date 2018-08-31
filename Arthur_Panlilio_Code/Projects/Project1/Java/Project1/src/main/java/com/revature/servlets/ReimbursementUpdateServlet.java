package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

@WebServlet("/reimbursementUpdate")
public class ReimbursementUpdateServlet extends HttpServlet {
	
	ReimbursementService rService = new ReimbursementService();
	private static Logger log = Logger.getLogger(ReimbursementUpdateServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("in the post of ReimbursementUpdateServlet");
		ObjectMapper mapper = new ObjectMapper();
		reUpdateInfo info = mapper.readValue(req.getReader(), reUpdateInfo.class);
		LocalDate now = LocalDate.now();
		rService.update(info.getId(), info.getrId(), info.getStatus(),now , info.getResponse());
	}
	
	static class reUpdateInfo{
		
		private int id;
		private int rId;
		private int status;
		private String response;
		
		public reUpdateInfo() {
			
		}
		
		public reUpdateInfo(int id, int rId, int status, String response) {
			super();
			this.id = id;
			this.rId = rId;
			this.status = status;
			this.response = response;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getrId() {
			return rId;
		}

		public void setrId(int rId) {
			this.rId = rId;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		@Override
		public String toString() {
			return "reUpdateInfo [id=" + id + ", rId=" + rId + ", status=" + status + ", response=" + response + "]";
		}
		
		
	}

}
