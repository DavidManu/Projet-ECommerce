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
						<h2 id="homeHeading" style="text-align: center">Bienvenue
							dans votre Online shop!</h2>
						<hr>
					</div>
				</div>
			</header>


			<br /> <br />


		

			<h4>Voici les categories disponibles:</h4>

			<div style="text-align: center">


				<table width="100%" cellpadding="6">
					<tr
						style="background-color: grey; color: white; text-align: center">

						<th>ID</th>
						<th>Nom</th>
						<th>Description</th>
						<th>Photo</th>
						<th>Commande</th>


					</tr>
					<c:forEach var="categorie" items="${cListe}">
						<tr>

							<td>${categorie.idCategorie}</td>
							<td>${categorie.nomCategorie}</td>
							<td>${categorie.description}</td>
							<td>${categorie.photo}</td>
							<td><a
								href="${pageContext.request.contextPath}/categorie/delete/${categorie.idCategorie}">Supprimer</a>
								| <a
								href="${pageContext.request.contextPath}/categorie/edit?idCategorie=${categorie.idCategorie}">Editer</a></td>
							<%-- 					<td>${}</td> --%>

							<%-- <td><a href="${pageContext.request.contextPath}/personne/delete/${personne.id}">Ajouter au pannier</a></td> --%>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>


	
	<h1 style="background-color: grey; color: white; text_align: center">
		<b>L'ajout a bien été pris en compte</b>
	</h1>

	<form:form action="insererCategorie" method="POST"
		modelAttribute="mCategorie">

		<!-- 		<table width="100%"> -->
		
		Nom de la Categorie:<form:input path="nomCategorie" />
		<form:errors path="nomCategorie" cssStyle="color:red"></form:errors>
		<br />
		
			Description:<form:input path="description" />
		<form:errors path="description" cssStyle="color:red"></form:errors>
		<br />
		<%-- 					Photo : <form:input path="photo" /> --%>
		<%-- 		<form:errors path="photo" cssStyle="color:red"></form:errors> --%>
		<!-- 		<br /> -->

		<br />
		<br />
		<input type="submit" value="Ajouter une Categorie" />
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