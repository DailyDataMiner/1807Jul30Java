package com.ex.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class KorsFilter
 */
public class KorsFilter implements Filter {

    /**
     * Default constructor. 
     */
    public KorsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		System.out.println("Incoming " + httpRequest.getMethod() + " request at " + httpRequest.getRequestURI());
		
		httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS");
		httpResponse.addHeader("Access-Controll-Allow-Headers", "Content-Type");
		
		if (httpRequest.getMethod().equals("Options"))
			httpResponse.setStatus(202);

		//What filters the request servlett
		chain.doFilter(httpRequest, httpResponse);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
