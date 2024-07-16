<%-- 
    Document   : registro
    Created on : 11/07/2024, 5:10:45 p. m.
    Author     : lauma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
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
        }

        .logo {
            display: block;
            margin: 0 auto 20px auto;
            width: 150px;
        }

        form {
            margin-top: 20px;
        }

        h2 {
            font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
            color: #333;
        }

        .input-group {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="checkbox"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

        .terms {
            display: flex;
            align-items: center;
        }

        .terms label {
            margin-left: 5px;
            font-weight: normal;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #0056b3;
        }

        .links {
            margin-top: 15px;
        }

        .already-have-account {
            text-align: center;
            color: #000;
        }

        .already-have-account a {
            color: #007bff;
            text-decoration: none;
        }

        .already-have-account a:hover {
            text-decoration: underline;
        }

        /* Mensajes de error y éxito */
        .error-message {
            color: red;
            font-size: 14px;
            margin-top: -15px;
            margin-bottom: 15px;
        }

        .success-message {
            color: green;
            font-size: 14px;
            margin-top: -15px;
            margin-bottom: 15px;
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

            input[type="text"],
            input[type="email"],
            input[type="tel"],
            input[type="checkbox"],
            input[type="password"] {
                padding: 8px;
            }

            button {
                padding: 8px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Logo de la empresa -->
        <img src="images/logo cuadrado.png" alt="Logo de la empresa" class="logo">
        <form id="registerForm" action="RegistrarUsuarioServlet" method="POST">
            <h2>Regístrate</h2>
            <div class="input-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div class="input-group">
                <label for="correo">Correo electrónico</label>
                <input type="email" id="correo" name="correo" required>
            </div>
            <div class="input-group">
                <label for="telefono">Teléfono</label>
                <input type="tel" id="telefono" name="telefono" required>
            </div>
            <div class="input-group">
                <label for="direccion">Dirección</label>
                <input type="text" id="direccion" name="direccion" required>
            </div>
            <div class="input-group terms">
                <input type="checkbox" id="terms" required>
                <label for="terms">Acepto los términos y condiciones</label>
            </div>
            <button type="submit">Registrarse</button>
            <div class="links">
                <p class="already-have-account">¿Ya tienes una cuenta? <a href="login.jsp">Inicia sesión</a></p>
            </div>
        </form>
    </div>
</body>
</html>
