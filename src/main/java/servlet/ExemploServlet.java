package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ExemploServlet")
public class ExemploServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4909965054032768806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Meu Servlet</title></head></body>");
		out.print("o email digitado foi: " +email);
		
		
		out.print("<br> Ola, Servlet</body></html>");
}
}
