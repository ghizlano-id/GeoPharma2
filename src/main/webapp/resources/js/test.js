$(document).ready(function(){
 
$('#b').on('click',function(){ 

	
	
		var _this  = $(this);
		$.ajax({
			type: "GET",
			url:"http://localhost:8080/gestionPharmacie/pharmacies-garde",
			contentType: "application/json",
			dataType: 'json',
			cache: false,
			success: function(response){
				
				
				 var result =new array() ;
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
						 var coord = new array() ; 

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
								coord[i*(originList.length)+j]=distance[j] ;
							
							}
						}
						/*for(var i=0 ; i<coord.length;i++)
						$(_this).parents("div").html("<span>"+coord[i]+"</span>");*/
						
						$(_this).parents("div").children("span").html("<span>heeey</span>");	
						
						
						var map = new Map();		
						for(var i=0 ; i<coord.length;i++)
					{
							 for(var j=0 ; j<coord.length;j++)
								 if(i!=j)
									 {
								var s=i+"-"+j;
								map.set(s,coord[i*(originList.length)+j]) ; 
									 
									 
									 }
							
					}
						/*for (var [key, value] of map) 
							$(_this).parents("div").html("<span>"+key+"->"+value+"</span>");	*/
						
						
						
				/*		var tab =new array() ;
					var i=0 ; 
					for (var [key, value] of map) 
						{
						
						if(i==n-1)
						break ; 
						else
						{	tab[i]=value ;
						i++ ; }
						}
						var m=min(tab) ;
						result[0]=getKey(m,map) ; 
						
			var s=result.split("-") ; 
			var first=s[0] ; 
			var f=first ; 
			var last =s[1] ; 
			i=0 ; 
			
			while(result.length<n)	
			{		
				var min2=1000000000  ;
				var k ; 
				i++;	
				c=0 ; 
				for(var [key, value] of map) 
					{
				
			    var last2=key.split("-")[1] ; 
                var first2=key.split("-")[0] ;
                for(var j=0 ; j<result.length ; j++)
                {
                if(result[j].split("-")[0]==last2)
                c++  ;
                if(result[j].split("-")[1]==last2)
                c++  ;
                }
                
				if(firs2==last && first!=last2 && f!=last2 && c<2)
					{
					if(value<min2)
						{min2=value ;
				 	   k=key ; 
						}
					}
				if(fisrt2==last && f==last2)
				if(result.length==n-1)
				{
					min2=value ; 
				    k=key ;
				    
				}		
					}	
						
			result[i]=k ;
			
			
			var first=first2 ; 
			var last =last2 ; 
						
			}	
				*/		
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
		 if(val==value)
			 return key ; 
		
		 
	 }
 }
 

});
	