<%-- 
    Document   : recuperarContraseña
    Created on : 11/07/2024, 7:09:48 p. m.
    Author     : lauma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recuperar Contraseña</title>
    <style>
        /* Estilos CSS aquí */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 5px;
        }
        h2 {
            color: #333333;
            font-family: 'Arial', sans-serif;
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            text-align: center;
            margin-top: 20px;
        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type=submit] {
            background-color: #5E456B;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type=submit]:hover {
            background-color: #5E456B;
        }
        .error {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Recuperar Contraseña</h2>
        
        <%
            String action = request.getParameter("action");
            if (action == null) {
        %>
        <!-- Formulario para ingresar el correo electrónico -->
        <form action="recuperarContraseña.jsp?action=enviarCodigo" method="POST">
            <label for="email">Ingrese su correo electrónico:</label><br>
            <input type="text" id="email" name="email" required><br><br>
            <input type="submit" value="Enviar Código">
        </form>
        
        <%
            } else if (action.equals("enviarCodigo")) {
                // Lógica para enviar el código por correo electrónico y guardar en sesión
                String email = request.getParameter("email");
                // Generar un código aleatorio (aquí uso un número aleatorio simple, puedes implementar algo más robusto)
                java.util.Random random = new java.util.Random();
                int codigo = random.nextInt(900000) + 100000; // Código de 6 dígitos
                // Aquí deberías enviar el código por correo electrónico al usuario
                // Puedes implementar esta funcionalidad utilizando librerías como JavaMail API
                // Guardar el código en la sesión para validar después
                session.setAttribute("codigoRecuperacion", codigo);
                session.setAttribute("emailRecuperacion", email);
        %>
        
        <!-- Formulario para ingresar el código recibido -->
        <form action="recuperarContraseña.jsp?action=validarCodigo" method="POST">
            <label for="codigo">Ingrese el código recibido:</label><br>
            <input type="text" id="codigo" name="codigo" required><br><br>
            <input type="submit" value="Validar Código">
        </form>
        
        <%
            } else if (action.equals("validarCodigo")) {
                // Lógica para validar el código ingresado por el usuario
                int codigoRecibido = Integer.parseInt(request.getParameter("codigo"));
                int codigoGuardado = (Integer) session.getAttribute("codigoRecuperacion");
                if (codigoRecibido == codigoGuardado) {
        %>
        
        <!-- Formulario para establecer una nueva contraseña -->
        <form action="ServletDeNuevaContraseña" method="POST"> <!-- Necesitarás un servlet para manejar la nueva contraseña -->
            <label for="password">Nueva Contraseña:</label><br>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Guardar Contraseña">
        </form>
        
        <%
                } else {
        %>
        
        <p class="error">El código ingresado es incorrecto. Por favor, inténtelo nuevamente.</p>
        <form action="recuperarContraseña.jsp?action=validarCodigo" method="POST">
            <label for="codigo">Ingrese el código recibido:</label><br>
            <input type="text" id="codigo" name="codigo" required><br><br>
            <input type="submit" value="Validar Código">
        </form>
        
        <%
                }
            }
        %>
    </div>
</body>
</html>
