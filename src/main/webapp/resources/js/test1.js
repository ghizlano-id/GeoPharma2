$(document).ready(function(){
 
	

	
	 var directionsService ;
      var x ; 
      var y ;
	   var directionsDisplay;
	  var map,geocoder ;
	window.initMap = function() {
		

		   
		  directionsService = new google.maps.DirectionsService();
		    directionsDisplay = new google.maps.DirectionsRenderer();
		  /*emplacement par défaut de la carte (j'ai mis Paris)*/
		    var maison = new google.maps.LatLng(31.634494, -8.060885999999982);
		  
		  /*option par défaut de la carte*/
		    var myOptions = {
		      zoom:6,
		      
		      center: maison
		    }
		  /*creation de la map*/
		    map = new google.maps.Map(document.getElementById("divMap"), myOptions);
		  /*connexion de la map + le panneau de l'itinéraire*/
		    directionsDisplay.setMap(map);
		    directionsDisplay.setPanel(document.getElementById("divRoute"));
		  /*intialise le geocoder pour localiser les adresses */
		  geocoder = new google.maps.Geocoder();
		   //x=document.getElementById("x").value ; 
		   
		   //y=document.getElementById("y").value ; 
		   
		 
		   
		  
		
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	$('#chercher').on('click',function()
	  {
		  /*test si les variables sont bien initialisés */
			 var or =31.632103201070812+","+(-8.078209301456809) ; 
		     var dest=31.639630042518906+"," +(-8.076836010441184) ;
		     var a=31.6355319+","+(-8.064115000000015)  ;
		     
	
		     
		    var request = {
//		       origin: rs_final[0][0],
//		       destination: rs_final[0][1] ,
		    		 origin: or,
			       destination: dest,
             //waypoints:waypts,

		        travelMode:'DRIVING'//google.maps.DirectionsTravelMode[choixMode]


		    };
			/*appel à l'API pour tracer l'itinéraire*/
		    directionsService.route(request, function(response, status) {
		      if (status == google.maps.DirectionsStatus.OK) {
		        directionsDisplay.setDirections(response);
		      }
		    });






		  
			
		  });
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	





function min(distances){
	mind=distances[0];
	ind=0;
	for(var iter=0; iter<distances.length; iter++){
		if(distances[iter]<mind){
			mind=distances[iter];
			ind=iter; //probleme !!!!!
		}
	}
	return mind;
}
 function getKey(val, map)
 {
	 
	 for (var [key, value] of map) 
	 {
		 if(value==val)
			 return key ; 
		
		 
	 }
 }
 

});
	