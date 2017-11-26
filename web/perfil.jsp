<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC01
  Date: 18/11/2017
  Time: 02:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
            <li><a href="login?action=rate">Inicio</a></li>
            <li><a href="login?action=profile?id=${personall.id}">Mi perfil</a></li>
            <li><a href="login?action=search">Búsqueda</a></li>
        </ul>
    </nav>
</div>

<div class="row">
    <div class="column">
        <h5> Mi Perfil</h5>
        <div class="perfil">
            <img src="${personall.profile}">
            <h3>${personall.name}</h3>
            <h3>${personall.type} - ${personall.category}</h3>
            <div class="clasificacion">
                <input id="radio1" type="radio" name="estrellas" value="5"><!--
    						--><label for="radio1">★</label><!--
   					 --><input id="radio2" type="radio" name="estrellas" value="4"><!--
    						--><label for="radio2">★</label><!--
    				 --><input id="radio3" type="radio" name="estrellas" value="3"><!--
   							 --><label for="radio3">★</label><!--
   					 --><input id="radio4" type="radio" name="estrellas" value="2"><!--
   							 --><label for="radio4">★</label><!--
   					 --><input id="radio5" type="radio" name="estrellas" value="1"><!--
   							 --><label for="radio5">★</label>
            </div>
            <div class="InfoPerfil">
                <p>Dni: ${personall.dni}</p>
                <p>${personall.description}</p>
            </div>
        </div>
    </div>
    <div class="column2">
        <h3> Mi Portafolio</h3>

        <c:forEach var="image" items="${images}">
        <div class="photo">
            <a target="_blank" href="login?action=imgs&id=${image.id}"><img src="${image.url}" alt=""></a>
            <div class="desc"><div>${image.rate}★</div></div>
        </div>
        </c:forEach>

    </div>

    <div class="column3">
        <h3> Contacto</h3>
        <div class="contact">
            <p><span class="fa fa-home"></span> ${personall.location}</p>
            <p><span class="fa fa-phone-square"></span> ${personall.cellphone}</p>
            <p><span class="fa fa-envelope-square"></span> ${personall.email}</p>
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