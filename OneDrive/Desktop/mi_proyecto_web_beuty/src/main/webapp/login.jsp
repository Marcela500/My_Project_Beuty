<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="stylesinicioseccion.css">
</head>
<body>
    <div class="container">
        <!-- Logo de la empresa -->
        <img src="images/logo_cuadrado.png" alt="Logo de la empresa" class="logo">
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
                <a href="#" class="forgot-password">¿Olvidaste tu contraseña?</a>
                <p class="or">o inicia con</p>
                <div class="social-icons">
                    <a href="#"><img src="images/google.png" alt="Google"></a>
                    <a href="#"><img src="images/facebook.png" alt="Facebook"></a>
                    <a href="#"><img src="images/twitter.png" alt="Twitter"></a>
                </div>
                <!-- Sección "¿No tienes una cuenta?" y "Regístrate" -->
                <p class="no-account">¿No tienes una cuenta?</p>
                <!-- Ajusta la ruta de registro.jsp según la estructura de tu proyecto -->
                <a href="registro.jsp" class="register-link">Regístrate</a>
            </div>
        </form>
    </div>
    <script src="script.js"></script>
</body>
</html>
