<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Produit</title>
</head>
<body>
	<h1 style="background-color: red; color: white; text_align: center">
		<b>${msg1}</b>


	</h1>

	<div style="color: blue; font-style: italic; font-size: 14pt">
		<a href="${pageContext.request.contextPath}/produit/listeProduit">Cliquez
			Ici pour voir la liste des produits</a>
	</div>
	
	<div style="color: blue; font-style: italic; font-size: 14pt">
		<a href="${pageContext.request.contextPath}/produit/afficheCreateProduitForm">Cliquez
			Ici pour ajouter un porduit à  la liste des produits</a>
	</div>
</body>
</html>