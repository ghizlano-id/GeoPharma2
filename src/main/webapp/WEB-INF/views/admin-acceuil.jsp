
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags" %>

<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page acceuil</title>
		<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet">
</head>
<body id="pharmacien-body">
	<header:header />
	<section >
		<div class="col-md-3 ">
		 <div class="panel panel-success choix">
			<div class="panel-body ">
			  <a href="<c:url value="/ajout-pharmacien"/>"><img alt="ajouter" src="resources/img/ajouter.png"></a>
			  <span>Ajouter pharmacie</span>
			</div>
		 </div>
		</div>
		<div class="col-md-3 ">
		 <div class="panel panel-success choix">
			<div class="panel-body">
			 <a href="<c:url value="/supprimer-pharmacie"/>"><img alt="supprimer" src="resources/img/supprimer.jpg"></a>
			 <span>Supprimer pharmacie</span>
			</div>
		 </div>
		</div>
	</section>
<!-- 		<div id="div-top"> -->
<!-- 		  <div class="titre">GeoPharma  Espace Administrateur</div> -->
<%-- 		  <div class="titre"><a href="<c:url value="/admin"/>" ><button type="button" value="DECONNEXION" id="dcnx">Déconnexion</button></a></div> --%>
<!-- 	    </div> -->

 
<!-- 	<div id="div-body"> -->
<!-- 	  <div class="ligne2"> -->
<!-- 	  	<div class="choix">  -->
<!-- 		  <div class="icon1"></div> -->
<%-- 		  <a href="<c:url value="/ajout-pharmacien"/>">Ajouter une pharmacie</a> --%>
<!-- 		</div> -->
		
<!-- 		<div class="choix">  -->
<!-- 		  <div class="icon2"></div> -->
<%-- 		  <a href="<c:url value="/supprimer-pharmacie"/>">Supprimer un pharmacie</a> --%>
<!-- 		</div> -->
		
<!-- 		<div class="choix">  -->
<!-- 		  <div class="icon"></div> -->
<!-- 		  <a href="#">XXXXX</a> -->
<!-- 		</div> -->
<!-- 	  </div> -->
	  
<!-- 		<div class="ligne2"> -->
<!-- 		<div class="choix">  -->
<!-- 		  <div class="icon"></div> -->
<!-- 		  <a href="#">XXXXX</a> -->
<!-- 		</div> -->
<!-- 		<div class="choix">  -->
<!-- 		  <div class="icon"></div> -->
<!-- 		  <a href="#">XXXX</a> -->
<!-- 		</div> -->
<!-- 		<div class="choix">  -->
<!-- 		  <div class="icon"></div> -->
<!-- 		  <a href="#">XXXXX</a> -->
<!-- 		</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	   

</body>
</html>