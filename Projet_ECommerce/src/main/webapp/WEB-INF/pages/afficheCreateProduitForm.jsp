<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="background-color: red; color: white; text_align: center">
		<b>L'ajout a bein été pris en compte</b>
	</h1>

	<form:form action="insererProduit" method="POST"
		modelAttribute="mProduit">

		<!-- 		<table width="100%"> -->
		
		Description:<form:input path="description" />
		<form:errors path="description" cssStyle="color:red"></form:errors>
		<br />
		
			Designation:<form:input path="designation" />
		<form:errors path="designation" cssStyle="color:red"></form:errors>
		<br />
<%-- 					Photo : <form:input path="photo" /> --%>
<%-- 		<form:errors path="photo" cssStyle="color:red"></form:errors> --%>
<!-- 		<br /> -->
			
			Prix :<form:input path="prix" />
		<form:errors path="prix" cssStyle="color:red"></form:errors>
		
		Quantite :<form:input path="quantite" />
		<form:errors path="quantite" cssStyle="color:red"></form:errors>

				Selectionne :<form:input path="selectionne" />
		<form:errors path="selectionne" cssStyle="color:red"></form:errors>

<%-- 				Categorie :<form:input path="categorie" /> --%>
<%-- 		<form:errors path="categorie" cssStyle="color:red"></form:errors> --%>
		<br />
		<br />
		<input type="submit" value="Ajouter un Produit" />
	</form:form>

	<a href="${pageContext.request.contextPath}/produit/listeProduit">Page
		d'acceuil</a>
</body>
</html>