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
	<div class="navbar-fixed-bottom"
		style="background-color: #662200; box-shadow: 10px 10px 5px #888888; color: white; font-weight: bold;">
		<div class="text-center center-block">
			<br />
			<p class="txt-railway" style="font-weight: bold">Contact us</p>
			<a href="https://www.facebook.com/manulltt"><i id="social-fb"
				class="fa fa-facebook-square fa-3x social"></i></a> <a
				href="https://twitter.com/bootsnipp"><i id="social-tw"
				class="fa fa-twitter-square fa-3x social"></i></a> <a
				href="https://plus.google.com/+Bootsnipp-page"><i id="social-gp"
				class="fa fa-google-plus-square fa-3x social"></i></a> <a
				href="mailto:emmanuel.lilettep@gmail.com"><i id="social-em"
				class="fa fa-envelope-square fa-3x social"></i></a> <br /> <br />
		</div>
	</div>
	<!-- jQuery -->
	<script src='<c:url value="/resources/vendor/jquery/jquery.min.js" />'></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />'></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script
		src='<c:url value="/resources/vendor/scrollreveal/scrollreveal.min.js" />'></script>
	<script
		src='<c:url value="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js" />'></script>

	<!-- Theme JavaScript -->
	<script src='<c:url value="/resources/js/creative.min.js" />'></script>
</body>
</html>