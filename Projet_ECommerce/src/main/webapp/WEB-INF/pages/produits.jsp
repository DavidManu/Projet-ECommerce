<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">


		<table width="100%" cellpadding="6">
			<tr style="background-color: grey; color: white; text-align: center">
				<th>Selection</th>
				<th>ID</th>
				<th>Categorie</th>
				<th>Designation</th>
				<th>Prix</th>
				<th>Quantite</th>
				<th>Description</th>
				<th>Photo</th>
				<th>Commande</th>
				
			</tr>
			<c:forEach var="produit" items="${pListe}">
				<tr>
					<td>${produit.selectionne}</td>
					<td>${produit.idProduit}</td>
					<td>${produit.categorie.idCategorie}</td>
					<td>${produit.designation}</td>
					<td>${produit.prix}</td>
					<td>${produit.quantite}</td>
					<td>${produit.description}</td>
					<td>${produit.photo}</td>
<%-- 					<td>${}</td> --%>

					<%-- <td><a href="${pageContext.request.contextPath}/personne/delete/${personne.id}">Ajouter au pannier</a></td> --%>
				</tr>
			</c:forEach>
		</table>


	</div>
</body>
</html>