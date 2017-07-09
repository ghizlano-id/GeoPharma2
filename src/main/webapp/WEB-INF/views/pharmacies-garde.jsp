<%@ taglib prefix="principalHeader" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="principalFooter" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Pharmacie de garde</title>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/map.js"></script>
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script src="resources/js/pharmacie-garde.js"></script>	


</head>
<body>
<!-- 	<input type="button" value="Ajax Submit" id="abcd" > -->
<!--   	<div id="result"></div>	 -->
<!--   	<p>hello</p>		  	 -->
		
		<principalHeader:principalHeader/>
			
			<div class="container " style="margin:80px 0;">
			  <div class="col-sm-12">
				<div class="col-sm-8">
					<div id="map" class="map-chercher" style="width:100%;height:500px;"></div>
				</div >
				
				<div class="col-sm-4">
					<button type="button" class="btn  btn-block btn-lg medica" id="b"> Pharmacie à proximité <span class="glyphicon glyphicon-map-marker fa-fw"></span></button>
					<div class="panel panel-default itineraire"  style="margin-top:10px;">
					  <div class="panel-heading">L'itineraire</div>
					  <div class="panel-body" id="divRoute"></div>
					</div>
				</div>
			  </div>
			</div>
			
		<principalFooter:principalFooter/>
	
		<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		</script>
</body>
</html>