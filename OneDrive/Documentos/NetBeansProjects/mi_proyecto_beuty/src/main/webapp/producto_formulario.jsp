<%-- 
    Document   : producto_formulario
    Created on : 17/07/2024, 5:31:48 p. m.
    Author     : lauma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Producto</title>
</head>
<body>
    <h1>${producto.id == null ? 'Nuevo Producto' : 'Editar Producto'}</h1>

    <form action="ProductoServlet" method="post">
        <c:if test="${producto.id != null}">
            <input type="hidden" name="action" value="actualizar">
            <input type="hidden" name="id" value="${producto.id}">
        </c:if>
        <c:if test="${producto.id == null}">
            <input type="hidden" name="action" value="guardar">
        </c:if>
        <label>Nombre:</label>
        <input type="text" name="nombre" value="${producto.nombre}" required>
        <label>Marca:</label>
        <input type="text" name="marca" value="${producto.marca}" required>
        <label>Precio:</label>
        <input type="number" step="0.01" name="precio" value="${producto.precio}" required>
        <label>Color:</label>
        <input type="text" name="color" value="${producto.color}" required>
        <label>Tipo:</label>
        <input type="text" name="tipo" value="${producto.tipo}" required>
        <label>Descripción:</label>
        <textarea name="descripcion" required>${producto.descripcion}</textarea>
        <button type="submit">${producto.id == null ? 'Agregar' : 'Actualizar'}</button>
    </form>
</body>
</html>
