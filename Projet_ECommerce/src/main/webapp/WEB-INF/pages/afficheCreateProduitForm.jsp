<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html >
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
<body>
		<table width="100%" cellpadding="6" style="text_align: center">
		<tr style="text-align: center; background-color:grey; color: white">
			<form:form action="insererProduit" method="POST"
				modelAttribute="mProduit">

				<!-- 		<table width="100%"> -->
				<td>Description:<form:input path="description" /> <form:errors
						path="description" cssStyle="color:red"></form:errors> <br />
				</td>
				<td>Designation:<form:input path="designation" /> <form:errors
						path="designation" cssStyle="color:red"></form:errors> <br />
				</td>
				<%-- 					Photo : <form:input path="photo" /> --%>
				<%-- 		<form:errors path="photo" cssStyle="color:red"></form:errors> --%>
				<!-- 		<br /> -->
				<td>Prix :<form:input path="prix" /> <form:errors path="prix"
						cssStyle="color:red"></form:errors>
				</td>
				<td>Quantite :<form:input path="quantite" /> <form:errors
						path="quantite" cssStyle="color:red"></form:errors>
				</td>
				<td>Selectionne :<form:input path="selectionne" /> <form:errors
						path="selectionne" cssStyle="color:red"></form:errors>
				</td>
				<%-- 				Categorie :<form:input path="categorie" /> --%>
				<%-- 		<form:errors path="categorie" cssStyle="color:red"></form:errors> --%>
				<br />
				<br />
				<input type="submit" value="Ajouter un Produit" />
	
			</form:form>
		</tr>
	</table>
</body>
</html>