<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="styleseditarUsuario.css">
</head>
<body>
    <div class="container">
        <!-- Logo de la empresa o título -->
        <h2>Editar Usuario</h2>
        <form id="editUserForm" action="ActualizarUsuarioServlet" method="post">
            <%-- Recibe el ID del usuario a editar desde el servlet --%>
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
            <div class="input-group">
                <label for="name">Nombre</label>
                <input type="text" id="name" name="name" value="<%= request.getParameter("nombre") %>" required>
            </div>
            <div class="input-group">
                <label for="email">Correo electrónico</label>
                <input type="email" id="email" name="email" value="<%= request.getParameter("email") %>" required>
            </div>
            <div class="input-group">
                <label for="phone">Teléfono</label>
                <input type="tel" id="phone" name="phone" value="<%= request.getParameter("telefono") %>" required>
            </div>
            <div class="input-group">
                <label for="address">Dirección</label>
                <input type="text" id="address" name="address" value="<%= request.getParameter("direccion") %>" required>
            </div>
            <button type="submit">Actualizar Usuario</button>
            <div class="links">
                <a href="listaUsuarios.jsp" class="cancel-link">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>
