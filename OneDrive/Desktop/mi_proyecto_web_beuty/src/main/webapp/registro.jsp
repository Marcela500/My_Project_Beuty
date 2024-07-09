<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="stylesheet" href="stylesregistro.css">
</head>
<body>
    <div class="container">
        <!-- Logo de la empresa -->
        <img src="images/logo_cuadrado.png" alt="Logo de la empresa" class="logo">
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
                <p class="already-have-account">¿Ya tienes una cuenta? <a href="inicioseccion.jsp">Inicia sesión</a></p>
            </div>
        </form>
    </div>
</body>
</html>
