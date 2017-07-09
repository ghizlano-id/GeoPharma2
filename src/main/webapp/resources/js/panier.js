$(document).ready(function(){
	
	//-------------ajouter au panier----------------
	$('.a').on('click',function(){
		
		var id =  $(this).parent().children( ".idMedica" ).val();
//		$(this).hide();
		alert("le médicament "+id+" a été ajouté au panier");
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/gestionPharmacie/ajoutPanier/"+id,
			cache: false,
		});
		
	});
	
	
	
	
	
});

