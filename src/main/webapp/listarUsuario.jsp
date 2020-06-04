<%@page import="dao.UsuarioDao"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<html>
<body>
<head>
<meta charset="UTF-8">
<title>Listar Usuario</title>
<h2>Listar Usuario</h2>
<table>
<tr><td>id</td><td>E-mail</td></tr>
<%
UsuarioDao dao = new UsuarioDao();
List<Usuario> lsUsuarios = dao.listar();
for (Usuario u : lsUsuarios){
	
out.print("<tr><td>" + u.getId()+"</td><td>" + u.getEmail() + "</td>"+ "<td> <a href='index.jsp?id=" 
+ u.getId() + "' >Editar</a></td>");
%>

<td><a onclick= "return confirm('Deseja realmente excluir esse registro ?')" href='ExemploServlet?acao=excluir&id=<%= u.getId()%>'>Excluir</a></td>

<% out.print("</tr>");

}

%>
</table>
</body>
</html>
