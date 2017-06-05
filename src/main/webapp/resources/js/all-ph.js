$(document).ready(function(){

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
            infoWindowo.setContent('hi');
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
	 function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	        infoWindow.setPosition(pos);
	        infoWindow.setContent(browserHasGeolocation ?
	                              'Error: The Geolocation service failed.' :
	                              'Error: Your browser doesn\'t support geolocation.');
	      }
	
	function getData(){

		$.ajax({
			type: "GET",
			url: "http://localhost:8080/gestionPharmacie/pharmacies-all",
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
			
				for (var i = 0; i < response.length; i++) {
					var lat = response[i].x;
					var lng = response[i].y;
					var name =response[i].name;
					var adress=response[i].adresse;
					var latLng = new google.maps.LatLng(lat,lng);
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

			},
			error: function(){      
				alert('Error while request..');
			}
		});

	}
});

