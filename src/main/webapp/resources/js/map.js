$(document).ready(function(){

	$("#abcd").click(function(){
		
		$.ajax({
			type: "GET",
			url: "http://localhost:8080/gestionPharmacie/pharmacies-garde",
			contentType: "application/json",
			dataType: 'json',
			cache: false,  
			success: function(response){
				console.log(response);
//				$('#result').html("");
				
				$('#result').html("First Name:- " + response.cin +"</br>");
			},
			error: function(){      
				alert('Error while request..');
			}
		});
		
	});
});