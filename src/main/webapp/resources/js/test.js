$(document).ready(function(){
 
	

	
	 var directionsService ;

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
		
		
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	$('#chercher').on('click',function()
	  {
		  /*test si les variables sont bien initialisés */
			 var or =31.6319717+","+(-8.05328970000005) ; 
		     var dest=31.6348423+"," +(-8.05794370000001) ;
		     var a=31.6355319+","+(-8.064115000000015)  ;
		     
		 	var waypts = [];

		 	for (var i = 1; i < rs_final.length; i++) {
		 	  waypts.push({
		 	     location:new google.maps.LatLng(rs_final[i][0], rs_final[i][1]),
		 	     stopover:true
		 	  });}
		     
		    var request = {
		       origin: rs_final[0][0],
		       destination: rs_final[0][1] ,
             waypoints:waypts,

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
	
	

	
	var outputDiv = document.getElementById('s');
$('#b').on('click',function(){ 

	
	
		var _this  = $(this);
		$.ajax({
			type: "GET",
			url:"http://localhost:8080/gestionPharmacie/pharmacies-garde",
			contentType: "application/json",
			dataType: 'json',
			cache: false,
			success: function(response){
				
				
				 var result =new Array() ;
				//Remplir la tab de destination depuis json
				var destinations = new Array();
				for (var i = 0; i < response.length; i++) {
					var lat = response[i].x;
					var lng = response[i].y;
					var latLng = new google.maps.LatLng(lat,lng);
					destinations[i]=latLng;
					

				}
				// le nombre de client n-1
				 var n =destinations.length ;
				//appel de la methode qui calcul de la distance
				var service = new google.maps.DistanceMatrixService();

				service.getDistanceMatrix(
						{
							origins: destinations,
							destinations: destinations,
							travelMode: 'DRIVING',
							unitSystem: google.maps.UnitSystem.METRIC
						}, callback);

				function callback(response, status) {
					if (status == 'OK') {
						
						
						
						 var coord = new Array() ; 

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
								coord[i*(originList.length)+j]=distances[j] ;
							
							}
						}
						
						 /* var res="" ; 
						for(var i=0 ; i<coord.length;i++)
							 res+="<span>"+coord[i]+"</span><br/>";
						$(_this).parents("div").html(res);
						*/
					
						
						
							var map = new Map();		
						for(var i=0 ; i<destinations.length;i++)
					{
							 for(var j=0 ; j<destinations.length;j++)
								 if(i!=j)
									 {
								var s=i+"-"+j;
								map.set(s,coord[i*(originList.length)+j]) ; 
									 
									 
									 }
							
					}
						
						
							//$(_this).parents("div").html(res);	
						
						
						
					var tab =new Array() ;
					var i=0 ; 
					for (var [key, value] of map) 
						{
						
						if(i==n-1)
						break ; 
						else
						{	
							tab[i]=parseFloat(value) ;
						   i++ ;
						   
						}
						
						}
						var m=min(tab) ;
						
						
						var temp="" ;
						result[0]=getKey(m,map) ;
						
							
						i=0
						for (var [key, value] of map) 
						{
							if(i<n-1)
							{	map.delete(key) ;
							   i++ ;
							}
						}
						
						res=""; 
						for (var [key, value] of map) 
							res+="<span>"+key+"->"+value+"</span><br/>";
						res+="<span> la valeur de "+m+"  est  "+result[0]+"</span><br/>" ; 
						//$(_this).parents("div").html(res);
						
			var first=result[0].split("-")[0] ; 
			var f=first ; 
			var last =result[0].split("-")[1] ; 
			i=1 ; 
			var c=0 ; 
			var k=result[0] ; 
			var last2="" ; 
			var first2="" ; 
			var a="" ; 
			var b="" ; 
			while(result.length<n)	
			{		
				var min2=1000000000  ;
				
					
				
				
				
				for(var [key, value] of map) 
					{
					c=0 ; 
			     last2=key.split("-")[1] ; 
                 first2=key.split("-")[0] ;
                for(var j=0 ; j<result.length ; j++)
                {	
               var temp1=result[j].split("-")[0] ;
                var temp2=result[j].split("-")[1] ;
                if(temp1==last2)
                c++  ;
                if(temp2==last2)
                c++  ;
                
                
                }
                
				if(first2.localeCompare(last)==0  && first.localeCompare(last2)!=0  && f.localeCompare(last2)!=0 && c<2)
					{
					if(value<=min2)
						{min2=value ;
				 	   k=key ; 
				 	   a=first2 ; 
				 	   b=last2 ; 
						}
					}
				if(first2.localeCompare(last)==0  && f.localeCompare(last2)==0 && result.length==n-1)
				
				{
					min2=value ; 
				    k=key ;
				    a=first2 ; 
				 	   b=last2 ;
				    
				}		
					}	
					
				
			result[i]=k ;
			 i++ ; 
			
			first=a ; 
			 last =b ; 
						
			}	
				
				for(var t=0 ; t<result.length;t++)
					res+="<span>"+result[t]+" "+"</span>";  
				//$(_this).parents("div").html(res);	
				
			// stocker les adresses suivants le plus cours chemins
				
				var fin = new Array()  ; 
				
				fin[0]= destinations[parseInt(result[0].split("-")[0])]; 
				fin[1]= destinations[parseInt(result[0].split("-")[1])]; 
				
				for(var j=1 ; j<result.length ; j++ )
					fin[j+1]=destinations[parseInt(result[j].split("-")[1])] ; 
				 
				
				res+="<br/>" ;
				for(var t=0 ; t<fin.length;t++)
					 
					res+="<span>"+fin[t]+" "+"</span><br/>";

			
				//$(_this).parents("div").html(res);
				
				
				
				
     ////////////////////////////////////////////////////////////////////////////////////////				
				
				
				  /*test si les variables sont bien initialisés */
				 var or =31.6319717+","+(-8.05328970000005) ; 
			     var dest=31.6348423+"," +(-8.05794370000001) ;
			     var a=31.6355319+","+(-8.064115000000015)  ;
			     
			 	var waypts = [];

			 	for (var i = 1; i < fin.length-1; i++) {
			 	  waypts.push({
			 	     location:fin[i],
			 	     stopover:true
			 	  });}
			     
			    var request = {
			       origin: fin[0],
			       destination: fin[0] ,
	             waypoints:waypts,

			        travelMode:'WALKING'//google.maps.DirectionsTravelMode[choixMode]


			    };
				/*appel à l'API pour tracer l'itinéraire*/
			    directionsService.route(request, function(response, status) {
			      if (status == google.maps.DirectionsStatus.OK) {
			        directionsDisplay.setDirections(response);
			      }
			    });

	///////////////////////////////////////////////////////////////////////////////////////////			
				
				
				
				  
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
	