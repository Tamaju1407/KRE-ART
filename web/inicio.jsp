<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC01
  Date: 10/11/2017
  Time: 01:39 PM
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
<h3>DESTACADOS</h3>
<c:forEach var="image" items="${images}">
<div class="gallery">
    <img src="${image.url}" alt="">
    <div class="desc">${image.person.name}</div>
</div>
</c:forEach>
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