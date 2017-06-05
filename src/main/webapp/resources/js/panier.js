$(document).ready(function(){
	
	$('.a').on('click',function(){
		var id =  $(this).parent().children( ".idMedica" ).val();
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/gestionPharmacie/ajoutPanier/"+id,
			cache: false,
		});
	});
	
});

