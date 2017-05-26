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

				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Photo</th>


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
</body>
</html>