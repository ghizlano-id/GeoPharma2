<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/CSS/commande.css" />" rel="stylesheet">
<script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/panier.js"></script>
  

</head>
<body>



	<table cellspacing="20">
		<tr>
			<c:forEach var="l" items="${listmed}">

				<td class="d"><img
					src="<c:url value="/resources/img/ajouter-m.jpg"/>" width="100"
					height="100" /><br> <span>${l.nom}</span><br /> <span
					style="color: blue"> ${l.prix}DH </span><br /> 

						<button type="button" class="a">Ajouter</button>
						<input type="hidden" class="idMedica" name="user" value="${l.nom}"/>
				</td>


			</c:forEach>
		</tr>




	</table>


	<a href="<c:url value="/monPanier"/>">

		<button type="button">Panier</button>
	</a>



</body>
</html>