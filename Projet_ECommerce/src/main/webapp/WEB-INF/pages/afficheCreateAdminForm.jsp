<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<!-- Bootstrap Core CSS -->
<link
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.css" />'
	rel="stylesheet" />

<!-- Theme CSS -->
<link href='<c:url value="/resources/css/creative.css" />'
	rel="stylesheet" />

<link
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />'
	rel="stylesheet" />
<link
	href='<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />'
	rel="stylesheet" type="text/css" />
<link
	href='<c:url value="/resources/vendor/magnific-popup/magnific-popup.css" />'
	rel="stylesheet" />

</head>
<body>
	<div style="text-align: center">
		<header>
			<div class="header-content">
				<div class="header-content-inner">
					<h2 id="homeHeading" style="text-align: center">Bienvenue dans
						votre espace de gestion des administrateurs!</h2>
					<h2 id="homeHeading" style="text-align: center">Ajouter un
						administrateur et donnez lui droits correspondants</h2>
					<hr>
				</div>
			</div>
		</header>


		<br /> <br />


		<table width="100%" cellpadding="6" style="text_align: center">
			<CAPTION ALIGN=bottom color="blue">LEGENDE : Actived :
				Faire votre choix entre 1: actived et 0: passif</CAPTION>
			<CAPTION ALIGN=bottom color="blue">LEGENDE : Role assigné :
				Faire votre choix entre 1: ROLE Administrateur général et 2: ROLE
				Gestionnaire de produit</CAPTION>
			<tr style="text-align: center; background-color: grey; color: white">
				<form:form action="insererCategorie" method="POST"
					modelAttribute="mCategorie" style="text_align: center">


					<td>Statut de l'administrateur<form:input path="actived" /> <form:errors
							path="actived" cssStyle="color:red"></form:errors> <br />
					</td>
					<td>Nom d'utilisation:<form:input path="userName" /> <form:errors
							path="userName" cssStyle="color:red"></form:errors> <br />
					</td>
					<td>Mot de Passe:<form:input path="password" /> <form:errors
							path="password" cssStyle="color:red"></form:errors> <br />
					</td>
					<td>Role assigné:<form:input path="role_id" /> <form:errors
							path="role_id" cssStyle="color:red"></form:errors> <br />
					</td>
					<td><input type="submit" value="Ajouter un administrateur" /></td>
					<br />
					<br />
				</form:form>
			</tr>
		</table>
		
	
		
		<div class="navbar-fixed-bottom"
			style="background-color: #662200; box-shadow: 10px 10px 5px #888888; color: white; font-weight: bold;">
			<div class="text-center center-block">
				<br />
				<p class="txt-railway" style="font-weight: bold">Contact us</p>
				<a href="https://www.facebook.com/manulltt"><i id="social-fb"
					class="fa fa-facebook-square fa-3x social"></i></a> <a
					href="https://twitter.com/bootsnipp"><i id="social-tw"
					class="fa fa-twitter-square fa-3x social"></i></a> <a
					href="https://plus.google.com/+Bootsnipp-page"><i
					id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a> <a
					href="mailto:emmanuel.lilettep@gmail.com"><i id="social-em"
					class="fa fa-envelope-square fa-3x social"></i></a> <br /> <br />
			</div>
		</div>

		<!-- jQuery -->
		<script src='<c:url value="/resources/vendor/jquery/jquery.min.js" />'></script>

		<!-- Bootstrap Core JavaScript -->
		<script
			src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />'></script>

		<!-- Plugin JavaScript -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
		<script
			src='<c:url value="/resources/vendor/scrollreveal/scrollreveal.min.js" />'></script>
		<script
			src='<c:url value="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js" />'></script>

		<!-- Theme JavaScript -->
		<script src='<c:url value="/resources/js/creative.min.js" />'></script>
</body>
</html>