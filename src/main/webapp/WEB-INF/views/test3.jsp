<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/> 
<!--importation de l'API google MAP Version 3-->
  	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>
 <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/test1.js"></script>
  <style>
/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
		#div-top {
			height: 15%;
			width: 100%;
			background-color: #78AB46;
			font-weight: bolder;
			font-size: 24pt;
			color: White;
		}
		
		#div-center {
			height: 85%;
			width: 100%;
		}
		
		#divMap {
			height: 508px;
			width: 1068px;
			display: inline-block;
			float:left;
			width:60%; 
			height:80% ; 
			margin-top: 10px ;
			margin-left:10px ;  
		border:1px gray solid;
border-radius:10px;
-webkit-box-shadow:0 0 6px gray inset; 
			
		}
		

		#divRoute{
		   float:right;
		   width:30%;
		   height:73% ; 
		   overflow-y: auto;
	border:1px gray solid;
border-radius:10px;
-webkit-box-shadow:0 0 6px gray inset;
    
 
		 
		}

		#t{
		  width:30%;
		   height:7% ; 
		   float:right ; 
		   text-align:center ; 
		   font-size:30px ; 
		   font-family:sans serif ; 
		   color : blue ; 
		
		}
		

		
	#b{
	
				border:1px gray solid;
border-radius:5px;
-webkit-box-shadow:0 0 6px gray inset;
  width:150px ; 
  height:30px ; 
  font-size:15px ; 
	
	}
			
	#m{
	
				border:1px gray solid;
border-radius:5px;
-webkit-box-shadow:0 0 6px gray inset;
  width:150px ; 
  height:30px ; 
  font-size:15px ; 
	margin-left:100px ; 
	}
	
#liv{
 margin-top:45px ;  
 width:30%; 
  margin-left:350px ; 
 height:70px ; 

}
		/* Optional: Makes the sample page fill the window. */
		html, body {
			height: 100%;
			margin: 0;
			padding: 0;
		}
</style>
</head> 
<body> 
<div id="div-top">GeoPharma GN</div>

   <div id="liv">
      
      	<input type="button" value="affihcer l'itinéraire" id="chercher"/>
      	
      </div>
      

		
</div>
		
	
	<div id="div-center">
	  
		<div id="divMap" ></div> 
		
		 <div id="t">
		  L'itinéraire
		 </div>
		<div id="divRoute"></div> 

		
	</div>
	
	
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>

      
     
    
</body>
</html>