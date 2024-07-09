<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" href="styleslistaUsuarios.css">
</head>
<body>
    <div class="container">
        <!-- Logo de la empresa o título -->
        <h2>Lista de Usuarios</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Correo Electrónico</th>
                    <th>Teléfono</th>
                    <th>Dirección</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%-- Aquí se debe iterar sobre la lista de usuarios y mostrar cada uno --%>
                <%
                    // Suponiendo que tienes una lista de usuarios disponibles en una variable userList
                    // Debes ajustar esto según cómo recuperes y manejes tus datos en Java
                    List<Usuario> userList = (List<Usuario>) request.getAttribute("userList");
                    if (userList != null) {
                        for (Usuario usuario : userList) {
                %>
                <tr>
                    <td><%= usuario.getId() %></td>
                    <td><%= usuario.getNombre() %></td>
                    <td><%= usuario.getCorreoElectronico() %></td>
                    <td><%= usuario.getTelefono() %></td>
                    <td><%= usuario.getDireccion() %></td>
                    <td>
                        <a href="EditarUsuarioServlet?id=<%= usuario.getId() %>">Editar</a>
                        <a href="EliminarUsuarioServlet?id=<%= usuario.getId() %>">Eliminar</a>
                    </td>
                </tr>
                <% 
                        }
                    }
                %>
            </tbody>
        </table>
        <div class="links">
            <a href="registro.jsp" class="register-link">Registrar Nuevo Usuario</a>
            <a href="index.jsp" class="home-link">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
