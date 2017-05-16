<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pharmacie de garde</title>
	<script type="text/javascript">
		function madeAjaxCall(){
		 $.ajax({
		  type: "post",
		  url: "http://localhost:8080/gestionPharmacie/pharmacies-garde",
		  cache: false,    
		  success: function(response){
		   $('#result').html("");
		   var obj = JSON.parse(response);
		   $('#result').html("First Name:- " + obj.CIN +"</br>");
		  },
		  error: function(){      
		   alert('Error while request..');
		  }
		 });
		
		}
    </script>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Pharmacie de garde</title>
	
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript"  src="resources/js/map.js"></script>


</head>
<body>
	<input type="button" value="Ajax Submit" id="abcd" >
	<div id="result"></div>
	

</body>
</html>