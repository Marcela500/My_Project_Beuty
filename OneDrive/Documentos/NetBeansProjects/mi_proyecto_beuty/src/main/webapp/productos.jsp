<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos - Beautè boutique</title>
    <link rel="stylesheet" href="styles.css"> <!-- Enlazar tu archivo de estilos CSS -->
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

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
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

        .navbar {
            display: flex;
        }

        .navbar a {
            font-size: 18px;
            padding: 10px 20px;
            color: #111111;
            display: block;
        }

        .search-bar {
            margin: 20px 0;
            text-align: center;
        }

        .search-bar input[type="text"] {
            width: 60%;
            padding: 10px;
            font-size: 1em;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .products {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 20px;
            padding: 20px;
            margin: auto;
            max-width: 1200px; /* Ancho máximo para centrar los productos */
        }

        .product {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
            padding: 20px;
        }

        .product img {
            width: 100%;
            border-bottom: 1px solid #ddd;
            border-radius: 5px 5px 0 0;
        }

        .product h3 {
            margin: 10px 0;
            font-size: 1.2em;
        }

        .product .stars {
            color: gold;
            margin-bottom: 10px;
        }

        .product p {
            margin: 10px 0;
            font-size: 1.1em;
        }
    </style>
    
    <script>
        function filterProducts() {
            var input, filter, products, product, title, i, txtValue;
            input = document.getElementById("searchInput");
            filter = input.value.toUpperCase();
            products = document.getElementsByClassName("product");

            for (i = 0; i < products.length; i++) {
                product = products[i];
                title = product.getElementsByTagName("h3")[0];
                txtValue = title.textContent || title.innerText;

                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    product.style.display = "";
                } else {
                    product.style.display = "none";
                }
            }
        }
    </script>
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

    <section class="search-bar">
        <input type="text" id="searchInput" onkeyup="filterProducts()" placeholder="Buscar productos...">
    </section>

    <section class="products">
        <div class="product">
            <img src="img/product1.jpg" alt="Producto 1">
            <h3>Producto 1</h3>
            <div class="stars">★★★★☆</div>
            <p>$29.99</p>
        </div>
        <div class="product">
            <img src="img/product2.jpg" alt="Producto 2">
            <h3>Producto 2</h3>
            <div class="stars">★★★★★</div>
            <p>$39.99</p>
        </div>
        <div class="product">
            <img src="img/product3.jpg" alt="Producto 3">
            <h3>Producto 3</h3>
            <div class="stars">★★★☆☆</div>
            <p>$19.99</p>
        </div>
        <div class="product">
            <img src="img/product4.jpg" alt="Producto 4">
            <h3>Producto 4</h3>
            <div class="stars">★★★★☆</div>
            <p>$49.99</p>
        </div>
        <div class="product">
            <img src="img/product5.jpg" alt="Producto 5">
            <h3>Producto 5</h3>
            <div class="stars">★★★☆☆</div>
            <p>$24.99</p>
        </div>
        <div class="product">
            <img src="img/product6.jpg" alt="Producto 6">
            <h3>Producto 6</h3>
            <div class="stars">★★★★☆</div>
            <p>$34.99</p>
        </div>
        <div class="product">
            <img src="img/product7.jpg" alt="Producto 7">
            <h3>Producto 7</h3>
            <div class="stars">★★★☆☆</div>
            <p>$14.99</p>
        </div>
        <div class="product">
            <img src="img/product8.jpg" alt="Producto 8">
            <h3>Producto 8</h3>
            <div class="stars">★★★★★</div>
            <p>$54.99</p>
        </div>
        <div class="product">
            <img src="img/product9.jpg" alt="Producto 9">
            <h3>Producto 9</h3>
            <div class="stars">★★★★☆</div>
            <p>$44.99</p>
        </div>
        <div class="product">
            <img src="img/product10.jpg" alt="Producto 10">
            <h3>Producto 10</h3>
            <div class="stars">★★★☆☆</div>
            <p>$9.99</p>
        </div>
        <div class="product">
            <img src="img/product11.jpg" alt="Producto 11">
            <h3>Producto 11</h3>
            <div class="stars">★★★☆☆</div>
            <p>$39.99</p>
        </div>
        <div class="product">
            <img src="img/product12.jpg" alt="Producto 12">
            <h3>Producto 12</h3>
            <div class="stars">★★★★☆</div>
            <p>$49.99</p>
        </div>
        <div class="product">
            <img src="img/product13.jpg" alt="Producto 13">
            <h3>Producto 13</h3>
            <div class="stars">★★★★★</div>
            <p>$29.99</p>
        </div>
        <div class="product">
            <img src="img/product14.jpg" alt="Producto 14">
            <h3>Producto 14</h3>
            <div class="stars">★★★★☆</div>
            <p>$19.99</p>
        </div>
        <div class="product">
            <img src="img/product15.jpg" alt="Producto 15">
            <h3>Producto 15</h3>
            <div class="stars">★★★☆☆</div>
            <p>$14.99</p>
        </div>
        <div class="product">
            <img src="img/product16.jpg" alt="Producto 16">
            <h3>Producto 16</h3>
            <div class="stars">★★★★☆</div>
            <p>$34.99</p>
        </div>
    </section>
</body>
</html>
