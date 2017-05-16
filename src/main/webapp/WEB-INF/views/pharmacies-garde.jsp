<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pharmacie de garde</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
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
</head>
<body>
	<input type="button" value="Ajax Submit" onclick="madeAjaxCall();">
	<div id="result"></div>
	<p>hello</p>

</body>
</html>