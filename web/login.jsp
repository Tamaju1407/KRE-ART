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
<div class="login_container">
	<div class="login_top">
		<h2 class="login title">Ingresa a tu cuenta</h2>
	</div>

	<form action="login" class="login_form" method="post">
		<input type="hidden" name="action" value="verify"/>
		<span class="fa fa-user-circle"></span>Usuario<input type="text" name="email" id="email" required autofocus>
		<span class="fa fa-lock"></span>Contraseña<input type="password" name="password" id="password" required>

		<input class="btn" type="submit" value="ENTRAR">
		<br>
		<input class="btn_name" type="name" value="Error">
		<p class="form_recover"><a href="#">¿olvidaste la contraseña?</a></p>
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