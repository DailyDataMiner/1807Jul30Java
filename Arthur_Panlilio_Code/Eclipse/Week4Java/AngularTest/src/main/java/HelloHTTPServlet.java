

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloHTTPServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("In HTTP SERVLET INIT");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("In HTTP SERVLET DESTROY");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp)
					throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		System.out.println("In hTTP SERVLET DO GET()");
		resp.setContentType("text/html");
		
		//servlet config is any configuration detail about this particular servlet  
		String info = getServletConfig().getInitParameter("info");
		out.write("<h1> Hello <b>Genesis</b> ! </h1>"
				+ "<br> Random init params: <i>" + info + "</i>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = resp.getWriter();
		out.write("In HTTPSERVLET POST METHOD() hi postman >:/^)");
	}

}
