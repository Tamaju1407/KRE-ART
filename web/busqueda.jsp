<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC01
  Date: 17/11/2017
  Time: 03:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1" language="java"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
    <c:forEach var="personall" items="${personalls}">
    <div class="columna">
        <div class="card">
            <img src="${personall.profile}" style="width:100%">
            <div class="contenedor">
                <h2>${personall.name}</h2>
                <p>${personall.type} - ${personall.category}</p>
                <a class="button" href="perfil.jsp">Ver Perfil</a>
            </div>
        </div>
    </div>
    </c:forEach>
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