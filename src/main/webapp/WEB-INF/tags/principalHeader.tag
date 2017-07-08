<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" /> " rel="stylesheet">
	<link href="<c:url value="/resources/CSS/style.css" /> "  rel="stylesheet">
	
</head>
<body> 
    <header>
		<nav class="navbar navbar-inverse navbar-fixed-top">
		  <div class="container-fluid">
		    <div class="navbar-header" >
		      <a class="navbar-brand logo" href="#">GeoPharma GN</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="<c:url value="/"/>">Home</a></li>
		      <li><a href="<c:url value="/listeMedicaments"/>">Médicaments</a></li>
		      <li class="dropdown">
		        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pharmacies<span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="#">Pharmacies</a></li>
		          <li class="divider"></li>
		          <li><a href="<c:url value="/PharmaciesGarde"/>">Pharmacie de garde</a></li>
		        </ul>
		      </li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="<c:url value="/monPanier2"/>"><span class="glyphicon glyphicon-shopping-cart"></span>  Mon panier</a></li>
		    </ul>
		  </div>
		</nav>
	</header>
</body>
</html>