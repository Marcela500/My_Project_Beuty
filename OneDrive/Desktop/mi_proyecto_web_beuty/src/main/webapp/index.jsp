<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header class="header">
        <div class="menu container">
            <a href="#" class="logo">logo</a>
            <input type="checkbox"id="menu"/>
            <label for="menu">
                <img src="images/menu.png" class="menu-icono" alt="menu">
            </label> 
            <nav class="navbar">
                <ul>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="#">Categorias</a></li>
                    <li><a href="#">Productos</a></li>
                    <li><a href="#">Contacto</a></li>
                    <li><a href="login.jsp">Iniciar Sesión</a></li> <!-- Enlace a la página de inicio de sesión -->
                </ul>
            </nav>
            <div>
                <ul>
                    <li class="submenu">
                        <img src="images/car.svg" id="img-carrito" alt="carrito">
                        <div id="carrito">
                            <table id="lista-carrito">
                                <thead>
                                    <tr>
                                        <th>Imagen</th>
                                        <th>Nombre</th>
                                        <th>Precio</th>
                                        <th></th> 
                                    </tr>
                                </thead>
                            </table>
                            <a href="#" id="Vaciar-carrito" class="btn-2">Vaciar Carrito</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div> 
        <div class="header-content container">
            <div class="header-img">
                <img src="images/right.png" alt="">
            </div>
            <div class="header-txt">
                <h1>Ofertas especiales</h1>
                <p>estrena las mejores prendas</p>
                <a href="#" class="btn-1">informacion</a>
            </div>
        </div> 
    </header>
    
    <section class="ofert container">
        <div class="ofert-1">
            <div class="ofert-2">
                <img src="images/f1.png" alt="">
            </div>
            <div class="ofert-text">
                <h3>Producto 1</h3>
                <a href="#" class="btn-2">Información</a>
            </div>
        </div>

        <div class="ofert-1">
            <div class="ofert-2">
                <img src="images/f2.png" alt="">
            </div>
            <div class="ofert-text">
                <h3>Producto 2</h3>
                <a href="#" class="btn-2">Información</a>
            </div>
        </div>

        <div class="ofert-1">
            <div class="ofert-2">
                <img src="images/f3.png" alt="">
            </div>
            <div class="ofert-text">
                <h3>Producto 3</h3>
                <a href="#" class="btn-2">Información</a>
            </div>
        </div>
    </section>

    <main class="products container" id="lista-1">
        <h2>Productos</h2>
        <div class="product-content">
            <div class="product">
                <img src="images/1.png" alt="">
                <div class="product-txt">
                    <h3>Elis</h3>
                    <p>Calidad Premium</p>
                    <p class="precio">$200</p>
                    <a href="#" class="agregar-carrito btn-2" data-id="1">Agregar al carrito</a>
                </div>
            </div>

            <!-- Aquí irían los demás productos -->

        </div>
    </main>

    <section class="icons container">
        <div class="icon-1">
            <img src="images/i1.svg" alt="">
        </div>
        <div class="icon-text">
            <h3>Descripción</h3>
            <p>
                Información adicional sobre tus servicios o productos.
            </p>
        </div>

        <div class="icon-1">
            <img src="images/i2.svg" alt="">
        </div>
        <div class="icon-text">
            <h3>Descripción</h3>
            <p>
                Información adicional sobre tus servicios o productos.
            </p>
        </div>

        <div class="icon-1">
            <img src="images/i3.svg" alt="">
        </div>
        <div class="icon-text">
            <h3>Descripción</h3>
            <p>
                Información adicional sobre tus servicios o productos.
            </p>
        </div>
    </section>

    <section class="blog container">
        <div class="blog-1">
            <img src="images/b1.jpg" alt="">
            <h3>Blog 1</h3>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pulvinar consequat bibendum. 
                Integer sodales lacus leo, vitae hendrerit magna sollicitudin feugiat. Nulla et libero varius, 
                volutpat purus eu, lobortis mi. Nulla pharetra eleifend massa. Vestibulum ante ipsum primis 
                in faucibus orci luctus et ultrices posuere cubilia curae; Fusce malesuada magna condimentum 
                ante imperdiet, eget bibendum tortor rhoncus. Donec consequat porta massa ac pellentesque. 
            </p>
        </div>

        <div class="blog-1">
            <img src="images/b2.jpg" alt="">
            <h3>Blog 2</h3>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pulvinar consequat bibendum. 
                Integer sodales lacus leo, vitae hendrerit magna sollicitudin feugiat. Nulla et libero varius, 
                volutpat purus eu, lobortis mi. Nulla pharetra eleifend massa. Vestibulum ante ipsum primis 
                in faucibus orci luctus et ultrices posuere cubilia curae; Fusce malesuada magna condimentum 
                ante imperdiet, eget bibendum tortor rhoncus. Donec consequat porta massa ac pellentesque. 
            </p>
        </div>

        <div class="blog-1">
            <img src="images/b3.jpg" alt="">
            <h3>Blog 3</h3>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pulvinar consequat bibendum. 
                Integer sodales lacus leo, vitae hendrerit magna sollicitudin feugiat. Nulla et libero varius, 
                volutpat purus eu, lobortis mi. Nulla pharetra eleifend massa. Vestibulum ante ipsum primis 
                in faucibus orci luctus et ultrices posuere cubilia curae; Fusce malesuada magna condimentum 
                ante imperdiet, eget bibendum tortor rhoncus. Donec consequat porta massa ac pellentesque. 
            </p>
        </div>
    </section>

    <footer class="footer">
        <div class="footer-content container">
            <div class="link">
                <h3>Enlaces</h3>
                <ul>
                    <li><a href="#">Enlace 1</a></li>
                    <li><a href="#">Enlace 2</a></li>
                    <li><a href="#">Enlace 3</a></li>
                    <li><a href="#">Enlace 4</a></li>
                </ul>
            </div>

            <div class="link">
                <h3>Enlaces</h3>
                <ul>
                    <li><a href="#">Enlace 1</a></li>
                    <li><a href="#">Enlace 2</a></li>
                    <li><a href="#">Enlace 3</a></li>
                    <li><a href="#">Enlace 4</a></li>
                </ul>
            </div>

            <div class="link">
                <h3>Enlaces</h3>
                <ul>
                    <li><a href="#">Enlace 1</a></li>
                    <li><a href="#">Enlace 2</a></li>
                    <li><a href="#">Enlace 3</a></li>
                    <li><a href="#">Enlace 4</a></li>
                </ul>
            </div>

            <div class="link">
                <h3>Enlaces</h3>
                <ul>
                    <li><a href="#">Enlace 1</a></li>
                    <li><a href="#">Enlace 2</a></li>
                    <li><a href="#">Enlace 3</a></li>
                    <li><a href="#">Enlace 4</a></li>
                </ul>
            </div>
        </div>
    </footer>

    <script src="main.js"></script>
</body>
</html>
