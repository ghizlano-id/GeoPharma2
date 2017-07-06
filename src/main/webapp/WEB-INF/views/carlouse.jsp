<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" >
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style=" width:700px; max-height: 300px !important;">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="resources/img/scooter.jpg"  alt="Los Angeles" style=" width:700px; max-height: 300px !important;">
     	<div class="carousel-caption">
	        <h3>Livraison des médicaments</h3>
	        <p>Thank you, Chicago!</p>
	     </div>
      </div>

      <div class="item">
        <img src="resources/img/roadmap.jpg" alt="Chicago" style=" width:700px; max-height: 300px !important;">
        <div class="carousel-caption">
	        <h3>Paharmacie à proximité</h3>
	        <p>Trouver la pharmacie la plus proche de vous</p>
	     </div>
      </div>
    
      <div class="item">
        <img src="resources/img/acheter.jpg"  alt="New york" style=" width:700px; max-height: 300px !important;">
        <div class="carousel-caption">
	        <h3>Médicaments en ligne</h3>
	        <p>Acheter vos médicaments en ligne </p>
	     </div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>