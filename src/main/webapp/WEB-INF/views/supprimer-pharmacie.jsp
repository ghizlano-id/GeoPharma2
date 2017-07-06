<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppression</title>
	<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet">
</head>
<body>
	<header:header />
	
		<div class="col-md-8 col-md-offset-2 ">
			 <table class="table table-success table-hover table-bordered">
			 	<tr bgcolor="#78AB46" style="color:grey;">
	            	<th>Nom</th>
	            	<th>Adresse</th>
	            	<th>Nom du propriétaire</th>
	            	<th></th>
			     </tr>
			    <c:forEach var="pharma" items="${pharmacies}">
					<tr>
					  <td>${pharma.name}</td>
					   <td>${pharma.adresse}</td>
					   <td>${pharma.pharmacien.nom} ${pharma.pharmacien.prenom}</td>
					   <td><span class="glyphicon glyphicon-trash supprimer"></span><a class="supprimer" href="suppression?idPharma=${pharma.idPharma}&CIN=${pharma.pharmacien.CIN}">Supprimer</a></td>
					</tr>
			   </c:forEach>         
			 </table>
		</div>
<!-- 	<table border='1'  cellspacing='0' cellpadding='6' > -->
<!-- 		<tr bgcolor="#eee"> -->
<!-- 		  <td>Nom </td> -->
<!-- 		  <td>Adresse</td> -->
<!-- 		  <td>Nom du propriétaire</td> -->
<!-- 		  <td></td> -->
<!-- 		</tr> -->
<%-- 		<c:forEach var="pharma" items="${pharmacies}"> --%>
<!-- 		<tr> -->
<%-- 		  <td>${pharma.name}</td> --%>
<%-- 		   <td>${pharma.adresse}</td> --%>
<%-- 		   <td>${pharma.pharmacien.nom} ${pharma.pharmacien.prenom}</td> --%>
<%-- 		   <td><a href="suppression?idPharma=${pharma.idPharma}&CIN=${pharma.pharmacien.CIN}">Supprimer</a></td> --%>
<!-- 		</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
	

</body>
</html>