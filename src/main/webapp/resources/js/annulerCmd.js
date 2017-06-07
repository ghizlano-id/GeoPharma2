$(document).ready(function(){

	//-----------annuler-------------------
	$('.b').on('click',function(){
		var nomM =  $(this).parent().children( ".monM" ).val();
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/gestionPharmacie/annuler/nom="+nomM,
			cache: false,
		});
	});
	//-----------confirmer------------
var outputDiv = document.getElementById('distance');

	$('.c').on('click',function(){//?????? a suivre   
		var latClient =$('#lat').val();
		var lngClient =$('#lng').val();
		var idMedica = $(this).parent().children(".monM").val();
		var _this  = $(this);
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/gestionPharmacie/pharmacies-madicament/"+idMedica,
			contentType: "application/json",
			dataType: 'json',
			cache: false,
			success: function(response){
				var origin1 = new google.maps.LatLng(latClient,lngClient);

				//Remplir la tab de destination depuis json
				var destinations = new Array();
				for (var i = 0; i < response.length; i++) {
					var lat = response[i].x;
					var lng = response[i].y;
					var latLng = new google.maps.LatLng(lat,lng);
					destinations[i]=latLng;

				}
				//appel de la methode qui calcul de la distance
				var service = new google.maps.DistanceMatrixService();

				service.getDistanceMatrix(
						{
							origins: [origin1],
							destinations: destinations,
							travelMode: 'DRIVING',
							unitSystem: google.maps.UnitSystem.METRIC
						}, callback);

				function callback(response, status) {
					if (status == 'OK') {
//						var outputDiv = document.getElementById('distance');
						var originList = response.originAddresses;
						var destinationList = response.destinationAddresses;
						var distances=new Array();
						var id;

						for (var i = 0; i < originList.length; i++) {
							var results = response.rows[i].elements;
							for (var j = 0; j<results.length;j++) {
								id="medi";
								str=results[j].distance.text.split(" ");
								str[0]= str[0].replace(",",".");
								distances[j]=parseFloat(str[0]);
								outputDiv.innerHTML += 'A to  B: ' + results[j].distance.text + ' in ' +
								results[j].duration.text + ' dist: --->'+distances[j]+'<br>';
							}
						}
						
						$(_this).parents("tr").children(".dst").children("span").html("<span>"+min(distances)+"</span>");
					}
					else{
						alert('Error was: ' + status);
					}
				}


			},
			error: function(){      
				alert('Error while request..');
			}
		});
	});
	
	function min(distances){
		mind=distances[0];
		ind=0;
		for(var iter=0; iter<distances.length; iter++){
			if(distances[iter]<mind){
				mind=distances[iter];
				ind=iter; //probleme !!!!!
			}
		}
		return ind+" "+mind;
	}

});
