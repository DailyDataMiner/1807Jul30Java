package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.ReimbursementDetails;
import services.ReimbursementService;

@WebServlet("/reimbursements/details")
public class ReimbursementDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ReimbursementService reimbursementService = new ReimbursementService();
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in details servlet");
		String idParam = req.getParameter("id");

		if (idParam == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			mapper.writeValue(resp.getWriter(), "id required");
			return;
		}

		int id = Integer.parseInt(idParam);
		System.out.println(id);
		ReimbursementDetails rid = reimbursementService.getDetails(id);
		System.out.println(rid);
		if (rid == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "not found");
			return;
		}
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), rid);
	}
}
