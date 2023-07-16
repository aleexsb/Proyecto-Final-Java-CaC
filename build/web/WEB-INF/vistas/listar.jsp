<%-- 
    Document   : listar
    Created on : 15 jul 2023, 11:09:25
    Author     : Alex
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
        <h1>Personas</h1>
        <a href="Controlador?accion=add">Agregar Nuevo</a>
        <table border="1"> //CTRL + ESPACIO + TABLE
            <thead>
                <tr>
                    <th>ID</th>
                    <th>DNI</th>
                    <th>NOMBRES</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <%
                PersonaDao dao = new PersonaDao();
                List<Persona> list = dao.listar();
                Iterator<Persona> iter = list.iterator();
                Persona per = null;
                
                while(iter.hasNext()) {               
                    per = iter.next();                                          
                %>
            <tbody>
                <tr>
                    <td><%= per.getId()%></td> //%= ES JAVA DE UNA SOLA LINEA
                    <td><%= per.getDni()%></td>
                    <td><%= per.getNom()%></td>
                    <td>
                        <a>Editar</a>
                        <a>Eliminar</a>   
                    </td>
                </tr>
            </tbody>
            <%}%>
        </table>

    </body>
</html>
