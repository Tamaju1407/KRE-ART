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
            <h3>Nuevo talento - Ilustrador</h3>
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
                <p>Dni: 72925417</p>
                <p>Estudiante de la Carrera de Diseño Gráfico, desarrollo proyectos gráficos en diferentes estilos y creo que mientras más complejo es el reto, es mayor la satisfacción.</p>
            </div>
        </div>
    </div>
    <div class="column2">
        <h3> Mi Portafolio</h3>

        <div class="photo">
            <a target="_blank" href="img.jsp"><img src="img/porta1.jpg" alt=""></a>
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
        <div class="photo">
            <a target="_blank" href="img/porta7.jpg"><img src="img/porta7.jpg" alt=""></a>
            <div class="desc">Perú Futbolista</div>
        </div>
        <div class="photo">
            <a target="_blank" href="img/porta8.jpg"><img src="img/porta8.jpg" alt=""></a>
            <div class="desc"> Torito Pukará</div>
        </div>
        <div class="photo">
            <a target="_blank" href="img/porta9.jpg"><img src="img/porta9.jpg" alt="">
            </a>
            <div class="desc">Perú Futbolista</div>
        </div>
    </div>

    <div class="column3">
        <h3> Contacto</h3>
        <div class="contact">
            <p><span class="fa fa-home"></span> Av. Perú 452, San martín de Porres</p>
            <p><span class="fa fa-phone-square"></span> 936 138 926</p>
            <p><span class="fa fa-envelope-square"></span> harturochg@outlook.com</p>
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