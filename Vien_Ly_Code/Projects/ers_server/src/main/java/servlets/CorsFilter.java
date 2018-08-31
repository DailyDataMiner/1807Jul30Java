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

@WebFilter(filterName="CorsFilter", urlPatterns="*")
public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("cors");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, HEAD, OPTIONS, DELETE");
		httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
		httpResponse.addHeader("Access-Control-Allow-Credentials", "true");

		if (httpRequest.getMethod().equals("OPTIONS")) {
			httpResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}