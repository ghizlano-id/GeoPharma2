$(document).ready(function(){

	var map;
	var mapos  ;
	var k ; 
	var t="" ; 

	 var directionsService ;

	   var directionsDisplay;
	var tab =new Array()  ; 
	window.onload = function() {
		// t="" ;  
		init() ;
		};
	
	function init()
	{
		// console.log("test1");
		map = new google.maps.Map(document.getElementById('map'), {
			zoom: 15,
			center: new google.maps.LatLng(31.635444,-8.070279),
		});
		var infoWindowo = new google.maps.InfoWindow({map: map});
		

		  directionsService = new google.maps.DirectionsService();
		    directionsDisplay = new google.maps.DirectionsRenderer();
		
		  /*connexion de la map + le panneau de l'itinéraire*/
		    directionsDisplay.setMap(map);
		    directionsDisplay.setPanel(document.getElementById("divRoute"));
		  /*intialise le geocoder pour localiser les adresses */
		  geocoder = new google.maps.Geocoder();
		

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
             pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
             
             
            mapos = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
 
            infoWindowo.setPosition(pos);
            infoWindowo.setContent('My location');
            map.setCenter(pos);
          }, function() {
            handleLocationError(true, infoWindowo, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindowo, map.getCenter());
        }
		
        // add markers (calling function getData())
		getData();
	}
	
	window.initMap = function() {
		
		init() ; 
	}
	 function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	        infoWindow.setPosition(pos);
	        infoWindow.setContent(browserHasGeolocation ?
	                              'Error: The Geolocation service failed.' :
	                              'Error: Your browser doesn\'t support geolocation.');
	      }
	
	function getData(){

		$.ajax({
			type: "GET",
			url: "http://localhost:8080/gestionPharmacie/pharmacies-garde",
			contentType: "application/json",
			dataType: 'json',
			cache: false,  
			success: function(response){
				//console.log(response);
//				$('#result').html("");
//				$('#result').html("CIN:- " + response.cin +"</br>"+"First Name:- " + response.nom);
			var infoWindow = new google.maps.InfoWindow;
			var infowincontent = new Array();
			var marker = new Array();
			//var tab = new Array()  ; 
			
			
				for (var i = 0; i < response.length; i++) {
					var lat = response[i].x;
					var lng = response[i].y;
					var name =response[i].name;
					var adress=response[i].adresse;
					var latLng = new google.maps.LatLng(lat,lng);
					  tab[i]=latLng ; 
			
					var icon="P";
					//Les info affichées en cliquent sur le mark
					infowincontent[i] = document.createElement('div');
					var strong = document.createElement('strong');
					strong.textContent =name;
					infowincontent[i].appendChild(strong);
					infowincontent[i].appendChild(document.createElement('br'));

					var text = document.createElement('text');
					text.textContent = adress
					infowincontent[i].appendChild(text);

					 marker[i] = new google.maps.Marker({
						position:latLng,
						map: map,
						//label:'P',
						icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
						idMap:i
					});
					 marker[i].addListener('click', function() {
			                infoWindow.setContent(infowincontent[this.idMap]);
			                infoWindow.open(map, this);
			              });
				}
				
				////////////////////////////////////////////////////////////
				
				
				var service = new google.maps.DistanceMatrixService();
				service.getDistanceMatrix({
					origins : [mapos], 
					destinations:tab, 
					travelMode: 'DRIVING',
					unitSystem: google.maps.UnitSystem.METRIC
					//avoidHighways:Boolean, 
					//avoidTolls:Boolean, 
				},callback) ; 
				
				
			

				function callback(response, status) {
					

//					
					 var mapp = new Map() ; 

//						
						var originList = response.originAddresses;
						var destinationList = response.destinationAddresses;
						var distances=new Array();
						//var id;

						for (var i = 0; i < originList.length; i++) {
							var results = response.rows[i].elements;
							for (var j = 0; j<results.length;j++) {
								
							str=results[j].distance.text.split(" ");
								str[0]= str[0].replace(",",".");
								distances[j]=parseFloat(str[0]);
								mapp.set(i*(originList.length)+j,distances[j]) ;
								
								t+="<span>"+mapp.get(i*(originList.length)+j)+"</span><br/>";
								
							}
							 
						}
   
						//document.getElementById("res").innerHTML=t ; 
						
						var tab2 =new Array() ;
						var i=0 ; 
						for (var [key, value] of mapp) 
							{
							
								tab2[i]=parseFloat(value) ;
							   i++ ;
							   
							}
						
						
						
						var m=min(tab2) ;
						
						
						
						 k=getKey(m,mapp) ;
						
						t+="<span>"+m+" ---->"+k+"-----"+mapp.get(k)+" </span><br/>";
						//document.getElementById("res").innerHTML=t ; 
						
						//iti(mapos, tab[k]) ; 
						
						
					
							
							}	
						
				
					
				
				
				
				
				
				///////////////////////////////////////////////////////////////
				
				
				
				
				//document.getElementById("res").innerHTML=t ; 
			
				
				//$(this).parents("div-center").html(t);

			},
			error: function(){      
				alert('Error while request..');
			}
		});

	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	$('#b').on('click',function()
			  {


	    var request = {
	       origin: mapos,
	       destination: tab[k] ,
         

	        travelMode:'DRIVING'//google.maps.DirectionsTravelMode[choixMode]


	    };
		/*appel à l'API pour tracer l'itinéraire*/
	    directionsService.route(request, function(response, status) {
	      if (status == google.maps.DirectionsStatus.OK) {
	        directionsDisplay.setDirections(response);
	      }
	    });





	  

		//iti(mapos, tab[k]) ; 
					
				  });
	
	
	
	function iti(or , dest)
			  {
				  /*test si les variables sont bien initialisés */
				

	
				    var request = {
				       origin: or,
				       destination: dest ,
		             

				        travelMode:'DRIVING'//google.maps.DirectionsTravelMode[choixMode]


				    };
					/*appel à l'API pour tracer l'itinéraire*/
				    directionsService.route(request, function(response, status) {
				      if (status == google.maps.DirectionsStatus.OK) {
				        directionsDisplay.setDirections(response);
				      }
				    });





				  
					
				  }
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////
	
	
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

