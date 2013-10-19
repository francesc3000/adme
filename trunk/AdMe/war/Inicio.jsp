<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="com.luremesoftware.adme.controlador.ControladorWeb"%>
<%@ page import="com.luremesoftware.adme.modelo.Usuario"%>
<%@ page import="com.luremesoftware.adme.modelo.Publi"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>AdMe!</title>

<link rel="stylesheet" type="text/css" href="Inicio.css">

<div align="right">

	<form name="acceder" method="post" action="Inicio.jsp?env=1">

		<button type="submit" class="login-button">Acceder</button>

	</form>

</div>
</head>
<body>


	<%
		if ((request.getParameter("env") !=null)) {


			ControladorWeb cw = new ControladorWeb();

			Usuario login = cw.acceder(request, response);

			if (login.getNombre() != null) {

				session.setAttribute("user", login.getNombre());
				response.sendRedirect("Perfil.jsp");
			} else {
				response.sendRedirect("Registro.jsp");

				if (login.getNombre() == null) {
					session.setAttribute("userMail", login.getCorreo());
					response.sendRedirect("Registro.jsp");
				} else {
					session.setAttribute("user", login);
					response.sendRedirect("Perfil.jsp");
				}

			}

		}
	%>


	<div>
		<br>
		<br>
		<br>
		<br>

		<div id="menu">
			<img src="../img/adme.png"></img>
		</div>

		<div id="centro">

			<form name="acceder" method="post" action="Inicio.jsp?env=2">
				<input type="text" size="65"></input> <br>
				<br>

				<p>
					<label for="ciudad">Ciudad:</label> <select name="ciudad">
						<option value="Barcelona">Barcelona
						<option value="Sevilla">Sevilla
						<option value="Tarragona">Tarragona
						<option value="Cuenca">Cuenca
						<option value="Zaragoza">Zaragoza
						<option value="Madrid">Madrid
					</select> &nbsp; &nbsp; &nbsp; <input class="buscar" type="submit"
						value="Buscar"></input>

				</p>

			</form>

		</div>
		<div id="pie">By LuremeSoftware</div>
</body>
</html>
