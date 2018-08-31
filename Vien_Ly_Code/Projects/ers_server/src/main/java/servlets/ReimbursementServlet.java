package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Reimbursement;
import beans.ReimbursementStatus;
import beans.ReimbursementType;
import beans.User;
import beans.UserRole;
import services.ReimbursementService;
import servlets.models.ReimbursementUpdateData;

@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ObjectMapper mapper = new ObjectMapper();
	ReimbursementService reimbursementService = new ReimbursementService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		// we'll return in order of most general to most specific
		// if 2 different params are specified, the most general param will be processed
		String authorParam = req.getParameter("author");
		String statusParam = req.getParameter("status");
		String typeParam = req.getParameter("type");
		String idParam = req.getParameter("id");

		HttpSession session = req.getSession(false);
		User actor = (User) session.getAttribute("user");

		if (authorParam != null) {
			if (((User) session.getAttribute("user")).getUsername().equals(authorParam)
					|| actor.getRole() == UserRole.MANAGER) {
				reimbursements = reimbursementService.findByAuthor(authorParam);
				if (reimbursements.size() == 0) {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
					mapper.writeValue(resp.getWriter(), "not found");
					return;
				}
			} else {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				mapper.writeValue(resp.getWriter(), "Not authorized to make this request");
				return;
			}
		} else if (statusParam != null) {
			try {
				ReimbursementStatus status = ReimbursementStatus.valueOf(statusParam.toUpperCase());
				reimbursements = reimbursementService.findByStatus(status);
				if (reimbursements.size() == 0) {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
					mapper.writeValue(resp.getWriter(), "not found");
					return;
				}
				if (actor.getRole() != UserRole.MANAGER && reimbursements.get(0).getAuthorId() != actor.getId()) {
					resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					mapper.writeValue(resp.getWriter(), "Not authorized to make this request");
					return;
				}
			} catch (IllegalArgumentException e) {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				mapper.writeValue(resp.getWriter(), "No such status");
				return;
			}

		} else if (typeParam != null) {
			try {
				ReimbursementType type = ReimbursementType.valueOf(typeParam.toUpperCase());
				reimbursements = reimbursementService.findByType(type);
				if (reimbursements.size() == 0) {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
					mapper.writeValue(resp.getWriter(), "not found");
					return;
				}
				if (actor.getRole() != UserRole.MANAGER && reimbursements.get(0).getAuthorId() != actor.getId()) {
					resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					mapper.writeValue(resp.getWriter(), "requires admin credentials");
					return;
				}
			} catch (IllegalArgumentException e) {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				mapper.writeValue(resp.getWriter(), "no such type");
				return;
			}

		} else if (idParam != null) {
			Reimbursement ri = reimbursementService.findOne(Integer.parseInt(idParam));
			if (ri == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				mapper.writeValue(resp.getWriter(), "not found");
				return;
			}
			if (actor.getRole() != UserRole.MANAGER && ri.getAuthorId() != actor.getId()) {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				mapper.writeValue(resp.getWriter(), "authorization required");
				return;
			}
			resp.setContentType("application/json");
			mapper.writeValue(resp.getWriter(), ri);
			return;
		} else { // no params, get all
			reimbursements = reimbursementService.findAll();
			if (reimbursements.size() == 0) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				mapper.writeValue(resp.getWriter(), "not found");
				return;
			}
			if (actor.getRole() != UserRole.MANAGER && reimbursements.get(0).getAuthorId() != actor.getId()) {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				mapper.writeValue(resp.getWriter(), "auth required");
				return;
			}
		}

		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), reimbursements);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("posting");
		HttpSession session = req.getSession(false);
		User actor = (User) session.getAttribute("user");

		Reimbursement ri = mapper.readValue(req.getReader(), Reimbursement.class);

		ri.setAuthorId(actor.getId());
		ri.setSubmittedTime(new Timestamp(System.currentTimeMillis()));
		ri.setStatus(ReimbursementStatus.PENDING);

		if (!reimbursementService.createReimbursement(ri)) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			mapper.writeValue(resp.getWriter(), "unexpected server error");
			return;
		}
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), ri);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User actor = (User) session.getAttribute("user");
		ReimbursementUpdateData editData = mapper.readValue(req.getReader(), ReimbursementUpdateData.class);
		Reimbursement ri = reimbursementService.findOne(editData.getId());

		if (ri == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "not found");
			return;
		}

		if (ri.getAuthorId() != 0 && ri.getAuthorId() != actor.getId() && actor.getRole() != UserRole.MANAGER) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			mapper.writeValue(resp.getWriter(), "auth required");
			return;
		}

		if (ri.getStatus() != ReimbursementStatus.PENDING) { // can only change pending statuses
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			mapper.writeValue(resp.getWriter(), "cannot edit resolved requests");
			return;
		}
		ri.setAmount(editData.getAmount());
		ri.setDescription(editData.getDescription());
		ri.setType(editData.getType());

		if (ri.getAuthorId() != 0 && ri.getAuthorId() != actor.getId()) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			mapper.writeValue(resp.getWriter(), "unauthorized");
			return;
		}

		reimbursementService.updateReimbursement(ri);
		resp.setContentType("application/json");
		mapper.writeValue(resp.getWriter(), ri);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String idParam = req.getParameter("id");
		if (idParam == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "not found");
			return;
		}
		int id = Integer.parseInt(idParam);
		User actor = (User) session.getAttribute("user");
		Reimbursement ri = reimbursementService.findOne(id);

		if (ri == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			mapper.writeValue(resp.getWriter(), "not found");
			return;
		}

		if (actor.getRole() != UserRole.MANAGER && ri.getAuthorId() != actor.getId()) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			mapper.writeValue(resp.getWriter(), "unauthorized");
			return;
		}

		reimbursementService.deleteReimbursement(ri);
		resp.setContentType("application/json");
		resp.getWriter().write("Successfully deleted");
		mapper.writeValue(resp.getWriter(), ri);
	}
}
