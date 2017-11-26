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

<div class="container">
	<div class="form_top">
		<h2>Registro de usuario</h2>
	</div>
	<form class="form_reg" action="">
		<span class="fa fa-user"></span>Nombres<input class="input" name="name" id="name" type="text" placeholder="Ingresa nombre y apellidos completos" required>
		<span class="fa fa-id-card"></span>D.N.I<input class="input" name="dni" id="dni" type="text" placeholder=" Ingresa 8 dígitos" required>
		<span class="fa fa-phone-square"></span>Teléfono<input class="input" name="cellphone" id="cellphone" type="text" placeholder=" Ingresa 9 números" required>
		<span class="fa fa-envelope"></span>Email<input class="input" name="email" id="email" type="email"  placeholder="Ingresa correo electrónico" required>
		<span class="fa fa-home"></span>Dirección<input class="input" name="location" id="location" type="text" placeholder=" Ejm: Av. Perú 3624, San Martín de porres" required>
		<span class="fa fa-lock"></span>Contraseña<input class="input"  name="password" id="password" type="password"  placeholder="crea una contraseña" required>

		<div class="opciones" action="">
			<select name="type" id="type" type="checkbox">
				<option value="1" checked>Nuevo Talento</option>
				<option value="2">Caza Talento</option>
			</select>

			<input class="input"  type="text"  placeholder=" " required>
		</div>




		<div class="btn_form">
			<input class="btn_submit" type="submit" value="REGISTRAR">
			<input class="btn_reset" type="reset" value="LIMPIAR">
		</div>
		<p class="form_link">¿ya tienes una cuenta?<a href="login.jsp">Ingresa aquí</a></p>
	</form>
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