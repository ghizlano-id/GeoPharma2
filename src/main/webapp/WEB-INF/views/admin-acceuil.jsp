<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page acceuil</title>
		<link href="<c:url value="/resources/CSS/admin-acceuil.css" />" rel="stylesheet">
</head>
<body>
		<div id="div-top">
		  <div class="titre">GeoPharma  Espace Administrateur</div>
		  <div class="titre"><a href="<c:url value="/admin"/>" ><button type="button" value="DECONNEXION" id="dcnx">Déconnexion</button></a></div>
	    </div>

 
	<div id="div-body">
	  <div class="ligne2">
	  	<div class="choix"> 
		  <div class="icon1"></div>
		  <a href="<c:url value="/ajout-pharmacien"/>">Ajouter une pharmacie</a>
		</div>
		
		<div class="choix"> 
		  <div class="icon2"></div>
		  <a href="<c:url value="/supprimer-pharmacie"/>">Supprimer un pharmacie</a>
		</div>
		
		<div class="choix"> 
		  <div class="icon"></div>
		  <a href="#">XXXXX</a>
		</div>
	  </div>
	  
		<div class="ligne2">
		<div class="choix"> 
		  <div class="icon"></div>
		  <a href="#">XXXXX</a>
		</div>
		<div class="choix"> 
		  <div class="icon"></div>
		  <a href="#">XXXX</a>
		</div>
		<div class="choix"> 
		  <div class="icon"></div>
		  <a href="#">XXXXX</a>
		</div>
		</div>
	</div>
	   

</body>
</html>