<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Categorie</title>
</head>
<body>
	<h1 style="background-color: red; color: white; text_align: center">
		<b>${msg1}</b>


	</h1>

	<div style="color: blue; font-style: italic; font-size: 14pt">
		<a href="${pageContext.request.contextPath}/categorie/listeCategorie">Cliquez
			Ici pour voir la liste des categories</a>
	</div>

	<div style="color: blue; font-style: italic; font-size: 14pt">
		<a
			href="${pageContext.request.contextPath}/categorie/afficheCreateCategorieForm">Cliquez
			Ici pour ajouter un catgorie à la liste des categories</a>
	</div>
</body>
</html>