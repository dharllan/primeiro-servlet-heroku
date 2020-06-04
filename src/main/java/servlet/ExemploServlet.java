package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import modelo.Usuario;

@WebServlet(urlPatterns = "/ExemploServlet")
public class ExemploServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4909965054032768806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();
		
		String email = req.getParameter("email");
		String acao = req.getParameter("acao");
		
		usuario.setEmail(email);
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Meu Servlet</title></head></body>");
		if (email != null)
		out.print("o email digitado foi: "+usuario.getEmail());
		
		if (acao.equals("incluir")) {
			if ( dao.incluir(usuario)) {
				
				out.print("Usuario inserido com sucesso");		
		}
		
		}
		
		if (acao.equals("atualizar")) {
			usuario.setId(Integer.parseInt(req.getParameter("id")));
			if ( dao.atualizar(usuario)) {
				
				out.print("Usuario atualizado com sucesso");
			}
			}
		if(acao.equals("excluir")) {
			usuario.setId(Integer.parseInt(req.getParameter("id")));
			if( dao.excluir(usuario)) {
				out.print("Usuario excluido com sucesso !");
				
			}
				
		}
				
		out.print("<br> Ola, Servlet</body></html>");
}
}
