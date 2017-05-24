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

	<h1 style="text-align: center">${msg}</h1>
	<h3 style="text-align: center">Bienvenue : ${nomAdminCatProd}</h3>
	
	<h3 href="categorie.jsp">Gerer les categories</h3>
	<h3 href="produit.jsp">Gerer les produit</h3>
	
	<a href="<c:url value="/j_spring_security_logout"/>">Se deconnecter</a>
</body>
</html>