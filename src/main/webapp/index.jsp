<%@page import="dao.UsuarioDao"%>
<%@page import="modelo.Usuario"%>
<html>
<body>
		<h3>Digite seu e-mail:</h3>
		<%
			String id = request.getParameter("id");
		    String acao = "incluir";
			Usuario u = new Usuario();
			if (id != null) {
				out.println("id identificado :" + id);
				UsuarioDao dao = new UsuarioDao();
				u = dao.getUsuario(id);
				acao= "atualizar";

			}
		%>
		<form action="ExemploServlet" method="get">
		<input type="hidden" name="acao" value="<%out.print(acao);%>">
		<input type="hidden" name="id" value="<%out.print(u.getId());%>">
		<input type="text" name="email" value="<%out.print(u.getEmail());%>"><br>
		<input type="submit">

	</form>
	<a href='listarUsuario.jsp'>Listar</a>
</body>
</html>
