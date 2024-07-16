<%-- 
    Document   : login
    Created on : 11/07/2024, 5:04:33 p. m.
    Author     : lauma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
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
        input[type="password"],
        input[type="checkbox"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

        .remember-me {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }

        .remember-me label {
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

        .recuperarcontraseña-link {
            text-align: center;
            color: #007bff; /* Azul */
            text-decoration: none;
            display: block; 
            margin-top: 10px; 
        }

        .recuperarcontraseña-link:hover {
            text-decoration: underline;
        }

        .or {
            text-align: center;
            margin-bottom: 10px;
            color: #555;
        }

        .social-icons {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .social-icons a {
            margin: 0 10px;
        }

        .social-icons img {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            cursor: pointer;
        }

        .social-icons img:hover {
            opacity: 0.8;
        }

        .access-message-yellow {
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
            color: #FFD700; /* Amarillo */
        }

        .no-account {
            text-align: center;
            color: #000; /* Negro */
            margin-top: 20px; 
        }

        .register-link {
            text-align: center;
            color: #007bff; /* Azul */
            text-decoration: none;
            display: block; 
            margin-top: 10px; 
        }

        .register-link:hover {
            text-decoration: underline;
        }

        
        @media (max-width: 600px) {
            .container {
                margin: 20px;
                padding: 15px;
            }

            h2 {
                font-size: 20px;
            }

            input[type="text"],
            input[type="password"],
            input[type="checkbox"] {
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
        <form id="loginForm" action="LoginServlet" method="POST">
            <h2>Iniciar Sesión</h2>
            <div class="input-group">
                <label for="email">Correo electrónico o Teléfono</label>
                <input type="text" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-group">
                <input type="checkbox" id="rememberMe" name="rememberMe">
                <label for="rememberMe">Recuérdame</label>
            </div>
            <button type="submit">Iniciar Sesión</button>
            <div class="links">
               <a href="recuperarContraseña.jsp" class="recuperarcontraseña-link">¿Olvidaste tu contraseña?</a>
                <p class="or">o inicia con</p>
                <div class="social-icons">
                    <a href="#"><img src="images/google.png" alt="Google"></a>
                    <a href="#"><img src="images/facebook.png" alt="Facebook"></a>
                    <a href="#"><img src="images/twitter.png" alt="Twitter"></a>
                </div>
                <!-- Sección "¿No tienes una cuenta?" y "Regístrate" -->
                <p class="no-account">¿No tienes una cuenta?</p>
                <a href="registro.jsp" class="register-link">Regístrate</a>
            </div>
        </form>
    </div>
</body>
</html>

