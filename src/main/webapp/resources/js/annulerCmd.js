$(document).ready(function(){

	//-----------annuler-------------------
	$('.b').on('click',function(){
		var nomM =  $(this).parent().children( ".monM" ).val();
		alert("done!");
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/gestionPharmacie/annuler?nom="+nomM,
			cache: false,
		});
	});
	//-------------get commands----------- (ghizlane) 04/07/2017
	

	/*$( window ).load(function() {
				afficher();
		});
	
	function afficher(){
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/gestionPharmacie/cmd",
			contentType: "application/json",
			dataType: 'json',
			cache: false,
			success: function(response){
				var tab="";
				tab+="<table id=\"mytable\" class=\"table table-bordred table-striped\">";
		        tab+="<thead><th>Médicament</th><th>Prix unitaire</th><th>Confirmer</th><th>Supprimer</th></thead>";
		        for (var i = 0; i < response.length; i++) {
		        	tab+="<tbody><tr><td>"+response[i].nom+"</td>";
		        	tab+="<td>"+response[i].prix+"</td>";
		        	tab+="<td><p data-placement=\"top\" data-toggle=\"tooltip\" title=\"Confirmer\"><button  class=\"btn btn-primary btn-xs \" data-title=\"Edit\" data-toggle=\"modal\" data-target=\"#edit\" ><input type=\"hidden\" value="+response[i].nom+" class=\"monM\" /><span class=\"glyphicon glyphicon-ok\"></span></button></p></td>";
		        	tab+="<td><p data-placement=\"top\" data-toggle=\"tooltip\" title=\"Supprimer\"><button onClick=\"annuler(this)\" class=\"btn btn-danger btn-xs b\" data-title=\"Delete\" data-toggle=\"modal\" data-target=\"#delete\" ><input type=\"hidden\" value="+response[i].nom+" /><span class=\"glyphicon glyphicon-trash\"></span></button></p></td></tr>";
		        	tab+="</tbody>";
		        }
		        tab+="</table>";
    		    $('#panier').html(tab);
				
				},
				error: function(){      
				alert('Error while request..');
			}

			});
	}*/

	//-----------confirmer------------
   var outputDiv = document.getElementById('distance');

	$('.c').on('click',function(){ 
		
		var latClient =$('#lat').val();
		var lngClient =$('#lng').val();
		var idMedica = $(this).parent().children(".monM").val();
		var lato;
		var lngo;
		
		var _this  = $(this);
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/gestionPharmacie/pharmacies-madicament/"+idMedica,
			contentType: "application/json",
			dataType: 'json',
			cache: false,
			success: function(response){
				var origin1 = new google.maps.LatLng(latClient,lngClient);
				var responsesCoord=response;

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
					alert(JSON.stringify(response));
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
								//str=results[j].distance.text.split(" ");
								//str[0]= str[0].replace(",",".");
								str=results[j].distance.text.replace(",",".");
								distances[j]=parseFloat(str);
								outputDiv.innerHTML += 'A to  B: ' + results[j].distance.text + ' in ' +
								results[j].duration.text + ' dist: --->'+distances[j]+'<br>';
							}
							outputDiv.innerHTML +='-------------<br>'
						}
						var indt=min(distances); //
						lato=responsesCoord[indt].x;
						lngo=responsesCoord[indt].y;
						$(_this).parents("tr").children(".dst").children("span").html("<span>"+min(distances)+"  x="+lato+",y="+responsesCoord[indt].y+"</span>");
						$(_this).hide();
						//call function ajax 2
						callAjaxAgain(lato,lngo);
					}
					else{
						alert('Error was:1' + status);
					}
				}
				

			}, 
			error: function(){      
				alert('Error while request..');
			}
		});//*fin call ajax 1
	function callAjaxAgain(lato,lngo){
		console.log(lngo);
		$.ajax({
				type: "POST",
				data: {"lato": lato, "lngo": lngo},
				url: "http://localhost:8080/gestionPharmacie/ajoutPharmacieProche",
				cache: false,
				
/*			success: function(response){
				alert('Save it :)');
			},
			error: function(){      
				alert('Error while request ajax ajoutPharmacieProche ');
		}*/
		});
	}
	
	});
	
	function min(distances){
		mind=distances[0];
		ind=0;
		for(var iter=0; iter<distances.length; iter++){
			if(distances[iter]<mind){
				mind=distances[iter];
				ind=iter;			 //probleme !!!!!
			}
		}
		return ind;
	}

});

