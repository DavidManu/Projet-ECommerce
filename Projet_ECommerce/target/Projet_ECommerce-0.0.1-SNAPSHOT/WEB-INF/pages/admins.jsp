<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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

<body style="background-image: url('./resources/image/whitebrick.jpg');">
	<div style="background-image: url('./resources/image/whitebrick.jpg');">
		<nav id="mainNav" class="navbar navbar-default navbar-fixed-top"
			style="background-color: #662200; box-shadow: 10px 10px 5px #888888;">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<!-- 				<button type="button" class="navbar-toggle collapsed" -->
					<!-- 					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> -->
					<!-- 					<span class="sr-only">Toggle navigation</span> Menu <i -->
					<!-- 						class="fa fa-bars"></i> -->
					<!-- 				</button> -->
					<a class="navbar-brand page-scroll"
						href="${pageContext.request.contextPath}/authentication"
						style="color: white; font-weight: bold;"> Shop </a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li><a class="page-scroll" href="#about"
							style="color: white; font-weight: bold;">About</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
							style="color: white; font-weight: bold;"> Login </a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">

								<form action="j_spring_security_check" method="post">

									Login: <input type="text" name="j_username" /> <br /> Mot de
									passe: <input type="text" name="j_password" /> <br /> <input
										type="submit" value="se connecter">

								</form>
								<c:if test="${not empty erreur}">
									<h1 style="color: red">Tu t'es trompé sur le Login ou Mdp
										tu n'as pas plus qu'a trouvé lequel</h1>
								</c:if>

								<a class="dropdown-item"
									href="${pageContext.request.contextPath}/authentication/adminCatProd/adminCatProdPage"
									style="background-color: #662200; color: white; font-weight: bold;">As
									general admin</a> <br /> <a class="dropdown-item"
									href="${pageContext.request.contextPath}/authentication/adminProd/adminProdPage"
									style="background-color: #662200; color: white; font-weight: bold;">As
									product admin</a>

							</div></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<br /> <br /> <br />

		<div style="text-align: center">
			<header>
				<div class="header-content">
					<div class="header-content-inner">
						<h2 id="homeHeading" style="text-align: center">Bienvenue
							dans votre espace de gestion des administrateurs!</h2>
						<hr>
					</div>
				</div>
			</header>


			<br /> <br />

			<div style="color: blue; font-style: italic; font-size: 14pt">
				<a
					href="${pageContext.request.contextPath}/categorie/afficheCreateCategorieForm">Cliquez
					Ici pour ajouter un administrateur</a>
			</div>

			<h4>Voici les administrateurs existants:</h4>

			<div style="text-align: center">

				<TABLE width=100% border=10 CELLPADDING=CELLSPACING=10>
					<CAPTION ALIGN=bottom color="blue">Table récapitulative
						des catégories existantes</CAPTION>
					<tr
						style="background-color: blue; color: white; text-align: center">
						<th style="text-align: center">ID</th>
						<th style="text-align: center">Statut</th>
						<th style="text-align: center">Nom d'utilisateur</th>
						<th style="text-align: center">Mot de Passe</th>
						<th style="text-align: center">Role Assigné</th>

					</tr>
					<c:forEach var="admin" items="${aListe}">
						<tr>
							<td>${admin.id}</td>
							<td>${admin.userName}</td>
							<td>${admin.password}</td>
							<td>${admin.actived}</td>

							<td class="text-right" style="text-align: center">
								<button type="button" title="Edit"
									class="btn btn-success btn-simple btn-xs"
									onclick="location.href='${pageContext.request.contextPath}/categorie/edit?idCategorie=${categorie.idCategorie}'">
									<i class="material-icons">Editer</i>
								</button>
								<button type="button" title="Remove"
									class="btn btn-danger btn-simple btn-xs"
									onclick="location.href='${pageContext.request.contextPath}/categorie/delete/${categorie.idCategorie}'">
									<i class="material-icons">Supprimer</i>
								</button>
							</td>

						</tr>
					</c:forEach>
				</TABLE>
			</div>
		</div>

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
	</div>
</body>
</html>