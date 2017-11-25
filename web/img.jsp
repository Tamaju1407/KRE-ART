<%--
  Created by IntelliJ IDEA.
  User: PC01
  Date: 24/11/2017
  Time: 04:40 PM
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

<div class="zoom">
    <img src="img/porta1.jpg" alt="">
    <div class="desc">Escudo Nacional Peruano</div>
</div>

<div class="comments-container">
    <ul id="comments-list" class="comments-list">
        <li>
            <div class="comment-main-level">
                <!-- Avatar -->
                <div class="comment-avatar"><img src="img/avatar_1.jpg" alt=""></div>
                <!-- Contenedor del Comentario -->
                <div class="comment-box">
                    <div class="comment-head">
                        <h6 class="comment-name by-author"><a href="">Arturo Chavez García</a></h6>
                        <span>hace 20 minutos</span>
                        <i class="fa fa-reply"></i>
                        <i class="fa fa-heart"></i>
                    </div>
                    <div class="comment-content">
                        Les presento al ESCUDO FANÁTICO...
                        #ArribaElPerú #Escudo #Perú #Ilustración
                    </div>
                </div>
            </div>

            <!-- Respuestas de los comentarios -->
            <ul class="comments-list reply-list">
                <li>
                    <!-- Avatar -->
                    <div class="comment-avatar"><img src="img/avatar_2.jpg" alt=""></div>
                    <!-- Contenedor del Comentario -->
                    <div class="comment-box">
                        <div class="comment-head">
                            <h6 class="comment-name"><a href="">Juan Durand</a></h6>
                            <span>hace 10 minutos</span>
                            <i class="fa fa-reply"></i>
                            <i class="fa fa-heart"></i>
                        </div>
                        <div class="comment-content">
                            Increíble el trabajo de bro, sigue deleitandonos con tu arte 👏👏👏
                        </div>
                    </div>
                </li>
            </ul>
        </li>
    </ul>
    <div id="comment_form">
        <div>
            <textarea rows="10" name="comment" id="comment" placeholder="Comment"></textarea>
        </div>
        <div>
            <input type="submit" name="submit" value="Add Comment">
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