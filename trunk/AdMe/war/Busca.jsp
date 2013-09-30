<%-- 
    Document   : index
    Created on : 29/04/2013, 01:14:48
    Author     : cfgs
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.luremesoftware.adme.controlador.ControladorWeb" %>
<%@ page import="com.luremesoftware.adme.modelo.Usuario" %>
<%@ page import="com.luremesoftware.adme.modelo.Publi" %>

<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            input, textarea {   
                padding: 9px;  
                border: solid 1px #E5E5E5;  
                outline: 0;  
                font: normal 13px/100% Verdana, Tahoma, sans-serif;  
                width: 200px;  
                background: #FFFFFF;  
            }  

            textarea {   
                width: 400px;  
                max-width: 400px;  
                height: 150px;  
                line-height: 150%;  
            }  

            input:hover, textarea:hover,  
            input:focus, textarea:focus {   
                border-color: #C9C9C9;   
            }  

            .form label {   
                margin-left: 10px;   
                color: #999999;   
            }  

            .submit input {  
                width: auto;  
                padding: 9px 15px;  
                background: #617798;  
                border: 0;  
                font-size: 12px;  
                color: #888;  
            }  
        </style>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>




    </head>
    <body>

        <h1>BUSQUEDA DE PUBLICACIONES</h1>

        
           <%
            int ok = 1;
            if (!(request.getParameter("env") == null)) {

                String nom = request.getParameter("txtNom");
            

                if (nom.equals("")) {
                    out.print("Falta omplir el camp nom <br>");
                    ok = 0;
                }


                if (ok == 1) {
                    
                    Usuario usu = new Usuario(nom);
			
                    ControladorWeb cw = new ControladorWeb();
                                  
                    Usuario result_u = cw.getUsuario(usu);
                    
                    out.print(result_u.getNombre());
                    
                }
            }
        %>

        
       
        <form name="formulario" method="post" action="Busca.jsp?env=1">
            <h4>Busca:</h4>
            <input type="text" name="txtNom" value="<%if (!(request.getParameter("env") == null)) {
                    out.print(request.getParameter("txtNom"));
                }%>">

            <br>
            	<select name="ciudad">
			<option value="Barcelona">Barcelona
			<option value="Sevilla">Sevilla
			<option value="Tarragona">Tarragona
			<option value="Barcelona">Barcelona
			<option value="Sevilla">Sevilla
			<option value="Tarragona">Tarragona
			<option value="Barcelona">Barcelona
			<option value="Sevilla">Sevilla
			<option value="Tarragona">Tarragona
			<option value="Barcelona">Barcelona
			<option value="Sevilla">Sevilla
			<option value="Tarragona">Tarragona
			<option value="Barcelona">Barcelona
			<option value="Sevilla">Sevilla
			<option value="Tarragona">Tarragona		
		</select>
           <br> 
            
            <input type="submit" value="Buscar"> 

        </form> 


<br>
<br>

<table border="2" WIDTH="80%">
<tr>

<td>HOLA</td>

<td>HOLA</td>

<td>HOLA</td>

</tr>


</table>
     
    </body>
</html>