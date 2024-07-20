<%-- 
    Document   : Producto
    Created on : 17/07/2024, 5:23:17 p. m.
    Author     : lauma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Productos</title>
</head>
<body>
    <h1>Gestión de Productos</h1>

    <!-- Formulario para agregar nuevo producto -->
    <form action="ProductoServlet" method="post">
        <input type="hidden" name="action" value="guardar">
        <h2>Nuevo Producto</h2>
        <label>Nombre:</label>
        <input type="text" name="nombre" required>
        <label>Marca:</label>
        <input type="text" name="marca" required>
        <label>Precio:</label>
        <input type="number" step="0.01" name="precio" required>
        <label>Color:</label>
        <input type="text" name="color" required>
        <label>Tipo:</label>
        <input type="text" name="tipo" required>
        <label>Descripción:</label>
        <textarea name="descripcion" required></textarea>
        <button type="submit">Agregar</button>
    </form>

    <!-- Listado de productos existentes -->
    <h2>Listado de Productos</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Marca</th>
            <th>Precio</th>
            <th>Color</th>
            <th>Tipo</th>
            <th>Descripción</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Producto> productos = (List<Producto>) request.getAttribute("productos");
            if (productos != null) {
                for (Producto producto : productos) {
        %>
        <tr>
            <td><%= producto.getId() %></td>
            <td><%= producto.getNombre() %></td>
            <td><%= producto.getMarca() %></td>
            <td><%= producto.getPrecio() %></td>
            <td><%= producto.getColor() %></td>
            <td><%= producto.getTipo() %></td>
            <td><%= producto.getDescripcion() %></td>
            <td>
                <form action="ProductoServlet" method="get" style="display:inline;">
                    <input type="hidden" name="action" value="editar">
                    <input type="hidden" name="id" value="<%= producto.getId() %>">
                    <button type="submit">Editar</button>
                </form>
                <form action="ProductoServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="eliminar">
                    <input type="hidden" name="id" value="<%= producto.getId() %>">
                    <button type="submit" onclick="return confirm('¿Estás seguro de que deseas eliminar este producto?');">Eliminar</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
