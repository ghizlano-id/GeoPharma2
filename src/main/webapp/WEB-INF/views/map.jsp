<!DOCTYPE html>
<html>
<head>
<style>
/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
		#div-top {
			height: 15%;
			width: 100%;
			background-color: #78AB46;
			font-weight: bolder;
			font-size: 24pt;
			color: White;
		}
		
		#div-center {
			height: 85%;
			width: 100%;
		}
		
	#map {
			height: 508px;
			width: 1068px;
			display: inline-block;
			float:left;
			width:60%; 
			height:80% ; 
			margin-top: 10px ;
			margin-left:40px ;  
		border:1px gray solid;
border-radius:10px;
-webkit-box-shadow:0 0 6px gray inset; 
			
		}
		

		#divRoute{
		   float:right;
		   width:30%;
		   height:73% ; 
		   margin-top: 10px ;
		   overflow-y: auto;
	border:1px gray solid;
border-radius:10px;
-webkit-box-shadow:0 0 6px gray inset;
    margin-right:30px ; 
 
		 
		}

		/* Optional: Makes the sample page fill the window. */
		html, body {
			height: 100%;
			margin: 0;
			padding: 0;
		}
</style>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/pharmacie-garde.js"></script>
</head>
<body>

	
	<div id="div-top">GeoPharma GN</div>
	<div id="div-center">
		<div id="menu">

		</div>
		<div id="map"></div>
		<div id="divRoute"></div>
		<div id="res">	<button id="b">afficher l'itineraire de la pharmacie la plus proche</button></div>
	
		
	</div>
	
	
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>
</body>
</html>