<%-- 
    Document   : edit
    Created on : 15 jul 2023, 11:56:42
    Author     : Alex
--%>

<%@page import="modelo.Persona"%>
<%@page import="modeloDao.PersonaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% PersonaDao dao = new PersonaDao();
            int id = Integer.parseInt((String) request.getAttribute("idper"));
            Persona p = (Persona) dao.list(id);
        %>
        <h1>Editar Persona</h1>
        <form action="Controlador">
            DNI:
            <input type="text" name ="txtDni" value="<%=p.getDni()%>"><br>
            Nombres:
            <input type="text" name ="txtNom"value="<%=p.getNom()%>"><br>
            <input type ="hidden" name ="txtid" value="<%=p.getId()%>">   
            <input type="submit" name ="accion" value="Actualizar">
            <a href="Controlador?accion=listar">Regresar</a>
        </form>
    </body>
</html>
