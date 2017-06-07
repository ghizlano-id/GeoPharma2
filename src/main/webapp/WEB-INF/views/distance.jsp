<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
		#map {
        height: 50%;
        width:100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
	</style>

 <script type="text/javascript">
 var map;
	window.initMap = function() {
		// console.log("test1");
		map = new google.maps.Map(document.getElementById('map'), {
			zoom: 15,
			center: new google.maps.LatLng(31.635444,-8.070279),
		});
		var infoWindowo = new google.maps.InfoWindow({map: map});

     // Try HTML5 geolocation.
     if (navigator.geolocation) {
       navigator.geolocation.getCurrentPosition(function(position) {
         var pos = {
           lat: position.coords.latitude,
           lng: position.coords.longitude
         };

         infoWindowo.setPosition(pos);
         infoWindowo.setContent('yes');
         map.setCenter(pos);
       }, function() {
         handleLocationError(true, infoWindowo, map.getCenter());
       });
     } else {
       // Browser doesn't support Geolocation
       handleLocationError(false, infoWindowo, map.getCenter());
     }
     
     ///--------------distance--------------
     var origin1 = new google.maps.LatLng(31.635824815018054, -8.070523906425993);
     var destinationA = new google.maps.LatLng(31.635444, -8.067824599999994);
     var destinationB = new google.maps.LatLng(31.6303272, -8.054875700000025);
     
     var geocoder = new google.maps.Geocoder;
     var service = new google.maps.DistanceMatrixService();
     
     service.getDistanceMatrix(
       {
         origins: [origin1],
         destinations: [destinationA, destinationB],
         travelMode: 'DRIVING',
         unitSystem: google.maps.UnitSystem.METRIC
       }, callback);

  
     function callback(response, status) {
    	 if (status == 'OK') {
    		 var outputDiv = document.getElementById('info');
    		 var output = document.getElementById('test');
    		 var originList = response.originAddresses;
             var destinationList = response.destinationAddresses;
             var res="" ; 
    		 for (var i = 0; i < originList.length; i++) {
                 var results = response.rows[i].elements;
                 for (var j = 0; j < results.length; j++) {
                   outputDiv.innerHTML += 'A to  B: ' + results[j].distance.text + ' in ' +
                       results[j].duration.text + '<br>';
                     
                       
                 
                 }
               }

    		 
    	
    		  }
    	 else{
    		 alert('Error was: ' + status);
    	 }
     }
		
	}
	 function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	        infoWindow.setPosition(pos);
	        infoWindow.setContent(browserHasGeolocation ?
	                              'Error: The Geolocation service failed.' :
	                              'Error: Your browser doesn\'t support geolocation.');
	
 </script>
</head>
<body>
		
		<div id="map"></div>
		<div id="info"></div>
	      <div id="test"></div>
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>

</body>
</html>