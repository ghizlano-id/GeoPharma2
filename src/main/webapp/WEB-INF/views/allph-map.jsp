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
		}
		
		#menu {
			height: 508px;
			width:200px;
			background-color: red;
			display: inline-block;
		}
		/* Optional: Makes the sample page fill the window. */
		html, body {
			height: 100%;
			margin: 0;
			padding: 0;
		}
</style>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/all-ph.js"></script>
</head>
<body>

	
	<div id="div-top">GeoPharma GN</div>
	<div id="div-center">
		<div id="menu"></div>
		<div id="map"></div>
	</div>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>
</body>
</html>