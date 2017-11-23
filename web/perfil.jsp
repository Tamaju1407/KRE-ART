<%--
  Created by IntelliJ IDEA.
  User: PC01
  Date: 18/11/2017
  Time: 02:56 PM
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

<div class="row">
    <div class="column">
        <h5> Mi Perfil</h5>
        <div class="perfil">
            <img src="img/profile1.jpg">
            <h3>Arturo Chavez García</h3>
            <div class="InfoPerfil">
                <p>Estudiante de la Carrera de Diseño Gráfico, realiza todo tipo de trabajos de ilustración</p>
                <p>Dni: 72925417</p>
            </div>
        </div>
    </div>
    <div class="column2">
        <h3> Mi Portafolio</h3>

        <div class="photo">
            <a target="_blank" href="img/porta1.jpg"><img src="img/porta1.jpg" alt=""></a>
            <div class="desc">Escudo Nacional Peruano</div>
        </div>
        <div class="photo">
            <a target="_blank" href="img/porta2.jpg"><img src="img/porta2.jpg" alt=""></a>
            <div class="desc">Perú Futbolista</div>
        </div>
        <div class="photo">
            <a target="_blank" href="img/porta3.jpg"><img src="img/porta3.jpg" alt=""></a>
            <div class="desc"> Torito Pukará</div>
        </div>
        <div class="photo">
            <a target="_blank" href="img/porta4.jpg"><img src="img/porta4.jpg" alt=""></a>
            <div class="desc">Perú Futbolista</div>
        </div>
        <div class="photo">
            <a target="_blank" href="img/porta5.jpg"><img src="img/porta5.jpg" alt=""></a>
            <div class="desc"> Torito Pukará</div>
        </div>
        <div class="photo">
            <a target="_blank" href="img/porta6.jpg"><img src="img/porta6.jpg" alt="">
            </a>
            <div class="desc">Perú Futbolista</div>
        </div>
    </div>

    <div class="column3">
        <h3> Contacto</h3>
        <div class="contact">
            <h3><i class="fa fa-envelope"></i> E-mail</h3>
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