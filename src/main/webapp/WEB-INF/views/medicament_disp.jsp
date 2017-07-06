<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		
		#map {
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
		
		#menu {
			height: 508px;
			width:200px;
			background-color: red;
			display: inline-block;
			
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
		#f{
		 width:100%  ; 
		 height:100px ; 
		
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
		
		#op{
		
			border:1px gray solid;
border-radius:5px;
-webkit-box-shadow:0 0 6px gray inset;
  width:100px ; 
  height:30px ; 
  font-size:15px ; 
		
		}
		
	#b{
	
				border:1px gray solid;
border-radius:5px;
-webkit-box-shadow:0 0 6px gray inset;
  width:100px ; 
  height:30px ; 
  font-size:15px ; 
	
	}
	
 #afficher{
	
				border:1px gray solid;
                border-radius:5px;
               -webkit-box-shadow:0 0 6px gray inset;
               width:140px ; 
                 height:30px ; 
                    font-size:15px ; 
	
	}		
		.champ{
		
		 font-size:25px ; 
		 font-color : #001f3f  ;
		
		}
		/* Optional: Makes the sample page fill the window. */
		html, body {
			height: 100%;
			margin: 0;
			padding: 0;
		}
</style>
<title>Insert title here</title>
</head>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/med_disp.js"></script>
<body>

	<div id="div-top">GeoPharma GN</div>
	<div id="f">
		<form action="" > 
  <table cellpadding="15px">
  	<tr>
  		<td class="champ">Nom de Médicament</td>

      <td>
  
   <select id="op">
   <c:forEach items="${listmed}" var="v">
   <option >${v}</option>
</c:forEach>
    
    </select>
      	
      </td>
       <td>
      	<input type="button" value="chercher" id="b"/>
      
      </td>
       <td>
      	<input type="button" value="afficher l'itinéraire" id="afficher"/>
      
      </td>
  	</tr>




  </table>	


</form>
		
</div>
		
	
	<div id="div-center">
	  
		<div id="map" ></div> 
		
		 <div id="t">
		  L'itinéraire
		 </div>
		<div id="divRoute"></div> 

		
	</div>
	
	
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>
	<div id="res"></div>
</body>
</html>