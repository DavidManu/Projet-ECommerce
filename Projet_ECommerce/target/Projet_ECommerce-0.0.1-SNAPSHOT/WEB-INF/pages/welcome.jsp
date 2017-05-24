<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Pages concernant Admin categorie et produit: <a
			href="${pageContext.request.contextPath}/authentication/adminCatProd/adminCatProdPage">Cliquer
			ici</a>
	</h1>
	<h1>
		Pages concernant Admin produit: <a
			href="${pageContext.request.contextPath}/authentication/adminProd/adminProdPage">Cliquer
			ici</a>
	</h1>

	<h1
		style="background-color: Lightgreen; color: darkgreen; text-align: center">Liste
		des Produits</h1>
	<div align="center">
		<table width="100%" cellpadding="6">
			<tr style="background-color: grey; color: white; text-align: center">
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

					<%-- <td><a href="${pageContext.request.contextPath}/personne/delete/${personne.id}">Ajouter au pannier</a></td> --%>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />

</body>
</html>