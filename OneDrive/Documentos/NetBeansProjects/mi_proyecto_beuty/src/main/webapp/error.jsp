<%-- 
    Document   : error
    Created on : 11/07/2024, 6:22:40 p. m.
    Author     : lauma
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
        }
        h1 {
            color: #ff0000;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Ocurrió un error</h1>
        <p><strong>Código de estado:</strong> ${statusCode}</p>
        <p><strong>Nombre del servlet:</strong> ${servletName}</p>
        <p><strong>URI de la solicitud:</strong> ${requestUri}</p>
        <p><strong>Mensaje del error:</strong> ${throwable.message}</p>
        <p>Por favor, intenta de nuevo más tarde o contacta al administrador del sistema.</p>
    </div>
</body>
</html>
