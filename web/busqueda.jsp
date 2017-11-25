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

    <header>
        <a href="index.jsp"><img src="img/logo.png"></a>
    </header>


</head>

<body>
<div class="navegacion">
    <div class="boton-menu">
        <a href="#"><span class="fa fa-bars"></span></a>
    </div>
    <nav>
        <ul class="menu">
            <li><a href="inicio.jsp">Inicio</a></li>
            <li><a href="perfil.jsp">Mi perfil</a></li>
            <li><a href="busqueda.jsp">Búsqueda</a></li>
        </ul>
    </nav>
</div>

<div class="header-top">
    <input type="search"  id="input-search" placeholder="buscar...">
</div>

<div class="row">
    <div class="columna">
        <div class="card">
            <img src="img/perfil1.jpg" style="width:100%">
            <div class="contenedor">
                <h2>Arturo Chavez García</h2>
                <p>Diseñador & Ilustrador</p>
                <a class="button" href="perfil.jsp">Ver Perfil</a>
            </div>
        </div>
    </div>
    <div class="columna">
        <div class="card">
            <img src="img/perfil2.jpg" style="width:100%">
            <div class="contenedor">
                <h2>Manuel Mescco cano</h2>
                <p>Fotógrafo</p>
                <a class="button" href="perfil.jsp">Ver Perfil</a>
            </div>
        </div>
    </div>
    <div class="columna">
        <div class="card">
            <img src="img/perfil3.jpg" style="width:100%">
            <div class="contenedor">
                <h2>Victoria Fuentes Solis</h2>
                <p>Fotógrafa</p>
                <a class="button" href="perfil.jsp">Ver Perfil</a>
            </div>
        </div>
    </div>
    <div class="columna">
        <div class="card">
            <img src="img/perfil4.jpg" style="width:100%">
            <div class="contenedor">
                <h2>Joel Ramos Carbajal</h2>
                <p>Ilustrador</p>
                <a class="button" href="perfil.jsp">Ver Perfil</a>
            </div>
        </div>
    </div>
    <div class="columna">
        <div class="card">
            <img src="img/perfil5.jpg" style="width:100%">
            <div class="contenedor">
                <h2>Omar campos campos</h2>
                <p>Diseñador Gráfico</p>
                <a class="button" href="perfil.jsp">Ver Perfil</a>
            </div>
        </div>
    </div>
    <div class="columna">
        <div class="card">
            <img src="img/perfil6.jpg" style="width:100%">
            <div class="contenedor">
                <h2>Ayrton cardenas Lavado</h2>
                <p>Pintor</p>
                <a class="button" href="perfil.jsp">Ver Perfil</a>
            </div>
        </div>
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