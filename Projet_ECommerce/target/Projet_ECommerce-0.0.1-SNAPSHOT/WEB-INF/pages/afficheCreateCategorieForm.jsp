<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Commit -->
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

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top"
		style="background-color: #662200; box-shadow: 10px 10px 5px #888888;">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

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
							aria-labelledby="navbarDropdownMenuLink"></div></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div style="text-align: center">
		<header>
			<div class="header-content">
				<div class="header-content-inner">
					<h2 id="homeHeading" style="text-align: center">Bienvenue dans
						votre espace de gestion des categories musicales!</h2>
					<h2 id="homeHeading" style="text-align: center">Ajouter votre
						categorie et faites partager vos envies</h2>
					<hr>
				</div>
			</div>
		</header>

		<br /> <br />
	</div>

	<form:form enctype="multipart/form-data">
		<table width="100%" cellpadding="6" style="text_align: center">
			<tr style="text-align: center; background-color: grey; color: white">
				<form:form action="insererCategorie" method="POST"
					modelAttribute="mCategorie" style="text_align: center">


					<td>Nom de la Categorie:<form:input path="nomCategorie" /> <form:errors
							path="nomCategorie" cssStyle="color:red"></form:errors> <br />
					</td>
					<td>Description:<form:input path="description" /> <form:errors
							path="description" cssStyle="color:red"></form:errors> <br />
					</td>
					<td>
						<div class="input-group">
							<span class="input-group-addon"> <i class="material-icons">Inserer
									une photo</i>
							</span>
							<div class="form-group">
								<a class="btn btn-default btn-xs col-sm-8"><input
									type="file" name="file"></a>
							</div>
						</div>
					</td>
					<td><input type="submit" value="Ajouter une Categorie" /></td>
					<br />
					<br />

				</form:form>
			</tr>
		</table>

	</form:form>

	<div class="navbar-fixed-bottom"
		style="background-color: #662200; box-shadow: 10px 10px 5px #888888; color: white; font-weight: bold;">
		<div class="text-center center-block">

			<br />
			<p class="txt-railway" style="font-weight: bold">Contact us</p>
			<a href="https://www.facebook.com/manulltt"><i id="social-fb"
				class="fa fa-facebook-square fa-3x social"></i></a> <a
				href="https://twitter.com/bootsnipp"><i id="social-tw"
				class="fa fa-twitter-square fa-3x social"></i></a> <a
				href="https://plus.google.com/+Bootsnipp-page"><i id="social-gp"
				class="fa fa-google-plus-square fa-3x social"></i></a> <a
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