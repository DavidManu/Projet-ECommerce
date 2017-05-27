<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/creative.css" />'
	rel="stylesheet">
<link
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />'
	rel="stylesheet">
<link
	href='<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />'
	rel="stylesheet" type="text/css">
<link
	href='<c:url value="/resources/vendor/magnific-popup/magnific-popup.css" />'
	rel="stylesheet">

<link href='<c:url value="/resources/css/table.css" />' rel="stylesheet">
</head>
<body>

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="#page-top">Start
					Bootstrap</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="page-scroll"
						href="${pageContext.request.contextPath}/authentication">Welcome</a>
					</li>
					<li><a class="page-scroll"
						href="${pageContext.request.contextPath}/authentication/adminCatProd/adminCatProdPage">AdminCatProd</a>
					</li>
					<li><a class="page-scroll"
						href="${pageContext.request.contextPath}/authentication/adminProd/adminProdPage">AdminProd</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<br />
	<br />
	<br />
	<br />
	<br />
	<br />


	<h1
		style="background-color: Lightgreen; color: darkgreen; text-align: center">Liste
		des Produits</h1>
	<div align="center">
		<table class="responstable">
			<tr>
				<th>Selection</th>
				<th>ID</th>
				<th>Categorie</th>
				<th>Designation</th>
				<th>Prix</th>
				<th>Description</th>
				<th>Photo</th>
			</tr>
			<c:forEach var="produit" items="${pListe}">
				<tr>
					<td>${produit.selectionne}</td>
					<td>${produit.idProduit}</td>
					<td>${produit.categorie.idCategorie}</td>
					<td>${produit.designation}</td>
					<td>${produit.prix}</td>
					<td>${produit.description}</td>
					<td>${produit.photo}</td>

					<td><a
						href="${pageContext.request.contextPath}/produit/addToBasket/${personne.id}">Ajouter
							au pannier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />

</body>
</html>