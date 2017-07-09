<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib prefix="headerPharmacien" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/> 
<!--importation de l'API google MAP Version 3-->
  	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>
 <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/test4.js"></script>
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
			margin-left:40px ;  
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
    margin-right:30px ; 
 
		 
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
			#div-client{
		margin-left:60px; 
		margin-bottom: 60px;
		}
				#table-client,.client{
		    border: 2px solid grey;
		     padding: 10px;
		    border-collapse: collapse;
		}
		.client{
			background-color:#f6f6f6;
		}
</style>
</head> 
<body > 
<headerPharmacien:headerPharmacien />
<!-- <div id="div-top">GeoPharma GN</div> -->

   <div id="liv">
      	<input type="button" value="Livraison a 12H" id="b"/>
      	<input type="button" value="Livraison a 18H" id="m"/>
      	
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
	<%@ page  import="com.ensa.gestionPharmacie.entity.Pharmacie"%>
	<%@ page  import="com.ensa.gestionPharmacie.entity.Commande"%>
	<%@ page  import="java.util.List"%>
	

	<% Pharmacie ph =(Pharmacie)request.getSession().getAttribute("ph") ; 
	    String x=Double.toString(ph.getX()) ; 
	    String y=Double.toString(ph.getY()) ; 
	  
	    
	    
	%>
    <input type="hidden" value="<%=x %>" id="x">
    <input type="hidden" value="<%=y %>"  id="y">
    

    
      <div id="div-client">
	   <table id="table-client">
	     <tr>
	     	
	     	<th class="client">Client CIN</th>
	     
	     	<th class="client">Médicaments commandés</th>
	     	<th class="client">Date de la commande</th>
	     </tr>
	  <c:set var="myVar" value="" />
	  <c:set var="myVar2" value="" />
	  <c:set var="virgule" value="," />
	  <c:set var="espace" value="" />
	     <c:forEach items="${listcommande}" var="commande">
		      <tr class="client">
		      
		     	<td class="client"><c:out value="${commande.client.CIN}"/></td>
		 	<c:forEach items="${listAll}" var="list">
		     	
		     	<c:if test="${commande.client.CIN eq list.client.CIN}">
		     	      <c:if test="${myVar ne espace}">            
		     	    <c:set var="myVar" value="${myVar} ${virgule}  ${list.medicament.nom}" />
                      </c:if>
                      
                       <c:if test="${myVar eq espace}">            
		     	    <c:set var="myVar" value="${list.medicament.nom}" />
                      </c:if>
                      
                      
                      
                        <c:if test="${myVar2 ne espace}">            
		     	    <c:set var="myVar2" value="${myVar2} ${virgule}  ${list.dateTime}" />
                      </c:if>
                      
                       <c:if test="${myVar2 eq espace}">            
		     	    <c:set var="myVar2" value="${list.dateTime}" />
                      </c:if>
                      
                      
                  </c:if>
		     	
		     	</c:forEach>
		     	
		     	<td class="client"><c:out value="${myVar}"/></td>
		     	
		     	
		     	<td class="client"><c:out value="${myVar2}"/></td>
		     	
		     	<c:set var="myVar" value="" />
		     	<c:set var="myVar2" value="" />
		     	
		     	
		     </tr>
	     </c:forEach>
	   </table>
	 </div>
      

    
    
</body>
