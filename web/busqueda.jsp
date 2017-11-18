<%--
  Created by IntelliJ IDEA.
  User: PC01
  Date: 17/11/2017
  Time: 03:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">

    <title>Kreart</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>

    <header>
        <a href="index.html"><img src="img/logo.png"></a>
    </header>


</head>

<body>
<div class="navegacion">
    <div class="boton-menu">
        <a href="#"><span class="fa fa-bars"></span></a>
    </div>
    <nav>
        <ul class="menu">
            <li><a href="inicio.html">Inicio</a></li>
            <li><a href="perfil.html">Mi perfil</a></li>
            <li><a href="busqueda.html">Búsqueda</a></li>
        </ul>
    </nav>
</div>

<div class="header-top">

    <input type="search"  id="input-search" placeholder="buscar...">

    <div class="conten-search">
        <div class="content-table">
            <table>
                <thead>
                <tr>
                    <td></td>
                </tr>
                <tbody>
                <tr>
                    <td><a href="#">inicio</a></td>
                </tr>
                <tr>
                    <td><a href="#">artista</a></td>
                </tr>
                <tr>
                    <td><a href="#">cazatalento</a></td>
                </tr>
                <tr>
                    <td><a href="#">contacto</a></td>
                </tr>
                <tr>
                    <td><a href="#">destacados</a></td>
                </tr>
                <tr>
                    <td><a href="#">kre-art</a></td>
                </tr>
                <tr>
                    <td><a href="#">ilustrador</a></td>
                </tr>
                <tr>
                    <td><a href="#">pintores</a></td>
                </tr>
                <tr>
                    <td><a href="#">fotografos</a></td>
                </tr>
                <tr>
                    <td><a href="#">escultores</a></td>
                </tr>
                </tbody>
                </thead>
            </table>


        </div>

    </div>
</div>




<div class="info">
    <p>
        CATEGORÍAS:</p>

    <p>Encontrarás la catégorías que más se adecue al</p>

    <nav class="navegadores">
        <a href="#">ILUSTRADORES</a>
        <a href="#">FOTOGRAFOS</a>
        <a href="#">PINTORES</a>
        <a href="#">ESCULTORES</a>
    </nav>






</div>



</body>

<footer>
    <ul>
        <li>
            <a href="#"><img src="img/facebook.png"></a>
            <p>Facebook</p>
        </li>
        <li>
            <a href="#"><img src="img/twitter.png"></a>
            <p>Twitter</p>
        </li>
        <li>
            <a href="#"><img src="img/insta.png"></a>
            <p>Instagram</p>
        </li>
    </ul>
    <p class="derechos">© 2017 Indigo Recycle. All Rights Reserved</p>
</footer>


</html>