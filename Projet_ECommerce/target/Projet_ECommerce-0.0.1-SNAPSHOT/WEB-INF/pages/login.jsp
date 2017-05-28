<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
<body style="background-image: url('./resources/image/whitebrick.jpg');">
	<form action="j_spring_security_check" method="post">

		Login: <input type="text" name="j_username" /> <br /> Mot de passe:
		<input type="text" name="j_password" /> <br /> <input type="submit"
			value="se connecter">

	</form>

	<c:if test="${not empty erreur}">
		<h1 style="color: red">Tu t'es trompé sur le Login ou Mdp tu n'as
			pas plus qu'a trouvé lequel</h1>
	</c:if>
	
</body>
</html>