<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.luremesoftware.adme.constantes.Constante"%>   
<%@ page import="com.luremesoftware.adme.modelo.Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>PERFIL DE USUARIO</h1>

<a href="NuevoGrupo.jsp">Crear nuevo grupo</a> 
<br></br>

<a href="NuevaPublicacion.jsp">Crear nueva publicación</a>
<br></br>

<a href="Busca.jsp">Realizar busqueda</a>
<br></br>
<a href="Logout.jsp">Logout</a>
<br></br>
<%

response.getWriter().println("Bienvenido: ");

		%>
</body>
</html>