package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ExemploServlet")
public class ExemploServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Meu Servlet</title></head></body>");
		out.print("o email digitado foi: " +email);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexao = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10343527","sql10343527","hAj9EyMSFf");
		
		out.print("Ok para banco de dados");
		
		
		PreparedStatement pst = conexao.prepareStatement("insert into usuario (email) values(?)");
		pst.setString(1, email);
		
		pst.close();
		conexao.close();
		} catch (Exception e ) {
			out.print("Falha no banco de dados");
			e.printStackTrace();
		}
		out.print("<br> Ola, Servlet</body></html>");
}
}
