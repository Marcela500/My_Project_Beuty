<%-- 
    Document   : registroexitoso
    Created on : 16/07/2024, 4:46:17 p. m.
    Author     : lauma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro Exitoso</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 400px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .logo {
            display: block;
            margin: 0 auto 20px auto;
            width: 150px;
        }

        h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }

        p {
            font-size: 16px;
            color: green;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Estilos adicionales para pantallas pequeñas */
        @media (max-width: 600px) {
            .container {
                margin: 20px;
                padding: 15px;
            }

            h2 {
                font-size: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <img src="images/logo cuadrado.png" alt="Logo de la empresa" class="logo">
        <h2>Registro Exitoso</h2>
        <p>Usuario registrado correctamente.</p>
        <p><a href="login.jsp">Iniciar sesión</a></p>
    </div>
</body>
</html>

