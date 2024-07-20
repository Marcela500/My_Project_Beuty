<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contacto - Beautè boutique</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Oswald:wght@400;500;600;700&family=Poppins:wght@400;500;600;700;800&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            text-decoration: none;
            list-style: none;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f2f2f2;
            color: #111111;
            margin: 0;
            padding: 0;
        }

        img {
            max-width: 100%;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        .header {
            display: flex;
            align-items: center;
            min-height: 88vh;
            background-color: #F5F5F5;
            padding: 70px 20px;
            flex-direction: column;
        }

        .menu {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #fff;
            padding: 10px 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }

        .logo {
            font-size: 25px;
            color: #5E456B;
            text-transform: uppercase;
            font-weight: 800;
        }

        .menu .navbar ul li {
            position: relative;
            float: left;
        }

        .menu .navbar ul li a {
            font-size: 18px;
            padding: 10px 20px;
            color: #111111; /* Cambia el color del texto a un color más visible */
            display: block;
        }

        #menu {
            display: none;
        }

        .menu-icono {
            width: 25px;
        }

        .menu label {
            cursor: pointer;
            display: none;
        }

        .navbar {
            display: flex;
        }

        .navbar a {
            color: #111111; /* Cambia el color del texto a un color más visible */
            text-decoration: none;
            padding: 0 15px;
        }

        .contact-info {
            max-width: 800px;
            margin: 120px auto 20px; 
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .contact-info h2 {
            font-size: 2em;
            margin-bottom: 20px;
            text-align: center;
        }

        .contact-info p {
            font-size: 1.2em;
            line-height: 1.6;
            margin-bottom: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <header>
        <div class="menu">
            <div class="logo">Beautè boutique</div>
            <nav class="navbar">
                <a href="index.html">Inicio</a>
                <a href="productos.jsp">Productos</a>
                <a href="contacto.jsp">Contacto</a>
            </nav>
        </div>
    </header>

    <div class="contact-info">
        <h2>Contáctanos</h2>
        <p>Estamos aquí para ayudarte con cualquier pregunta o solicitud que tengas. Puedes contactarnos a través de los siguientes medios:</p>
        <p><strong>Teléfono:</strong> +57 312 2001090</p>
        <p><strong>Correo electrónico:</strong> support@beauteboutique.com</p>
    </div>
</body>
</html>
