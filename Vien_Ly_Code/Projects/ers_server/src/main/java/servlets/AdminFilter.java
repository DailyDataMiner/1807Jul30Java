package servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;
import beans.UserRole;

@WebFilter(filterName = "AdminFilter", urlPatterns = { "/home/admin/*" })
public class AdminFilter implements Filter {
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("admin");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			mapper.writeValue(resp.getWriter(), "login required");
			return;
		} else {
			if (((User) session.getAttribute("user")).getRole() != UserRole.MANAGER) {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				mapper.writeValue(resp.getWriter(), "admin required");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
