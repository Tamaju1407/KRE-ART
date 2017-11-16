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

<div class="container">
	<div class="form_top">
		<h2>Formulario de Registro</h2>
	</div>
	<form class="form_reg" action="">
		<span class="fa fa-user"></span>Nombres Completos<input class="input" type="text" nombre" required autofocus>
		<span class="fa fa-id-card"></span>D.N.I<input class="input" type="text" dni" required>
		<span class="fa fa-phone-square"></span>Teléfono<input class="input" type="text" celular" required>
		<span class="fa fa-envelope"></span>Email<input class="input"  type="email" correo" required>
		<span class="fa fa-user-circle"></span>Usuario<input class="input" type="text" usuario" required>
		<span class="fa fa-home"></span>Dirección<input class="input" type="text" direccion" required>
		<span class="fa fa-lock"></span>Contraseña<input class="input"  type="password"  clave" required>

		<div class="opciones" action="">
			<input type="radio" name="gender" value="nuevo talento" checked> Nuevo talento<br>
			<input type="radio" name="gender" value="busca talento">Busca talento<br>
		</div>




		<div class="btn_form">
			<input class="btn_submit" type="submit" value="REGISTRAR">
			<input class="btn_reset" type="reset" value="LIMPIAR">
		</div>
		<p class="form_link">¿ya tienes una cuenta?<a href="#">Ingresa aquí</a></p>
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