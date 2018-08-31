package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Reimbursement;
import beans.User;
import beans.UserRole;
import services.ReimbursementService;
import servlets.models.ReimbursementResolveData;

@WebServlet("/reimbursements/resolve")
public class ResolveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ObjectMapper mapper = new ObjectMapper();
	ReimbursementService reimbursementService = new ReimbursementService();

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User actor = (User) session.getAttribute("user");
		if (actor.getRole() != UserRole.MANAGER) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			mapper.writeValue(resp.getWriter(), "Must be an admin");
			return;
		}

		ReimbursementResolveData resolveData = mapper.readValue(req.getReader(), ReimbursementResolveData.class);
		Reimbursement ri = reimbursementService.findOne(resolveData.getId());

		reimbursementService.resolve(ri, actor.getId(), resolveData);
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), ri);
	}

}
