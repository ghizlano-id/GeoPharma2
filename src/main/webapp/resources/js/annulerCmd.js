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
	$('.b').on('click',function(){//?????? a suivre   
	var latClient =$('#lat').val();
	var lngClient =$('#lng').val();
	var idMedica = $(this).parent().children( ".monM" ).val();
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/gestionPharmacie/findPharmacies/"+idMedica,
			cache: false,
		});
	});

});

