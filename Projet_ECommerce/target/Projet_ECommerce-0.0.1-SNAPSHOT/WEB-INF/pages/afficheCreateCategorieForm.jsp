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

	<a href="${pageContext.request.contextPath}/categorie/listeCategorie">Page
		d'acceuil</a>
</body>
</html>